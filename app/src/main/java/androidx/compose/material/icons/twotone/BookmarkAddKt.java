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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_bookmarkAdd", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BookmarkAdd", "Landroidx/compose/material/icons/Icons$TwoTone;", "getBookmarkAdd", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BookmarkAddKt {
    private static ImageVector _bookmarkAdd;

    static {
    }

    public static final ImageVector getBookmarkAdd(TwoTone arg19) {
        ImageVector v0 = BookmarkAddKt._bookmarkAdd;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.BookmarkAdd", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17f, 17.969999f);
        v12.lineToRelative(0f, -7.07f);
        v12.curveToRelative(-2.28f, -0.46f, -4f, -2.48f, -4f, -4.9f);
        v12.curveToRelative(0f, -0.34f, 0.03f, -0.68f, 0.1f, -1f);
        v12.lineTo(7f, 5f);
        v12.verticalLineToRelative(12.97f);
        v12.lineToRelative(5f, -2.14f);
        v12.lineTo(17f, 17.969999f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(21f, 7f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(3f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(7f);
        v12.close();
        v12.moveTo(17f, 17.969999f);
        v12.lineToRelative(-5f, -2.14f);
        v12.lineToRelative(-5f, 2.14f);
        v12.verticalLineTo(5f);
        v12.lineToRelative(6.1f, 0f);
        v12.curveToRelative(0.15f, -0.74f, 0.46f, -1.42f, 0.9f, -2f);
        v12.lineTo(7f, 3f);
        v12.curveTo(5.9f, 3f, 5f, 3.9f, 5f, 5f);
        v12.verticalLineToRelative(16f);
        v12.lineToRelative(7f, -3f);
        v12.lineToRelative(7f, 3f);
        v12.lineToRelative(0f, -10.1f);
        v12.curveToRelative(-0.32f, 0.07f, -0.66f, 0.1f, -1f, 0.1f);
        v12.curveToRelative(-0.34f, 0f, -0.68f, -0.03f, -1f, -0.1f);
        v12.lineTo(17f, 17.969999f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BookmarkAddKt._bookmarkAdd = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

