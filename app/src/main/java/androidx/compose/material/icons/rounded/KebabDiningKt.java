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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_kebabDining", "Landroidx/compose/ui/graphics/vector/ImageVector;", "KebabDining", "Landroidx/compose/material/icons/Icons$Rounded;", "getKebabDining", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class KebabDiningKt {
    private static ImageVector _kebabDining;

    static {
    }

    public static final ImageVector getKebabDining(Rounded arg19) {
        ImageVector v0 = KebabDiningKt._kebabDining;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.KebabDining", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7.75f, 13f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineTo(8.5f);
        v12.curveToRelative(1.38f, 0f, 2.5f, 1.12f, 2.5f, 2.5f);
        v12.curveToRelative(0f, 1.38f, -1.12f, 2.5f, -2.5f, 2.5f);
        v12.horizontalLineTo(7.75f);
        v12.verticalLineToRelative(3.25f);
        v12.curveTo(7.75f, 22.66f, 7.41f, 23f, 7f, 23f);
        v12.reflectiveCurveToRelative(-0.75f, -0.34f, -0.75f, -0.75f);
        v12.verticalLineTo(19f);
        v12.horizontalLineTo(5.5f);
        v12.curveTo(4.12f, 19f, 3f, 17.879999f, 3f, 16.5f);
        v12.curveTo(3f, 15.12f, 4.12f, 14f, 5.5f, 14f);
        v12.horizontalLineToRelative(0.75f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineTo(9f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(2.25f);
        v12.verticalLineTo(7f);
        v12.horizontalLineTo(5.5f);
        v12.curveTo(4.12f, 7f, 3f, 5.88f, 3f, 4.5f);
        v12.curveTo(3f, 3.12f, 4.12f, 2f, 5.5f, 2f);
        v12.horizontalLineToRelative(0.75f);
        v12.verticalLineTo(1.75f);
        v12.curveTo(6.25f, 1.34f, 6.59f, 1f, 7f, 1f);
        v12.reflectiveCurveToRelative(0.75f, 0.34f, 0.75f, 0.75f);
        v12.verticalLineTo(2f);
        v12.horizontalLineTo(8.5f);
        v12.curveTo(9.88f, 2f, 11f, 3.12f, 11f, 4.5f);
        v12.curveTo(11f, 5.88f, 9.88f, 7f, 8.5f, 7f);
        v12.horizontalLineTo(7.75f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineTo(10f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(3f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineTo(7.75f);
        v12.close();
        v12.moveTo(17.75f, 13f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(0.75f);
        v12.curveToRelative(1.38f, 0f, 2.5f, 1.12f, 2.5f, 2.5f);
        v12.curveToRelative(0f, 1.38f, -1.12f, 2.5f, -2.5f, 2.5f);
        v12.horizontalLineToRelative(-0.75f);
        v12.verticalLineToRelative(3.25f);
        v12.curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f);
        v12.reflectiveCurveToRelative(-0.75f, -0.34f, -0.75f, -0.75f);
        v12.verticalLineTo(19f);
        v12.horizontalLineTo(15.5f);
        v12.curveToRelative(-1.38f, 0f, -2.5f, -1.12f, -2.5f, -2.5f);
        v12.curveToRelative(0f, -1.38f, 1.12f, -2.5f, 2.5f, -2.5f);
        v12.horizontalLineToRelative(0.75f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineTo(14f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineTo(9f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(2.25f);
        v12.verticalLineTo(7f);
        v12.horizontalLineTo(15.5f);
        v12.curveTo(14.12f, 7f, 13f, 5.88f, 13f, 4.5f);
        v12.curveTo(13f, 3.12f, 14.12f, 2f, 15.5f, 2f);
        v12.horizontalLineToRelative(0.75f);
        v12.verticalLineTo(1.75f);
        v12.curveTo(16.25f, 1.34f, 16.59f, 1f, 17f, 1f);
        v12.reflectiveCurveToRelative(0.75f, 0.34f, 0.75f, 0.75f);
        v12.verticalLineTo(2f);
        v12.horizontalLineToRelative(0.75f);
        v12.curveTo(19.879999f, 2f, 21f, 3.12f, 21f, 4.5f);
        v12.curveTo(21f, 5.88f, 19.879999f, 7f, 18.5f, 7f);
        v12.horizontalLineToRelative(-0.75f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineTo(20f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(3f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineTo(17.75f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        KebabDiningKt._kebabDining = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

