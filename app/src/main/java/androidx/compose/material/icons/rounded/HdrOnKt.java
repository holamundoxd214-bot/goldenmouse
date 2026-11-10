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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_hdrOn", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HdrOn", "Landroidx/compose/material/icons/Icons$Rounded;", "getHdrOn", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HdrOnKt {
    private static ImageVector _hdrOn;

    static {
    }

    public static final ImageVector getHdrOn(Rounded arg19) {
        ImageVector v0 = HdrOnKt._hdrOn;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.HdrOn", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7.25f, 9f);
        v12.curveToRelative(-0.41f, 0f, -0.75f, 0.34f, -0.75f, 0.75f);
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
        v12.verticalLineToRelative(-4.5f);
        v12.curveTo(8f, 9.34f, 7.66f, 9f, 7.25f, 9f);
        v12.close();
        v12.moveTo(21f, 11.5f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        v12.lineTo(17f, 9f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(4.25f);
        v12.curveToRelative(0f, 0.41f, 0.34f, 0.75f, 0.75f, 0.75f);
        v12.reflectiveCurveToRelative(0.75f, -0.34f, 0.75f, -0.75f);
        v12.lineTo(17.5f, 13f);
        v12.horizontalLineToRelative(1.1f);
        v12.lineToRelative(0.72f, 1.59f);
        v12.curveToRelative(0.11f, 0.25f, 0.36f, 0.41f, 0.63f, 0.41f);
        v12.curveToRelative(0.5f, 0f, 0.83f, -0.51f, 0.64f, -0.96f);
        v12.lineToRelative(-0.49f, -1.14f);
        v12.curveToRelative(0.5f, -0.3f, 0.9f, -0.8f, 0.9f, -1.4f);
        v12.close();
        v12.moveTo(17.5f, 11.5f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-2f);
        v12.close();
        v12.moveTo(13f, 9f);
        v12.horizontalLineToRelative(-3f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f);
        v12.verticalLineToRelative(5f);
        v12.curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0.82f, 0f, 1.5f, -0.68f, 1.5f, -1.5f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(0f, -0.82f, -0.68f, -1.5f, -1.5f, -1.5f);
        v12.close();
        v12.moveTo(13f, 13.5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HdrOnKt._hdrOn = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

