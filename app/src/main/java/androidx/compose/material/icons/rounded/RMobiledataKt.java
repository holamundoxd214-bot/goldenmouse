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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_rMobiledata", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RMobiledata", "Landroidx/compose/material/icons/Icons$Rounded;", "getRMobiledata", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RMobiledataKt {
    private static ImageVector _rMobiledata;

    static {
    }

    public static final ImageVector getRMobiledata(Rounded arg19) {
        ImageVector v0 = RMobiledataKt._rMobiledata;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.RMobiledata", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7.8f, 7.2f);
        v12.lineToRelative(0.65f, 1.52f);
        v12.curveTo(8.71f, 9.33f, 8.27f, 10f, 7.61f, 10f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.37f, 0f, -0.7f, -0.22f, -0.85f, -0.56f);
        v12.lineTo(5.87f, 7.33f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(1.75f);
        v12.curveTo(4f, 9.59f, 3.59f, 10f, 3.08f, 10f);
        v12.horizontalLineTo(2.92f);
        v12.curveTo(2.41f, 10f, 2f, 9.59f, 2f, 9.08f);
        v12.verticalLineTo(3f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.verticalLineToRelative(1.33f);
        v12.curveTo(9f, 6.13f, 8.47f, 6.87f, 7.8f, 7.2f);
        v12.close();
        v12.moveTo(7f, 4f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(1.33f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineTo(4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RMobiledataKt._rMobiledata = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

