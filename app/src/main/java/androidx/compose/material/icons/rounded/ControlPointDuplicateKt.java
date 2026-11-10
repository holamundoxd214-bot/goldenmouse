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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_controlPointDuplicate", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ControlPointDuplicate", "Landroidx/compose/material/icons/Icons$Rounded;", "getControlPointDuplicate", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ControlPointDuplicateKt {
    private static ImageVector _controlPointDuplicate;

    static {
    }

    public static final ImageVector getControlPointDuplicate(Rounded arg19) {
        ImageVector v0 = ControlPointDuplicateKt._controlPointDuplicate;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ControlPointDuplicate", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15f, 8f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-2f);
        v12.lineTo(16f, 9f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.close();
        v12.moveTo(2f, 12f);
        v12.curveToRelative(0f, -2.58f, 1.4f, -4.83f, 3.48f, -6.04f);
        v12.curveToRelative(0.32f, -0.19f, 0.53f, -0.51f, 0.53f, -0.88f);
        v12.curveToRelative(0f, -0.77f, -0.84f, -1.25f, -1.51f, -0.86f);
        v12.curveTo(1.82f, 5.78f, 0f, 8.68f, 0f, 12f);
        v12.reflectiveCurveToRelative(1.82f, 6.22f, 4.5f, 7.78f);
        v12.curveToRelative(0.67f, 0.39f, 1.51f, -0.09f, 1.51f, -0.86f);
        v12.curveToRelative(0f, -0.37f, -0.21f, -0.69f, -0.53f, -0.88f);
        v12.curveTo(3.4f, 16.83f, 2f, 14.58f, 2f, 12f);
        v12.close();
        v12.moveTo(15f, 3f);
        v12.curveToRelative(-4.96f, 0f, -9f, 4.04f, -9f, 9f);
        v12.reflectiveCurveToRelative(4.04f, 9f, 9f, 9f);
        v12.reflectiveCurveToRelative(9f, -4.04f, 9f, -9f);
        v12.reflectiveCurveToRelative(-4.04f, -9f, -9f, -9f);
        v12.close();
        v12.moveTo(15f, 19f);
        v12.curveToRelative(-3.86f, 0f, -7f, -3.14f, -7f, -7f);
        v12.reflectiveCurveToRelative(3.14f, -7f, 7f, -7f);
        v12.reflectiveCurveToRelative(7f, 3.14f, 7f, 7f);
        v12.reflectiveCurveToRelative(-3.14f, 7f, -7f, 7f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ControlPointDuplicateKt._controlPointDuplicate = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

