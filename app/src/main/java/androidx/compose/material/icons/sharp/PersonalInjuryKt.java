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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_personalInjury", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PersonalInjury", "Landroidx/compose/material/icons/Icons$Sharp;", "getPersonalInjury", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PersonalInjuryKt {
    private static ImageVector _personalInjury;

    static {
    }

    public static final ImageVector getPersonalInjury(Sharp arg19) {
        ImageVector v0 = PersonalInjuryKt._personalInjury;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.PersonalInjury", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8f, 6f);
        v12.curveToRelative(0f, -2.21f, 1.79f, -4f, 4f, -4f);
        v12.reflectiveCurveToRelative(4f, 1.79f, 4f, 4f);
        v12.curveToRelative(0f, 2.21f, -1.79f, 4f, -4f, 4f);
        v12.reflectiveCurveTo(8f, 8.21f, 8f, 6f);
        v12.close();
        v12.moveTo(17f, 22f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineToRelative(0f, -4.78f);
        v12.curveToRelative(0f, -1.12f, -0.61f, -2.15f, -1.61f, -2.66f);
        v12.curveToRelative(-0.43f, -0.22f, -0.9f, -0.43f, -1.39f, -0.62f);
        v12.lineTo(17f, 22f);
        v12.close();
        v12.moveTo(12.34f, 17f);
        v12.lineTo(15f, 11.33f);
        v12.curveTo(14.07f, 11.12f, 13.07f, 11f, 12f, 11f);
        v12.curveToRelative(-2.53f, 0f, -4.71f, 0.7f, -6.39f, 1.56f);
        v12.curveTo(4.61f, 13.07f, 4f, 14.1f, 4f, 15.22f);
        v12.lineTo(4f, 22f);
        v12.horizontalLineToRelative(2.34f);
        v12.curveTo(6.12f, 21.549999f, 6f, 21.040001f, 6f, 20.5f);
        v12.curveTo(6f, 18.57f, 7.57f, 17f, 9.5f, 17f);
        v12.horizontalLineTo(12.34f);
        v12.close();
        v12.moveTo(10f, 22f);
        v12.lineToRelative(1.41f, -3f);
        v12.horizontalLineTo(9.5f);
        v12.curveTo(8.67f, 19f, 8f, 19.67f, 8f, 20.5f);
        v12.reflectiveCurveTo(8.67f, 22f, 9.5f, 22f);
        v12.horizontalLineTo(10f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PersonalInjuryKt._personalInjury = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

