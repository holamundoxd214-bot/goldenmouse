package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.shadow.Shadow;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A/\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001AC\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\u000BH\u0007¢\u0006\u0004\b\r\u0010\u000E\u001A\u001C\u0010\u000F\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0000\u001A\u00020\u0010H\u0007\u001A-\u0010\u000F\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0017\u0010\u0011\u001A\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\u0002\b\u0015H\u0007\u001A\u001C\u0010\u0016\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0000\u001A\u00020\u0010H\u0007\u001A-\u0010\u0016\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0017\u0010\u0011\u001A\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\u0002\b\u0015H\u0007\u001A\f\u0010\u0018\u001A\u00020\u0014*\u00020\u0019H\u0002¨\u0006\u001A"}, d2={"shadow", "Landroidx/compose/ui/Modifier;", "elevation", "Landroidx/compose/ui/unit/Dp;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "shadow-ziNgDLE", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;Z)Landroidx/compose/ui/Modifier;", "ambientColor", "Landroidx/compose/ui/graphics/Color;", "spotColor", "shadow-s4CzXII", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;ZJJ)Landroidx/compose/ui/Modifier;", "dropShadow", "Landroidx/compose/ui/graphics/shadow/Shadow;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/draw/DropShadowScope;", "", "Lkotlin/ExtensionFunctionType;", "innerShadow", "Landroidx/compose/ui/draw/InnerShadowScope;", "resetShadow", "Landroidx/compose/ui/draw/ShadowScope;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ShadowKt {
    public static final void access$resetShadow(ShadowScope arg0) {
        ShadowKt.resetShadow(arg0);
    }

    public static final Modifier dropShadow(Modifier arg1, Shape arg2, Shadow arg3) {
        return arg1.then(new SimpleDropShadowElement(arg2, arg3));
    }

    public static final Modifier dropShadow(Modifier arg1, Shape arg2, Function1 arg3) {
        return arg1.then(new BlockDropShadowElement(arg2, arg3));
    }

    public static final Modifier innerShadow(Modifier arg1, Shape arg2, Shadow arg3) {
        return arg1.then(new SimpleInnerShadowElement(arg2, arg3));
    }

    public static final Modifier innerShadow(Modifier arg1, Shape arg2, Function1 arg3) {
        return arg1.then(new BlockInnerShadowElement(arg2, arg3));
    }

    private static final void resetShadow(ShadowScope arg2) {
        arg2.setRadius(0f);
        arg2.setSpread(0f);
        arg2.setOffset-k-4lQ0M(Offset.Companion.getZero-F1C5BW0());
        arg2.setColor-8_81llA(Color.Companion.getBlack-0d7_KjU());
        arg2.setBrush(null);
        arg2.setAlpha(1f);
        arg2.setBlendMode-s9anfk8(BlendMode.Companion.getSrcOver-0nO6VwU());
    }

    public static final Modifier shadow-s4CzXII(Modifier arg10, float arg11, Shape arg12, boolean arg13, long arg14, long arg16) {
        if(Dp.compareTo-0680j_4(arg11, Dp.constructor-impl(0f)) <= 0) {
            if(arg13) {
            }
            else {
                return arg10;
            }
        }

        return arg10.then(new ShadowGraphicsLayerElement(arg11, arg12, arg13, arg14, arg16, null));
    }

    public static Modifier shadow-s4CzXII$default(Modifier arg6, float arg7, Shape arg8, boolean arg9, long arg10, long arg12, int arg14, Object arg15) {
        boolean v1;
        Shape v0 = (arg14 & 2) != 0 ? RectangleShapeKt.getRectangleShape() : arg8;
        if((arg14 & 4) == 0) {
            v1 = arg9;
        }
        else if(Dp.compareTo-0680j_4(arg7, Dp.constructor-impl(0f)) > 0) {
            v1 = true;
        }
        else {
            v1 = false;
        }

        long v2 = (arg14 & 8) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : arg10;
        long v14 = (arg14 & 16) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : arg12;
        return ShadowKt.shadow-s4CzXII(arg6, arg7, v0, v1, v2, v14);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Replace with shadow which accepts ambientColor and spotColor parameters", replaceWith="<_subannotation>") public static final Modifier shadow-ziNgDLE(Modifier arg8, float arg9, Shape arg10, boolean arg11) {
        return ShadowKt.shadow-s4CzXII(arg8, arg9, arg10, arg11, GraphicsLayerScopeKt.getDefaultShadowColor(), GraphicsLayerScopeKt.getDefaultShadowColor());
    }

    public static Modifier shadow-ziNgDLE$default(Modifier arg0, float arg1, Shape arg2, boolean arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = RectangleShapeKt.getRectangleShape();
        }

        if((arg4 & 4) != 0) {
            arg3 = Dp.compareTo-0680j_4(arg1, Dp.constructor-impl(0f)) > 0 ? true : false;
        }

        return ShadowKt.shadow-ziNgDLE(arg0, arg1, arg2, arg3);
    }
}

