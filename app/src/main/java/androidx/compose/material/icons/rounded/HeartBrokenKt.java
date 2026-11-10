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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_heartBroken", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HeartBroken", "Landroidx/compose/material/icons/Icons$Rounded;", "getHeartBroken", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HeartBrokenKt {
    private static ImageVector _heartBroken;

    static {
    }

    public static final ImageVector getHeartBroken(Rounded arg19) {
        ImageVector v0 = HeartBrokenKt._heartBroken;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.HeartBroken", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.57f, 3.95f);
        v12.curveToRelative(-1.92f, -1.29f, -4.08f, -1.17f, -5.8f, -0.26f);
        v12.lineTo(12f, 9f);
        v12.horizontalLineToRelative(1.66f);
        v12.curveToRelative(0.67f, 0f, 1.15f, 0.65f, 0.96f, 1.29f);
        v12.lineToRelative(-1.82f, 6.07f);
        v12.curveToRelative(-0.09f, 0.29f, -0.52f, 0.2f, -0.49f, -0.1f);
        v12.lineTo(13f, 10f);
        v12.horizontalLineToRelative(-1.67f);
        v12.curveToRelative(-0.66f, 0f, -1.14f, -0.64f, -0.96f, -1.27f);
        v12.lineToRelative(1.18f, -4.11f);
        v12.curveToRelative(0f, 0f, 0f, 0f, 0f, 0f);
        v12.curveTo(9.7f, 2.89f, 6.71f, 2.32f, 4.27f, 4.04f);
        v12.curveTo(2.82f, 5.07f, 2f, 6.7f, 2f, 8.49f);
        v12.curveToRelative(-0.01f, 3.81f, 3.53f, 6.71f, 8.66f, 11.3f);
        v12.curveToRelative(0.76f, 0.68f, 1.92f, 0.69f, 2.69f, 0.01f);
        v12.curveToRelative(4.98f, -4.42f, 8.87f, -7.58f, 8.64f, -11.62f);
        v12.curveTo(21.9f, 6.45f, 21f, 4.92f, 19.57f, 3.95f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HeartBrokenKt._heartBroken = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

