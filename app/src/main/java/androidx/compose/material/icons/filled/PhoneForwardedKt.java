package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_phoneForwarded", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PhoneForwarded", "Landroidx/compose/material/icons/Icons$Filled;", "getPhoneForwarded$annotations", "(Landroidx/compose/material/icons/Icons$Filled;)V", "getPhoneForwarded", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PhoneForwardedKt {
    private static ImageVector _phoneForwarded;

    static {
    }

    public static final ImageVector getPhoneForwarded(Filled arg19) {
        ImageVector v0 = PhoneForwardedKt._phoneForwarded;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.PhoneForwarded", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 11f);
        v12.lineToRelative(5f, -5f);
        v12.lineToRelative(-5f, -5f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(3f);
        v12.close();
        v12.moveTo(20f, 15.5f);
        v12.curveToRelative(-1.25f, 0f, -2.45f, -0.2f, -3.57f, -0.57f);
        v12.curveToRelative(-0.35f, -0.11f, -0.74f, -0.03f, -1.02f, 0.24f);
        v12.lineToRelative(-2.2f, 2.2f);
        v12.curveToRelative(-2.83f, -1.44f, -5.15f, -3.75f, -6.59f, -6.59f);
        v12.lineToRelative(2.2f, -2.21f);
        v12.curveToRelative(0.28f, -0.26f, 0.36f, -0.65f, 0.25f, -1f);
        v12.curveTo(8.7f, 6.45f, 8.5f, 5.25f, 8.5f, 4f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.lineTo(4f, 3f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.curveToRelative(0f, 9.39f, 7.61f, 17f, 17f, 17f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-3.5f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PhoneForwardedKt._phoneForwarded = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Filled.PhoneForwarded", replaceWith="<_subannotation>") public static void getPhoneForwarded$annotations(Filled arg0) {
    }
}

