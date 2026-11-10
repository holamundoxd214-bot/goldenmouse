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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noCrash", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoCrash", "Landroidx/compose/material/icons/Icons$Sharp;", "getNoCrash", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoCrashKt {
    private static ImageVector _noCrash;

    static {
    }

    public static final ImageVector getNoCrash(Sharp arg19) {
        ImageVector v0 = NoCrashKt._noCrash;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.NoCrash", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.57f, 8f);
        v12.horizontalLineTo(5.43f);
        v12.lineTo(3f, 15f);
        v12.verticalLineToRelative(9f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(-9f);
        v12.lineTo(18.57f, 8f);
        v12.close();
        v12.moveTo(6.85f, 10f);
        v12.horizontalLineToRelative(10.29f);
        v12.lineToRelative(1.04f, 3f);
        v12.horizontalLineTo(5.81f);
        v12.lineTo(6.85f, 10f);
        v12.close();
        v12.moveTo(6f, 17.5f);
        v12.curveTo(6f, 16.67f, 6.67f, 16f, 7.5f, 16f);
        v12.reflectiveCurveTo(9f, 16.67f, 9f, 17.5f);
        v12.reflectiveCurveTo(8.33f, 19f, 7.5f, 19f);
        v12.reflectiveCurveTo(6f, 18.33f, 6f, 17.5f);
        v12.close();
        v12.moveTo(15f, 17.5f);
        v12.curveToRelative(0f, -0.83f, 0.67f, -1.5f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(17.33f, 19f, 16.5f, 19f);
        v12.reflectiveCurveTo(15f, 18.33f, 15f, 17.5f);
        v12.close();
        v12.moveTo(12f, 6.36f);
        v12.lineTo(9.17f, 3.54f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(12f, 3.54f);
        v12.lineTo(15.54f, 0f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineTo(12f, 6.36f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoCrashKt._noCrash = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

