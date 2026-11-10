package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_pushPin", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PushPin", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPushPin", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PushPinKt {
    private static ImageVector _pushPin;

    static {
    }

    public static final ImageVector getPushPin(TwoTone arg19) {
        ImageVector v0 = PushPinKt._pushPin;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.PushPin", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14f, 4f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineToRelative(5f);
        v12.curveToRelative(0f, 1.1f, -0.35f, 2.14f, -1f, 3f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(-0.63f, -0.84f, -1f, -1.88f, -1f, -3f);
        v12.verticalLineTo(4f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(19f, 12f);
        v12.curveToRelative(-1.66f, 0f, -3f, -1.34f, -3f, -3f);
        v12.verticalLineTo(4f);
        v12.lineToRelative(1f, 0f);
        v12.curveToRelative(0f, 0f, 0f, 0f, 0f, 0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(7f);
        v12.curveTo(6.45f, 2f, 6f, 2.45f, 6f, 3f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.curveToRelative(0f, 0f, 0f, 0f, 0f, 0f);
        v12.lineToRelative(1f, 0f);
        v12.verticalLineToRelative(5f);
        v12.curveToRelative(0f, 1.66f, -1.34f, 3f, -3f, 3f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(5.97f);
        v12.verticalLineToRelative(7f);
        v12.lineToRelative(1f, 1f);
        v12.lineToRelative(1f, -1f);
        v12.verticalLineToRelative(-7f);
        v12.horizontalLineTo(19f);
        v12.lineTo(19f, 12f);
        v12.curveTo(19f, 12f, 19f, 12f, 19f, 12f);
        v12.close();
        v12.moveTo(9f, 12f);
        v12.curveToRelative(0.65f, -0.86f, 1f, -1.9f, 1f, -3f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(5f);
        v12.curveToRelative(0f, 1.12f, 0.37f, 2.16f, 1f, 3f);
        v12.horizontalLineTo(9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PushPinKt._pushPin = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

