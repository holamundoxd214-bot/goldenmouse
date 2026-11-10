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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_notAccessible", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NotAccessible", "Landroidx/compose/material/icons/Icons$Rounded;", "getNotAccessible", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NotAccessibleKt {
    private static ImageVector _notAccessible;

    static {
    }

    public static final ImageVector getNotAccessible(Rounded arg19) {
        ImageVector v0 = NotAccessibleKt._notAccessible;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.NotAccessible", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.moveTo(20.49f, 20.49f);
        v12.lineTo(3.51f, 3.51f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(7.9f, 7.9f);
        v12.verticalLineTo(15f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(2.17f);
        v12.lineToRelative(4.9f, 4.9f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveTo(20.879999f, 21.51f, 20.879999f, 20.879999f, 20.49f, 20.49f);
        v12.close();
        v12.moveTo(18.16f, 10.93f);
        v12.curveToRelative(-1.25f, -0.21f, -2.43f, -0.88f, -3.23f, -1.76f);
        v12.lineToRelative(-1.29f, -1.43f);
        v12.curveTo(13.4f, 7.5f, 13.2f, 7.38f, 13.01f, 7.28f);
        v12.curveToRelative(-0.36f, -0.19f, -0.72f, -0.3f, -1.2f, -0.26f);
        v12.curveToRelative(-0.49f, 0.04f, -0.91f, 0.27f, -1.23f, 0.61f);
        v12.lineTo(14f, 11.05f);
        v12.curveToRelative(1f, 0.83f, 2.4f, 1.54f, 3.8f, 1.82f);
        v12.curveTo(18.42f, 13f, 19f, 12.53f, 19f, 11.9f);
        v12.curveTo(19f, 11.42f, 18.639999f, 11.01f, 18.16f, 10.93f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NotAccessibleKt._notAccessible = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

