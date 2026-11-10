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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sports", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Sports", "Landroidx/compose/material/icons/Icons$Rounded;", "getSports", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SportsKt {
    private static ImageVector _sports;

    static {
    }

    public static final ImageVector getSports(Rounded arg20) {
        ImageVector v0 = SportsKt._sports;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Sports", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 6f);
        v12.horizontalLineToRelative(-9.77f);
        v12.curveTo(9.57f, 6f, 8.01f, 6.66f, 6.87f, 7.73f);
        v12.curveTo(6.54f, 6.73f, 5.61f, 6f, 4.5f, 6f);
        v12.curveTo(3.12f, 6f, 2f, 7.12f, 2f, 8.5f);
        v12.curveTo(2f, 9.88f, 3.12f, 11f, 4.5f, 11f);
        v12.curveToRelative(0.21f, 0f, 0.41f, -0.03f, 0.61f, -0.08f);
        v12.curveToRelative(-0.05f, 0.25f, -0.09f, 0.51f, -0.1f, 0.78f);
        v12.curveToRelative(-0.18f, 3.68f, 2.95f, 6.68f, 6.68f, 6.27f);
        v12.curveToRelative(2.55f, -0.28f, 4.68f, -2.26f, 5.19f, -4.77f);
        v12.curveToRelative(0.15f, -0.71f, 0.15f, -1.4f, 0.06f, -2.06f);
        v12.curveToRelative(-0.09f, -0.6f, 0.38f, -1.13f, 0.99f, -1.13f);
        v12.lineToRelative(2.76f, 0f);
        v12.curveTo(21.559999f, 10f, 22f, 9.55f, 22f, 9f);
        v12.verticalLineTo(7f);
        v12.curveTo(22f, 6.45f, 21.549999f, 6f, 21f, 6f);
        v12.close();
        v12.moveTo(4.5f, 9f);
        v12.curveTo(4.22f, 9f, 4f, 8.78f, 4f, 8.5f);
        v12.curveTo(4f, 8.22f, 4.22f, 8f, 4.5f, 8f);
        v12.reflectiveCurveTo(5f, 8.22f, 5f, 8.5f);
        v12.curveTo(5f, 8.78f, 4.78f, 9f, 4.5f, 9f);
        v12.close();
        v12.moveTo(11f, 15f);
        v12.curveToRelative(-1.66f, 0f, -3f, -1.34f, -3f, -3f);
        v12.reflectiveCurveToRelative(1.34f, -3f, 3f, -3f);
        v12.reflectiveCurveToRelative(3f, 1.34f, 3f, 3f);
        v12.reflectiveCurveTo(12.66f, 15f, 11f, 15f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(11f, 12f);
        v12.moveToRelative(-2f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, 4f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, -4f, 0f);
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SportsKt._sports = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

