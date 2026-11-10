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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_update", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Update", "Landroidx/compose/material/icons/Icons$Rounded;", "getUpdate", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class UpdateKt {
    private static ImageVector _update;

    static {
    }

    public static final ImageVector getUpdate(Rounded arg19) {
        ImageVector v0 = UpdateKt._update;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Update", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11f, 8.75f);
        v12.verticalLineToRelative(3.68f);
        v12.curveToRelative(0f, 0.35f, 0.19f, 0.68f, 0.49f, 0.86f);
        v12.lineToRelative(3.12f, 1.85f);
        v12.curveToRelative(0.36f, 0.21f, 0.82f, 0.09f, 1.03f, -0.26f);
        v12.curveToRelative(0.21f, -0.36f, 0.1f, -0.82f, -0.26f, -1.03f);
        v12.lineToRelative(-2.87f, -1.71f);
        v12.verticalLineToRelative(-3.4f);
        v12.curveTo(12.5f, 8.34f, 12.16f, 8f, 11.75f, 8f);
        v12.reflectiveCurveTo(11f, 8.34f, 11f, 8.75f);
        v12.close();
        v12.moveTo(21f, 9.5f);
        v12.verticalLineTo(4.21f);
        v12.curveToRelative(0f, -0.45f, -0.54f, -0.67f, -0.85f, -0.35f);
        v12.lineToRelative(-1.78f, 1.78f);
        v12.curveToRelative(-1.81f, -1.81f, -4.39f, -2.85f, -7.21f, -2.6f);
        v12.curveToRelative(-4.19f, 0.38f, -7.64f, 3.75f, -8.1f, 7.94f);
        v12.curveTo(2.46f, 16.4f, 6.69f, 21f, 12f, 21f);
        v12.curveToRelative(4.59f, 0f, 8.38f, -3.44f, 8.93f, -7.88f);
        v12.curveToRelative(0.07f, -0.6f, -0.4f, -1.12f, -1f, -1.12f);
        v12.curveToRelative(-0.5f, 0f, -0.92f, 0.37f, -0.98f, 0.86f);
        v12.curveToRelative(-0.43f, 3.49f, -3.44f, 6.19f, -7.05f, 6.14f);
        v12.curveToRelative(-3.71f, -0.05f, -6.84f, -3.18f, -6.9f, -6.9f);
        v12.curveTo(4.94f, 8.2f, 8.11f, 5f, 12f, 5f);
        v12.curveToRelative(1.93f, 0f, 3.68f, 0.79f, 4.95f, 2.05f);
        v12.lineToRelative(-2.09f, 2.09f);
        v12.curveTo(14.54f, 9.46f, 14.76f, 10f, 15.21f, 10f);
        v12.horizontalLineToRelative(5.29f);
        v12.curveTo(20.780001f, 10f, 21f, 9.78f, 21f, 9.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        UpdateKt._update = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

