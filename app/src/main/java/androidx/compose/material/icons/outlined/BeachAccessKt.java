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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_beachAccess", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BeachAccess", "Landroidx/compose/material/icons/Icons$Outlined;", "getBeachAccess", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BeachAccessKt {
    private static ImageVector _beachAccess;

    static {
    }

    public static final ImageVector getBeachAccess(Outlined arg19) {
        ImageVector v0 = BeachAccessKt._beachAccess;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.BeachAccess", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 19.57f);
        v12.lineToRelative(-1.427f, 1.428f);
        v12.lineToRelative(-6.442f, -6.442f);
        v12.lineToRelative(1.43f, -1.428f);
        v12.close();
        v12.moveTo(13.12f, 3f);
        v12.curveToRelative(-2.58f, 0f, -5.16f, 0.98f, -7.14f, 2.95f);
        v12.lineToRelative(-0.01f, 0.01f);
        v12.curveToRelative(-3.95f, 3.95f, -3.95f, 10.36f, 0f, 14.31f);
        v12.lineToRelative(14.3f, -14.31f);
        v12.curveTo(18.299999f, 3.99f, 15.71f, 3f, 13.12f, 3f);
        v12.close();
        v12.moveTo(6.14f, 17.27f);
        v12.curveTo(5.4f, 16.030001f, 5f, 14.61f, 5f, 13.12f);
        v12.curveToRelative(0f, -0.93f, 0.16f, -1.82f, 0.46f, -2.67f);
        v12.curveToRelative(0.19f, 1.91f, 0.89f, 3.79f, 2.07f, 5.44f);
        v12.lineToRelative(-1.39f, 1.38f);
        v12.close();
        v12.moveTo(8.98f, 14.43f);
        v12.curveTo(7.63f, 12.38f, 7.12f, 9.93f, 7.6f, 7.6f);
        v12.curveToRelative(0.58f, -0.12f, 1.16f, -0.18f, 1.75f, -0.18f);
        v12.curveToRelative(1.8f, 0f, 3.55f, 0.55f, 5.08f, 1.56f);
        v12.lineToRelative(-5.45f, 5.45f);
        v12.close();
        v12.moveTo(10.45f, 5.46f);
        v12.curveToRelative(0.85f, -0.3f, 1.74f, -0.46f, 2.67f, -0.46f);
        v12.curveToRelative(1.49f, 0f, 2.91f, 0.4f, 4.15f, 1.14f);
        v12.lineToRelative(-1.39f, 1.39f);
        v12.curveToRelative(-1.65f, -1.18f, -3.52f, -1.88f, -5.43f, -2.07f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BeachAccessKt._beachAccess = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

