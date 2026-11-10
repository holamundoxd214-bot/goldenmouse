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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_controlPointDuplicate", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ControlPointDuplicate", "Landroidx/compose/material/icons/Icons$Filled;", "getControlPointDuplicate", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ControlPointDuplicateKt {
    private static ImageVector _controlPointDuplicate;

    static {
    }

    public static final ImageVector getControlPointDuplicate(Filled arg19) {
        ImageVector v0 = ControlPointDuplicateKt._controlPointDuplicate;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.ControlPointDuplicate", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 8f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-3f);
        v12.close();
        v12.moveTo(2f, 12f);
        v12.curveToRelative(0f, -2.79f, 1.64f, -5.2f, 4.01f, -6.32f);
        v12.lineTo(6.01f, 3.52f);
        v12.curveTo(2.52f, 4.76f, 0f, 8.09f, 0f, 12f);
        v12.reflectiveCurveToRelative(2.52f, 7.24f, 6.01f, 8.48f);
        v12.verticalLineToRelative(-2.16f);
        v12.curveTo(3.64f, 17.200001f, 2f, 14.79f, 2f, 12f);
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

