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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noFlash", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoFlash", "Landroidx/compose/material/icons/Icons$TwoTone;", "getNoFlash", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoFlashKt {
    private static ImageVector _noFlash;

    static {
    }

    public static final ImageVector getNoFlash(TwoTone arg19) {
        ImageVector v0 = NoFlashKt._noFlash;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.NoFlash", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13.42f, 16.24f);
        v12.lineToRelative(2.55f, 2.55f);
        v12.lineTo(15.96f, 20f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(-8.6f);
        v12.horizontalLineToRelative(3.02f);
        v12.lineToRelative(0.59f, -0.65f);
        v12.lineToRelative(0.15f, -0.16f);
        v12.lineToRelative(1.5f, 1.5f);
        v12.curveTo(7.68f, 12.43f, 6.5f, 13.82f, 6.5f, 15.5f);
        v12.curveToRelative(0f, 1.93f, 1.57f, 3.5f, 3.5f, 3.5f);
        v12.curveTo(11.68f, 19f, 13.07f, 17.82f, 13.42f, 16.24f);
        v12.close();
        v12.moveTo(16f, 13.17f);
        v12.lineToRelative(0f, -1.77f);
        v12.horizontalLineToRelative(-1.77f);
        v12.lineTo(16f, 13.17f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(20.4f, 5.6f);
        v12.horizontalLineTo(22f);
        v12.lineTo(19f, 11f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineTo(2f);
        v12.horizontalLineToRelative(4f);
        v12.lineTo(20.4f, 5.6f);
        v12.close();
        v12.moveTo(16f, 11.4f);
        v12.verticalLineToRelative(1.77f);
        v12.lineToRelative(2f, 2f);
        v12.verticalLineTo(11f);
        v12.curveToRelative(0f, -0.88f, -0.72f, -1.6f, -1.6f, -1.6f);
        v12.horizontalLineToRelative(-2.54f);
        v12.lineTo(12.58f, 8f);
        v12.horizontalLineToRelative(-1.75f);
        v12.lineToRelative(3.4f, 3.4f);
        v12.horizontalLineTo(16f);
        v12.close();
        v12.moveTo(17.969999f, 17.969999f);
        v12.lineTo(2.1f, 2.1f);
        v12.lineTo(0.69f, 3.51f);
        v12.lineToRelative(5.66f, 5.66f);
        v12.lineTo(6.14f, 9.4f);
        v12.horizontalLineTo(3.6f);
        v12.curveTo(2.72f, 9.4f, 2f, 10.12f, 2f, 11f);
        v12.verticalLineToRelative(9.4f);
        v12.curveTo(2f, 21.280001f, 2.72f, 22f, 3.6f, 22f);
        v12.horizontalLineToRelative(12.8f);
        v12.curveToRelative(0.75f, 0f, 1.38f, -0.52f, 1.55f, -1.22f);
        v12.lineToRelative(2.54f, 2.54f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(17.969999f, 17.969999f);
        v12.close();
        v12.moveTo(11.5f, 15.5f);
        v12.curveToRelative(0f, 0.83f, -0.67f, 1.5f, -1.5f, 1.5f);
        v12.reflectiveCurveToRelative(-1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveTo(9.17f, 14f, 10f, 14f);
        v12.reflectiveCurveTo(11.5f, 14.67f, 11.5f, 15.5f);
        v12.close();
        v12.moveTo(15.96f, 20f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(-8.6f);
        v12.horizontalLineToRelative(2.14f);
        v12.horizontalLineToRelative(0.88f);
        v12.lineToRelative(0.59f, -0.65f);
        v12.lineToRelative(0.15f, -0.16f);
        v12.lineToRelative(1.5f, 1.5f);
        v12.curveTo(7.68f, 12.43f, 6.5f, 13.82f, 6.5f, 15.5f);
        v12.curveToRelative(0f, 1.93f, 1.57f, 3.5f, 3.5f, 3.5f);
        v12.curveToRelative(1.68f, 0f, 3.07f, -1.18f, 3.42f, -2.76f);
        v12.lineToRelative(2.55f, 2.55f);
        v12.lineTo(15.96f, 20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoFlashKt._noFlash = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

