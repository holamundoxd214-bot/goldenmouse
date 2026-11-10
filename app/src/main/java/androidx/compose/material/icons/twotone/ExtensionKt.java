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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_extension", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Extension", "Landroidx/compose/material/icons/Icons$TwoTone;", "getExtension", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ExtensionKt {
    private static ImageVector _extension;

    static {
    }

    public static final ImageVector getExtension(TwoTone arg19) {
        ImageVector v0 = ExtensionKt._extension;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Extension", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 13f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(-6f);
        v12.verticalLineTo(5f);
        v12.curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f);
        v12.reflectiveCurveToRelative(-0.5f, 0.22f, -0.5f, 0.5f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(4f);
        v12.lineToRelative(0.01f, 2.12f);
        v12.curveTo(5.76f, 9.8f, 7f, 11.51f, 7f, 13.5f);
        v12.curveToRelative(0f, 1.99f, -1.25f, 3.7f, -3f, 4.38f);
        v12.verticalLineTo(20f);
        v12.horizontalLineToRelative(2.12f);
        v12.curveToRelative(0.68f, -1.75f, 2.39f, -3f, 4.38f, -3f);
        v12.curveToRelative(1.99f, 0f, 3.7f, 1.25f, 4.38f, 3f);
        v12.horizontalLineTo(17f);
        v12.verticalLineToRelative(-6f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f);
        v12.reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(19f, 11f);
        v12.lineTo(19f, 7f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-4f);
        v12.curveToRelative(0f, -1.38f, -1.12f, -2.5f, -2.5f, -2.5f);
        v12.reflectiveCurveTo(8f, 3.62f, 8f, 5f);
        v12.lineTo(4f, 5f);
        v12.curveToRelative(-1.1f, 0f, -1.99f, 0.9f, -1.99f, 2f);
        v12.verticalLineToRelative(3.8f);
        v12.horizontalLineToRelative(0.29f);
        v12.curveToRelative(1.49f, 0f, 2.7f, 1.21f, 2.7f, 2.7f);
        v12.reflectiveCurveToRelative(-1.21f, 2.7f, -2.7f, 2.7f);
        v12.lineTo(2f, 16.200001f);
        v12.lineTo(2f, 20f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(3.8f);
        v12.verticalLineToRelative(-0.3f);
        v12.curveToRelative(0f, -1.49f, 1.21f, -2.7f, 2.7f, -2.7f);
        v12.reflectiveCurveToRelative(2.7f, 1.21f, 2.7f, 2.7f);
        v12.verticalLineToRelative(0.3f);
        v12.lineTo(17f, 22f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-4f);
        v12.curveToRelative(1.38f, 0f, 2.5f, -1.12f, 2.5f, -2.5f);
        v12.reflectiveCurveTo(20.379999f, 11f, 19f, 11f);
        v12.close();
        v12.moveTo(19f, 14f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(-2.12f);
        v12.curveToRelative(-0.68f, -1.75f, -2.39f, -3f, -4.38f, -3f);
        v12.curveToRelative(-1.99f, 0f, -3.7f, 1.25f, -4.38f, 3f);
        v12.lineTo(4f, 20f);
        v12.verticalLineToRelative(-2.12f);
        v12.curveToRelative(1.75f, -0.68f, 3f, -2.39f, 3f, -4.38f);
        v12.curveToRelative(0f, -1.99f, -1.24f, -3.7f, -2.99f, -4.38f);
        v12.lineTo(4f, 7f);
        v12.horizontalLineToRelative(6f);
        v12.lineTo(10f, 5f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f);
        v12.reflectiveCurveToRelative(-0.22f, 0.5f, -0.5f, 0.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ExtensionKt._extension = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

