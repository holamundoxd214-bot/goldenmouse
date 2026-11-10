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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wbIridescent", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WbIridescent", "Landroidx/compose/material/icons/Icons$Outlined;", "getWbIridescent", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WbIridescentKt {
    private static ImageVector _wbIridescent;

    static {
    }

    public static final ImageVector getWbIridescent(Outlined arg18) {
        ImageVector v0 = WbIridescentKt._wbIridescent;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.WbIridescent", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(5f, 15f);
        v0_1.horizontalLineToRelative(14f);
        v0_1.lineTo(19f, 9f);
        v0_1.lineTo(5f, 9f);
        v0_1.verticalLineToRelative(6f);
        v0_1.close();
        v0_1.moveTo(7f, 11f);
        v0_1.horizontalLineToRelative(10f);
        v0_1.verticalLineToRelative(2f);
        v0_1.lineTo(7f, 13f);
        v0_1.verticalLineToRelative(-2f);
        v0_1.close();
        v0_1.moveTo(11f, 1f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.verticalLineToRelative(3f);
        v0_1.horizontalLineToRelative(-2f);
        v0_1.close();
        v0_1.moveTo(20.459999f, 5.01f);
        v0_1.lineTo(19.040001f, 3.6f);
        v0_1.lineToRelative(-1.79f, 1.79f);
        v0_1.lineToRelative(1.41f, 1.41f);
        v0_1.close();
        v0_1.moveTo(11f, 20f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.verticalLineToRelative(3f);
        v0_1.horizontalLineToRelative(-2f);
        v0_1.close();
        v0_1.moveTo(17.24f, 18.709999f);
        v0_1.lineToRelative(1.79f, 1.8f);
        v0_1.lineToRelative(1.42f, -1.42f);
        v0_1.lineToRelative(-1.8f, -1.79f);
        v0_1.close();
        v0_1.moveTo(4.96f, 3.595f);
        v0_1.lineToRelative(1.788f, 1.79f);
        v0_1.lineTo(5.34f, 6.79f);
        v0_1.lineTo(3.553f, 5.003f);
        v0_1.close();
        v0_1.moveTo(3.55f, 19.08f);
        v0_1.lineToRelative(1.41f, 1.42f);
        v0_1.lineToRelative(1.79f, -1.8f);
        v0_1.lineToRelative(-1.41f, -1.41f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WbIridescentKt._wbIridescent = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

