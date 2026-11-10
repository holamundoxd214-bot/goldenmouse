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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_rotateRight", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RotateRight", "Landroidx/compose/material/icons/Icons$Outlined;", "getRotateRight$annotations", "(Landroidx/compose/material/icons/Icons$Outlined;)V", "getRotateRight", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RotateRightKt {
    private static ImageVector _rotateRight;

    static {
    }

    public static final ImageVector getRotateRight(Outlined arg19) {
        ImageVector v0 = RotateRightKt._rotateRight;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.RotateRight", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.55f, 5.55f);
        v12.lineTo(11f, 1f);
        v12.verticalLineToRelative(3.07f);
        v12.curveTo(7.06f, 4.56f, 4f, 7.92f, 4f, 12f);
        v12.reflectiveCurveToRelative(3.05f, 7.44f, 7f, 7.93f);
        v12.verticalLineToRelative(-2.02f);
        v12.curveToRelative(-2.84f, -0.48f, -5f, -2.94f, -5f, -5.91f);
        v12.reflectiveCurveToRelative(2.16f, -5.43f, 5f, -5.91f);
        v12.lineTo(11f, 10f);
        v12.lineToRelative(4.55f, -4.45f);
        v12.close();
        v12.moveTo(19.93f, 11f);
        v12.curveToRelative(-0.17f, -1.39f, -0.72f, -2.73f, -1.62f, -3.89f);
        v12.lineToRelative(-1.42f, 1.42f);
        v12.curveToRelative(0.54f, 0.75f, 0.88f, 1.6f, 1.02f, 2.47f);
        v12.horizontalLineToRelative(2.02f);
        v12.close();
        v12.moveTo(13f, 17.9f);
        v12.verticalLineToRelative(2.02f);
        v12.curveToRelative(1.39f, -0.17f, 2.74f, -0.71f, 3.9f, -1.61f);
        v12.lineToRelative(-1.44f, -1.44f);
        v12.curveToRelative(-0.75f, 0.54f, -1.59f, 0.89f, -2.46f, 1.03f);
        v12.close();
        v12.moveTo(16.889999f, 15.48f);
        v12.lineToRelative(1.42f, 1.41f);
        v12.curveToRelative(0.9f, -1.16f, 1.45f, -2.5f, 1.62f, -3.89f);
        v12.horizontalLineToRelative(-2.02f);
        v12.curveToRelative(-0.14f, 0.87f, -0.48f, 1.72f, -1.02f, 2.48f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RotateRightKt._rotateRight = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Outlined.RotateRight", replaceWith="<_subannotation>") public static void getRotateRight$annotations(Outlined arg0) {
    }
}

