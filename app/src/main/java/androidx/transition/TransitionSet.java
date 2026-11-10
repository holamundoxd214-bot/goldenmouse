package androidx.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class TransitionSet extends Transition {
    class TransitionSetListener extends TransitionListenerAdapter {
        TransitionSet mTransitionSet;

        TransitionSetListener(TransitionSet arg1) {
            super();
            this.mTransitionSet = arg1;
        }

        public void onTransitionEnd(Transition arg3) {
            --this.mTransitionSet.mCurrentListeners;
            if(this.mTransitionSet.mCurrentListeners == 0) {
                this.mTransitionSet.mStarted = false;
                this.mTransitionSet.end();
            }

            arg3.removeListener(((TransitionListener)this));
        }

        public void onTransitionStart(Transition arg1) {
            if(!this.mTransitionSet.mStarted) {
                this.mTransitionSet.start();
                this.mTransitionSet.mStarted = true;
            }
        }
    }

    private static final int FLAG_CHANGE_EPICENTER = 8;
    private static final int FLAG_CHANGE_INTERPOLATOR = 1;
    private static final int FLAG_CHANGE_PATH_MOTION = 4;
    private static final int FLAG_CHANGE_PROPAGATION = 2;
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER;
    private int mChangeFlags;
    int mCurrentListeners;
    private boolean mPlayTogether;
    boolean mStarted;
    ArrayList mTransitions;
    private Transition[] mTransitionsCache;

    public TransitionSet() {
        super();
        this.mTransitions = new ArrayList();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
    }

    public TransitionSet(Context arg3, AttributeSet arg4) {
        super(arg3, arg4);
        this.mTransitions = new ArrayList();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
        TypedArray v3 = arg3.obtainStyledAttributes(arg4, Styleable.TRANSITION_SET);
        this.setOrdering(TypedArrayUtils.getNamedInt(v3, ((XmlPullParser)arg4), "transitionOrdering", 0, 0));
        v3.recycle();
    }

    public Transition addListener(TransitionListener arg1) {
        return this.addListener(arg1);
    }

    public TransitionSet addListener(TransitionListener arg1) {
        return super.addListener(arg1);
    }

    public Transition addTarget(int arg1) {
        return this.addTarget(arg1);
    }

    public TransitionSet addTarget(int arg3) {
        int v0;
        for(v0 = 0; v0 < this.mTransitions.size(); ++v0) {
            this.mTransitions.get(v0).addTarget(arg3);
        }

        return super.addTarget(arg3);
    }

    public Transition addTarget(View arg1) {
        return this.addTarget(arg1);
    }

    public TransitionSet addTarget(View arg3) {
        int v0;
        for(v0 = 0; v0 < this.mTransitions.size(); ++v0) {
            this.mTransitions.get(v0).addTarget(arg3);
        }

        return super.addTarget(arg3);
    }

    public Transition addTarget(Class arg1) {
        return this.addTarget(arg1);
    }

    public TransitionSet addTarget(Class arg3) {
        int v0;
        for(v0 = 0; v0 < this.mTransitions.size(); ++v0) {
            this.mTransitions.get(v0).addTarget(arg3);
        }

        return super.addTarget(arg3);
    }

    public Transition addTarget(String arg1) {
        return this.addTarget(arg1);
    }

    public TransitionSet addTarget(String arg3) {
        int v0;
        for(v0 = 0; v0 < this.mTransitions.size(); ++v0) {
            this.mTransitions.get(v0).addTarget(arg3);
        }

        return super.addTarget(arg3);
    }

    public TransitionSet addTransition(Transition arg5) {
        this.addTransitionInternal(arg5);
        if(this.mDuration >= 0) {
            arg5.setDuration(this.mDuration);
        }

        if((this.mChangeFlags & 1) != 0) {
            arg5.setInterpolator(this.getInterpolator());
        }

        if((this.mChangeFlags & 2) != 0) {
            arg5.setPropagation(this.getPropagation());
        }

        if((this.mChangeFlags & 4) != 0) {
            arg5.setPathMotion(this.getPathMotion());
        }

        if((this.mChangeFlags & 8) != 0) {
            arg5.setEpicenterCallback(this.getEpicenterCallback());
        }

        return this;
    }

    private void addTransitionInternal(Transition arg2) {
        this.mTransitions.add(arg2);
        arg2.mParent = this;
    }

    protected void cancel() {
        super.cancel();
        Transition[] v0 = this.transitionsAsArray();
        int v1 = this.mTransitions.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0[v2].cancel();
        }

        this.returnTransitionArrayToCache(v0);
    }

    public void captureEndValues(TransitionValues arg3) {
        if(this.isValidTarget(arg3.view)) {
            Iterator v2 = this.mTransitions.iterator();
            while(v2.hasNext()) {
                Object v0 = v2.next();
                if(!((Transition)v0).isValidTarget(arg3.view)) {
                    continue;
                }

                ((Transition)v0).captureEndValues(arg3);
                arg3.mTargetedTransitions.add(v0);
            }
        }
    }

    void capturePropagationValues(TransitionValues arg4) {
        super.capturePropagationValues(arg4);
        int v0 = this.mTransitions.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.mTransitions.get(v1).capturePropagationValues(arg4);
        }
    }

    public void captureStartValues(TransitionValues arg3) {
        if(this.isValidTarget(arg3.view)) {
            Iterator v2 = this.mTransitions.iterator();
            while(v2.hasNext()) {
                Object v0 = v2.next();
                if(!((Transition)v0).isValidTarget(arg3.view)) {
                    continue;
                }

                ((Transition)v0).captureStartValues(arg3);
                arg3.mTargetedTransitions.add(v0);
            }
        }
    }

    public Transition clone() {
        Transition v0 = super.clone();
        ((TransitionSet)v0).mTransitions = new ArrayList();
        int v1 = this.mTransitions.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            ((TransitionSet)v0).addTransitionInternal(this.mTransitions.get(v2).clone());
        }

        return v0;
    }

    public Object clone() throws CloneNotSupportedException {
        return this.clone();
    }

    void createAnimators(ViewGroup arg12, TransitionValuesMaps arg13, TransitionValuesMaps arg14, ArrayList arg15, ArrayList arg16) {
        long v0 = this.getStartDelay();
        int v2 = this.mTransitions.size();
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            Object v5 = this.mTransitions.get(v3);
            long v6 = 0;
            if(v0 > v6 && ((this.mPlayTogether) || v3 == 0)) {
                long v8 = ((Transition)v5).getStartDelay();
                if(v8 > v6) {
                    ((Transition)v5).setStartDelay(v8 + v0);
                    goto label_19;
                }

                ((Transition)v5).setStartDelay(v0);
            }

        label_19:
            ((Transition)v5).createAnimators(arg12, arg13, arg14, arg15, arg16);
        }
    }

    public Transition excludeTarget(int arg3, boolean arg4) {
        int v0;
        for(v0 = 0; v0 < this.mTransitions.size(); ++v0) {
            this.mTransitions.get(v0).excludeTarget(arg3, arg4);
        }

        return super.excludeTarget(arg3, arg4);
    }

    public Transition excludeTarget(View arg3, boolean arg4) {
        int v0;
        for(v0 = 0; v0 < this.mTransitions.size(); ++v0) {
            this.mTransitions.get(v0).excludeTarget(arg3, arg4);
        }

        return super.excludeTarget(arg3, arg4);
    }

    public Transition excludeTarget(Class arg3, boolean arg4) {
        int v0;
        for(v0 = 0; v0 < this.mTransitions.size(); ++v0) {
            this.mTransitions.get(v0).excludeTarget(arg3, arg4);
        }

        return super.excludeTarget(arg3, arg4);
    }

    public Transition excludeTarget(String arg3, boolean arg4) {
        int v0;
        for(v0 = 0; v0 < this.mTransitions.size(); ++v0) {
            this.mTransitions.get(v0).excludeTarget(arg3, arg4);
        }

        return super.excludeTarget(arg3, arg4);
    }

    void forceToEnd(ViewGroup arg5) {
        super.forceToEnd(arg5);
        Transition[] v0 = this.transitionsAsArray();
        int v1 = this.mTransitions.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0[v2].forceToEnd(arg5);
        }

        this.returnTransitionArrayToCache(v0);
    }

    public int getOrdering() {
        return this.mPlayTogether ^ 1;
    }

    public Transition getTransitionAt(int arg2) {
        if(arg2 >= 0) {
            if(arg2 >= this.mTransitions.size()) {
            }
            else {
                return this.mTransitions.get(arg2);
            }
        }

        return null;
    }

    public int getTransitionCount() {
        return this.mTransitions.size();
    }

    boolean hasAnimators() {
        int v1;
        for(v1 = 0; v1 < this.mTransitions.size(); ++v1) {
            if(this.mTransitions.get(v1).hasAnimators()) {
                return 1;
            }
        }

        return 0;
    }

    private int indexOfTransition(long arg5) {
        ArrayList v3;
        int v1;
        for(v1 = 1; true; ++v1) {
            int v2 = this.mTransitions.size();
            v3 = this.mTransitions;
            if(v1 >= v2) {
                break;
            }

            if(v3.get(v1).mSeekOffsetInParent > arg5) {
                return v1 - 1;
            }
        }

        return v3.size() - 1;
    }

    public boolean isSeekingSupported() {
        int v0 = this.mTransitions.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(!this.mTransitions.get(v2).isSeekingSupported()) {
                return 0;
            }
        }

        return 1;
    }

    public void pause(View arg4) {
        super.pause(arg4);
        int v0 = this.mTransitions.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.mTransitions.get(v1).pause(arg4);
        }
    }

    void prepareAnimatorsForSeeking() {
        this.mTotalDuration = 0;
        androidx.transition.TransitionSet$2 v0 = new TransitionListenerAdapter() {
            public void onTransitionCancel(Transition arg3) {
                TransitionSet.this.mTransitions.remove(arg3);
                if(!TransitionSet.this.hasAnimators()) {
                    TransitionSet.this.notifyListeners(TransitionNotification.ON_CANCEL, false);
                    TransitionSet.this.mEnded = true;
                    TransitionSet.this.notifyListeners(TransitionNotification.ON_END, false);
                }
            }
        };
        int v1;
        for(v1 = 0; v1 < this.mTransitions.size(); ++v1) {
            Object v2 = this.mTransitions.get(v1);
            ((Transition)v2).addListener(((TransitionListener)v0));
            ((Transition)v2).prepareAnimatorsForSeeking();
            long v3 = ((Transition)v2).getTotalDurationMillis();
            if(this.mPlayTogether) {
                this.mTotalDuration = Math.max(this.mTotalDuration, v3);
            }
            else {
                ((Transition)v2).mSeekOffsetInParent = this.mTotalDuration;
                this.mTotalDuration += v3;
            }
        }
    }

    public Transition removeListener(TransitionListener arg1) {
        return this.removeListener(arg1);
    }

    public TransitionSet removeListener(TransitionListener arg1) {
        return super.removeListener(arg1);
    }

    public Transition removeTarget(int arg1) {
        return this.removeTarget(arg1);
    }

    public TransitionSet removeTarget(int arg3) {
        int v0;
        for(v0 = 0; v0 < this.mTransitions.size(); ++v0) {
            this.mTransitions.get(v0).removeTarget(arg3);
        }

        return super.removeTarget(arg3);
    }

    public Transition removeTarget(View arg1) {
        return this.removeTarget(arg1);
    }

    public TransitionSet removeTarget(View arg3) {
        int v0;
        for(v0 = 0; v0 < this.mTransitions.size(); ++v0) {
            this.mTransitions.get(v0).removeTarget(arg3);
        }

        return super.removeTarget(arg3);
    }

    public Transition removeTarget(Class arg1) {
        return this.removeTarget(arg1);
    }

    public TransitionSet removeTarget(Class arg3) {
        int v0;
        for(v0 = 0; v0 < this.mTransitions.size(); ++v0) {
            this.mTransitions.get(v0).removeTarget(arg3);
        }

        return super.removeTarget(arg3);
    }

    public Transition removeTarget(String arg1) {
        return this.removeTarget(arg1);
    }

    public TransitionSet removeTarget(String arg3) {
        int v0;
        for(v0 = 0; v0 < this.mTransitions.size(); ++v0) {
            this.mTransitions.get(v0).removeTarget(arg3);
        }

        return super.removeTarget(arg3);
    }

    public TransitionSet removeTransition(Transition arg2) {
        this.mTransitions.remove(arg2);
        arg2.mParent = null;
        return this;
    }

    public void resume(View arg5) {
        super.resume(arg5);
        Transition[] v0 = this.transitionsAsArray();
        int v1 = this.mTransitions.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0[v2].resume(arg5);
        }

        this.returnTransitionArrayToCache(v0);
    }

    private void returnTransitionArrayToCache(Transition[] arg2) {
        Arrays.fill(((Object[])arg2), null);
        this.mTransitionsCache = arg2;
    }

    protected void runAnimators() {
        ArrayList v2;
        if(this.mTransitions.isEmpty()) {
            this.start();
            this.end();
            return;
        }

        this.setupStartEndListeners();
        if(!this.mPlayTogether) {
            int v0;
            for(v0 = 1; true; ++v0) {
                int v1 = this.mTransitions.size();
                v2 = this.mTransitions;
                if(v0 >= v1) {
                    break;
                }

                v2.get(v0 - 1).addListener(new TransitionListenerAdapter(this.mTransitions.get(v0)) {
                    public void onTransitionEnd(Transition arg2) {
                        this.val$nextTransition.runAnimators();
                        arg2.removeListener(((TransitionListener)this));
                    }
                });
            }

            Object v4 = v2.get(0);
            if(v4 != null) {
                ((Transition)v4).runAnimators();
                return;
            }
        }
        else {
            Iterator v4_1 = this.mTransitions.iterator();
            while(v4_1.hasNext()) {
                v4_1.next().runAnimators();
            }
        }
    }

    void setCanRemoveViews(boolean arg4) {
        super.setCanRemoveViews(arg4);
        int v0 = this.mTransitions.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.mTransitions.get(v1).setCanRemoveViews(arg4);
        }
    }

    void setCurrentPlayTimeMillis(long arg20, long arg22) {
        long v16;
        long v14;
        Object v7_1;
        TransitionSet v0 = this;
        long v1 = arg20;
        long v3 = arg22;
        long v5 = v0.getTotalDurationMillis();
        long v8 = 0;
        if(v0.mParent != null) {
            if(v1 < v8 && v3 < v8) {
                return;
            }

            if(v1 <= v5) {
                goto label_12;
            }

            if(v3 <= v5) {
                goto label_12;
            }
        }
        else {
        label_12:
            int v7 = Long.compare(v1, v3);
            int v10 = 0;
            boolean v12 = v7 < 0 ? true : false;
            int v13 = Long.compare(v1, v8);
            if(v13 >= 0 && v3 < v8 || v1 <= v5 && v3 > v5) {
                v0.mEnded = false;
                v0.notifyListeners(TransitionNotification.ON_START, v12);
            }

            if(v0.mPlayTogether) {
                while(true) {
                    if(v10 < v0.mTransitions.size()) {
                        v0.mTransitions.get(v10).setCurrentPlayTimeMillis(v1, v3);
                        ++v10;
                        continue;
                    }
                    else {
                        goto label_37;
                    }
                }
            }
            else {
                v10 = v0.indexOfTransition(v3);
                if(v7 >= 0) {
                    while(v10 < v0.mTransitions.size()) {
                        v7_1 = v0.mTransitions.get(v10);
                        v14 = ((Transition)v7_1).mSeekOffsetInParent;
                        v16 = v8;
                        v8 = v1 - v14;
                        if(v8 < v16) {
                            goto label_68;
                        }

                        ((Transition)v7_1).setCurrentPlayTimeMillis(v8, v3 - v14);
                        ++v10;
                        v8 = v16;
                    }

                label_37:
                    v16 = v8;
                    goto label_68;
                }

                v16 = v8;
                while(v10 >= 0) {
                    v7_1 = v0.mTransitions.get(v10);
                    v14 = v1 - ((Transition)v7_1).mSeekOffsetInParent;
                    ((Transition)v7_1).setCurrentPlayTimeMillis(v14, v3 - ((Transition)v7_1).mSeekOffsetInParent);
                    if(v14 >= v16) {
                        break;
                    }

                    --v10;
                }
            }

        label_68:
            if(v0.mParent == null) {
                return;
            }

            int v1_1 = Long.compare(v1, v5);
            if(v1_1 <= 0 || v3 > v5) {
                if(v13 >= 0) {
                }
                else if(v3 >= v16) {
                    goto label_75;
                }

                return;
            }

        label_75:
            if(v1_1 > 0) {
                v0.mEnded = true;
            }

            v0.notifyListeners(TransitionNotification.ON_END, v12);
        }
    }

    public Transition setDuration(long arg1) {
        return this.setDuration(arg1);
    }

    public TransitionSet setDuration(long arg5) {
        super.setDuration(arg5);
        if(this.mDuration >= 0) {
            ArrayList v0 = this.mTransitions;
            if(v0 != null) {
                int v0_1 = v0.size();
                int v1;
                for(v1 = 0; v1 < v0_1; ++v1) {
                    this.mTransitions.get(v1).setDuration(arg5);
                }
            }
        }

        return this;
    }

    public void setEpicenterCallback(EpicenterCallback arg4) {
        super.setEpicenterCallback(arg4);
        this.mChangeFlags |= 8;
        int v0 = this.mTransitions.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.mTransitions.get(v1).setEpicenterCallback(arg4);
        }
    }

    public Transition setInterpolator(TimeInterpolator arg1) {
        return this.setInterpolator(arg1);
    }

    public TransitionSet setInterpolator(TimeInterpolator arg4) {
        this.mChangeFlags |= 1;
        ArrayList v0 = this.mTransitions;
        if(v0 != null) {
            int v0_1 = v0.size();
            int v1;
            for(v1 = 0; v1 < v0_1; ++v1) {
                this.mTransitions.get(v1).setInterpolator(arg4);
            }
        }

        return super.setInterpolator(arg4);
    }

    public TransitionSet setOrdering(int arg3) {
        if(arg3 != 0) {
            if(arg3 == 1) {
                this.mPlayTogether = false;
                return this;
            }

            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + arg3);
        }

        this.mPlayTogether = true;
        return this;
    }

    public void setPathMotion(PathMotion arg3) {
        super.setPathMotion(arg3);
        this.mChangeFlags |= 4;
        if(this.mTransitions != null) {
            int v0;
            for(v0 = 0; v0 < this.mTransitions.size(); ++v0) {
                this.mTransitions.get(v0).setPathMotion(arg3);
            }
        }
    }

    public void setPropagation(TransitionPropagation arg4) {
        super.setPropagation(arg4);
        this.mChangeFlags |= 2;
        int v0 = this.mTransitions.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.mTransitions.get(v1).setPropagation(arg4);
        }
    }

    public Transition setStartDelay(long arg1) {
        return this.setStartDelay(arg1);
    }

    public TransitionSet setStartDelay(long arg1) {
        return super.setStartDelay(arg1);
    }

    private void setupStartEndListeners() {
        TransitionSetListener v0 = new TransitionSetListener(this);
        Iterator v1 = this.mTransitions.iterator();
        while(v1.hasNext()) {
            v1.next().addListener(((TransitionListener)v0));
        }

        this.mCurrentListeners = this.mTransitions.size();
    }

    String toString(String arg6) {
        String v0 = super.toString(arg6);
        int v1;
        for(v1 = 0; v1 < this.mTransitions.size(); ++v1) {
            v0 = v0 + "\n" + this.mTransitions.get(v1).toString(arg6 + "  ");
        }

        return v0;
    }

    private Transition[] transitionsAsArray() {
        Transition[] v0 = this.mTransitionsCache;
        this.mTransitionsCache = null;
        if(v0 == null) {
            v0 = new Transition[this.mTransitions.size()];
        }

        return this.mTransitions.toArray(((Object[])v0));
    }
}

