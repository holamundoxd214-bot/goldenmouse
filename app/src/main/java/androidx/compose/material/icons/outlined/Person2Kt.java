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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_person2", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Person2", "Landroidx/compose/material/icons/Icons$Outlined;", "getPerson2", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class Person2Kt {
    private static ImageVector _person2;

    static {
    }

    public static final ImageVector getPerson2(Outlined arg19) {
        ImageVector v0 = Person2Kt._person2;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Person2", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.389999f, 14.56f);
        v12.curveTo(16.709999f, 13.7f, 14.53f, 13f, 12f, 13f);
        v12.curveToRelative(-2.53f, 0f, -4.71f, 0.7f, -6.39f, 1.56f);
        v12.curveTo(4.61f, 15.07f, 4f, 16.1f, 4f, 17.219999f);
        v12.verticalLineTo(20f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineToRelative(-2.78f);
        v12.curveTo(20f, 16.1f, 19.389999f, 15.07f, 18.389999f, 14.56f);
        v12.close();
        v12.moveTo(18f, 18f);
        v12.horizontalLineTo(6f);
        v12.verticalLineToRelative(-0.78f);
        v12.curveToRelative(0f, -0.38f, 0.2f, -0.72f, 0.52f, -0.88f);
        v12.curveTo(7.71f, 15.73f, 9.63f, 15f, 12f, 15f);
        v12.curveToRelative(2.37f, 0f, 4.29f, 0.73f, 5.48f, 1.34f);
        v12.curveTo(17.799999f, 16.5f, 18f, 16.84f, 18f, 17.219999f);
        v12.verticalLineTo(18f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(9.78f, 12f);
        v12.horizontalLineToRelative(4.44f);
        v12.curveToRelative(1.21f, 0f, 2.14f, -1.06f, 1.98f, -2.26f);
        v12.lineToRelative(-0.32f, -2.45f);
        v12.curveTo(15.57f, 5.39f, 13.92f, 4f, 12f, 4f);
        v12.reflectiveCurveTo(8.43f, 5.39f, 8.12f, 7.29f);
        v12.lineTo(7.8f, 9.74f);
        v12.curveTo(7.64f, 10.94f, 8.57f, 12f, 9.78f, 12f);
        v12.close();
        v12.moveTo(10.1f, 7.59f);
        v12.curveTo(10.26f, 6.67f, 11.06f, 6f, 12f, 6f);
        v12.reflectiveCurveToRelative(1.74f, 0.67f, 1.9f, 1.59f);
        v12.lineTo(14.22f, 10f);
        v12.horizontalLineTo(9.78f);
        v12.lineTo(10.1f, 7.59f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        Person2Kt._person2 = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

