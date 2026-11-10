package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001A\u001C\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001AT\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000126\u0010\u0003\u001A2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u001A6\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000B*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000B0\r\u001Au\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0014\u0010\f\u001A\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\r2:\u0010\u0003\u001A6\u0012\u0015\u0012\u0013\u0018\u00010\u000F¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\u000F¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u0002¢\u0006\u0002\b\u0011\"\u001E\u0010\u000E\u001A\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000F\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\rX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0010\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000F\u0012\u0006\u0012\u0004\u0018\u00010\u000F\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"distinctUntilChanged", "Lkotlinx/coroutines/flow/Flow;", "T", "areEquivalent", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "old", "new", "", "distinctUntilChangedBy", "K", "keySelector", "Lkotlin/Function1;", "defaultKeySelector", "", "defaultAreEquivalent", "distinctUntilChangedBy$FlowKt__DistinctKt", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/flow/FlowKt") final class FlowKt__DistinctKt {
    private static final Function2 defaultAreEquivalent;
    private static final Function1 defaultKeySelector;

    public static boolean $r8$lambda$gx6nPCTeN-XIdcjeew_gbEL_7B8(Object arg0, Object arg1) {
        return FlowKt__DistinctKt.defaultAreEquivalent$lambda$1$FlowKt__DistinctKt(arg0, arg1);
    }

    public static Object $r8$lambda$mgidQTCZEwPL4AoZywC2sds_69k(Object arg0) {
        return FlowKt__DistinctKt.defaultKeySelector$lambda$0$FlowKt__DistinctKt(arg0);
    }

    static {
        FlowKt__DistinctKt.defaultKeySelector = new FlowKt__DistinctKt$$ExternalSyntheticLambda0();
        FlowKt__DistinctKt.defaultAreEquivalent = new FlowKt__DistinctKt$$ExternalSyntheticLambda1();
    }

    private static final boolean defaultAreEquivalent$lambda$1$FlowKt__DistinctKt(Object arg0, Object arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    private static final Object defaultKeySelector$lambda$0$FlowKt__DistinctKt(Object arg0) {
        return arg0;
    }

    public static final Flow distinctUntilChanged(Flow arg2) {
        if((arg2 instanceof StateFlow)) {
            return arg2;
        }

        return FlowKt__DistinctKt.distinctUntilChangedBy$FlowKt__DistinctKt(arg2, FlowKt__DistinctKt.defaultKeySelector, FlowKt__DistinctKt.defaultAreEquivalent);
    }

    public static final Flow distinctUntilChanged(Flow arg2, Function2 arg3) {
        Function1 v0 = FlowKt__DistinctKt.defaultKeySelector;
        Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Boolean>");
        return FlowKt__DistinctKt.distinctUntilChangedBy$FlowKt__DistinctKt(arg2, v0, TypeIntrinsics.beforeCheckcastToFunctionOfArity(arg3, 2));
    }

    public static final Flow distinctUntilChangedBy(Flow arg1, Function1 arg2) {
        return FlowKt__DistinctKt.distinctUntilChangedBy$FlowKt__DistinctKt(arg1, arg2, FlowKt__DistinctKt.defaultAreEquivalent);
    }

    private static final Flow distinctUntilChangedBy$FlowKt__DistinctKt(Flow arg2, Function1 arg3, Function2 arg4) {
        if((arg2 instanceof DistinctFlowImpl)) {
            Flow v0 = arg2;
            if(((DistinctFlowImpl)v0).keySelector == arg3 && ((DistinctFlowImpl)v0).areEquivalent == arg4) {
                return arg2;
            }
        }

        return new DistinctFlowImpl(arg2, arg3, arg4);
    }
}

