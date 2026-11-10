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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_fireExtinguisher", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FireExtinguisher", "Landroidx/compose/material/icons/Icons$TwoTone;", "getFireExtinguisher", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FireExtinguisherKt {
    private static ImageVector _fireExtinguisher;

    static {
    }

    public static final ImageVector getFireExtinguisher(TwoTone arg19) {
        ImageVector v0 = FireExtinguisherKt._fireExtinguisher;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.FireExtinguisher", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7f, 19f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.horizontalLineTo(9f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.verticalLineTo(19f);
        v12.close();
        v12.moveTo(7f, 18f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(-5f);
        v12.horizontalLineTo(7f);
        v12.verticalLineTo(18f);
        v12.close();
        v12.moveTo(17f, 3f);
        v12.verticalLineToRelative(6f);
        v12.lineToRelative(-3.15f, -0.66f);
        v12.curveToRelative(-0.01f, 0f, -0.01f, 0.01f, -0.02f, 0.02f);
        v12.curveToRelative(1.55f, 0.62f, 2.72f, 1.98f, 3.07f, 3.64f);
        v12.horizontalLineTo(7.1f);
        v12.curveToRelative(0.34f, -1.66f, 1.52f, -3.02f, 3.07f, -3.64f);
        v12.curveToRelative(-0.33f, -0.26f, -0.6f, -0.58f, -0.8f, -0.95f);
        v12.lineTo(5f, 6.5f);
        v12.verticalLineToRelative(-1f);
        v12.lineToRelative(4.37f, -0.91f);
        v12.curveTo(9.87f, 3.65f, 10.86f, 3f, 12f, 3f);
        v12.curveToRelative(0.7f, 0f, 1.34f, 0.25f, 1.85f, 0.66f);
        v12.lineTo(17f, 3f);
        v12.close();
        v12.moveTo(13f, 6f);
        v12.curveToRelative(-0.03f, -0.59f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveTo(13f, 6.55f, 13f, 6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FireExtinguisherKt._fireExtinguisher = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

