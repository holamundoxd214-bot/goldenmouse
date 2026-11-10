package androidx.compose.material.icons.automirrored.rounded;

import androidx.compose.material.icons.Icons$AutoMirrored$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_callSplit", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CallSplit", "Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;", "getCallSplit", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CallSplitKt {
    private static ImageVector _callSplit;

    static {
    }

    public static final ImageVector getCallSplit(Rounded arg19) {
        ImageVector v0 = CallSplitKt._callSplit;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Rounded.CallSplit", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.85f, 4.85f);
        v12.lineToRelative(1.44f, 1.44f);
        v12.lineToRelative(-2.88f, 2.88f);
        v12.lineToRelative(1.42f, 1.42f);
        v12.lineToRelative(2.88f, -2.88f);
        v12.lineToRelative(1.44f, 1.44f);
        v12.curveToRelative(0.31f, 0.31f, 0.85f, 0.09f, 0.85f, -0.36f);
        v12.verticalLineTo(4.5f);
        v12.curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f);
        v12.horizontalLineToRelative(-4.29f);
        v12.curveToRelative(-0.45f, 0f, -0.67f, 0.54f, -0.36f, 0.85f);
        v12.close();
        v12.moveTo(8.79f, 4f);
        v12.horizontalLineTo(4.5f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f);
        v12.verticalLineToRelative(4.29f);
        v12.curveToRelative(0f, 0.45f, 0.54f, 0.67f, 0.85f, 0.35f);
        v12.lineTo(6.29f, 7.7f);
        v12.lineTo(11f, 12.4f);
        v12.verticalLineTo(19f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-7f);
        v12.curveToRelative(0f, -0.26f, -0.11f, -0.52f, -0.29f, -0.71f);
        v12.lineToRelative(-5f, -5.01f);
        v12.lineToRelative(1.44f, -1.44f);
        v12.curveToRelative(0.31f, -0.3f, 0.09f, -0.84f, -0.36f, -0.84f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CallSplitKt._callSplit = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

