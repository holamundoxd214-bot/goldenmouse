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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_soap", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Soap", "Landroidx/compose/material/icons/Icons$Filled;", "getSoap", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SoapKt {
    private static ImageVector _soap;

    static {
    }

    public static final ImageVector getSoap(Filled arg19) {
        ImageVector v0 = SoapKt._soap;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Soap", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9.12f, 5f);
        v12.lineToRelative(-7.18f, 6.79f);
        v12.curveTo(1.34f, 12.35f, 1f, 13.14f, 1f, 13.97f);
        v12.verticalLineTo(20f);
        v12.curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f);
        v12.horizontalLineToRelative(6.25f);
        v12.horizontalLineTo(12f);
        v12.horizontalLineToRelative(5.75f);
        v12.curveToRelative(0.69f, 0f, 1.25f, -0.56f, 1.25f, -1.25f);
        v12.reflectiveCurveToRelative(-0.56f, -1.25f, -1.25f, -1.25f);
        v12.horizontalLineTo(12f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(7.75f);
        v12.curveToRelative(0.69f, 0f, 1.25f, -0.56f, 1.25f, -1.25f);
        v12.reflectiveCurveTo(20.440001f, 17f, 19.75f, 17f);
        v12.horizontalLineTo(12f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(8.75f);
        v12.curveToRelative(0.69f, 0f, 1.25f, -0.56f, 1.25f, -1.25f);
        v12.reflectiveCurveToRelative(-0.56f, -1.25f, -1.25f, -1.25f);
        v12.horizontalLineTo(12f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(6.75f);
        v12.curveToRelative(0.69f, 0f, 1.25f, -0.56f, 1.25f, -1.25f);
        v12.reflectiveCurveTo(19.440001f, 10f, 18.75f, 10f);
        v12.horizontalLineTo(8.86f);
        v12.curveToRelative(0.64f, -1.11f, 1.48f, -2.58f, 1.49f, -2.61f);
        v12.curveToRelative(0.09f, -0.16f, 0.14f, -0.33f, 0.14f, -0.53f);
        v12.curveToRelative(0f, -0.26f, -0.09f, -0.5f, -0.26f, -0.7f);
        v12.curveTo(10.22f, 6.12f, 9.12f, 5f, 9.12f, 5f);
        v12.lineTo(9.12f, 5f);
        v12.close();
        v12.moveTo(14f, 6.25f);
        v12.curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f);
        v12.reflectiveCurveTo(14.41f, 7.75f, 14f, 7.75f);
        v12.reflectiveCurveTo(13.25f, 7.41f, 13.25f, 7f);
        v12.reflectiveCurveTo(13.59f, 6.25f, 14f, 6.25f);
        v12.moveTo(14f, 4.75f);
        v12.curveToRelative(-1.24f, 0f, -2.25f, 1.01f, -2.25f, 2.25f);
        v12.reflectiveCurveTo(12.76f, 9.25f, 14f, 9.25f);
        v12.reflectiveCurveTo(16.25f, 8.24f, 16.25f, 7f);
        v12.reflectiveCurveTo(15.24f, 4.75f, 14f, 4.75f);
        v12.lineTo(14f, 4.75f);
        v12.close();
        v12.moveTo(19.75f, 5.5f);
        v12.curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f);
        v12.reflectiveCurveToRelative(-0.22f, 0.5f, -0.5f, 0.5f);
        v12.reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f);
        v12.reflectiveCurveTo(19.469999f, 5.5f, 19.75f, 5.5f);
        v12.moveTo(19.75f, 4f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveTo(20.85f, 4f, 19.75f, 4f);
        v12.lineTo(19.75f, 4f);
        v12.close();
        v12.moveTo(16.5f, 1f);
        v12.curveTo(15.67f, 1f, 15f, 1.67f, 15f, 2.5f);
        v12.reflectiveCurveTo(15.67f, 4f, 16.5f, 4f);
        v12.curveTo(17.33f, 4f, 18f, 3.33f, 18f, 2.5f);
        v12.reflectiveCurveTo(17.33f, 1f, 16.5f, 1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SoapKt._soap = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

