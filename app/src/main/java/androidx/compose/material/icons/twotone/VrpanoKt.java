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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_vrpano", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Vrpano", "Landroidx/compose/material/icons/Icons$TwoTone;", "getVrpano", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VrpanoKt {
    private static ImageVector _vrpano;

    static {
    }

    public static final ImageVector getVrpano(TwoTone arg19) {
        ImageVector v0 = VrpanoKt._vrpano;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Vrpano", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4f, 6.38f);
        v12.verticalLineToRelative(11.25f);
        v12.curveToRelative(2.01f, -0.59f, 4.61f, -1.13f, 8f, -1.13f);
        v12.curveToRelative(3.38f, 0f, 5.99f, 0.54f, 8f, 1.13f);
        v12.verticalLineTo(6.37f);
        v12.curveToRelative(-2.01f, 0.59f, -4.62f, 1.13f, -8f, 1.13f);
        v12.curveTo(9.32f, 7.5f, 6.58f, 7.11f, 4f, 6.38f);
        v12.close();
        v12.moveTo(18.51f, 15.4f);
        v12.curveTo(16.52f, 15.15f, 14.3f, 15f, 12f, 15f);
        v12.curveToRelative(-2.34f, 0f, -4.52f, 0.15f, -6.52f, 0.41f);
        v12.lineToRelative(3.69f, -4.42f);
        v12.lineToRelative(2f, 2.4f);
        v12.lineTo(14f, 10f);
        v12.lineTo(18.51f, 15.4f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(21.01f, 4f);
        v12.curveTo(20.450001f, 4f, 17.4f, 5.5f, 12f, 5.5f);
        v12.curveToRelative(-5.31f, 0f, -8.49f, -1.49f, -9.01f, -1.49f);
        v12.curveTo(2.46f, 4.01f, 2f, 4.45f, 2f, 5.02f);
        v12.verticalLineTo(19f);
        v12.curveToRelative(0f, 0.57f, 0.46f, 1f, 0.99f, 1f);
        v12.curveToRelative(0.57f, 0f, 3.55f, -1.5f, 9.01f, -1.5f);
        v12.curveToRelative(5.42f, 0f, 8.44f, 1.5f, 9.01f, 1.5f);
        v12.curveToRelative(0.53f, 0f, 0.99f, -0.43f, 0.99f, -1f);
        v12.verticalLineTo(5f);
        v12.curveTo(22f, 4.43f, 21.540001f, 4f, 21.01f, 4f);
        v12.close();
        v12.moveTo(20f, 17.629999f);
        v12.curveToRelative(-2.01f, -0.59f, -4.62f, -1.13f, -8f, -1.13f);
        v12.curveToRelative(-3.39f, 0f, -5.99f, 0.54f, -8f, 1.13f);
        v12.verticalLineTo(6.38f);
        v12.curveTo(6.58f, 7.11f, 9.32f, 7.5f, 12f, 7.5f);
        v12.curveToRelative(3.38f, 0f, 5.99f, -0.54f, 8f, -1.13f);
        v12.verticalLineTo(17.629999f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(9.17f, 10.99f);
        v12.lineToRelative(-3.69f, 4.42f);
        v12.curveTo(7.48f, 15.15f, 9.66f, 15f, 12f, 15f);
        v12.curveToRelative(2.3f, 0f, 4.52f, 0.15f, 6.51f, 0.4f);
        v12.lineTo(14f, 10f);
        v12.lineToRelative(-2.83f, 3.39f);
        v12.lineTo(9.17f, 10.99f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VrpanoKt._vrpano = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

