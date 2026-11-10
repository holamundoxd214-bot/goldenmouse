package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sportsMartialArts", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SportsMartialArts", "Landroidx/compose/material/icons/Icons$Filled;", "getSportsMartialArts", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SportsMartialArtsKt {
    private static ImageVector _sportsMartialArts;

    static {
    }

    public static final ImageVector getSportsMartialArts(Filled arg28) {
        ImageVector v0 = SportsMartialArtsKt._sportsMartialArts;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.SportsMartialArts", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(19.799999f, 2f);
        v0_1.lineToRelative(-8.2f, 6.7f);
        v0_1.lineToRelative(-1.21f, -1.04f);
        v0_1.lineToRelative(3.6f, -2.08f);
        v0_1.lineToRelative(-4.58f, -4.58f);
        v0_1.lineToRelative(-1.41f, 1.41f);
        v0_1.lineToRelative(2.74f, 2.74f);
        v0_1.lineToRelative(-5.74f, 3.31f);
        v0_1.lineToRelative(-1.19f, 4.29f);
        v0_1.lineToRelative(2.46f, 4.25f);
        v0_1.lineToRelative(1.73f, -1f);
        v0_1.lineToRelative(-2.03f, -3.52f);
        v0_1.lineToRelative(0.35f, -1.3f);
        v0_1.lineToRelative(3.18f, 1.82f);
        v0_1.lineToRelative(0.5f, 9f);
        v0_1.lineToRelative(2f, 0f);
        v0_1.lineToRelative(0.5f, -10f);
        v0_1.lineToRelative(8.5f, -8.6f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(5f, 5f);
        v0_1.moveToRelative(-2f, 0f);
        v0_1.arcToRelative(2f, 2f, 0f, true, true, 4f, 0f);
        v0_1.arcToRelative(2f, 2f, 0f, true, true, -4f, 0f);
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SportsMartialArtsKt._sportsMartialArts = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

