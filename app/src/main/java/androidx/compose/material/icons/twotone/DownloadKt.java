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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_download", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Download", "Landroidx/compose/material/icons/Icons$TwoTone;", "getDownload", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DownloadKt {
    private static ImageVector _download;

    static {
    }

    public static final ImageVector getDownload(TwoTone arg26) {
        ImageVector v0 = DownloadKt._download;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Download", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(13f, 9f);
        v0_1.verticalLineTo(5f);
        v0_1.horizontalLineToRelative(-2f);
        v0_1.verticalLineToRelative(6f);
        v0_1.horizontalLineTo(9.83f);
        v0_1.lineTo(12f, 13.17f);
        v0_1.lineTo(14.17f, 11f);
        v0_1.horizontalLineTo(13f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(15f, 9f);
        v0_1.lineTo(15f, 3f);
        v0_1.lineTo(9f, 3f);
        v0_1.verticalLineToRelative(6f);
        v0_1.lineTo(5f, 9f);
        v0_1.lineToRelative(7f, 7f);
        v0_1.lineToRelative(7f, -7f);
        v0_1.horizontalLineToRelative(-4f);
        v0_1.close();
        v0_1.moveTo(12f, 13.17f);
        v0_1.lineTo(9.83f, 11f);
        v0_1.lineTo(11f, 11f);
        v0_1.lineTo(11f, 5f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.verticalLineToRelative(6f);
        v0_1.horizontalLineToRelative(1.17f);
        v0_1.lineTo(12f, 13.17f);
        v0_1.close();
        v0_1.moveTo(5f, 18f);
        v0_1.horizontalLineToRelative(14f);
        v0_1.verticalLineToRelative(2f);
        v0_1.lineTo(5f, 20f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DownloadKt._download = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

