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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_micOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MicOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getMicOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MicOffKt {
    private static ImageVector _micOff;

    static {
    }

    public static final ImageVector getMicOff(Rounded arg19) {
        ImageVector v0 = MicOffKt._micOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.MicOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15f, 10.6f);
        v12.lineTo(15f, 5f);
        v12.curveToRelative(0f, -1.66f, -1.34f, -3f, -3f, -3f);
        v12.curveToRelative(-1.54f, 0f, -2.79f, 1.16f, -2.96f, 2.65f);
        v12.lineTo(15f, 10.6f);
        v12.close();
        v12.moveTo(18.08f, 11f);
        v12.curveToRelative(-0.41f, 0f, -0.77f, 0.3f, -0.83f, 0.71f);
        v12.curveToRelative(-0.05f, 0.32f, -0.12f, 0.64f, -0.22f, 0.93f);
        v12.lineToRelative(1.27f, 1.27f);
        v12.curveToRelative(0.3f, -0.6f, 0.52f, -1.25f, 0.63f, -1.94f);
        v12.curveToRelative(0.07f, -0.51f, -0.33f, -0.97f, -0.85f, -0.97f);
        v12.close();
        v12.moveTo(3.71f, 3.56f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineTo(9f, 10.27f);
        v12.verticalLineToRelative(0.43f);
        v12.curveToRelative(0f, 1.19f, 0.6f, 2.32f, 1.63f, 2.91f);
        v12.curveToRelative(0.75f, 0.43f, 1.41f, 0.44f, 2.02f, 0.31f);
        v12.lineToRelative(1.66f, 1.66f);
        v12.curveToRelative(-0.71f, 0.33f, -1.5f, 0.52f, -2.31f, 0.52f);
        v12.curveToRelative(-2.54f, 0f, -4.88f, -1.77f, -5.25f, -4.39f);
        v12.curveToRelative(-0.06f, -0.41f, -0.42f, -0.71f, -0.83f, -0.71f);
        v12.curveToRelative(-0.52f, 0f, -0.92f, 0.46f, -0.85f, 0.97f);
        v12.curveToRelative(0.46f, 2.96f, 2.96f, 5.3f, 5.93f, 5.75f);
        v12.lineTo(11f, 20f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-2.28f);
        v12.curveToRelative(0.91f, -0.13f, 1.77f, -0.45f, 2.55f, -0.9f);
        v12.lineToRelative(3.49f, 3.49f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(5.12f, 3.56f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MicOffKt._micOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

