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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_eco", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Eco", "Landroidx/compose/material/icons/Icons$Outlined;", "getEco", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EcoKt {
    private static ImageVector _eco;

    static {
    }

    public static final ImageVector getEco(Outlined arg19) {
        ImageVector v0 = EcoKt._eco;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Eco", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6.05f, 8.05f);
        v12.curveToRelative(-2.73f, 2.73f, -2.73f, 7.17f, 0f, 9.9f);
        v12.curveTo(7.42f, 19.32f, 9.21f, 20f, 11f, 20f);
        v12.reflectiveCurveToRelative(3.58f, -0.68f, 4.95f, -2.05f);
        v12.curveTo(19.43f, 14.47f, 20f, 4f, 20f, 4f);
        v12.reflectiveCurveTo(9.53f, 4.57f, 6.05f, 8.05f);
        v12.close();
        v12.moveTo(14.54f, 16.540001f);
        v12.curveTo(13.59f, 17.48f, 12.34f, 18f, 11f, 18f);
        v12.curveToRelative(-0.89f, 0f, -1.73f, -0.25f, -2.48f, -0.68f);
        v12.curveToRelative(0.92f, -2.88f, 2.62f, -5.41f, 4.88f, -7.32f);
        v12.curveToRelative(-2.63f, 1.36f, -4.84f, 3.46f, -6.37f, 6f);
        v12.curveToRelative(-1.48f, -1.96f, -1.35f, -4.75f, 0.44f, -6.54f);
        v12.curveTo(9.21f, 7.72f, 14.04f, 6.65f, 17.799999f, 6.2f);
        v12.curveTo(17.35f, 9.96f, 16.280001f, 14.79f, 14.54f, 16.540001f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EcoKt._eco = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

