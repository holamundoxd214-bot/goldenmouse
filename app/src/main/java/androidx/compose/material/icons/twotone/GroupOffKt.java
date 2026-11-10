package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_groupOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "GroupOff", "Landroidx/compose/material/icons/Icons$TwoTone;", "getGroupOff", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class GroupOffKt {
    private static ImageVector _groupOff;

    static {
    }

    public static final ImageVector getGroupOff(TwoTone arg19) {
        ImageVector v0 = GroupOffKt._groupOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.GroupOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10.99f, 8.16f);
        v12.curveTo(11f, 8.11f, 11f, 8.06f, 11f, 8f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.curveTo(8.94f, 6f, 8.89f, 6f, 8.84f, 6.01f);
        v12.lineTo(10.99f, 8.16f);
        v12.close();
        v12.moveTo(9f, 15f);
        v12.curveToRelative(-2.7f, 0f, -5.8f, 1.29f, -6f, 2.01f);
        v12.verticalLineTo(18f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(-0.17f);
        v12.lineToRelative(-2.11f, -2.11f);
        v12.curveTo(11.76f, 15.31f, 10.33f, 15f, 9f, 15f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(15f, 8f);
        v12.curveToRelative(0f, -1.42f, -0.5f, -2.73f, -1.33f, -3.76f);
        v12.curveTo(14.09f, 4.1f, 14.53f, 4f, 15f, 4f);
        v12.curveToRelative(2.21f, 0f, 4f, 1.79f, 4f, 4f);
        v12.reflectiveCurveToRelative(-1.79f, 4f, -4f, 4f);
        v12.curveToRelative(-0.06f, 0f, -0.12f, 0f, -0.18f, 0f);
        v12.lineToRelative(-0.77f, -0.77f);
        v12.curveTo(14.65f, 10.29f, 15f, 9.18f, 15f, 8f);
        v12.close();
        v12.moveTo(22.83f, 20f);
        v12.horizontalLineTo(23f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(0f, -2.18f, -3.58f, -3.47f, -6.34f, -3.87f);
        v12.curveToRelative(1.1f, 0.75f, 1.95f, 1.71f, 2.23f, 2.94f);
        v12.lineTo(22.83f, 20f);
        v12.close();
        v12.moveTo(9f, 6f);
        v12.curveTo(8.94f, 6f, 8.89f, 6f, 8.84f, 6.01f);
        v12.lineToRelative(-1.6f, -1.6f);
        v12.curveTo(7.77f, 4.15f, 8.37f, 4f, 9f, 4f);
        v12.curveToRelative(2.21f, 0f, 4f, 1.79f, 4f, 4f);
        v12.curveToRelative(0f, 0.63f, -0.15f, 1.23f, -0.41f, 1.76f);
        v12.lineToRelative(-1.6f, -1.6f);
        v12.curveTo(11f, 8.11f, 11f, 8.06f, 11f, 8f);
        v12.curveTo(11f, 6.9f, 10.1f, 6f, 9f, 6f);
        v12.close();
        v12.moveTo(9.17f, 12f);
        v12.curveTo(9.11f, 12f, 9.06f, 12f, 9f, 12f);
        v12.curveToRelative(-2.21f, 0f, -4f, -1.79f, -4f, -4f);
        v12.curveToRelative(0f, -0.06f, 0f, -0.11f, 0f, -0.17f);
        v12.lineTo(0.69f, 3.51f);
        v12.lineTo(2.1f, 2.1f);
        v12.lineToRelative(19.799999f, 19.799999f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.lineTo(17f, 19.83f);
        v12.verticalLineTo(20f);
        v12.horizontalLineTo(1f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(0f, -2.66f, 5.33f, -4f, 8f, -4f);
        v12.curveToRelative(0.37f, 0f, 0.8f, 0.03f, 1.25f, 0.08f);
        v12.lineTo(9.17f, 12f);
        v12.close();
        v12.moveTo(9f, 15f);
        v12.curveToRelative(-2.7f, 0f, -5.8f, 1.29f, -6f, 2.01f);
        v12.verticalLineTo(18f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(-0.17f);
        v12.lineToRelative(-2.11f, -2.11f);
        v12.curveTo(11.76f, 15.31f, 10.33f, 15f, 9f, 15f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        GroupOffKt._groupOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

