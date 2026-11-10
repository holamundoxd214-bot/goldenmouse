package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons$Rounded;
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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_rvHookup", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RvHookup", "Landroidx/compose/material/icons/Icons$Rounded;", "getRvHookup", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RvHookupKt {
    private static ImageVector _rvHookup;

    static {
    }

    public static final ImageVector getRvHookup(Rounded arg19) {
        ImageVector v0 = RvHookupKt._rvHookup;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.RvHookup", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 17f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(-6f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.lineTo(7f, 9f);
        v12.verticalLineToRelative(-0.74f);
        v12.curveToRelative(0f, -0.46f, -0.56f, -0.7f, -0.89f, -0.37f);
        v12.lineTo(4.37f, 9.63f);
        v12.curveToRelative(-0.2f, 0.2f, -0.2f, 0.53f, 0f, 0.74f);
        v12.lineToRelative(1.74f, 1.74f);
        v12.curveToRelative(0.33f, 0.33f, 0.89f, 0.1f, 0.89f, -0.37f);
        v12.lineTo(7f, 11f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(3f);
        v12.lineTo(5f, 14f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f);
        v12.reflectiveCurveToRelative(3f, -1.34f, 3f, -3f);
        v12.horizontalLineToRelative(7f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.close();
        v12.moveTo(11f, 20f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.close();
        v12.moveTo(18f, 14f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(2f);
        v12.close();
        v12.moveTo(10f, 6f);
        v12.horizontalLineToRelative(7f);
        v12.verticalLineToRelative(0.74f);
        v12.curveToRelative(0f, 0.46f, 0.56f, 0.7f, 0.89f, 0.37f);
        v12.lineToRelative(1.74f, -1.74f);
        v12.curveToRelative(0.2f, -0.2f, 0.2f, -0.53f, 0f, -0.74f);
        v12.lineToRelative(-1.74f, -1.74f);
        v12.curveToRelative(-0.33f, -0.33f, -0.89f, -0.1f, -0.89f, 0.37f);
        v12.lineTo(17f, 4f);
        v12.horizontalLineToRelative(-7f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RvHookupKt._rvHookup = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

