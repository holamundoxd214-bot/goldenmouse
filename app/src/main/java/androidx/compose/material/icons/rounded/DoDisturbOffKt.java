package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_doDisturbOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DoDisturbOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getDoDisturbOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DoDisturbOffKt {
    private static ImageVector _doDisturbOff;

    static {
    }

    public static final ImageVector getDoDisturbOff(Rounded arg19) {
        ImageVector v0 = DoDisturbOffKt._doDisturbOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.DoDisturbOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17f, 11f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-0.88f);
        v12.lineToRelative(4.33f, 4.33f);
        v12.curveTo(21.43f, 15.79f, 22f, 13.96f, 22f, 12f);
        v12.curveToRelative(0f, -5.52f, -4.48f, -10f, -10f, -10f);
        v12.curveToRelative(-1.96f, 0f, -3.79f, 0.57f, -5.33f, 1.55f);
        v12.lineTo(14.12f, 11f);
        v12.lineTo(17f, 11f);
        v12.close();
        v12.moveTo(21.17f, 20.879999f);
        v12.lineTo(3.12f, 2.83f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(2.07f, 2.07f);
        v12.curveTo(2.66f, 7.93f, 2f, 9.89f, 2f, 12f);
        v12.curveToRelative(0f, 5.52f, 4.48f, 10f, 10f, 10f);
        v12.curveToRelative(2.11f, 0f, 4.07f, -0.66f, 5.68f, -1.78f);
        v12.lineToRelative(2.07f, 2.07f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.4f, -0.39f, 0.4f, -1.02f, 0.01f, -1.41f);
        v12.close();
        v12.moveTo(7f, 13f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(1.46f);
        v12.lineToRelative(2f, 2f);
        v12.lineTo(7f, 13f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DoDisturbOffKt._doDisturbOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

