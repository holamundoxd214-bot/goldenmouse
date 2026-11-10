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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_mediation", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Mediation", "Landroidx/compose/material/icons/Icons$Rounded;", "getMediation", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MediationKt {
    private static ImageVector _mediation;

    static {
    }

    public static final ImageVector getMediation(Rounded arg19) {
        ImageVector v0 = MediationKt._mediation;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Mediation", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 13f);
        v12.horizontalLineToRelative(-5.06f);
        v12.curveToRelative(-0.34f, 3.1f, -2.26f, 5.72f, -4.94f, 7.05f);
        v12.curveToRelative(-0.03f, 1.81f, -1.66f, 3.23f, -3.55f, 2.9f);
        v12.curveToRelative(-1.2f, -0.21f, -2.19f, -1.2f, -2.4f, -2.4f);
        v12.curveTo(1.71f, 18.65f, 3.16f, 17f, 5f, 17f);
        v12.curveToRelative(0.95f, 0f, 1.78f, 0.45f, 2.33f, 1.14f);
        v12.curveToRelative(1.9f, -1.03f, 3.26f, -2.91f, 3.58f, -5.14f);
        v12.horizontalLineToRelative(-3.1f);
        v12.curveToRelative(-0.48f, 1.34f, -1.86f, 2.24f, -3.42f, 1.94f);
        v12.curveToRelative(-1.18f, -0.23f, -2.13f, -1.2f, -2.35f, -2.38f);
        v12.curveTo(1.7f, 10.66f, 3.16f, 9f, 5f, 9f);
        v12.curveToRelative(1.3f, 0f, 2.4f, 0.84f, 2.82f, 2f);
        v12.horizontalLineToRelative(3.1f);
        v12.curveTo(10.6f, 8.77f, 9.23f, 6.9f, 7.33f, 5.86f);
        v12.curveToRelative(-0.64f, 0.8f, -1.67f, 1.28f, -2.81f, 1.1f);
        v12.curveTo(3.29f, 6.77f, 2.26f, 5.77f, 2.05f, 4.54f);
        v12.curveTo(1.72f, 2.65f, 3.17f, 1f, 5f, 1f);
        v12.curveToRelative(1.64f, 0f, 2.96f, 1.31f, 2.99f, 2.95f);
        v12.curveToRelative(2.68f, 1.33f, 4.6f, 3.95f, 4.94f, 7.05f);
        v12.horizontalLineTo(18f);
        v12.verticalLineTo(9.21f);
        v12.curveToRelative(0f, -0.45f, 0.54f, -0.67f, 0.85f, -0.35f);
        v12.lineToRelative(2.79f, 2.79f);
        v12.curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f);
        v12.lineToRelative(-2.79f, 2.79f);
        v12.curveTo(18.540001f, 15.46f, 18f, 15.24f, 18f, 14.79f);
        v12.verticalLineTo(13f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MediationKt._mediation = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

