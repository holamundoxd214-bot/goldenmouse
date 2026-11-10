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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_castConnected", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CastConnected", "Landroidx/compose/material/icons/Icons$Rounded;", "getCastConnected", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CastConnectedKt {
    private static ImageVector _castConnected;

    static {
    }

    public static final ImageVector getCastConnected(Rounded arg19) {
        ImageVector v0 = CastConnectedKt._castConnected;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.CastConnected", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 16f);
        v12.lineTo(19f, 8f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.lineTo(6f, 7f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(0.63f);
        v12.curveToRelative(3.96f, 1.28f, 7.09f, 4.41f, 8.37f, 8.37f);
        v12.lineTo(18f, 17f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.close();
        v12.moveTo(21f, 3f);
        v12.lineTo(3f, 3f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.lineTo(3f, 6f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(-5f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(23f, 5f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(1f, 18f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0f, -0.62f, -0.19f, -1.2f, -0.51f, -1.68f);
        v12.curveTo(2.95f, 18.52f, 2.04f, 18f, 1f, 18f);
        v12.close();
        v12.moveTo(2.14f, 14.09f);
        v12.curveToRelative(-0.6f, -0.1f, -1.14f, 0.39f, -1.14f, 1f);
        v12.curveToRelative(0f, 0.49f, 0.36f, 0.9f, 0.85f, 0.98f);
        v12.curveToRelative(2.08f, 0.36f, 3.72f, 2f, 4.08f, 4.08f);
        v12.curveToRelative(0.08f, 0.49f, 0.49f, 0.85f, 0.98f, 0.85f);
        v12.curveToRelative(0.61f, 0f, 1.09f, -0.54f, 1f, -1.14f);
        v12.curveToRelative(-0.48f, -2.96f, -2.82f, -5.29f, -5.77f, -5.77f);
        v12.close();
        v12.moveTo(2.1f, 10.05f);
        v12.curveToRelative(-0.59f, -0.05f, -1.1f, 0.41f, -1.1f, 1f);
        v12.curveToRelative(0f, 0.51f, 0.38f, 0.94f, 0.88f, 0.99f);
        v12.curveToRelative(4.27f, 0.41f, 7.67f, 3.81f, 8.08f, 8.08f);
        v12.curveToRelative(0.05f, 0.5f, 0.48f, 0.87f, 0.99f, 0.87f);
        v12.curveToRelative(0.6f, 0f, 1.06f, -0.52f, 1f, -1.11f);
        v12.curveToRelative(-0.53f, -5.19f, -4.66f, -9.31f, -9.85f, -9.83f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CastConnectedKt._castConnected = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

