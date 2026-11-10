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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_snowmobile", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Snowmobile", "Landroidx/compose/material/icons/Icons$Rounded;", "getSnowmobile", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SnowmobileKt {
    private static ImageVector _snowmobile;

    static {
    }

    public static final ImageVector getSnowmobile(Rounded arg19) {
        ImageVector v0 = SnowmobileKt._snowmobile;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Snowmobile", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11f, 6f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(1.25f);
        v12.lineToRelative(1.45f, 1.3f);
        v12.lineTo(11f, 11f);
        v12.lineToRelative(-9.12f, -0.96f);
        v12.curveTo(0.88f, 9.93f, 0f, 10.72f, 0f, 11.73f);
        v12.curveToRelative(0f, 0.75f, 0.49f, 1.41f, 1.21f, 1.63f);
        v12.lineToRelative(3.33f, 1f);
        v12.lineToRelative(-3.49f, 1.88f);
        v12.curveTo(-0.77f, 17.219999f, -0.07f, 20f, 2f, 20f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(2.21f, 0f, 4f, -1.79f, 4f, -4f);
        v12.horizontalLineToRelative(4f);
        v12.lineToRelative(2f, 2f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(5f);
        v12.curveToRelative(1.13f, 0f, 2.11f, -0.62f, 2.63f, -1.55f);
        v12.curveToRelative(0.36f, -0.65f, -0.15f, -1.45f, -0.9f, -1.45f);
        v12.curveToRelative(-0.34f, 0f, -0.68f, 0.16f, -0.84f, 0.47f);
        v12.curveTo(21.719999f, 17.780001f, 21.379999f, 18f, 21f, 18f);
        v12.horizontalLineToRelative(-0.17f);
        v12.lineToRelative(-2.2f, -2.2f);
        v12.curveTo(20.58f, 15.37f, 22f, 14.4f, 22f, 13f);
        v12.curveToRelative(0f, -0.89f, -7.72f, -7.75f, -7.72f, -7.75f);
        v12.curveTo(14.1f, 5.09f, 13.87f, 5f, 13.62f, 5f);
        v12.horizontalLineTo(12f);
        v12.curveTo(11.45f, 5f, 11f, 5.45f, 11f, 6f);
        v12.close();
        v12.moveTo(8f, 18f);
        v12.horizontalLineTo(2f);
        v12.lineToRelative(5.25f, -2.83f);
        v12.lineTo(10f, 16f);
        v12.curveTo(10f, 17.1f, 9.11f, 18f, 8f, 18f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SnowmobileKt._snowmobile = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

