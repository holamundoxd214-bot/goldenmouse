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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_wrapText", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WrapText", "Landroidx/compose/material/icons/Icons$Rounded;", "getWrapText$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getWrapText", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WrapTextKt {
    private static ImageVector _wrapText;

    static {
    }

    public static final ImageVector getWrapText(Rounded arg19) {
        ImageVector v0 = WrapTextKt._wrapText;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.WrapText", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(5f, 7f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.lineTo(5f, 5f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.close();
        v12.moveTo(16.83f, 11f);
        v12.lineTo(5f, 11f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(12.13f);
        v12.curveToRelative(1f, 0f, 1.93f, 0.67f, 2.09f, 1.66f);
        v12.curveToRelative(0.21f, 1.25f, -0.76f, 2.34f, -1.97f, 2.34f);
        v12.lineTo(15f, 17f);
        v12.verticalLineToRelative(-0.79f);
        v12.curveToRelative(0f, -0.45f, -0.54f, -0.67f, -0.85f, -0.35f);
        v12.lineToRelative(-1.79f, 1.79f);
        v12.curveToRelative(-0.2f, 0.2f, -0.2f, 0.51f, 0f, 0.71f);
        v12.lineToRelative(1.79f, 1.79f);
        v12.curveToRelative(0.32f, 0.32f, 0.85f, 0.09f, 0.85f, -0.35f);
        v12.lineTo(15f, 19f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(2.34f, 0f, 4.21f, -2.01f, 3.98f, -4.39f);
        v12.curveToRelative(-0.2f, -2.08f, -2.06f, -3.61f, -4.15f, -3.61f);
        v12.close();
        v12.moveTo(9f, 17f);
        v12.lineTo(5f, 17f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WrapTextKt._wrapText = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Rounded.WrapText", replaceWith="<_subannotation>") public static void getWrapText$annotations(Rounded arg0) {
    }
}

