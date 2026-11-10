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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_verified", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Verified", "Landroidx/compose/material/icons/Icons$Rounded;", "getVerified", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VerifiedKt {
    private static ImageVector _verified;

    static {
    }

    public static final ImageVector getVerified(Rounded arg19) {
        ImageVector v0 = VerifiedKt._verified;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Verified", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(23f, 12f);
        v12.lineToRelative(-2.44f, -2.79f);
        v12.lineToRelative(0.34f, -3.69f);
        v12.lineToRelative(-3.61f, -0.82f);
        v12.lineTo(15.4f, 1.5f);
        v12.lineTo(12f, 2.96f);
        v12.lineTo(8.6f, 1.5f);
        v12.lineTo(6.71f, 4.69f);
        v12.lineTo(3.1f, 5.5f);
        v12.lineTo(3.44f, 9.2f);
        v12.lineTo(1f, 12f);
        v12.lineToRelative(2.44f, 2.79f);
        v12.lineToRelative(-0.34f, 3.7f);
        v12.lineToRelative(3.61f, 0.82f);
        v12.lineTo(8.6f, 22.5f);
        v12.lineToRelative(3.4f, -1.47f);
        v12.lineToRelative(3.4f, 1.46f);
        v12.lineToRelative(1.89f, -3.19f);
        v12.lineToRelative(3.61f, -0.82f);
        v12.lineToRelative(-0.34f, -3.69f);
        v12.lineTo(23f, 12f);
        v12.close();
        v12.moveTo(9.38f, 16.01f);
        v12.lineTo(7f, 13.61f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(0.07f, -0.07f);
        v12.curveToRelative(0.39f, -0.39f, 1.03f, -0.39f, 1.42f, 0f);
        v12.lineToRelative(1.61f, 1.62f);
        v12.lineToRelative(5.15f, -5.16f);
        v12.curveToRelative(0.39f, -0.39f, 1.03f, -0.39f, 1.42f, 0f);
        v12.lineToRelative(0.07f, 0.07f);
        v12.curveToRelative(0.39f, 0.39f, 0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(-5.92f, 5.94f);
        v12.curveTo(10.41f, 16.4f, 9.78f, 16.4f, 9.38f, 16.01f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VerifiedKt._verified = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

