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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_callEnd", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CallEnd", "Landroidx/compose/material/icons/Icons$Filled;", "getCallEnd", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CallEndKt {
    private static ImageVector _callEnd;

    static {
    }

    public static final ImageVector getCallEnd(Filled arg19) {
        ImageVector v0 = CallEndKt._callEnd;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.CallEnd", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 9f);
        v12.curveToRelative(-1.6f, 0f, -3.15f, 0.25f, -4.6f, 0.72f);
        v12.verticalLineToRelative(3.1f);
        v12.curveToRelative(0f, 0.39f, -0.23f, 0.74f, -0.56f, 0.9f);
        v12.curveToRelative(-0.98f, 0.49f, -1.87f, 1.12f, -2.66f, 1.85f);
        v12.curveToRelative(-0.18f, 0.18f, -0.43f, 0.28f, -0.7f, 0.28f);
        v12.curveToRelative(-0.28f, 0f, -0.53f, -0.11f, -0.71f, -0.29f);
        v12.lineTo(0.29f, 13.08f);
        v12.curveToRelative(-0.18f, -0.17f, -0.29f, -0.42f, -0.29f, -0.7f);
        v12.curveToRelative(0f, -0.28f, 0.11f, -0.53f, 0.29f, -0.71f);
        v12.curveTo(3.34f, 8.78f, 7.46f, 7f, 12f, 7f);
        v12.reflectiveCurveToRelative(8.66f, 1.78f, 11.71f, 4.67f);
        v12.curveToRelative(0.18f, 0.18f, 0.29f, 0.43f, 0.29f, 0.71f);
        v12.curveToRelative(0f, 0.28f, -0.11f, 0.53f, -0.29f, 0.71f);
        v12.lineToRelative(-2.48f, 2.48f);
        v12.curveToRelative(-0.18f, 0.18f, -0.43f, 0.29f, -0.71f, 0.29f);
        v12.curveToRelative(-0.27f, 0f, -0.52f, -0.11f, -0.7f, -0.28f);
        v12.curveToRelative(-0.79f, -0.74f, -1.69f, -1.36f, -2.67f, -1.85f);
        v12.curveToRelative(-0.33f, -0.16f, -0.56f, -0.5f, -0.56f, -0.9f);
        v12.verticalLineToRelative(-3.1f);
        v12.curveTo(15.15f, 9.25f, 13.6f, 9f, 12f, 9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CallEndKt._callEnd = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

