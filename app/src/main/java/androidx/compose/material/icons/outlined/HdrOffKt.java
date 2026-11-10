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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_hdrOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HdrOff", "Landroidx/compose/material/icons/Icons$Outlined;", "getHdrOff", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HdrOffKt {
    private static ImageVector _hdrOff;

    static {
    }

    public static final ImageVector getHdrOff(Outlined arg19) {
        ImageVector v0 = HdrOffKt._hdrOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.HdrOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.5f, 15f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(1.1f);
        v12.lineToRelative(0.9f, 2f);
        v12.lineTo(21f, 15f);
        v12.lineToRelative(-0.9f, -2.1f);
        v12.curveToRelative(0.5f, -0.3f, 0.9f, -0.8f, 0.9f, -1.4f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(0f, -0.8f, -0.7f, -1.5f, -1.5f, -1.5f);
        v12.lineTo(16f, 9f);
        v12.verticalLineToRelative(4.86f);
        v12.lineTo(17.139999f, 15f);
        v12.horizontalLineToRelative(0.36f);
        v12.close();
        v12.moveTo(17.5f, 10.5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-1f);
        v12.close();
        v12.moveTo(13f, 10.5f);
        v12.verticalLineToRelative(0.36f);
        v12.lineToRelative(1.5f, 1.5f);
        v12.lineTo(14.5f, 10.5f);
        v12.curveToRelative(0f, -0.8f, -0.7f, -1.5f, -1.5f, -1.5f);
        v12.horizontalLineToRelative(-1.86f);
        v12.lineToRelative(1.5f, 1.5f);
        v12.lineTo(13f, 10.5f);
        v12.close();
        v12.moveTo(2.51f, 2.49f);
        v12.lineTo(1.45f, 3.55f);
        v12.lineTo(6.9f, 9f);
        v12.horizontalLineToRelative(-0.4f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-2f);
        v12.lineTo(4.5f, 9f);
        v12.lineTo(3f, 9f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(1.5f);
        v12.verticalLineToRelative(-2.5f);
        v12.horizontalLineToRelative(2f);
        v12.lineTo(6.5f, 15f);
        v12.lineTo(8f, 15f);
        v12.verticalLineToRelative(-4.9f);
        v12.lineToRelative(1.5f, 1.5f);
        v12.lineTo(9.5f, 15f);
        v12.horizontalLineToRelative(3.4f);
        v12.lineToRelative(7.6f, 7.6f);
        v12.lineToRelative(1.06f, -1.06f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HdrOffKt._hdrOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

