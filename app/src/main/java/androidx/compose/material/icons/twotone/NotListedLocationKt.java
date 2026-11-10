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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_notListedLocation", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NotListedLocation", "Landroidx/compose/material/icons/Icons$TwoTone;", "getNotListedLocation$annotations", "(Landroidx/compose/material/icons/Icons$TwoTone;)V", "getNotListedLocation", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NotListedLocationKt {
    private static ImageVector _notListedLocation;

    static {
    }

    public static final ImageVector getNotListedLocation(TwoTone arg19) {
        ImageVector v0 = NotListedLocationKt._notListedLocation;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.NotListedLocation", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.5f, 10.2f);
        v12.curveToRelative(0f, 2.57f, -2.1f, 5.79f, -6.16f, 9.51f);
        v12.lineTo(12f, 20.01f);
        v12.lineToRelative(-0.34f, -0.31f);
        v12.curveTo(7.6f, 15.99f, 5.5f, 12.77f, 5.5f, 10.2f);
        v12.curveToRelative(0f, -3.84f, 2.82f, -6.7f, 6.5f, -6.7f);
        v12.reflectiveCurveTo(18.5f, 6.35f, 18.5f, 10.2f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12.01f, 16f);
        v12.curveToRelative(-0.27f, 0f, -0.52f, -0.1f, -0.71f, -0.29f);
        v12.curveToRelative(-0.2f, -0.2f, -0.29f, -0.43f, -0.29f, -0.71f);
        v12.curveToRelative(-0.01f, -0.55f, 0.43f, -0.99f, 0.98f, -1f);
        v12.curveToRelative(0.01f, 0f, 0.01f, 0f, 0.02f, 0f);
        v12.curveToRelative(0.28f, 0f, 0.51f, 0.1f, 0.71f, 0.29f);
        v12.curveToRelative(0.18f, 0.19f, 0.28f, 0.43f, 0.28f, 0.7f);
        v12.reflectiveCurveToRelative(-0.1f, 0.51f, -0.29f, 0.71f);
        v12.reflectiveCurveTo(12.28f, 16f, 12.01f, 16f);
        v12.close();
        v12.moveTo(11.13f, 12.34f);
        v12.curveToRelative(0f, -0.45f, 0.1f, -0.84f, 0.29f, -1.16f);
        v12.curveToRelative(0.19f, -0.33f, 0.53f, -0.7f, 1f, -1.12f);
        v12.curveToRelative(0.28f, -0.25f, 0.48f, -0.47f, 0.61f, -0.66f);
        v12.reflectiveCurveToRelative(0.19f, -0.4f, 0.19f, -0.64f);
        v12.curveToRelative(0f, -0.29f, -0.11f, -0.53f, -0.32f, -0.74f);
        v12.curveToRelative(-0.21f, -0.2f, -0.5f, -0.3f, -0.85f, -0.3f);
        v12.curveToRelative(-0.37f, 0f, -0.74f, 0.1f, -0.96f, 0.3f);
        v12.curveToRelative(-0.21f, 0.2f, -0.4f, 0.45f, -0.4f, 0.98f);
        v12.horizontalLineTo(9f);
        v12.curveToRelative(0f, -1.01f, 0.46f, -1.73f, 0.97f, -2.21f);
        v12.curveTo(10.53f, 6.28f, 11.25f, 6f, 12f, 6f);
        v12.curveToRelative(0.59f, 0f, 1.11f, 0.12f, 1.57f, 0.35f);
        v12.curveTo(14.45f, 6.78f, 15f, 7.68f, 15f, 8.66f);
        v12.curveToRelative(0f, 0.49f, -0.1f, 0.9f, -0.31f, 1.25f);
        v12.reflectiveCurveTo(14.21f, 10.62f, 13.8f, 11f);
        v12.curveToRelative(-0.32f, 0.3f, -0.53f, 0.56f, -0.65f, 0.77f);
        v12.reflectiveCurveToRelative(-0.18f, 0.49f, -0.18f, 0.81f);
        v12.verticalLineTo(13f);
        v12.horizontalLineToRelative(-1.85f);
        v12.verticalLineToRelative(-0.66f);
        v12.horizontalLineTo(11.13f);
        v12.close();
        v12.moveTo(18f, 10.2f);
        v12.curveTo(18f, 6.57f, 15.35f, 4f, 12f, 4f);
        v12.reflectiveCurveToRelative(-6f, 2.57f, -6f, 6.2f);
        v12.curveToRelative(0f, 2.34f, 1.95f, 5.44f, 6f, 9.14f);
        v12.curveTo(16.049999f, 15.64f, 18f, 12.54f, 18f, 10.2f);
        v12.close();
        v12.moveTo(12f, 2f);
        v12.curveToRelative(4.2f, 0f, 8f, 3.22f, 8f, 8.2f);
        v12.curveToRelative(0f, 3.32f, -2.67f, 7.25f, -8f, 11.8f);
        v12.curveToRelative(-5.33f, -4.55f, -8f, -8.48f, -8f, -11.8f);
        v12.curveTo(4f, 5.22f, 7.8f, 2f, 12f, 2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NotListedLocationKt._notListedLocation = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.TwoTone.NotListedLocation", replaceWith="<_subannotation>") public static void getNotListedLocation$annotations(TwoTone arg0) {
    }
}

