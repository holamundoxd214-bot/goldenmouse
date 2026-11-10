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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_pendingActions", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PendingActions", "Landroidx/compose/material/icons/Icons$Sharp;", "getPendingActions", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PendingActionsKt {
    private static ImageVector _pendingActions;

    static {
    }

    public static final ImageVector getPendingActions(Sharp arg19) {
        ImageVector v0 = PendingActionsKt._pendingActions;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.PendingActions", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17f, 12f);
        v12.curveToRelative(-2.76f, 0f, -5f, 2.24f, -5f, 5f);
        v12.reflectiveCurveToRelative(2.24f, 5f, 5f, 5f);
        v12.curveToRelative(2.76f, 0f, 5f, -2.24f, 5f, -5f);
        v12.reflectiveCurveTo(19.76f, 12f, 17f, 12f);
        v12.close();
        v12.moveTo(18.65f, 19.35f);
        v12.lineToRelative(-2.15f, -2.15f);
        v12.verticalLineTo(14f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(2.79f);
        v12.lineToRelative(1.85f, 1.85f);
        v12.lineTo(18.65f, 19.35f);
        v12.close();
        v12.moveTo(20f, 3f);
        v12.horizontalLineToRelative(-5.18f);
        v12.curveTo(14.4f, 1.84f, 13.3f, 1f, 12f, 1f);
        v12.reflectiveCurveTo(9.6f, 1.84f, 9.18f, 3f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(19f);
        v12.horizontalLineToRelative(8.11f);
        v12.curveToRelative(-0.59f, -0.57f, -1.07f, -1.25f, -1.42f, -2f);
        v12.horizontalLineTo(6f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(5.08f);
        v12.curveToRelative(0.71f, 0.1f, 1.38f, 0.31f, 2f, 0.6f);
        v12.verticalLineTo(3f);
        v12.close();
        v12.moveTo(12f, 5f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.curveTo(13f, 4.55f, 12.55f, 5f, 12f, 5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PendingActionsKt._pendingActions = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

