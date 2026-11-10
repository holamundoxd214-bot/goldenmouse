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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_permCameraMic", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PermCameraMic", "Landroidx/compose/material/icons/Icons$Rounded;", "getPermCameraMic", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PermCameraMicKt {
    private static ImageVector _permCameraMic;

    static {
    }

    public static final ImageVector getPermCameraMic(Rounded arg19) {
        ImageVector v0 = PermCameraMicKt._permCameraMic;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.PermCameraMic", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 5f);
        v12.horizontalLineToRelative(-3.17f);
        v12.lineToRelative(-1.24f, -1.35f);
        v12.curveToRelative(-0.37f, -0.41f, -0.91f, -0.65f, -1.47f, -0.65f);
        v12.lineTo(9.88f, 3f);
        v12.curveToRelative(-0.56f, 0f, -1.1f, 0.24f, -1.48f, 0.65f);
        v12.lineTo(7.17f, 5f);
        v12.lineTo(4f, 5f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(7f);
        v12.verticalLineToRelative(-2.09f);
        v12.curveToRelative(-2.45f, -0.42f, -4.41f, -2.32f, -4.89f, -4.75f);
        v12.curveToRelative(-0.12f, -0.61f, 0.38f, -1.16f, 0.99f, -1.16f);
        v12.curveToRelative(0.49f, 0f, 0.88f, 0.35f, 0.98f, 0.83f);
        v12.curveTo(8.47f, 15.64f, 10.07f, 17f, 12f, 17f);
        v12.reflectiveCurveToRelative(3.53f, -1.36f, 3.91f, -3.17f);
        v12.curveToRelative(0.1f, -0.48f, 0.5f, -0.83f, 0.98f, -0.83f);
        v12.curveToRelative(0.61f, 0f, 1.11f, 0.55f, 0.99f, 1.16f);
        v12.curveToRelative(-0.48f, 2.43f, -2.44f, 4.34f, -4.89f, 4.75f);
        v12.lineTo(12.99f, 21f);
        v12.horizontalLineToRelative(7f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(21.99f, 7f);
        v12.curveTo(22f, 5.9f, 21.1f, 5f, 20f, 5f);
        v12.close();
        v12.moveTo(14f, 13f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f);
        v12.lineTo(10f, 9f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.verticalLineToRelative(4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PermCameraMicKt._permCameraMic = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

