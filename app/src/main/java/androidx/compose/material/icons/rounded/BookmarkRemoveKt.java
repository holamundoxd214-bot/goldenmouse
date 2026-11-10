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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_bookmarkRemove", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BookmarkRemove", "Landroidx/compose/material/icons/Icons$Rounded;", "getBookmarkRemove", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BookmarkRemoveKt {
    private static ImageVector _bookmarkRemove;

    static {
    }

    public static final ImageVector getBookmarkRemove(Rounded arg19) {
        ImageVector v0 = BookmarkRemoveKt._bookmarkRemove;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.BookmarkRemove", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 6f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(-4f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(4f);
        v12.curveTo(20.549999f, 5f, 21f, 5.45f, 21f, 6f);
        v12.close();
        v12.moveTo(19f, 10.9f);
        v12.curveToRelative(-0.32f, 0.07f, -0.66f, 0.1f, -1f, 0.1f);
        v12.curveToRelative(-2.76f, 0f, -5f, -2.24f, -5f, -5f);
        v12.curveToRelative(0f, -1.13f, 0.37f, -2.16f, 1f, -3f);
        v12.lineTo(7f, 3f);
        v12.curveTo(5.9f, 3f, 5f, 3.9f, 5f, 5f);
        v12.verticalLineToRelative(14.48f);
        v12.curveToRelative(0f, 0.72f, 0.73f, 1.2f, 1.39f, 0.92f);
        v12.lineTo(12f, 18f);
        v12.lineToRelative(5.61f, 2.4f);
        v12.curveToRelative(0.66f, 0.28f, 1.39f, -0.2f, 1.39f, -0.92f);
        v12.verticalLineTo(10.9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BookmarkRemoveKt._bookmarkRemove = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

