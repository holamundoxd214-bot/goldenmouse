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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_rawOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RawOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getRawOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RawOffKt {
    private static ImageVector _rawOff;

    static {
    }

    public static final ImageVector getRawOff(Rounded arg19) {
        ImageVector v0 = RawOffKt._rawOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.RawOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.549999f, 9f);
        v12.curveToRelative(-0.33f, 0f, -0.63f, 0.23f, -0.71f, 0.55f);
        v12.lineTo(19.24f, 12f);
        v12.lineToRelative(-0.56f, -2.26f);
        v12.curveTo(18.58f, 9.3f, 18.190001f, 9f, 17.74f, 9f);
        v12.reflectiveCurveTo(16.9f, 9.3f, 16.799999f, 9.74f);
        v12.lineTo(16.24f, 12f);
        v12.lineToRelative(-0.6f, -2.45f);
        v12.curveTo(15.56f, 9.23f, 15.27f, 9f, 14.93f, 9f);
        v12.curveToRelative(-0.47f, 0f, -0.82f, 0.44f, -0.71f, 0.9f);
        v12.lineToRelative(0.5f, 1.99f);
        v12.lineToRelative(2.42f, 2.42f);
        v12.curveToRelative(0f, -0.01f, 0.01f, -0.02f, 0.01f, -0.03f);
        v12.lineToRelative(0.58f, -2.32f);
        v12.lineToRelative(0.58f, 2.32f);
        v12.curveTo(18.43f, 14.7f, 18.809999f, 15f, 19.24f, 15f);
        v12.reflectiveCurveToRelative(0.81f, -0.3f, 0.92f, -0.72f);
        v12.lineToRelative(1.09f, -4.38f);
        v12.curveTo(21.370001f, 9.44f, 21.02f, 9f, 20.549999f, 9f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(3.51f, 3.51f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineTo(6.17f, 9f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(4.31f);
        v12.curveTo(3f, 14.69f, 3.31f, 15f, 3.69f, 15f);
        v12.horizontalLineToRelative(0.11f);
        v12.curveToRelative(0.38f, 0f, 0.69f, -0.31f, 0.69f, -0.69f);
        v12.verticalLineTo(13f);
        v12.horizontalLineToRelative(1.1f);
        v12.lineToRelative(0.72f, 1.59f);
        v12.curveTo(6.43f, 14.84f, 6.68f, 15f, 6.95f, 15f);
        v12.curveToRelative(0.5f, 0f, 0.83f, -0.51f, 0.64f, -0.97f);
        v12.lineTo(7.1f, 12.9f);
        v12.curveTo(7.6f, 12.6f, 8f, 12.1f, 8f, 11.5f);
        v12.verticalLineToRelative(-0.67f);
        v12.lineToRelative(1.43f, 1.43f);
        v12.lineTo(8.98f, 14.1f);
        v12.curveTo(8.86f, 14.56f, 9.21f, 15f, 9.68f, 15f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.33f, 0f, 0.62f, -0.23f, 0.7f, -0.55f);
        v12.lineToRelative(0.24f, -0.95f);
        v12.horizontalLineToRelative(0.04f);
        v12.lineToRelative(8.4f, 8.4f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(3.51f, 3.51f);
        v12.close();
        v12.moveTo(6.5f, 11.5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(11.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RawOffKt._rawOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

