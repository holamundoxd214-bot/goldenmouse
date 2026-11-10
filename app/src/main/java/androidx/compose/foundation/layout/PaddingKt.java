package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u001A;\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001A\'\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u0003H\u0007¢\u0006\u0004\b\u000B\u0010\f\u001A\u001B\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001A\u00020\u0003H\u0007¢\u0006\u0004\b\u000E\u0010\u000F\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001A\u00020\u0011H\u0007\u001A;\u0010\u0012\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0013\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0014\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0003H\u0007¢\u0006\u0004\b\u0015\u0010\b\u001A\u0019\u0010\u0016\u001A\u00020\u0003*\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001A\u0019\u0010\u001A\u001A\u00020\u0003*\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001A\u0017\u0010\u001B\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\u0003H\u0007¢\u0006\u0004\b\u001C\u0010\u001D\u001A#\u0010\u001B\u001A\u00020\u00112\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u0003H\u0007¢\u0006\u0004\b\u001E\u0010\u001F\u001A7\u0010\u001B\u001A\u00020\u00112\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0003H\u0007¢\u0006\u0004\b \u0010!¨\u0006\""}, d2={"padding", "Landroidx/compose/ui/Modifier;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "padding-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "horizontal", "vertical", "padding-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "all", "padding-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "absolutePadding", "left", "right", "absolutePadding-qDBjuR0", "calculateStartPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateEndPadding", "PaddingValues", "PaddingValues-0680j_4", "(F)Landroidx/compose/foundation/layout/PaddingValues;", "PaddingValues-YgX7TsA", "(FF)Landroidx/compose/foundation/layout/PaddingValues;", "PaddingValues-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PaddingKt {
    public static final PaddingValues PaddingValues-0680j_4(float arg6) {
        return new PaddingValuesImpl(arg6, arg6, arg6, arg6, null);
    }

    public static final PaddingValues PaddingValues-YgX7TsA(float arg6, float arg7) {
        return new PaddingValuesImpl(arg6, arg7, arg6, arg7, null);
    }

    public static PaddingValues PaddingValues-YgX7TsA$default(float arg1, float arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = Dp.constructor-impl(0f);
        }

        if((arg3 & 2) != 0) {
            arg2 = Dp.constructor-impl(0f);
        }

        return PaddingKt.PaddingValues-YgX7TsA(arg1, arg2);
    }

    public static final PaddingValues PaddingValues-a9UjIt4(float arg6, float arg7, float arg8, float arg9) {
        return new PaddingValuesImpl(arg6, arg7, arg8, arg9, null);
    }

    public static PaddingValues PaddingValues-a9UjIt4$default(float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = Dp.constructor-impl(0f);
        }

        if((arg5 & 2) != 0) {
            arg2 = Dp.constructor-impl(0f);
        }

        if((arg5 & 4) != 0) {
            arg3 = Dp.constructor-impl(0f);
        }

        if((arg5 & 8) != 0) {
            arg4 = Dp.constructor-impl(0f);
        }

        return PaddingKt.PaddingValues-a9UjIt4(arg1, arg2, arg3, arg4);
    }

    public static final Modifier absolutePadding-qDBjuR0(Modifier arg8, float arg9, float arg10, float arg11, float arg12) {
        return arg8.then(new PaddingElement(arg9, arg10, arg11, arg12, false, new PaddingKt$$ExternalSyntheticLambda2(arg9, arg10, arg11, arg12), null));
    }

    public static Modifier absolutePadding-qDBjuR0$default(Modifier arg1, float arg2, float arg3, float arg4, float arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg2 = Dp.constructor-impl(0f);
        }

        if((arg6 & 2) != 0) {
            arg3 = Dp.constructor-impl(0f);
        }

        if((arg6 & 4) != 0) {
            arg4 = Dp.constructor-impl(0f);
        }

        if((arg6 & 8) != 0) {
            arg5 = Dp.constructor-impl(0f);
        }

        return PaddingKt.absolutePadding-qDBjuR0(arg1, arg2, arg3, arg4, arg5);
    }

    static final Unit absolutePadding_qDBjuR0$lambda$0(float arg2, float arg3, float arg4, float arg5, InspectorInfo arg6) {
        arg6.setName("absolutePadding");
        arg6.getProperties().set("left", Dp.box-impl(arg2));
        arg6.getProperties().set("top", Dp.box-impl(arg3));
        arg6.getProperties().set("right", Dp.box-impl(arg4));
        arg6.getProperties().set("bottom", Dp.box-impl(arg5));
        return Unit.INSTANCE;
    }

    public static final float calculateEndPadding(PaddingValues arg1, LayoutDirection arg2) {
        if(arg2 == LayoutDirection.Ltr) {
            return arg1.calculateRightPadding-u2uoSUM(arg2);
        }

        return arg1.calculateLeftPadding-u2uoSUM(arg2);
    }

    public static final float calculateStartPadding(PaddingValues arg1, LayoutDirection arg2) {
        if(arg2 == LayoutDirection.Ltr) {
            return arg1.calculateLeftPadding-u2uoSUM(arg2);
        }

        return arg1.calculateRightPadding-u2uoSUM(arg2);
    }

    public static final Modifier padding(Modifier arg2, PaddingValues arg3) {
        return arg2.then(new PaddingValuesElement(arg3, new PaddingKt$$ExternalSyntheticLambda1(arg3)));
    }

    static final Unit padding$lambda$0(PaddingValues arg1, InspectorInfo arg2) {
        arg2.setName("padding");
        arg2.getProperties().set("paddingValues", arg1);
        return Unit.INSTANCE;
    }

    public static final Modifier padding-3ABfNKs(Modifier arg8, float arg9) {
        return arg8.then(new PaddingElement(arg9, arg9, arg9, arg9, true, new PaddingKt$$ExternalSyntheticLambda4(arg9), null));
    }

    public static final Modifier padding-VpY3zN4(Modifier arg8, float arg9, float arg10) {
        return arg8.then(new PaddingElement(arg9, arg10, arg9, arg10, true, new PaddingKt$$ExternalSyntheticLambda3(arg9, arg10), null));
    }

    public static Modifier padding-VpY3zN4$default(Modifier arg1, float arg2, float arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg2 = Dp.constructor-impl(0f);
        }

        if((arg4 & 2) != 0) {
            arg3 = Dp.constructor-impl(0f);
        }

        return PaddingKt.padding-VpY3zN4(arg1, arg2, arg3);
    }

    public static final Modifier padding-qDBjuR0(Modifier arg8, float arg9, float arg10, float arg11, float arg12) {
        return arg8.then(new PaddingElement(arg9, arg10, arg11, arg12, true, new PaddingKt$$ExternalSyntheticLambda0(arg9, arg10, arg11, arg12), null));
    }

    public static Modifier padding-qDBjuR0$default(Modifier arg1, float arg2, float arg3, float arg4, float arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg2 = Dp.constructor-impl(0f);
        }

        if((arg6 & 2) != 0) {
            arg3 = Dp.constructor-impl(0f);
        }

        if((arg6 & 4) != 0) {
            arg4 = Dp.constructor-impl(0f);
        }

        if((arg6 & 8) != 0) {
            arg5 = Dp.constructor-impl(0f);
        }

        return PaddingKt.padding-qDBjuR0(arg1, arg2, arg3, arg4, arg5);
    }

    static final Unit padding_3ABfNKs$lambda$0(float arg1, InspectorInfo arg2) {
        arg2.setName("padding");
        arg2.setValue(Dp.box-impl(arg1));
        return Unit.INSTANCE;
    }

    static final Unit padding_VpY3zN4$lambda$0(float arg2, float arg3, InspectorInfo arg4) {
        arg4.setName("padding");
        arg4.getProperties().set("horizontal", Dp.box-impl(arg2));
        arg4.getProperties().set("vertical", Dp.box-impl(arg3));
        return Unit.INSTANCE;
    }

    static final Unit padding_qDBjuR0$lambda$0(float arg2, float arg3, float arg4, float arg5, InspectorInfo arg6) {
        arg6.setName("padding");
        arg6.getProperties().set("start", Dp.box-impl(arg2));
        arg6.getProperties().set("top", Dp.box-impl(arg3));
        arg6.getProperties().set("end", Dp.box-impl(arg4));
        arg6.getProperties().set("bottom", Dp.box-impl(arg5));
        return Unit.INSTANCE;
    }
}

