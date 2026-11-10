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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_lineAxis", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LineAxis", "Landroidx/compose/material/icons/Icons$Rounded;", "getLineAxis", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LineAxisKt {
    private static ImageVector _lineAxis;

    static {
    }

    public static final ImageVector getLineAxis(Rounded arg19) {
        ImageVector v0 = LineAxisKt._lineAxis;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.LineAxis", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.34f, 6.77f);
        v12.lineTo(21.34f, 6.77f);
        v12.curveToRelative(-0.4f, -0.4f, -1.07f, -0.39f, -1.45f, 0.04f);
        v12.lineToRelative(-3.33f, 3.74f);
        v12.lineToRelative(-5.65f, -5.24f);
        v12.curveTo(10.12f, 4.58f, 8.9f, 4.6f, 8.14f, 5.36f);
        v12.lineTo(2.7f, 10.81f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(0.09f, 0.09f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(5.44f, -5.45f);
        v12.lineToRelative(5.59f, 5.19f);
        v12.lineToRelative(-1.73f, 1.95f);
        v12.lineToRelative(-2.58f, -2.58f);
        v12.curveToRelative(-0.78f, -0.78f, -2.05f, -0.78f, -2.83f, 0f);
        v12.lineTo(2.7f, 16.799999f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineTo(2.8f, 18.299999f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(5.3f, -5.3f);
        v12.lineToRelative(2.5f, 2.5f);
        v12.curveToRelative(0.81f, 0.81f, 2.14f, 0.77f, 2.91f, -0.09f);
        v12.lineToRelative(1.78f, -2.01f);
        v12.lineToRelative(3.19f, 2.96f);
        v12.curveToRelative(0.39f, 0.36f, 1f, 0.35f, 1.38f, -0.03f);
        v12.lineToRelative(0.01f, -0.01f);
        v12.curveToRelative(0.4f, -0.4f, 0.39f, -1.05f, -0.03f, -1.43f);
        v12.lineToRelative(-3.22f, -2.99f);
        v12.lineToRelative(3.35f, -3.77f);
        v12.curveTo(21.73f, 7.74f, 21.709999f, 7.14f, 21.34f, 6.77f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LineAxisKt._lineAxis = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

