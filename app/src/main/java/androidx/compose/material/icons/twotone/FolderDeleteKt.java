package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_folderDelete", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FolderDelete", "Landroidx/compose/material/icons/Icons$TwoTone;", "getFolderDelete", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FolderDeleteKt {
    private static ImageVector _folderDelete;

    static {
    }

    public static final ImageVector getFolderDelete(TwoTone arg19) {
        ImageVector v0 = FolderDeleteKt._folderDelete;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.FolderDelete", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.5f, 11.5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(11.5f);
        v12.close();
        v12.moveTo(20f, 8f);
        v12.verticalLineToRelative(10f);
        v12.horizontalLineTo(4f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(5.17f);
        v12.lineToRelative(2f, 2f);
        v12.horizontalLineTo(20f);
        v12.close();
        v12.moveTo(19f, 10f);
        v12.horizontalLineToRelative(-2.5f);
        v12.verticalLineTo(9f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineTo(12f);
        v12.verticalLineToRelative(1.5f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.verticalLineToRelative(-4f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(10f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(16.5f, 10f);
        v12.verticalLineTo(9f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineTo(12f);
        v12.verticalLineToRelative(1.5f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.verticalLineToRelative(-4f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(10f);
        v12.horizontalLineTo(16.5f);
        v12.close();
        v12.moveTo(16.5f, 15.5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-4f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(15.5f);
        v12.close();
        v12.moveTo(20f, 6f);
        v12.horizontalLineToRelative(-8f);
        v12.lineToRelative(-2f, -2f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.89f, 4f, 2.01f, 4.89f, 2.01f, 6f);
        v12.lineTo(2f, 18f);
        v12.curveToRelative(0f, 1.11f, 0.89f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.11f, 0f, 2f, -0.89f, 2f, -2f);
        v12.verticalLineTo(8f);
        v12.curveTo(22f, 6.89f, 21.110001f, 6f, 20f, 6f);
        v12.close();
        v12.moveTo(20f, 18f);
        v12.horizontalLineTo(4f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(5.17f);
        v12.lineToRelative(2f, 2f);
        v12.horizontalLineTo(20f);
        v12.verticalLineTo(18f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FolderDeleteKt._folderDelete = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

