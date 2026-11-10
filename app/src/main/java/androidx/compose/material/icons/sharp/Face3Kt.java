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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_face3", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Face3", "Landroidx/compose/material/icons/Icons$Sharp;", "getFace3", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class Face3Kt {
    private static ImageVector _face3;

    static {
    }

    public static final ImageVector getFace3(Sharp arg20) {
        ImageVector v0 = Face3Kt._face3;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Face3", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9f, 13f);
        v12.moveToRelative(-1.25f, 0f);
        v12.arcToRelative(1.25f, 1.25f, 0f, true, true, 2.5f, 0f);
        v12.arcToRelative(1.25f, 1.25f, 0f, true, true, -2.5f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(15f, 13f);
        v12.moveToRelative(-1.25f, 0f);
        v12.arcToRelative(1.25f, 1.25f, 0f, true, true, 2.5f, 0f);
        v12.arcToRelative(1.25f, 1.25f, 0f, true, true, -2.5f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(22.91f, 11.96f);
        v12.curveToRelative(-0.54f, -5.93f, -5.75f, -10.41f, -11.8f, -9.92f);
        v12.curveTo(5.73f, 2.46f, 1.55f, 6.94f, 1.06f, 12.32f);
        v12.lineTo(0f, 24f);
        v12.horizontalLineToRelative(24f);
        v12.curveToRelative(0f, 0f, 0f, 0f, 0f, 0f);
        v12.lineTo(22.91f, 11.96f);
        v12.close();
        v12.moveTo(4.54f, 9.13f);
        v12.curveTo(5.41f, 9.68f, 6.43f, 10f, 7.5f, 10f);
        v12.curveTo(9.36f, 10f, 11f, 9.07f, 12f, 7.65f);
        v12.curveTo(13f, 9.07f, 14.64f, 10f, 16.5f, 10f);
        v12.curveToRelative(1.07f, 0f, 2.09f, -0.32f, 2.96f, -0.87f);
        v12.curveTo(19.799999f, 10.02f, 20f, 10.99f, 20f, 12f);
        v12.curveToRelative(0f, 4.41f, -3.59f, 8f, -8f, 8f);
        v12.reflectiveCurveToRelative(-8f, -3.59f, -8f, -8f);
        v12.curveTo(4f, 10.99f, 4.2f, 10.02f, 4.54f, 9.13f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        Face3Kt._face3 = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

