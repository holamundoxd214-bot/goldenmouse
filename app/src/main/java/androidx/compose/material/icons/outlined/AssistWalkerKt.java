package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_assistWalker", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AssistWalker", "Landroidx/compose/material/icons/Icons$Outlined;", "getAssistWalker", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AssistWalkerKt {
    private static ImageVector _assistWalker;

    static {
    }

    public static final ImageVector getAssistWalker(Outlined arg20) {
        ImageVector v0 = AssistWalkerKt._assistWalker;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.AssistWalker", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.5f, 4.5f);
        v12.moveToRelative(-2f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, 4f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, -4f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(19.77f, 17.719999f);
        v12.lineToRelative(-0.64f, -6.37f);
        v12.curveTo(19.059999f, 10.58f, 18.41f, 10f, 17.639999f, 10f);
        v12.horizontalLineTo(16f);
        v12.curveToRelative(-1.5f, -0.02f, -2.86f, -0.54f, -3.76f, -1.44f);
        v12.lineToRelative(-2f, -1.98f);
        v12.curveTo(10.08f, 6.42f, 9.62f, 6f, 8.83f, 6f);
        v12.curveTo(8.32f, 6f, 7.81f, 6.2f, 7.42f, 6.59f);
        v12.lineTo(4.08f, 9.91f);
        v12.curveToRelative(-0.53f, 0.68f, -0.51f, 1.57f, -0.21f, 2.13f);
        v12.lineToRelative(1.43f, 2.8f);
        v12.lineToRelative(-3.15f, 4.05f);
        v12.lineToRelative(1.57f, 1.24f);
        v12.lineToRelative(3.68f, -4.73f);
        v12.lineToRelative(-0.17f, -1.36f);
        v12.lineTo(8f, 14.75f);
        v12.verticalLineTo(20f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-6.12f);
        v12.lineToRelative(-2.12f, -2.12f);
        v12.lineToRelative(2.36f, -2.36f);
        v12.curveToRelative(0.94f, 0.94f, 1.72f, 1.82f, 3.59f, 2.32f);
        v12.lineTo(13f, 20f);
        v12.horizontalLineToRelative(1.5f);
        v12.lineToRelative(0.41f, -3.5f);
        v12.horizontalLineToRelative(3.18f);
        v12.lineToRelative(0.14f, 1.22f);
        v12.curveToRelative(-0.44f, 0.26f, -0.73f, 0.74f, -0.73f, 1.28f);
        v12.curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f);
        v12.reflectiveCurveToRelative(1.5f, -0.67f, 1.5f, -1.5f);
        v12.curveTo(20.5f, 18.459999f, 20.209999f, 17.98f, 19.77f, 17.719999f);
        v12.close();
        v12.moveTo(15.09f, 15f);
        v12.lineToRelative(0.41f, -3.5f);
        v12.horizontalLineToRelative(2f);
        v12.lineToRelative(0.41f, 3.5f);
        v12.horizontalLineTo(15.09f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AssistWalkerKt._assistWalker = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

