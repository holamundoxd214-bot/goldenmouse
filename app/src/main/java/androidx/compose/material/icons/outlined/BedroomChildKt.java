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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_bedroomChild", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BedroomChild", "Landroidx/compose/material/icons/Icons$Outlined;", "getBedroomChild", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BedroomChildKt {
    private static ImageVector _bedroomChild;

    static {
    }

    public static final ImageVector getBedroomChild(Outlined arg19) {
        ImageVector v0 = BedroomChildKt._bedroomChild;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.BedroomChild", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 4f);
        v12.verticalLineToRelative(16f);
        v12.horizontalLineTo(4f);
        v12.verticalLineTo(4f);
        v12.horizontalLineTo(20f);
        v12.moveTo(20f, 2f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.9f, 2f, 2f, 2.9f, 2f, 4f);
        v12.verticalLineToRelative(16f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(4f);
        v12.curveTo(22f, 2.9f, 21.1f, 2f, 20f, 2f);
        v12.close();
        v12.moveTo(16.5f, 10.67f);
        v12.verticalLineTo(9f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-5f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(1.67f);
        v12.curveToRelative(-0.88f, 0.35f, -1.5f, 1.2f, -1.5f, 2.2f);
        v12.verticalLineTo(17f);
        v12.horizontalLineToRelative(1.5f);
        v12.verticalLineToRelative(-1.5f);
        v12.horizontalLineToRelative(9f);
        v12.verticalLineTo(17f);
        v12.horizontalLineTo(18f);
        v12.verticalLineToRelative(-4.13f);
        v12.curveTo(18f, 11.87f, 17.379999f, 11.02f, 16.5f, 10.67f);
        v12.close();
        v12.moveTo(15f, 8.5f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(15f);
        v12.close();
        v12.moveTo(7.5f, 12.87f);
        v12.curveTo(7.5f, 12.39f, 7.89f, 12f, 8.37f, 12f);
        v12.horizontalLineToRelative(7.27f);
        v12.curveToRelative(0.48f, 0f, 0.87f, 0.39f, 0.87f, 0.87f);
        v12.verticalLineTo(14f);
        v12.horizontalLineToRelative(-9f);
        v12.verticalLineToRelative(-1.13f);
        v12.horizontalLineTo(7.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BedroomChildKt._bedroomChild = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

