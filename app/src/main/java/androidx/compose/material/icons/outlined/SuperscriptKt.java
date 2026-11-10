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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_superscript", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Superscript", "Landroidx/compose/material/icons/Icons$Outlined;", "getSuperscript", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SuperscriptKt {
    private static ImageVector _superscript;

    static {
    }

    public static final ImageVector getSuperscript(Outlined arg19) {
        ImageVector v0 = SuperscriptKt._superscript;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Superscript", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 7f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineTo(7f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(1f);
        v12.curveTo(23f, 6.55f, 22.549999f, 7f, 22f, 7f);
        v12.close();
        v12.moveTo(5.88f, 20f);
        v12.horizontalLineToRelative(2.66f);
        v12.lineToRelative(3.4f, -5.42f);
        v12.horizontalLineToRelative(0.12f);
        v12.lineToRelative(3.4f, 5.42f);
        v12.horizontalLineToRelative(2.66f);
        v12.lineToRelative(-4.65f, -7.27f);
        v12.lineTo(17.809999f, 6f);
        v12.horizontalLineToRelative(-2.68f);
        v12.lineToRelative(-3.07f, 4.99f);
        v12.horizontalLineToRelative(-0.12f);
        v12.lineTo(8.85f, 6f);
        v12.horizontalLineTo(6.19f);
        v12.lineToRelative(4.32f, 6.73f);
        v12.lineTo(5.88f, 20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SuperscriptKt._superscript = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

