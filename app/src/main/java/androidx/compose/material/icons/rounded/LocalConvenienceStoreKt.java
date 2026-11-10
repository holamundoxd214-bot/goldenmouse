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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_localConvenienceStore", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocalConvenienceStore", "Landroidx/compose/material/icons/Icons$Rounded;", "getLocalConvenienceStore", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LocalConvenienceStoreKt {
    private static ImageVector _localConvenienceStore;

    static {
    }

    public static final ImageVector getLocalConvenienceStore(Rounded arg19) {
        ImageVector v0 = LocalConvenienceStoreKt._localConvenienceStore;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.LocalConvenienceStore", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.9f, 7.89f);
        v12.lineToRelative(-1.05f, -3.37f);
        v12.curveToRelative(-0.22f, -0.9f, -1f, -1.52f, -1.91f, -1.52f);
        v12.horizontalLineTo(5.05f);
        v12.curveToRelative(-0.9f, 0f, -1.69f, 0.63f, -1.9f, 1.52f);
        v12.lineTo(2.1f, 7.89f);
        v12.curveTo(1.64f, 9.86f, 2.95f, 11f, 3f, 11.06f);
        v12.verticalLineTo(19f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-7.94f);
        v12.curveTo(22.120001f, 9.94f, 22.09f, 8.65f, 21.9f, 7.89f);
        v12.close();
        v12.moveTo(13f, 5f);
        v12.horizontalLineToRelative(1.96f);
        v12.lineToRelative(0.54f, 3.52f);
        v12.curveTo(15.59f, 9.23f, 15.11f, 10f, 14.22f, 10f);
        v12.curveTo(13.55f, 10f, 13f, 9.41f, 13f, 8.69f);
        v12.verticalLineTo(5f);
        v12.close();
        v12.moveTo(6.44f, 8.86f);
        v12.curveTo(6.36f, 9.51f, 5.84f, 10f, 5.23f, 10f);
        v12.curveTo(4.3f, 10f, 3.88f, 9.03f, 4.04f, 8.36f);
        v12.lineTo(5.05f, 5f);
        v12.horizontalLineToRelative(1.97f);
        v12.lineTo(6.44f, 8.86f);
        v12.close();
        v12.moveTo(10.5f, 16f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(1.5f);
        v12.curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f);
        v12.horizontalLineToRelative(-2f);
        v12.curveTo(8.22f, 18f, 8f, 17.780001f, 8f, 17.5f);
        v12.verticalLineToRelative(-2f);
        v12.curveTo(8f, 15.22f, 8.22f, 15f, 8.5f, 15f);
        v12.horizontalLineTo(10f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineTo(8.5f);
        v12.curveTo(8.22f, 14f, 8f, 13.78f, 8f, 13.5f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(8f, 13.22f, 8.22f, 13f, 8.5f, 13f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f);
        v12.verticalLineToRelative(2f);
        v12.curveTo(11f, 15.78f, 10.78f, 16f, 10.5f, 16f);
        v12.close();
        v12.moveTo(11f, 8.69f);
        v12.curveTo(11f, 9.41f, 10.45f, 10f, 9.71f, 10f);
        v12.curveToRelative(-0.75f, 0f, -1.3f, -0.7f, -1.22f, -1.48f);
        v12.lineTo(9.04f, 5f);
        v12.horizontalLineTo(11f);
        v12.verticalLineTo(8.69f);
        v12.close();
        v12.moveTo(15.5f, 18f);
        v12.lineTo(15.5f, 18f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f);
        v12.verticalLineTo(16f);
        v12.horizontalLineToRelative(-1.5f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f);
        v12.verticalLineTo(15f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(-1.5f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f);
        v12.verticalLineToRelative(4f);
        v12.curveTo(16f, 17.780001f, 15.78f, 18f, 15.5f, 18f);
        v12.close();
        v12.moveTo(18.77f, 10f);
        v12.curveToRelative(-0.61f, 0f, -1.14f, -0.49f, -1.21f, -1.14f);
        v12.lineTo(16.98f, 5f);
        v12.lineToRelative(1.93f, -0.01f);
        v12.lineToRelative(1.05f, 3.37f);
        v12.curveTo(20.120001f, 9.03f, 19.709999f, 10f, 18.77f, 10f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LocalConvenienceStoreKt._localConvenienceStore = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

