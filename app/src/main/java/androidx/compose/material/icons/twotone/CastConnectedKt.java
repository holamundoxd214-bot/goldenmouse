package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_castConnected", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CastConnected", "Landroidx/compose/material/icons/Icons$TwoTone;", "getCastConnected", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CastConnectedKt {
    private static ImageVector _castConnected;

    static {
    }

    public static final ImageVector getCastConnected(TwoTone arg19) {
        ImageVector v0 = CastConnectedKt._castConnected;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.CastConnected", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17f, 9f);
        v12.horizontalLineTo(5.95f);
        v12.curveToRelative(2.83f, 1.17f, 5.15f, 3.3f, 6.56f, 6f);
        v12.horizontalLineTo(17f);
        v12.verticalLineTo(9f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(1f, 18f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0f, -1.66f, -1.34f, -3f, -3f, -3f);
        v12.close();
        v12.moveTo(1f, 14f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(2.76f, 0f, 5f, 2.24f, 5f, 5f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0f, -3.87f, -3.13f, -7f, -7f, -7f);
        v12.close();
        v12.moveTo(1f, 10f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(4.97f, 0f, 9f, 4.03f, 9f, 9f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0f, -6.08f, -4.93f, -11f, -11f, -11f);
        v12.close();
        v12.moveTo(21f, 3f);
        v12.lineTo(3f, 3f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(2f);
        v12.lineTo(3f, 5f);
        v12.horizontalLineToRelative(18f);
        v12.verticalLineToRelative(14f);
        v12.horizontalLineToRelative(-7f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(7f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(23f, 5f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(5f, 7f);
        v12.verticalLineToRelative(1.63f);
        v12.curveToRelative(0.32f, 0.1f, 0.63f, 0.24f, 0.95f, 0.37f);
        v12.lineTo(17f, 9f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(-4.49f);
        v12.curveToRelative(0.15f, 0.29f, 0.29f, 0.58f, 0.42f, 0.88f);
        v12.curveToRelative(0.16f, 0.36f, 0.31f, 0.74f, 0.44f, 1.12f);
        v12.lineTo(19f, 17f);
        v12.lineTo(19f, 7f);
        v12.lineTo(5f, 7f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CastConnectedKt._castConnected = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

