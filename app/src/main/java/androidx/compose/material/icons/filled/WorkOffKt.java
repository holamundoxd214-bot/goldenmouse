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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_workOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WorkOff", "Landroidx/compose/material/icons/Icons$Filled;", "getWorkOff", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WorkOffKt {
    private static ImageVector _workOff;

    static {
    }

    public static final ImageVector getWorkOff(Filled arg19) {
        ImageVector v0 = WorkOffKt._workOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.WorkOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(23f, 21.74f);
        v12.lineToRelative(-1.46f, -1.46f);
        v12.lineTo(7.21f, 5.95f);
        v12.lineTo(3.25f, 1.99f);
        v12.lineTo(1.99f, 3.25f);
        v12.lineToRelative(2.7f, 2.7f);
        v12.horizontalLineToRelative(-0.64f);
        v12.curveToRelative(-1.11f, 0f, -1.99f, 0.89f, -1.99f, 2f);
        v12.lineToRelative(-0.01f, 11f);
        v12.curveToRelative(0f, 1.11f, 0.89f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(15.64f);
        v12.lineTo(21.74f, 23f);
        v12.lineTo(23f, 21.74f);
        v12.close();
        v12.moveTo(22f, 7.95f);
        v12.curveToRelative(0.05f, -1.11f, -0.84f, -2f, -1.95f, -1.95f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineTo(3.95f);
        v12.curveToRelative(0f, -1.11f, -0.89f, -2f, -2f, -1.95f);
        v12.horizontalLineToRelative(-4f);
        v12.curveToRelative(-1.11f, -0.05f, -2f, 0.84f, -2f, 1.95f);
        v12.verticalLineToRelative(0.32f);
        v12.lineToRelative(13.95f, 14f);
        v12.verticalLineTo(7.95f);
        v12.close();
        v12.moveTo(14.05f, 6f);
        v12.horizontalLineTo(10f);
        v12.verticalLineTo(3.95f);
        v12.horizontalLineToRelative(4.05f);
        v12.verticalLineTo(6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WorkOffKt._workOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

