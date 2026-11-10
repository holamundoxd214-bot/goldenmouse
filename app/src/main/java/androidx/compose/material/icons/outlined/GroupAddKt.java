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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_groupAdd", "Landroidx/compose/ui/graphics/vector/ImageVector;", "GroupAdd", "Landroidx/compose/material/icons/Icons$Outlined;", "getGroupAdd", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class GroupAddKt {
    private static ImageVector _groupAdd;

    static {
    }

    public static final ImageVector getGroupAdd(Outlined arg19) {
        ImageVector v0 = GroupAddKt._groupAdd;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.GroupAdd", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(22f, 9f);
        v0_1.lineToRelative(0f, -2f);
        v0_1.lineToRelative(-2f, 0f);
        v0_1.lineToRelative(0f, 2f);
        v0_1.lineToRelative(-2f, 0f);
        v0_1.lineToRelative(0f, 2f);
        v0_1.lineToRelative(2f, 0f);
        v0_1.lineToRelative(0f, 2f);
        v0_1.lineToRelative(2f, 0f);
        v0_1.lineToRelative(0f, -2f);
        v0_1.lineToRelative(2f, 0f);
        v0_1.lineToRelative(0f, -2f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8f, 12f);
        v12.curveToRelative(2.21f, 0f, 4f, -1.79f, 4f, -4f);
        v12.reflectiveCurveToRelative(-1.79f, -4f, -4f, -4f);
        v12.reflectiveCurveTo(4f, 5.79f, 4f, 8f);
        v12.reflectiveCurveTo(5.79f, 12f, 8f, 12f);
        v12.close();
        v12.moveTo(8f, 6f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.reflectiveCurveToRelative(-0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveTo(6f, 9.1f, 6f, 8f);
        v12.reflectiveCurveTo(6.9f, 6f, 8f, 6f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(8f, 13f);
        v12.curveToRelative(-2.67f, 0f, -8f, 1.34f, -8f, 4f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineToRelative(-3f);
        v12.curveTo(16f, 14.34f, 10.67f, 13f, 8f, 13f);
        v12.close();
        v12.moveTo(14f, 18f);
        v12.horizontalLineTo(2f);
        v12.verticalLineToRelative(-0.99f);
        v12.curveTo(2.2f, 16.290001f, 5.3f, 15f, 8f, 15f);
        v12.reflectiveCurveToRelative(5.8f, 1.29f, 6f, 2f);
        v12.verticalLineTo(18f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12.51f, 4.05f);
        v12.curveTo(13.43f, 5.11f, 14f, 6.49f, 14f, 8f);
        v12.reflectiveCurveToRelative(-0.57f, 2.89f, -1.49f, 3.95f);
        v12.curveTo(14.47f, 11.7f, 16f, 10.04f, 16f, 8f);
        v12.reflectiveCurveTo(14.47f, 4.3f, 12.51f, 4.05f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(16.530001f, 13.83f);
        v12.curveTo(17.42f, 14.66f, 18f, 15.7f, 18f, 17f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-3f);
        v12.curveTo(20f, 15.55f, 18.41f, 14.49f, 16.530001f, 13.83f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        GroupAddKt._groupAdd = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

