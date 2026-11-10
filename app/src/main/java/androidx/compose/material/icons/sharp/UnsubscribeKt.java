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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_unsubscribe", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Unsubscribe", "Landroidx/compose/material/icons/Icons$Sharp;", "getUnsubscribe", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class UnsubscribeKt {
    private static ImageVector _unsubscribe;

    static {
    }

    public static final ImageVector getUnsubscribe(Sharp arg19) {
        ImageVector v0 = UnsubscribeKt._unsubscribe;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Unsubscribe", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.5f, 13f);
        v12.curveToRelative(-1.93f, 0f, -3.5f, 1.57f, -3.5f, 3.5f);
        v12.reflectiveCurveToRelative(1.57f, 3.5f, 3.5f, 3.5f);
        v12.reflectiveCurveToRelative(3.5f, -1.57f, 3.5f, -3.5f);
        v12.reflectiveCurveToRelative(-1.57f, -3.5f, -3.5f, -3.5f);
        v12.close();
        v12.moveTo(20.5f, 17f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(1f);
        v12.close();
        v12.moveTo(13.55f, 17f);
        v12.curveToRelative(-0.02f, -0.17f, -0.05f, -0.33f, -0.05f, -0.5f);
        v12.curveToRelative(0f, -2.76f, 2.24f, -5f, 5f, -5f);
        v12.curveToRelative(0.92f, 0f, 1.75f, 0.26f, 2.49f, 0.69f);
        v12.lineTo(20.99f, 3f);
        v12.lineTo(3f, 3f);
        v12.verticalLineToRelative(14f);
        v12.horizontalLineToRelative(10.55f);
        v12.close();
        v12.moveTo(12f, 10.5f);
        v12.lineTo(5f, 7f);
        v12.lineTo(5f, 5f);
        v12.lineToRelative(7f, 3.5f);
        v12.lineTo(19f, 5f);
        v12.verticalLineToRelative(2f);
        v12.lineToRelative(-7f, 3.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        UnsubscribeKt._unsubscribe = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

