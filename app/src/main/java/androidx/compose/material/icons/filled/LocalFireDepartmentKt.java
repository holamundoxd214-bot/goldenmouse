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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_localFireDepartment", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocalFireDepartment", "Landroidx/compose/material/icons/Icons$Filled;", "getLocalFireDepartment", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LocalFireDepartmentKt {
    private static ImageVector _localFireDepartment;

    static {
    }

    public static final ImageVector getLocalFireDepartment(Filled arg19) {
        ImageVector v0 = LocalFireDepartmentKt._localFireDepartment;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.LocalFireDepartment", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 12.9f);
        v12.lineToRelative(-2.13f, 2.09f);
        v12.curveTo(9.31f, 15.55f, 9f, 16.280001f, 9f, 17.059999f);
        v12.curveTo(9f, 18.68f, 10.35f, 20f, 12f, 20f);
        v12.reflectiveCurveToRelative(3f, -1.32f, 3f, -2.94f);
        v12.curveToRelative(0f, -0.78f, -0.31f, -1.52f, -0.87f, -2.07f);
        v12.lineTo(12f, 12.9f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(16f, 6f);
        v12.lineToRelative(-0.44f, 0.55f);
        v12.curveTo(14.38f, 8.02f, 12f, 7.19f, 12f, 5.3f);
        v12.verticalLineTo(2f);
        v12.curveToRelative(0f, 0f, -8f, 4f, -8f, 11f);
        v12.curveToRelative(0f, 2.92f, 1.56f, 5.47f, 3.89f, 6.86f);
        v12.curveTo(7.33f, 19.07f, 7f, 18.1f, 7f, 17.059999f);
        v12.curveToRelative(0f, -1.32f, 0.52f, -2.56f, 1.47f, -3.5f);
        v12.lineTo(12f, 10.1f);
        v12.lineToRelative(3.53f, 3.47f);
        v12.curveToRelative(0.95f, 0.93f, 1.47f, 2.17f, 1.47f, 3.5f);
        v12.curveToRelative(0f, 1.02f, -0.31f, 1.96f, -0.85f, 2.75f);
        v12.curveToRelative(1.89f, -1.15f, 3.29f, -3.06f, 3.71f, -5.3f);
        v12.curveTo(20.52f, 10.97f, 18.790001f, 7.62f, 16f, 6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LocalFireDepartmentKt._localFireDepartment = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

