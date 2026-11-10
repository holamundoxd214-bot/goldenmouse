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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_transcribe", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Transcribe", "Landroidx/compose/material/icons/Icons$Rounded;", "getTranscribe", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TranscribeKt {
    private static ImageVector _transcribe;

    static {
    }

    public static final ImageVector getTranscribe(Rounded arg19) {
        ImageVector v0 = TranscribeKt._transcribe;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Transcribe", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22.540001f, 10.28f);
        v12.curveToRelative(-0.34f, -0.82f, -0.34f, -1.72f, 0f, -2.54f);
        v12.curveToRelative(0.19f, -0.45f, 0.1f, -0.96f, -0.24f, -1.3f);
        v12.lineToRelative(-0.1f, -0.1f);
        v12.curveToRelative(-0.56f, -0.56f, -1.51f, -0.44f, -1.88f, 0.26f);
        v12.curveToRelative(-0.8f, 1.48f, -0.79f, 3.24f, 0.03f, 4.79f);
        v12.curveToRelative(0.37f, 0.69f, 1.31f, 0.83f, 1.86f, 0.27f);
        v12.lineToRelative(0.1f, -0.1f);
        v12.curveTo(22.65f, 11.23f, 22.73f, 10.72f, 22.540001f, 10.28f);
        v12.close();
        v12.moveTo(18.82f, 15.11f);
        v12.lineTo(18.82f, 15.11f);
        v12.curveToRelative(0.4f, -0.4f, 0.46f, -1.02f, 0.13f, -1.48f);
        v12.curveToRelative(-1.97f, -2.73f, -1.96f, -6.39f, 0.01f, -9.23f);
        v12.curveToRelative(0.32f, -0.47f, 0.26f, -1.1f, -0.14f, -1.5f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.5f, -0.5f, -1.34f, -0.46f, -1.78f, 0.1f);
        v12.curveToRelative(-2.73f, 3.54f, -2.73f, 8.36f, 0.02f, 12f);
        v12.curveTo(17.49f, 15.56f, 18.33f, 15.61f, 18.82f, 15.11f);
        v12.close();
        v12.moveTo(9f, 13f);
        v12.curveToRelative(2.21f, 0f, 4f, -1.79f, 4f, -4f);
        v12.curveToRelative(0f, -2.21f, -1.79f, -4f, -4f, -4f);
        v12.reflectiveCurveTo(5f, 6.79f, 5f, 9f);
        v12.curveTo(5f, 11.21f, 6.79f, 13f, 9f, 13f);
        v12.close();
        v12.moveTo(15.39f, 15.56f);
        v12.curveTo(13.71f, 14.7f, 11.53f, 14f, 9f, 14f);
        v12.curveToRelative(-2.53f, 0f, -4.71f, 0.7f, -6.39f, 1.56f);
        v12.curveTo(1.61f, 16.07f, 1f, 17.1f, 1f, 18.219999f);
        v12.lineTo(1f, 20f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.lineToRelative(0f, -1.78f);
        v12.curveTo(17f, 17.1f, 16.389999f, 16.07f, 15.39f, 15.56f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TranscribeKt._transcribe = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

