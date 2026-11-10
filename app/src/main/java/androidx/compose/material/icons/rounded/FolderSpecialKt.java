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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_folderSpecial", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FolderSpecial", "Landroidx/compose/material/icons/Icons$Rounded;", "getFolderSpecial", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FolderSpecialKt {
    private static ImageVector _folderSpecial;

    static {
    }

    public static final ImageVector getFolderSpecial(Rounded arg19) {
        ImageVector v0 = FolderSpecialKt._folderSpecial;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FolderSpecial", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 6f);
        v12.horizontalLineToRelative(-8f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.curveTo(10.21f, 4.21f, 9.7f, 4f, 9.17f, 4f);
        v12.lineTo(4f, 4f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(22f, 8f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(16.940001f, 16.41f);
        v12.lineTo(15f, 15.28f);
        v12.lineToRelative(-1.94f, 1.13f);
        v12.curveToRelative(-0.38f, 0.22f, -0.84f, -0.12f, -0.74f, -0.55f);
        v12.lineToRelative(0.51f, -2.2f);
        v12.lineToRelative(-1.69f, -1.46f);
        v12.curveToRelative(-0.33f, -0.29f, -0.16f, -0.84f, 0.28f, -0.88f);
        v12.lineToRelative(2.23f, -0.19f);
        v12.lineToRelative(0.88f, -2.06f);
        v12.curveToRelative(0.17f, -0.4f, 0.75f, -0.4f, 0.92f, 0f);
        v12.lineToRelative(0.88f, 2.06f);
        v12.lineToRelative(2.23f, 0.19f);
        v12.curveToRelative(0.44f, 0.04f, 0.62f, 0.59f, 0.28f, 0.88f);
        v12.lineToRelative(-1.69f, 1.46f);
        v12.lineToRelative(0.51f, 2.2f);
        v12.curveToRelative(0.11f, 0.43f, -0.35f, 0.77f, -0.72f, 0.55f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FolderSpecialKt._folderSpecial = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

