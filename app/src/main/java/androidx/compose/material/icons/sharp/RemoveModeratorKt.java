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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_removeModerator", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RemoveModerator", "Landroidx/compose/material/icons/Icons$Sharp;", "getRemoveModerator", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RemoveModeratorKt {
    private static ImageVector _removeModerator;

    static {
    }

    public static final ImageVector getRemoveModerator(Sharp arg19) {
        ImageVector v0 = RemoveModeratorKt._removeModerator;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.RemoveModerator", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 11.09f);
        v12.verticalLineTo(5f);
        v12.lineToRelative(-8f, -3f);
        v12.lineTo(6.78f, 3.96f);
        v12.lineToRelative(12.09f, 12.09f);
        v12.curveTo(19.59f, 14.52f, 20f, 12.83f, 20f, 11.09f);
        v12.close();
        v12.moveTo(2.81f, 2.81f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineTo(4f, 6.83f);
        v12.verticalLineToRelative(4.26f);
        v12.curveToRelative(0f, 5.05f, 3.41f, 9.76f, 8f, 10.91f);
        v12.curveToRelative(1.72f, -0.43f, 3.28f, -1.36f, 4.55f, -2.62f);
        v12.lineToRelative(3.23f, 3.23f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(2.81f, 2.81f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RemoveModeratorKt._removeModerator = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

