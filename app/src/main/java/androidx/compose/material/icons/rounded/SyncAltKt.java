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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_syncAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SyncAlt", "Landroidx/compose/material/icons/Icons$Rounded;", "getSyncAlt", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SyncAltKt {
    private static ImageVector _syncAlt;

    static {
    }

    public static final ImageVector getSyncAlt(Rounded arg19) {
        ImageVector v0 = SyncAltKt._syncAlt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SyncAlt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.65f, 7.65f);
        v12.lineToRelative(-2.79f, -2.79f);
        v12.curveTo(18.540001f, 4.54f, 18f, 4.76f, 18f, 5.21f);
        v12.verticalLineTo(7f);
        v12.horizontalLineTo(4f);
        v12.curveTo(3.45f, 7f, 3f, 7.45f, 3f, 8f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineToRelative(1.79f);
        v12.curveToRelative(0f, 0.45f, 0.54f, 0.67f, 0.85f, 0.35f);
        v12.lineToRelative(2.79f, -2.79f);
        v12.curveTo(21.84f, 8.16f, 21.84f, 7.84f, 21.65f, 7.65f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(20f, 15f);
        v12.horizontalLineTo(6f);
        v12.verticalLineToRelative(-1.79f);
        v12.curveToRelative(0f, -0.45f, -0.54f, -0.67f, -0.85f, -0.35f);
        v12.lineToRelative(-2.79f, 2.79f);
        v12.curveToRelative(-0.2f, 0.19f, -0.2f, 0.51f, -0.01f, 0.7f);
        v12.lineToRelative(2.79f, 2.79f);
        v12.curveTo(5.46f, 19.459999f, 6f, 19.24f, 6f, 18.790001f);
        v12.verticalLineTo(17f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveTo(20.549999f, 15f, 20f, 15f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SyncAltKt._syncAlt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

