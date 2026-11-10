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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_filePresent", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FilePresent", "Landroidx/compose/material/icons/Icons$Rounded;", "getFilePresent", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FilePresentKt {
    private static ImageVector _filePresent;

    static {
    }

    public static final ImageVector getFilePresent(Rounded arg19) {
        ImageVector v0 = FilePresentKt._filePresent;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FilePresent", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(8.83f);
        v12.curveToRelative(0f, -0.53f, -0.21f, -1.04f, -0.59f, -1.41f);
        v12.lineToRelative(-4.83f, -4.83f);
        v12.curveTo(14.21f, 2.21f, 13.7f, 2f, 13.17f, 2f);
        v12.close();
        v12.moveTo(16f, 15f);
        v12.curveToRelative(0f, 2.34f, -2.01f, 4.21f, -4.39f, 3.98f);
        v12.curveTo(9.53f, 18.780001f, 8f, 16.92f, 8f, 14.83f);
        v12.lineToRelative(0f, -5.19f);
        v12.curveToRelative(0f, -1.31f, 0.94f, -2.5f, 2.24f, -2.63f);
        v12.curveTo(11.74f, 6.86f, 13f, 8.03f, 13f, 9.5f);
        v12.verticalLineTo(14f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineTo(9.5f);
        v12.curveTo(11f, 9.22f, 10.78f, 9f, 10.5f, 9f);
        v12.reflectiveCurveTo(10f, 9.22f, 10f, 9.5f);
        v12.verticalLineToRelative(5.39f);
        v12.curveToRelative(0f, 1f, 0.68f, 1.92f, 1.66f, 2.08f);
        v12.curveTo(12.92f, 17.18f, 14f, 16.209999f, 14f, 15f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineTo(15f);
        v12.close();
        v12.moveTo(14f, 7f);
        v12.verticalLineTo(4f);
        v12.lineToRelative(4f, 4f);
        v12.horizontalLineToRelative(-3f);
        v12.curveTo(14.45f, 8f, 14f, 7.55f, 14f, 7f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FilePresentKt._filePresent = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

