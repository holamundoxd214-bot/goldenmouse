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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_tram", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Tram", "Landroidx/compose/material/icons/Icons$TwoTone;", "getTram", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TramKt {
    private static ImageVector _tram;

    static {
    }

    public static final ImageVector getTram(TwoTone arg19) {
        ImageVector v0 = TramKt._tram;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Tram", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.97f, 7f);
        v12.horizontalLineToRelative(-1.94f);
        v12.curveToRelative(-2.75f, 0.08f, -3.62f, 0.58f, -3.9f, 1f);
        v12.horizontalLineToRelative(9.74f);
        v12.curveToRelative(-0.28f, -0.42f, -1.15f, -0.92f, -3.9f, -1f);
        v12.close();
        v12.moveTo(7f, 16f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.45f, 0.3f, 0.84f, 0.74f, 0.95f);
        v12.horizontalLineToRelative(3.11f);
        v12.curveToRelative(-0.22f, -0.26f, -0.35f, -0.59f, -0.35f, -0.95f);
        v12.curveToRelative(0f, -0.39f, 0.15f, -0.73f, 0.39f, -1f);
        v12.lineTo(7f, 16f);
        v12.close();
        v12.moveTo(13.5f, 17f);
        v12.curveToRelative(0f, 0.36f, -0.13f, 0.69f, -0.35f, 0.95f);
        v12.horizontalLineToRelative(3.11f);
        v12.curveToRelative(0.44f, -0.11f, 0.74f, -0.5f, 0.74f, -0.95f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(-3.89f);
        v12.curveToRelative(0.24f, 0.27f, 0.39f, 0.61f, 0.39f, 1f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(13f, 5f);
        v12.lineToRelative(0.75f, -1.5f);
        v12.lineTo(17f, 3.5f);
        v12.lineTo(17f, 2f);
        v12.lineTo(7f, 2f);
        v12.verticalLineToRelative(1.5f);
        v12.horizontalLineToRelative(4.75f);
        v12.lineTo(11f, 5f);
        v12.curveToRelative(-3.13f, 0.09f, -6f, 0.73f, -6f, 3.5f);
        v12.lineTo(5f, 17f);
        v12.curveToRelative(0f, 1.5f, 1.11f, 2.73f, 2.55f, 2.95f);
        v12.lineTo(6f, 21.5f);
        v12.verticalLineToRelative(0.5f);
        v12.horizontalLineToRelative(2f);
        v12.lineToRelative(2f, -2f);
        v12.horizontalLineToRelative(4f);
        v12.lineToRelative(2f, 2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-0.5f);
        v12.lineToRelative(-1.55f, -1.55f);
        v12.horizontalLineToRelative(-0.01f);
        v12.horizontalLineToRelative(0.01f);
        v12.curveTo(17.889999f, 19.73f, 19f, 18.5f, 19f, 17f);
        v12.lineTo(19f, 8.5f);
        v12.curveToRelative(0f, -2.77f, -2.87f, -3.41f, -6f, -3.5f);
        v12.close();
        v12.moveTo(11.03f, 7f);
        v12.horizontalLineToRelative(1.94f);
        v12.curveToRelative(2.75f, 0.08f, 3.62f, 0.58f, 3.9f, 1f);
        v12.lineTo(7.13f, 8f);
        v12.curveToRelative(0.28f, -0.42f, 1.15f, -0.92f, 3.9f, -1f);
        v12.close();
        v12.moveTo(10.85f, 17.950001f);
        v12.lineTo(7.74f, 17.950001f);
        v12.curveTo(7.3f, 17.84f, 7f, 17.450001f, 7f, 17f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(3.89f);
        v12.curveToRelative(-0.24f, 0.27f, -0.39f, 0.61f, -0.39f, 1f);
        v12.curveToRelative(0f, 0.36f, 0.13f, 0.69f, 0.35f, 0.95f);
        v12.close();
        v12.moveTo(17f, 17f);
        v12.curveToRelative(0f, 0.45f, -0.3f, 0.84f, -0.74f, 0.95f);
        v12.horizontalLineToRelative(-3.11f);
        v12.curveToRelative(0.22f, -0.26f, 0.35f, -0.59f, 0.35f, -0.95f);
        v12.curveToRelative(0f, -0.39f, -0.15f, -0.73f, -0.39f, -1f);
        v12.lineTo(17f, 16f);
        v12.verticalLineToRelative(1f);
        v12.close();
        v12.moveTo(17f, 14f);
        v12.lineTo(7f, 14f);
        v12.verticalLineToRelative(-4f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TramKt._tram = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

