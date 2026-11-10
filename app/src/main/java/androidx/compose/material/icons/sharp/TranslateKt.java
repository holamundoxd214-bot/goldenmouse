package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_translate", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Translate", "Landroidx/compose/material/icons/Icons$Sharp;", "getTranslate", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TranslateKt {
    private static ImageVector _translate;

    static {
    }

    public static final ImageVector getTranslate(Sharp arg19) {
        ImageVector v0 = TranslateKt._translate;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Translate", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.87f, 15.07f);
        v12.lineToRelative(-2.54f, -2.51f);
        v12.lineToRelative(0.03f, -0.03f);
        v12.curveToRelative(1.74f, -1.94f, 2.98f, -4.17f, 3.71f, -6.53f);
        v12.lineTo(17f, 6f);
        v12.lineTo(17f, 4f);
        v12.horizontalLineToRelative(-7f);
        v12.lineTo(10f, 2f);
        v12.lineTo(8f, 2f);
        v12.verticalLineToRelative(2f);
        v12.lineTo(1f, 4f);
        v12.verticalLineToRelative(1.99f);
        v12.horizontalLineToRelative(11.17f);
        v12.curveTo(11.5f, 7.92f, 10.44f, 9.75f, 9f, 11.35f);
        v12.curveTo(8.07f, 10.32f, 7.3f, 9.19f, 6.69f, 8f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(0.73f, 1.63f, 1.73f, 3.17f, 2.98f, 4.56f);
        v12.lineToRelative(-5.09f, 5.02f);
        v12.lineTo(4f, 19f);
        v12.lineToRelative(5f, -5f);
        v12.lineToRelative(3.11f, 3.11f);
        v12.lineToRelative(0.76f, -2.04f);
        v12.close();
        v12.moveTo(18.5f, 10f);
        v12.horizontalLineToRelative(-2f);
        v12.lineTo(12f, 22f);
        v12.horizontalLineToRelative(2f);
        v12.lineToRelative(1.12f, -3f);
        v12.horizontalLineToRelative(4.75f);
        v12.lineTo(21f, 22f);
        v12.horizontalLineToRelative(2f);
        v12.lineToRelative(-4.5f, -12f);
        v12.close();
        v12.moveTo(15.88f, 17f);
        v12.lineToRelative(1.62f, -4.33f);
        v12.lineTo(19.120001f, 17f);
        v12.horizontalLineToRelative(-3.24f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TranslateKt._translate = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

