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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_redo", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Redo", "Landroidx/compose/material/icons/Icons$Sharp;", "getRedo$annotations", "(Landroidx/compose/material/icons/Icons$Sharp;)V", "getRedo", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RedoKt {
    private static ImageVector _redo;

    static {
    }

    public static final ImageVector getRedo(Sharp arg19) {
        ImageVector v0 = RedoKt._redo;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Redo", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.4f, 10.6f);
        v12.curveTo(16.549999f, 8.99f, 14.15f, 8f, 11.5f, 8f);
        v12.curveToRelative(-4.65f, 0f, -8.58f, 3.03f, -9.96f, 7.22f);
        v12.lineTo(3.9f, 16f);
        v12.curveToRelative(1.05f, -3.19f, 4.05f, -5.5f, 7.6f, -5.5f);
        v12.curveToRelative(1.95f, 0f, 3.73f, 0.72f, 5.12f, 1.88f);
        v12.lineTo(13f, 16f);
        v12.horizontalLineToRelative(9f);
        v12.verticalLineTo(7f);
        v12.lineToRelative(-3.6f, 3.6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RedoKt._redo = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Sharp.Redo", replaceWith="<_subannotation>") public static void getRedo$annotations(Sharp arg0) {
    }
}

