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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sailing", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Sailing", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSailing", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SailingKt {
    private static ImageVector _sailing;

    static {
    }

    public static final ImageVector getSailing(TwoTone arg19) {
        ImageVector v0 = SailingKt._sailing;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Sailing", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9f, 11.5f);
        v12.horizontalLineTo(6.83f);
        v12.lineTo(9f, 8.38f);
        v12.verticalLineTo(11.5f);
        v12.close();
        v12.moveTo(15.38f, 5.24f);
        v12.curveToRelative(1.42f, 1.52f, 2.88f, 3.72f, 3.41f, 6.26f);
        v12.horizontalLineToRelative(-3.68f);
        v12.curveToRelative(0.21f, -1.1f, 0.39f, -2.46f, 0.39f, -4f);
        v12.curveTo(15.5f, 6.71f, 15.45f, 5.95f, 15.38f, 5.24f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(11f, 13.5f);
        v12.verticalLineTo(2f);
        v12.lineTo(3f, 13.5f);
        v12.horizontalLineTo(11f);
        v12.close();
        v12.moveTo(9f, 11.5f);
        v12.horizontalLineTo(6.83f);
        v12.lineTo(9f, 8.38f);
        v12.verticalLineTo(11.5f);
        v12.close();
        v12.moveTo(21f, 13.5f);
        v12.curveTo(21f, 6.5f, 14.5f, 1f, 12.5f, 1f);
        v12.curveToRelative(0f, 0f, 1f, 3f, 1f, 6.5f);
        v12.reflectiveCurveToRelative(-1f, 6f, -1f, 6f);
        v12.horizontalLineTo(21f);
        v12.close();
        v12.moveTo(15.38f, 5.24f);
        v12.curveToRelative(1.42f, 1.52f, 2.88f, 3.72f, 3.41f, 6.26f);
        v12.horizontalLineToRelative(-3.68f);
        v12.curveToRelative(0.21f, -1.1f, 0.39f, -2.46f, 0.39f, -4f);
        v12.curveTo(15.5f, 6.71f, 15.45f, 5.95f, 15.38f, 5.24f);
        v12.close();
        v12.moveTo(22f, 15f);
        v12.horizontalLineTo(2f);
        v12.curveToRelative(0.31f, 1.53f, 1.16f, 2.84f, 2.33f, 3.73f);
        v12.curveTo(4.98f, 18.459999f, 5.55f, 18.01f, 6f, 17.5f);
        v12.curveTo(6.73f, 18.34f, 7.8f, 19f, 9f, 19f);
        v12.reflectiveCurveToRelative(2.27f, -0.66f, 3f, -1.5f);
        v12.curveToRelative(0.73f, 0.84f, 1.8f, 1.5f, 3f, 1.5f);
        v12.reflectiveCurveToRelative(2.26f, -0.66f, 3f, -1.5f);
        v12.curveToRelative(0.45f, 0.51f, 1.02f, 0.96f, 1.67f, 1.23f);
        v12.curveTo(20.84f, 17.84f, 21.690001f, 16.530001f, 22f, 15f);
        v12.close();
        v12.moveTo(22f, 23f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-1f);
        v12.curveToRelative(-1.04f, 0f, -2.08f, -0.35f, -3f, -1f);
        v12.curveToRelative(-1.83f, 1.3f, -4.17f, 1.3f, -6f, 0f);
        v12.curveToRelative(-1.83f, 1.3f, -4.17f, 1.3f, -6f, 0f);
        v12.curveToRelative(-0.91f, 0.65f, -1.96f, 1f, -3f, 1f);
        v12.horizontalLineTo(2f);
        v12.lineToRelative(0f, 2f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(1.03f, 0f, 2.05f, -0.25f, 3f, -0.75f);
        v12.curveToRelative(1.89f, 1f, 4.11f, 1f, 6f, 0f);
        v12.curveToRelative(1.89f, 1f, 4.11f, 1f, 6f, 0f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.95f, 0.5f, 1.97f, 0.75f, 3f, 0.75f);
        v12.horizontalLineTo(22f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SailingKt._sailing = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

