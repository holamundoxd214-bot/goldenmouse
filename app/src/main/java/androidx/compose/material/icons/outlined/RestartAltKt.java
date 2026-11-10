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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_restartAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RestartAlt", "Landroidx/compose/material/icons/Icons$Outlined;", "getRestartAlt", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RestartAltKt {
    private static ImageVector _restartAlt;

    static {
    }

    public static final ImageVector getRestartAlt(Outlined arg19) {
        ImageVector v0 = RestartAltKt._restartAlt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.RestartAlt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6f, 13f);
        v12.curveToRelative(0f, -1.65f, 0.67f, -3.15f, 1.76f, -4.24f);
        v12.lineTo(6.34f, 7.34f);
        v12.curveTo(4.9f, 8.79f, 4f, 10.79f, 4f, 13f);
        v12.curveToRelative(0f, 4.08f, 3.05f, 7.44f, 7f, 7.93f);
        v12.verticalLineToRelative(-2.02f);
        v12.curveTo(8.17f, 18.43f, 6f, 15.97f, 6f, 13f);
        v12.close();
        v12.moveTo(20f, 13f);
        v12.curveToRelative(0f, -4.42f, -3.58f, -8f, -8f, -8f);
        v12.curveToRelative(-0.06f, 0f, -0.12f, 0.01f, -0.18f, 0.01f);
        v12.lineToRelative(1.09f, -1.09f);
        v12.lineTo(11.5f, 2.5f);
        v12.lineTo(8f, 6f);
        v12.lineToRelative(3.5f, 3.5f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(-1.08f, -1.08f);
        v12.curveTo(11.89f, 7.01f, 11.95f, 7f, 12f, 7f);
        v12.curveToRelative(3.31f, 0f, 6f, 2.69f, 6f, 6f);
        v12.curveToRelative(0f, 2.97f, -2.17f, 5.43f, -5f, 5.91f);
        v12.verticalLineToRelative(2.02f);
        v12.curveTo(16.950001f, 20.440001f, 20f, 17.08f, 20f, 13f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RestartAltKt._restartAlt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

