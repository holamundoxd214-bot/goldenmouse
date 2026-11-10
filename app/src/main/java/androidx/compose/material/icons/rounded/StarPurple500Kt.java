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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_starPurple500", "Landroidx/compose/ui/graphics/vector/ImageVector;", "StarPurple500", "Landroidx/compose/material/icons/Icons$Rounded;", "getStarPurple500", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class StarPurple500Kt {
    private static ImageVector _starPurple500;

    static {
    }

    public static final ImageVector getStarPurple500(Rounded arg19) {
        ImageVector v0 = StarPurple500Kt._starPurple500;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.StarPurple500", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 8.89f);
        v12.lineTo(12.94f, 12f);
        v12.horizontalLineToRelative(2.82f);
        v12.lineToRelative(-2.27f, 1.62f);
        v12.lineToRelative(0.93f, 3.01f);
        v12.lineTo(12f, 14.79f);
        v12.lineToRelative(-2.42f, 1.84f);
        v12.lineToRelative(0.93f, -3.01f);
        v12.lineTo(8.24f, 12f);
        v12.horizontalLineToRelative(2.82f);
        v12.lineTo(12f, 8.89f);
        v12.moveTo(9.58f, 10f);
        v12.horizontalLineTo(5.12f);
        v12.curveToRelative(-0.97f, 0f, -1.37f, 1.25f, -0.58f, 1.81f);
        v12.lineToRelative(3.64f, 2.6f);
        v12.lineToRelative(-1.43f, 4.61f);
        v12.curveToRelative(-0.29f, 0.93f, 0.79f, 1.68f, 1.56f, 1.09f);
        v12.lineTo(12f, 17.309999f);
        v12.lineToRelative(3.69f, 2.81f);
        v12.curveToRelative(0.77f, 0.59f, 1.85f, -0.16f, 1.56f, -1.09f);
        v12.lineToRelative(-1.43f, -4.61f);
        v12.lineToRelative(3.64f, -2.6f);
        v12.curveToRelative(0.79f, -0.57f, 0.39f, -1.81f, -0.58f, -1.81f);
        v12.horizontalLineToRelative(-4.46f);
        v12.lineToRelative(-1.47f, -4.84f);
        v12.curveToRelative(-0.29f, -0.95f, -1.63f, -0.95f, -1.91f, 0f);
        v12.lineTo(9.58f, 10f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        StarPurple500Kt._starPurple500 = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

