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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_scoreboard", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Scoreboard", "Landroidx/compose/material/icons/Icons$Rounded;", "getScoreboard", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ScoreboardKt {
    private static ImageVector _scoreboard;

    static {
    }

    public static final ImageVector getScoreboard(Rounded arg19) {
        ImageVector v0 = ScoreboardKt._scoreboard;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Scoreboard", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.5f, 13.5f);
        v12.horizontalLineTo(16f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(1.5f);
        v12.verticalLineTo(13.5f);
        v12.close();
        v12.moveTo(16f, 2f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineTo(9f);
        v12.verticalLineTo(3f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveTo(7f, 2.45f, 7f, 3f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.9f, 4f, 2f, 4.9f, 2f, 6f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineTo(3f);
        v12.curveTo(17f, 2.45f, 16.549999f, 2f, 16f, 2f);
        v12.close();
        v12.moveTo(9.5f, 14.25f);
        v12.curveTo(9.5f, 14.66f, 9.16f, 15f, 8.75f, 15f);
        v12.horizontalLineTo(6f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-1.5f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineTo(5.75f);
        v12.curveTo(5.34f, 10.5f, 5f, 10.16f, 5f, 9.75f);
        v12.reflectiveCurveTo(5.34f, 9f, 5.75f, 9f);
        v12.horizontalLineTo(8.5f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(1.5f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(2.25f);
        v12.curveTo(9.16f, 13.5f, 9.5f, 13.84f, 9.5f, 14.25f);
        v12.close();
        v12.moveTo(19f, 14f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(-2.5f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-4f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineTo(18f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineTo(14f);
        v12.close();
        v12.moveTo(12.75f, 6.75f);
        v12.curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f);
        v12.reflectiveCurveToRelative(-0.75f, -0.34f, -0.75f, -0.75f);
        v12.reflectiveCurveTo(11.59f, 6f, 12f, 6f);
        v12.reflectiveCurveTo(12.75f, 6.34f, 12.75f, 6.75f);
        v12.close();
        v12.moveTo(12.75f, 10.25f);
        v12.curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f);
        v12.reflectiveCurveToRelative(-0.75f, -0.34f, -0.75f, -0.75f);
        v12.reflectiveCurveTo(11.59f, 9.5f, 12f, 9.5f);
        v12.reflectiveCurveTo(12.75f, 9.84f, 12.75f, 10.25f);
        v12.close();
        v12.moveTo(12.75f, 13.75f);
        v12.curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f);
        v12.reflectiveCurveToRelative(-0.75f, -0.34f, -0.75f, -0.75f);
        v12.reflectiveCurveTo(11.59f, 13f, 12f, 13f);
        v12.reflectiveCurveTo(12.75f, 13.34f, 12.75f, 13.75f);
        v12.close();
        v12.moveTo(12.75f, 17.25f);
        v12.curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f);
        v12.reflectiveCurveToRelative(-0.75f, -0.34f, -0.75f, -0.75f);
        v12.reflectiveCurveTo(11.59f, 16.5f, 12f, 16.5f);
        v12.reflectiveCurveTo(12.75f, 16.84f, 12.75f, 17.25f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ScoreboardKt._scoreboard = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

