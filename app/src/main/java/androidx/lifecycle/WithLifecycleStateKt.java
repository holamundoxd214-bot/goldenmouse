package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(d1={"\u0000.\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A0\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u000E\b\u0004\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086H¢\u0006\u0002\u0010\u0007\u001A(\u0010\b\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000E\b\u0004\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086H¢\u0006\u0002\u0010\t\u001A(\u0010\n\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000E\b\u0004\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086H¢\u0006\u0002\u0010\t\u001A(\u0010\u000B\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000E\b\u0004\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086H¢\u0006\u0002\u0010\t\u001A0\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\f2\u0006\u0010\u0003\u001A\u00020\u00042\u000E\b\u0004\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086H¢\u0006\u0002\u0010\r\u001A(\u0010\b\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\f2\u000E\b\u0004\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086H¢\u0006\u0002\u0010\u000E\u001A(\u0010\n\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\f2\u000E\b\u0004\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086H¢\u0006\u0002\u0010\u000E\u001A(\u0010\u000B\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\f2\u000E\b\u0004\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086H¢\u0006\u0002\u0010\u000E\u001A0\u0010\u000F\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u000E\b\u0004\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0081H¢\u0006\u0002\u0010\u0007\u001A>\u0010\u0010\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0081@¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2={"withStateAtLeast", "R", "Landroidx/lifecycle/Lifecycle;", "state", "Landroidx/lifecycle/Lifecycle$State;", "block", "Lkotlin/Function0;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withCreated", "(Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withStarted", "withResumed", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withStateAtLeastUnchecked", "suspendWithStateAtLeastUnchecked", "dispatchNeeded", "", "lifecycleDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;ZLkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lifecycle-runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class WithLifecycleStateKt {
    public static final Object suspendWithStateAtLeastUnchecked(Lifecycle arg3, State arg4, boolean arg5, CoroutineDispatcher arg6, Function0 arg7, Continuation arg8) {
        CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg8), 1);
        v0.initCancellability();
        CancellableContinuationImpl v1 = v0;
        WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 v2 = new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1(arg4, arg3, ((CancellableContinuation)v1), arg7);
        if(arg5) {
            arg6.dispatch(EmptyCoroutineContext.INSTANCE, new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1(arg3, v2));
        }
        else {
            arg3.addObserver(v2);
        }

        ((CancellableContinuation)v1).invokeOnCancellation(new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(arg6, arg3, v2));
        Object v3 = v0.getResult();
        if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg8);
        }

        return v3;
    }

    public static final Object withCreated(Lifecycle arg6, Function0 arg7, Continuation arg8) {
        State v1 = State.CREATED;
        MainCoroutineDispatcher v0 = Dispatchers.getMain().getImmediate();
        boolean v2 = v0.isDispatchNeeded(arg8.getContext());
        if(!v2) {
            if(arg6.getCurrentState() == State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            else if(arg6.getCurrentState().compareTo(v1) >= 0) {
                return arg7.invoke();
            }
        }

        return WithLifecycleStateKt.suspendWithStateAtLeastUnchecked(arg6, v1, v2, v0, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(arg7), arg8);
    }

    public static final Object withCreated(LifecycleOwner arg6, Function0 arg7, Continuation arg8) {
        Lifecycle v0 = arg6.getLifecycle();
        State v1 = State.CREATED;
        MainCoroutineDispatcher v6 = Dispatchers.getMain().getImmediate();
        boolean v2 = v6.isDispatchNeeded(arg8.getContext());
        if(!v2) {
            if(v0.getCurrentState() == State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            else if(v0.getCurrentState().compareTo(v1) >= 0) {
                return arg7.invoke();
            }
        }

        return WithLifecycleStateKt.suspendWithStateAtLeastUnchecked(v0, v1, v2, v6, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(arg7), arg8);
    }

    private static final Object withCreated$$forInline(Lifecycle arg0, Function0 arg1, Continuation arg2) {
        Dispatchers.getMain().getImmediate();
        null.getContext();
        throw null;
    }

    private static final Object withCreated$$forInline(LifecycleOwner arg0, Function0 arg1, Continuation arg2) {
        arg0.getLifecycle();
        Dispatchers.getMain().getImmediate();
        null.getContext();
        throw null;
    }

    public static final Object withResumed(Lifecycle arg6, Function0 arg7, Continuation arg8) {
        State v1 = State.RESUMED;
        MainCoroutineDispatcher v0 = Dispatchers.getMain().getImmediate();
        boolean v2 = v0.isDispatchNeeded(arg8.getContext());
        if(!v2) {
            if(arg6.getCurrentState() == State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            else if(arg6.getCurrentState().compareTo(v1) >= 0) {
                return arg7.invoke();
            }
        }

        return WithLifecycleStateKt.suspendWithStateAtLeastUnchecked(arg6, v1, v2, v0, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(arg7), arg8);
    }

    public static final Object withResumed(LifecycleOwner arg6, Function0 arg7, Continuation arg8) {
        Lifecycle v0 = arg6.getLifecycle();
        State v1 = State.RESUMED;
        MainCoroutineDispatcher v6 = Dispatchers.getMain().getImmediate();
        boolean v2 = v6.isDispatchNeeded(arg8.getContext());
        if(!v2) {
            if(v0.getCurrentState() == State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            else if(v0.getCurrentState().compareTo(v1) >= 0) {
                return arg7.invoke();
            }
        }

        return WithLifecycleStateKt.suspendWithStateAtLeastUnchecked(v0, v1, v2, v6, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(arg7), arg8);
    }

    private static final Object withResumed$$forInline(Lifecycle arg0, Function0 arg1, Continuation arg2) {
        Dispatchers.getMain().getImmediate();
        null.getContext();
        throw null;
    }

    private static final Object withResumed$$forInline(LifecycleOwner arg0, Function0 arg1, Continuation arg2) {
        arg0.getLifecycle();
        Dispatchers.getMain().getImmediate();
        null.getContext();
        throw null;
    }

    public static final Object withStarted(Lifecycle arg6, Function0 arg7, Continuation arg8) {
        State v1 = State.STARTED;
        MainCoroutineDispatcher v0 = Dispatchers.getMain().getImmediate();
        boolean v2 = v0.isDispatchNeeded(arg8.getContext());
        if(!v2) {
            if(arg6.getCurrentState() == State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            else if(arg6.getCurrentState().compareTo(v1) >= 0) {
                return arg7.invoke();
            }
        }

        return WithLifecycleStateKt.suspendWithStateAtLeastUnchecked(arg6, v1, v2, v0, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(arg7), arg8);
    }

    public static final Object withStarted(LifecycleOwner arg6, Function0 arg7, Continuation arg8) {
        Lifecycle v0 = arg6.getLifecycle();
        State v1 = State.STARTED;
        MainCoroutineDispatcher v6 = Dispatchers.getMain().getImmediate();
        boolean v2 = v6.isDispatchNeeded(arg8.getContext());
        if(!v2) {
            if(v0.getCurrentState() == State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            else if(v0.getCurrentState().compareTo(v1) >= 0) {
                return arg7.invoke();
            }
        }

        return WithLifecycleStateKt.suspendWithStateAtLeastUnchecked(v0, v1, v2, v6, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(arg7), arg8);
    }

    private static final Object withStarted$$forInline(Lifecycle arg0, Function0 arg1, Continuation arg2) {
        Dispatchers.getMain().getImmediate();
        null.getContext();
        throw null;
    }

    private static final Object withStarted$$forInline(LifecycleOwner arg0, Function0 arg1, Continuation arg2) {
        arg0.getLifecycle();
        Dispatchers.getMain().getImmediate();
        null.getContext();
        throw null;
    }

    public static final Object withStateAtLeast(Lifecycle arg8, State arg9, Function0 arg10, Continuation arg11) {
        if(arg9.compareTo(State.CREATED) >= 0) {
            MainCoroutineDispatcher v0 = Dispatchers.getMain().getImmediate();
            boolean v4 = v0.isDispatchNeeded(arg11.getContext());
            if(!v4) {
                if(arg8.getCurrentState() == State.DESTROYED) {
                    throw new LifecycleDestroyedException();
                }
                else if(arg8.getCurrentState().compareTo(arg9) >= 0) {
                    return arg10.invoke();
                }
            }

            return WithLifecycleStateKt.suspendWithStateAtLeastUnchecked(arg8, arg9, v4, v0, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(arg10), arg11);
        }

        throw new IllegalArgumentException("target state must be CREATED or greater, found " + arg9.toString());
    }

    public static final Object withStateAtLeast(LifecycleOwner arg6, State arg7, Function0 arg8, Continuation arg9) {
        Lifecycle v0 = arg6.getLifecycle();
        if(arg7.compareTo(State.CREATED) >= 0) {
            MainCoroutineDispatcher v6 = Dispatchers.getMain().getImmediate();
            boolean v2 = v6.isDispatchNeeded(arg9.getContext());
            if(!v2) {
                if(v0.getCurrentState() == State.DESTROYED) {
                    throw new LifecycleDestroyedException();
                }
                else if(v0.getCurrentState().compareTo(arg7) >= 0) {
                    return arg8.invoke();
                }
            }

            return WithLifecycleStateKt.suspendWithStateAtLeastUnchecked(v0, arg7, v2, v6, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(arg8), arg9);
        }

        throw new IllegalArgumentException("target state must be CREATED or greater, found " + arg7.toString());
    }

    private static final Object withStateAtLeast$$forInline(Lifecycle arg0, State arg1, Function0 arg2, Continuation arg3) {
        if(arg1.compareTo(State.CREATED) >= 0) {
            Dispatchers.getMain().getImmediate();
            null.getContext();
            throw null;
        }

        throw new IllegalArgumentException("target state must be CREATED or greater, found " + arg1.toString());
    }

    private static final Object withStateAtLeast$$forInline(LifecycleOwner arg0, State arg1, Function0 arg2, Continuation arg3) {
        arg0.getLifecycle();
        if(arg1.compareTo(State.CREATED) >= 0) {
            Dispatchers.getMain().getImmediate();
            null.getContext();
            throw null;
        }

        throw new IllegalArgumentException("target state must be CREATED or greater, found " + arg1.toString());
    }

    public static final Object withStateAtLeastUnchecked(Lifecycle arg8, State arg9, Function0 arg10, Continuation arg11) {
        MainCoroutineDispatcher v0 = Dispatchers.getMain().getImmediate();
        boolean v4 = v0.isDispatchNeeded(arg11.getContext());
        if(!v4) {
            if(arg8.getCurrentState() == State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            else if(arg8.getCurrentState().compareTo(arg9) >= 0) {
                return arg10.invoke();
            }
        }

        return WithLifecycleStateKt.suspendWithStateAtLeastUnchecked(arg8, arg9, v4, v0, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(arg10), arg11);
    }

    private static final Object withStateAtLeastUnchecked$$forInline(Lifecycle arg0, State arg1, Function0 arg2, Continuation arg3) {
        Dispatchers.getMain().getImmediate();
        null.getContext();
        throw null;
    }
}

