package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_speed", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Speed", "Landroidx/compose/material/icons/Icons$Rounded;", "getSpeed", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SpeedKt {
    private static ImageVector _speed;

    static {
    }

    public static final ImageVector getSpeed(Rounded arg20) {
        ImageVector v0 = SpeedKt._speed;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Speed", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.459999f, 10f);
        v12.arcToRelative(1f, 1f, 0f, false, false, -0.07f, 1f);
        v12.arcToRelative(7.55f, 7.55f, 0f, false, true, 0.52f, 1.81f);
        v12.arcToRelative(8f, 8f, 0f, false, true, -0.69f, 4.73f);
        v12.arcToRelative(1f, 1f, 0f, false, true, -0.89f, 0.53f);
        v12.horizontalLineTo(5.68f);
        v12.arcToRelative(1f, 1f, 0f, false, true, -0.89f, -0.54f);
        v12.arcTo(8f, 8f, 0f, false, true, 13f, 6.06f);
        v12.arcToRelative(7.69f, 7.69f, 0f, false, true, 2.11f, 0.56f);
        v12.arcToRelative(1f, 1f, 0f, false, false, 1f, -0.07f);
        v12.arcToRelative(1f, 1f, 0f, false, false, -0.17f, -1.76f);
        v12.arcTo(10f, 10f, 0f, false, false, 3.35f, 19f);
        v12.arcToRelative(2f, 2f, 0f, false, false, 1.72f, 1f);
        v12.horizontalLineToRelative(13.85f);
        v12.arcToRelative(2f, 2f, 0f, false, false, 1.74f, -1f);
        v12.arcToRelative(10f, 10f, 0f, false, false, 0.55f, -8.89f);
        v12.arcToRelative(1f, 1f, 0f, false, false, -1.75f, -0.11f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(10.59f, 12.59f);
        v12.arcToRelative(2f, 2f, 0f, false, false, 2.83f, 2.83f);
        v12.lineToRelative(5.66f, -8.49f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SpeedKt._speed = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

