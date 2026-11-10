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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_doNotTouch", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DoNotTouch", "Landroidx/compose/material/icons/Icons$Outlined;", "getDoNotTouch", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DoNotTouchKt {
    private static ImageVector _doNotTouch;

    static {
    }

    public static final ImageVector getDoNotTouch(Outlined arg19) {
        ImageVector v0 = DoNotTouchKt._doNotTouch;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.DoNotTouch", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(2.81f, 2.81f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineTo(7f, 9.83f);
        v12.lineToRelative(0f, 4.3f);
        v12.lineToRelative(-2.6f, -1.48f);
        v12.curveToRelative(-0.17f, -0.09f, -0.34f, -0.14f, -0.54f, -0.14f);
        v12.curveToRelative(-0.26f, 0f, -0.5f, 0.09f, -0.7f, 0.26f);
        v12.lineTo(2f, 13.88f);
        v12.lineToRelative(6.8f, 7.18f);
        v12.curveToRelative(0.57f, 0.6f, 1.35f, 0.94f, 2.18f, 0.94f);
        v12.horizontalLineTo(17f);
        v12.curveToRelative(0.62f, 0f, 1.18f, -0.19f, 1.66f, -0.52f);
        v12.lineToRelative(1.12f, 1.12f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(2.81f, 2.81f);
        v12.close();
        v12.moveTo(17f, 20f);
        v12.horizontalLineToRelative(-6f);
        v12.curveToRelative(-0.39f, 0f, -0.64f, -0.23f, -0.75f, -0.36f);
        v12.lineTo(6.87f, 16f);
        v12.horizontalLineTo(9f);
        v12.lineToRelative(0f, -4.17f);
        v12.lineToRelative(8.14f, 8.14f);
        v12.curveTo(17.09f, 19.98f, 17.049999f, 20f, 17f, 20f);
        v12.close();
        v12.moveTo(13.83f, 11f);
        v12.horizontalLineTo(14f);
        v12.verticalLineTo(3.25f);
        v12.curveTo(14f, 2.56f, 14.56f, 2f, 15.25f, 2f);
        v12.reflectiveCurveToRelative(1.25f, 0.56f, 1.25f, 1.25f);
        v12.verticalLineTo(11f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(5.25f);
        v12.curveTo(17.5f, 4.56f, 18.059999f, 4f, 18.75f, 4f);
        v12.reflectiveCurveTo(20f, 4.56f, 20f, 5.25f);
        v12.verticalLineToRelative(11.92f);
        v12.lineToRelative(-2f, -2f);
        v12.verticalLineTo(13f);
        v12.horizontalLineToRelative(-2.17f);
        v12.lineTo(13.83f, 11f);
        v12.close();
        v12.moveTo(13f, 10.17f);
        v12.verticalLineTo(2.25f);
        v12.curveTo(13f, 1.56f, 12.44f, 1f, 11.75f, 1f);
        v12.reflectiveCurveTo(10.5f, 1.56f, 10.5f, 2.25f);
        v12.verticalLineToRelative(5.42f);
        v12.lineTo(13f, 10.17f);
        v12.close();
        v12.moveTo(9.5f, 6.67f);
        v12.verticalLineTo(4.25f);
        v12.curveTo(9.5f, 3.56f, 8.94f, 3f, 8.25f, 3f);
        v12.curveToRelative(-0.67f, 0f, -1.2f, 0.53f, -1.24f, 1.18f);
        v12.verticalLineToRelative(0f);
        v12.lineTo(9.5f, 6.67f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DoNotTouchKt._doNotTouch = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

