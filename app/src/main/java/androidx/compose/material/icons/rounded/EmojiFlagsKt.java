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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_emojiFlags", "Landroidx/compose/ui/graphics/vector/ImageVector;", "EmojiFlags", "Landroidx/compose/material/icons/Icons$Rounded;", "getEmojiFlags", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EmojiFlagsKt {
    private static ImageVector _emojiFlags;

    static {
    }

    public static final ImageVector getEmojiFlags(Rounded arg19) {
        ImageVector v0 = EmojiFlagsKt._emojiFlags;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.EmojiFlags", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 9f);
        v12.horizontalLineToRelative(-5f);
        v12.lineToRelative(-0.72f, -1.45f);
        v12.curveTo(13.11f, 7.21f, 12.76f, 7f, 12.38f, 7f);
        v12.horizontalLineTo(7f);
        v12.verticalLineTo(5.72f);
        v12.curveTo(7.6f, 5.38f, 8f, 4.74f, 8f, 4f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveTo(4f, 2.9f, 4f, 4f);
        v12.curveToRelative(0f, 0.74f, 0.4f, 1.38f, 1f, 1.72f);
        v12.verticalLineTo(20f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(5f);
        v12.lineToRelative(0.72f, 1.45f);
        v12.curveToRelative(0.17f, 0.34f, 0.52f, 0.55f, 0.89f, 0.55f);
        v12.horizontalLineTo(19f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-8f);
        v12.curveTo(20f, 9.45f, 19.549999f, 9f, 19f, 9f);
        v12.close();
        v12.moveTo(18f, 17f);
        v12.horizontalLineToRelative(-4f);
        v12.lineToRelative(-1f, -2f);
        v12.horizontalLineTo(7f);
        v12.verticalLineTo(9f);
        v12.horizontalLineToRelative(5f);
        v12.lineToRelative(1f, 2f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineTo(17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EmojiFlagsKt._emojiFlags = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

