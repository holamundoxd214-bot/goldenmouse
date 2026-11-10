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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_callMissed", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CallMissed", "Landroidx/compose/material/icons/Icons$Sharp;", "getCallMissed$annotations", "(Landroidx/compose/material/icons/Icons$Sharp;)V", "getCallMissed", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CallMissedKt {
    private static ImageVector _callMissed;

    static {
    }

    public static final ImageVector getCallMissed(Sharp arg18) {
        ImageVector v0 = CallMissedKt._callMissed;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.CallMissed", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(19.59f, 7f);
        v0_1.lineTo(12f, 14.59f);
        v0_1.lineTo(6.41f, 9f);
        v0_1.horizontalLineTo(11f);
        v0_1.verticalLineTo(7f);
        v0_1.horizontalLineTo(3f);
        v0_1.verticalLineToRelative(8f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.verticalLineToRelative(-4.59f);
        v0_1.lineToRelative(7f, 7f);
        v0_1.lineToRelative(9f, -9f);
        v0_1.lineTo(19.59f, 7f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CallMissedKt._callMissed = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Sharp.CallMissed", replaceWith="<_subannotation>") public static void getCallMissed$annotations(Sharp arg0) {
    }
}

