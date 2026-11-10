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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_repartition", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Repartition", "Landroidx/compose/material/icons/Icons$Rounded;", "getRepartition", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RepartitionKt {
    private static ImageVector _repartition;

    static {
    }

    public static final ImageVector getRepartition(Rounded arg19) {
        ImageVector v0 = RepartitionKt._repartition;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Repartition", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4.5f, 21f);
        v12.horizontalLineToRelative(15f);
        v12.curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        v12.horizontalLineToRelative(-15f);
        v12.curveTo(3.67f, 15f, 3f, 15.67f, 3f, 16.5f);
        v12.verticalLineToRelative(3f);
        v12.curveTo(3f, 20.33f, 3.67f, 21f, 4.5f, 21f);
        v12.close();
        v12.moveTo(10.33f, 19f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(3.33f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(10.33f);
        v12.close();
        v12.moveTo(19f, 19f);
        v12.horizontalLineToRelative(-3.33f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(19f);
        v12.verticalLineTo(19f);
        v12.close();
        v12.moveTo(5f, 17f);
        v12.horizontalLineToRelative(3.33f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(5f);
        v12.verticalLineTo(17f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(6.71f, 9.29f);
        v12.lineTo(6.71f, 9.29f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.42f);
        v12.lineTo(5.83f, 7f);
        v12.lineToRelative(11.06f, 0f);
        v12.curveToRelative(1f, 0f, 1.92f, 0.68f, 2.08f, 1.66f);
        v12.curveTo(19.18f, 9.91f, 18.209999f, 11f, 17f, 11f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.lineToRelative(12.82f, 0f);
        v12.curveToRelative(2.09f, 0f, 3.96f, -1.52f, 4.16f, -3.6f);
        v12.curveTo(21.209999f, 7.02f, 19.34f, 5f, 17f, 5f);
        v12.horizontalLineTo(5.83f);
        v12.lineToRelative(0.88f, -0.88f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.42f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineTo(2.71f, 5.29f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(2.59f, 2.59f);
        v12.curveTo(5.68f, 9.68f, 6.32f, 9.68f, 6.71f, 9.29f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RepartitionKt._repartition = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

