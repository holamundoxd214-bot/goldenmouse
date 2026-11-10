package androidx.compose.material.icons.automirrored.outlined;

import androidx.compose.material.icons.Icons$AutoMirrored$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_assignmentReturn", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AssignmentReturn", "Landroidx/compose/material/icons/Icons$AutoMirrored$Outlined;", "getAssignmentReturn", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AssignmentReturnKt {
    private static ImageVector _assignmentReturn;

    static {
    }

    public static final ImageVector getAssignmentReturn(Outlined arg19) {
        ImageVector v0 = AssignmentReturnKt._assignmentReturn;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Outlined.AssignmentReturn", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 14f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(-4f);
        v12.horizontalLineToRelative(-4f);
        v12.lineTo(12f, 7f);
        v12.lineToRelative(-5f, 5f);
        v12.lineToRelative(5f, 5f);
        v12.close();
        v12.moveTo(19f, 3f);
        v12.horizontalLineToRelative(-4.18f);
        v12.curveTo(14.4f, 1.84f, 13.3f, 1f, 12f, 1f);
        v12.curveToRelative(-1.3f, 0f, -2.4f, 0.84f, -2.82f, 2f);
        v12.lineTo(5f, 3f);
        v12.curveToRelative(-0.14f, 0f, -0.27f, 0.01f, -0.4f, 0.04f);
        v12.curveToRelative(-0.39f, 0.08f, -0.74f, 0.28f, -1.01f, 0.55f);
        v12.curveToRelative(-0.18f, 0.18f, -0.33f, 0.4f, -0.43f, 0.64f);
        v12.curveToRelative(-0.1f, 0.23f, -0.16f, 0.49f, -0.16f, 0.77f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 0.27f, 0.06f, 0.54f, 0.16f, 0.78f);
        v12.reflectiveCurveToRelative(0.25f, 0.45f, 0.43f, 0.64f);
        v12.curveToRelative(0.27f, 0.27f, 0.62f, 0.47f, 1.01f, 0.55f);
        v12.curveToRelative(0.13f, 0.02f, 0.26f, 0.03f, 0.4f, 0.03f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(21f, 5f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(12f, 2.75f);
        v12.curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f);
        v12.reflectiveCurveToRelative(-0.34f, 0.75f, -0.75f, 0.75f);
        v12.reflectiveCurveToRelative(-0.75f, -0.34f, -0.75f, -0.75f);
        v12.reflectiveCurveToRelative(0.34f, -0.75f, 0.75f, -0.75f);
        v12.close();
        v12.moveTo(19f, 19f);
        v12.lineTo(5f, 19f);
        v12.lineTo(5f, 5f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineToRelative(14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AssignmentReturnKt._assignmentReturn = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

