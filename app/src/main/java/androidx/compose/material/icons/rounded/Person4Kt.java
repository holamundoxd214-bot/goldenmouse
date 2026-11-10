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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_person4", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Person4", "Landroidx/compose/material/icons/Icons$Rounded;", "getPerson4", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class Person4Kt {
    private static ImageVector _person4;

    static {
    }

    public static final ImageVector getPerson4(Rounded arg19) {
        ImageVector v0 = Person4Kt._person4;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Person4", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.389999f, 14.56f);
        v12.curveTo(16.709999f, 13.7f, 14.53f, 13f, 12f, 13f);
        v12.curveToRelative(-2.53f, 0f, -4.71f, 0.7f, -6.39f, 1.56f);
        v12.curveTo(4.61f, 15.07f, 4f, 16.1f, 4f, 17.219999f);
        v12.lineTo(4f, 18f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineToRelative(0f, -0.78f);
        v12.curveTo(20f, 16.1f, 19.389999f, 15.07f, 18.389999f, 14.56f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 12f);
        v12.curveToRelative(2.21f, 0f, 4f, -1.79f, 4f, -4f);
        v12.curveToRelative(0f, -1.37f, 0f, -3.5f, 0f, -3.5f);
        v12.curveTo(16f, 3.67f, 15.33f, 3f, 14.5f, 3f);
        v12.curveToRelative(-0.52f, 0f, -0.98f, 0.27f, -1.25f, 0.67f);
        v12.curveTo(12.98f, 3.27f, 12.52f, 3f, 12f, 3f);
        v12.reflectiveCurveToRelative(-0.98f, 0.27f, -1.25f, 0.67f);
        v12.curveTo(10.48f, 3.27f, 10.02f, 3f, 9.5f, 3f);
        v12.curveTo(8.67f, 3f, 8f, 3.67f, 8f, 4.5f);
        v12.curveToRelative(0f, 0f, 0f, 2.12f, 0f, 3.5f);
        v12.curveTo(8f, 10.21f, 9.79f, 12f, 12f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        Person4Kt._person4 = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

