package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Landroidx/lifecycle/DefaultLifecycleObserverAdapter;", "Landroidx/lifecycle/LifecycleEventObserver;", "defaultLifecycleObserver", "Landroidx/lifecycle/DefaultLifecycleObserver;", "lifecycleEventObserver", "<init>", "(Landroidx/lifecycle/DefaultLifecycleObserver;Landroidx/lifecycle/LifecycleEventObserver;)V", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycle-common"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DefaultLifecycleObserverAdapter implements LifecycleEventObserver {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Event.values().length];
            try {
                v0[Event.ON_CREATE.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Event.ON_START.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[Event.ON_RESUME.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[Event.ON_PAUSE.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[Event.ON_STOP.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_23:
                                    v0[Event.ON_DESTROY.ordinal()] = 6;
                                    goto label_27;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_27:
                                        v0[Event.ON_ANY.ordinal()] = 7;
                                        goto label_31;
                                    }
                                    catch(NoSuchFieldError ) {
                                    label_31:
                                        WhenMappings.$EnumSwitchMapping$0 = v0;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private final DefaultLifecycleObserver defaultLifecycleObserver;
    private final LifecycleEventObserver lifecycleEventObserver;

    public DefaultLifecycleObserverAdapter(DefaultLifecycleObserver arg2, LifecycleEventObserver arg3) {
        Intrinsics.checkNotNullParameter(arg2, "defaultLifecycleObserver");
        super();
        this.defaultLifecycleObserver = arg2;
        this.lifecycleEventObserver = arg3;
    }

    public void onStateChanged(LifecycleOwner arg3, Event arg4) {
        Intrinsics.checkNotNullParameter(arg3, "source");
        Intrinsics.checkNotNullParameter(arg4, "event");
        switch(WhenMappings.$EnumSwitchMapping$0[arg4.ordinal()]) {
            case 1: {
                goto label_30;
            }
            case 2: {
                goto label_27;
            }
            case 3: {
                goto label_24;
            }
            case 4: {
                goto label_21;
            }
            case 5: {
                goto label_18;
            }
            case 6: {
                goto label_15;
            }
            case 7: {
                goto label_11;
            }
        }

        throw new NoWhenBranchMatchedException();
    label_18:
        this.defaultLifecycleObserver.onStop(arg3);
        goto label_32;
    label_21:
        this.defaultLifecycleObserver.onPause(arg3);
        goto label_32;
    label_24:
        this.defaultLifecycleObserver.onResume(arg3);
        goto label_32;
    label_27:
        this.defaultLifecycleObserver.onStart(arg3);
        goto label_32;
    label_11:
        throw new IllegalArgumentException("ON_ANY must not been send by anybody");
    label_30:
        this.defaultLifecycleObserver.onCreate(arg3);
        goto label_32;
    label_15:
        this.defaultLifecycleObserver.onDestroy(arg3);
    label_32:
        LifecycleEventObserver v2 = this.lifecycleEventObserver;
        if(v2 != null) {
            v2.onStateChanged(arg3, arg4);
        }
    }
}

