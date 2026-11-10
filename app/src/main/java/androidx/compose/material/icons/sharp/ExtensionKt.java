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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_extension", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Extension", "Landroidx/compose/material/icons/Icons$Sharp;", "getExtension", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ExtensionKt {
    private static ImageVector _extension;

    static {
    }

    public static final ImageVector getExtension(Sharp arg19) {
        ImageVector v0 = ExtensionKt._extension;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Extension", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.360001f, 11f);
        v12.horizontalLineTo(19f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(-6f);
        v12.verticalLineTo(3.64f);
        v12.curveToRelative(0f, -1.31f, -0.94f, -2.5f, -2.24f, -2.63f);
        v12.curveTo(9.26f, 0.86f, 8f, 2.03f, 8f, 3.5f);
        v12.verticalLineTo(5f);
        v12.horizontalLineTo(2.01f);
        v12.verticalLineToRelative(5.8f);
        v12.horizontalLineTo(3.4f);
        v12.curveToRelative(1.31f, 0f, 2.5f, 0.88f, 2.75f, 2.16f);
        v12.curveToRelative(0.33f, 1.72f, -0.98f, 3.24f, -2.65f, 3.24f);
        v12.horizontalLineTo(2f);
        v12.verticalLineTo(22f);
        v12.horizontalLineToRelative(5.8f);
        v12.verticalLineToRelative(-1.4f);
        v12.curveToRelative(0f, -1.31f, 0.88f, -2.5f, 2.16f, -2.75f);
        v12.curveToRelative(1.72f, -0.33f, 3.24f, 0.98f, 3.24f, 2.65f);
        v12.verticalLineTo(22f);
        v12.horizontalLineTo(19f);
        v12.verticalLineToRelative(-6f);
        v12.horizontalLineToRelative(1.5f);
        v12.curveToRelative(1.47f, 0f, 2.64f, -1.26f, 2.49f, -2.76f);
        v12.curveToRelative(-0.13f, -1.3f, -1.33f, -2.24f, -2.63f, -2.24f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ExtensionKt._extension = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

