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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_helpOutline", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HelpOutline", "Landroidx/compose/material/icons/Icons$Rounded;", "getHelpOutline$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getHelpOutline", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HelpOutlineKt {
    private static ImageVector _helpOutline;

    static {
    }

    public static final ImageVector getHelpOutline(Rounded arg19) {
        ImageVector v0 = HelpOutlineKt._helpOutline;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.HelpOutline", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.reflectiveCurveTo(17.52f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-4.41f, 0f, -8f, -3.59f, -8f, -8f);
        v12.reflectiveCurveToRelative(3.59f, -8f, 8f, -8f);
        v12.reflectiveCurveToRelative(8f, 3.59f, 8f, 8f);
        v12.reflectiveCurveToRelative(-3.59f, 8f, -8f, 8f);
        v12.close();
        v12.moveTo(11f, 16f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-2f);
        v12.close();
        v12.moveTo(12.61f, 6.04f);
        v12.curveToRelative(-2.06f, -0.3f, -3.88f, 0.97f, -4.43f, 2.79f);
        v12.curveToRelative(-0.18f, 0.58f, 0.26f, 1.17f, 0.87f, 1.17f);
        v12.horizontalLineToRelative(0.2f);
        v12.curveToRelative(0.41f, 0f, 0.74f, -0.29f, 0.88f, -0.67f);
        v12.curveToRelative(0.32f, -0.89f, 1.27f, -1.5f, 2.3f, -1.28f);
        v12.curveToRelative(0.95f, 0.2f, 1.65f, 1.13f, 1.57f, 2.1f);
        v12.curveToRelative(-0.1f, 1.34f, -1.62f, 1.63f, -2.45f, 2.88f);
        v12.curveToRelative(0f, 0.01f, -0.01f, 0.01f, -0.01f, 0.02f);
        v12.curveToRelative(-0.01f, 0.02f, -0.02f, 0.03f, -0.03f, 0.05f);
        v12.curveToRelative(-0.09f, 0.15f, -0.18f, 0.32f, -0.25f, 0.5f);
        v12.curveToRelative(-0.01f, 0.03f, -0.03f, 0.05f, -0.04f, 0.08f);
        v12.curveToRelative(-0.01f, 0.02f, -0.01f, 0.04f, -0.02f, 0.07f);
        v12.curveToRelative(-0.12f, 0.34f, -0.2f, 0.75f, -0.2f, 1.25f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0f, -0.42f, 0.11f, -0.77f, 0.28f, -1.07f);
        v12.curveToRelative(0.02f, -0.03f, 0.03f, -0.06f, 0.05f, -0.09f);
        v12.curveToRelative(0.08f, -0.14f, 0.18f, -0.27f, 0.28f, -0.39f);
        v12.curveToRelative(0.01f, -0.01f, 0.02f, -0.03f, 0.03f, -0.04f);
        v12.curveToRelative(0.1f, -0.12f, 0.21f, -0.23f, 0.33f, -0.34f);
        v12.curveToRelative(0.96f, -0.91f, 2.26f, -1.65f, 1.99f, -3.56f);
        v12.curveToRelative(-0.24f, -1.74f, -1.61f, -3.21f, -3.35f, -3.47f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HelpOutlineKt._helpOutline = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Rounded.HelpOutline", replaceWith="<_subannotation>") public static void getHelpOutline$annotations(Rounded arg0) {
    }
}

