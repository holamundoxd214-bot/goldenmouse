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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_vaccines", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Vaccines", "Landroidx/compose/material/icons/Icons$Filled;", "getVaccines", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VaccinesKt {
    private static ImageVector _vaccines;

    static {
    }

    public static final ImageVector getVaccines(Filled arg19) {
        ImageVector v0 = VaccinesKt._vaccines;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Vaccines", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11f, 5.5f);
        v12.horizontalLineTo(8f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(0.5f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-3f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineTo(6f);
        v12.verticalLineToRelative(1.5f);
        v12.horizontalLineTo(3f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.verticalLineTo(15f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(4f);
        v12.lineToRelative(2f, 1.5f);
        v12.verticalLineTo(17f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(7.5f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.curveTo(12f, 5.95f, 11.55f, 5.5f, 11f, 5.5f);
        v12.close();
        v12.moveTo(9f, 9f);
        v12.horizontalLineTo(7.25f);
        v12.curveTo(6.84f, 9f, 6.5f, 9.34f, 6.5f, 9.75f);
        v12.curveToRelative(0f, 0.41f, 0.34f, 0.75f, 0.75f, 0.75f);
        v12.horizontalLineTo(9f);
        v12.verticalLineTo(12f);
        v12.horizontalLineTo(7.25f);
        v12.curveToRelative(-0.41f, 0f, -0.75f, 0.34f, -0.75f, 0.75f);
        v12.curveToRelative(0f, 0.41f, 0.34f, 0.75f, 0.75f, 0.75f);
        v12.horizontalLineTo(9f);
        v12.lineTo(9f, 15f);
        v12.horizontalLineTo(5f);
        v12.verticalLineTo(7.5f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineTo(9f);
        v12.close();
        v12.moveTo(19.5f, 10.5f);
        v12.verticalLineTo(10f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-5f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.verticalLineToRelative(0.5f);
        v12.curveToRelative(0f, 0.5f, -1.5f, 1.16f, -1.5f, 3f);
        v12.verticalLineTo(20f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-6.5f);
        v12.curveTo(21f, 11.66f, 19.5f, 11f, 19.5f, 10.5f);
        v12.close();
        v12.moveTo(16.5f, 10.5f);
        v12.verticalLineTo(10f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(0.5f);
        v12.curveToRelative(0f, 1.6f, 1.5f, 2f, 1.5f, 3f);
        v12.verticalLineTo(14f);
        v12.horizontalLineToRelative(-4f);
        v12.curveToRelative(0f, -0.21f, 0f, -0.39f, 0f, -0.5f);
        v12.curveTo(15f, 12.5f, 16.5f, 12.1f, 16.5f, 10.5f);
        v12.close();
        v12.moveTo(15f, 20f);
        v12.curveToRelative(0f, 0f, 0f, -0.63f, 0f, -1.5f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineTo(20f);
        v12.horizontalLineTo(15f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VaccinesKt._vaccines = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

