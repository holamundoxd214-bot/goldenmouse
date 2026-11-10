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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_videogameAssetOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "VideogameAssetOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getVideogameAssetOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VideogameAssetOffKt {
    private static ImageVector _videogameAssetOff;

    static {
    }

    public static final ImageVector getVideogameAssetOff(Rounded arg19) {
        ImageVector v0 = VideogameAssetOffKt._videogameAssetOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.VideogameAssetOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.700001f, 17.870001f);
        v12.curveTo(21.459999f, 17.59f, 22f, 16.85f, 22f, 16f);
        v12.verticalLineTo(8f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineTo(8.83f);
        v12.lineTo(20.700001f, 17.870001f);
        v12.close();
        v12.moveTo(17.5f, 9f);
        v12.curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(18.33f, 12f, 17.5f, 12f);
        v12.reflectiveCurveTo(16f, 11.33f, 16f, 10.5f);
        v12.reflectiveCurveTo(16.67f, 9f, 17.5f, 9f);
        v12.close();
        v12.moveTo(20.49f, 20.49f);
        v12.lineTo(3.51f, 3.51f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(1.2f, 1.2f);
        v12.curveTo(2.54f, 6.41f, 2f, 7.15f, 2f, 8f);
        v12.verticalLineToRelative(8f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(11.17f);
        v12.lineToRelative(3.9f, 3.9f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(20.879999f, 21.51f, 20.879999f, 20.879999f, 20.49f, 20.49f);
        v12.close();
        v12.moveTo(10f, 13f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineTo(6f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(0f, -0.05f, 0.01f, -0.11f, 0.01f, -0.16f);
        v12.lineToRelative(3.14f, 3.14f);
        v12.curveTo(10.11f, 12.99f, 10.05f, 13f, 10f, 13f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VideogameAssetOffKt._videogameAssetOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

