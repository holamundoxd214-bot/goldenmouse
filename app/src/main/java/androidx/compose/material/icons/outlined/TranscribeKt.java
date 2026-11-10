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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_transcribe", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Transcribe", "Landroidx/compose/material/icons/Icons$Outlined;", "getTranscribe", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TranscribeKt {
    private static ImageVector _transcribe;

    static {
    }

    public static final ImageVector getTranscribe(Outlined arg19) {
        ImageVector v0 = TranscribeKt._transcribe;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Transcribe", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9f, 13f);
        v12.curveToRelative(2.21f, 0f, 4f, -1.79f, 4f, -4f);
        v12.curveToRelative(0f, -2.21f, -1.79f, -4f, -4f, -4f);
        v12.reflectiveCurveTo(5f, 6.79f, 5f, 9f);
        v12.curveTo(5f, 11.21f, 6.79f, 13f, 9f, 13f);
        v12.close();
        v12.moveTo(9f, 7f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f);
        v12.curveTo(7f, 7.9f, 7.9f, 7f, 9f, 7f);
        v12.close();
        v12.moveTo(15.39f, 15.56f);
        v12.curveTo(13.71f, 14.7f, 11.53f, 14f, 9f, 14f);
        v12.curveToRelative(-2.53f, 0f, -4.71f, 0.7f, -6.39f, 1.56f);
        v12.curveTo(1.61f, 16.07f, 1f, 17.1f, 1f, 18.219999f);
        v12.verticalLineTo(21f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineToRelative(-2.78f);
        v12.curveTo(17f, 17.1f, 16.389999f, 16.07f, 15.39f, 15.56f);
        v12.close();
        v12.moveTo(15f, 19f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(-0.78f);
        v12.curveToRelative(0f, -0.38f, 0.2f, -0.72f, 0.52f, -0.88f);
        v12.curveTo(4.71f, 16.73f, 6.63f, 16f, 9f, 16f);
        v12.curveToRelative(2.37f, 0f, 4.29f, 0.73f, 5.48f, 1.34f);
        v12.curveTo(14.8f, 17.5f, 15f, 17.84f, 15f, 18.219999f);
        v12.verticalLineTo(19f);
        v12.close();
        v12.moveTo(17.93f, 16f);
        v12.lineToRelative(1.63f, -1.63f);
        v12.curveToRelative(-2.77f, -3.02f, -2.77f, -7.56f, 0f, -10.74f);
        v12.lineTo(17.93f, 2f);
        v12.curveTo(14.03f, 5.89f, 14.02f, 11.95f, 17.93f, 16f);
        v12.close();
        v12.moveTo(22.92f, 10.95f);
        v12.curveToRelative(-0.84f, -1.18f, -0.84f, -2.71f, 0f, -3.89f);
        v12.lineToRelative(-1.68f, -1.69f);
        v12.curveToRelative(-2.02f, 2.02f, -2.02f, 5.07f, 0f, 7.27f);
        v12.lineTo(22.92f, 10.95f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TranscribeKt._transcribe = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

