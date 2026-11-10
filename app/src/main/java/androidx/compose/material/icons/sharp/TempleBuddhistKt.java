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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_templeBuddhist", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TempleBuddhist", "Landroidx/compose/material/icons/Icons$Sharp;", "getTempleBuddhist", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TempleBuddhistKt {
    private static ImageVector _templeBuddhist;

    static {
    }

    public static final ImageVector getTempleBuddhist(Sharp arg19) {
        ImageVector v0 = TempleBuddhistKt._templeBuddhist;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.TempleBuddhist", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 9.02f);
        v12.curveToRelative(0f, 1.09f, -0.89f, 1.98f, -1.98f, 1.98f);
        v12.horizontalLineTo(4.98f);
        v12.curveTo(3.89f, 11f, 3f, 10.11f, 3f, 9.02f);
        v12.horizontalLineTo(1f);
        v12.curveToRelative(0f, 1.86f, 1.28f, 3.4f, 3f, 3.84f);
        v12.verticalLineTo(22f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(-5f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(-9.14f);
        v12.curveToRelative(0.55f, -0.14f, 3f, -1.04f, 3f, -3.86f);
        v12.lineTo(21f, 9.02f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(6f, 8.86f);
        v12.verticalLineTo(10f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineTo(8.86f);
        v12.curveToRelative(0.55f, -0.14f, 3f, -1.04f, 3f, -3.86f);
        v12.lineToRelative(-2f, 0.02f);
        v12.curveTo(19f, 6.11f, 18.110001f, 7f, 17.02f, 7f);
        v12.horizontalLineTo(6.98f);
        v12.curveTo(5.89f, 7f, 5f, 6.11f, 5f, 5.02f);
        v12.horizontalLineTo(3f);
        v12.curveTo(3f, 6.87f, 4.28f, 8.42f, 6f, 8.86f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(12f, 1f);
        v0_1.lineToRelative(-3.75f, 5f);
        v0_1.lineToRelative(7.5f, 0f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TempleBuddhistKt._templeBuddhist = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

