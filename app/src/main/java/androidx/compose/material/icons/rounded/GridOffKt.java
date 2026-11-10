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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_gridOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "GridOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getGridOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class GridOffKt {
    private static ImageVector _gridOff;

    static {
    }

    public static final ImageVector getGridOff(Rounded arg19) {
        ImageVector v0 = GridOffKt._gridOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.GridOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8f, 4f);
        v12.verticalLineToRelative(0.89f);
        v12.lineToRelative(2f, 2f);
        v12.lineTo(10f, 4f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(-2.89f);
        v12.lineToRelative(2f, 2f);
        v12.lineTo(14f, 10f);
        v12.verticalLineToRelative(0.89f);
        v12.lineToRelative(2f, 2f);
        v12.lineTo(16f, 10f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(-2.89f);
        v12.lineToRelative(2f, 2f);
        v12.lineTo(20f, 16f);
        v12.verticalLineToRelative(0.89f);
        v12.lineToRelative(2f, 2f);
        v12.lineTo(22f, 4f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.lineTo(5.11f, 2f);
        v12.lineToRelative(2f, 2f);
        v12.lineTo(8f, 4f);
        v12.close();
        v12.moveTo(16f, 4f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(-4f);
        v12.lineTo(16f, 4f);
        v12.close();
        v12.moveTo(22.16f, 21.879999f);
        v12.lineTo(2.12f, 1.84f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineTo(2f, 4.55f);
        v12.lineTo(2f, 20f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(15.45f);
        v12.lineToRelative(1.3f, 1.3f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.03f, 0f, -1.42f);
        v12.close();
        v12.moveTo(10f, 12.55f);
        v12.lineTo(11.45f, 14f);
        v12.lineTo(10f, 14f);
        v12.verticalLineToRelative(-1.45f);
        v12.close();
        v12.moveTo(4f, 6.55f);
        v12.lineTo(5.45f, 8f);
        v12.lineTo(4f, 8f);
        v12.lineTo(4f, 6.55f);
        v12.close();
        v12.moveTo(8f, 20f);
        v12.lineTo(5f, 20f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(4f);
        v12.close();
        v12.moveTo(8f, 14f);
        v12.lineTo(4f, 14f);
        v12.verticalLineToRelative(-4f);
        v12.horizontalLineToRelative(3.45f);
        v12.lineToRelative(0.55f, 0.55f);
        v12.lineTo(8f, 14f);
        v12.close();
        v12.moveTo(14f, 20f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineToRelative(-4f);
        v12.horizontalLineToRelative(3.45f);
        v12.lineToRelative(0.55f, 0.55f);
        v12.lineTo(14f, 20f);
        v12.close();
        v12.moveTo(16f, 20f);
        v12.verticalLineToRelative(-1.45f);
        v12.lineTo(17.450001f, 20f);
        v12.lineTo(16f, 20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        GridOffKt._gridOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

