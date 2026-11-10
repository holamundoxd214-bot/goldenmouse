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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_groups", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Groups", "Landroidx/compose/material/icons/Icons$Outlined;", "getGroups", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class GroupsKt {
    private static ImageVector _groups;

    static {
    }

    public static final ImageVector getGroups(Outlined arg19) {
        ImageVector v0 = GroupsKt._groups;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Groups", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4f, 13f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.curveTo(2f, 12.1f, 2.9f, 13f, 4f, 13f);
        v12.close();
        v12.moveTo(5.13f, 14.1f);
        v12.curveTo(4.76f, 14.04f, 4.39f, 14f, 4f, 14f);
        v12.curveToRelative(-0.99f, 0f, -1.93f, 0.21f, -2.78f, 0.58f);
        v12.curveTo(0.48f, 14.9f, 0f, 15.62f, 0f, 16.43f);
        v12.verticalLineTo(18f);
        v12.lineToRelative(4.5f, 0f);
        v12.verticalLineToRelative(-1.61f);
        v12.curveTo(4.5f, 15.56f, 4.73f, 14.78f, 5.13f, 14.1f);
        v12.close();
        v12.moveTo(20f, 13f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.curveTo(18f, 12.1f, 18.9f, 13f, 20f, 13f);
        v12.close();
        v12.moveTo(24f, 16.43f);
        v12.curveToRelative(0f, -0.81f, -0.48f, -1.53f, -1.22f, -1.85f);
        v12.curveTo(21.93f, 14.21f, 20.99f, 14f, 20f, 14f);
        v12.curveToRelative(-0.39f, 0f, -0.76f, 0.04f, -1.13f, 0.1f);
        v12.curveToRelative(0.4f, 0.68f, 0.63f, 1.46f, 0.63f, 2.29f);
        v12.verticalLineTo(18f);
        v12.lineToRelative(4.5f, 0f);
        v12.verticalLineTo(16.43f);
        v12.close();
        v12.moveTo(16.24f, 13.65f);
        v12.curveToRelative(-1.17f, -0.52f, -2.61f, -0.9f, -4.24f, -0.9f);
        v12.curveToRelative(-1.63f, 0f, -3.07f, 0.39f, -4.24f, 0.9f);
        v12.curveTo(6.68f, 14.13f, 6f, 15.21f, 6f, 16.389999f);
        v12.verticalLineTo(18f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(-1.61f);
        v12.curveTo(18f, 15.21f, 17.32f, 14.13f, 16.24f, 13.65f);
        v12.close();
        v12.moveTo(8.07f, 16f);
        v12.curveToRelative(0.09f, -0.23f, 0.13f, -0.39f, 0.91f, -0.69f);
        v12.curveToRelative(0.97f, -0.38f, 1.99f, -0.56f, 3.02f, -0.56f);
        v12.reflectiveCurveToRelative(2.05f, 0.18f, 3.02f, 0.56f);
        v12.curveToRelative(0.77f, 0.3f, 0.81f, 0.46f, 0.91f, 0.69f);
        v12.horizontalLineTo(8.07f);
        v12.close();
        v12.moveTo(12f, 8f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveTo(11.45f, 8f, 12f, 8f);
        v12.moveTo(12f, 6f);
        v12.curveToRelative(-1.66f, 0f, -3f, 1.34f, -3f, 3f);
        v12.curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f);
        v12.reflectiveCurveToRelative(3f, -1.34f, 3f, -3f);
        v12.curveTo(15f, 7.34f, 13.66f, 6f, 12f, 6f);
        v12.lineTo(12f, 6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        GroupsKt._groups = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

