package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_howToVote", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HowToVote", "Landroidx/compose/material/icons/Icons$Sharp;", "getHowToVote", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HowToVoteKt {
    private static ImageVector _howToVote;

    static {
    }

    public static final ImageVector getHowToVote(Sharp arg18) {
        ImageVector v0 = HowToVoteKt._howToVote;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.HowToVote", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(18f, 13f);
        v0_1.horizontalLineToRelative(-0.68f);
        v0_1.lineToRelative(-2f, 2f);
        v0_1.horizontalLineToRelative(1.91f);
        v0_1.lineTo(19f, 17f);
        v0_1.lineTo(5f, 17f);
        v0_1.lineToRelative(1.78f, -2f);
        v0_1.horizontalLineToRelative(2.05f);
        v0_1.lineToRelative(-2f, -2f);
        v0_1.lineTo(6f, 13f);
        v0_1.lineToRelative(-3f, 3f);
        v0_1.verticalLineToRelative(6f);
        v0_1.horizontalLineToRelative(18f);
        v0_1.verticalLineToRelative(-6f);
        v0_1.close();
        v0_1.moveTo(19.809999f, 7.96f);
        v0_1.lineTo(13.45f, 1.6f);
        v0_1.lineTo(5.68f, 9.36f);
        v0_1.lineToRelative(6.36f, 6.36f);
        v0_1.lineToRelative(7.77f, -7.76f);
        v0_1.close();
        v0_1.moveTo(13.46f, 4.41f);
        v0_1.lineTo(17f, 7.95f);
        v0_1.lineToRelative(-4.95f, 4.95f);
        v0_1.lineToRelative(-3.54f, -3.54f);
        v0_1.lineToRelative(4.95f, -4.95f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HowToVoteKt._howToVote = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

