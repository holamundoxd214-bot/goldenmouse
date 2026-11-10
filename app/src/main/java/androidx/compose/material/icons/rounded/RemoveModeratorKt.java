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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_removeModerator", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RemoveModerator", "Landroidx/compose/material/icons/Icons$Rounded;", "getRemoveModerator", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RemoveModeratorKt {
    private static ImageVector _removeModerator;

    static {
    }

    public static final ImageVector getRemoveModerator(Rounded arg19) {
        ImageVector v0 = RemoveModeratorKt._removeModerator;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.RemoveModerator", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 11.09f);
        v12.verticalLineToRelative(-4.7f);
        v12.curveToRelative(0f, -0.83f, -0.52f, -1.58f, -1.3f, -1.87f);
        v12.lineToRelative(-6f, -2.25f);
        v12.curveToRelative(-0.45f, -0.17f, -0.95f, -0.17f, -1.4f, 0f);
        v12.lineTo(6.78f, 3.96f);
        v12.lineToRelative(12.09f, 12.09f);
        v12.curveTo(19.59f, 14.52f, 20f, 12.83f, 20f, 11.09f);
        v12.close();
        v12.moveTo(20.49f, 20.49f);
        v12.lineTo(3.51f, 3.51f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineTo(4f, 6.83f);
        v12.verticalLineToRelative(4.26f);
        v12.curveToRelative(0f, 4.83f, 3.13f, 9.37f, 7.43f, 10.75f);
        v12.curveToRelative(0.37f, 0.12f, 0.77f, 0.12f, 1.14f, 0f);
        v12.curveToRelative(1.49f, -0.48f, 2.84f, -1.35f, 3.97f, -2.47f);
        v12.lineToRelative(2.53f, 2.53f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveTo(20.879999f, 21.51f, 20.879999f, 20.879999f, 20.49f, 20.49f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RemoveModeratorKt._removeModerator = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

