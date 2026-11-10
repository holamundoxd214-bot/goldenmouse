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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_peopleAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PeopleAlt", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPeopleAlt", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PeopleAltKt {
    private static ImageVector _peopleAlt;

    static {
    }

    public static final ImageVector getPeopleAlt(TwoTone arg20) {
        ImageVector v0 = PeopleAltKt._peopleAlt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.PeopleAlt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9f, 8f);
        v12.moveToRelative(-2f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, 4f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, -4f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(9f, 15f);
        v12.curveToRelative(-2.7f, 0f, -5.8f, 1.29f, -6f, 2.01f);
        v12.lineTo(3f, 18f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(-1f);
        v12.curveTo(14.8f, 16.290001f, 11.7f, 15f, 9f, 15f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(16.67f, 13.13f);
        v12.curveTo(18.040001f, 14.06f, 19f, 15.32f, 19f, 17f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(-3f);
        v12.curveTo(23f, 14.82f, 19.43f, 13.53f, 16.67f, 13.13f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(15f, 12f);
        v12.curveToRelative(2.21f, 0f, 4f, -1.79f, 4f, -4f);
        v12.curveToRelative(0f, -2.21f, -1.79f, -4f, -4f, -4f);
        v12.curveToRelative(-0.47f, 0f, -0.91f, 0.1f, -1.33f, 0.24f);
        v12.curveTo(14.5f, 5.27f, 15f, 6.58f, 15f, 8f);
        v12.reflectiveCurveToRelative(-0.5f, 2.73f, -1.33f, 3.76f);
        v12.curveTo(14.09f, 11.9f, 14.53f, 12f, 15f, 12f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(9f, 12f);
        v12.curveToRelative(2.21f, 0f, 4f, -1.79f, 4f, -4f);
        v12.curveToRelative(0f, -2.21f, -1.79f, -4f, -4f, -4f);
        v12.reflectiveCurveTo(5f, 5.79f, 5f, 8f);
        v12.curveTo(5f, 10.21f, 6.79f, 12f, 9f, 12f);
        v12.close();
        v12.moveTo(9f, 6f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveTo(7f, 9.1f, 7f, 8f);
        v12.curveTo(7f, 6.9f, 7.9f, 6f, 9f, 6f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(9f, 13f);
        v12.curveToRelative(-2.67f, 0f, -8f, 1.34f, -8f, 4f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineToRelative(-3f);
        v12.curveTo(17f, 14.34f, 11.67f, 13f, 9f, 13f);
        v12.close();
        v12.moveTo(15f, 18f);
        v12.horizontalLineTo(3f);
        v12.lineToRelative(0f, -0.99f);
        v12.curveTo(3.2f, 16.290001f, 6.3f, 15f, 9f, 15f);
        v12.reflectiveCurveToRelative(5.8f, 1.29f, 6f, 2f);
        v12.verticalLineTo(18f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PeopleAltKt._peopleAlt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

