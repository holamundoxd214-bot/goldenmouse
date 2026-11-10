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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_familyRestroom", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FamilyRestroom", "Landroidx/compose/material/icons/Icons$Sharp;", "getFamilyRestroom", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FamilyRestroomKt {
    private static ImageVector _familyRestroom;

    static {
    }

    public static final ImageVector getFamilyRestroom(Sharp arg20) {
        ImageVector v0 = FamilyRestroomKt._familyRestroom;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.FamilyRestroom", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 4f);
        v12.curveToRelative(0f, -1.11f, 0.89f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.89f, 2f, 2f);
        v12.reflectiveCurveToRelative(-0.89f, 2f, -2f, 2f);
        v12.reflectiveCurveTo(16f, 5.11f, 16f, 4f);
        v12.close();
        v12.moveTo(20f, 22f);
        v12.verticalLineToRelative(-6f);
        v12.horizontalLineToRelative(2.5f);
        v12.lineToRelative(-3f, -9f);
        v12.lineToRelative(-3f, 0f);
        v12.lineToRelative(-1.17f, 3.5f);
        v12.horizontalLineTo(17f);
        v12.verticalLineTo(22f);
        v12.horizontalLineTo(20f);
        v12.close();
        v12.moveTo(12.5f, 11.5f);
        v12.curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(-0.67f, -1.5f, -1.5f, -1.5f);
        v12.reflectiveCurveTo(11f, 9.17f, 11f, 10f);
        v12.reflectiveCurveTo(11.67f, 11.5f, 12.5f, 11.5f);
        v12.close();
        v12.moveTo(5.5f, 6f);
        v12.curveToRelative(1.11f, 0f, 2f, -0.89f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.89f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.89f, -2f, 2f);
        v12.reflectiveCurveTo(4.39f, 6f, 5.5f, 6f);
        v12.close();
        v12.moveTo(7.5f, 22f);
        v12.verticalLineToRelative(-7f);
        v12.horizontalLineTo(9f);
        v12.verticalLineTo(7f);
        v12.horizontalLineTo(2f);
        v12.verticalLineToRelative(8f);
        v12.horizontalLineToRelative(1.5f);
        v12.verticalLineToRelative(7f);
        v12.horizontalLineTo(7.5f);
        v12.close();
        v12.moveTo(14f, 22f);
        v12.verticalLineToRelative(-4f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(-5.5f);
        v12.horizontalLineToRelative(-5f);
        v12.verticalLineTo(18f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineTo(14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FamilyRestroomKt._familyRestroom = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

