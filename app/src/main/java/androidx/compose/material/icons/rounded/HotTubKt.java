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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_hotTub", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HotTub", "Landroidx/compose/material/icons/Icons$Rounded;", "getHotTub", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HotTubKt {
    private static ImageVector _hotTub;

    static {
    }

    public static final ImageVector getHotTub(Rounded arg20) {
        ImageVector v0 = HotTubKt._hotTub;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.HotTub", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7f, 6f);
        v12.moveToRelative(-2f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, 4f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, -4f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(21f, 12f);
        v12.horizontalLineToRelative(-9.85f);
        v12.curveToRelative(-0.31f, -0.22f, -0.59f, -0.46f, -0.82f, -0.72f);
        v12.lineToRelative(-1.4f, -1.55f);
        v12.curveToRelative(-0.19f, -0.21f, -0.43f, -0.38f, -0.69f, -0.5f);
        v12.curveToRelative(-0.29f, -0.14f, -0.62f, -0.23f, -0.96f, -0.23f);
        v12.horizontalLineToRelative(-0.03f);
        v12.curveTo(6.01f, 9f, 5f, 10.01f, 5f, 11.25f);
        v12.lineTo(5f, 12f);
        v12.lineTo(3f, 12f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(7f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-7f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.close();
        v12.moveTo(7f, 19f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-4f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(4f);
        v12.close();
        v12.moveTo(11f, 19f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-4f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(4f);
        v12.close();
        v12.moveTo(15f, 19f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-4f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(4f);
        v12.close();
        v12.moveTo(19f, 19f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-4f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(4f);
        v12.close();
        v12.moveTo(15.06f, 10f);
        v12.curveToRelative(0.5f, 0f, 0.93f, -0.39f, 0.94f, -0.89f);
        v12.curveToRelative(0.04f, -1.4f, -0.58f, -2.48f, -1.35f, -3.25f);
        v12.curveToRelative(-0.65f, -0.72f, -0.8f, -1.27f, -0.77f, -1.91f);
        v12.curveToRelative(0.02f, -0.52f, -0.41f, -0.95f, -0.94f, -0.95f);
        v12.curveToRelative(-0.5f, 0f, -0.93f, 0.4f, -0.94f, 0.9f);
        v12.curveToRelative(-0.03f, 1.29f, 0.5f, 2.43f, 1.35f, 3.25f);
        v12.curveToRelative(0.61f, 0.59f, 0.78f, 1.27f, 0.78f, 1.89f);
        v12.curveToRelative(-0.01f, 0.52f, 0.4f, 0.96f, 0.93f, 0.96f);
        v12.close();
        v12.moveTo(19.059999f, 10f);
        v12.curveToRelative(0.5f, 0f, 0.93f, -0.39f, 0.94f, -0.89f);
        v12.curveToRelative(0.04f, -1.4f, -0.58f, -2.48f, -1.35f, -3.25f);
        v12.curveToRelative(-0.65f, -0.72f, -0.8f, -1.27f, -0.77f, -1.91f);
        v12.curveToRelative(0.02f, -0.52f, -0.41f, -0.95f, -0.94f, -0.95f);
        v12.curveToRelative(-0.5f, 0f, -0.93f, 0.4f, -0.94f, 0.9f);
        v12.curveToRelative(-0.03f, 1.29f, 0.5f, 2.43f, 1.35f, 3.25f);
        v12.curveToRelative(0.61f, 0.59f, 0.78f, 1.27f, 0.78f, 1.89f);
        v12.curveToRelative(-0.01f, 0.52f, 0.4f, 0.96f, 0.93f, 0.96f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HotTubKt._hotTub = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

