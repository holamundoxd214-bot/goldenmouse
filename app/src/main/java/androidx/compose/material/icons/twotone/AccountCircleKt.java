package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_accountCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AccountCircle", "Landroidx/compose/material/icons/Icons$TwoTone;", "getAccountCircle", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AccountCircleKt {
    private static ImageVector _accountCircle;

    static {
    }

    public static final ImageVector getAccountCircle(TwoTone arg19) {
        ImageVector v0 = AccountCircleKt._accountCircle;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.AccountCircle", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 4f);
        v12.curveToRelative(-4.42f, 0f, -8f, 3.58f, -8f, 8f);
        v12.curveToRelative(0f, 1.95f, 0.7f, 3.73f, 1.86f, 5.12f);
        v12.curveTo(7.55f, 15.8f, 9.68f, 15f, 12f, 15f);
        v12.reflectiveCurveToRelative(4.45f, 0.8f, 6.14f, 2.12f);
        v12.curveTo(19.299999f, 15.73f, 20f, 13.95f, 20f, 12f);
        v12.curveTo(20f, 7.58f, 16.42f, 4f, 12f, 4f);
        v12.close();
        v12.moveTo(12f, 13f);
        v12.curveToRelative(-1.93f, 0f, -3.5f, -1.57f, -3.5f, -3.5f);
        v12.curveTo(8.5f, 7.57f, 10.07f, 6f, 12f, 6f);
        v12.reflectiveCurveToRelative(3.5f, 1.57f, 3.5f, 3.5f);
        v12.curveTo(15.5f, 11.43f, 13.93f, 13f, 12f, 13f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.curveToRelative(0f, 5.52f, 4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.curveTo(22f, 6.48f, 17.52f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-1.74f, 0f, -3.34f, -0.56f, -4.65f, -1.5f);
        v12.curveTo(8.66f, 17.559999f, 10.26f, 17f, 12f, 17f);
        v12.reflectiveCurveToRelative(3.34f, 0.56f, 4.65f, 1.5f);
        v12.curveTo(15.34f, 19.440001f, 13.74f, 20f, 12f, 20f);
        v12.close();
        v12.moveTo(18.139999f, 17.120001f);
        v12.curveTo(16.450001f, 15.8f, 14.32f, 15f, 12f, 15f);
        v12.reflectiveCurveToRelative(-4.45f, 0.8f, -6.14f, 2.12f);
        v12.curveTo(4.7f, 15.73f, 4f, 13.95f, 4f, 12f);
        v12.curveToRelative(0f, -4.42f, 3.58f, -8f, 8f, -8f);
        v12.reflectiveCurveToRelative(8f, 3.58f, 8f, 8f);
        v12.curveTo(20f, 13.95f, 19.299999f, 15.73f, 18.139999f, 17.120001f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 5.93f);
        v12.curveToRelative(-1.93f, 0f, -3.5f, 1.57f, -3.5f, 3.5f);
        v12.curveToRelative(0f, 1.93f, 1.57f, 3.5f, 3.5f, 3.5f);
        v12.reflectiveCurveToRelative(3.5f, -1.57f, 3.5f, -3.5f);
        v12.curveTo(15.5f, 7.5f, 13.93f, 5.93f, 12f, 5.93f);
        v12.close();
        v12.moveTo(12f, 10.93f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveToRelative(0.67f, -1.5f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(12.83f, 10.93f, 12f, 10.93f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AccountCircleKt._accountCircle = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

