package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_fitnessCenter", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FitnessCenter", "Landroidx/compose/material/icons/Icons$Outlined;", "getFitnessCenter", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FitnessCenterKt {
    private static ImageVector _fitnessCenter;

    static {
    }

    public static final ImageVector getFitnessCenter(Outlined arg18) {
        ImageVector v0 = FitnessCenterKt._fitnessCenter;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.FitnessCenter", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(20.57f, 14.86f);
        v0_1.lineTo(22f, 13.43f);
        v0_1.lineTo(20.57f, 12f);
        v0_1.lineTo(17f, 15.57f);
        v0_1.lineTo(8.43f, 7f);
        v0_1.lineTo(12f, 3.43f);
        v0_1.lineTo(10.57f, 2f);
        v0_1.lineTo(9.14f, 3.43f);
        v0_1.lineTo(7.71f, 2f);
        v0_1.lineTo(5.57f, 4.14f);
        v0_1.lineTo(4.14f, 2.71f);
        v0_1.lineTo(2.71f, 4.14f);
        v0_1.lineToRelative(1.43f, 1.43f);
        v0_1.lineTo(2f, 7.71f);
        v0_1.lineToRelative(1.43f, 1.43f);
        v0_1.lineTo(2f, 10.57f);
        v0_1.lineTo(3.43f, 12f);
        v0_1.lineTo(7f, 8.43f);
        v0_1.lineTo(15.57f, 17f);
        v0_1.lineTo(12f, 20.57f);
        v0_1.lineTo(13.43f, 22f);
        v0_1.lineToRelative(1.43f, -1.43f);
        v0_1.lineTo(16.290001f, 22f);
        v0_1.lineToRelative(2.14f, -2.14f);
        v0_1.lineToRelative(1.43f, 1.43f);
        v0_1.lineToRelative(1.43f, -1.43f);
        v0_1.lineToRelative(-1.43f, -1.43f);
        v0_1.lineTo(22f, 16.290001f);
        v0_1.lineToRelative(-1.43f, -1.43f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FitnessCenterKt._fitnessCenter = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

