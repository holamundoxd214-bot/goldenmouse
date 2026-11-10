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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noEncryptionGmailerrorred", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoEncryptionGmailerrorred", "Landroidx/compose/material/icons/Icons$Filled;", "getNoEncryptionGmailerrorred", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoEncryptionGmailerrorredKt {
    private static ImageVector _noEncryptionGmailerrorred;

    static {
    }

    public static final ImageVector getNoEncryptionGmailerrorred(Filled arg19) {
        ImageVector v0 = NoEncryptionGmailerrorredKt._noEncryptionGmailerrorred;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.NoEncryptionGmailerrorred", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8.9f, 6f);
        v12.curveToRelative(0f, -1.71f, 1.39f, -3.1f, 3.1f, -3.1f);
        v12.reflectiveCurveToRelative(3.1f, 1.39f, 3.1f, 3.1f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-4.27f);
        v12.lineTo(20f, 17.17f);
        v12.verticalLineTo(10f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -2.76f, -2.24f, -5f, -5f, -5f);
        v12.curveTo(9.79f, 1f, 7.93f, 2.45f, 7.27f, 4.44f);
        v12.lineTo(8.9f, 6.07f);
        v12.verticalLineTo(6f);
        v12.close();
        v12.moveTo(2.1f, 2.1f);
        v12.lineTo(0.69f, 3.51f);
        v12.lineTo(5.3f, 8.13f);
        v12.curveTo(4.55f, 8.42f, 4f, 9.15f, 4f, 10f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(0.34f, 0f, 0.65f, -0.09f, 0.93f, -0.24f);
        v12.lineToRelative(1.56f, 1.56f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(2.1f, 2.1f);
        v12.close();
        v12.moveTo(12f, 17f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.curveToRelative(0f, -0.59f, 0.27f, -1.12f, 0.68f, -1.49f);
        v12.lineToRelative(2.81f, 2.81f);
        v12.curveTo(13.12f, 16.73f, 12.59f, 17f, 12f, 17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoEncryptionGmailerrorredKt._noEncryptionGmailerrorred = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

