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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_volcano", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Volcano", "Landroidx/compose/material/icons/Icons$Outlined;", "getVolcano", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VolcanoKt {
    private static ImageVector _volcano;

    static {
    }

    public static final ImageVector getVolcano(Outlined arg18) {
        ImageVector v0 = VolcanoKt._volcano;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Volcano", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(18f, 8f);
        v0_1.horizontalLineToRelative(-7f);
        v0_1.lineToRelative(-2f, 5f);
        v0_1.horizontalLineTo(6f);
        v0_1.lineToRelative(-4f, 9f);
        v0_1.horizontalLineToRelative(20f);
        v0_1.lineTo(18f, 8f);
        v0_1.close();
        v0_1.moveTo(7.3f, 15f);
        v0_1.horizontalLineTo(9f);
        v0_1.horizontalLineToRelative(1.35f);
        v0_1.lineToRelative(0.5f, -1.26f);
        v0_1.lineToRelative(1.5f, -3.74f);
        v0_1.horizontalLineToRelative(4.14f);
        v0_1.lineToRelative(2.86f, 10f);
        v0_1.horizontalLineTo(5.08f);
        v0_1.lineTo(7.3f, 15f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(13f, 1f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.verticalLineToRelative(4f);
        v0_1.horizontalLineToRelative(-2f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(16.121f, 5.468f);
        v0_1.lineToRelative(2.828f, -2.828f);
        v0_1.lineToRelative(1.414f, 1.414f);
        v0_1.lineToRelative(-2.828f, 2.828f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(7.64f, 4.05f);
        v0_1.lineToRelative(1.414f, -1.414f);
        v0_1.lineToRelative(2.828f, 2.828f);
        v0_1.lineToRelative(-1.414f, 1.414f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VolcanoKt._volcano = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

