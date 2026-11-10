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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_interests", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Interests", "Landroidx/compose/material/icons/Icons$Filled;", "getInterests", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class InterestsKt {
    private static ImageVector _interests;

    static {
    }

    public static final ImageVector getInterests(Filled arg19) {
        ImageVector v0 = InterestsKt._interests;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Interests", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7.02f, 13f);
        v12.curveToRelative(-2.21f, 0f, -4f, 1.79f, -4f, 4f);
        v12.reflectiveCurveToRelative(1.79f, 4f, 4f, 4f);
        v12.reflectiveCurveToRelative(4f, -1.79f, 4f, -4f);
        v12.reflectiveCurveTo(9.23f, 13f, 7.02f, 13f);
        v12.close();
        v12.moveTo(13f, 13f);
        v12.verticalLineToRelative(8f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(-8f);
        v12.horizontalLineTo(13f);
        v12.close();
        v12.moveTo(7f, 2f);
        v12.lineToRelative(-5f, 9f);
        v12.horizontalLineToRelative(10f);
        v12.lineTo(7f, 2f);
        v12.close();
        v12.moveTo(19.25f, 2.5f);
        v12.curveToRelative(-1.06f, 0f, -1.81f, 0.56f, -2.25f, 1.17f);
        v12.curveToRelative(-0.44f, -0.61f, -1.19f, -1.17f, -2.25f, -1.17f);
        v12.curveTo(13.19f, 2.5f, 12f, 3.78f, 12f, 5.25f);
        v12.curveToRelative(0f, 2f, 2.42f, 3.42f, 5f, 5.75f);
        v12.curveToRelative(2.58f, -2.33f, 5f, -3.75f, 5f, -5.75f);
        v12.curveTo(22f, 3.78f, 20.809999f, 2.5f, 19.25f, 2.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        InterestsKt._interests = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

