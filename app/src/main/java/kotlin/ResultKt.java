package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000F\u001A\u0012\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0081\u0080\u0004\u001A\u0017\u0010\u0004\u001A\u00020\u0005*\u0006\u0012\u0002\b\u00030\u0006H\u0081\u0080\u0004¢\u0006\u0002\u0010\u0007\u001A,\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\t0\u0006\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\t0\u000BH\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\f\u001AA\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\t0\u0006\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\t*\u0002H\r2\u0017\u0010\n\u001A\u0013\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\t0\u000E¢\u0006\u0002\b\u000FH\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001A\u001F\u0010\u0011\u001A\u0002H\r\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u0006H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0012\u001A\\\u0010\u0013\u001A\u0002H\t\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\r*\u0002H\t*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010\u0014\u001A\u001D\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\t0\u000EH\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0010\u001A1\u0010\u0017\u001A\u0002H\t\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\r*\u0002H\t*\b\u0012\u0004\u0012\u0002H\r0\u00062\u0006\u0010\u0018\u001A\u0002H\tH\u0087\u0088\u0004¢\u0006\u0002\u0010\u0019\u001A\u0085\u0001\u0010\u001A\u001A\u0002H\t\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010\u001B\u001A\u001D\u0012\u0013\u0012\u0011H\r¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u0002H\t0\u000E2!\u0010\u0014\u001A\u001D\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\t0\u000EH\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\u0014\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0002\u0010\u001D\u001A^\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\t0\u0006\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010\u001F\u001A\u001D\u0012\u0013\u0012\u0011H\r¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u0002H\t0\u000EH\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0010\u001AQ\u0010 \u001A\b\u0012\u0004\u0012\u0002H\t0\u0006\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010\u001F\u001A\u001D\u0012\u0013\u0012\u0011H\r¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u0002H\t0\u000EH\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001Ab\u0010!\u001A\b\u0012\u0004\u0012\u0002H\t0\u0006\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\r*\u0002H\t*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010\u001F\u001A\u001D\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\t0\u000EH\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0010\u001AU\u0010\"\u001A\b\u0012\u0004\u0012\u0002H\t0\u0006\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\r*\u0002H\t*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010\u001F\u001A\u001D\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\t0\u000EH\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001AX\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\r0\u0006\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010#\u001A\u001D\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u00050\u000EH\u0087\u0088\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0010\u001AX\u0010\u001B\u001A\b\u0012\u0004\u0012\u0002H\r0\u0006\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010#\u001A\u001D\u0012\u0013\u0012\u0011H\r¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u00020\u00050\u000EH\u0087\u0088\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, d2={"createFailure", "", "exception", "", "throwOnFailure", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "runCatching", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "T", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrThrow", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "onFailure", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "fold", "onSuccess", "value", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "map", "transform", "mapCatching", "recover", "recoverCatching", "action", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class ResultKt {
    public static final Object createFailure(Throwable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "exception");
        return new Failure(arg1);
    }

    private static final Object fold(Object arg1, Function1 arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "onSuccess");
        Intrinsics.checkNotNullParameter(arg3, "onFailure");
        Throwable v0 = Result.exceptionOrNull-impl(arg1);
        if(v0 == null) {
            return arg2.invoke(arg1);
        }

        return arg3.invoke(v0);
    }

    private static final Object getOrDefault(Object arg1, Object arg2) {
        if(Result.isFailure-impl(arg1)) {
            return arg2;
        }

        return arg1;
    }

    private static final Object getOrElse(Object arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "onFailure");
        Throwable v0 = Result.exceptionOrNull-impl(arg1);
        if(v0 == null) {
            return arg1;
        }

        return arg2.invoke(v0);
    }

    private static final Object getOrThrow(Object arg0) {
        ResultKt.throwOnFailure(arg0);
        return arg0;
    }

    private static final Object map(Object arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "transform");
        if(Result.isSuccess-impl(arg1)) {
            return Result.constructor-impl(arg2.invoke(arg1));
        }

        return Result.constructor-impl(arg1);
    }

    private static final Object mapCatching(Object arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "transform");
        if(Result.isSuccess-impl(arg1)) {
            try {
                arg1 = Result.constructor-impl(arg2.invoke(arg1));
            }
            catch(Throwable v1) {
                arg1 = Result.constructor-impl(ResultKt.createFailure(v1));
            }

            return arg1;
        }

        return Result.constructor-impl(arg1);
    }

    @IgnorableReturnValue private static final Object onFailure(Object arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "action");
        Throwable v0 = Result.exceptionOrNull-impl(arg1);
        if(v0 != null) {
            arg2.invoke(v0);
        }

        return arg1;
    }

    @IgnorableReturnValue private static final Object onSuccess(Object arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "action");
        if(Result.isSuccess-impl(arg1)) {
            arg2.invoke(arg1);
        }

        return arg1;
    }

    private static final Object recover(Object arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "transform");
        Throwable v0 = Result.exceptionOrNull-impl(arg1);
        if(v0 == null) {
            return arg1;
        }

        return Result.constructor-impl(arg2.invoke(v0));
    }

    private static final Object recoverCatching(Object arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "transform");
        Throwable v0 = Result.exceptionOrNull-impl(arg1);
        if(v0 == null) {
            return arg1;
        }

        try {
            arg1 = Result.constructor-impl(arg2.invoke(v0));
        }
        catch(Throwable v1) {
            arg1 = Result.constructor-impl(ResultKt.createFailure(v1));
        }

        return arg1;
    }

    private static final Object runCatching(Object arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "block");
        try {
            return Result.constructor-impl(arg2.invoke(arg1));
        }
        catch(Throwable v1) {
            return Result.constructor-impl(ResultKt.createFailure(v1));
        }
    }

    private static final Object runCatching(Function0 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "block");
        try {
            return Result.constructor-impl(arg1.invoke());
        }
        catch(Throwable v1) {
            return Result.constructor-impl(ResultKt.createFailure(v1));
        }
    }

    public static final void throwOnFailure(Object arg1) {
        if(!(arg1 instanceof Failure)) {
            return;
        }

        throw ((Failure)arg1).exception;
    }
}

