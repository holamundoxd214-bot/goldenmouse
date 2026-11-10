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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_archive", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Archive", "Landroidx/compose/material/icons/Icons$TwoTone;", "getArchive", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ArchiveKt {
    private static ImageVector _archive;

    static {
    }

    public static final ImageVector getArchive(TwoTone arg19) {
        ImageVector v0 = ArchiveKt._archive;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Archive", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(5f, 19f);
        v0_1.horizontalLineToRelative(14f);
        v0_1.lineTo(19f, 8f);
        v0_1.lineTo(5f, 8f);
        v0_1.verticalLineToRelative(11f);
        v0_1.close();
        v0_1.moveTo(10.55f, 13f);
        v0_1.verticalLineToRelative(-3f);
        v0_1.horizontalLineToRelative(2.91f);
        v0_1.verticalLineToRelative(3f);
        v0_1.lineTo(16f, 13f);
        v0_1.lineToRelative(-4f, 4f);
        v0_1.lineToRelative(-4f, -4f);
        v0_1.horizontalLineToRelative(2.55f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 13f);
        v12.horizontalLineToRelative(-2.55f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(-2.9f);
        v12.verticalLineToRelative(3f);
        v12.lineTo(8f, 13f);
        v12.lineToRelative(4f, 4f);
        v12.close();
        v12.moveTo(20.540001f, 5.23f);
        v12.lineToRelative(-1.39f, -1.68f);
        v12.curveTo(18.879999f, 3.21f, 18.469999f, 3f, 18f, 3f);
        v12.lineTo(6f, 3f);
        v12.curveToRelative(-0.47f, 0f, -0.88f, 0.21f, -1.16f, 0.55f);
        v12.lineTo(3.46f, 5.23f);
        v12.curveTo(3.17f, 5.57f, 3f, 6.02f, 3f, 6.5f);
        v12.lineTo(3f, 19f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(21f, 6.5f);
        v12.curveToRelative(0f, -0.48f, -0.17f, -0.93f, -0.46f, -1.27f);
        v12.close();
        v12.moveTo(6.24f, 5f);
        v12.horizontalLineToRelative(11.52f);
        v12.lineToRelative(0.81f, 0.97f);
        v12.lineTo(5.44f, 5.97f);
        v12.lineToRelative(0.8f, -0.97f);
        v12.close();
        v12.moveTo(19f, 19f);
        v12.lineTo(5f, 19f);
        v12.lineTo(5f, 8f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineToRelative(11f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ArchiveKt._archive = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

