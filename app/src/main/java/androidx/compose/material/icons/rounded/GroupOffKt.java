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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_groupOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "GroupOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getGroupOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class GroupOffKt {
    private static ImageVector _groupOff;

    static {
    }

    public static final ImageVector getGroupOff(Rounded arg19) {
        ImageVector v0 = GroupOffKt._groupOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.GroupOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15f, 8f);
        v12.curveToRelative(0f, -1.42f, -0.5f, -2.73f, -1.33f, -3.76f);
        v12.curveTo(14.09f, 4.1f, 14.53f, 4f, 15f, 4f);
        v12.curveToRelative(2.21f, 0f, 4f, 1.79f, 4f, 4f);
        v12.reflectiveCurveToRelative(-1.79f, 4f, -4f, 4f);
        v12.curveToRelative(-0.06f, 0f, -0.12f, 0f, -0.18f, 0f);
        v12.lineToRelative(-0.77f, -0.77f);
        v12.curveTo(14.65f, 10.29f, 15f, 9.18f, 15f, 8f);
        v12.close();
        v12.moveTo(7.24f, 4.41f);
        v12.curveTo(7.77f, 4.15f, 8.37f, 4f, 9f, 4f);
        v12.curveToRelative(2.21f, 0f, 4f, 1.79f, 4f, 4f);
        v12.curveToRelative(0f, 0.63f, -0.15f, 1.23f, -0.41f, 1.76f);
        v12.lineTo(7.24f, 4.41f);
        v12.close();
        v12.moveTo(21.190001f, 21.190001f);
        v12.curveToRelative(0.39f, 0.39f, 0.39f, 1.02f, 0f, 1.41f);
        v12.reflectiveCurveToRelative(-1.02f, 0.39f, -1.41f, 0f);
        v12.lineToRelative(-2.99f, -2.99f);
        v12.curveTo(16.6f, 19.85f, 16.32f, 20f, 16f, 20f);
        v12.horizontalLineTo(2f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(0f, -2.66f, 5.33f, -4f, 8f, -4f);
        v12.curveToRelative(0.37f, 0f, 0.8f, 0.03f, 1.25f, 0.08f);
        v12.lineTo(9.17f, 12f);
        v12.curveTo(9.11f, 12f, 9.06f, 12f, 9f, 12f);
        v12.curveToRelative(-2.21f, 0f, -4f, -1.79f, -4f, -4f);
        v12.curveToRelative(0f, -0.06f, 0f, -0.11f, 0f, -0.17f);
        v12.lineTo(1.39f, 4.22f);
        v12.curveTo(1f, 3.83f, 1f, 3.2f, 1.39f, 2.81f);
        v12.reflectiveCurveToRelative(1.02f, -0.39f, 1.41f, 0f);
        v12.lineTo(21.190001f, 21.190001f);
        v12.close();
        v12.moveTo(18.889999f, 16.07f);
        v12.curveToRelative(-0.29f, -1.22f, -1.13f, -2.19f, -2.23f, -2.94f);
        v12.curveTo(19.42f, 13.53f, 23f, 14.82f, 23f, 17f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 0.32f, -0.15f, 0.6f, -0.38f, 0.79f);
        v12.lineTo(18.889999f, 16.07f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        GroupOffKt._groupOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

