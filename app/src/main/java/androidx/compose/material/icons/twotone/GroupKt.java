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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_group", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Group", "Landroidx/compose/material/icons/Icons$TwoTone;", "getGroup", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class GroupKt {
    private static ImageVector _group;

    static {
    }

    public static final ImageVector getGroup(TwoTone arg20) {
        ImageVector v0 = GroupKt._group;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Group", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9f, 8.5f);
        v12.moveToRelative(-1.5f, 0f);
        v12.arcToRelative(1.5f, 1.5f, 0f, true, true, 3f, 0f);
        v12.arcToRelative(1.5f, 1.5f, 0f, true, true, -3f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(4.34f, 17f);
        v12.horizontalLineToRelative(9.32f);
        v12.curveToRelative(-0.84f, -0.58f, -2.87f, -1.25f, -4.66f, -1.25f);
        v12.reflectiveCurveToRelative(-3.82f, 0.67f, -4.66f, 1.25f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(9f, 12f);
        v12.curveToRelative(1.93f, 0f, 3.5f, -1.57f, 3.5f, -3.5f);
        v12.reflectiveCurveTo(10.93f, 5f, 9f, 5f);
        v12.reflectiveCurveTo(5.5f, 6.57f, 5.5f, 8.5f);
        v12.reflectiveCurveTo(7.07f, 12f, 9f, 12f);
        v12.close();
        v12.moveTo(9f, 7f);
        v12.curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(9.83f, 10f, 9f, 10f);
        v12.reflectiveCurveToRelative(-1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveTo(8.17f, 7f, 9f, 7f);
        v12.close();
        v12.moveTo(9f, 13.75f);
        v12.curveToRelative(-2.34f, 0f, -7f, 1.17f, -7f, 3.5f);
        v12.lineTo(2f, 19f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineToRelative(-1.75f);
        v12.curveToRelative(0f, -2.33f, -4.66f, -3.5f, -7f, -3.5f);
        v12.close();
        v12.moveTo(4.34f, 17f);
        v12.curveToRelative(0.84f, -0.58f, 2.87f, -1.25f, 4.66f, -1.25f);
        v12.reflectiveCurveToRelative(3.82f, 0.67f, 4.66f, 1.25f);
        v12.lineTo(4.34f, 17f);
        v12.close();
        v12.moveTo(16.040001f, 13.81f);
        v12.curveToRelative(1.16f, 0.84f, 1.96f, 1.96f, 1.96f, 3.44f);
        v12.lineTo(18f, 19f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(-1.75f);
        v12.curveToRelative(0f, -2.02f, -3.5f, -3.17f, -5.96f, -3.44f);
        v12.close();
        v12.moveTo(15f, 12f);
        v12.curveToRelative(1.93f, 0f, 3.5f, -1.57f, 3.5f, -3.5f);
        v12.reflectiveCurveTo(16.93f, 5f, 15f, 5f);
        v12.curveToRelative(-0.54f, 0f, -1.04f, 0.13f, -1.5f, 0.35f);
        v12.curveToRelative(0.63f, 0.89f, 1f, 1.98f, 1f, 3.15f);
        v12.reflectiveCurveToRelative(-0.37f, 2.26f, -1f, 3.15f);
        v12.curveToRelative(0.46f, 0.22f, 0.96f, 0.35f, 1.5f, 0.35f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        GroupKt._group = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

