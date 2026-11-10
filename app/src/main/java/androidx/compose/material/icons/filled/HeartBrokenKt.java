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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_heartBroken", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HeartBroken", "Landroidx/compose/material/icons/Icons$Filled;", "getHeartBroken", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HeartBrokenKt {
    private static ImageVector _heartBroken;

    static {
    }

    public static final ImageVector getHeartBroken(Filled arg19) {
        ImageVector v0 = HeartBrokenKt._heartBroken;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.HeartBroken", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16.5f, 3f);
        v12.curveToRelative(-0.96f, 0f, -1.9f, 0.25f, -2.73f, 0.69f);
        v12.lineTo(12f, 9f);
        v12.horizontalLineToRelative(3f);
        v12.lineToRelative(-3f, 10f);
        v12.lineToRelative(1f, -9f);
        v12.horizontalLineToRelative(-3f);
        v12.lineToRelative(1.54f, -5.39f);
        v12.curveTo(10.47f, 3.61f, 9.01f, 3f, 7.5f, 3f);
        v12.curveTo(4.42f, 3f, 2f, 5.42f, 2f, 8.5f);
        v12.curveToRelative(0f, 4.13f, 4.16f, 7.18f, 10f, 12.5f);
        v12.curveToRelative(5.47f, -4.94f, 10f, -8.26f, 10f, -12.5f);
        v12.curveTo(22f, 5.42f, 19.58f, 3f, 16.5f, 3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HeartBrokenKt._heartBroken = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

