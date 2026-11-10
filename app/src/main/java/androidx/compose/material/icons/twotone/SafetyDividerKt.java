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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_safetyDivider", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SafetyDivider", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSafetyDivider", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SafetyDividerKt {
    private static ImageVector _safetyDivider;

    static {
    }

    public static final ImageVector getSafetyDivider(TwoTone arg19) {
        ImageVector v0 = SafetyDividerKt._safetyDivider;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.SafetyDivider", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11f, 5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(14f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(5f);
        v12.close();
        v12.moveTo(5f, 12f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.curveTo(3f, 11.1f, 3.9f, 12f, 5f, 12f);
        v12.close();
        v12.moveTo(7.78f, 13.58f);
        v12.curveTo(6.93f, 13.21f, 5.99f, 13f, 5f, 13f);
        v12.reflectiveCurveToRelative(-1.93f, 0.21f, -2.78f, 0.58f);
        v12.curveTo(1.48f, 13.9f, 1f, 14.62f, 1f, 15.43f);
        v12.lineTo(1f, 16f);
        v12.horizontalLineToRelative(8f);
        v12.lineToRelative(0f, -0.57f);
        v12.curveTo(9f, 14.62f, 8.52f, 13.9f, 7.78f, 13.58f);
        v12.close();
        v12.moveTo(19f, 12f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.curveTo(17f, 11.1f, 17.9f, 12f, 19f, 12f);
        v12.close();
        v12.moveTo(21.780001f, 13.58f);
        v12.curveTo(20.93f, 13.21f, 19.99f, 13f, 19f, 13f);
        v12.reflectiveCurveToRelative(-1.93f, 0.21f, -2.78f, 0.58f);
        v12.curveTo(15.48f, 13.9f, 15f, 14.62f, 15f, 15.43f);
        v12.lineTo(15f, 16f);
        v12.horizontalLineToRelative(8f);
        v12.lineToRelative(0f, -0.57f);
        v12.curveTo(23f, 14.62f, 22.52f, 13.9f, 21.780001f, 13.58f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SafetyDividerKt._safetyDivider = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

