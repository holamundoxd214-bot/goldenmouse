package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_riceBowl", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RiceBowl", "Landroidx/compose/material/icons/Icons$Sharp;", "getRiceBowl", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RiceBowlKt {
    private static ImageVector _riceBowl;

    static {
    }

    public static final ImageVector getRiceBowl(Sharp arg19) {
        ImageVector v0 = RiceBowlKt._riceBowl;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.RiceBowl", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 12f);
        v12.lineTo(22f, 12f);
        v12.curveToRelative(0f, -5.52f, -4.48f, -10f, -10f, -10f);
        v12.reflectiveCurveTo(2f, 6.48f, 2f, 12f);
        v12.curveToRelative(0f, 3.69f, 2.47f, 6.86f, 6f, 8.25f);
        v12.verticalLineTo(22f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(-1.75f);
        v12.curveTo(19.530001f, 18.860001f, 22f, 15.69f, 22f, 12f);
        v12.close();
        v12.moveTo(20f, 12f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineTo(5.08f);
        v12.curveTo(18.389999f, 6.47f, 20f, 9.05f, 20f, 12f);
        v12.close();
        v12.moveTo(14f, 4.26f);
        v12.verticalLineTo(12f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineTo(4.26f);
        v12.curveTo(10.64f, 4.1f, 11.31f, 4f, 12f, 4f);
        v12.reflectiveCurveTo(13.36f, 4.1f, 14f, 4.26f);
        v12.close();
        v12.moveTo(4f, 12f);
        v12.curveToRelative(0f, -2.95f, 1.61f, -5.53f, 4f, -6.92f);
        v12.verticalLineTo(12f);
        v12.horizontalLineTo(4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RiceBowlKt._riceBowl = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

