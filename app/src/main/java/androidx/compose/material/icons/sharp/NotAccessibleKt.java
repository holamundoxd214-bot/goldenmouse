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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_notAccessible", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NotAccessible", "Landroidx/compose/material/icons/Icons$Sharp;", "getNotAccessible", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NotAccessibleKt {
    private static ImageVector _notAccessible;

    static {
    }

    public static final ImageVector getNotAccessible(Sharp arg19) {
        ImageVector v0 = NotAccessibleKt._notAccessible;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.NotAccessible", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.reflectiveCurveToRelative(-0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f);
        v12.reflectiveCurveTo(10.9f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(10f, 20f);
        v12.curveToRelative(-1.66f, 0f, -3f, -1.34f, -3f, -3f);
        v12.curveToRelative(0f, -1.31f, 0.84f, -2.41f, 2f, -2.83f);
        v12.verticalLineTo(12.1f);
        v12.curveToRelative(-2.28f, 0.46f, -4f, 2.48f, -4f, 4.9f);
        v12.curveToRelative(0f, 2.76f, 2.24f, 5f, 5f, 5f);
        v12.curveToRelative(2.42f, 0f, 4.44f, -1.72f, 4.9f, -4f);
        v12.horizontalLineToRelative(-2.07f);
        v12.curveTo(12.42f, 19.16f, 11.31f, 20f, 10f, 20f);
        v12.close();
        v12.moveTo(21.190001f, 21.190001f);
        v12.lineTo(2.81f, 2.81f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineTo(10f, 12.83f);
        v12.verticalLineTo(17f);
        v12.horizontalLineToRelative(4.17f);
        v12.lineToRelative(5.61f, 5.61f);
        v12.lineTo(21.190001f, 21.190001f);
        v12.close();
        v12.moveTo(19f, 11f);
        v12.curveToRelative(-1.54f, 0.02f, -3.09f, -0.75f, -4.07f, -1.83f);
        v12.lineToRelative(-1.29f, -1.43f);
        v12.curveTo(13.4f, 7.5f, 13.2f, 7.38f, 13.01f, 7.28f);
        v12.curveToRelative(-0.36f, -0.19f, -0.72f, -0.3f, -1.2f, -0.26f);
        v12.curveToRelative(-0.49f, 0.04f, -0.91f, 0.27f, -1.23f, 0.61f);
        v12.lineTo(14f, 11.05f);
        v12.curveToRelative(1.29f, 1.07f, 3.25f, 1.94f, 5f, 1.95f);
        v12.verticalLineTo(11f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NotAccessibleKt._notAccessible = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

