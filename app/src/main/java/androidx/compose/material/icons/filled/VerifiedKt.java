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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_verified", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Verified", "Landroidx/compose/material/icons/Icons$Filled;", "getVerified", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VerifiedKt {
    private static ImageVector _verified;

    static {
    }

    public static final ImageVector getVerified(Filled arg18) {
        ImageVector v0 = VerifiedKt._verified;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Verified", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(23f, 12f);
        v0_1.lineToRelative(-2.44f, -2.79f);
        v0_1.lineToRelative(0.34f, -3.69f);
        v0_1.lineToRelative(-3.61f, -0.82f);
        v0_1.lineTo(15.4f, 1.5f);
        v0_1.lineTo(12f, 2.96f);
        v0_1.lineTo(8.6f, 1.5f);
        v0_1.lineTo(6.71f, 4.69f);
        v0_1.lineTo(3.1f, 5.5f);
        v0_1.lineTo(3.44f, 9.2f);
        v0_1.lineTo(1f, 12f);
        v0_1.lineToRelative(2.44f, 2.79f);
        v0_1.lineToRelative(-0.34f, 3.7f);
        v0_1.lineToRelative(3.61f, 0.82f);
        v0_1.lineTo(8.6f, 22.5f);
        v0_1.lineToRelative(3.4f, -1.47f);
        v0_1.lineToRelative(3.4f, 1.46f);
        v0_1.lineToRelative(1.89f, -3.19f);
        v0_1.lineToRelative(3.61f, -0.82f);
        v0_1.lineToRelative(-0.34f, -3.69f);
        v0_1.lineTo(23f, 12f);
        v0_1.close();
        v0_1.moveTo(10.09f, 16.719999f);
        v0_1.lineToRelative(-3.8f, -3.81f);
        v0_1.lineToRelative(1.48f, -1.48f);
        v0_1.lineToRelative(2.32f, 2.33f);
        v0_1.lineToRelative(5.85f, -5.87f);
        v0_1.lineToRelative(1.48f, 1.48f);
        v0_1.lineTo(10.09f, 16.719999f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VerifiedKt._verified = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

