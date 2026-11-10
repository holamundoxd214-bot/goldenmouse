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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_micExternalOn", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MicExternalOn", "Landroidx/compose/material/icons/Icons$Rounded;", "getMicExternalOn", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MicExternalOnKt {
    private static ImageVector _micExternalOn;

    static {
    }

    public static final ImageVector getMicExternalOn(Rounded arg19) {
        ImageVector v0 = MicExternalOnKt._micExternalOn;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.MicExternalOn", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9.22f, 7f);
        v12.horizontalLineTo(4.78f);
        v12.curveTo(4.3f, 6.47f, 4f, 5.77f, 4f, 5f);
        v12.curveToRelative(0f, -1.66f, 1.34f, -3f, 3f, -3f);
        v12.reflectiveCurveToRelative(3f, 1.34f, 3f, 3f);
        v12.curveTo(10f, 5.77f, 9.7f, 6.47f, 9.22f, 7f);
        v12.close();
        v12.moveTo(16.24f, 2.01f);
        v12.curveTo(18.32f, 2.13f, 20f, 4.08f, 20f, 6.16f);
        v12.lineTo(20f, 21f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.lineToRelative(0f, -14.91f);
        v12.curveToRelative(0f, -0.96f, -0.64f, -1.86f, -1.58f, -2.05f);
        v12.curveTo(15.14f, 3.78f, 14f, 4.76f, 14f, 6f);
        v12.lineToRelative(0f, 11.84f);
        v12.curveToRelative(0f, 2.08f, -1.68f, 4.03f, -3.76f, 4.15f);
        v12.curveTo(7.92f, 22.129999f, 6f, 20.290001f, 6f, 18f);
        v12.horizontalLineTo(5.45f);
        v12.curveToRelative(-0.26f, 0f, -0.47f, -0.19f, -0.5f, -0.45f);
        v12.lineTo(4.11f, 9.1f);
        v12.curveTo(4.05f, 8.51f, 4.51f, 8f, 5.1f, 8f);
        v12.horizontalLineTo(8.9f);
        v12.curveToRelative(0.59f, 0f, 1.05f, 0.51f, 1f, 1.1f);
        v12.lineToRelative(-0.85f, 8.45f);
        v12.curveTo(9.02f, 17.809999f, 8.8f, 18f, 8.55f, 18f);
        v12.horizontalLineTo(8f);
        v12.curveToRelative(0f, 1.24f, 1.14f, 2.22f, 2.42f, 1.96f);
        v12.curveToRelative(0.94f, -0.19f, 1.58f, -1.09f, 1.58f, -2.05f);
        v12.lineTo(12f, 6f);
        v12.curveTo(12f, 3.71f, 13.92f, 1.87f, 16.24f, 2.01f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MicExternalOnKt._micExternalOn = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

