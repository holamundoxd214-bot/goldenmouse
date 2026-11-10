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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_dinnerDining", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DinnerDining", "Landroidx/compose/material/icons/Icons$Rounded;", "getDinnerDining", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DinnerDiningKt {
    private static ImageVector _dinnerDining;

    static {
    }

    public static final ImageVector getDinnerDining(Rounded arg19) {
        ImageVector v0 = DinnerDiningKt._dinnerDining;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.DinnerDining", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(2.85f, 19.85f);
        v12.lineToRelative(1f, 1f);
        v12.curveTo(3.95f, 20.950001f, 4.07f, 21f, 4.21f, 21f);
        v12.horizontalLineToRelative(15.59f);
        v12.curveToRelative(0.13f, 0f, 0.26f, -0.05f, 0.35f, -0.15f);
        v12.lineToRelative(1f, -1f);
        v12.curveToRelative(0.31f, -0.31f, 0.09f, -0.85f, -0.35f, -0.85f);
        v12.horizontalLineTo(3.21f);
        v12.curveTo(2.76f, 19f, 2.54f, 19.540001f, 2.85f, 19.85f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(3f, 18f);
        v12.lineToRelative(16.969999f, 0f);
        v12.curveToRelative(0f, 0f, 0f, 0f, 0f, 0f);
        v12.curveToRelative(0.29f, -3.26f, -2.28f, -6f, -5.48f, -6f);
        v12.curveToRelative(-2.35f, 0f, -4.35f, 1.48f, -5.14f, 3.55f);
        v12.curveTo(8.94f, 15.32f, 8.48f, 15.17f, 8f, 15.08f);
        v12.verticalLineTo(9f);
        v12.horizontalLineToRelative(1.75f);
        v12.curveTo(10.99f, 9f, 12f, 7.99f, 12f, 6.75f);
        v12.verticalLineToRelative(0f);
        v12.horizontalLineToRelative(8.25f);
        v12.curveTo(20.66f, 6.75f, 21f, 6.41f, 21f, 6f);
        v12.reflectiveCurveToRelative(-0.34f, -0.75f, -0.75f, -0.75f);
        v12.horizontalLineTo(12f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(12f, 4.01f, 10.99f, 3f, 9.75f, 3f);
        v12.horizontalLineToRelative(-6f);
        v12.curveTo(3.34f, 3f, 3f, 3.34f, 3f, 3.75f);
        v12.reflectiveCurveTo(3.34f, 4.5f, 3.75f, 4.5f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(0.75f);
        v12.horizontalLineTo(3.75f);
        v12.curveTo(3.34f, 5.25f, 3f, 5.59f, 3f, 6f);
        v12.reflectiveCurveToRelative(0.34f, 0.75f, 0.75f, 0.75f);
        v12.horizontalLineTo(4f);
        v12.verticalLineTo(7.5f);
        v12.horizontalLineTo(3.75f);
        v12.curveTo(3.34f, 7.5f, 3f, 7.84f, 3f, 8.25f);
        v12.reflectiveCurveTo(3.34f, 9f, 3.75f, 9f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(7.39f);
        v12.curveTo(3.56f, 16.85f, 3.22f, 17.389999f, 3f, 18f);
        v12.close();
        v12.moveTo(8f, 4.5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(0.75f);
        v12.horizontalLineTo(8f);
        v12.verticalLineTo(4.5f);
        v12.close();
        v12.moveTo(8f, 6.75f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(7.5f);
        v12.horizontalLineTo(8f);
        v12.verticalLineTo(6.75f);
        v12.close();
        v12.moveTo(5.5f, 4.5f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(0.75f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineTo(4.5f);
        v12.close();
        v12.moveTo(5.5f, 6.75f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(7.5f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineTo(6.75f);
        v12.close();
        v12.moveTo(5.5f, 9f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(6.06f);
        v12.curveToRelative(-0.35f, 0.06f, -0.68f, 0.17f, -1f, 0.3f);
        v12.verticalLineTo(9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DinnerDiningKt._dinnerDining = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

