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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_doneOutline", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DoneOutline", "Landroidx/compose/material/icons/Icons$Outlined;", "getDoneOutline", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DoneOutlineKt {
    private static ImageVector _doneOutline;

    static {
    }

    public static final ImageVector getDoneOutline(Outlined arg18) {
        ImageVector v0 = DoneOutlineKt._doneOutline;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.DoneOutline", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v2 = new PathBuilder();
        v2.moveTo(19.77f, 4.93f);
        v2.lineToRelative(1.4f, 1.4f);
        v2.lineTo(8.43f, 19.07f);
        v2.lineToRelative(-5.6f, -5.6f);
        v2.lineToRelative(1.4f, -1.4f);
        v2.lineToRelative(4.2f, 4.2f);
        v2.lineTo(19.77f, 4.93f);
        v2.moveToRelative(0f, -2.83f);
        v2.lineTo(8.43f, 13.44f);
        v2.lineToRelative(-4.2f, -4.2f);
        v2.lineTo(0f, 13.47f);
        v2.lineToRelative(8.43f, 8.43f);
        v2.lineTo(24f, 6.33f);
        v2.lineTo(19.77f, 2.1f);
        v2.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v2.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DoneOutlineKt._doneOutline = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

