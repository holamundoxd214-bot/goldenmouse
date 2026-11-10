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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_autoAwesome", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AutoAwesome", "Landroidx/compose/material/icons/Icons$Rounded;", "getAutoAwesome", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AutoAwesomeKt {
    private static ImageVector _autoAwesome;

    static {
    }

    public static final ImageVector getAutoAwesome(Rounded arg19) {
        ImageVector v0 = AutoAwesomeKt._autoAwesome;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.AutoAwesome", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.459999f, 8f);
        v12.lineToRelative(0.79f, -1.75f);
        v12.lineTo(22f, 5.46f);
        v12.curveToRelative(0.39f, -0.18f, 0.39f, -0.73f, 0f, -0.91f);
        v12.lineToRelative(-1.75f, -0.79f);
        v12.lineTo(19.459999f, 2f);
        v12.curveToRelative(-0.18f, -0.39f, -0.73f, -0.39f, -0.91f, 0f);
        v12.lineToRelative(-0.79f, 1.75f);
        v12.lineTo(16f, 4.54f);
        v12.curveToRelative(-0.39f, 0.18f, -0.39f, 0.73f, 0f, 0.91f);
        v12.lineToRelative(1.75f, 0.79f);
        v12.lineTo(18.540001f, 8f);
        v12.curveTo(18.719999f, 8.39f, 19.280001f, 8.39f, 19.459999f, 8f);
        v12.close();
        v12.moveTo(11.5f, 9.5f);
        v12.lineTo(9.91f, 6f);
        v12.curveTo(9.56f, 5.22f, 8.44f, 5.22f, 8.09f, 6f);
        v12.lineTo(6.5f, 9.5f);
        v12.lineTo(3f, 11.09f);
        v12.curveToRelative(-0.78f, 0.36f, -0.78f, 1.47f, 0f, 1.82f);
        v12.lineToRelative(3.5f, 1.59f);
        v12.lineTo(8.09f, 18f);
        v12.curveToRelative(0.36f, 0.78f, 1.47f, 0.78f, 1.82f, 0f);
        v12.lineToRelative(1.59f, -3.5f);
        v12.lineToRelative(3.5f, -1.59f);
        v12.curveToRelative(0.78f, -0.36f, 0.78f, -1.47f, 0f, -1.82f);
        v12.lineTo(11.5f, 9.5f);
        v12.close();
        v12.moveTo(18.540001f, 16f);
        v12.lineToRelative(-0.79f, 1.75f);
        v12.lineTo(16f, 18.540001f);
        v12.curveToRelative(-0.39f, 0.18f, -0.39f, 0.73f, 0f, 0.91f);
        v12.lineToRelative(1.75f, 0.79f);
        v12.lineTo(18.540001f, 22f);
        v12.curveToRelative(0.18f, 0.39f, 0.73f, 0.39f, 0.91f, 0f);
        v12.lineToRelative(0.79f, -1.75f);
        v12.lineTo(22f, 19.459999f);
        v12.curveToRelative(0.39f, -0.18f, 0.39f, -0.73f, 0f, -0.91f);
        v12.lineToRelative(-1.75f, -0.79f);
        v12.lineTo(19.459999f, 16f);
        v12.curveTo(19.280001f, 15.61f, 18.719999f, 15.61f, 18.540001f, 16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AutoAwesomeKt._autoAwesome = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

