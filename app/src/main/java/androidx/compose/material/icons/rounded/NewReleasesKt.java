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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_newReleases", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NewReleases", "Landroidx/compose/material/icons/Icons$Rounded;", "getNewReleases", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NewReleasesKt {
    private static ImageVector _newReleases;

    static {
    }

    public static final ImageVector getNewReleases(Rounded arg19) {
        ImageVector v0 = NewReleasesKt._newReleases;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.NewReleases", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22.42f, 11.34f);
        v12.lineToRelative(-1.86f, -2.12f);
        v12.lineToRelative(0.26f, -2.81f);
        v12.curveToRelative(0.05f, -0.5f, -0.29f, -0.96f, -0.77f, -1.07f);
        v12.lineToRelative(-2.76f, -0.63f);
        v12.lineToRelative(-1.44f, -2.43f);
        v12.curveToRelative(-0.26f, -0.43f, -0.79f, -0.61f, -1.25f, -0.41f);
        v12.lineTo(12f, 3f);
        v12.lineTo(9.41f, 1.89f);
        v12.curveToRelative(-0.46f, -0.2f, -1f, -0.02f, -1.25f, 0.41f);
        v12.lineTo(6.71f, 4.72f);
        v12.lineToRelative(-2.75f, 0.62f);
        v12.curveToRelative(-0.49f, 0.11f, -0.83f, 0.56f, -0.78f, 1.07f);
        v12.lineToRelative(0.26f, 2.8f);
        v12.lineToRelative(-1.86f, 2.13f);
        v12.curveToRelative(-0.33f, 0.38f, -0.33f, 0.94f, 0f, 1.32f);
        v12.lineToRelative(1.86f, 2.12f);
        v12.lineToRelative(-0.26f, 2.82f);
        v12.curveToRelative(-0.05f, 0.5f, 0.29f, 0.96f, 0.77f, 1.07f);
        v12.lineToRelative(2.76f, 0.63f);
        v12.lineToRelative(1.44f, 2.42f);
        v12.curveToRelative(0.26f, 0.43f, 0.79f, 0.61f, 1.26f, 0.41f);
        v12.lineTo(12f, 21f);
        v12.lineToRelative(2.59f, 1.11f);
        v12.curveToRelative(0.46f, 0.2f, 1f, 0.02f, 1.25f, -0.41f);
        v12.lineToRelative(1.44f, -2.43f);
        v12.lineToRelative(2.76f, -0.63f);
        v12.curveToRelative(0.49f, -0.11f, 0.82f, -0.57f, 0.77f, -1.07f);
        v12.lineToRelative(-0.26f, -2.81f);
        v12.lineToRelative(1.86f, -2.12f);
        v12.curveToRelative(0.34f, -0.36f, 0.34f, -0.92f, 0.01f, -1.3f);
        v12.close();
        v12.moveTo(13f, 17f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.close();
        v12.moveTo(12f, 13f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.lineTo(11f, 8f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NewReleasesKt._newReleases = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

