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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_tapAndPlay", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TapAndPlay", "Landroidx/compose/material/icons/Icons$Rounded;", "getTapAndPlay", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TapAndPlayKt {
    private static ImageVector _tapAndPlay;

    static {
    }

    public static final ImageVector getTapAndPlay(Rounded arg19) {
        ImageVector v0 = TapAndPlayKt._tapAndPlay;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.TapAndPlay", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(3.14f, 16.09f);
        v12.curveToRelative(-0.6f, -0.1f, -1.14f, 0.39f, -1.14f, 1f);
        v12.curveToRelative(0f, 0.49f, 0.36f, 0.9f, 0.85f, 0.98f);
        v12.curveToRelative(2.08f, 0.36f, 3.72f, 2f, 4.08f, 4.08f);
        v12.curveToRelative(0.08f, 0.49f, 0.49f, 0.85f, 0.98f, 0.85f);
        v12.curveToRelative(0.61f, 0f, 1.09f, -0.54f, 1f, -1.14f);
        v12.curveToRelative(-0.48f, -2.95f, -2.81f, -5.29f, -5.77f, -5.77f);
        v12.close();
        v12.moveTo(2f, 20f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0f, -1.66f, -1.34f, -3f, -3f, -3f);
        v12.close();
        v12.moveTo(3.11f, 12.06f);
        v12.curveToRelative(-0.59f, -0.06f, -1.11f, 0.4f, -1.11f, 0.99f);
        v12.curveToRelative(0f, 0.5f, 0.37f, 0.94f, 0.87f, 0.99f);
        v12.curveToRelative(4.27f, 0.41f, 7.67f, 3.81f, 8.08f, 8.08f);
        v12.curveToRelative(0.05f, 0.5f, 0.48f, 0.88f, 0.99f, 0.88f);
        v12.curveToRelative(0.59f, 0f, 1.06f, -0.51f, 1f, -1.1f);
        v12.curveToRelative(-0.51f, -5.2f, -4.63f, -9.32f, -9.83f, -9.84f);
        v12.close();
        v12.moveTo(17f, 1.01f);
        v12.lineTo(7f, 1f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(7.37f);
        v12.curveToRelative(0.69f, 0.16f, 1.36f, 0.37f, 2f, 0.64f);
        v12.lineTo(7f, 5f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(13f);
        v12.horizontalLineToRelative(-3.03f);
        v12.curveToRelative(0.52f, 1.25f, 0.84f, 2.59f, 0.95f, 4f);
        v12.lineTo(17f, 22f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(19f, 3f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -1.99f, -2f, -1.99f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TapAndPlayKt._tapAndPlay = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

