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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_female", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Female", "Landroidx/compose/material/icons/Icons$TwoTone;", "getFemale", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FemaleKt {
    private static ImageVector _female;

    static {
    }

    public static final ImageVector getFemale(TwoTone arg19) {
        ImageVector v0 = FemaleKt._female;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Female", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.5f, 9.5f);
        v12.curveTo(17.5f, 6.46f, 15.04f, 4f, 12f, 4f);
        v12.reflectiveCurveTo(6.5f, 6.46f, 6.5f, 9.5f);
        v12.curveToRelative(0f, 2.7f, 1.94f, 4.93f, 4.5f, 5.4f);
        v12.verticalLineTo(17f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-2.1f);
        v12.curveTo(15.56f, 14.43f, 17.5f, 12.2f, 17.5f, 9.5f);
        v12.close();
        v12.moveTo(8.5f, 9.5f);
        v12.curveTo(8.5f, 7.57f, 10.07f, 6f, 12f, 6f);
        v12.reflectiveCurveToRelative(3.5f, 1.57f, 3.5f, 3.5f);
        v12.reflectiveCurveTo(13.93f, 13f, 12f, 13f);
        v12.reflectiveCurveTo(8.5f, 11.43f, 8.5f, 9.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FemaleKt._female = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

