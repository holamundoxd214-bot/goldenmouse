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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_workspaces", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Workspaces", "Landroidx/compose/material/icons/Icons$Sharp;", "getWorkspaces", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WorkspacesKt {
    private static ImageVector _workspaces;

    static {
    }

    public static final ImageVector getWorkspaces(Sharp arg19) {
        ImageVector v0 = WorkspacesKt._workspaces;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Workspaces", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6f, 13f);
        v12.curveToRelative(-2.2f, 0f, -4f, 1.8f, -4f, 4f);
        v12.reflectiveCurveToRelative(1.8f, 4f, 4f, 4f);
        v12.reflectiveCurveToRelative(4f, -1.8f, 4f, -4f);
        v12.reflectiveCurveTo(8.2f, 13f, 6f, 13f);
        v12.close();
        v12.moveTo(12f, 3f);
        v12.curveTo(9.8f, 3f, 8f, 4.8f, 8f, 7f);
        v12.reflectiveCurveToRelative(1.8f, 4f, 4f, 4f);
        v12.reflectiveCurveToRelative(4f, -1.8f, 4f, -4f);
        v12.reflectiveCurveTo(14.2f, 3f, 12f, 3f);
        v12.close();
        v12.moveTo(18f, 13f);
        v12.curveToRelative(-2.2f, 0f, -4f, 1.8f, -4f, 4f);
        v12.reflectiveCurveToRelative(1.8f, 4f, 4f, 4f);
        v12.reflectiveCurveToRelative(4f, -1.8f, 4f, -4f);
        v12.reflectiveCurveTo(20.200001f, 13f, 18f, 13f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WorkspacesKt._workspaces = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

