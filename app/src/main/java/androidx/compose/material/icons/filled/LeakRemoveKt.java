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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_leakRemove", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LeakRemove", "Landroidx/compose/material/icons/Icons$Filled;", "getLeakRemove", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LeakRemoveKt {
    private static ImageVector _leakRemove;

    static {
    }

    public static final ImageVector getLeakRemove(Filled arg19) {
        ImageVector v0 = LeakRemoveKt._leakRemove;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.LeakRemove", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10f, 3f);
        v12.lineTo(8f, 3f);
        v12.curveToRelative(0f, 0.37f, -0.04f, 0.72f, -0.12f, 1.06f);
        v12.lineToRelative(1.59f, 1.59f);
        v12.curveTo(9.81f, 4.84f, 10f, 3.94f, 10f, 3f);
        v12.close();
        v12.moveTo(3f, 4.27f);
        v12.lineToRelative(2.84f, 2.84f);
        v12.curveTo(5.03f, 7.67f, 4.06f, 8f, 3f, 8f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(1.61f, 0f, 3.09f, -0.55f, 4.27f, -1.46f);
        v12.lineTo(8.7f, 9.97f);
        v12.curveTo(7.14f, 11.24f, 5.16f, 12f, 3f, 12f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(2.71f, 0f, 5.19f, -0.99f, 7.11f, -2.62f);
        v12.lineToRelative(2.5f, 2.5f);
        v12.curveTo(10.99f, 15.81f, 10f, 18.290001f, 10f, 21f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0f, -2.16f, 0.76f, -4.14f, 2.03f, -5.69f);
        v12.lineToRelative(1.43f, 1.43f);
        v12.curveTo(14.55f, 17.91f, 14f, 19.389999f, 14f, 21f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0f, -1.06f, 0.33f, -2.03f, 0.89f, -2.84f);
        v12.lineTo(19.73f, 21f);
        v12.lineTo(21f, 19.73f);
        v12.lineTo(4.27f, 3f);
        v12.lineTo(3f, 4.27f);
        v12.close();
        v12.moveTo(14f, 3f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(0f, 1.5f, -0.37f, 2.91f, -1.02f, 4.16f);
        v12.lineToRelative(1.46f, 1.46f);
        v12.curveTo(13.42f, 6.98f, 14f, 5.06f, 14f, 3f);
        v12.close();
        v12.moveTo(19.940001f, 16.120001f);
        v12.curveToRelative(0.34f, -0.08f, 0.69f, -0.12f, 1.06f, -0.12f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(-0.94f, 0f, -1.84f, 0.19f, -2.66f, 0.52f);
        v12.lineToRelative(1.6f, 1.6f);
        v12.close();
        v12.moveTo(15.38f, 11.56f);
        v12.lineToRelative(1.46f, 1.46f);
        v12.curveTo(18.09f, 12.37f, 19.5f, 12f, 21f, 12f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(-2.06f, 0f, -3.98f, 0.58f, -5.62f, 1.56f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LeakRemoveKt._leakRemove = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

