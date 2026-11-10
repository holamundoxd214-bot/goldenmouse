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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_whereToVote", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WhereToVote", "Landroidx/compose/material/icons/Icons$TwoTone;", "getWhereToVote", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WhereToVoteKt {
    private static ImageVector _whereToVote;

    static {
    }

    public static final ImageVector getWhereToVote(TwoTone arg19) {
        ImageVector v0 = WhereToVoteKt._whereToVote;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.WhereToVote", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 3f);
        v12.curveTo(8.69f, 3f, 6f, 5.69f, 6f, 9f);
        v12.curveToRelative(0f, 3.54f, 3.82f, 8.86f, 6f, 11.47f);
        v12.curveToRelative(1.75f, -2.11f, 6f, -7.63f, 6f, -11.47f);
        v12.curveToRelative(0f, -3.31f, -2.69f, -6f, -6f, -6f);
        v12.close();
        v12.moveTo(10.47f, 14f);
        v12.lineToRelative(-3.18f, -3.18f);
        v12.lineTo(8.71f, 9.4f);
        v12.lineToRelative(1.77f, 1.77f);
        v12.lineToRelative(4.6f, -4.6f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineTo(10.47f, 14f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 1f);
        v12.curveTo(7.59f, 1f, 4f, 4.59f, 4f, 9f);
        v12.curveToRelative(0f, 5.57f, 6.96f, 13.34f, 7.26f, 13.67f);
        v12.lineToRelative(0.74f, 0.82f);
        v12.lineToRelative(0.74f, -0.82f);
        v12.curveTo(13.04f, 22.34f, 20f, 14.57f, 20f, 9f);
        v12.curveToRelative(0f, -4.41f, -3.59f, -8f, -8f, -8f);
        v12.close();
        v12.moveTo(12f, 20.469999f);
        v12.curveTo(9.82f, 17.860001f, 6f, 12.54f, 6f, 9f);
        v12.curveToRelative(0f, -3.31f, 2.69f, -6f, 6f, -6f);
        v12.reflectiveCurveToRelative(6f, 2.69f, 6f, 6f);
        v12.curveToRelative(0f, 3.83f, -4.25f, 9.36f, -6f, 11.47f);
        v12.close();
        v12.moveTo(15.07f, 6.57f);
        v12.lineToRelative(-4.6f, 4.6f);
        v12.lineTo(8.71f, 9.4f);
        v12.lineToRelative(-1.42f, 1.42f);
        v12.lineTo(10.47f, 14f);
        v12.lineToRelative(6.01f, -6.01f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WhereToVoteKt._whereToVote = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

