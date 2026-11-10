package androidx.compose.material.icons.automirrored.rounded;

import androidx.compose.material.icons.Icons$AutoMirrored$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_replyAll", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ReplyAll", "Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;", "getReplyAll", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ReplyAllKt {
    private static ImageVector _replyAll;

    static {
    }

    public static final ImageVector getReplyAll(Rounded arg19) {
        ImageVector v0 = ReplyAllKt._replyAll;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Rounded.ReplyAll", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7f, 7.56f);
        v12.curveToRelative(0f, -0.94f, -1.14f, -1.42f, -1.81f, -0.75f);
        v12.lineTo(0.71f, 11.29f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(4.48f, 4.48f);
        v12.curveToRelative(0.67f, 0.68f, 1.81f, 0.2f, 1.81f, -0.74f);
        v12.curveToRelative(0f, -0.28f, -0.11f, -0.55f, -0.31f, -0.75f);
        v12.lineTo(3f, 12f);
        v12.lineToRelative(3.69f, -3.69f);
        v12.curveToRelative(0.2f, -0.2f, 0.31f, -0.47f, 0.31f, -0.75f);
        v12.close();
        v12.moveTo(13f, 9f);
        v12.verticalLineTo(7.41f);
        v12.curveToRelative(0f, -0.89f, -1.08f, -1.34f, -1.71f, -0.71f);
        v12.lineTo(6.7f, 11.29f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(4.59f, 4.59f);
        v12.curveToRelative(0.63f, 0.63f, 1.71f, 0.18f, 1.71f, -0.71f);
        v12.verticalLineTo(14.9f);
        v12.curveToRelative(5f, 0f, 8.5f, 1.6f, 11f, 5.1f);
        v12.curveToRelative(-1f, -5f, -4f, -10f, -11f, -11f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ReplyAllKt._replyAll = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

