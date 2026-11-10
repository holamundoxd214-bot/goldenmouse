package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_markEmailUnread", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MarkEmailUnread", "Landroidx/compose/material/icons/Icons$Sharp;", "getMarkEmailUnread", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MarkEmailUnreadKt {
    private static ImageVector _markEmailUnread;

    static {
    }

    public static final ImageVector getMarkEmailUnread(Sharp arg19) {
        ImageVector v0 = MarkEmailUnreadKt._markEmailUnread;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.MarkEmailUnread", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 8.98f);
        v12.verticalLineTo(20f);
        v12.horizontalLineTo(2f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(12.1f);
        v12.curveTo(14.04f, 4.32f, 14f, 4.66f, 14f, 5f);
        v12.curveToRelative(0f, 1.48f, 0.65f, 2.79f, 1.67f, 3.71f);
        v12.lineTo(12f, 11f);
        v12.lineTo(4f, 6f);
        v12.verticalLineToRelative(2f);
        v12.lineToRelative(8f, 5f);
        v12.lineToRelative(5.3f, -3.32f);
        v12.curveTo(17.84f, 9.88f, 18.4f, 10f, 19f, 10f);
        v12.curveTo(20.129999f, 10f, 21.16f, 9.61f, 22f, 8.98f);
        v12.close();
        v12.moveTo(16f, 5f);
        v12.curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f);
        v12.reflectiveCurveToRelative(3f, -1.34f, 3f, -3f);
        v12.reflectiveCurveToRelative(-1.34f, -3f, -3f, -3f);
        v12.reflectiveCurveTo(16f, 3.34f, 16f, 5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MarkEmailUnreadKt._markEmailUnread = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

