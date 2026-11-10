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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_unsubscribe", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Unsubscribe", "Landroidx/compose/material/icons/Icons$Outlined;", "getUnsubscribe", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class UnsubscribeKt {
    private static ImageVector _unsubscribe;

    static {
    }

    public static final ImageVector getUnsubscribe(Outlined arg19) {
        ImageVector v0 = UnsubscribeKt._unsubscribe;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Unsubscribe", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.99f, 14.04f);
        v12.lineTo(20.99f, 5f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.lineTo(5f, 3f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(10.05f);
        v12.curveToRelative(0.28f, 1.92f, 2.1f, 3.35f, 4.18f, 2.93f);
        v12.curveToRelative(1.34f, -0.27f, 2.43f, -1.37f, 2.7f, -2.71f);
        v12.curveToRelative(0.25f, -1.24f, -0.16f, -2.39f, -0.94f, -3.18f);
        v12.close();
        v12.moveTo(18.99f, 5f);
        v12.lineTo(12f, 8.5f);
        v12.lineTo(5f, 5f);
        v12.horizontalLineToRelative(13.99f);
        v12.close();
        v12.moveTo(15.35f, 15f);
        v12.lineTo(5f, 15f);
        v12.lineTo(5f, 7f);
        v12.lineToRelative(7f, 3.5f);
        v12.lineTo(19f, 7f);
        v12.verticalLineToRelative(6.05f);
        v12.curveToRelative(-0.16f, -0.02f, -0.33f, -0.05f, -0.5f, -0.05f);
        v12.curveToRelative(-1.39f, 0f, -2.59f, 0.82f, -3.15f, 2f);
        v12.close();
        v12.moveTo(20.5f, 17f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        UnsubscribeKt._unsubscribe = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

