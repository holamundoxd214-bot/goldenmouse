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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_missedVideoCall", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MissedVideoCall", "Landroidx/compose/material/icons/Icons$Sharp;", "getMissedVideoCall$annotations", "(Landroidx/compose/material/icons/Icons$Sharp;)V", "getMissedVideoCall", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MissedVideoCallKt {
    private static ImageVector _missedVideoCall;

    static {
    }

    public static final ImageVector getMissedVideoCall(Sharp arg18) {
        ImageVector v0 = MissedVideoCallKt._missedVideoCall;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.MissedVideoCall", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(17f, 10.5f);
        v0_1.verticalLineTo(6f);
        v0_1.horizontalLineTo(3f);
        v0_1.verticalLineToRelative(12f);
        v0_1.horizontalLineToRelative(14f);
        v0_1.verticalLineToRelative(-4.5f);
        v0_1.lineToRelative(4f, 4f);
        v0_1.verticalLineToRelative(-11f);
        v0_1.lineToRelative(-4f, 4f);
        v0_1.close();
        v0_1.moveTo(10f, 15f);
        v0_1.lineToRelative(-3.89f, -3.89f);
        v0_1.verticalLineToRelative(2.55f);
        v0_1.horizontalLineTo(5f);
        v0_1.verticalLineTo(9.22f);
        v0_1.horizontalLineToRelative(4.44f);
        v0_1.verticalLineToRelative(1.11f);
        v0_1.horizontalLineTo(6.89f);
        v0_1.lineToRelative(3.11f, 3.1f);
        v0_1.lineToRelative(4.22f, -4.22f);
        v0_1.lineToRelative(0.78f, 0.79f);
        v0_1.lineToRelative(-5f, 5f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MissedVideoCallKt._missedVideoCall = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Sharp.MissedVideoCall", replaceWith="<_subannotation>") public static void getMissedVideoCall$annotations(Sharp arg0) {
    }
}

