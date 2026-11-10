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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_construction", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Construction", "Landroidx/compose/material/icons/Icons$Sharp;", "getConstruction", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ConstructionKt {
    private static ImageVector _construction;

    static {
    }

    public static final ImageVector getConstruction(Sharp arg19) {
        ImageVector v0 = ConstructionKt._construction;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Construction", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(13.783f, 15.172f);
        v0_1.lineToRelative(2.121f, -2.121f);
        v0_1.lineToRelative(5.996f, 5.996f);
        v0_1.lineToRelative(-2.121f, 2.121f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.5f, 10f);
        v12.curveToRelative(1.93f, 0f, 3.5f, -1.57f, 3.5f, -3.5f);
        v12.curveToRelative(0f, -0.58f, -0.16f, -1.12f, -0.41f, -1.6f);
        v12.lineToRelative(-2.7f, 2.7f);
        v12.lineTo(16.4f, 6.11f);
        v12.lineToRelative(2.7f, -2.7f);
        v12.curveTo(18.620001f, 3.16f, 18.08f, 3f, 17.5f, 3f);
        v12.curveTo(15.57f, 3f, 14f, 4.57f, 14f, 6.5f);
        v12.curveToRelative(0f, 0.41f, 0.08f, 0.8f, 0.21f, 1.16f);
        v12.lineToRelative(-1.85f, 1.85f);
        v12.lineToRelative(-1.78f, -1.78f);
        v12.lineToRelative(0.71f, -0.71f);
        v12.lineTo(9.88f, 5.61f);
        v12.lineTo(12f, 3.49f);
        v12.curveToRelative(-1.17f, -1.17f, -3.07f, -1.17f, -4.24f, 0f);
        v12.lineTo(4.22f, 7.03f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.horizontalLineTo(2.81f);
        v12.lineTo(2.1f, 9.15f);
        v12.lineToRelative(3.54f, 3.54f);
        v12.lineToRelative(0.71f, -0.71f);
        v12.verticalLineTo(9.15f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(0.71f, -0.71f);
        v12.lineToRelative(1.78f, 1.78f);
        v12.lineToRelative(-7.41f, 7.41f);
        v12.lineToRelative(2.12f, 2.12f);
        v12.lineTo(16.34f, 9.79f);
        v12.curveTo(16.700001f, 9.92f, 17.09f, 10f, 17.5f, 10f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ConstructionKt._construction = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

