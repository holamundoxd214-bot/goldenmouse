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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_openInNewOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "OpenInNewOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getOpenInNewOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class OpenInNewOffKt {
    private static ImageVector _openInNewOff;

    static {
    }

    public static final ImageVector getOpenInNewOff(Rounded arg19) {
        ImageVector v0 = OpenInNewOffKt._openInNewOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.OpenInNewOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16.790001f, 5.8f);
        v12.lineToRelative(-1.94f, -1.94f);
        v12.curveTo(14.54f, 3.54f, 14.76f, 3f, 15.21f, 3f);
        v12.horizontalLineToRelative(5.29f);
        v12.curveTo(20.780001f, 3f, 21f, 3.22f, 21f, 3.5f);
        v12.verticalLineToRelative(5.29f);
        v12.curveToRelative(0f, 0.45f, -0.54f, 0.67f, -0.85f, 0.35f);
        v12.lineTo(18.209999f, 7.2f);
        v12.lineToRelative(-4.09f, 4.09f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.lineTo(16.790001f, 5.8f);
        v12.close();
        v12.moveTo(19f, 13f);
        v12.verticalLineToRelative(3.17f);
        v12.lineToRelative(2f, 2f);
        v12.verticalLineTo(13f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(20f);
        v12.curveTo(19.450001f, 12f, 19f, 12.45f, 19f, 13f);
        v12.close();
        v12.moveTo(19.07f, 21.9f);
        v12.lineToRelative(-0.9f, -0.9f);
        v12.horizontalLineTo(5f);
        v12.curveToRelative(-1.11f, 0f, -2f, -0.9f, -2f, -2f);
        v12.verticalLineTo(5.83f);
        v12.lineToRelative(-0.9f, -0.9f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0f);
        v12.lineToRelative(16.969999f, 16.969999f);
        v12.curveToRelative(0.39f, 0.39f, 0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(20.09f, 22.290001f, 19.459999f, 22.290001f, 19.07f, 21.9f);
        v12.close();
        v12.moveTo(16.17f, 19f);
        v12.lineToRelative(-4.88f, -4.88f);
        v12.lineTo(10.41f, 15f);
        v12.curveToRelative(-0.39f, 0.39f, -1.02f, 0.39f, -1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(0.88f, -0.88f);
        v12.lineTo(5f, 7.83f);
        v12.verticalLineTo(19f);
        v12.horizontalLineTo(16.17f);
        v12.close();
        v12.moveTo(7.83f, 5f);
        v12.horizontalLineTo(11f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(4f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(5.83f);
        v12.lineTo(7.83f, 5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        OpenInNewOffKt._openInNewOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

