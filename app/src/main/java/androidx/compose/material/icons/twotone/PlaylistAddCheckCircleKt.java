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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_playlistAddCheckCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PlaylistAddCheckCircle", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPlaylistAddCheckCircle", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PlaylistAddCheckCircleKt {
    private static ImageVector _playlistAddCheckCircle;

    static {
    }

    public static final ImageVector getPlaylistAddCheckCircle(TwoTone arg19) {
        ImageVector v0 = PlaylistAddCheckCircleKt._playlistAddCheckCircle;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.PlaylistAddCheckCircle", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 4f);
        v12.curveToRelative(-4.41f, 0f, -8f, 3.59f, -8f, 8f);
        v12.reflectiveCurveToRelative(3.59f, 8f, 8f, 8f);
        v12.curveToRelative(4.41f, 0f, 8f, -3.59f, 8f, -8f);
        v12.reflectiveCurveTo(16.41f, 4f, 12f, 4f);
        v12.close();
        v12.moveTo(7f, 7f);
        v12.horizontalLineToRelative(7f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(7f);
        v12.verticalLineTo(7f);
        v12.close();
        v12.moveTo(7f, 10f);
        v12.horizontalLineToRelative(7f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(7f);
        v12.verticalLineTo(10f);
        v12.close();
        v12.moveTo(10f, 15f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineTo(15f);
        v12.close();
        v12.moveTo(14.05f, 18.360001f);
        v12.lineToRelative(-2.83f, -2.83f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineTo(17.59f, 12f);
        v12.lineTo(19f, 13.41f);
        v12.lineTo(14.05f, 18.360001f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 4f);
        v12.curveToRelative(4.41f, 0f, 8f, 3.59f, 8f, 8f);
        v12.reflectiveCurveToRelative(-3.59f, 8f, -8f, 8f);
        v12.reflectiveCurveToRelative(-8f, -3.59f, -8f, -8f);
        v12.reflectiveCurveTo(7.59f, 4f, 12f, 4f);
        v12.close();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.curveToRelative(0f, 5.52f, 4.48f, 10f, 10f, 10f);
        v12.curveToRelative(5.52f, 0f, 10f, -4.48f, 10f, -10f);
        v12.curveTo(22f, 6.48f, 17.52f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(14f, 10f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(7f);
        v12.verticalLineTo(10f);
        v12.close();
        v12.moveTo(14f, 7f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(7f);
        v12.verticalLineTo(7f);
        v12.close();
        v12.moveTo(7f, 15f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(7f);
        v12.verticalLineTo(15f);
        v12.close();
        v12.moveTo(19f, 13.41f);
        v12.lineTo(17.59f, 12f);
        v12.lineToRelative(-3.54f, 3.54f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.lineToRelative(2.83f, 2.83f);
        v12.lineTo(19f, 13.41f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PlaylistAddCheckCircleKt._playlistAddCheckCircle = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

