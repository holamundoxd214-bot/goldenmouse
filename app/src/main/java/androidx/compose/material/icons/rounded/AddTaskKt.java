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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_addTask", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AddTask", "Landroidx/compose/material/icons/Icons$Rounded;", "getAddTask", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AddTaskKt {
    private static ImageVector _addTask;

    static {
    }

    public static final ImageVector getAddTask(Rounded arg19) {
        ImageVector v0 = AddTaskKt._addTask;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.AddTask", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.verticalLineToRelative(0f);
        v12.curveTo(21.68f, 4.87f, 21.68f, 5.5f, 21.290001f, 5.89f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-4.71f, 0f, -8.48f, -4.09f, -7.95f, -8.9f);
        v12.curveToRelative(0.39f, -3.52f, 3.12f, -6.41f, 6.61f, -6.99f);
        v12.curveToRelative(1.81f, -0.3f, 3.53f, 0.02f, 4.99f, 0.78f);
        v12.curveToRelative(0.39f, 0.2f, 0.86f, 0.13f, 1.17f, -0.18f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.48f, -0.48f, 0.36f, -1.29f, -0.24f, -1.6f);
        v12.curveTo(15.11f, 2.36f, 13.45f, 1.95f, 11.68f, 2f);
        v12.curveToRelative(-5.14f, 0.16f, -9.41f, 4.34f, -9.67f, 9.47f);
        v12.curveTo(1.72f, 17.24f, 6.3f, 22f, 12f, 22f);
        v12.curveToRelative(1.2f, 0f, 2.34f, -0.21f, 3.41f, -0.6f);
        v12.curveToRelative(0.68f, -0.25f, 0.87f, -1.13f, 0.35f, -1.65f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.27f, -0.27f, -0.68f, -0.37f, -1.04f, -0.23f);
        v12.curveTo(13.87f, 19.83f, 12.95f, 20f, 12f, 20f);
        v12.close();
        v12.moveTo(19f, 15f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineTo(15f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AddTaskKt._addTask = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

