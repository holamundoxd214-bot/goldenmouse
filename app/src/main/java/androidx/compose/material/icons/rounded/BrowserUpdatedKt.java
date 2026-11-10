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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_browserUpdated", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BrowserUpdated", "Landroidx/compose/material/icons/Icons$Rounded;", "getBrowserUpdated", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BrowserUpdatedKt {
    private static ImageVector _browserUpdated;

    static {
    }

    public static final ImageVector getBrowserUpdated(Rounded arg19) {
        ImageVector v0 = BrowserUpdatedKt._browserUpdated;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.BrowserUpdated", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15f, 3f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(1.59f);
        v12.curveToRelative(0.89f, 0f, 1.34f, 1.08f, 0.71f, 1.71f);
        v12.lineToRelative(-2.59f, 2.59f);
        v12.curveToRelative(-0.39f, 0.39f, -1.02f, 0.39f, -1.41f, 0f);
        v12.lineToRelative(-2.59f, -2.59f);
        v12.curveTo(11.08f, 11.08f, 11.52f, 10f, 12.41f, 10f);
        v12.horizontalLineTo(14f);
        v12.verticalLineTo(4f);
        v12.curveTo(14f, 3.45f, 14.45f, 3f, 15f, 3f);
        v12.close();
        v12.moveTo(6f, 19.59f);
        v12.curveTo(6f, 20.370001f, 6.63f, 21f, 7.41f, 21f);
        v12.horizontalLineToRelative(9.17f);
        v12.curveToRelative(0.78f, 0f, 1.41f, -0.63f, 1.41f, -1.41f);
        v12.curveToRelative(0f, -0.72f, -0.44f, -1.03f, -1f, -1.59f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(4f);
        v12.verticalLineTo(5f);
        v12.lineToRelative(7f, 0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.lineTo(4f, 3f);
        v12.curveTo(2.9f, 3f, 2f, 3.9f, 2f, 5f);
        v12.verticalLineToRelative(11f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(3f);
        v12.curveTo(6.45f, 18.549999f, 6f, 18.870001f, 6f, 19.59f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BrowserUpdatedKt._browserUpdated = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

