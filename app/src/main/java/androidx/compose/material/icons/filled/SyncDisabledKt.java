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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_syncDisabled", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SyncDisabled", "Landroidx/compose/material/icons/Icons$Filled;", "getSyncDisabled", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SyncDisabledKt {
    private static ImageVector _syncDisabled;

    static {
    }

    public static final ImageVector getSyncDisabled(Filled arg19) {
        ImageVector v0 = SyncDisabledKt._syncDisabled;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.SyncDisabled", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10f, 6.35f);
        v12.lineTo(10f, 4.26f);
        v12.curveToRelative(-0.8f, 0.21f, -1.55f, 0.54f, -2.23f, 0.96f);
        v12.lineToRelative(1.46f, 1.46f);
        v12.curveToRelative(0.25f, -0.12f, 0.5f, -0.24f, 0.77f, -0.33f);
        v12.close();
        v12.moveTo(2.86f, 5.41f);
        v12.lineToRelative(2.36f, 2.36f);
        v12.curveTo(4.45f, 8.99f, 4f, 10.44f, 4f, 12f);
        v12.curveToRelative(0f, 2.21f, 0.91f, 4.2f, 2.36f, 5.64f);
        v12.lineTo(4f, 20f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(-6f);
        v12.lineToRelative(-2.24f, 2.24f);
        v12.curveTo(6.68f, 15.15f, 6f, 13.66f, 6f, 12f);
        v12.curveToRelative(0f, -1f, 0.25f, -1.94f, 0.68f, -2.77f);
        v12.lineToRelative(8.08f, 8.08f);
        v12.curveToRelative(-0.25f, 0.13f, -0.5f, 0.25f, -0.77f, 0.34f);
        v12.verticalLineToRelative(2.09f);
        v12.curveToRelative(0.8f, -0.21f, 1.55f, -0.54f, 2.23f, -0.96f);
        v12.lineToRelative(2.36f, 2.36f);
        v12.lineToRelative(1.27f, -1.27f);
        v12.lineTo(4.14f, 4.14f);
        v12.lineTo(2.86f, 5.41f);
        v12.close();
        v12.moveTo(20f, 4f);
        v12.horizontalLineToRelative(-6f);
        v12.verticalLineToRelative(6f);
        v12.lineToRelative(2.24f, -2.24f);
        v12.curveTo(17.32f, 8.85f, 18f, 10.34f, 18f, 12f);
        v12.curveToRelative(0f, 1f, -0.25f, 1.94f, -0.68f, 2.77f);
        v12.lineToRelative(1.46f, 1.46f);
        v12.curveTo(19.549999f, 15.01f, 20f, 13.56f, 20f, 12f);
        v12.curveToRelative(0f, -2.21f, -0.91f, -4.2f, -2.36f, -5.64f);
        v12.lineTo(20f, 4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SyncDisabledKt._syncDisabled = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

