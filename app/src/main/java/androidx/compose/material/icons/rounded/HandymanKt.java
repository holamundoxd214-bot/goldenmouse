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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_handyman", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Handyman", "Landroidx/compose/material/icons/Icons$Rounded;", "getHandyman", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HandymanKt {
    private static ImageVector _handyman;

    static {
    }

    public static final ImageVector getHandyman(Rounded arg19) {
        ImageVector v0 = HandymanKt._handyman;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Handyman", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.67f, 18.17f);
        v12.lineToRelative(-4.72f, -4.72f);
        v12.curveToRelative(-0.48f, -0.48f, -0.99f, -0.59f, -1.58f, -0.59f);
        v12.lineToRelative(-2.54f, 2.54f);
        v12.curveToRelative(0f, 0.59f, 0.11f, 1.11f, 0.59f, 1.58f);
        v12.lineToRelative(4.72f, 4.72f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(2.12f, -2.12f);
        v12.curveTo(22.059999f, 19.200001f, 22.059999f, 18.559999f, 21.67f, 18.17f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(16.629999f, 9.49f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(0.71f, -0.71f);
        v12.lineToRelative(2.12f, 2.12f);
        v12.curveToRelative(1.17f, -1.17f, 1.17f, -3.07f, 0f, -4.24f);
        v12.lineToRelative(-2.83f, -2.83f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineToRelative(-0.71f, 0.71f);
        v12.verticalLineTo(2f);
        v12.curveToRelative(0f, -0.62f, -0.76f, -0.95f, -1.21f, -0.5f);
        v12.lineToRelative(-2.54f, 2.54f);
        v12.curveToRelative(-0.45f, 0.45f, -0.12f, 1.21f, 0.5f, 1.21f);
        v12.horizontalLineToRelative(2.54f);
        v12.lineToRelative(-0.71f, 0.71f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(0.35f, 0.35f);
        v12.lineToRelative(-2.89f, 2.89f);
        v12.lineTo(7.85f, 6.48f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(0f, -0.27f, -0.11f, -0.52f, -0.29f, -0.71f);
        v12.lineTo(5.54f, 2.74f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineTo(2.71f, 4.16f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineTo(4.73f, 7.6f);
        v12.curveToRelative(0.19f, 0.19f, 0.44f, 0.29f, 0.71f, 0.29f);
        v12.horizontalLineToRelative(1f);
        v12.lineToRelative(4.13f, 4.13f);
        v12.lineToRelative(-0.85f, 0.85f);
        v12.horizontalLineTo(8.42f);
        v12.curveToRelative(-0.53f, 0f, -1.04f, 0.21f, -1.41f, 0.59f);
        v12.lineToRelative(-4.72f, 4.72f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(2.12f, 2.12f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(4.72f, -4.72f);
        v12.curveToRelative(0.38f, -0.38f, 0.59f, -0.88f, 0.59f, -1.41f);
        v12.verticalLineToRelative(-1.29f);
        v12.lineToRelative(5.15f, -5.15f);
        v12.lineTo(16.629999f, 9.49f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HandymanKt._handyman = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

