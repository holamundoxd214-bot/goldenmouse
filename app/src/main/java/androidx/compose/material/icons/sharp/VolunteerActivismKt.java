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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_volunteerActivism", "Landroidx/compose/ui/graphics/vector/ImageVector;", "VolunteerActivism", "Landroidx/compose/material/icons/Icons$Sharp;", "getVolunteerActivism", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VolunteerActivismKt {
    private static ImageVector _volunteerActivism;

    static {
    }

    public static final ImageVector getVolunteerActivism(Sharp arg19) {
        ImageVector v0 = VolunteerActivismKt._volunteerActivism;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.VolunteerActivism", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(1f, 11f);
        v0_1.horizontalLineToRelative(4f);
        v0_1.verticalLineToRelative(11f);
        v0_1.horizontalLineToRelative(-4f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 3.25f);
        v12.curveTo(16.65f, 2.49f, 17.66f, 2f, 18.700001f, 2f);
        v12.curveTo(20.549999f, 2f, 22f, 3.45f, 22f, 5.3f);
        v12.curveToRelative(0f, 2.27f, -2.91f, 4.9f, -6f, 7.7f);
        v12.curveToRelative(-3.09f, -2.81f, -6f, -5.44f, -6f, -7.7f);
        v12.curveTo(10f, 3.45f, 11.45f, 2f, 13.3f, 2f);
        v12.curveTo(14.34f, 2f, 15.35f, 2.49f, 16f, 3.25f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(22f, 17f);
        v0_1.lineToRelative(-9f, 0f);
        v0_1.lineToRelative(-2.09f, -0.73f);
        v0_1.lineToRelative(0.33f, -0.95f);
        v0_1.lineToRelative(1.76f, 0.68f);
        v0_1.lineToRelative(4f, 0f);
        v0_1.lineToRelative(0f, -2f);
        v0_1.lineToRelative(-8.03f, -3f);
        v0_1.lineToRelative(-1.97f, 0f);
        v0_1.lineToRelative(0f, 9.02f);
        v0_1.lineToRelative(7f, 1.98f);
        v0_1.lineToRelative(8f, -3f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VolunteerActivismKt._volunteerActivism = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

