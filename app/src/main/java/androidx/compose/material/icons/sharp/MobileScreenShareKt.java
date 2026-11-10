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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_mobileScreenShare", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MobileScreenShare", "Landroidx/compose/material/icons/Icons$Sharp;", "getMobileScreenShare$annotations", "(Landroidx/compose/material/icons/Icons$Sharp;)V", "getMobileScreenShare", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MobileScreenShareKt {
    private static ImageVector _mobileScreenShare;

    static {
    }

    public static final ImageVector getMobileScreenShare(Sharp arg19) {
        ImageVector v0 = MobileScreenShareKt._mobileScreenShare;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.MobileScreenShare", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(5.01f, 1f);
        v12.verticalLineToRelative(22f);
        v12.lineTo(19f, 23f);
        v12.lineTo(19f, 1f);
        v12.lineTo(5.01f, 1f);
        v12.close();
        v12.moveTo(17f, 19f);
        v12.lineTo(7f, 19f);
        v12.lineTo(7f, 5f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(14f);
        v12.close();
        v12.moveTo(12.8f, 13.24f);
        v12.verticalLineToRelative(1.75f);
        v12.lineTo(16f, 12f);
        v12.lineToRelative(-3.2f, -2.98f);
        v12.verticalLineToRelative(1.7f);
        v12.curveToRelative(-3.11f, 0.43f, -4.35f, 2.56f, -4.8f, 4.7f);
        v12.curveToRelative(1.11f, -1.5f, 2.58f, -2.18f, 4.8f, -2.18f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MobileScreenShareKt._mobileScreenShare = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Sharp.MobileScreenShare", replaceWith="<_subannotation>") public static void getMobileScreenShare$annotations(Sharp arg0) {
    }
}

