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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_accessible", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Accessible", "Landroidx/compose/material/icons/Icons$Rounded;", "getAccessible$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getAccessible", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AccessibleKt {
    private static ImageVector _accessible;

    static {
    }

    public static final ImageVector getAccessible(Rounded arg20) {
        ImageVector v0 = AccessibleKt._accessible;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Accessible", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 4f);
        v12.moveToRelative(-2f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, 4f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, -4f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(19f, 11.9f);
        v12.curveToRelative(0f, -0.49f, -0.36f, -0.89f, -0.84f, -0.97f);
        v12.curveToRelative(-1.25f, -0.21f, -2.43f, -0.88f, -3.23f, -1.76f);
        v12.lineToRelative(-1.29f, -1.43f);
        v12.curveToRelative(-0.17f, -0.19f, -0.38f, -0.34f, -0.61f, -0.45f);
        v12.curveToRelative(-0.01f, 0f, -0.01f, -0.01f, -0.02f, -0.01f);
        v12.horizontalLineTo(13f);
        v12.curveToRelative(-0.37f, -0.21f, -0.78f, -0.31f, -1.25f, -0.25f);
        v12.curveTo(10.73f, 7.15f, 10f, 8.07f, 10f, 9.1f);
        v12.verticalLineTo(15f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-4.5f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineToRelative(-3.45f);
        v12.curveToRelative(1f, 0.83f, 2.4f, 1.54f, 3.8f, 1.82f);
        v12.curveToRelative(0.62f, 0.13f, 1.2f, -0.34f, 1.2f, -0.97f);
        v12.close();
        v12.moveTo(12.83f, 18f);
        v12.curveToRelative(-0.41f, 1.16f, -1.52f, 2f, -2.83f, 2f);
        v12.curveToRelative(-1.66f, 0f, -3f, -1.34f, -3f, -3f);
        v12.curveToRelative(0f, -1.31f, 0.84f, -2.41f, 2f, -2.83f);
        v12.verticalLineTo(12.1f);
        v12.curveToRelative(-2.28f, 0.46f, -4f, 2.48f, -4f, 4.9f);
        v12.curveToRelative(0f, 2.76f, 2.24f, 5f, 5f, 5f);
        v12.curveToRelative(2.42f, 0f, 4.44f, -1.72f, 4.9f, -4f);
        v12.horizontalLineToRelative(-2.07f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AccessibleKt._accessible = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Rounded.Accessible", replaceWith="<_subannotation>") public static void getAccessible$annotations(Rounded arg0) {
    }
}

