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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_bookOnline", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BookOnline", "Landroidx/compose/material/icons/Icons$TwoTone;", "getBookOnline", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BookOnlineKt {
    private static ImageVector _bookOnline;

    static {
    }

    public static final ImageVector getBookOnline(TwoTone arg19) {
        ImageVector v0 = BookOnlineKt._bookOnline;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.BookOnline", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(17f, 4f);
        v0_1.horizontalLineTo(7f);
        v0_1.verticalLineTo(3f);
        v0_1.horizontalLineToRelative(10f);
        v0_1.verticalLineTo(4f);
        v0_1.close();
        v0_1.moveTo(17f, 21f);
        v0_1.horizontalLineTo(7f);
        v0_1.verticalLineToRelative(-1f);
        v0_1.horizontalLineToRelative(10f);
        v0_1.verticalLineTo(21f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17f, 4f);
        v12.horizontalLineTo(7f);
        v12.verticalLineTo(3f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineTo(4f);
        v12.close();
        v12.moveTo(17f, 21f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineTo(21f);
        v12.close();
        v12.moveTo(17f, 1f);
        v12.horizontalLineTo(7f);
        v12.curveTo(5.9f, 1f, 5f, 1.9f, 5f, 3f);
        v12.verticalLineToRelative(18f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(10f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(3f);
        v12.curveTo(19f, 1.9f, 18.1f, 1f, 17f, 1f);
        v12.lineTo(17f, 1f);
        v12.close();
        v12.moveTo(7f, 6f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(12f);
        v12.horizontalLineTo(7f);
        v12.verticalLineTo(6f);
        v12.close();
        v12.moveTo(16f, 11f);
        v12.verticalLineTo(9.14f);
        v12.curveTo(16f, 8.51f, 15.55f, 8f, 15f, 8f);
        v12.horizontalLineTo(9f);
        v12.curveTo(8.45f, 8f, 8f, 8.51f, 8f, 9.14f);
        v12.lineToRelative(0f, 1.96f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.lineToRelative(0f, 1.76f);
        v12.curveTo(8f, 15.49f, 8.45f, 16f, 9f, 16f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.51f, 1f, -1.14f);
        v12.verticalLineTo(13f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.curveTo(15f, 11.45f, 15.45f, 11f, 16f, 11f);
        v12.close();
        v12.moveTo(12.5f, 14.5f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(14.5f);
        v12.close();
        v12.moveTo(12.5f, 12.5f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(12.5f);
        v12.close();
        v12.moveTo(12.5f, 10.5f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(10.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BookOnlineKt._bookOnline = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

