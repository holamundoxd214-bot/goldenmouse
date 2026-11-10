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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_addModerator", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AddModerator", "Landroidx/compose/material/icons/Icons$Filled;", "getAddModerator", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AddModeratorKt {
    private static ImageVector _addModerator;

    static {
    }

    public static final ImageVector getAddModerator(Filled arg19) {
        ImageVector v0 = AddModeratorKt._addModerator;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.AddModerator", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13.22f, 22.610001f);
        v12.curveToRelative(-0.4f, 0.15f, -0.8f, 0.29f, -1.22f, 0.39f);
        v12.curveToRelative(-5.16f, -1.26f, -9f, -6.45f, -9f, -12f);
        v12.verticalLineTo(5f);
        v12.lineToRelative(9f, -4f);
        v12.lineToRelative(9f, 4f);
        v12.verticalLineToRelative(6f);
        v12.curveToRelative(0f, 0.9f, -0.11f, 1.78f, -0.3f, 2.65f);
        v12.curveToRelative(-0.81f, -0.41f, -1.73f, -0.65f, -2.7f, -0.65f);
        v12.curveToRelative(-3.31f, 0f, -6f, 2.69f, -6f, 6f);
        v12.curveToRelative(0f, 1.36f, 0.46f, 2.61f, 1.22f, 3.61f);
        v12.close();
        v12.moveTo(19f, 20f);
        v12.verticalLineToRelative(2.99f);
        v12.reflectiveCurveToRelative(-1.99f, 0.01f, -2f, 0f);
        v12.verticalLineTo(20f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AddModeratorKt._addModerator = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

