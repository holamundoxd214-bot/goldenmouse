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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_localLibrary", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocalLibrary", "Landroidx/compose/material/icons/Icons$Rounded;", "getLocalLibrary", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LocalLibraryKt {
    private static ImageVector _localLibrary;

    static {
    }

    public static final ImageVector getLocalLibrary(Rounded arg19) {
        ImageVector v0 = LocalLibraryKt._localLibrary;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.LocalLibrary", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 11.55f);
        v12.curveToRelative(-1.82f, -1.7f, -4.12f, -2.89f, -6.68f, -3.35f);
        v12.curveTo(4.11f, 7.99f, 3f, 8.95f, 3f, 10.18f);
        v12.verticalLineToRelative(6.24f);
        v12.curveToRelative(0f, 1.68f, 0.72f, 2.56f, 1.71f, 2.69f);
        v12.curveToRelative(2.5f, 0.32f, 4.77f, 1.35f, 6.63f, 2.87f);
        v12.curveToRelative(0.35f, 0.29f, 0.92f, 0.32f, 1.27f, 0.04f);
        v12.curveToRelative(1.87f, -1.53f, 4.16f, -2.58f, 6.68f, -2.9f);
        v12.curveToRelative(0.94f, -0.13f, 1.71f, -1.06f, 1.71f, -2.02f);
        v12.verticalLineToRelative(-6.92f);
        v12.curveToRelative(0f, -1.23f, -1.11f, -2.19f, -2.32f, -1.98f);
        v12.curveToRelative(-2.56f, 0.46f, -4.86f, 1.65f, -6.68f, 3.35f);
        v12.close();
        v12.moveTo(12f, 8f);
        v12.curveToRelative(1.66f, 0f, 3f, -1.34f, 3f, -3f);
        v12.reflectiveCurveToRelative(-1.34f, -3f, -3f, -3f);
        v12.reflectiveCurveToRelative(-3f, 1.34f, -3f, 3f);
        v12.reflectiveCurveToRelative(1.34f, 3f, 3f, 3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LocalLibraryKt._localLibrary = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

