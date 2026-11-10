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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_elevator", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Elevator", "Landroidx/compose/material/icons/Icons$Rounded;", "getElevator", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ElevatorKt {
    private static ImageVector _elevator;

    static {
    }

    public static final ImageVector getElevator(Rounded arg19) {
        ImageVector v0 = ElevatorKt._elevator;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Elevator", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 3f);
        v12.horizontalLineTo(5f);
        v12.curveTo(3.9f, 3f, 3f, 3.9f, 3f, 5f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(5f);
        v12.curveTo(21f, 3.9f, 20.1f, 3f, 19f, 3f);
        v12.close();
        v12.moveTo(8.5f, 6f);
        v12.curveToRelative(0.69f, 0f, 1.25f, 0.56f, 1.25f, 1.25f);
        v12.curveToRelative(0f, 0.69f, -0.56f, 1.25f, -1.25f, 1.25f);
        v12.reflectiveCurveTo(7.25f, 7.94f, 7.25f, 7.25f);
        v12.curveTo(7.25f, 6.56f, 7.81f, 6f, 8.5f, 6f);
        v12.close();
        v12.moveTo(11f, 13f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.verticalLineToRelative(3f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineTo(8f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-1.5f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.verticalLineTo(13f);
        v12.close();
        v12.moveTo(17.52f, 13.76f);
        v12.lineToRelative(-1.6f, 2.56f);
        v12.curveToRelative(-0.2f, 0.31f, -0.65f, 0.31f, -0.85f, 0f);
        v12.lineToRelative(-1.6f, -2.56f);
        v12.curveTo(13.27f, 13.43f, 13.51f, 13f, 13.9f, 13f);
        v12.horizontalLineToRelative(3.2f);
        v12.curveTo(17.49f, 13f, 17.73f, 13.43f, 17.52f, 13.76f);
        v12.close();
        v12.moveTo(17.1f, 11f);
        v12.horizontalLineToRelative(-3.2f);
        v12.curveToRelative(-0.39f, 0f, -0.63f, -0.43f, -0.42f, -0.77f);
        v12.lineToRelative(1.6f, -2.56f);
        v12.curveToRelative(0.2f, -0.31f, 0.65f, -0.31f, 0.85f, 0f);
        v12.lineToRelative(1.6f, 2.56f);
        v12.curveTo(17.73f, 10.57f, 17.49f, 11f, 17.1f, 11f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ElevatorKt._elevator = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

