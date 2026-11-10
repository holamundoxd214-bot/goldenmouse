package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_localActivity", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocalActivity", "Landroidx/compose/material/icons/Icons$Outlined;", "getLocalActivity", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LocalActivityKt {
    private static ImageVector _localActivity;

    static {
    }

    public static final ImageVector getLocalActivity(Outlined arg19) {
        ImageVector v0 = LocalActivityKt._localActivity;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.LocalActivity", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 10f);
        v12.lineTo(22f, 6f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.lineTo(4f, 4f);
        v12.curveToRelative(-1.1f, 0f, -1.99f, 0.9f, -1.99f, 2f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(1.1f, 0f, 1.99f, 0.9f, 1.99f, 2f);
        v12.reflectiveCurveToRelative(-0.89f, 2f, -2f, 2f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-4f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.reflectiveCurveToRelative(0.9f, -2f, 2f, -2f);
        v12.close();
        v12.moveTo(20f, 8.54f);
        v12.curveToRelative(-1.19f, 0.69f, -2f, 1.99f, -2f, 3.46f);
        v12.reflectiveCurveToRelative(0.81f, 2.77f, 2f, 3.46f);
        v12.lineTo(20f, 18f);
        v12.lineTo(4f, 18f);
        v12.verticalLineToRelative(-2.54f);
        v12.curveToRelative(1.19f, -0.69f, 2f, -1.99f, 2f, -3.46f);
        v12.curveToRelative(0f, -1.48f, -0.8f, -2.77f, -1.99f, -3.46f);
        v12.lineTo(4f, 6f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineToRelative(2.54f);
        v12.close();
        v12.moveTo(9.07f, 16f);
        v12.lineTo(12f, 14.12f);
        v12.lineTo(14.93f, 16f);
        v12.lineToRelative(-0.89f, -3.36f);
        v12.lineToRelative(2.69f, -2.2f);
        v12.lineToRelative(-3.47f, -0.21f);
        v12.lineTo(12f, 7f);
        v12.lineToRelative(-1.27f, 3.22f);
        v12.lineToRelative(-3.47f, 0.21f);
        v12.lineToRelative(2.69f, 2.2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LocalActivityKt._localActivity = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

