package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_handyman", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Handyman", "Landroidx/compose/material/icons/Icons$Filled;", "getHandyman", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HandymanKt {
    private static ImageVector _handyman;

    static {
    }

    public static final ImageVector getHandyman(Filled arg19) {
        ImageVector v0 = HandymanKt._handyman;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Handyman", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.67f, 18.17f);
        v12.lineToRelative(-5.3f, -5.3f);
        v12.horizontalLineToRelative(-0.99f);
        v12.lineToRelative(-2.54f, 2.54f);
        v12.verticalLineToRelative(0.99f);
        v12.lineToRelative(5.3f, 5.3f);
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
        v12.moveTo(17.34f, 10.19f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(2.12f, 2.12f);
        v12.curveToRelative(1.17f, -1.17f, 1.17f, -3.07f, 0f, -4.24f);
        v12.lineToRelative(-3.54f, -3.54f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.verticalLineTo(1.71f);
        v12.lineTo(15.22f, 1f);
        v12.lineToRelative(-3.54f, 3.54f);
        v12.lineToRelative(0.71f, 0.71f);
        v12.horizontalLineToRelative(2.83f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.lineToRelative(1.06f, 1.06f);
        v12.lineToRelative(-2.89f, 2.89f);
        v12.lineTo(7.85f, 6.48f);
        v12.verticalLineTo(5.06f);
        v12.lineTo(4.83f, 2.04f);
        v12.lineTo(2f, 4.87f);
        v12.lineToRelative(3.03f, 3.03f);
        v12.horizontalLineToRelative(1.41f);
        v12.lineToRelative(4.13f, 4.13f);
        v12.lineToRelative(-0.85f, 0.85f);
        v12.horizontalLineTo(7.6f);
        v12.lineToRelative(-5.3f, 5.3f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(2.12f, 2.12f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(5.3f, -5.3f);
        v12.verticalLineToRelative(-2.12f);
        v12.lineToRelative(5.15f, -5.15f);
        v12.lineTo(17.34f, 10.19f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HandymanKt._handyman = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

