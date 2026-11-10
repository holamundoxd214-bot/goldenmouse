package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_burstMode", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BurstMode", "Landroidx/compose/material/icons/Icons$TwoTone;", "getBurstMode", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BurstModeKt {
    private static ImageVector _burstMode;

    static {
    }

    public static final ImageVector getBurstMode(TwoTone arg19) {
        ImageVector v0 = BurstModeKt._burstMode;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.BurstMode", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(11f, 17f);
        v0_1.horizontalLineToRelative(10f);
        v0_1.lineTo(21f, 7f);
        v0_1.lineTo(11f, 7f);
        v0_1.verticalLineToRelative(10f);
        v0_1.close();
        v0_1.moveTo(14f, 13.47f);
        v0_1.lineToRelative(1.43f, 1.72f);
        v0_1.lineToRelative(2f, -2.58f);
        v0_1.lineTo(20f, 15.99f);
        v0_1.horizontalLineToRelative(-8f);
        v0_1.lineToRelative(2f, -2.52f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(1f, 5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(14f);
        v12.lineTo(1f, 19f);
        v12.close();
        v12.moveTo(5f, 5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(14f);
        v12.lineTo(5f, 19f);
        v12.close();
        v12.moveTo(22f, 5f);
        v12.lineTo(10f, 5f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.lineTo(23f, 6f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.close();
        v12.moveTo(21f, 17f);
        v12.lineTo(11f, 17f);
        v12.lineTo(11f, 7f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(10f);
        v12.close();
        v12.moveTo(17.43f, 12.62f);
        v12.lineToRelative(-2f, 2.57f);
        v12.lineTo(14f, 13.47f);
        v12.lineToRelative(-2f, 2.52f);
        v12.horizontalLineToRelative(8f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BurstModeKt._burstMode = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

