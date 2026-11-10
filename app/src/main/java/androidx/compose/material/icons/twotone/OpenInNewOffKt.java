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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_openInNewOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "OpenInNewOff", "Landroidx/compose/material/icons/Icons$TwoTone;", "getOpenInNewOff", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class OpenInNewOffKt {
    private static ImageVector _openInNewOff;

    static {
    }

    public static final ImageVector getOpenInNewOff(TwoTone arg19) {
        ImageVector v0 = OpenInNewOffKt._openInNewOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.OpenInNewOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16.790001f, 5.8f);
        v12.lineTo(14f, 3f);
        v12.horizontalLineToRelative(7f);
        v12.verticalLineToRelative(7f);
        v12.lineToRelative(-2.79f, -2.8f);
        v12.lineToRelative(-4.09f, 4.09f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.lineTo(16.790001f, 5.8f);
        v12.close();
        v12.moveTo(19f, 12f);
        v12.verticalLineToRelative(4.17f);
        v12.lineToRelative(2f, 2f);
        v12.verticalLineTo(12f);
        v12.horizontalLineTo(19f);
        v12.close();
        v12.moveTo(19.780001f, 22.610001f);
        v12.lineTo(18.17f, 21f);
        v12.horizontalLineTo(5f);
        v12.curveToRelative(-1.11f, 0f, -2f, -0.9f, -2f, -2f);
        v12.verticalLineTo(5.83f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(18.379999f, 18.379999f);
        v12.lineTo(19.780001f, 22.610001f);
        v12.close();
        v12.moveTo(16.17f, 19f);
        v12.lineToRelative(-4.88f, -4.88f);
        v12.lineTo(9.7f, 15.71f);
        v12.lineTo(8.29f, 14.3f);
        v12.lineToRelative(1.59f, -1.59f);
        v12.lineTo(5f, 7.83f);
        v12.verticalLineTo(19f);
        v12.horizontalLineTo(16.17f);
        v12.close();
        v12.moveTo(7.83f, 5f);
        v12.horizontalLineTo(12f);
        v12.verticalLineTo(3f);
        v12.horizontalLineTo(5.83f);
        v12.lineTo(7.83f, 5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        OpenInNewOffKt._openInNewOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

