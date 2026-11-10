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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_help", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Help", "Landroidx/compose/material/icons/Icons$Rounded;", "getHelp$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getHelp", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HelpKt {
    private static ImageVector _help;

    static {
    }

    public static final ImageVector getHelp(Rounded arg19) {
        ImageVector v0 = HelpKt._help;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Help", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.moveTo(13f, 19f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.close();
        v12.moveTo(15.07f, 11.25f);
        v12.lineToRelative(-0.9f, 0.92f);
        v12.curveToRelative(-0.5f, 0.51f, -0.86f, 0.97f, -1.04f, 1.69f);
        v12.curveToRelative(-0.08f, 0.32f, -0.13f, 0.68f, -0.13f, 1.14f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-0.5f);
        v12.curveToRelative(0f, -0.46f, 0.08f, -0.9f, 0.22f, -1.31f);
        v12.curveToRelative(0.2f, -0.58f, 0.53f, -1.1f, 0.95f, -1.52f);
        v12.lineToRelative(1.24f, -1.26f);
        v12.curveToRelative(0.46f, -0.44f, 0.68f, -1.1f, 0.55f, -1.8f);
        v12.curveToRelative(-0.13f, -0.72f, -0.69f, -1.33f, -1.39f, -1.53f);
        v12.curveToRelative(-1.11f, -0.31f, -2.14f, 0.32f, -2.47f, 1.27f);
        v12.curveToRelative(-0.12f, 0.37f, -0.43f, 0.65f, -0.82f, 0.65f);
        v12.horizontalLineToRelative(-0.3f);
        v12.curveTo(8.4f, 9f, 8f, 8.44f, 8.16f, 7.88f);
        v12.curveToRelative(0.43f, -1.47f, 1.68f, -2.59f, 3.23f, -2.83f);
        v12.curveToRelative(1.52f, -0.24f, 2.97f, 0.55f, 3.87f, 1.8f);
        v12.curveToRelative(1.18f, 1.63f, 0.83f, 3.38f, -0.19f, 4.4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HelpKt._help = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Rounded.Help", replaceWith="<_subannotation>") public static void getHelp$annotations(Rounded arg0) {
    }
}

