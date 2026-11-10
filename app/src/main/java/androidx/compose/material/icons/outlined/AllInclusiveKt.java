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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_allInclusive", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AllInclusive", "Landroidx/compose/material/icons/Icons$Outlined;", "getAllInclusive", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AllInclusiveKt {
    private static ImageVector _allInclusive;

    static {
    }

    public static final ImageVector getAllInclusive(Outlined arg19) {
        ImageVector v0 = AllInclusiveKt._allInclusive;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.AllInclusive", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.6f, 6.62f);
        v12.curveToRelative(-1.44f, 0f, -2.8f, 0.56f, -3.77f, 1.53f);
        v12.lineTo(7.8f, 14.39f);
        v12.curveToRelative(-0.64f, 0.64f, -1.49f, 0.99f, -2.4f, 0.99f);
        v12.curveToRelative(-1.87f, 0f, -3.39f, -1.51f, -3.39f, -3.38f);
        v12.reflectiveCurveTo(3.53f, 8.62f, 5.4f, 8.62f);
        v12.curveToRelative(0.91f, 0f, 1.76f, 0.35f, 2.44f, 1.03f);
        v12.lineToRelative(1.13f, 1f);
        v12.lineToRelative(1.51f, -1.34f);
        v12.lineTo(9.22f, 8.2f);
        v12.curveTo(8.2f, 7.18f, 6.84f, 6.62f, 5.4f, 6.62f);
        v12.curveTo(2.42f, 6.62f, 0f, 9.04f, 0f, 12f);
        v12.reflectiveCurveToRelative(2.42f, 5.38f, 5.4f, 5.38f);
        v12.curveToRelative(1.44f, 0f, 2.8f, -0.56f, 3.77f, -1.53f);
        v12.lineToRelative(7.03f, -6.24f);
        v12.curveToRelative(0.64f, -0.64f, 1.49f, -0.99f, 2.4f, -0.99f);
        v12.curveToRelative(1.87f, 0f, 3.39f, 1.51f, 3.39f, 3.38f);
        v12.reflectiveCurveToRelative(-1.52f, 3.38f, -3.39f, 3.38f);
        v12.curveToRelative(-0.9f, 0f, -1.76f, -0.35f, -2.44f, -1.03f);
        v12.lineToRelative(-1.14f, -1.01f);
        v12.lineToRelative(-1.51f, 1.34f);
        v12.lineToRelative(1.27f, 1.12f);
        v12.curveToRelative(1.02f, 1.01f, 2.37f, 1.57f, 3.82f, 1.57f);
        v12.curveToRelative(2.98f, 0f, 5.4f, -2.41f, 5.4f, -5.38f);
        v12.reflectiveCurveToRelative(-2.42f, -5.37f, -5.4f, -5.37f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AllInclusiveKt._allInclusive = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

