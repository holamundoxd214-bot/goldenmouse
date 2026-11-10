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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_localFireDepartment", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocalFireDepartment", "Landroidx/compose/material/icons/Icons$Rounded;", "getLocalFireDepartment", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LocalFireDepartmentKt {
    private static ImageVector _localFireDepartment;

    static {
    }

    public static final ImageVector getLocalFireDepartment(Rounded arg19) {
        ImageVector v0 = LocalFireDepartmentKt._localFireDepartment;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.LocalFireDepartment", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 12.9f);
        v12.lineToRelative(-2.03f, 2f);
        v12.curveToRelative(-0.46f, 0.46f, -0.82f, 1.03f, -0.93f, 1.67f);
        v12.curveTo(8.74f, 18.41f, 10.18f, 20f, 12f, 20f);
        v12.reflectiveCurveToRelative(3.26f, -1.59f, 2.96f, -3.42f);
        v12.curveToRelative(-0.11f, -0.64f, -0.46f, -1.22f, -0.93f, -1.67f);
        v12.lineTo(12f, 12.9f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(15.56f, 6.55f);
        v12.lineTo(15.56f, 6.55f);
        v12.curveTo(14.38f, 8.02f, 12f, 7.19f, 12f, 5.3f);
        v12.verticalLineTo(3.77f);
        v12.curveToRelative(0f, -0.8f, -0.89f, -1.28f, -1.55f, -0.84f);
        v12.curveTo(8.12f, 4.49f, 4f, 7.97f, 4f, 13f);
        v12.curveToRelative(0f, 2.92f, 1.56f, 5.47f, 3.89f, 6.86f);
        v12.curveToRelative(-0.71f, -1.02f, -1.06f, -2.31f, -0.81f, -3.68f);
        v12.curveToRelative(0.19f, -1.04f, 0.75f, -1.98f, 1.51f, -2.72f);
        v12.lineToRelative(2.71f, -2.67f);
        v12.curveToRelative(0.39f, -0.38f, 1.01f, -0.38f, 1.4f, 0f);
        v12.lineToRelative(2.73f, 2.69f);
        v12.curveToRelative(0.74f, 0.73f, 1.3f, 1.65f, 1.48f, 2.68f);
        v12.curveToRelative(0.25f, 1.36f, -0.07f, 2.64f, -0.77f, 3.66f);
        v12.curveToRelative(1.89f, -1.15f, 3.29f, -3.06f, 3.71f, -5.3f);
        v12.curveToRelative(0.61f, -3.27f, -0.81f, -6.37f, -3.22f, -8.1f);
        v12.curveTo(16.299999f, 6.17f, 15.83f, 6.22f, 15.56f, 6.55f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LocalFireDepartmentKt._localFireDepartment = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

