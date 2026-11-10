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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_dryCleaning", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DryCleaning", "Landroidx/compose/material/icons/Icons$Rounded;", "getDryCleaning", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DryCleaningKt {
    private static ImageVector _dryCleaning;

    static {
    }

    public static final ImageVector getDryCleaning(Rounded arg19) {
        ImageVector v0 = DryCleaningKt._dryCleaning;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.DryCleaning", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.559999f, 11.36f);
        v12.lineTo(13f, 8.44f);
        v12.verticalLineTo(7f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.curveToRelative(0.38f, 0f, 0.72f, 0.22f, 0.88f, 0.53f);
        v12.curveTo(13.04f, 4.84f, 13.39f, 5f, 13.73f, 5f);
        v12.curveToRelative(0.74f, 0f, 1.26f, -0.79f, 0.91f, -1.44f);
        v12.curveToRelative(-0.6f, -1.1f, -1.86f, -1.78f, -3.24f, -1.51f);
        v12.curveToRelative(-1.17f, 0.23f, -2.12f, 1.2f, -2.34f, 2.37f);
        v12.curveTo(8.77f, 5.98f, 9.67f, 7.35f, 11f, 7.82f);
        v12.verticalLineToRelative(0.63f);
        v12.lineToRelative(-6.56f, 2.92f);
        v12.curveTo(3.56f, 11.75f, 3f, 12.62f, 3f, 13.57f);
        v12.verticalLineToRelative(0.01f);
        v12.curveTo(3f, 14.92f, 4.08f, 16f, 5.42f, 16f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-4f);
        v12.horizontalLineToRelative(1.58f);
        v12.curveToRelative(1.34f, 0f, 2.42f, -1.08f, 2.42f, -2.42f);
        v12.verticalLineToRelative(-0.01f);
        v12.curveTo(21f, 12.62f, 20.440001f, 11.75f, 19.559999f, 11.36f);
        v12.close();
        v12.moveTo(18.58f, 14f);
        v12.horizontalLineToRelative(-1.86f);
        v12.curveToRelative(-0.35f, -0.6f, -0.98f, -1f, -1.72f, -1f);
        v12.horizontalLineTo(9f);
        v12.curveToRelative(-0.74f, 0f, -1.38f, 0.4f, -1.72f, 1f);
        v12.horizontalLineTo(5.42f);
        v12.curveToRelative(-0.46f, 0f, -0.58f, -0.65f, -0.17f, -0.81f);
        v12.lineToRelative(6.75f, -3f);
        v12.lineToRelative(6.75f, 3f);
        v12.curveTo(19.17f, 13.38f, 19.030001f, 14f, 18.58f, 14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DryCleaningKt._dryCleaning = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

