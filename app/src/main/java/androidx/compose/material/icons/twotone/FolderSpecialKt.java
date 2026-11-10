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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_folderSpecial", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FolderSpecial", "Landroidx/compose/material/icons/Icons$TwoTone;", "getFolderSpecial", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FolderSpecialKt {
    private static ImageVector _folderSpecial;

    static {
    }

    public static final ImageVector getFolderSpecial(TwoTone arg19) {
        ImageVector v0 = FolderSpecialKt._folderSpecial;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.FolderSpecial", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(11.17f, 8f);
        v0_1.lineToRelative(-2f, -2f);
        v0_1.horizontalLineTo(4f);
        v0_1.verticalLineToRelative(12f);
        v0_1.horizontalLineToRelative(16f);
        v0_1.verticalLineTo(8f);
        v0_1.horizontalLineToRelative(-8.83f);
        v0_1.close();
        v0_1.moveTo(15f, 9f);
        v0_1.lineToRelative(1.19f, 2.79f);
        v0_1.lineToRelative(3.03f, 0.26f);
        v0_1.lineToRelative(-2.3f, 1.99f);
        v0_1.lineToRelative(0.69f, 2.96f);
        v0_1.lineTo(15f, 15.47f);
        v0_1.lineTo(12.39f, 17f);
        v0_1.lineToRelative(0.69f, -2.96f);
        v0_1.lineToRelative(-2.3f, -1.99f);
        v0_1.lineToRelative(3.03f, -0.26f);
        v0_1.lineTo(15f, 9f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 6f);
        v12.horizontalLineToRelative(-8f);
        v12.lineToRelative(-2f, -2f);
        v12.lineTo(4f, 4f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(22f, 8f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(20f, 18f);
        v12.lineTo(4f, 18f);
        v12.lineTo(4f, 6f);
        v12.horizontalLineToRelative(5.17f);
        v12.lineToRelative(2f, 2f);
        v12.lineTo(20f, 8f);
        v12.verticalLineToRelative(10f);
        v12.close();
        v12.moveTo(13.08f, 14.04f);
        v12.lineTo(12.39f, 17f);
        v12.lineTo(15f, 15.47f);
        v12.lineTo(17.610001f, 17f);
        v12.lineToRelative(-0.69f, -2.96f);
        v12.lineToRelative(2.3f, -1.99f);
        v12.lineToRelative(-3.03f, -0.26f);
        v12.lineTo(15f, 9f);
        v12.lineToRelative(-1.19f, 2.79f);
        v12.lineToRelative(-3.03f, 0.26f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FolderSpecialKt._folderSpecial = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

