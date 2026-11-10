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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_mailLock", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MailLock", "Landroidx/compose/material/icons/Icons$Sharp;", "getMailLock", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MailLockKt {
    private static ImageVector _mailLock;

    static {
    }

    public static final ImageVector getMailLock(Sharp arg19) {
        ImageVector v0 = MailLockKt._mailLock;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.MailLock", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 9.97f);
        v12.verticalLineTo(4f);
        v12.horizontalLineTo(2.01f);
        v12.lineTo(2f, 20f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineToRelative(-5.03f);
        v12.curveToRelative(0f, -2.76f, 2.24f, -5f, 5f, -5f);
        v12.horizontalLineTo(22f);
        v12.close();
        v12.moveTo(20f, 8f);
        v12.lineToRelative(-8f, 5f);
        v12.lineTo(4f, 8f);
        v12.verticalLineTo(6f);
        v12.lineToRelative(8f, 5f);
        v12.lineToRelative(8f, -5f);
        v12.verticalLineTo(8f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(23f, 15f);
        v12.verticalLineToRelative(-0.89f);
        v12.curveToRelative(0f, -1f, -0.68f, -1.92f, -1.66f, -2.08f);
        v12.curveTo(20.08f, 11.82f, 19f, 12.79f, 19f, 14f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(-5f);
        v12.horizontalLineTo(23f);
        v12.close();
        v12.moveTo(22f, 15f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.verticalLineTo(15f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MailLockKt._mailLock = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

