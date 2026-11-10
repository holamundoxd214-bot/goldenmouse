package androidx.compose.material.icons.automirrored.twotone;

import androidx.compose.material.icons.Icons$AutoMirrored$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_accessible", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Accessible", "Landroidx/compose/material/icons/Icons$AutoMirrored$TwoTone;", "getAccessible", "(Landroidx/compose/material/icons/Icons$AutoMirrored$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AccessibleKt {
    private static ImageVector _accessible;

    static {
    }

    public static final ImageVector getAccessible(TwoTone arg20) {
        ImageVector v0 = AccessibleKt._accessible;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.TwoTone.Accessible", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
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
        v12.moveTo(19f, 13f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(-1.54f, 0.02f, -3.09f, -0.75f, -4.07f, -1.83f);
        v12.lineToRelative(-1.29f, -1.43f);
        v12.curveToRelative(-0.17f, -0.19f, -0.38f, -0.34f, -0.61f, -0.45f);
        v12.curveToRelative(-0.01f, 0f, -0.01f, -0.01f, -0.02f, -0.01f);
        v12.lineTo(13f, 7.28f);
        v12.curveToRelative(-0.35f, -0.2f, -0.75f, -0.3f, -1.19f, -0.26f);
        v12.curveTo(10.76f, 7.11f, 10f, 8.04f, 10f, 9.09f);
        v12.lineTo(10f, 15f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-5.5f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineToRelative(-3.45f);
        v12.curveToRelative(1.29f, 1.07f, 3.25f, 1.94f, 5f, 1.95f);
        v12.close();
        v12.moveTo(12.83f, 18f);
        v12.curveToRelative(-0.41f, 1.16f, -1.52f, 2f, -2.83f, 2f);
        v12.curveToRelative(-1.66f, 0f, -3f, -1.34f, -3f, -3f);
        v12.curveToRelative(0f, -1.31f, 0.84f, -2.41f, 2f, -2.83f);
        v12.lineTo(9f, 12.1f);
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
}

