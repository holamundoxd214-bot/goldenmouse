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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_dryCleaning", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DryCleaning", "Landroidx/compose/material/icons/Icons$Outlined;", "getDryCleaning", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DryCleaningKt {
    private static ImageVector _dryCleaning;

    static {
    }

    public static final ImageVector getDryCleaning(Outlined arg19) {
        ImageVector v0 = DryCleaningKt._dryCleaning;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.DryCleaning", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.559999f, 11.36f);
        v12.lineTo(13f, 8.44f);
        v12.verticalLineTo(7f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0f, -1.84f, -1.66f, -3.3f, -3.56f, -2.95f);
        v12.curveTo(10.26f, 2.27f, 9.29f, 3.22f, 9.06f, 4.4f);
        v12.curveTo(8.76f, 5.96f, 9.66f, 7.34f, 11f, 7.82f);
        v12.verticalLineToRelative(0.63f);
        v12.lineToRelative(-6.56f, 2.92f);
        v12.curveTo(3.56f, 11.75f, 3f, 12.62f, 3f, 13.57f);
        v12.verticalLineToRelative(0.01f);
        v12.curveTo(3f, 14.92f, 4.08f, 16f, 5.42f, 16f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(-6f);
        v12.horizontalLineToRelative(1.58f);
        v12.curveToRelative(1.34f, 0f, 2.42f, -1.08f, 2.42f, -2.42f);
        v12.verticalLineToRelative(-0.01f);
        v12.curveTo(21f, 12.62f, 20.440001f, 11.75f, 19.559999f, 11.36f);
        v12.close();
        v12.moveTo(15f, 20f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(-5f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineTo(20f);
        v12.close();
        v12.moveTo(18.58f, 14f);
        v12.horizontalLineTo(17f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(1f);
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

