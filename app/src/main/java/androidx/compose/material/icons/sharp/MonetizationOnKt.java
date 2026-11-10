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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_monetizationOn", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MonetizationOn", "Landroidx/compose/material/icons/Icons$Sharp;", "getMonetizationOn", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MonetizationOnKt {
    private static ImageVector _monetizationOn;

    static {
    }

    public static final ImageVector getMonetizationOn(Sharp arg19) {
        ImageVector v0 = MonetizationOnKt._monetizationOn;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.MonetizationOn", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.lineTo(13.41f, 20f);
        v12.horizontalLineToRelative(-2.67f);
        v12.verticalLineToRelative(-1.93f);
        v12.curveToRelative(-1.71f, -0.36f, -3.16f, -1.46f, -3.27f, -3.4f);
        v12.horizontalLineToRelative(1.96f);
        v12.curveToRelative(0.1f, 1.05f, 0.82f, 1.87f, 2.65f, 1.87f);
        v12.curveToRelative(1.96f, 0f, 2.4f, -0.98f, 2.4f, -1.59f);
        v12.curveToRelative(0f, -0.83f, -0.44f, -1.61f, -2.67f, -2.14f);
        v12.curveToRelative(-2.48f, -0.6f, -4.18f, -1.62f, -4.18f, -3.67f);
        v12.curveToRelative(0f, -1.72f, 1.39f, -2.84f, 3.11f, -3.21f);
        v12.lineTo(10.74f, 4f);
        v12.horizontalLineToRelative(2.67f);
        v12.verticalLineToRelative(1.95f);
        v12.curveToRelative(1.86f, 0.45f, 2.79f, 1.86f, 2.85f, 3.39f);
        v12.lineTo(14.3f, 9.34f);
        v12.curveToRelative(-0.05f, -1.11f, -0.64f, -1.87f, -2.22f, -1.87f);
        v12.curveToRelative(-1.5f, 0f, -2.4f, 0.68f, -2.4f, 1.64f);
        v12.curveToRelative(0f, 0.84f, 0.65f, 1.39f, 2.67f, 1.91f);
        v12.reflectiveCurveToRelative(4.18f, 1.39f, 4.18f, 3.91f);
        v12.curveToRelative(-0.01f, 1.83f, -1.38f, 2.83f, -3.12f, 3.16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MonetizationOnKt._monetizationOn = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

