package androidx.lifecycle;

@Deprecated class ReflectiveGenericLifecycleObserver implements LifecycleEventObserver {
    private final CallbackInfo mInfo;
    private final Object mWrapped;

    ReflectiveGenericLifecycleObserver(Object arg2) {
        super();
        this.mWrapped = arg2;
        this.mInfo = ClassesInfoCache.sInstance.getInfo(arg2.getClass());
    }

    public void onStateChanged(LifecycleOwner arg2, Event arg3) {
        this.mInfo.invokeCallbacks(arg2, arg3, this.mWrapped);
    }
}

