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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_cabin", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Cabin", "Landroidx/compose/material/icons/Icons$Sharp;", "getCabin", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CabinKt {
    private static ImageVector _cabin;

    static {
    }

    public static final ImageVector getCabin(Sharp arg19) {
        ImageVector v0 = CabinKt._cabin;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Cabin", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10f, 1f);
        v12.curveToRelative(0f, 1.66f, -1.34f, 3f, -3f, 3f);
        v12.curveTo(6.45f, 4f, 6f, 4.45f, 6f, 5f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(0f, -1.66f, 1.34f, -3f, 3f, -3f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.horizontalLineTo(10f);
        v12.close();
        v12.moveTo(12f, 3f);
        v12.lineTo(6f, 7.58f);
        v12.verticalLineTo(6f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(3.11f);
        v12.lineTo(1f, 11.4f);
        v12.lineToRelative(1.21f, 1.59f);
        v12.lineTo(4f, 11.62f);
        v12.verticalLineTo(21f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineToRelative(-9.38f);
        v12.lineToRelative(1.79f, 1.36f);
        v12.lineTo(23f, 11.4f);
        v12.lineTo(12f, 3f);
        v12.close();
        v12.moveTo(13.94f, 7f);
        v12.horizontalLineToRelative(-3.89f);
        v12.lineTo(12f, 5.52f);
        v12.lineTo(13.94f, 7f);
        v12.close();
        v12.moveTo(7.44f, 9f);
        v12.horizontalLineToRelative(9.12f);
        v12.lineTo(18f, 10.1f);
        v12.verticalLineTo(11f);
        v12.horizontalLineTo(6f);
        v12.verticalLineToRelative(-0.9f);
        v12.lineTo(7.44f, 9f);
        v12.close();
        v12.moveTo(18f, 13f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(6f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(18f);
        v12.close();
        v12.moveTo(6f, 19f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CabinKt._cabin = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

