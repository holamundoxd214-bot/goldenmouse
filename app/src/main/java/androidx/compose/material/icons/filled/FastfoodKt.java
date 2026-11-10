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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_fastfood", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Fastfood", "Landroidx/compose/material/icons/Icons$Filled;", "getFastfood", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FastfoodKt {
    private static ImageVector _fastfood;

    static {
    }

    public static final ImageVector getFastfood(Filled arg19) {
        ImageVector v0 = FastfoodKt._fastfood;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Fastfood", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.059999f, 22.99f);
        v12.horizontalLineToRelative(1.66f);
        v12.curveToRelative(0.84f, 0f, 1.53f, -0.64f, 1.63f, -1.46f);
        v12.lineTo(23f, 5.05f);
        v12.horizontalLineToRelative(-5f);
        v12.lineTo(18f, 1f);
        v12.horizontalLineToRelative(-1.97f);
        v12.verticalLineToRelative(4.05f);
        v12.horizontalLineToRelative(-4.97f);
        v12.lineToRelative(0.3f, 2.34f);
        v12.curveToRelative(1.71f, 0.47f, 3.31f, 1.32f, 4.27f, 2.26f);
        v12.curveToRelative(1.44f, 1.42f, 2.43f, 2.89f, 2.43f, 5.29f);
        v12.verticalLineToRelative(8.05f);
        v12.close();
        v12.moveTo(1f, 21.99f);
        v12.lineTo(1f, 21f);
        v12.horizontalLineToRelative(15.03f);
        v12.verticalLineToRelative(0.99f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1.01f, 1f);
        v12.lineTo(2.01f, 22.99f);
        v12.curveToRelative(-0.56f, 0f, -1.01f, -0.45f, -1.01f, -1f);
        v12.close();
        v12.moveTo(16.030001f, 14.99f);
        v12.curveToRelative(0f, -8f, -15.03f, -8f, -15.03f, 0f);
        v12.horizontalLineToRelative(15.03f);
        v12.close();
        v12.moveTo(1.02f, 17f);
        v12.horizontalLineToRelative(15f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-15f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FastfoodKt._fastfood = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

