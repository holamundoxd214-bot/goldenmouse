package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\'\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001A\'\u0010\u0007\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003H\u0007¢\u0006\u0004\b\b\u0010\u0006\u001A#\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0017\u0010\u0000\u001A\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\t¢\u0006\u0002\b\f\u001A#\u0010\u0007\u001A\u00020\u0001*\u00020\u00012\u0017\u0010\u0000\u001A\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\t¢\u0006\u0002\b\f¨\u0006\r"}, d2={"offset", "Landroidx/compose/ui/Modifier;", "x", "Landroidx/compose/ui/unit/Dp;", "y", "offset-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "absoluteOffset", "absoluteOffset-VpY3zN4", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/IntOffset;", "Lkotlin/ExtensionFunctionType;", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class OffsetKt {
    public static final Modifier absoluteOffset(Modifier arg3, Function1 arg4) {
        return arg3.then(new OffsetPxElement(arg4, false, new OffsetKt$$ExternalSyntheticLambda1(arg4)));
    }

    static final Unit absoluteOffset$lambda$0(Function1 arg1, InspectorInfo arg2) {
        arg2.setName("absoluteOffset");
        arg2.getProperties().set("offset", arg1);
        return Unit.INSTANCE;
    }

    public static final Modifier absoluteOffset-VpY3zN4(Modifier arg6, float arg7, float arg8) {
        return arg6.then(new OffsetElement(arg7, arg8, false, new OffsetKt$$ExternalSyntheticLambda2(arg7, arg8), null));
    }

    public static Modifier absoluteOffset-VpY3zN4$default(Modifier arg1, float arg2, float arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg2 = Dp.constructor-impl(0f);
        }

        if((arg4 & 2) != 0) {
            arg3 = Dp.constructor-impl(0f);
        }

        return OffsetKt.absoluteOffset-VpY3zN4(arg1, arg2, arg3);
    }

    static final Unit absoluteOffset_VpY3zN4$lambda$0(float arg2, float arg3, InspectorInfo arg4) {
        arg4.setName("absoluteOffset");
        arg4.getProperties().set("x", Dp.box-impl(arg2));
        arg4.getProperties().set("y", Dp.box-impl(arg3));
        return Unit.INSTANCE;
    }

    public static final Modifier offset(Modifier arg3, Function1 arg4) {
        return arg3.then(new OffsetPxElement(arg4, true, new OffsetKt$$ExternalSyntheticLambda0(arg4)));
    }

    static final Unit offset$lambda$0(Function1 arg1, InspectorInfo arg2) {
        arg2.setName("offset");
        arg2.getProperties().set("offset", arg1);
        return Unit.INSTANCE;
    }

    public static final Modifier offset-VpY3zN4(Modifier arg6, float arg7, float arg8) {
        return arg6.then(new OffsetElement(arg7, arg8, true, new OffsetKt$$ExternalSyntheticLambda3(arg7, arg8), null));
    }

    public static Modifier offset-VpY3zN4$default(Modifier arg1, float arg2, float arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg2 = Dp.constructor-impl(0f);
        }

        if((arg4 & 2) != 0) {
            arg3 = Dp.constructor-impl(0f);
        }

        return OffsetKt.offset-VpY3zN4(arg1, arg2, arg3);
    }

    static final Unit offset_VpY3zN4$lambda$0(float arg2, float arg3, InspectorInfo arg4) {
        arg4.setName("offset");
        arg4.getProperties().set("x", Dp.box-impl(arg2));
        arg4.getProperties().set("y", Dp.box-impl(arg3));
        return Unit.INSTANCE;
    }
}

