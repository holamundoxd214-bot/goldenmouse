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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_markEmailRead", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MarkEmailRead", "Landroidx/compose/material/icons/Icons$Sharp;", "getMarkEmailRead", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MarkEmailReadKt {
    private static ImageVector _markEmailRead;

    static {
    }

    public static final ImageVector getMarkEmailRead(Sharp arg19) {
        ImageVector v0 = MarkEmailReadKt._markEmailRead;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.MarkEmailRead", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 19f);
        v12.curveToRelative(0f, -3.87f, 3.13f, -7f, 7f, -7f);
        v12.curveToRelative(1.08f, 0f, 2.09f, 0.25f, 3f, 0.68f);
        v12.verticalLineTo(4f);
        v12.horizontalLineTo(2f);
        v12.verticalLineToRelative(16f);
        v12.horizontalLineToRelative(10.08f);
        v12.curveTo(12.03f, 19.67f, 12f, 19.34f, 12f, 19f);
        v12.close();
        v12.moveTo(4f, 6f);
        v12.lineToRelative(8f, 5f);
        v12.lineToRelative(8f, -5f);
        v12.verticalLineToRelative(2f);
        v12.lineToRelative(-8f, 5f);
        v12.lineTo(4f, 8f);
        v12.verticalLineTo(6f);
        v12.close();
        v12.moveTo(17.34f, 22f);
        v12.lineToRelative(-3.54f, -3.54f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(2.12f, 2.12f);
        v12.lineToRelative(4.24f, -4.24f);
        v12.lineTo(23f, 16.34f);
        v12.lineTo(17.34f, 22f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MarkEmailReadKt._markEmailRead = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

