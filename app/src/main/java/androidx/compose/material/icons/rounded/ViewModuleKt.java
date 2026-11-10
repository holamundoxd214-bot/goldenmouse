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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_viewModule", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ViewModule", "Landroidx/compose/material/icons/Icons$Rounded;", "getViewModule", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ViewModuleKt {
    private static ImageVector _viewModule;

    static {
    }

    public static final ImageVector getViewModule(Rounded arg19) {
        ImageVector v0 = ViewModuleKt._viewModule;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ViewModule", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.67f, 6f);
        v12.verticalLineToRelative(4.5f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(-3.33f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(3.33f);
        v12.curveTo(14.22f, 5f, 14.67f, 5.45f, 14.67f, 6f);
        v12.close();
        v12.moveTo(16.67f, 11.5f);
        v12.horizontalLineTo(20f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-3.33f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(4.5f);
        v12.curveTo(15.67f, 11.05f, 16.110001f, 11.5f, 16.67f, 11.5f);
        v12.close();
        v12.moveTo(14.67f, 18f);
        v12.verticalLineToRelative(-4.5f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-3.33f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineTo(18f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(3.33f);
        v12.curveTo(14.22f, 19f, 14.67f, 18.549999f, 14.67f, 18f);
        v12.close();
        v12.moveTo(15.67f, 13.5f);
        v12.verticalLineTo(18f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineTo(20f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-4.5f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-3.33f);
        v12.curveTo(16.110001f, 12.5f, 15.67f, 12.95f, 15.67f, 13.5f);
        v12.close();
        v12.moveTo(7.33f, 12.5f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineTo(18f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(3.33f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-4.5f);
        v12.curveTo(8.33f, 12.95f, 7.89f, 12.5f, 7.33f, 12.5f);
        v12.close();
        v12.moveTo(8.33f, 10.5f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(4f);
        v12.curveTo(3.45f, 5f, 3f, 5.45f, 3f, 6f);
        v12.verticalLineToRelative(4.5f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(3.33f);
        v12.curveTo(7.89f, 11.5f, 8.33f, 11.05f, 8.33f, 10.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ViewModuleKt._viewModule = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

