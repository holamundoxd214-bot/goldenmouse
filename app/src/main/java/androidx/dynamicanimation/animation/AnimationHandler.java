package androidx.dynamicanimation.animation;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer$FrameCallback;
import android.view.Choreographer;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

class AnimationHandler {
    class AnimationCallbackDispatcher {
        AnimationCallbackDispatcher(AnimationHandler arg1) {
            AnimationHandler.this = arg1;
            super();
        }

        void dispatchAnimationFrame() {
            AnimationHandler.this.mCurrentFrameTime = SystemClock.uptimeMillis();
            AnimationHandler.this.doAnimationFrame(AnimationHandler.this.mCurrentFrameTime);
            if(AnimationHandler.this.mAnimationCallbacks.size() > 0) {
                AnimationHandler.this.getProvider().postFrameCallback();
            }
        }
    }

    interface AnimationFrameCallback {
        boolean doAnimationFrame(long arg1);
    }

    abstract class AnimationFrameCallbackProvider {
        final AnimationCallbackDispatcher mDispatcher;

        AnimationFrameCallbackProvider(AnimationCallbackDispatcher arg1) {
            super();
            this.mDispatcher = arg1;
        }

        abstract void postFrameCallback();
    }

    class FrameCallbackProvider14 extends AnimationFrameCallbackProvider {
        private final Handler mHandler;
        long mLastFrameTime;
        private final Runnable mRunnable;

        FrameCallbackProvider14(AnimationCallbackDispatcher arg3) {
            super(arg3);
            this.mLastFrameTime = -1;
            this.mRunnable = new Runnable() {
                public void run() {
                    FrameCallbackProvider14.this.mLastFrameTime = SystemClock.uptimeMillis();
                    FrameCallbackProvider14.this.mDispatcher.dispatchAnimationFrame();
                }
            };
            this.mHandler = new Handler(Looper.myLooper());
        }

        void postFrameCallback() {
            this.mHandler.postDelayed(this.mRunnable, Math.max(10 - (SystemClock.uptimeMillis() - this.mLastFrameTime), 0));
        }
    }

    class FrameCallbackProvider16 extends AnimationFrameCallbackProvider {
        private final Choreographer mChoreographer;
        private final Choreographer$FrameCallback mChoreographerCallback;

        FrameCallbackProvider16(AnimationCallbackDispatcher arg1) {
            super(arg1);
            this.mChoreographer = Choreographer.getInstance();
            this.mChoreographerCallback = new Choreographer$FrameCallback() {
                public void doFrame(long arg1) {
                    FrameCallbackProvider16.this.mDispatcher.dispatchAnimationFrame();
                }
            };
        }

        void postFrameCallback() {
            this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
        }
    }

    private static final long FRAME_DELAY_MS = 10;
    final ArrayList mAnimationCallbacks;
    private final AnimationCallbackDispatcher mCallbackDispatcher;
    long mCurrentFrameTime;
    private final SimpleArrayMap mDelayedCallbackStartTime;
    private boolean mListDirty;
    private AnimationFrameCallbackProvider mProvider;
    public static final ThreadLocal sAnimatorHandler;

    static {
        AnimationHandler.sAnimatorHandler = new ThreadLocal();
    }

    AnimationHandler() {
        super();
        this.mDelayedCallbackStartTime = new SimpleArrayMap();
        this.mAnimationCallbacks = new ArrayList();
        this.mCallbackDispatcher = new AnimationCallbackDispatcher(this);
        this.mCurrentFrameTime = 0;
        this.mListDirty = false;
    }

    public void addAnimationFrameCallback(AnimationFrameCallback arg3, long arg4) {
        if(this.mAnimationCallbacks.size() == 0) {
            this.getProvider().postFrameCallback();
        }

        if(!this.mAnimationCallbacks.contains(arg3)) {
            this.mAnimationCallbacks.add(arg3);
        }

        if(arg4 > 0) {
            this.mDelayedCallbackStartTime.put(arg3, Long.valueOf(SystemClock.uptimeMillis() + arg4));
        }
    }

    private void cleanUpList() {
        if(this.mListDirty) {
            int v0;
            for(v0 = this.mAnimationCallbacks.size() - 1; v0 >= 0; --v0) {
                if(this.mAnimationCallbacks.get(v0) == null) {
                    this.mAnimationCallbacks.remove(v0);
                }
            }

            this.mListDirty = false;
        }
    }

    void doAnimationFrame(long arg6) {
        long v0 = SystemClock.uptimeMillis();
        int v2;
        for(v2 = 0; v2 < this.mAnimationCallbacks.size(); ++v2) {
            Object v3 = this.mAnimationCallbacks.get(v2);
            if(v3 == null) {
            }
            else if(this.isCallbackDue(((AnimationFrameCallback)v3), v0)) {
                ((AnimationFrameCallback)v3).doAnimationFrame(arg6);
            }
        }

        this.cleanUpList();
    }

    public static long getFrameTime() {
        ThreadLocal v0 = AnimationHandler.sAnimatorHandler;
        if(v0.get() == null) {
            return 0;
        }

        return v0.get().mCurrentFrameTime;
    }

    public static AnimationHandler getInstance() {
        ThreadLocal v0 = AnimationHandler.sAnimatorHandler;
        if(v0.get() == null) {
            v0.set(new AnimationHandler());
        }

        return v0.get();
    }

    AnimationFrameCallbackProvider getProvider() {
        if(this.mProvider == null) {
            this.mProvider = new FrameCallbackProvider16(this.mCallbackDispatcher);
        }

        return this.mProvider;
    }

    private boolean isCallbackDue(AnimationFrameCallback arg5, long arg6) {
        Object v0 = this.mDelayedCallbackStartTime.get(arg5);
        if(v0 == null) {
            return 1;
        }

        if(((Long)v0).longValue() < arg6) {
            this.mDelayedCallbackStartTime.remove(arg5);
            return 1;
        }

        return 0;
    }

    public void removeCallback(AnimationFrameCallback arg3) {
        this.mDelayedCallbackStartTime.remove(arg3);
        int v3 = this.mAnimationCallbacks.indexOf(arg3);
        if(v3 >= 0) {
            this.mAnimationCallbacks.set(v3, null);
            this.mListDirty = true;
        }
    }

    public void setProvider(AnimationFrameCallbackProvider arg1) {
        this.mProvider = arg1;
    }
}

