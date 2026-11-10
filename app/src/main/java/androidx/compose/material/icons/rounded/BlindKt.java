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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_blind", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Blind", "Landroidx/compose/material/icons/Icons$Rounded;", "getBlind", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BlindKt {
    private static ImageVector _blind;

    static {
    }

    public static final ImageVector getBlind(Rounded arg20) {
        ImageVector v0 = BlindKt._blind;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Blind", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.41f, 3.5f);
        v12.moveToRelative(-2f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, 4f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, -4f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12.04f, 7.12f);
        v12.curveToRelative(-0.17f, -0.35f, -0.44f, -0.65f, -0.8f, -0.85f);
        v12.curveTo(10.63f, 5.91f, 9.9f, 5.93f, 9.31f, 6.24f);
        v12.lineToRelative(0f, -0.01f);
        v12.lineTo(4.92f, 8.73f);
        v12.curveTo(4.3f, 9.08f, 3.91f, 9.74f, 3.91f, 10.46f);
        v12.verticalLineTo(13f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-2.54f);
        v12.lineToRelative(1.5f, -0.85f);
        v12.curveToRelative(-0.32f, 1.1f, -0.5f, 2.24f, -0.5f, 3.39f);
        v12.verticalLineToRelative(5.33f);
        v12.lineToRelative(-2f, 2.67f);
        v12.curveToRelative(-0.33f, 0.44f, -0.24f, 1.07f, 0.2f, 1.4f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.44f, 0.33f, 1.07f, 0.24f, 1.4f, -0.2f);
        v12.lineToRelative(2.04f, -2.72f);
        v12.curveToRelative(0.23f, -0.31f, 0.37f, -0.69f, 0.4f, -1.08f);
        v12.lineToRelative(0.18f, -2.94f);
        v12.lineTo(10.91f, 18f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-4.87f);
        v12.curveToRelative(0f, -0.41f, -0.13f, -0.81f, -0.36f, -1.15f);
        v12.lineToRelative(-1.6f, -2.29f);
        v12.curveToRelative(0f, 0f, 0f, 0f, 0f, -0.01f);
        v12.curveToRelative(-0.11f, -1.16f, 0.07f, -2.32f, 0.46f, -3.4f);
        v12.curveToRelative(0.75f, 1.14f, 1.88f, 1.98f, 3.2f, 2.41f);
        v12.lineToRelative(5.7f, 9.87f);
        v12.curveToRelative(0.14f, 0.24f, 0.44f, 0.32f, 0.68f, 0.18f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.24f, -0.14f, 0.32f, -0.44f, 0.18f, -0.68f);
        v12.lineTo(15.92f, 13f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.54f, 0f, 0.98f, -0.44f, 0.98f, -0.98f);
        v12.verticalLineToRelative(-0.05f);
        v12.curveToRelative(0f, -0.5f, -0.37f, -0.94f, -0.87f, -0.99f);
        v12.curveToRelative(-0.95f, -0.1f, -2.37f, -0.52f, -3.21f, -2.18f);
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BlindKt._blind = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

