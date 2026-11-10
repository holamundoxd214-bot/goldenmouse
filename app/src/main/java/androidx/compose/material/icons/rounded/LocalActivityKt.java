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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_localActivity", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocalActivity", "Landroidx/compose/material/icons/Icons$Rounded;", "getLocalActivity", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LocalActivityKt {
    private static ImageVector _localActivity;

    static {
    }

    public static final ImageVector getLocalActivity(Rounded arg19) {
        ImageVector v0 = LocalActivityKt._localActivity;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.LocalActivity", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 12f);
        v12.curveToRelative(0f, -0.76f, 0.43f, -1.42f, 1.06f, -1.76f);
        v12.curveToRelative(0.6f, -0.33f, 0.94f, -1.01f, 0.94f, -1.7f);
        v12.lineTo(22f, 6f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.lineTo(4f, 4f);
        v12.curveToRelative(-1.1f, 0f, -1.99f, 0.89f, -1.99f, 1.99f);
        v12.verticalLineToRelative(2.55f);
        v12.curveToRelative(0f, 0.69f, 0.33f, 1.37f, 0.94f, 1.69f);
        v12.curveTo(3.58f, 10.58f, 4f, 11.24f, 4f, 12f);
        v12.reflectiveCurveToRelative(-0.43f, 1.43f, -1.06f, 1.76f);
        v12.curveToRelative(-0.6f, 0.33f, -0.94f, 1.01f, -0.94f, 1.7f);
        v12.lineTo(2f, 18f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-2.54f);
        v12.curveToRelative(0f, -0.69f, -0.34f, -1.37f, -0.94f, -1.7f);
        v12.curveToRelative(-0.63f, -0.34f, -1.06f, -1f, -1.06f, -1.76f);
        v12.close();
        v12.moveTo(14.5f, 16.1f);
        v12.lineTo(12f, 14.5f);
        v12.lineToRelative(-2.5f, 1.61f);
        v12.curveToRelative(-0.38f, 0.24f, -0.87f, -0.11f, -0.75f, -0.55f);
        v12.lineToRelative(0.75f, -2.88f);
        v12.lineToRelative(-2.3f, -1.88f);
        v12.curveToRelative(-0.35f, -0.29f, -0.17f, -0.86f, 0.29f, -0.89f);
        v12.lineToRelative(2.96f, -0.17f);
        v12.lineToRelative(1.08f, -2.75f);
        v12.curveToRelative(0.17f, -0.42f, 0.77f, -0.42f, 0.93f, 0f);
        v12.lineToRelative(1.08f, 2.76f);
        v12.lineToRelative(2.96f, 0.17f);
        v12.curveToRelative(0.45f, 0.03f, 0.64f, 0.6f, 0.29f, 0.89f);
        v12.lineToRelative(-2.3f, 1.88f);
        v12.lineToRelative(0.76f, 2.86f);
        v12.curveToRelative(0.12f, 0.45f, -0.37f, 0.8f, -0.75f, 0.55f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LocalActivityKt._localActivity = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

