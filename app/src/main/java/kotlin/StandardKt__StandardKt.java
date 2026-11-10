package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u001A\n\u0010\u0000\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0087\u0088\u0004\u001A3\u0010\u0004\u001A\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0087\u0088\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\b\u001AH\u0010\u0004\u001A\u0002H\u0005\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u0005*\u0002H\t2\u0017\u0010\u0006\u001A\u0013\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u00050\n¢\u0006\u0002\b\u000BH\u0087\u0088\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\f\u001AL\u0010\r\u001A\u0002H\u0005\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u000E\u001A\u0002H\t2\u0017\u0010\u0006\u001A\u0013\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u00050\n¢\u0006\u0002\b\u000BH\u0087\u0088\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\f\u001AB\u0010\u000F\u001A\u0002H\t\"\u0004\b\u0000\u0010\t*\u0002H\t2\u0017\u0010\u0006\u001A\u0013\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00100\n¢\u0006\u0002\b\u000BH\u0087\u0088\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\f\u001A=\u0010\u0011\u001A\u0002H\t\"\u0004\b\u0000\u0010\t*\u0002H\t2\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00100\nH\u0087\u0088\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\f\u001AC\u0010\u0012\u001A\u0002H\u0005\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u0005*\u0002H\t2\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u00050\nH\u0087\u0088\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\f\u001A?\u0010\u0013\u001A\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t*\u0002H\t2\u0012\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00150\nH\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\f\u001A?\u0010\u0016\u001A\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t*\u0002H\t2\u0012\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00150\nH\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\f\u001A4\u0010\u0017\u001A\u00020\u00102\u0006\u0010\u0018\u001A\u00020\u00192\u0012\u0010\u001A\u001A\u000E\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00100\nH\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001B"}, d2={"TODO", "", "reason", "", "run", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "T", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "with", "receiver", "apply", "", "also", "let", "takeIf", "predicate", "", "takeUnless", "repeat", "times", "", "action", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/StandardKt") class StandardKt__StandardKt {
    public StandardKt__StandardKt() {
        super();
    }

    private static final Void TODO() {
        throw new NotImplementedError(null, 1, null);
    }

    private static final Void TODO(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "reason");
        throw new NotImplementedError("An operation is not implemented: " + arg3);
    }

    @IgnorableReturnValue private static final Object also(Object arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "block");
        arg2.invoke(arg1);
        return arg1;
    }

    @IgnorableReturnValue private static final Object apply(Object arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "block");
        arg2.invoke(arg1);
        return arg1;
    }

    @IgnorableReturnValue private static final Object let(Object arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "block");
        return arg2.invoke(arg1);
    }

    private static final void repeat(int arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "action");
        int v0;
        for(v0 = 0; v0 < arg2; ++v0) {
            arg3.invoke(Integer.valueOf(v0));
        }
    }

    @IgnorableReturnValue private static final Object run(Object arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "block");
        return arg2.invoke(arg1);
    }

    @IgnorableReturnValue private static final Object run(Function0 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "block");
        return arg1.invoke();
    }

    private static final Object takeIf(Object arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "predicate");
        if(arg2.invoke(arg1).booleanValue()) {
            return arg1;
        }

        return null;
    }

    private static final Object takeUnless(Object arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "predicate");
        if(!arg2.invoke(arg1).booleanValue()) {
            return arg1;
        }

        return null;
    }

    @IgnorableReturnValue private static final Object with(Object arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "block");
        return arg2.invoke(arg1);
    }
}

