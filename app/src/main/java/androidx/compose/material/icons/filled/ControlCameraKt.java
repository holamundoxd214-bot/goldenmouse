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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_controlCamera", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ControlCamera", "Landroidx/compose/material/icons/Icons$Filled;", "getControlCamera", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ControlCameraKt {
    private static ImageVector _controlCamera;

    static {
    }

    public static final ImageVector getControlCamera(Filled arg28) {
        ImageVector v0 = ControlCameraKt._controlCamera;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.ControlCamera", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(15.54f, 5.54f);
        v0_1.lineTo(13.77f, 7.3f);
        v0_1.lineTo(12f, 5.54f);
        v0_1.lineTo(10.23f, 7.3f);
        v0_1.lineTo(8.46f, 5.54f);
        v0_1.lineTo(12f, 2f);
        v0_1.close();
        v0_1.moveTo(18.459999f, 15.54f);
        v0_1.lineToRelative(-1.76f, -1.77f);
        v0_1.lineTo(18.459999f, 12f);
        v0_1.lineToRelative(-1.76f, -1.77f);
        v0_1.lineToRelative(1.76f, -1.77f);
        v0_1.lineTo(22f, 12f);
        v0_1.close();
        v0_1.moveTo(8.46f, 18.459999f);
        v0_1.lineToRelative(1.77f, -1.76f);
        v0_1.lineTo(12f, 18.459999f);
        v0_1.lineToRelative(1.77f, -1.76f);
        v0_1.lineToRelative(1.77f, 1.76f);
        v0_1.lineTo(12f, 22f);
        v0_1.close();
        v0_1.moveTo(5.54f, 8.46f);
        v0_1.lineToRelative(1.76f, 1.77f);
        v0_1.lineTo(5.54f, 12f);
        v0_1.lineToRelative(1.76f, 1.77f);
        v0_1.lineToRelative(-1.76f, 1.77f);
        v0_1.lineTo(2f, 12f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(12f, 12f);
        v0_1.moveToRelative(-3f, 0f);
        v0_1.arcToRelative(3f, 3f, 0f, true, true, 6f, 0f);
        v0_1.arcToRelative(3f, 3f, 0f, true, true, -6f, 0f);
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ControlCameraKt._controlCamera = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

