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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_escalatorWarning", "Landroidx/compose/ui/graphics/vector/ImageVector;", "EscalatorWarning", "Landroidx/compose/material/icons/Icons$TwoTone;", "getEscalatorWarning", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EscalatorWarningKt {
    private static ImageVector _escalatorWarning;

    static {
    }

    public static final ImageVector getEscalatorWarning(TwoTone arg19) {
        ImageVector v0 = EscalatorWarningKt._escalatorWarning;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.EscalatorWarning", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6.5f, 2f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.reflectiveCurveToRelative(-0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f);
        v12.reflectiveCurveTo(5.4f, 2f, 6.5f, 2f);
        v12.close();
        v12.moveTo(15.5f, 9.5f);
        v12.curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f);
        v12.reflectiveCurveToRelative(1.5f, -0.67f, 1.5f, -1.5f);
        v12.reflectiveCurveTo(17.83f, 8f, 17f, 8f);
        v12.reflectiveCurveTo(15.5f, 8.67f, 15.5f, 9.5f);
        v12.close();
        v12.moveTo(18.5f, 12f);
        v12.horizontalLineToRelative(-2.84f);
        v12.curveToRelative(-0.58f, 0.01f, -1.14f, 0.32f, -1.45f, 0.86f);
        v12.lineToRelative(-0.92f, 1.32f);
        v12.lineTo(9.72f, 8f);
        v12.curveTo(9.35f, 7.37f, 8.69f, 7.01f, 8.01f, 7f);
        v12.horizontalLineTo(5f);
        v12.curveTo(3.9f, 7f, 3f, 7.9f, 3f, 9f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(1.5f);
        v12.verticalLineToRelative(7f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineTo(11.61f);
        v12.lineTo(12.03f, 16f);
        v12.horizontalLineToRelative(2.2f);
        v12.lineTo(15f, 14.9f);
        v12.verticalLineTo(22f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(-5f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(-3.5f);
        v12.curveTo(20f, 12.68f, 19.33f, 12f, 18.5f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EscalatorWarningKt._escalatorWarning = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

