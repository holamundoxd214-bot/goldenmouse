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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_unsubscribe", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Unsubscribe", "Landroidx/compose/material/icons/Icons$Rounded;", "getUnsubscribe", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class UnsubscribeKt {
    private static ImageVector _unsubscribe;

    static {
    }

    public static final ImageVector getUnsubscribe(Rounded arg19) {
        ImageVector v0 = UnsubscribeKt._unsubscribe;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Unsubscribe", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.5f, 11.5f);
        v12.curveToRelative(0.92f, 0f, 1.75f, 0.26f, 2.49f, 0.69f);
        v12.lineTo(20.99f, 5f);
        v12.curveToRelative(0f, -1.1f, -0.89f, -2f, -1.99f, -2f);
        v12.lineTo(5f, 3f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(8.55f);
        v12.curveToRelative(-0.02f, -0.17f, -0.05f, -0.33f, -0.05f, -0.5f);
        v12.curveToRelative(0f, -2.76f, 2.24f, -5f, 5f, -5f);
        v12.close();
        v12.moveTo(12.89f, 10.05f);
        v12.curveToRelative(-0.56f, 0.28f, -1.23f, 0.28f, -1.79f, 0f);
        v12.lineToRelative(-5.61f, -2.8f);
        v12.curveToRelative(-0.3f, -0.15f, -0.49f, -0.46f, -0.49f, -0.8f);
        v12.curveToRelative(0f, -0.66f, 0.7f, -1.1f, 1.29f, -0.8f);
        v12.lineTo(12f, 8.5f);
        v12.lineToRelative(5.71f, -2.85f);
        v12.curveToRelative(0.59f, -0.3f, 1.29f, 0.13f, 1.29f, 0.8f);
        v12.curveToRelative(0f, 0.34f, -0.19f, 0.65f, -0.49f, 0.8f);
        v12.lineToRelative(-5.62f, 2.8f);
        v12.close();
        v12.moveTo(18.5f, 13f);
        v12.curveToRelative(-1.93f, 0f, -3.5f, 1.57f, -3.5f, 3.5f);
        v12.reflectiveCurveToRelative(1.57f, 3.5f, 3.5f, 3.5f);
        v12.reflectiveCurveToRelative(3.5f, -1.57f, 3.5f, -3.5f);
        v12.reflectiveCurveToRelative(-1.57f, -3.5f, -3.5f, -3.5f);
        v12.close();
        v12.moveTo(20.5f, 16.5f);
        v12.curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f);
        v12.horizontalLineToRelative(-3f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f);
        v12.reflectiveCurveToRelative(0.22f, -0.5f, 0.5f, -0.5f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        UnsubscribeKt._unsubscribe = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

