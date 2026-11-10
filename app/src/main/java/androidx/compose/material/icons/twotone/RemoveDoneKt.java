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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_removeDone", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RemoveDone", "Landroidx/compose/material/icons/Icons$TwoTone;", "getRemoveDone", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RemoveDoneKt {
    private static ImageVector _removeDone;

    static {
    }

    public static final ImageVector getRemoveDone(TwoTone arg18) {
        ImageVector v0 = RemoveDoneKt._removeDone;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.RemoveDone", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(4.84f, 1.98f);
        v0_1.lineTo(3.43f, 3.39f);
        v0_1.lineToRelative(10.38f, 10.38f);
        v0_1.lineToRelative(-1.41f, 1.41f);
        v0_1.lineToRelative(-4.24f, -4.24f);
        v0_1.lineToRelative(-1.41f, 1.41f);
        v0_1.lineToRelative(5.66f, 5.66f);
        v0_1.lineToRelative(2.83f, -2.83f);
        v0_1.lineToRelative(6.6f, 6.6f);
        v0_1.lineToRelative(1.41f, -1.41f);
        v0_1.lineTo(4.84f, 1.98f);
        v0_1.close();
        v0_1.moveTo(18.049999f, 12.36f);
        v0_1.lineTo(23f, 7.4f);
        v0_1.lineTo(21.57f, 6f);
        v0_1.lineToRelative(-4.94f, 4.94f);
        v0_1.lineTo(18.049999f, 12.36f);
        v0_1.close();
        v0_1.moveTo(17.34f, 7.4f);
        v0_1.lineToRelative(-1.41f, -1.41f);
        v0_1.lineToRelative(-2.12f, 2.12f);
        v0_1.lineToRelative(1.41f, 1.41f);
        v0_1.lineTo(17.34f, 7.4f);
        v0_1.close();
        v0_1.moveTo(1.08f, 12.35f);
        v0_1.lineToRelative(5.66f, 5.66f);
        v0_1.lineToRelative(1.41f, -1.41f);
        v0_1.lineToRelative(-5.66f, -5.66f);
        v0_1.lineTo(1.08f, 12.35f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RemoveDoneKt._removeDone = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

