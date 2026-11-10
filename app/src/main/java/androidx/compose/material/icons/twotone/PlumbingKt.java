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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_plumbing", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Plumbing", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPlumbing", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PlumbingKt {
    private static ImageVector _plumbing;

    static {
    }

    public static final ImageVector getPlumbing(TwoTone arg19) {
        ImageVector v0 = PlumbingKt._plumbing;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Plumbing", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.280001f, 4.93f);
        v12.lineToRelative(-2.12f, -2.12f);
        v12.curveToRelative(-0.78f, -0.78f, -2.05f, -0.78f, -2.83f, 0f);
        v12.lineTo(11.5f, 5.64f);
        v12.lineToRelative(2.12f, 2.12f);
        v12.lineToRelative(2.12f, -2.12f);
        v12.lineToRelative(3.54f, 3.54f);
        v12.curveTo(20.450001f, 8f, 20.450001f, 6.1f, 19.280001f, 4.93f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(5.49f, 13.77f);
        v12.curveToRelative(0.59f, 0.59f, 1.54f, 0.59f, 2.12f, 0f);
        v12.lineToRelative(2.47f, -2.47f);
        v12.lineTo(7.96f, 9.17f);
        v12.lineToRelative(-2.47f, 2.47f);
        v12.curveTo(4.9f, 12.23f, 4.9f, 13.18f, 5.49f, 13.77f);
        v12.lineTo(5.49f, 13.77f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(15.04f, 7.76f);
        v12.lineToRelative(-0.71f, 0.71f);
        v12.lineToRelative(-0.71f, 0.71f);
        v12.lineToRelative(-3.18f, -3.18f);
        v12.curveTo(9.85f, 5.4f, 8.9f, 5.4f, 8.32f, 5.99f);
        v12.curveToRelative(-0.59f, 0.59f, -0.59f, 1.54f, 0f, 2.12f);
        v12.lineToRelative(3.18f, 3.18f);
        v12.lineTo(10.79f, 12f);
        v12.lineToRelative(-6.36f, 6.36f);
        v12.curveToRelative(-0.78f, 0.78f, -0.78f, 2.05f, 0f, 2.83f);
        v12.curveToRelative(0.78f, 0.78f, 2.05f, 0.78f, 2.83f, 0f);
        v12.lineTo(16.450001f, 12f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(15.04f, 7.76f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PlumbingKt._plumbing = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

