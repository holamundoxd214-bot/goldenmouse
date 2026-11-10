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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_rotateRight", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RotateRight", "Landroidx/compose/material/icons/Icons$Rounded;", "getRotateRight$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getRotateRight", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RotateRightKt {
    private static ImageVector _rotateRight;

    static {
    }

    public static final ImageVector getRotateRight(Rounded arg19) {
        ImageVector v0 = RotateRightKt._rotateRight;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.RotateRight", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.83f, 4.83f);
        v12.lineTo(12.7f, 2.7f);
        v12.curveToRelative(-0.62f, -0.62f, -1.7f, -0.18f, -1.7f, 0.71f);
        v12.verticalLineToRelative(0.66f);
        v12.curveTo(7.06f, 4.56f, 4f, 7.92f, 4f, 12f);
        v12.curveToRelative(0f, 3.64f, 2.43f, 6.71f, 5.77f, 7.68f);
        v12.curveToRelative(0.62f, 0.18f, 1.23f, -0.32f, 1.23f, -0.96f);
        v12.verticalLineToRelative(-0.03f);
        v12.curveToRelative(0f, -0.43f, -0.27f, -0.82f, -0.68f, -0.94f);
        v12.curveTo(7.82f, 17.030001f, 6f, 14.73f, 6f, 12f);
        v12.curveToRelative(0f, -2.97f, 2.16f, -5.43f, 5f, -5.91f);
        v12.verticalLineToRelative(1.53f);
        v12.curveToRelative(0f, 0.89f, 1.07f, 1.33f, 1.7f, 0.71f);
        v12.lineToRelative(2.13f, -2.08f);
        v12.curveToRelative(0.4f, -0.38f, 0.4f, -1.02f, 0f, -1.42f);
        v12.close();
        v12.moveTo(19.67f, 9.76f);
        v12.curveToRelative(-0.16f, -0.55f, -0.38f, -1.08f, -0.66f, -1.59f);
        v12.curveToRelative(-0.31f, -0.57f, -1.1f, -0.66f, -1.56f, -0.2f);
        v12.lineToRelative(-0.01f, 0.01f);
        v12.curveToRelative(-0.31f, 0.31f, -0.38f, 0.78f, -0.17f, 1.16f);
        v12.curveToRelative(0.2f, 0.37f, 0.36f, 0.76f, 0.48f, 1.16f);
        v12.curveToRelative(0.12f, 0.42f, 0.51f, 0.7f, 0.94f, 0.7f);
        v12.horizontalLineToRelative(0.02f);
        v12.curveToRelative(0.65f, 0f, 1.15f, -0.62f, 0.96f, -1.24f);
        v12.close();
        v12.moveTo(13f, 18.68f);
        v12.verticalLineToRelative(0.02f);
        v12.curveToRelative(0f, 0.65f, 0.62f, 1.14f, 1.24f, 0.96f);
        v12.curveToRelative(0.55f, -0.16f, 1.08f, -0.38f, 1.59f, -0.66f);
        v12.curveToRelative(0.57f, -0.31f, 0.66f, -1.1f, 0.2f, -1.56f);
        v12.lineToRelative(-0.02f, -0.02f);
        v12.curveToRelative(-0.31f, -0.31f, -0.78f, -0.38f, -1.16f, -0.17f);
        v12.curveToRelative(-0.37f, 0.21f, -0.76f, 0.37f, -1.16f, 0.49f);
        v12.curveToRelative(-0.41f, 0.12f, -0.69f, 0.51f, -0.69f, 0.94f);
        v12.close();
        v12.moveTo(17.440001f, 16.030001f);
        v12.curveToRelative(0.46f, 0.46f, 1.25f, 0.37f, 1.56f, -0.2f);
        v12.curveToRelative(0.28f, -0.51f, 0.5f, -1.04f, 0.67f, -1.59f);
        v12.curveToRelative(0.18f, -0.62f, -0.31f, -1.24f, -0.96f, -1.24f);
        v12.horizontalLineToRelative(-0.02f);
        v12.curveToRelative(-0.44f, 0f, -0.82f, 0.28f, -0.94f, 0.7f);
        v12.curveToRelative(-0.12f, 0.4f, -0.28f, 0.79f, -0.48f, 1.17f);
        v12.curveToRelative(-0.21f, 0.38f, -0.13f, 0.86f, 0.17f, 1.16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RotateRightKt._rotateRight = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Rounded.RotateRight", replaceWith="<_subannotation>") public static void getRotateRight$annotations(Rounded arg0) {
    }
}

