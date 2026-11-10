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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_restorePage", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RestorePage", "Landroidx/compose/material/icons/Icons$Outlined;", "getRestorePage", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RestorePageKt {
    private static ImageVector _restorePage;

    static {
    }

    public static final ImageVector getRestorePage(Outlined arg19) {
        ImageVector v0 = RestorePageKt._restorePage;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.RestorePage", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14f, 2f);
        v12.lineTo(6f, 2f);
        v12.curveToRelative(-1.1f, 0f, -1.99f, 0.9f, -1.99f, 2f);
        v12.lineTo(4f, 20f);
        v12.curveToRelative(0f, 1.1f, 0.89f, 2f, 1.99f, 2f);
        v12.lineTo(18f, 22f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(20f, 8f);
        v12.lineToRelative(-6f, -6f);
        v12.close();
        v12.moveTo(18f, 20f);
        v12.lineTo(6f, 20f);
        v12.lineTo(6f, 4f);
        v12.horizontalLineToRelative(7.17f);
        v12.lineTo(18f, 8.83f);
        v12.lineTo(18f, 20f);
        v12.close();
        v12.moveTo(8.45f, 10.57f);
        v12.lineTo(7.28f, 9.4f);
        v12.lineTo(7.28f, 13f);
        v12.horizontalLineToRelative(3.6f);
        v12.lineToRelative(-1.44f, -1.44f);
        v12.curveToRelative(0.52f, -1.01f, 1.58f, -1.71f, 2.79f, -1.71f);
        v12.curveToRelative(1.74f, 0f, 3.15f, 1.41f, 3.15f, 3.15f);
        v12.reflectiveCurveToRelative(-1.41f, 3.15f, -3.15f, 3.15f);
        v12.curveToRelative(-1.07f, 0f, -2.02f, -0.54f, -2.58f, -1.35f);
        v12.lineTo(8.1f, 14.8f);
        v12.curveToRelative(0.69f, 1.58f, 2.28f, 2.7f, 4.12f, 2.7f);
        v12.curveToRelative(2.48f, 0f, 4.5f, -2.02f, 4.5f, -4.5f);
        v12.reflectiveCurveToRelative(-2.02f, -4.5f, -4.5f, -4.5f);
        v12.curveToRelative(-1.59f, 0f, -2.97f, 0.83f, -3.77f, 2.07f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RestorePageKt._restorePage = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

