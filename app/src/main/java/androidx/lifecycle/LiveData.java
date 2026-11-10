package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap$IteratorWithAdditions;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map$Entry;

public abstract class LiveData {
    class androidx.lifecycle.LiveData$1 implements Runnable {
        androidx.lifecycle.LiveData$1(LiveData arg1) {
            LiveData.this = arg1;
            super();
        }

        public void run() {
            Object v1;
            Object v0 = LiveData.this.mDataLock;
            __monitor_enter(v0);
            try {
                v1 = LiveData.this.mPendingData;
                LiveData.this.mPendingData = LiveData.NOT_SET;
                __monitor_exit(v0);
            }
            catch(Throwable v4) {
                try {
                label_13:
                    __monitor_exit(v0);
                }
                catch(Throwable v4) {
                    goto label_13;
                }

                throw v4;
            }

            LiveData.this.setValue(v1);
        }
    }

    class AlwaysActiveObserver extends ObserverWrapper {
        AlwaysActiveObserver(LiveData arg1, Observer arg2) {
            LiveData.this = arg1;
            super(arg1, arg2);
        }

        boolean shouldBeActive() {
            return 1;
        }
    }

    class LifecycleBoundObserver extends ObserverWrapper implements LifecycleEventObserver {
        final LifecycleOwner mOwner;

        LifecycleBoundObserver(LiveData arg1, LifecycleOwner arg2, Observer arg3) {
            LiveData.this = arg1;
            super(arg1, arg3);
            this.mOwner = arg2;
        }

        void detachObserver() {
            this.mOwner.getLifecycle().removeObserver(((LifecycleObserver)this));
        }

        boolean isAttachedTo(LifecycleOwner arg1) {
            if(this.mOwner == arg1) {
                return 1;
            }

            return 0;
        }

        public void onStateChanged(LifecycleOwner arg2, Event arg3) {
            State v2 = this.mOwner.getLifecycle().getCurrentState();
            if(v2 == State.DESTROYED) {
                LiveData.this.removeObserver(this.mObserver);
                return;
            }

            State v3 = null;
            while(v3 != v2) {
                this.activeStateChanged(this.shouldBeActive());
                v3 = v2;
                v2 = this.mOwner.getLifecycle().getCurrentState();
            }
        }

        boolean shouldBeActive() {
            return this.mOwner.getLifecycle().getCurrentState().isAtLeast(State.STARTED);
        }
    }

    abstract class ObserverWrapper {
        boolean mActive;
        int mLastVersion;
        final Observer mObserver;

        ObserverWrapper(LiveData arg1, Observer arg2) {
            LiveData.this = arg1;
            super();
            this.mLastVersion = -1;
            this.mObserver = arg2;
        }

        void activeStateChanged(boolean arg2) {
            if(arg2 == this.mActive) {
            }
            else {
                this.mActive = arg2;
                LiveData v0 = LiveData.this;
                int v2 = arg2 ? 1 : -1;
                v0.changeActiveCounter(v2);
                if(!this.mActive) {
                    return;
                }

                LiveData.this.dispatchingValue(this);
            }
        }

        void detachObserver() {
        }

        boolean isAttachedTo(LifecycleOwner arg1) {
            return 0;
        }

        abstract boolean shouldBeActive();
    }

    static final Object NOT_SET = null;
    static final int START_VERSION = -1;
    int mActiveCount;
    private boolean mChangingActiveState;
    private volatile Object mData;
    final Object mDataLock;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private SafeIterableMap mObservers;
    volatile Object mPendingData;
    private final Runnable mPostValueRunnable;
    private int mVersion;

    static {
        LiveData.NOT_SET = new Object();
    }

    public LiveData() {
        super();
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap();
        this.mActiveCount = 0;
        Object v0 = LiveData.NOT_SET;
        this.mPendingData = v0;
        this.mPostValueRunnable = new androidx.lifecycle.LiveData$1(this);
        this.mData = v0;
        this.mVersion = -1;
    }

    public LiveData(Object arg3) {
        super();
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap();
        this.mActiveCount = 0;
        this.mPendingData = LiveData.NOT_SET;
        this.mPostValueRunnable = new androidx.lifecycle.LiveData$1(this);
        this.mData = arg3;
        this.mVersion = 0;
    }

    static void assertMainThread(String arg3) {
        if(ArchTaskExecutor.getInstance().isMainThread()) {
            return;
        }

        throw new IllegalStateException("Cannot invoke " + arg3 + " on a background thread");
    }

