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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_liveHelp", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LiveHelp", "Landroidx/compose/material/icons/Icons$Rounded;", "getLiveHelp$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getLiveHelp", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LiveHelpKt {
    private static ImageVector _liveHelp;

    static {
    }

    public static final ImageVector getLiveHelp(Rounded arg19) {
        ImageVector v0 = LiveHelpKt._liveHelp;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.LiveHelp", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 2f);
        v12.lineTo(5f, 2f);
        v12.curveToRelative(-1.11f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(4f);
        v12.lineToRelative(2.29f, 2.29f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineTo(15f, 20f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(21f, 4f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(13f, 18f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.close();
        v12.moveTo(15.07f, 10.25f);
        v12.lineToRelative(-0.9f, 0.92f);
        v12.curveToRelative(-0.58f, 0.59f, -0.99f, 1.1f, -1.12f, 2.06f);
        v12.curveToRelative(-0.06f, 0.43f, -0.41f, 0.76f, -0.85f, 0.76f);
        v12.horizontalLineToRelative(-0.31f);
        v12.curveToRelative(-0.52f, 0f, -0.92f, -0.46f, -0.85f, -0.98f);
        v12.curveToRelative(0.11f, -0.91f, 0.53f, -1.72f, 1.14f, -2.34f);
        v12.lineToRelative(1.24f, -1.26f);
        v12.curveToRelative(0.36f, -0.36f, 0.58f, -0.86f, 0.58f, -1.41f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.curveToRelative(-0.87f, 0f, -1.62f, 0.57f, -1.89f, 1.35f);
        v12.curveToRelative(-0.13f, 0.37f, -0.44f, 0.64f, -0.83f, 0.64f);
        v12.horizontalLineToRelative(-0.3f);
        v12.curveToRelative(-0.58f, 0f, -0.98f, -0.56f, -0.82f, -1.12f);
        v12.curveTo(8.65f, 5.21f, 10.18f, 4f, 12f, 4f);
        v12.curveToRelative(2.21f, 0f, 4f, 1.79f, 4f, 4f);
        v12.curveToRelative(0f, 0.88f, -0.36f, 1.68f, -0.93f, 2.25f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LiveHelpKt._liveHelp = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Rounded.LiveHelp", replaceWith="<_subannotation>") public static void getLiveHelp$annotations(Rounded arg0) {
    }
}

