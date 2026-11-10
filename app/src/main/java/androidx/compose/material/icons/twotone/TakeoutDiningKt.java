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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_takeoutDining", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TakeoutDining", "Landroidx/compose/material/icons/Icons$TwoTone;", "getTakeoutDining", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TakeoutDiningKt {
    private static ImageVector _takeoutDining;

    static {
    }

    public static final ImageVector getTakeoutDining(TwoTone arg24) {
        ImageVector v0 = TakeoutDiningKt._takeoutDining;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.TakeoutDining", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(9.83f, 5f);
        v0_1.lineToRelative(-2.8f, 2.73f);
        v0_1.lineToRelative(0.09f, 1.27f);
        v0_1.lineToRelative(9.75f, 0f);
        v0_1.lineToRelative(0.09f, -1.27f);
        v0_1.lineToRelative(-2.8f, -2.73f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v2 = new PathBuilder();
        v2.moveTo(7.79f, 18f);
        v2.lineToRelative(8.44f, 0f);
        v2.lineToRelative(0.51f, -7f);
        v2.lineToRelative(-9.46f, 0f);
        v2.close();
        Builder.addPath-oIyEayM$default(v1, v2.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(20.59f, 6.05f);
        v0_1.lineTo(19f, 7.63f);
        v0_1.lineToRelative(0.03f, -0.56f);
        v0_1.lineTo(14.98f, 3f);
        v0_1.horizontalLineTo(9.02f);
        v0_1.lineTo(4.97f, 7.07f);
        v0_1.lineTo(5f, 7.57f);
        v0_1.lineTo(3.41f, 6.01f);
        v0_1.lineTo(2f, 7.44f);
        v0_1.lineToRelative(3.23f, 3.11f);
        v0_1.lineTo(5.93f, 20f);
        v0_1.horizontalLineToRelative(12.14f);
        v0_1.lineToRelative(0.7f, -9.44f);
        v0_1.lineTo(22f, 7.46f);
        v0_1.lineTo(20.59f, 6.05f);
        v0_1.close();
        v0_1.moveTo(16.23f, 18f);
        v0_1.horizontalLineTo(7.79f);
        v0_1.lineToRelative(-0.51f, -7f);
        v0_1.horizontalLineToRelative(9.46f);
        v0_1.lineTo(16.23f, 18f);
        v0_1.close();
        v0_1.moveTo(16.870001f, 9f);
        v0_1.horizontalLineTo(7.12f);
        v0_1.lineTo(7.03f, 7.73f);
        v0_1.lineTo(9.83f, 5f);
        v0_1.horizontalLineToRelative(4.33f);
        v0_1.lineToRelative(2.8f, 2.73f);
        v0_1.lineTo(16.870001f, 9f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TakeoutDiningKt._takeoutDining = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

