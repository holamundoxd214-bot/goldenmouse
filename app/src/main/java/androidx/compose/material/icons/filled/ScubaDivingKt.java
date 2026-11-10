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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_scubaDiving", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ScubaDiving", "Landroidx/compose/material/icons/Icons$Filled;", "getScubaDiving", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ScubaDivingKt {
    private static ImageVector _scubaDiving;

    static {
    }

    public static final ImageVector getScubaDiving(Filled arg19) {
        ImageVector v0 = ScubaDivingKt._scubaDiving;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.ScubaDiving", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(1f, 13f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.reflectiveCurveToRelative(-0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveTo(1f, 14.1f, 1f, 13f);
        v12.close();
        v12.moveTo(8.89f, 10.11f);
        v12.lineToRelative(4.53f, -1.21f);
        v12.lineTo(12.64f, 6f);
        v12.lineTo(8.11f, 7.21f);
        v12.curveToRelative(-0.8f, 0.21f, -1.28f, 1.04f, -1.06f, 1.84f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(7.27f, 9.85f, 8.09f, 10.33f, 8.89f, 10.11f);
        v12.close();
        v12.moveTo(20.5f, 5.9f);
        v12.lineTo(23f, 3f);
        v12.lineToRelative(-1f, -1f);
        v12.lineToRelative(-3f, 3f);
        v12.lineToRelative(-2f, 4f);
        v12.lineToRelative(-9.48f, 2.87f);
        v12.curveToRelative(-0.82f, 0.2f, -1.39f, 0.89f, -1.5f, 1.68f);
        v12.lineTo(5.24f, 18f);
        v12.lineTo(2.4f, 21.799999f);
        v12.lineTo(4f, 23f);
        v12.lineToRelative(3f, -4f);
        v12.lineToRelative(1.14f, -3.14f);
        v12.lineTo(14f, 14f);
        v12.lineToRelative(5f, -3.5f);
        v12.lineTo(20.5f, 5.9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ScubaDivingKt._scubaDiving = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

