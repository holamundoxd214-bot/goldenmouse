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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_monetizationOn", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MonetizationOn", "Landroidx/compose/material/icons/Icons$Rounded;", "getMonetizationOn", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MonetizationOnKt {
    private static ImageVector _monetizationOn;

    static {
    }

    public static final ImageVector getMonetizationOn(Rounded arg19) {
        ImageVector v0 = MonetizationOnKt._monetizationOn;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.MonetizationOn", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.reflectiveCurveTo(17.52f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(13.41f, 18.09f);
        v12.verticalLineToRelative(0.58f);
        v12.curveToRelative(0f, 0.73f, -0.6f, 1.33f, -1.33f, 1.33f);
        v12.horizontalLineToRelative(-0.01f);
        v12.curveToRelative(-0.73f, 0f, -1.33f, -0.6f, -1.33f, -1.33f);
        v12.verticalLineToRelative(-0.6f);
        v12.curveToRelative(-1.33f, -0.28f, -2.51f, -1.01f, -3.01f, -2.24f);
        v12.curveToRelative(-0.23f, -0.55f, 0.2f, -1.16f, 0.8f, -1.16f);
        v12.horizontalLineToRelative(0.24f);
        v12.curveToRelative(0.37f, 0f, 0.67f, 0.25f, 0.81f, 0.6f);
        v12.curveToRelative(0.29f, 0.75f, 1.05f, 1.27f, 2.51f, 1.27f);
        v12.curveToRelative(1.96f, 0f, 2.4f, -0.98f, 2.4f, -1.59f);
        v12.curveToRelative(0f, -0.83f, -0.44f, -1.61f, -2.67f, -2.14f);
        v12.curveToRelative(-2.48f, -0.6f, -4.18f, -1.62f, -4.18f, -3.67f);
        v12.curveToRelative(0f, -1.72f, 1.39f, -2.84f, 3.11f, -3.21f);
        v12.verticalLineToRelative(-0.6f);
        v12.curveToRelative(0f, -0.73f, 0.6f, -1.33f, 1.33f, -1.33f);
        v12.horizontalLineToRelative(0.01f);
        v12.curveToRelative(0.73f, 0f, 1.33f, 0.6f, 1.33f, 1.33f);
        v12.verticalLineToRelative(0.62f);
        v12.curveToRelative(1.38f, 0.34f, 2.25f, 1.2f, 2.63f, 2.26f);
        v12.curveToRelative(0.2f, 0.55f, -0.22f, 1.13f, -0.81f, 1.13f);
        v12.horizontalLineToRelative(-0.26f);
        v12.curveToRelative(-0.37f, 0f, -0.67f, -0.26f, -0.77f, -0.62f);
        v12.curveToRelative(-0.23f, -0.76f, -0.86f, -1.25f, -2.12f, -1.25f);
        v12.curveToRelative(-1.5f, 0f, -2.4f, 0.68f, -2.4f, 1.64f);
        v12.curveToRelative(0f, 0.84f, 0.65f, 1.39f, 2.67f, 1.91f);
        v12.reflectiveCurveToRelative(4.18f, 1.39f, 4.18f, 3.91f);
        v12.curveToRelative(-0.02f, 1.83f, -1.39f, 2.83f, -3.13f, 3.16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MonetizationOnKt._monetizationOn = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

