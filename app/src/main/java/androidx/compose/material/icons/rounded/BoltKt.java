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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_bolt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Bolt", "Landroidx/compose/material/icons/Icons$Rounded;", "getBolt", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BoltKt {
    private static ImageVector _bolt;

    static {
    }

    public static final ImageVector getBolt(Rounded arg19) {
        ImageVector v0 = BoltKt._bolt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Bolt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10.67f, 21f);
        v12.lineTo(10.67f, 21f);
        v12.curveToRelative(-0.35f, 0f, -0.62f, -0.31f, -0.57f, -0.66f);
        v12.lineTo(11f, 14f);
        v12.horizontalLineTo(7.5f);
        v12.curveToRelative(-0.88f, 0f, -0.33f, -0.75f, -0.31f, -0.78f);
        v12.curveToRelative(1.26f, -2.23f, 3.15f, -5.53f, 5.65f, -9.93f);
        v12.curveToRelative(0.1f, -0.18f, 0.3f, -0.29f, 0.5f, -0.29f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.35f, 0f, 0.62f, 0.31f, 0.57f, 0.66f);
        v12.lineTo(13.01f, 10f);
        v12.horizontalLineToRelative(3.51f);
        v12.curveToRelative(0.4f, 0f, 0.62f, 0.19f, 0.4f, 0.66f);
        v12.curveToRelative(-3.29f, 5.74f, -5.2f, 9.09f, -5.75f, 10.05f);
        v12.curveTo(11.07f, 20.889999f, 10.88f, 21f, 10.67f, 21f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BoltKt._bolt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

