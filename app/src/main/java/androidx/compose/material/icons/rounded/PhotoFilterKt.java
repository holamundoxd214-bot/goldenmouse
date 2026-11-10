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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_photoFilter", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PhotoFilter", "Landroidx/compose/material/icons/Icons$Rounded;", "getPhotoFilter", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PhotoFilterKt {
    private static ImageVector _photoFilter;

    static {
    }

    public static final ImageVector getPhotoFilter(Rounded arg19) {
        ImageVector v0 = PhotoFilterKt._photoFilter;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.PhotoFilter", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.02f, 10.99f);
        v12.lineTo(19.02f, 18f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.lineTo(6f, 19f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.lineTo(5f, 6f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(7f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.lineTo(5.02f, 3f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.lineTo(19f, 21f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.89f, 2f, -2f);
        v12.verticalLineToRelative(-8.01f);
        v12.curveToRelative(0f, -0.55f, -0.44f, -0.99f, -0.99f, -0.99f);
        v12.reflectiveCurveToRelative(-0.99f, 0.44f, -0.99f, 0.99f);
        v12.close();
        v12.moveTo(13.25f, 10.75f);
        v12.lineTo(12.46f, 9f);
        v12.curveToRelative(-0.18f, -0.39f, -0.73f, -0.39f, -0.91f, 0f);
        v12.lineToRelative(-0.79f, 1.75f);
        v12.lineToRelative(-1.76f, 0.79f);
        v12.curveToRelative(-0.39f, 0.18f, -0.39f, 0.73f, 0f, 0.91f);
        v12.lineToRelative(1.75f, 0.79f);
        v12.lineToRelative(0.79f, 1.76f);
        v12.curveToRelative(0.18f, 0.39f, 0.73f, 0.39f, 0.91f, 0f);
        v12.lineToRelative(0.79f, -1.75f);
        v12.lineToRelative(1.76f, -0.79f);
        v12.curveToRelative(0.39f, -0.18f, 0.39f, -0.73f, 0f, -0.91f);
        v12.lineToRelative(-1.75f, -0.8f);
        v12.close();
        v12.moveTo(17.940001f, 6.06f);
        v12.lineToRelative(-0.6f, -1.32f);
        v12.curveToRelative(-0.13f, -0.29f, -0.55f, -0.29f, -0.69f, 0f);
        v12.lineToRelative(-0.6f, 1.32f);
        v12.lineToRelative(-1.32f, 0.6f);
        v12.curveToRelative(-0.29f, 0.13f, -0.29f, 0.55f, 0f, 0.69f);
        v12.lineToRelative(1.32f, 0.6f);
        v12.lineToRelative(0.6f, 1.32f);
        v12.curveToRelative(0.13f, 0.29f, 0.55f, 0.29f, 0.69f, 0f);
        v12.lineToRelative(0.6f, -1.32f);
        v12.lineToRelative(1.32f, -0.6f);
        v12.curveToRelative(0.29f, -0.13f, 0.29f, -0.55f, 0f, -0.69f);
        v12.lineToRelative(-1.32f, -0.6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PhotoFilterKt._photoFilter = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

