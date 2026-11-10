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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_screenRotation", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ScreenRotation", "Landroidx/compose/material/icons/Icons$Rounded;", "getScreenRotation", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ScreenRotationKt {
    private static ImageVector _screenRotation;

    static {
    }

    public static final ImageVector getScreenRotation(Rounded arg19) {
        ImageVector v0 = ScreenRotationKt._screenRotation;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ScreenRotation", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10.23f, 1.75f);
        v12.curveToRelative(-0.59f, -0.59f, -1.54f, -0.59f, -2.12f, 0f);
        v12.lineTo(1.75f, 8.11f);
        v12.curveToRelative(-0.59f, 0.59f, -0.59f, 1.54f, 0f, 2.12f);
        v12.lineToRelative(12.02f, 12.02f);
        v12.curveToRelative(0.59f, 0.59f, 1.54f, 0.59f, 2.12f, 0f);
        v12.lineToRelative(6.36f, -6.36f);
        v12.curveToRelative(0.59f, -0.59f, 0.59f, -1.54f, 0f, -2.12f);
        v12.lineTo(10.23f, 1.75f);
        v12.close();
        v12.moveTo(14.12f, 20.48f);
        v12.lineTo(3.52f, 9.88f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(4.95f, -4.95f);
        v12.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0f);
        v12.lineToRelative(10.61f, 10.61f);
        v12.curveToRelative(0.39f, 0.39f, 0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(-4.95f, 4.95f);
        v12.curveToRelative(-0.39f, 0.38f, -1.03f, 0.38f, -1.42f, -0.01f);
        v12.close();
        v12.moveTo(17.610001f, 1.4f);
        v12.curveTo(16.040001f, 0.57f, 14.06f, -0.03f, 11.81f, 0.02f);
        v12.curveToRelative(-0.18f, 0f, -0.26f, 0.22f, -0.14f, 0.35f);
        v12.lineToRelative(3.48f, 3.48f);
        v12.lineToRelative(1.33f, -1.33f);
        v12.curveToRelative(3.09f, 1.46f, 5.34f, 4.37f, 5.89f, 7.86f);
        v12.curveToRelative(0.06f, 0.41f, 0.44f, 0.69f, 0.86f, 0.62f);
        v12.curveToRelative(0.41f, -0.06f, 0.69f, -0.45f, 0.62f, -0.86f);
        v12.curveToRelative(-0.6f, -3.8f, -2.96f, -7f, -6.24f, -8.74f);
        v12.close();
        v12.moveTo(8.85f, 20.16f);
        v12.lineToRelative(-1.33f, 1.33f);
        v12.curveToRelative(-3.09f, -1.46f, -5.34f, -4.37f, -5.89f, -7.86f);
        v12.curveToRelative(-0.06f, -0.41f, -0.44f, -0.69f, -0.86f, -0.62f);
        v12.curveToRelative(-0.41f, 0.06f, -0.69f, 0.45f, -0.62f, 0.86f);
        v12.curveToRelative(0.6f, 3.81f, 2.96f, 7.01f, 6.24f, 8.75f);
        v12.curveToRelative(1.57f, 0.83f, 3.55f, 1.43f, 5.8f, 1.38f);
        v12.curveToRelative(0.18f, 0f, 0.26f, -0.22f, 0.14f, -0.35f);
        v12.lineToRelative(-3.48f, -3.49f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ScreenRotationKt._screenRotation = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

