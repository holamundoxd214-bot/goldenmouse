package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_emergency", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Emergency", "Landroidx/compose/material/icons/Icons$TwoTone;", "getEmergency", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EmergencyKt {
    private static ImageVector _emergency;

    static {
    }

    public static final ImageVector getEmergency(TwoTone arg19) {
        ImageVector v0 = EmergencyKt._emergency;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Emergency", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.43f, 16.870001f);
        v12.lineToRelative(-4.68f, -2.7f);
        v12.curveTo(13.42f, 13.97f, 13f, 14.21f, 13f, 14.6f);
        v12.verticalLineTo(20f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-5.4f);
        v12.curveToRelative(0f, -0.38f, -0.42f, -0.63f, -0.75f, -0.43f);
        v12.lineToRelative(-4.68f, 2.7f);
        v12.lineToRelative(-1f, -1.73f);
        v12.lineToRelative(4.68f, -2.7f);
        v12.curveToRelative(0.33f, -0.19f, 0.33f, -0.67f, 0f, -0.87f);
        v12.lineToRelative(-4.68f, -2.7f);
        v12.lineToRelative(1f, -1.73f);
        v12.lineToRelative(4.68f, 2.7f);
        v12.curveTo(10.58f, 10.03f, 11f, 9.79f, 11f, 9.4f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(5.4f);
        v12.curveToRelative(0f, 0.38f, 0.42f, 0.63f, 0.75f, 0.43f);
        v12.lineToRelative(4.68f, -2.7f);
        v12.lineToRelative(1f, 1.73f);
        v12.lineToRelative(-4.68f, 2.7f);
        v12.curveToRelative(-0.33f, 0.19f, -0.33f, 0.67f, 0f, 0.87f);
        v12.lineToRelative(4.68f, 2.7f);
        v12.lineTo(18.43f, 16.870001f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(21.290001f, 13.9f);
        v12.lineTo(18f, 12f);
        v12.lineToRelative(3.29f, -1.9f);
        v12.curveToRelative(0.48f, -0.28f, 0.64f, -0.89f, 0.37f, -1.37f);
        v12.lineToRelative(-2f, -3.46f);
        v12.curveToRelative(-0.28f, -0.48f, -0.89f, -0.64f, -1.37f, -0.37f);
        v12.lineTo(15f, 6.8f);
        v12.verticalLineTo(3f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-4f);
        v12.curveTo(9.45f, 2f, 9f, 2.45f, 9f, 3f);
        v12.verticalLineToRelative(3.8f);
        v12.lineTo(5.71f, 4.9f);
        v12.curveTo(5.23f, 4.63f, 4.62f, 4.79f, 4.34f, 5.27f);
        v12.lineToRelative(-2f, 3.46f);
        v12.curveTo(2.06f, 9.21f, 2.23f, 9.82f, 2.71f, 10.1f);
        v12.lineTo(6f, 12f);
        v12.lineToRelative(-3.29f, 1.9f);
        v12.curveToRelative(-0.48f, 0.28f, -0.64f, 0.89f, -0.37f, 1.37f);
        v12.lineToRelative(2f, 3.46f);
        v12.curveToRelative(0.28f, 0.48f, 0.89f, 0.64f, 1.37f, 0.37f);
        v12.lineTo(9f, 17.200001f);
        v12.verticalLineTo(21f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-3.8f);
        v12.lineToRelative(3.29f, 1.9f);
        v12.curveToRelative(0.48f, 0.28f, 1.09f, 0.11f, 1.37f, -0.37f);
        v12.lineToRelative(2f, -3.46f);
        v12.curveTo(21.940001f, 14.79f, 21.77f, 14.18f, 21.290001f, 13.9f);
        v12.close();
        v12.moveTo(18.43f, 16.870001f);
        v12.lineToRelative(-4.68f, -2.7f);
        v12.curveTo(13.42f, 13.97f, 13f, 14.21f, 13f, 14.6f);
        v12.verticalLineTo(20f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-5.4f);
        v12.curveToRelative(0f, -0.38f, -0.42f, -0.63f, -0.75f, -0.43f);
        v12.lineToRelative(-4.68f, 2.7f);
        v12.lineToRelative(-1f, -1.73f);
        v12.lineToRelative(4.68f, -2.7f);
        v12.curveToRelative(0.33f, -0.19f, 0.33f, -0.67f, 0f, -0.87f);
        v12.lineToRelative(-4.68f, -2.7f);
        v12.lineToRelative(1f, -1.73f);
        v12.lineToRelative(4.68f, 2.7f);
        v12.curveTo(10.58f, 10.03f, 11f, 9.79f, 11f, 9.4f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(5.4f);
        v12.curveToRelative(0f, 0.38f, 0.42f, 0.63f, 0.75f, 0.43f);
        v12.lineToRelative(4.68f, -2.7f);
        v12.lineToRelative(1f, 1.73f);
        v12.lineToRelative(-4.68f, 2.7f);
        v12.curveToRelative(-0.33f, 0.19f, -0.33f, 0.67f, 0f, 0.87f);
        v12.lineToRelative(4.68f, 2.7f);
        v12.lineTo(18.43f, 16.870001f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EmergencyKt._emergency = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

