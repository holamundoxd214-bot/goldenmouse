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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_call", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Call", "Landroidx/compose/material/icons/Icons$Outlined;", "getCall", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CallKt {
    private static ImageVector _call;

    static {
    }

    public static final ImageVector getCall(Outlined arg19) {
        ImageVector v0 = CallKt._call;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Call", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6.54f, 5f);
        v12.curveToRelative(0.06f, 0.89f, 0.21f, 1.76f, 0.45f, 2.59f);
        v12.lineToRelative(-1.2f, 1.2f);
        v12.curveToRelative(-0.41f, -1.2f, -0.67f, -2.47f, -0.76f, -3.79f);
        v12.horizontalLineToRelative(1.51f);
        v12.moveToRelative(9.86f, 12.02f);
        v12.curveToRelative(0.85f, 0.24f, 1.72f, 0.39f, 2.6f, 0.45f);
        v12.verticalLineToRelative(1.49f);
        v12.curveToRelative(-1.32f, -0.09f, -2.59f, -0.35f, -3.8f, -0.75f);
        v12.lineToRelative(1.2f, -1.19f);
        v12.moveTo(7.5f, 3f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.curveToRelative(0f, 9.39f, 7.61f, 17f, 17f, 17f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-3.49f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.curveToRelative(-1.24f, 0f, -2.45f, -0.2f, -3.57f, -0.57f);
        v12.curveToRelative(-0.1f, -0.04f, -0.21f, -0.05f, -0.31f, -0.05f);
        v12.curveToRelative(-0.26f, 0f, -0.51f, 0.1f, -0.71f, 0.29f);
        v12.lineToRelative(-2.2f, 2.2f);
        v12.curveToRelative(-2.83f, -1.45f, -5.15f, -3.76f, -6.59f, -6.59f);
        v12.lineToRelative(2.2f, -2.2f);
        v12.curveToRelative(0.28f, -0.28f, 0.36f, -0.67f, 0.25f, -1.02f);
        v12.curveTo(8.7f, 6.45f, 8.5f, 5.25f, 8.5f, 4f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CallKt._call = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

