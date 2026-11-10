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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_libraryAddCheck", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LibraryAddCheck", "Landroidx/compose/material/icons/Icons$TwoTone;", "getLibraryAddCheck", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LibraryAddCheckKt {
    private static ImageVector _libraryAddCheck;

    static {
    }

    public static final ImageVector getLibraryAddCheck(TwoTone arg19) {
        ImageVector v0 = LibraryAddCheckKt._libraryAddCheck;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.LibraryAddCheck", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(8f, 16f);
        v0_1.horizontalLineToRelative(12f);
        v0_1.verticalLineTo(4f);
        v0_1.horizontalLineTo(8f);
        v0_1.verticalLineTo(16f);
        v0_1.close();
        v0_1.moveTo(10.4f, 9.09f);
        v0_1.lineToRelative(2.07f, 2.08f);
        v0_1.lineTo(17.6f, 6f);
        v0_1.lineTo(19f, 7.41f);
        v0_1.lineTo(12.47f, 14f);
        v0_1.lineTo(9f, 10.5f);
        v0_1.lineTo(10.4f, 9.09f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 2f);
        v12.horizontalLineTo(8f);
        v12.curveTo(6.9f, 2f, 6f, 2.9f, 6f, 4f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(4f);
        v12.curveTo(22f, 2.9f, 21.1f, 2f, 20f, 2f);
        v12.close();
        v12.moveTo(20f, 16f);
        v12.horizontalLineTo(8f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineTo(16f);
        v12.close();
        v12.moveTo(12.47f, 14f);
        v12.lineTo(9f, 10.5f);
        v12.lineToRelative(1.4f, -1.41f);
        v12.lineToRelative(2.07f, 2.08f);
        v12.lineTo(17.6f, 6f);
        v12.lineTo(19f, 7.41f);
        v12.lineTo(12.47f, 14f);
        v12.close();
        v12.moveTo(4f, 20f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LibraryAddCheckKt._libraryAddCheck = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

