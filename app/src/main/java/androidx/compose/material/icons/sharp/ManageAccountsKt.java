package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_manageAccounts", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ManageAccounts", "Landroidx/compose/material/icons/Icons$Sharp;", "getManageAccounts", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ManageAccountsKt {
    private static ImageVector _manageAccounts;

    static {
    }

    public static final ImageVector getManageAccounts(Sharp arg20) {
        ImageVector v0 = ManageAccountsKt._manageAccounts;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.ManageAccounts", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10.67f, 13.02f);
        v12.curveTo(10.45f, 13.01f, 10.23f, 13f, 10f, 13f);
        v12.curveToRelative(-2.42f, 0f, -4.68f, 0.67f, -6.61f, 1.82f);
        v12.curveTo(2.51f, 15.34f, 2f, 16.32f, 2f, 17.35f);
        v12.verticalLineTo(20f);
        v12.horizontalLineToRelative(9.26f);
        v12.curveTo(10.47f, 18.870001f, 10f, 17.49f, 10f, 16f);
        v12.curveTo(10f, 14.93f, 10.25f, 13.93f, 10.67f, 13.02f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(10f, 8f);
        v12.moveToRelative(-4f, 0f);
        v12.arcToRelative(4f, 4f, 0f, true, true, 8f, 0f);
        v12.arcToRelative(4f, 4f, 0f, true, true, -8f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(20.75f, 16f);
        v12.curveToRelative(0f, -0.22f, -0.03f, -0.42f, -0.06f, -0.63f);
        v12.lineToRelative(1.14f, -1.01f);
        v12.lineToRelative(-1f, -1.73f);
        v12.lineToRelative(-1.45f, 0.49f);
        v12.curveToRelative(-0.32f, -0.27f, -0.68f, -0.48f, -1.08f, -0.63f);
        v12.lineTo(18f, 11f);
        v12.horizontalLineToRelative(-2f);
        v12.lineToRelative(-0.3f, 1.49f);
        v12.curveToRelative(-0.4f, 0.15f, -0.76f, 0.36f, -1.08f, 0.63f);
        v12.lineToRelative(-1.45f, -0.49f);
        v12.lineToRelative(-1f, 1.73f);
        v12.lineToRelative(1.14f, 1.01f);
        v12.curveToRelative(-0.03f, 0.21f, -0.06f, 0.41f, -0.06f, 0.63f);
        v12.reflectiveCurveToRelative(0.03f, 0.42f, 0.06f, 0.63f);
        v12.lineToRelative(-1.14f, 1.01f);
        v12.lineToRelative(1f, 1.73f);
        v12.lineToRelative(1.45f, -0.49f);
        v12.curveToRelative(0.32f, 0.27f, 0.68f, 0.48f, 1.08f, 0.63f);
        v12.lineTo(16f, 21f);
        v12.horizontalLineToRelative(2f);
        v12.lineToRelative(0.3f, -1.49f);
        v12.curveToRelative(0.4f, -0.15f, 0.76f, -0.36f, 1.08f, -0.63f);
        v12.lineToRelative(1.45f, 0.49f);
        v12.lineToRelative(1f, -1.73f);
        v12.lineToRelative(-1.14f, -1.01f);
        v12.curveTo(20.719999f, 16.42f, 20.75f, 16.219999f, 20.75f, 16f);
        v12.close();
        v12.moveTo(17f, 18f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.reflectiveCurveToRelative(0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.reflectiveCurveTo(18.1f, 18f, 17f, 18f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ManageAccountsKt._manageAccounts = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

