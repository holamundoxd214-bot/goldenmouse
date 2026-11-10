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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_callEnd", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CallEnd", "Landroidx/compose/material/icons/Icons$Outlined;", "getCallEnd", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CallEndKt {
    private static ImageVector _callEnd;

    static {
    }

    public static final ImageVector getCallEnd(Outlined arg19) {
        ImageVector v0 = CallEndKt._callEnd;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.CallEnd", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.59f, 10.52f);
        v12.curveToRelative(1.05f, 0.51f, 2.04f, 1.15f, 2.96f, 1.91f);
        v12.lineToRelative(-1.07f, 1.07f);
        v12.curveToRelative(-0.58f, -0.47f, -1.21f, -0.89f, -1.88f, -1.27f);
        v12.verticalLineToRelative(-1.71f);
        v12.moveToRelative(-13.2f, 0f);
        v12.verticalLineToRelative(1.7f);
        v12.curveToRelative(-0.65f, 0.37f, -1.28f, 0.79f, -1.87f, 1.27f);
        v12.lineToRelative(-1.07f, -1.07f);
        v12.curveToRelative(0.91f, -0.75f, 1.9f, -1.38f, 2.94f, -1.9f);
        v12.moveTo(12f, 7f);
        v12.curveTo(7.46f, 7f, 3.34f, 8.78f, 0.29f, 11.67f);
        v12.curveToRelative(-0.18f, 0.18f, -0.29f, 0.43f, -0.29f, 0.71f);
        v12.reflectiveCurveToRelative(0.11f, 0.53f, 0.29f, 0.7f);
        v12.lineToRelative(2.48f, 2.48f);
        v12.curveToRelative(0.18f, 0.18f, 0.43f, 0.29f, 0.71f, 0.29f);
        v12.curveToRelative(0.27f, 0f, 0.52f, -0.1f, 0.7f, -0.28f);
        v12.curveToRelative(0.79f, -0.73f, 1.68f, -1.36f, 2.66f, -1.85f);
        v12.curveToRelative(0.33f, -0.16f, 0.56f, -0.51f, 0.56f, -0.9f);
        v12.verticalLineToRelative(-3.1f);
        v12.curveTo(8.85f, 9.25f, 10.4f, 9f, 12f, 9f);
        v12.reflectiveCurveToRelative(3.15f, 0.25f, 4.59f, 0.73f);
        v12.verticalLineToRelative(3.1f);
        v12.curveToRelative(0f, 0.4f, 0.23f, 0.74f, 0.56f, 0.9f);
        v12.curveToRelative(0.98f, 0.49f, 1.88f, 1.11f, 2.67f, 1.85f);
        v12.curveToRelative(0.18f, 0.17f, 0.43f, 0.28f, 0.7f, 0.28f);
        v12.curveToRelative(0.28f, 0f, 0.53f, -0.11f, 0.71f, -0.29f);
        v12.lineToRelative(2.48f, -2.48f);
        v12.curveToRelative(0.18f, -0.18f, 0.29f, -0.43f, 0.29f, -0.71f);
        v12.reflectiveCurveToRelative(-0.11f, -0.53f, -0.29f, -0.71f);
        v12.curveTo(20.66f, 8.78f, 16.540001f, 7f, 12f, 7f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CallEndKt._callEnd = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

