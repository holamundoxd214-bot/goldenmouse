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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_fileOpen", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FileOpen", "Landroidx/compose/material/icons/Icons$Rounded;", "getFileOpen", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FileOpenKt {
    private static ImageVector _fileOpen;

    static {
    }

    public static final ImageVector getFileOpen(Rounded arg19) {
        ImageVector v0 = FileOpenKt._fileOpen;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FileOpen", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13.17f, 2f);
        v12.horizontalLineTo(6f);
        v12.curveTo(4.9f, 2f, 4f, 2.9f, 4f, 4f);
        v12.verticalLineToRelative(16f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(9f);
        v12.verticalLineToRelative(-6f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineTo(8.83f);
        v12.curveToRelative(0f, -0.53f, -0.21f, -1.04f, -0.59f, -1.41f);
        v12.lineToRelative(-4.83f, -4.83f);
        v12.curveTo(14.21f, 2.21f, 13.7f, 2f, 13.17f, 2f);
        v12.close();
        v12.moveTo(13f, 8f);
        v12.verticalLineTo(3.5f);
        v12.lineTo(18.5f, 9f);
        v12.horizontalLineTo(14f);
        v12.curveTo(13.45f, 9f, 13f, 8.55f, 13f, 8f);
        v12.close();
        v12.moveTo(22.66f, 17f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(-1.24f);
        v12.lineToRelative(2.24f, 2.24f);
        v12.curveToRelative(0.39f, 0.39f, 0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -1.02f, 0.39f, -1.41f, 0f);
        v12.lineTo(19f, 19.41f);
        v12.lineToRelative(0f, 1.24f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineTo(17f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(3.66f);
        v12.curveTo(22.209999f, 16f, 22.66f, 16.450001f, 22.66f, 17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FileOpenKt._fileOpen = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

