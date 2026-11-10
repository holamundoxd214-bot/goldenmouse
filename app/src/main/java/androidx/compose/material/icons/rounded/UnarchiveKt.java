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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_unarchive", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Unarchive", "Landroidx/compose/material/icons/Icons$Rounded;", "getUnarchive", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class UnarchiveKt {
    private static ImageVector _unarchive;

    static {
    }

    public static final ImageVector getUnarchive(Rounded arg19) {
        ImageVector v0 = UnarchiveKt._unarchive;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Unarchive", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.549999f, 5.22f);
        v12.lineToRelative(-1.39f, -1.68f);
        v12.curveTo(18.879999f, 3.21f, 18.469999f, 3f, 18f, 3f);
        v12.lineTo(6f, 3f);
        v12.curveToRelative(-0.47f, 0f, -0.88f, 0.21f, -1.15f, 0.55f);
        v12.lineTo(3.46f, 5.22f);
        v12.curveTo(3.17f, 5.57f, 3f, 6.01f, 3f, 6.5f);
        v12.lineTo(3f, 19f);
        v12.curveToRelative(0f, 1.1f, 0.89f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(21f, 6.5f);
        v12.curveToRelative(0f, -0.49f, -0.17f, -0.93f, -0.45f, -1.28f);
        v12.close();
        v12.moveTo(12.35f, 9.85f);
        v12.lineTo(17.5f, 15f);
        v12.lineTo(14f, 15f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineToRelative(-2f);
        v12.lineTo(6.5f, 15f);
        v12.lineToRelative(5.15f, -5.15f);
        v12.curveToRelative(0.19f, -0.19f, 0.51f, -0.19f, 0.7f, 0f);
        v12.close();
        v12.moveTo(5.12f, 5f);
        v12.lineToRelative(0.82f, -1f);
        v12.horizontalLineToRelative(12f);
        v12.lineToRelative(0.93f, 1f);
        v12.lineTo(5.12f, 5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        UnarchiveKt._unarchive = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

