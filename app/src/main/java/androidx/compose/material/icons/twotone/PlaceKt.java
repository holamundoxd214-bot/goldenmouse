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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_place", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Place", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPlace", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PlaceKt {
    private static ImageVector _place;

    static {
    }

    public static final ImageVector getPlace(TwoTone arg19) {
        ImageVector v0 = PlaceKt._place;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Place", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.5f, 10.2f);
        v12.curveToRelative(0f, 2.57f, -2.1f, 5.79f, -6.16f, 9.51f);
        v12.lineTo(12f, 20.01f);
        v12.lineToRelative(-0.34f, -0.31f);
        v12.curveTo(7.6f, 15.99f, 5.5f, 12.77f, 5.5f, 10.2f);
        v12.curveToRelative(0f, -3.84f, 2.82f, -6.7f, 6.5f, -6.7f);
        v12.reflectiveCurveTo(18.5f, 6.35f, 18.5f, 10.2f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveToRelative(4.2f, 0f, 8f, 3.22f, 8f, 8.2f);
        v12.curveToRelative(0f, 3.32f, -2.67f, 7.25f, -8f, 11.8f);
        v12.curveToRelative(-5.33f, -4.55f, -8f, -8.48f, -8f, -11.8f);
        v12.curveTo(4f, 5.22f, 7.8f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(18f, 10.2f);
        v12.curveTo(18f, 6.57f, 15.35f, 4f, 12f, 4f);
        v12.reflectiveCurveToRelative(-6f, 2.57f, -6f, 6.2f);
        v12.curveToRelative(0f, 2.34f, 1.95f, 5.44f, 6f, 9.14f);
        v12.curveTo(16.049999f, 15.64f, 18f, 12.54f, 18f, 10.2f);
        v12.close();
        v12.moveTo(12f, 12f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.reflectiveCurveToRelative(0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.reflectiveCurveTo(13.1f, 12f, 12f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PlaceKt._place = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

