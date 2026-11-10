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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_blind", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Blind", "Landroidx/compose/material/icons/Icons$Outlined;", "getBlind", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BlindKt {
    private static ImageVector _blind;

    static {
    }

    public static final ImageVector getBlind(Outlined arg20) {
        ImageVector v0 = BlindKt._blind;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Blind", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.5f, 3.5f);
        v12.moveToRelative(-2f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, 4f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, -4f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12.13f, 7.12f);
        v12.curveToRelative(-0.17f, -0.35f, -0.44f, -0.65f, -0.8f, -0.85f);
        v12.curveTo(10.72f, 5.91f, 9.99f, 5.93f, 9.4f, 6.24f);
        v12.lineToRelative(0f, -0.01f);
        v12.lineTo(4f, 9.3f);
        v12.verticalLineTo(14f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-3.54f);
        v12.lineToRelative(1.5f, -0.85f);
        v12.curveTo(7.18f, 10.71f, 7f, 11.85f, 7f, 13f);
        v12.verticalLineToRelative(5.33f);
        v12.lineTo(4.4f, 21.799999f);
        v12.lineTo(6f, 23f);
        v12.lineToRelative(3f, -4f);
        v12.lineToRelative(0.22f, -3.54f);
        v12.lineTo(11f, 18f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-6.5f);
        v12.lineToRelative(-1.97f, -2.81f);
        v12.curveToRelative(-0.04f, -0.52f, -0.14f, -1.76f, 0.45f, -3.4f);
        v12.curveToRelative(0.75f, 1.14f, 1.88f, 1.98f, 3.2f, 2.41f);
        v12.lineTo(20.629999f, 23f);
        v12.lineToRelative(0.87f, -0.5f);
        v12.lineTo(16.02f, 13f);
        v12.horizontalLineTo(17f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(-0.49f, 0f, -2.88f, 0.17f, -4.08f, -2.21f);
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BlindKt._blind = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

