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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_taskAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TaskAlt", "Landroidx/compose/material/icons/Icons$Rounded;", "getTaskAlt", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TaskAltKt {
    private static ImageVector _taskAlt;

    static {
    }

    public static final ImageVector getTaskAlt(Rounded arg19) {
        ImageVector v0 = TaskAltKt._taskAlt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.TaskAlt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.290001f, 5.89f);
        v12.lineToRelative(-10f, 10f);
        v12.curveToRelative(-0.39f, 0.39f, -1.02f, 0.39f, -1.41f, 0f);
        v12.lineToRelative(-2.83f, -2.83f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0f);
        v12.lineToRelative(2.12f, 2.12f);
        v12.lineToRelative(9.29f, -9.29f);
        v12.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(21.68f, 4.87f, 21.68f, 5.5f, 21.290001f, 5.89f);
        v12.close();
        v12.moveTo(15.77f, 2.74f);
        v12.curveToRelative(-1.69f, -0.69f, -3.61f, -0.93f, -5.61f, -0.57f);
        v12.curveTo(6.09f, 2.9f, 2.84f, 6.18f, 2.15f, 10.25f);
        v12.curveTo(1.01f, 17f, 6.63f, 22.780001f, 13.34f, 21.91f);
        v12.curveToRelative(3.96f, -0.51f, 7.28f, -3.46f, 8.32f, -7.31f);
        v12.curveToRelative(0.4f, -1.47f, 0.44f, -2.89f, 0.21f, -4.22f);
        v12.curveToRelative(-0.13f, -0.8f, -1.12f, -1.11f, -1.7f, -0.54f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(-0.23f, 0.23f, -0.33f, 0.57f, -0.27f, 0.89f);
        v12.curveToRelative(0.22f, 1.33f, 0.12f, 2.75f, -0.52f, 4.26f);
        v12.curveToRelative(-1.16f, 2.71f, -3.68f, 4.7f, -6.61f, 4.97f);
        v12.curveToRelative(-5.1f, 0.47f, -9.33f, -3.85f, -8.7f, -8.98f);
        v12.curveToRelative(0.43f, -3.54f, 3.28f, -6.42f, 6.81f, -6.91f);
        v12.curveToRelative(1.73f, -0.24f, 3.37f, 0.09f, 4.77f, 0.81f);
        v12.curveToRelative(0.39f, 0.2f, 0.86f, 0.13f, 1.17f, -0.18f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.48f, -0.48f, 0.36f, -1.29f, -0.24f, -1.6f);
        v12.curveTo(16.309999f, 2.98f, 16.040001f, 2.85f, 15.77f, 2.74f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TaskAltKt._taskAlt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

