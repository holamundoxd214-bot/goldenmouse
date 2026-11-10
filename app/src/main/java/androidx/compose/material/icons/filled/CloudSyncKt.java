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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_cloudSync", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CloudSync", "Landroidx/compose/material/icons/Icons$Filled;", "getCloudSync", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CloudSyncKt {
    private static ImageVector _cloudSync;

    static {
    }

    public static final ImageVector getCloudSync(Filled arg19) {
        ImageVector v0 = CloudSyncKt._cloudSync;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.CloudSync", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.5f, 14.98f);
        v12.curveToRelative(-0.02f, 0f, -0.03f, 0f, -0.05f, 0.01f);
        v12.curveTo(21.200001f, 13.3f, 19.76f, 12f, 18f, 12f);
        v12.curveToRelative(-1.4f, 0f, -2.6f, 0.83f, -3.16f, 2.02f);
        v12.curveTo(13.26f, 14.1f, 12f, 15.4f, 12f, 17f);
        v12.curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f);
        v12.lineToRelative(6.5f, -0.02f);
        v12.curveToRelative(1.38f, 0f, 2.5f, -1.12f, 2.5f, -2.5f);
        v12.reflectiveCurveTo(22.879999f, 14.98f, 21.5f, 14.98f);
        v12.close();
        v12.moveTo(10f, 4.26f);
        v12.verticalLineToRelative(2.09f);
        v12.curveTo(7.67f, 7.18f, 6f, 9.39f, 6f, 12f);
        v12.curveToRelative(0f, 1.77f, 0.78f, 3.34f, 2f, 4.44f);
        v12.verticalLineTo(14f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(2.73f);
        v12.curveTo(5.06f, 16.540001f, 4f, 14.4f, 4f, 12f);
        v12.curveTo(4f, 8.27f, 6.55f, 5.15f, 10f, 4.26f);
        v12.close();
        v12.moveTo(20f, 6f);
        v12.horizontalLineToRelative(-2.73f);
        v12.curveToRelative(1.43f, 1.26f, 2.41f, 3.01f, 2.66f, 5f);
        v12.lineToRelative(-2.02f, 0f);
        v12.curveTo(17.68f, 9.64f, 16.98f, 8.45f, 16f, 7.56f);
        v12.verticalLineTo(10f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineTo(6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CloudSyncKt._cloudSync = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

