package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_localLibrary", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocalLibrary", "Landroidx/compose/material/icons/Icons$TwoTone;", "getLocalLibrary", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LocalLibraryKt {
    private static ImageVector _localLibrary;

    static {
    }

    public static final ImageVector getLocalLibrary(TwoTone arg20) {
        ImageVector v0 = LocalLibraryKt._localLibrary;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.LocalLibrary", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 17.129999f);
        v12.verticalLineToRelative(-6.95f);
        v12.curveToRelative(-2.1f, 0.38f, -4.05f, 1.35f, -5.64f, 2.83f);
        v12.lineTo(12f, 14.28f);
        v12.lineToRelative(-1.36f, -1.27f);
        v12.curveTo(9.05f, 11.53f, 7.1f, 10.56f, 5f, 10.18f);
        v12.verticalLineToRelative(6.95f);
        v12.curveToRelative(2.53f, 0.34f, 4.94f, 1.3f, 7f, 2.83f);
        v12.curveToRelative(2.07f, -1.52f, 4.47f, -2.49f, 7f, -2.83f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 5f);
        v12.moveToRelative(-2f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, 4f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, -4f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(16f, 5f);
        v12.curveToRelative(0f, -2.21f, -1.79f, -4f, -4f, -4f);
        v12.reflectiveCurveTo(8f, 2.79f, 8f, 5f);
        v12.reflectiveCurveToRelative(1.79f, 4f, 4f, 4f);
        v12.reflectiveCurveToRelative(4f, -1.79f, 4f, -4f);
        v12.close();
        v12.moveTo(10f, 5f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.reflectiveCurveToRelative(-0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f);
        v12.close();
        v12.moveTo(3f, 19f);
        v12.curveToRelative(3.48f, 0f, 6.64f, 1.35f, 9f, 3.55f);
        v12.curveToRelative(2.36f, -2.19f, 5.52f, -3.55f, 9f, -3.55f);
        v12.lineTo(21f, 8f);
        v12.curveToRelative(-3.48f, 0f, -6.64f, 1.35f, -9f, 3.55f);
        v12.curveTo(9.64f, 9.35f, 6.48f, 8f, 3f, 8f);
        v12.verticalLineToRelative(11f);
        v12.close();
        v12.moveTo(5f, 10.18f);
        v12.curveToRelative(2.1f, 0.38f, 4.05f, 1.35f, 5.64f, 2.83f);
        v12.lineTo(12f, 14.28f);
        v12.lineToRelative(1.36f, -1.27f);
        v12.curveToRelative(1.59f, -1.48f, 3.54f, -2.45f, 5.64f, -2.83f);
        v12.verticalLineToRelative(6.95f);
        v12.curveToRelative(-2.53f, 0.34f, -4.93f, 1.3f, -7f, 2.82f);
        v12.curveToRelative(-2.06f, -1.52f, -4.47f, -2.49f, -7f, -2.83f);
        v12.verticalLineToRelative(-6.94f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LocalLibraryKt._localLibrary = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

