package androidx.compose.material.icons;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector$Builder;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001A*\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000BH\u0087\b\u001A4\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\f\u001A\u00020\r2\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000BH\u0086\b\u001AN\u0010\u000E\u001A\u00020\n*\u00020\n2\b\b\u0002\u0010\u000F\u001A\u00020\u00012\b\b\u0002\u0010\u0010\u001A\u00020\u00012\b\b\u0002\u0010\u0011\u001A\u00020\u00122\u0017\u0010\u0013\u001A\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\t¢\u0006\u0002\b\u000BH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\"\u0016\u0010\u0000\u001A\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u0082\u0002\u0007\n\u0005\b¡\u001E0\u0001¨\u0006\u0018"}, d2={"MaterialIconDimension", "", "getMaterialIconDimension$annotations", "()V", "materialIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "name", "", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "Lkotlin/ExtensionFunctionType;", "autoMirror", "", "materialPath", "fillAlpha", "strokeAlpha", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "pathBuilder", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "", "materialPath-YwgOQQI", "(Landroidx/compose/ui/graphics/vector/ImageVector$Builder;FFILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "material-icons-core_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class IconsKt {
    public static final float MaterialIconDimension = 24f;

    public static void getMaterialIconDimension$annotations() {
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use version with autoMirror instead.") public static final ImageVector materialIcon(String arg12, Function1 arg13) {
        return arg13.invoke(new Builder(arg12, Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null)).build();
    }

    public static final ImageVector materialIcon(String arg12, boolean arg13, Function1 arg14) {
        return arg14.invoke(new Builder(arg12, Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, arg13, 0x60, null)).build();
    }

    public static ImageVector materialIcon$default(String arg12, boolean arg13, Function1 arg14, int arg15, Object arg16) {
        return arg14.invoke(new Builder(arg12, Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null)).build();
    }

    public static final Builder materialPath-YwgOQQI(Builder arg21, float arg22, float arg23, int arg24, Function1 arg25) {
        SolidColor v8 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v13 = StrokeCap.Companion.getButt-KaPHkGw();
        int v14 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0 = new PathBuilder();
        arg25.invoke(v0);
        return Builder.addPath-oIyEayM$default(arg21, v0.getNodes(), arg24, "", ((Brush)v8), arg22, null, arg23, 1f, v13, v14, 1f, 0f, 0f, 0f, 0x3800, null);
    }

    public static Builder materialPath-YwgOQQI$default(Builder arg19, float arg20, float arg21, int arg22, Function1 arg23, int arg24, Object arg25) {
        float v1 = 1f;
        float v7 = (arg24 & 1) != 0 ? v1 : arg20;
        float v9 = (arg24 & 2) != 0 ? v1 : arg21;
        int v4 = (arg24 & 4) != 0 ? VectorKt.getDefaultFillType() : arg22;
        SolidColor v6 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v11 = StrokeCap.Companion.getButt-KaPHkGw();
        int v12 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0 = new PathBuilder();
        arg23.invoke(v0);
        return Builder.addPath-oIyEayM$default(arg19, v0.getNodes(), v4, "", ((Brush)v6), v7, null, v9, 1f, v11, v12, 1f, 0f, 0f, 0f, 0x3800, null);
    }
}

