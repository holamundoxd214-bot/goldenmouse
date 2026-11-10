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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_allInclusive", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AllInclusive", "Landroidx/compose/material/icons/Icons$Rounded;", "getAllInclusive", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AllInclusiveKt {
    private static ImageVector _allInclusive;

    static {
    }

    public static final ImageVector getAllInclusive(Rounded arg19) {
        ImageVector v0 = AllInclusiveKt._allInclusive;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.AllInclusive", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.219999f, 6.86f);
        v12.curveToRelative(-2f, -0.6f, -4.06f, -0.04f, -5.39f, 1.29f);
        v12.lineTo(12f, 10.66f);
        v12.lineTo(10.48f, 12f);
        v12.horizontalLineToRelative(0.01f);
        v12.lineTo(7.8f, 14.39f);
        v12.curveToRelative(-0.81f, 0.81f, -1.95f, 1.15f, -3.12f, 0.92f);
        v12.curveToRelative(-1.25f, -0.25f, -2.28f, -1.25f, -2.57f, -2.49f);
        v12.curveToRelative(-0.52f, -2.23f, 1.16f, -4.2f, 3.29f, -4.2f);
        v12.curveToRelative(0.91f, 0f, 1.76f, 0.35f, 2.44f, 1.03f);
        v12.lineToRelative(0.47f, 0.41f);
        v12.curveToRelative(0.38f, 0.34f, 0.95f, 0.34f, 1.33f, 0f);
        v12.curveToRelative(0.45f, -0.4f, 0.45f, -1.1f, 0f, -1.5f);
        v12.lineToRelative(-0.42f, -0.36f);
        v12.curveTo(8.2f, 7.18f, 6.84f, 6.62f, 5.4f, 6.62f);
        v12.curveTo(2.42f, 6.62f, 0f, 9.04f, 0f, 12f);
        v12.reflectiveCurveToRelative(2.42f, 5.38f, 5.4f, 5.38f);
        v12.curveToRelative(1.44f, 0f, 2.8f, -0.56f, 3.77f, -1.53f);
        v12.lineToRelative(2.83f, -2.5f);
        v12.lineToRelative(0.01f, 0.01f);
        v12.lineTo(13.52f, 12f);
        v12.horizontalLineToRelative(-0.01f);
        v12.lineToRelative(2.69f, -2.39f);
        v12.curveToRelative(0.81f, -0.81f, 1.95f, -1.15f, 3.12f, -0.92f);
        v12.curveToRelative(1.25f, 0.25f, 2.28f, 1.25f, 2.57f, 2.49f);
        v12.curveToRelative(0.52f, 2.23f, -1.16f, 4.2f, -3.29f, 4.2f);
        v12.curveToRelative(-0.9f, 0f, -1.76f, -0.35f, -2.44f, -1.03f);
        v12.lineToRelative(-0.48f, -0.42f);
        v12.curveToRelative(-0.38f, -0.34f, -0.95f, -0.34f, -1.33f, 0f);
        v12.curveToRelative(-0.45f, 0.4f, -0.45f, 1.1f, 0f, 1.5f);
        v12.lineToRelative(0.42f, 0.37f);
        v12.curveToRelative(1.02f, 1.01f, 2.37f, 1.57f, 3.82f, 1.57f);
        v12.curveToRelative(3.27f, 0f, 5.86f, -2.9f, 5.33f, -6.25f);
        v12.curveToRelative(-0.3f, -1.99f, -1.77f, -3.69f, -3.7f, -4.26f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AllInclusiveKt._allInclusive = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

