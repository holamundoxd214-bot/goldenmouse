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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_riceBowl", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RiceBowl", "Landroidx/compose/material/icons/Icons$TwoTone;", "getRiceBowl", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RiceBowlKt {
    private static ImageVector _riceBowl;

    static {
    }

    public static final ImageVector getRiceBowl(TwoTone arg19) {
        ImageVector v0 = RiceBowlKt._riceBowl;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.RiceBowl", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.66f, 14f);
        v12.curveToRelative(-0.66f, 1.92f, -2.24f, 3.54f, -4.4f, 4.39f);
        v12.lineTo(14f, 18.879999f);
        v12.verticalLineTo(20f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineToRelative(-1.12f);
        v12.lineToRelative(-1.27f, -0.5f);
        v12.curveToRelative(-2.16f, -0.85f, -3.74f, -2.47f, -4.4f, -4.39f);
        v12.horizontalLineTo(19.66f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(19.66f, 14f);
        v12.curveToRelative(-0.66f, 1.92f, -2.24f, 3.54f, -4.4f, 4.39f);
        v12.lineTo(14f, 18.879999f);
        v12.verticalLineTo(20f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineToRelative(-1.12f);
        v12.lineToRelative(-1.27f, -0.5f);
        v12.curveToRelative(-2.16f, -0.85f, -3.74f, -2.47f, -4.4f, -4.39f);
        v12.horizontalLineTo(19.66f);
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.curveToRelative(0f, 3.69f, 2.47f, 6.86f, 6f, 8.25f);
        v12.verticalLineTo(22f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(-1.75f);
        v12.curveToRelative(3.53f, -1.39f, 6f, -4.56f, 6f, -8.25f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(22f, 6.48f, 17.52f, 2f, 12f, 2f);
        v12.lineTo(12f, 2f);
        v12.close();
        v12.moveTo(10f, 12f);
        v12.verticalLineTo(4.26f);
        v12.curveTo(10.64f, 4.1f, 11.31f, 4f, 12f, 4f);
        v12.reflectiveCurveToRelative(1.36f, 0.1f, 2f, 0.26f);
        v12.verticalLineTo(12f);
        v12.horizontalLineTo(10f);
        v12.lineTo(10f, 12f);
        v12.close();
        v12.moveTo(16f, 12f);
        v12.verticalLineTo(5.08f);
        v12.curveToRelative(2.39f, 1.39f, 4f, 3.96f, 4f, 6.92f);
        v12.horizontalLineTo(16f);
        v12.lineTo(16f, 12f);
        v12.close();
        v12.moveTo(4f, 12f);
        v12.curveToRelative(0f, -2.95f, 1.61f, -5.53f, 4f, -6.92f);
        v12.verticalLineTo(12f);
        v12.horizontalLineTo(4f);
        v12.lineTo(4f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RiceBowlKt._riceBowl = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

