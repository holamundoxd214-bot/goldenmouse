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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_takeoutDining", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TakeoutDining", "Landroidx/compose/material/icons/Icons$Rounded;", "getTakeoutDining", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TakeoutDiningKt {
    private static ImageVector _takeoutDining;

    static {
    }

    public static final ImageVector getTakeoutDining(Rounded arg19) {
        ImageVector v0 = TakeoutDiningKt._takeoutDining;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.TakeoutDining", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.290001f, 6.75f);
        v12.curveToRelative(-0.39f, -0.39f, -1.01f, -0.39f, -1.4f, 0f);
        v12.lineTo(19f, 7.63f);
        v12.lineToRelative(0.03f, -0.56f);
        v12.lineToRelative(-3.46f, -3.48f);
        v12.curveTo(15.19f, 3.21f, 14.68f, 3f, 14.15f, 3f);
        v12.horizontalLineToRelative(-4.3f);
        v12.curveTo(9.32f, 3f, 8.81f, 3.21f, 8.43f, 3.59f);
        v12.lineTo(4.97f, 7.07f);
        v12.lineTo(5f, 7.57f);
        v12.lineTo(4.11f, 6.7f);
        v12.curveTo(3.72f, 6.32f, 3.1f, 6.32f, 2.72f, 6.71f);
        v12.lineTo(2.7f, 6.73f);
        v12.curveTo(2.32f, 7.12f, 2.32f, 7.75f, 2.72f, 8.13f);
        v12.lineTo(4.66f, 10f);
        v12.horizontalLineToRelative(14.69f);
        v12.lineToRelative(1.92f, -1.84f);
        v12.curveTo(21.67f, 7.78f, 21.68f, 7.14f, 21.290001f, 6.75f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(5.79f, 18.15f);
        v12.curveTo(5.87f, 19.190001f, 6.74f, 20f, 7.79f, 20f);
        v12.horizontalLineToRelative(8.43f);
        v12.curveToRelative(1.05f, 0f, 1.92f, -0.81f, 1.99f, -1.85f);
        v12.lineToRelative(0.49f, -6.6f);
        v12.horizontalLineTo(5.3f);
        v12.lineTo(5.79f, 18.15f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TakeoutDiningKt._takeoutDining = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

