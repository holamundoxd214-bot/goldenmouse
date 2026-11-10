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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_publishedWithChanges", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PublishedWithChanges", "Landroidx/compose/material/icons/Icons$Outlined;", "getPublishedWithChanges", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PublishedWithChangesKt {
    private static ImageVector _publishedWithChanges;

    static {
    }

    public static final ImageVector getPublishedWithChanges(Outlined arg19) {
        ImageVector v0 = PublishedWithChangesKt._publishedWithChanges;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.PublishedWithChanges", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.6f, 19.5f);
        v12.horizontalLineTo(21f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-6f);
        v12.verticalLineToRelative(-6f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2.73f);
        v12.curveToRelative(1.83f, -1.47f, 3f, -3.71f, 3f, -6.23f);
        v12.curveToRelative(0f, -4.07f, -3.06f, -7.44f, -7f, -7.93f);
        v12.verticalLineTo(2.05f);
        v12.curveToRelative(5.05f, 0.5f, 9f, 4.76f, 9f, 9.95f);
        v12.curveTo(22f, 14.99f, 20.68f, 17.67f, 18.6f, 19.5f);
        v12.close();
        v12.moveTo(4f, 12f);
        v12.curveToRelative(0f, -2.52f, 1.17f, -4.77f, 3f, -6.23f);
        v12.verticalLineTo(8.5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-6f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2.4f);
        v12.curveTo(3.32f, 6.33f, 2f, 9.01f, 2f, 12f);
        v12.curveToRelative(0f, 5.19f, 3.95f, 9.45f, 9f, 9.95f);
        v12.verticalLineToRelative(-2.02f);
        v12.curveTo(7.06f, 19.440001f, 4f, 16.07f, 4f, 12f);
        v12.close();
        v12.moveTo(16.24f, 8.11f);
        v12.lineToRelative(-5.66f, 5.66f);
        v12.lineToRelative(-2.83f, -2.83f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.lineToRelative(4.24f, 4.24f);
        v12.lineToRelative(7.07f, -7.07f);
        v12.lineTo(16.24f, 8.11f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PublishedWithChangesKt._publishedWithChanges = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

