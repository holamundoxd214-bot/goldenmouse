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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_subtitles", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Subtitles", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSubtitles", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SubtitlesKt {
    private static ImageVector _subtitles;

    static {
    }

    public static final ImageVector getSubtitles(TwoTone arg19) {
        ImageVector v0 = SubtitlesKt._subtitles;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Subtitles", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(4f, 18f);
        v0_1.horizontalLineToRelative(16f);
        v0_1.lineTo(20f, 6f);
        v0_1.lineTo(4f, 6f);
        v0_1.verticalLineToRelative(12f);
        v0_1.close();
        v0_1.moveTo(18f, 16f);
        v0_1.horizontalLineToRelative(-2f);
        v0_1.verticalLineToRelative(-2f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.verticalLineToRelative(2f);
        v0_1.close();
        v0_1.moveTo(10f, 10f);
        v0_1.horizontalLineToRelative(8f);
        v0_1.verticalLineToRelative(2f);
        v0_1.horizontalLineToRelative(-8f);
        v0_1.verticalLineToRelative(-2f);
        v0_1.close();
        v0_1.moveTo(6f, 10f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.verticalLineToRelative(2f);
        v0_1.lineTo(6f, 12f);
        v0_1.verticalLineToRelative(-2f);
        v0_1.close();
        v0_1.moveTo(6f, 14f);
        v0_1.horizontalLineToRelative(8f);
        v0_1.verticalLineToRelative(2f);
        v0_1.lineTo(6f, 16f);
        v0_1.verticalLineToRelative(-2f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 4f);
        v12.lineTo(4f, 4f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(22f, 6f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(20f, 18f);
        v12.lineTo(4f, 18f);
        v12.lineTo(4f, 6f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineToRelative(12f);
        v12.close();
        v12.moveTo(6f, 10f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.lineTo(6f, 12f);
        v12.close();
        v12.moveTo(6f, 14f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(2f);
        v12.lineTo(6f, 16f);
        v12.close();
        v12.moveTo(16f, 14f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-2f);
        v12.close();
        v12.moveTo(10f, 10f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-8f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SubtitlesKt._subtitles = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

