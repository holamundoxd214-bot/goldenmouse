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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_linkOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LinkOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getLinkOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LinkOffKt {
    private static ImageVector _linkOff;

    static {
    }

    public static final ImageVector getLinkOff(Rounded arg19) {
        ImageVector v0 = LinkOffKt._linkOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.LinkOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14f, 9f);
        v12.horizontalLineToRelative(2.87f);
        v12.curveToRelative(1.46f, 0f, 2.8f, 0.98f, 3.08f, 2.42f);
        v12.curveToRelative(0.31f, 1.64f, -0.74f, 3.11f, -2.22f, 3.48f);
        v12.lineToRelative(1.53f, 1.53f);
        v12.curveToRelative(1.77f, -0.91f, 2.95f, -2.82f, 2.7f, -5.01f);
        v12.curveTo(21.68f, 8.86f, 19.370001f, 7f, 16.790001f, 7f);
        v12.horizontalLineTo(14f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.curveTo(13f, 8.55f, 13.45f, 9f, 14f, 9f);
        v12.close();
        v12.moveTo(3.51f, 3.51f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(2.64f, 2.64f);
        v12.curveToRelative(-1.77f, 0.91f, -2.95f, 2.82f, -2.7f, 5.01f);
        v12.curveTo(2.32f, 15.14f, 4.63f, 17f, 7.21f, 17f);
        v12.horizontalLineTo(10f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(7.13f);
        v12.curveToRelative(-1.46f, 0f, -2.8f, -0.98f, -3.08f, -2.42f);
        v12.curveTo(3.74f, 10.94f, 4.8f, 9.47f, 6.27f, 9.1f);
        v12.lineToRelative(2.12f, 2.12f);
        v12.curveTo(8.16f, 11.41f, 8f, 11.68f, 8f, 12f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(1.17f);
        v12.lineToRelative(8.9f, 8.9f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(3.51f, 3.51f);
        v12.close();
        v12.moveTo(14f, 11f);
        v12.lineToRelative(1.71f, 1.71f);
        v12.curveTo(15.89f, 12.53f, 16f, 12.28f, 16f, 12f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LinkOffKt._linkOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

