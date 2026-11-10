package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_android", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Android", "Landroidx/compose/material/icons/Icons$Outlined;", "getAndroid", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AndroidKt {
    private static ImageVector _android;

    static {
    }

    public static final ImageVector getAndroid(Outlined arg19) {
        ImageVector v0 = AndroidKt._android;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Android", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.6f, 9.48f);
        v12.lineToRelative(1.84f, -3.18f);
        v12.curveToRelative(0.16f, -0.31f, 0.04f, -0.69f, -0.26f, -0.85f);
        v12.curveToRelative(-0.29f, -0.15f, -0.65f, -0.06f, -0.83f, 0.22f);
        v12.lineToRelative(-1.88f, 3.24f);
        v12.curveToRelative(-2.86f, -1.21f, -6.08f, -1.21f, -8.94f, 0f);
        v12.lineTo(5.65f, 5.67f);
        v12.curveToRelative(-0.19f, -0.29f, -0.58f, -0.38f, -0.87f, -0.2f);
        v12.curveTo(4.5f, 5.65f, 4.41f, 6.01f, 4.56f, 6.3f);
        v12.lineTo(6.4f, 9.48f);
        v12.curveTo(3.3f, 11.25f, 1.28f, 14.44f, 1f, 18f);
        v12.horizontalLineToRelative(22f);
        v12.curveTo(22.719999f, 14.44f, 20.700001f, 11.25f, 17.6f, 9.48f);
        v12.close();
        v12.moveTo(7f, 15.25f);
        v12.curveToRelative(-0.69f, 0f, -1.25f, -0.56f, -1.25f, -1.25f);
        v12.curveToRelative(0f, -0.69f, 0.56f, -1.25f, 1.25f, -1.25f);
        v12.reflectiveCurveTo(8.25f, 13.31f, 8.25f, 14f);
        v12.curveTo(8.25f, 14.69f, 7.69f, 15.25f, 7f, 15.25f);
        v12.close();
        v12.moveTo(17f, 15.25f);
        v12.curveToRelative(-0.69f, 0f, -1.25f, -0.56f, -1.25f, -1.25f);
        v12.curveToRelative(0f, -0.69f, 0.56f, -1.25f, 1.25f, -1.25f);
        v12.reflectiveCurveToRelative(1.25f, 0.56f, 1.25f, 1.25f);
        v12.curveTo(18.25f, 14.69f, 17.690001f, 15.25f, 17f, 15.25f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AndroidKt._android = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

