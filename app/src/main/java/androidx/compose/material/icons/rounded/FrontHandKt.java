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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_frontHand", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FrontHand", "Landroidx/compose/material/icons/Icons$Rounded;", "getFrontHand", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FrontHandKt {
    private static ImageVector _frontHand;

    static {
    }

    public static final ImageVector getFrontHand(Rounded arg19) {
        ImageVector v0 = FrontHandKt._frontHand;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FrontHand", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.5f, 14.5f);
        v12.curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-1.51f, 0f, -2.77f, 1.12f, -2.97f, 2.58f);
        v12.curveTo(15f, 17.82f, 14.78f, 18f, 14.54f, 18f);
        v12.curveToRelative(-0.3f, 0f, -0.54f, -0.27f, -0.5f, -0.57f);
        v12.curveToRelative(0.26f, -1.77f, 1.68f, -3.17f, 3.46f, -3.4f);
        v12.lineToRelative(0f, -10.78f);
        v12.curveTo(17.5f, 2.56f, 16.940001f, 2f, 16.25f, 2f);
        v12.curveTo(15.56f, 2f, 15f, 2.56f, 15f, 3.25f);
        v12.verticalLineToRelative(7.25f);
        v12.curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f);
        v12.reflectiveCurveTo(14f, 10.78f, 14f, 10.5f);
        v12.verticalLineTo(1.25f);
        v12.curveTo(14f, 0.56f, 13.44f, 0f, 12.75f, 0f);
        v12.reflectiveCurveTo(11.5f, 0.56f, 11.5f, 1.25f);
        v12.verticalLineToRelative(9.25f);
        v12.curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f);
        v12.reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f);
        v12.verticalLineTo(2.75f);
        v12.curveToRelative(0f, -0.69f, -0.56f, -1.25f, -1.25f, -1.25f);
        v12.reflectiveCurveTo(8f, 2.06f, 8f, 2.75f);
        v12.verticalLineToRelative(8.75f);
        v12.curveTo(8f, 11.78f, 7.78f, 12f, 7.5f, 12f);
        v12.reflectiveCurveTo(7f, 11.78f, 7f, 11.5f);
        v12.verticalLineTo(5.75f);
        v12.curveTo(7f, 5.06f, 6.44f, 4.5f, 5.75f, 4.5f);
        v12.reflectiveCurveTo(4.5f, 5.06f, 4.5f, 5.75f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 4.56f, 3.69f, 8.25f, 8.25f, 8.25f);
        v12.reflectiveCurveTo(21f, 20.309999f, 21f, 15.75f);
        v12.verticalLineToRelative(-6.5f);
        v12.curveTo(21f, 8.56f, 20.440001f, 8f, 19.75f, 8f);
        v12.reflectiveCurveTo(18.5f, 8.56f, 18.5f, 9.25f);
        v12.verticalLineTo(14.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FrontHandKt._frontHand = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

