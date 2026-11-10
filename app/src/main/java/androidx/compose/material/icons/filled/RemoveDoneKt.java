package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_removeDone", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RemoveDone", "Landroidx/compose/material/icons/Icons$Filled;", "getRemoveDone", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RemoveDoneKt {
    private static ImageVector _removeDone;

    static {
    }

    public static final ImageVector getRemoveDone(Filled arg18) {
        ImageVector v0 = RemoveDoneKt._removeDone;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.RemoveDone", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(1.79f, 12f);
        v0_1.lineToRelative(5.58f, 5.59f);
        v0_1.lineTo(5.96f, 19f);
        v0_1.lineTo(0.37f, 13.41f);
        v0_1.lineTo(1.79f, 12f);
        v0_1.close();
        v0_1.moveTo(2.24f, 4.22f);
        v0_1.lineTo(12.9f, 14.89f);
        v0_1.lineToRelative(-1.28f, 1.28f);
        v0_1.lineTo(7.44f, 12f);
        v0_1.lineToRelative(-1.41f, 1.41f);
        v0_1.lineTo(11.62f, 19f);
        v0_1.lineToRelative(2.69f, -2.69f);
        v0_1.lineToRelative(4.89f, 4.89f);
        v0_1.lineToRelative(1.41f, -1.41f);
        v0_1.lineTo(3.65f, 2.81f);
        v0_1.lineTo(2.24f, 4.22f);
        v0_1.close();
        v0_1.moveTo(17.139999f, 13.49f);
        v0_1.lineTo(23.620001f, 7f);
        v0_1.lineTo(22.200001f, 5.59f);
        v0_1.lineToRelative(-6.48f, 6.48f);
        v0_1.lineToRelative(1.42f, 1.42f);
        v0_1.close();
        v0_1.moveTo(17.959999f, 7f);
        v0_1.lineToRelative(-1.41f, -1.41f);
        v0_1.lineToRelative(-3.65f, 3.66f);
        v0_1.lineToRelative(1.41f, 1.41f);
        v0_1.lineTo(17.959999f, 7f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RemoveDoneKt._removeDone = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