    void changeActiveCounter(int arg5) {
        int v2;
        int v0 = this.mActiveCount;
        this.mActiveCount = arg5 + v0;
        if(this.mChangingActiveState) {
            return;
        }

        this.mChangingActiveState = true;
        try {
            while(true) {
            label_9:
                v2 = this.mActiveCount;
                if(v0 == v2) {
                    goto label_28;
                }

                int v3 = v0 != 0 || v2 <= 0 ? 0 : 1;
                v0 = v0 <= 0 || v2 != 0 ? 0 : 1;
                if(v3 != 0) {
                    this.onActive();
                }
                else if(v0 != 0) {
                    this.onInactive();
                }

                break;
            }
        }
        catch(Throwable v5) {
            this.mChangingActiveState = false;
            throw v5;
        }

        v0 = v2;
        goto label_9;
    label_28:
        this.mChangingActiveState = false;
    }

    private void considerNotify(ObserverWrapper arg3) {
        int v1;
        if(!arg3.mActive) {
        }
        else if(!arg3.shouldBeActive()) {
            arg3.activeStateChanged(false);
            return;
        }
        else {
            int v0 = arg3.mLastVersion;
            v1 = this.mVersion;
            if(v0 >= v1) {
                return;
            }

            goto label_12;
        }

        return;
    label_12:
        arg3.mLastVersion = v1;
        arg3.mObserver.onChanged(this.mData);
    }

    void dispatchingValue(ObserverWrapper arg4) {
        if(this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }

        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            if(0 != 0) {
                this.considerNotify(arg4);
                arg4 = null;
            }
            else {
                IteratorWithAdditions v1 = this.mObservers.iteratorWithAdditions();
                do {
                    if(((Iterator)v1).hasNext()) {
                        this.considerNotify(((Iterator)v1).next().getValue());
                        if(!this.mDispatchInvalidated) {
                            continue;
                        }
                    }

                    break;
                }
                while(true);
            }
        }
        while(this.mDispatchInvalidated);

        this.mDispatchingValue = false;
    }

    public Object getValue() {
        Object v1 = this.mData;
        if(v1 != LiveData.NOT_SET) {
            return v1;
        }

        return null;
    }

    int getVersion() {
        return this.mVersion;
    }

    public boolean hasActiveObservers() {
        if(this.mActiveCount > 0) {
            return 1;
        }

        return 0;
    }

    public boolean hasObservers() {
        if(this.mObservers.size() > 0) {
            return 1;
        }

        return 0;
    }

    public boolean isInitialized() {
        if(this.mData != LiveData.NOT_SET) {
            return 1;
        }

        return 0;
    }

    public void observe(LifecycleOwner arg3, Observer arg4) {
        LifecycleBoundObserver v0;
        LiveData.assertMainThread("observe");
        if(arg3.getLifecycle().getCurrentState() == State.DESTROYED) {
        }
        else {
            v0 = new LifecycleBoundObserver(this, arg3, arg4);
            Object v2 = this.mObservers.putIfAbsent(arg4, v0);
            if(v2 != null) {
                if(((ObserverWrapper)v2).isAttachedTo(arg3)) {
                }
                else {
                    throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
                }
            }

            if(v2 == null) {
                goto label_21;
            }
        }

        return;
    label_21:
        arg3.getLifecycle().addObserver(((LifecycleObserver)v0));
    }

    public void observeForever(Observer arg2) {
        LiveData.assertMainThread("observeForever");
        AlwaysActiveObserver v0 = new AlwaysActiveObserver(this, arg2);
        Object v1 = this.mObservers.putIfAbsent(arg2, v0);
        if(!(v1 instanceof LifecycleBoundObserver)) {
            if(v1 != null) {
                return;
            }

            v0.activeStateChanged(true);
            return;
        }

        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    protected void onActive() {
    }

    protected void onInactive() {
    }

    protected void postValue(Object arg4) {
        Object v0 = this.mDataLock;
        __monitor_enter(v0);
        try {
            int v1 = this.mPendingData == LiveData.NOT_SET ? 1 : 0;
            this.mPendingData = arg4;
            __monitor_exit(v0);
            if(v1 != 0) {
                goto label_12;
            }
        }
        catch(Throwable v3) {
            try {
            label_17:
                __monitor_exit(v0);
            }
            catch(Throwable v3) {
                goto label_17;
            }

            throw v3;
        }

        return;
    label_12:
        ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
    }

    public void removeObserver(Observer arg2) {
        LiveData.assertMainThread("removeObserver");
        Object v1 = this.mObservers.remove(arg2);
        if(v1 == null) {
            return;
        }

        ((ObserverWrapper)v1).detachObserver();
        ((ObserverWrapper)v1).activeStateChanged(false);
    }

    public void removeObservers(LifecycleOwner arg4) {
        LiveData.assertMainThread("removeObservers");
        Iterator v0 = this.mObservers.iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            if(!((Map$Entry)v1).getValue().isAttachedTo(arg4)) {
                continue;
            }

            this.removeObserver(((Map$Entry)v1).getKey());
        }
    }

    protected void setValue(Object arg2) {
        LiveData.assertMainThread("setValue");
        ++this.mVersion;
        this.mData = arg2;
        this.dispatchingValue(null);
    }
}

