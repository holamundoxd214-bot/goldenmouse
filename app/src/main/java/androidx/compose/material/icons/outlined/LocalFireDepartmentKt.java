package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_localFireDepartment", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocalFireDepartment", "Landroidx/compose/material/icons/Icons$Outlined;", "getLocalFireDepartment", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LocalFireDepartmentKt {
    private static ImageVector _localFireDepartment;

    static {
    }

    public static final ImageVector getLocalFireDepartment(Outlined arg19) {
        ImageVector v0 = LocalFireDepartmentKt._localFireDepartment;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.LocalFireDepartment", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 6f);
        v12.lineToRelative(-0.44f, 0.55f);
        v12.curveToRelative(-0.42f, 0.52f, -0.98f, 0.75f, -1.54f, 0.75f);
        v12.curveTo(13f, 7.3f, 12f, 6.52f, 12f, 5.3f);
        v12.verticalLineTo(2f);
        v12.curveToRelative(0f, 0f, -8f, 4f, -8f, 11f);
        v12.curveToRelative(0f, 4.42f, 3.58f, 8f, 8f, 8f);
        v12.reflectiveCurveToRelative(8f, -3.58f, 8f, -8f);
        v12.curveTo(20f, 10.04f, 18.389999f, 7.38f, 16f, 6f);
        v12.close();
        v12.moveTo(12f, 19f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.87f, -2f, -1.94f);
        v12.curveToRelative(0f, -0.51f, 0.2f, -0.99f, 0.58f, -1.36f);
        v12.lineToRelative(1.42f, -1.4f);
        v12.lineToRelative(1.43f, 1.4f);
        v12.curveTo(13.8f, 16.07f, 14f, 16.549999f, 14f, 17.059999f);
        v12.curveTo(14f, 18.129999f, 13.1f, 19f, 12f, 19f);
        v12.close();
        v12.moveTo(15.96f, 17.5f);
        v12.lineTo(15.96f, 17.5f);
        v12.curveToRelative(0.04f, -0.36f, 0.22f, -1.89f, -1.13f, -3.22f);
        v12.lineToRelative(0f, 0f);
        v12.lineTo(12f, 11.5f);
        v12.lineToRelative(-2.83f, 2.78f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-1.36f, 1.34f, -1.17f, 2.88f, -1.13f, 3.22f);
        v12.curveTo(6.79f, 16.4f, 6f, 14.79f, 6f, 13f);
        v12.curveToRelative(0f, -3.16f, 2.13f, -5.65f, 4.03f, -7.25f);
        v12.curveToRelative(0.23f, 1.99f, 1.93f, 3.55f, 3.99f, 3.55f);
        v12.curveToRelative(0.78f, 0f, 1.54f, -0.23f, 2.18f, -0.66f);
        v12.curveTo(17.34f, 9.78f, 18f, 11.35f, 18f, 13f);
        v12.curveTo(18f, 14.79f, 17.209999f, 16.4f, 15.96f, 17.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LocalFireDepartmentKt._localFireDepartment = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

