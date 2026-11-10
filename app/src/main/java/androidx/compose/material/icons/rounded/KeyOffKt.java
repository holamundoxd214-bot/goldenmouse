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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_keyOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "KeyOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getKeyOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class KeyOffKt {
    private static ImageVector _keyOff;

    static {
    }

    public static final ImageVector getKeyOff(Rounded arg19) {
        ImageVector v0 = KeyOffKt._keyOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.KeyOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.83f, 10f);
        v12.lineToRelative(4.09f, 4.09f);
        v12.lineTo(17f, 14f);
        v12.lineToRelative(1.29f, 1.29f);
        v12.curveToRelative(0.39f, 0.39f, 1.03f, 0.39f, 1.42f, 0f);
        v12.lineToRelative(2.59f, -2.61f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.03f, -0.01f, -1.42f);
        v12.lineToRelative(-0.99f, -0.97f);
        v12.curveTo(21.1f, 10.1f, 20.85f, 10f, 20.59f, 10f);
        v12.horizontalLineTo(12.83f);
        v12.close();
        v12.moveTo(19.07f, 21.9f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.reflectiveCurveToRelative(0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(3.51f, 3.51f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(1.88f, 1.88f);
        v12.curveTo(2.2f, 7.85f, 1f, 9.79f, 1f, 12f);
        v12.curveToRelative(0f, 3.31f, 2.69f, 6f, 6f, 6f);
        v12.curveToRelative(2.21f, 0f, 4.15f, -1.2f, 5.18f, -2.99f);
        v12.lineTo(19.07f, 21.9f);
        v12.close();
        v12.moveTo(9.91f, 12.74f);
        v12.curveTo(9.58f, 14.03f, 8.4f, 15f, 7f, 15f);
        v12.curveToRelative(-1.65f, 0f, -3f, -1.35f, -3f, -3f);
        v12.curveToRelative(0f, -1.4f, 0.97f, -2.58f, 2.26f, -2.91f);
        v12.lineTo(9.91f, 12.74f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        KeyOffKt._keyOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

