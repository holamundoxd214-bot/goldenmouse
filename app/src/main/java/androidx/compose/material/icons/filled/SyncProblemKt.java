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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_syncProblem", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SyncProblem", "Landroidx/compose/material/icons/Icons$Filled;", "getSyncProblem", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SyncProblemKt {
    private static ImageVector _syncProblem;

    static {
    }

    public static final ImageVector getSyncProblem(Filled arg19) {
        ImageVector v0 = SyncProblemKt._syncProblem;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.SyncProblem", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(3f, 12f);
        v12.curveToRelative(0f, 2.21f, 0.91f, 4.2f, 2.36f, 5.64f);
        v12.lineTo(3f, 20f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(-6f);
        v12.lineToRelative(-2.24f, 2.24f);
        v12.curveTo(5.68f, 15.15f, 5f, 13.66f, 5f, 12f);
        v12.curveToRelative(0f, -2.61f, 1.67f, -4.83f, 4f, -5.65f);
        v12.lineTo(9f, 4.26f);
        v12.curveTo(5.55f, 5.15f, 3f, 8.27f, 3f, 12f);
        v12.close();
        v12.moveTo(11f, 17f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.close();
        v12.moveTo(21f, 4f);
        v12.horizontalLineToRelative(-6f);
        v12.verticalLineToRelative(6f);
        v12.lineToRelative(2.24f, -2.24f);
        v12.curveTo(18.32f, 8.85f, 19f, 10.34f, 19f, 12f);
        v12.curveToRelative(0f, 2.61f, -1.67f, 4.83f, -4f, 5.65f);
        v12.verticalLineToRelative(2.09f);
        v12.curveToRelative(3.45f, -0.89f, 6f, -4.01f, 6f, -7.74f);
        v12.curveToRelative(0f, -2.21f, -0.91f, -4.2f, -2.36f, -5.64f);
        v12.lineTo(21f, 4f);
        v12.close();
        v12.moveTo(11f, 13f);
        v12.horizontalLineToRelative(2f);
        v12.lineTo(13f, 7f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SyncProblemKt._syncProblem = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

