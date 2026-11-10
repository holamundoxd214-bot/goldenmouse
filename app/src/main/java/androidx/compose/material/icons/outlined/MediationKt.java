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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_mediation", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Mediation", "Landroidx/compose/material/icons/Icons$Outlined;", "getMediation", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MediationKt {
    private static ImageVector _mediation;

    static {
    }

    public static final ImageVector getMediation(Outlined arg19) {
        ImageVector v0 = MediationKt._mediation;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Mediation", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 16f);
        v12.lineToRelative(4f, -4f);
        v12.lineToRelative(-4f, -4f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(-5.06f);
        v12.curveToRelative(-0.34f, -3.1f, -2.26f, -5.72f, -4.94f, -7.05f);
        v12.curveTo(7.96f, 2.31f, 6.64f, 1f, 5f, 1f);
        v12.curveTo(3.34f, 1f, 2f, 2.34f, 2f, 4f);
        v12.reflectiveCurveToRelative(1.34f, 3f, 3f, 3f);
        v12.curveToRelative(0.95f, 0f, 1.78f, -0.45f, 2.33f, -1.14f);
        v12.curveTo(9.23f, 6.9f, 10.6f, 8.77f, 10.92f, 11f);
        v12.horizontalLineToRelative(-3.1f);
        v12.curveTo(7.4f, 9.84f, 6.3f, 9f, 5f, 9f);
        v12.curveToRelative(-1.66f, 0f, -3f, 1.34f, -3f, 3f);
        v12.reflectiveCurveToRelative(1.34f, 3f, 3f, 3f);
        v12.curveToRelative(1.3f, 0f, 2.4f, -0.84f, 2.82f, -2f);
        v12.horizontalLineToRelative(3.1f);
        v12.curveToRelative(-0.32f, 2.23f, -1.69f, 4.1f, -3.58f, 5.14f);
        v12.curveTo(6.78f, 17.450001f, 5.95f, 17f, 5f, 17f);
        v12.curveToRelative(-1.66f, 0f, -3f, 1.34f, -3f, 3f);
        v12.reflectiveCurveToRelative(1.34f, 3f, 3f, 3f);
        v12.curveToRelative(1.64f, 0f, 2.96f, -1.31f, 2.99f, -2.95f);
        v12.curveToRelative(2.68f, -1.33f, 4.6f, -3.95f, 4.94f, -7.05f);
        v12.horizontalLineTo(18f);
        v12.verticalLineTo(16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MediationKt._mediation = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

