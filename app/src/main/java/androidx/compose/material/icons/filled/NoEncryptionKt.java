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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noEncryption", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoEncryption", "Landroidx/compose/material/icons/Icons$Filled;", "getNoEncryption", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoEncryptionKt {
    private static ImageVector _noEncryption;

    static {
    }

    public static final ImageVector getNoEncryption(Filled arg19) {
        ImageVector v0 = NoEncryptionKt._noEncryption;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.NoEncryption", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 21.780001f);
        v12.lineTo(4.22f, 5f);
        v12.lineTo(3f, 6.22f);
        v12.lineToRelative(2.04f, 2.04f);
        v12.curveTo(4.42f, 8.6f, 4f, 9.25f, 4f, 10f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(0.23f, 0f, 0.45f, -0.05f, 0.66f, -0.12f);
        v12.lineTo(19.780001f, 23f);
        v12.lineTo(21f, 21.780001f);
        v12.close();
        v12.moveTo(8.9f, 6f);
        v12.curveToRelative(0f, -1.71f, 1.39f, -3.1f, 3.1f, -3.1f);
        v12.reflectiveCurveToRelative(3.1f, 1.39f, 3.1f, 3.1f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(9.66f);
        v12.lineTo(20f, 18.34f);
        v12.verticalLineTo(10f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -2.76f, -2.24f, -5f, -5f, -5f);
        v12.curveToRelative(-2.56f, 0f, -4.64f, 1.93f, -4.94f, 4.4f);
        v12.lineTo(8.9f, 7.24f);
        v12.verticalLineTo(6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoEncryptionKt._noEncryption = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

