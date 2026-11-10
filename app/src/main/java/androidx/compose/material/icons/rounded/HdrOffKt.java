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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_hdrOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HdrOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getHdrOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HdrOffKt {
    private static ImageVector _hdrOff;

    static {
    }

    public static final ImageVector getHdrOff(Rounded arg19) {
        ImageVector v0 = HdrOffKt._hdrOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.HdrOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.5f, 14.25f);
        v12.lineTo(17.5f, 13f);
        v12.horizontalLineToRelative(1.1f);
        v12.lineToRelative(0.72f, 1.59f);
        v12.curveToRelative(0.11f, 0.25f, 0.36f, 0.41f, 0.63f, 0.41f);
        v12.curveToRelative(0.5f, 0f, 0.83f, -0.51f, 0.64f, -0.96f);
        v12.lineToRelative(-0.49f, -1.14f);
        v12.curveToRelative(0.5f, -0.3f, 0.9f, -0.8f, 0.9f, -1.4f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        v12.lineTo(17f, 9f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(3.9f);
        v12.lineToRelative(1.04f, 1.04f);
        v12.curveToRelative(0.27f, -0.11f, 0.46f, -0.38f, 0.46f, -0.69f);
        v12.close();
        v12.moveTo(17.5f, 10.5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-1f);
        v12.close();
        v12.moveTo(13f, 10.5f);
        v12.verticalLineToRelative(0.4f);
        v12.lineToRelative(1.5f, 1.5f);
        v12.verticalLineToRelative(-1.9f);
        v12.curveToRelative(0f, -0.82f, -0.68f, -1.5f, -1.5f, -1.5f);
        v12.horizontalLineToRelative(-1.9f);
        v12.lineToRelative(1.5f, 1.5f);
        v12.horizontalLineToRelative(0.4f);
        v12.close();
        v12.moveTo(21.030001f, 21.030001f);
        v12.lineToRelative(-18f, -18f);
        v12.curveToRelative(-0.29f, -0.29f, -0.76f, -0.29f, -1.05f, 0f);
        v12.curveToRelative(-0.29f, 0.29f, -0.29f, 0.76f, 0f, 1.05f);
        v12.lineToRelative(4.98f, 4.98f);
        v12.curveToRelative(-0.27f, 0.11f, -0.46f, 0.38f, -0.46f, 0.69f);
        v12.lineTo(6.5f, 11f);
        v12.horizontalLineToRelative(-2f);
        v12.lineTo(4.5f, 9.75f);
        v12.curveToRelative(0f, -0.41f, -0.34f, -0.75f, -0.75f, -0.75f);
        v12.reflectiveCurveTo(3f, 9.34f, 3f, 9.75f);
        v12.verticalLineToRelative(4.5f);
        v12.curveToRelative(0f, 0.41f, 0.34f, 0.75f, 0.75f, 0.75f);
        v12.reflectiveCurveToRelative(0.75f, -0.34f, 0.75f, -0.75f);
        v12.lineTo(4.5f, 12.5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(1.75f);
        v12.curveToRelative(0f, 0.41f, 0.34f, 0.75f, 0.75f, 0.75f);
        v12.reflectiveCurveToRelative(0.75f, -0.34f, 0.75f, -0.75f);
        v12.lineTo(8f, 10.1f);
        v12.lineToRelative(1.5f, 1.5f);
        v12.verticalLineToRelative(2.9f);
        v12.curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f);
        v12.horizontalLineToRelative(2.5f);
        v12.curveToRelative(0.12f, 0f, 0.24f, -0.01f, 0.36f, -0.04f);
        v12.lineToRelative(7.11f, 7.11f);
        v12.curveToRelative(0.29f, 0.29f, 0.76f, 0.29f, 1.05f, 0f);
        v12.curveToRelative(0.29f, -0.28f, 0.29f, -0.75f, 0.01f, -1.04f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HdrOffKt._hdrOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

