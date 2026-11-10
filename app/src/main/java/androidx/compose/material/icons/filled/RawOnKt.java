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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_rawOn", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RawOn", "Landroidx/compose/material/icons/Icons$Filled;", "getRawOn", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RawOnKt {
    private static ImageVector _rawOn;

    static {
    }

    public static final ImageVector getRawOn(Filled arg19) {
        ImageVector v0 = RawOnKt._rawOn;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.RawOn", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6.5f, 9f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(1.5f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(1.1f);
        v12.lineToRelative(0.9f, 2f);
        v12.horizontalLineTo(8f);
        v12.lineToRelative(-0.9f, -2.1f);
        v12.curveTo(7.6f, 12.6f, 8f, 12.1f, 8f, 11.5f);
        v12.verticalLineToRelative(-1f);
        v12.curveTo(8f, 9.7f, 7.3f, 9f, 6.5f, 9f);
        v12.close();
        v12.moveTo(6.5f, 11.5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(11.5f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(10.25f, 9f);
        v0_1.lineToRelative(-1.5f, 6f);
        v0_1.horizontalLineToRelative(1.5f);
        v0_1.lineToRelative(0.38f, -1.5f);
        v0_1.horizontalLineToRelative(1.75f);
        v0_1.lineToRelative(0.37f, 1.5f);
        v0_1.horizontalLineToRelative(1.5f);
        v0_1.lineToRelative(-1.5f, -6f);
        v0_1.horizontalLineTo(10.25f);
        v0_1.close();
        v0_1.moveTo(11f, 12f);
        v0_1.lineToRelative(0.25f, -1f);
        v0_1.horizontalLineToRelative(0.5f);
        v0_1.lineTo(12f, 12f);
        v0_1.horizontalLineTo(11f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(19.98f, 9f);
        v0_1.lineToRelative(-0.74f, 3f);
        v0_1.lineToRelative(-0.74f, -3f);
        v0_1.lineToRelative(-1.52f, 0f);
        v0_1.lineToRelative(-0.74f, 3f);
        v0_1.lineToRelative(-0.74f, -3f);
        v0_1.lineToRelative(-1.5f, 0f);
        v0_1.lineToRelative(1.5f, 6f);
        v0_1.lineToRelative(1.48f, 0f);
        v0_1.lineToRelative(0.76f, -3.04f);
        v0_1.lineToRelative(0.76f, 3.04f);
        v0_1.lineToRelative(1.48f, 0f);
        v0_1.lineToRelative(1.5f, -6f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RawOnKt._rawOn = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

