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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_translate", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Translate", "Landroidx/compose/material/icons/Icons$Rounded;", "getTranslate", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TranslateKt {
    private static ImageVector _translate;

    static {
    }

    public static final ImageVector getTranslate(Rounded arg19) {
        ImageVector v0 = TranslateKt._translate;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Translate", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.65f, 15.67f);
        v12.curveToRelative(0.14f, -0.36f, 0.05f, -0.77f, -0.23f, -1.05f);
        v12.lineToRelative(-2.09f, -2.06f);
        v12.lineToRelative(0.03f, -0.03f);
        v12.curveToRelative(1.74f, -1.94f, 2.98f, -4.17f, 3.71f, -6.53f);
        v12.horizontalLineToRelative(1.94f);
        v12.curveToRelative(0.54f, 0f, 0.99f, -0.45f, 0.99f, -0.99f);
        v12.verticalLineToRelative(-0.02f);
        v12.curveToRelative(0f, -0.54f, -0.45f, -0.99f, -0.99f, -0.99f);
        v12.lineTo(10f, 4f);
        v12.lineTo(10f, 3f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(1f);
        v12.lineTo(1.99f, 4f);
        v12.curveToRelative(-0.54f, 0f, -0.99f, 0.45f, -0.99f, 0.99f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 0.99f, 0.99f, 0.99f);
        v12.horizontalLineToRelative(10.18f);
        v12.curveTo(11.5f, 7.92f, 10.44f, 9.75f, 9f, 11.35f);
        v12.curveToRelative(-0.81f, -0.89f, -1.49f, -1.86f, -2.06f, -2.88f);
        v12.curveToRelative(-0.16f, -0.29f, -0.45f, -0.47f, -0.78f, -0.47f);
        v12.curveToRelative(-0.69f, 0f, -1.13f, 0.75f, -0.79f, 1.35f);
        v12.curveToRelative(0.63f, 1.13f, 1.4f, 2.21f, 2.3f, 3.21f);
        v12.lineTo(3.3f, 16.870001f);
        v12.curveToRelative(-0.4f, 0.39f, -0.4f, 1.03f, 0f, 1.42f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.42f, 0f);
        v12.lineTo(9f, 14f);
        v12.lineToRelative(2.02f, 2.02f);
        v12.curveToRelative(0.51f, 0.51f, 1.38f, 0.32f, 1.63f, -0.35f);
        v12.close();
        v12.moveTo(17.5f, 10f);
        v12.curveToRelative(-0.6f, 0f, -1.14f, 0.37f, -1.35f, 0.94f);
        v12.lineToRelative(-3.67f, 9.8f);
        v12.curveToRelative(-0.24f, 0.61f, 0.22f, 1.26f, 0.87f, 1.26f);
        v12.curveToRelative(0.39f, 0f, 0.74f, -0.24f, 0.88f, -0.61f);
        v12.lineToRelative(0.89f, -2.39f);
        v12.horizontalLineToRelative(4.75f);
        v12.lineToRelative(0.9f, 2.39f);
        v12.curveToRelative(0.14f, 0.36f, 0.49f, 0.61f, 0.88f, 0.61f);
        v12.curveToRelative(0.65f, 0f, 1.11f, -0.65f, 0.88f, -1.26f);
        v12.lineToRelative(-3.67f, -9.8f);
        v12.curveToRelative(-0.22f, -0.57f, -0.76f, -0.94f, -1.36f, -0.94f);
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

