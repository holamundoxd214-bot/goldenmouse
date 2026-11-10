package androidx.lifecycle;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u001A\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0001H\u0002\u001A\"\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\u0001H\u0002¨\u0006\n"}, d2={"min", "Landroidx/lifecycle/Lifecycle$State;", "state1", "state2", "checkLifecycleStateTransition", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "current", "next", "lifecycle-runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class LifecycleRegistryKt {
    public static final void access$checkLifecycleStateTransition(LifecycleOwner arg0, State arg1, State arg2) {
        LifecycleRegistryKt.checkLifecycleStateTransition(arg0, arg1, arg2);
    }

    public static final State access$min(State arg0, State arg1) {
        return LifecycleRegistryKt.min(arg0, arg1);
    }

    private static final void checkLifecycleStateTransition(LifecycleOwner arg3, State arg4, State arg5) {
        if(arg4 == State.INITIALIZED) {
            if(arg5 != State.DESTROYED) {
            }
            else {
                throw new IllegalStateException("State must be at least \'" + State.CREATED + "\' to be moved to \'" + arg5 + "\' in component " + arg3.toString());
            }
        }

        if(arg4 == State.DESTROYED) {
            if(arg4 == arg5) {
            }
            else {
                throw new IllegalStateException("State is \'" + State.DESTROYED + "\' and cannot be moved to `" + arg5 + "` in component " + arg3.toString());
            }
        }
    }

    private static final State min(State arg1, State arg2) {
        if(arg2 != null && arg2.compareTo(arg1) < 0) {
            return arg2;
        }

        return arg1;
    }
}

