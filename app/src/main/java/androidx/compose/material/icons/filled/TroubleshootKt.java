package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_troubleshoot", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Troubleshoot", "Landroidx/compose/material/icons/Icons$Filled;", "getTroubleshoot", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TroubleshootKt {
    private static ImageVector _troubleshoot;

    static {
    }

    public static final ImageVector getTroubleshoot(Filled arg19) {
        ImageVector v0 = TroubleshootKt._troubleshoot;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Troubleshoot", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 20.59f);
        v12.lineToRelative(-4.69f, -4.69f);
        v12.curveTo(18.370001f, 14.55f, 19f, 12.85f, 19f, 11f);
        v12.curveToRelative(0f, -4.42f, -3.58f, -8f, -8f, -8f);
        v12.curveToRelative(-4.08f, 0f, -7.44f, 3.05f, -7.93f, 7f);
        v12.horizontalLineToRelative(2.02f);
        v12.curveTo(5.57f, 7.17f, 8.03f, 5f, 11f, 5f);
        v12.curveToRelative(3.31f, 0f, 6f, 2.69f, 6f, 6f);
        v12.reflectiveCurveToRelative(-2.69f, 6f, -6f, 6f);
        v12.curveToRelative(-2.42f, 0f, -4.5f, -1.44f, -5.45f, -3.5f);
        v12.horizontalLineTo(3.4f);
        v12.curveTo(4.45f, 16.690001f, 7.46f, 19f, 11f, 19f);
        v12.curveToRelative(1.85f, 0f, 3.55f, -0.63f, 4.9f, -1.69f);
        v12.lineTo(20.59f, 22f);
        v12.lineTo(22f, 20.59f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(8.43f, 9.69f);
        v0_1.lineToRelative(1.22f, 5.31f);
        v0_1.lineToRelative(1.64f, 0f);
        v0_1.lineToRelative(1.26f, -3.78f);
        v0_1.lineToRelative(0.95f, 2.28f);
        v0_1.lineToRelative(2f, 0f);
        v0_1.lineToRelative(0f, -1.5f);
        v0_1.lineToRelative(-1f, 0f);
        v0_1.lineToRelative(-1.25f, -3f);
        v0_1.lineToRelative(-1.54f, 0f);
        v0_1.lineToRelative(-1.12f, 3.37f);
        v0_1.lineToRelative(-1.24f, -5.37f);
        v0_1.lineToRelative(-1.65f, 0f);
        v0_1.lineToRelative(-1.25f, 4f);
        v0_1.lineToRelative(-5.45f, 0f);
        v0_1.lineToRelative(0f, 1.5f);
        v0_1.lineToRelative(6.55f, 0f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TroubleshootKt._troubleshoot = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

