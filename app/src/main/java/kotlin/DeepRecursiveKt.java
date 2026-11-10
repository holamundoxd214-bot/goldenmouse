package kotlin;

import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A3\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0004\u001A\u0002H\u0002H\u0087\u0082\u0004¢\u0006\u0002\u0010\u0005\"\u0017\u0010\f\u001A\b\u0012\u0004\u0012\u00020\t0\rX\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u000E*r\b\u0002\u0010\u0006\"5\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007¢\u0006\u0002\b\u000B25\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007¢\u0006\u0002\b\u000B¨\u0006\u000F"}, d2={"invoke", "R", "T", "Lkotlin/DeepRecursiveFunction;", "value", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;)Ljava/lang/Object;", "DeepRecursiveFunctionBlock", "Lkotlin/Function3;", "Lkotlin/DeepRecursiveScope;", "", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "UNDEFINED_RESULT", "Lkotlin/Result;", "Ljava/lang/Object;", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class DeepRecursiveKt {
    private static final Object UNDEFINED_RESULT;

    static {
        DeepRecursiveKt.UNDEFINED_RESULT = Result.constructor-impl(IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }

    public static final Object access$getUNDEFINED_RESULT$p() {
        return DeepRecursiveKt.UNDEFINED_RESULT;
    }

    public static final Object invoke(DeepRecursiveFunction arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new DeepRecursiveScopeImpl(arg1.getBlock$kotlin_stdlib(), arg2).runCallLoop();
    }
}

