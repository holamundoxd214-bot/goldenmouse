package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0002\u001A\u001D\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0087\u0088\u0004\u0082\u0002\b\n\u0006\b\u0000\u001A\u0002\u0010\u0001\u001A.\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0000\u001A\u0002\u0010\u0001\u001A0\u0010\u0007\u001A\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00062\b\u0010\u0002\u001A\u0004\u0018\u0001H\bH\u0087\u0088\b\u0082\u0002\n\n\b\b\u0000\u001A\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\t\u001AA\u0010\u0007\u001A\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00062\b\u0010\u0002\u001A\u0004\u0018\u0001H\b2\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\u0088\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0000\u001A\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\n\u001A\u001D\u0010\u000B\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0087\u0088\u0004\u0082\u0002\b\n\u0006\b\u0000\u001A\u0002\u0010\u0001\u001A.\u0010\u000B\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0000\u001A\u0002\u0010\u0001\u001A0\u0010\f\u001A\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00062\b\u0010\u0002\u001A\u0004\u0018\u0001H\bH\u0087\u0088\b\u0082\u0002\n\n\b\b\u0000\u001A\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\t\u001AA\u0010\f\u001A\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00062\b\u0010\u0002\u001A\u0004\u0018\u0001H\b2\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\u0088\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0000\u001A\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\n\u001A\u0012\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0006H\u0087\u0088\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2={"require", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "requireNotNull", "T", "(Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "check", "checkNotNull", "error", "", "message", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/PreconditionsKt") class PreconditionsKt__PreconditionsKt extends PreconditionsKt__AssertionsJVMKt {
    public PreconditionsKt__PreconditionsKt() {
        super();
    }

    private static final void check(boolean arg1) {
        if(arg1) {
            return;
        }

        throw new IllegalStateException("Check failed.");
    }

    private static final void check(boolean arg1, Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "lazyMessage");
        if(arg1) {
            return;
        }

        throw new IllegalStateException(arg2.invoke().toString());
    }

    @IgnorableReturnValue private static final Object checkNotNull(Object arg1) {
        if(arg1 != null) {
            return arg1;
        }

        throw new IllegalStateException("Required value was null.".toString());
    }

    @IgnorableReturnValue private static final Object checkNotNull(Object arg1, Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "lazyMessage");
        if(arg1 != null) {
            return arg1;
        }

        throw new IllegalStateException(arg2.invoke().toString());
    }

    private static final Void error(Object arg1) {
        Intrinsics.checkNotNullParameter(arg1, "message");
        throw new IllegalStateException(arg1.toString());
    }

    private static final void require(boolean arg1) {
        if(arg1) {
            return;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final void require(boolean arg1, Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "lazyMessage");
        if(arg1) {
            return;
        }

        throw new IllegalArgumentException(arg2.invoke().toString());
    }

    @IgnorableReturnValue private static final Object requireNotNull(Object arg1) {
        if(arg1 != null) {
            return arg1;
        }

        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @IgnorableReturnValue private static final Object requireNotNull(Object arg1, Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "lazyMessage");
        if(arg1 != null) {
            return arg1;
        }

        throw new IllegalArgumentException(arg2.invoke().toString());
    }
}

