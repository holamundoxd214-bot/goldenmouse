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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_iron", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Iron", "Landroidx/compose/material/icons/Icons$Rounded;", "getIron", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class IronKt {
    private static ImageVector _iron;

    static {
    }

    public static final ImageVector getIron(Rounded arg19) {
        ImageVector v0 = IronKt._iron;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Iron", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8.27f, 10f);
        v12.curveToRelative(0.34f, 0f, 0.68f, -0.16f, 0.84f, -0.47f);
        v12.curveTo(9.28f, 9.22f, 9.62f, 9f, 10f, 9f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineTo(6f);
        v12.curveToRelative(-2.21f, 0f, -4f, 1.79f, -4f, 4f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(13f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(1.66f, 0f, 3f, -1.34f, 3f, -3f);
        v12.verticalLineTo(9f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-1.66f, 0f, -3f, 1.34f, -3f, 3f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.verticalLineToRelative(-4f);
        v12.curveToRelative(0f, -1.66f, -1.34f, -3f, -3f, -3f);
        v12.horizontalLineToRelative(-4f);
        v12.curveTo(8.87f, 7f, 7.89f, 7.62f, 7.37f, 8.55f);
        v12.curveTo(7.01f, 9.2f, 7.53f, 10f, 8.27f, 10f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        IronKt._iron = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

