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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_phonelinkRing", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PhonelinkRing", "Landroidx/compose/material/icons/Icons$Rounded;", "getPhonelinkRing", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PhonelinkRingKt {
    private static ImageVector _phonelinkRing;

    static {
    }

    public static final ImageVector getPhonelinkRing(Rounded arg19) {
        ImageVector v0 = PhonelinkRingKt._phonelinkRing;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.PhonelinkRing", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14f, 1f);
        v12.lineTo(4f, 1f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(18f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(10f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(16f, 3f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(14f, 20f);
        v12.lineTo(4f, 20f);
        v12.lineTo(4f, 4f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(16f);
        v12.close();
        v12.moveTo(20.629999f, 8.26f);
        v12.curveToRelative(-0.26f, -0.32f, -0.74f, -0.36f, -1.04f, -0.06f);
        v12.lineToRelative(-0.03f, 0.03f);
        v12.curveToRelative(-0.25f, 0.25f, -0.26f, 0.65f, -0.05f, 0.93f);
        v12.curveToRelative(1.26f, 1.64f, 1.25f, 3.87f, -0.02f, 5.57f);
        v12.curveToRelative(-0.21f, 0.28f, -0.19f, 0.67f, 0.05f, 0.92f);
        v12.lineToRelative(0.05f, 0.05f);
        v12.curveToRelative(0.29f, 0.29f, 0.76f, 0.26f, 1.03f, -0.05f);
        v12.curveToRelative(1.8f, -2.13f, 1.8f, -5.19f, 0.01f, -7.39f);
        v12.close();
        v12.moveTo(17.42f, 10.37f);
        v12.lineToRelative(-0.06f, 0.06f);
        v12.curveToRelative(-0.2f, 0.2f, -0.26f, 0.5f, -0.15f, 0.76f);
        v12.curveToRelative(0.21f, 0.49f, 0.21f, 1.03f, 0f, 1.52f);
        v12.curveToRelative(-0.11f, 0.26f, -0.05f, 0.56f, 0.15f, 0.76f);
        v12.lineToRelative(0.08f, 0.08f);
        v12.curveToRelative(0.32f, 0.32f, 0.87f, 0.25f, 1.09f, -0.15f);
        v12.curveToRelative(0.49f, -0.89f, 0.49f, -1.94f, -0.01f, -2.86f);
        v12.curveToRelative(-0.22f, -0.42f, -0.77f, -0.5f, -1.1f, -0.17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PhonelinkRingKt._phonelinkRing = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

