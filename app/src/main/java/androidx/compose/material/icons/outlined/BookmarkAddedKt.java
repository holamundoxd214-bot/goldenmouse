package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_bookmarkAdded", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BookmarkAdded", "Landroidx/compose/material/icons/Icons$Outlined;", "getBookmarkAdded", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BookmarkAddedKt {
    private static ImageVector _bookmarkAdded;

    static {
    }

    public static final ImageVector getBookmarkAdded(Outlined arg19) {
        ImageVector v0 = BookmarkAddedKt._bookmarkAdded;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.BookmarkAdded", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17f, 11f);
        v12.verticalLineToRelative(6.97f);
        v12.lineToRelative(-5f, -2.14f);
        v12.lineToRelative(-5f, 2.14f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineTo(3f);
        v12.horizontalLineTo(7f);
        v12.curveTo(5.9f, 3f, 5f, 3.9f, 5f, 5f);
        v12.verticalLineToRelative(16f);
        v12.lineToRelative(7f, -3f);
        v12.lineToRelative(7f, 3f);
        v12.verticalLineTo(11f);
        v12.horizontalLineTo(17f);
        v12.close();
        v12.moveTo(17.83f, 9f);
        v12.lineTo(15f, 6.17f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(3.54f, -3.54f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineTo(17.83f, 9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BookmarkAddedKt._bookmarkAdded = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

