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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_callSplit", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CallSplit", "Landroidx/compose/material/icons/Icons$Outlined;", "getCallSplit$annotations", "(Landroidx/compose/material/icons/Icons$Outlined;)V", "getCallSplit", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CallSplitKt {
    private static ImageVector _callSplit;

    static {
    }

    public static final ImageVector getCallSplit(Outlined arg18) {
        ImageVector v0 = CallSplitKt._callSplit;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.CallSplit", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(14f, 4f);
        v0_1.lineToRelative(2.29f, 2.29f);
        v0_1.lineToRelative(-2.88f, 2.88f);
        v0_1.lineToRelative(1.42f, 1.42f);
        v0_1.lineToRelative(2.88f, -2.88f);
        v0_1.lineTo(20f, 10f);
        v0_1.lineTo(20f, 4f);
        v0_1.horizontalLineToRelative(-6f);
        v0_1.close();
        v0_1.moveTo(10f, 4f);
        v0_1.lineTo(4f, 4f);
        v0_1.verticalLineToRelative(6f);
        v0_1.lineToRelative(2.29f, -2.29f);
        v0_1.lineToRelative(4.71f, 4.7f);
        v0_1.lineTo(11f, 20f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.verticalLineToRelative(-8.41f);
        v0_1.lineToRelative(-5.29f, -5.3f);
        v0_1.lineTo(10f, 4f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CallSplitKt._callSplit = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Outlined.CallSplit", replaceWith="<_subannotation>") public static void getCallSplit$annotations(Outlined arg0) {
    }
}

