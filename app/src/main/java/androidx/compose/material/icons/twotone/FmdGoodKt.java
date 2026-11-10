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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_fmdGood", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FmdGood", "Landroidx/compose/material/icons/Icons$TwoTone;", "getFmdGood", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FmdGoodKt {
    private static ImageVector _fmdGood;

    static {
    }

    public static final ImageVector getFmdGood(TwoTone arg19) {
        ImageVector v0 = FmdGoodKt._fmdGood;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.FmdGood", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 4f);
        v12.curveToRelative(-3.35f, 0f, -6f, 2.57f, -6f, 6.2f);
        v12.curveToRelative(0f, 2.34f, 1.95f, 5.44f, 6f, 9.14f);
        v12.curveToRelative(4.05f, -3.7f, 6f, -6.79f, 6f, -9.14f);
        v12.curveTo(18f, 6.57f, 15.35f, 4f, 12f, 4f);
        v12.close();
        v12.moveTo(12f, 12f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.curveTo(14f, 11.1f, 13.1f, 12f, 12f, 12f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 8f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.curveTo(14f, 8.9f, 13.1f, 8f, 12f, 8f);
        v12.close();
        v12.moveTo(12f, 2f);
        v12.curveToRelative(-4.2f, 0f, -8f, 3.22f, -8f, 8.2f);
        v12.curveToRelative(0f, 3.32f, 2.67f, 7.25f, 8f, 11.8f);
        v12.curveToRelative(5.33f, -4.55f, 8f, -8.48f, 8f, -11.8f);
        v12.curveTo(20f, 5.22f, 16.200001f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(12f, 19.33f);
        v12.curveToRelative(-4.05f, -3.7f, -6f, -6.79f, -6f, -9.14f);
        v12.curveTo(6f, 6.57f, 8.65f, 4f, 12f, 4f);
        v12.reflectiveCurveToRelative(6f, 2.57f, 6f, 6.2f);
        v12.curveTo(18f, 12.54f, 16.049999f, 15.64f, 12f, 19.33f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FmdGoodKt._fmdGood = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

