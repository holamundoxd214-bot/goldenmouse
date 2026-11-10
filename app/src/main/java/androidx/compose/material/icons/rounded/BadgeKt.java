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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_badge", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Badge", "Landroidx/compose/material/icons/Icons$Rounded;", "getBadge", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BadgeKt {
    private static ImageVector _badge;

    static {
    }

    public static final ImageVector getBadge(Rounded arg19) {
        ImageVector v0 = BadgeKt._badge;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Badge", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 7f);
        v12.horizontalLineToRelative(-5f);
        v12.verticalLineTo(4f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-2f);
        v12.curveTo(9.9f, 2f, 9f, 2.9f, 9f, 4f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.9f, 7f, 2f, 7.9f, 2f, 9f);
        v12.verticalLineToRelative(11f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(9f);
        v12.curveTo(22f, 7.9f, 21.1f, 7f, 20f, 7f);
        v12.close();
        v12.moveTo(9f, 12f);
        v12.curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f);
        v12.curveToRelative(0f, 0.83f, -0.67f, 1.5f, -1.5f, 1.5f);
        v12.reflectiveCurveToRelative(-1.5f, -0.67f, -1.5f, -1.5f);
        v12.curveTo(7.5f, 12.67f, 8.17f, 12f, 9f, 12f);
        v12.close();
        v12.moveTo(12f, 18f);
        v12.horizontalLineTo(6f);
        v12.verticalLineToRelative(-0.43f);
        v12.curveToRelative(0f, -0.6f, 0.36f, -1.15f, 0.92f, -1.39f);
        v12.curveTo(7.56f, 15.9f, 8.26f, 15.75f, 9f, 15.75f);
        v12.reflectiveCurveToRelative(1.44f, 0.15f, 2.08f, 0.43f);
        v12.curveToRelative(0.55f, 0.24f, 0.92f, 0.78f, 0.92f, 1.39f);
        v12.verticalLineTo(18f);
        v12.close();
        v12.moveTo(13f, 9f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(9f);
        v12.close();
        v12.moveTo(17.25f, 16.5f);
        v12.horizontalLineToRelative(-2.5f);
        v12.curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f);
        v12.horizontalLineToRelative(2.5f);
        v12.curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(18f, 16.16f, 17.66f, 16.5f, 17.25f, 16.5f);
        v12.close();
        v12.moveTo(17.25f, 13.5f);
        v12.horizontalLineToRelative(-2.5f);
        v12.curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f);
        v12.horizontalLineToRelative(2.5f);
        v12.curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(18f, 13.16f, 17.66f, 13.5f, 17.25f, 13.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BadgeKt._badge = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

