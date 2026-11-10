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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_abc", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Abc", "Landroidx/compose/material/icons/Icons$Outlined;", "getAbc", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AbcKt {
    private static ImageVector _abc;

    static {
    }

    public static final ImageVector getAbc(Outlined arg19) {
        ImageVector v0 = AbcKt._abc;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Abc", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 11f);
        v12.horizontalLineToRelative(-1.5f);
        v12.verticalLineToRelative(-0.5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(13f);
        v12.horizontalLineTo(21f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(-3f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-4f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineTo(11f);
        v12.close();
        v12.moveTo(8f, 10f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineTo(6.5f);
        v12.verticalLineToRelative(-1.5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(15f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(-5f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(3f);
        v12.curveTo(7.55f, 9f, 8f, 9.45f, 8f, 10f);
        v12.close();
        v12.moveTo(6.5f, 10.5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(12f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(10.5f);
        v12.close();
        v12.moveTo(13.5f, 12f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineTo(9f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(1f);
        v12.curveTo(14.5f, 11.55f, 14.05f, 12f, 13.5f, 12f);
        v12.close();
        v12.moveTo(11f, 10.5f);
        v12.verticalLineToRelative(0.75f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(10.5f);
        v12.horizontalLineTo(11f);
        v12.close();
        v12.moveTo(13f, 12.75f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(0.75f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(12.75f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AbcKt._abc = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

