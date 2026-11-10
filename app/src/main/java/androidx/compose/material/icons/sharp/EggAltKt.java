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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_eggAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "EggAlt", "Landroidx/compose/material/icons/Icons$Sharp;", "getEggAlt", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EggAltKt {
    private static ImageVector _eggAlt;

    static {
    }

    public static final ImageVector getEggAlt(Sharp arg19) {
        ImageVector v0 = EggAltKt._eggAlt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.EggAlt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 9f);
        v12.curveTo(17f, 7f, 15.99f, 2f, 9.97f, 2f);
        v12.curveTo(4.95f, 2f, 1.94f, 6f, 2f, 11.52f);
        v12.curveTo(2.06f, 17.040001f, 6.96f, 19f, 9.97f, 19f);
        v12.curveToRelative(2.01f, 0f, 2.01f, 3f, 6.02f, 3f);
        v12.curveTo(19f, 22f, 22f, 19f, 22f, 15.02f);
        v12.curveTo(22f, 12f, 21.01f, 11f, 19f, 9f);
        v12.close();
        v12.moveTo(12f, 15.5f);
        v12.curveToRelative(-1.93f, 0f, -3.5f, -1.57f, -3.5f, -3.5f);
        v12.reflectiveCurveToRelative(1.57f, -3.5f, 3.5f, -3.5f);
        v12.reflectiveCurveToRelative(3.5f, 1.57f, 3.5f, 3.5f);
        v12.reflectiveCurveTo(13.93f, 15.5f, 12f, 15.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EggAltKt._eggAlt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

