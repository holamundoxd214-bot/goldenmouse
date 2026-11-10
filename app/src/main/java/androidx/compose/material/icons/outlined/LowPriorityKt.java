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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_lowPriority", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LowPriority", "Landroidx/compose/material/icons/Icons$Outlined;", "getLowPriority", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LowPriorityKt {
    private static ImageVector _lowPriority;

    static {
    }

    public static final ImageVector getLowPriority(Outlined arg19) {
        ImageVector v0 = LowPriorityKt._lowPriority;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.LowPriority", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14f, 5f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-8f);
        v12.lineTo(14f, 5f);
        v12.close();
        v12.moveTo(14f, 10.5f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-8f);
        v12.verticalLineToRelative(-2f);
        v12.close();
        v12.moveTo(14f, 16f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-8f);
        v12.verticalLineToRelative(-2f);
        v12.close();
        v12.moveTo(2f, 11.5f);
        v12.curveTo(2f, 15.08f, 4.92f, 18f, 8.5f, 18f);
        v12.lineTo(9f, 18f);
        v12.verticalLineToRelative(2f);
        v12.lineToRelative(3f, -3f);
        v12.lineToRelative(-3f, -3f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-0.5f);
        v12.curveTo(6.02f, 16f, 4f, 13.98f, 4f, 11.5f);
        v12.reflectiveCurveTo(6.02f, 7f, 8.5f, 7f);
        v12.lineTo(12f, 7f);
        v12.lineTo(12f, 5f);
        v12.lineTo(8.5f, 5f);
        v12.curveTo(4.92f, 5f, 2f, 7.92f, 2f, 11.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LowPriorityKt._lowPriority = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

