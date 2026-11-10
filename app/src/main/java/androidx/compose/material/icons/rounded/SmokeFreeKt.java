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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_smokeFree", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SmokeFree", "Landroidx/compose/material/icons/Icons$Rounded;", "getSmokeFree", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SmokeFreeKt {
    private static ImageVector _smokeFree;

    static {
    }

    public static final ImageVector getSmokeFree(Rounded arg19) {
        ImageVector v0 = SmokeFreeKt._smokeFree;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SmokeFree", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.5f, 13f);
        v12.lineTo(22f, 13f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(-1.5f);
        v12.close();
        v12.moveTo(18f, 13f);
        v12.horizontalLineToRelative(1.5f);
        v12.verticalLineToRelative(3f);
        v12.lineTo(18f, 16f);
        v12.close();
        v12.moveTo(17f, 14.5f);
        v12.curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        v12.horizontalLineToRelative(-0.84f);
        v12.lineToRelative(2.18f, 2.18f);
        v12.curveToRelative(0.1f, -0.21f, 0.16f, -0.44f, 0.16f, -0.68f);
        v12.close();
        v12.moveTo(18.959999f, 2.35f);
        v12.lineTo(19f, 2.35f);
        v12.horizontalLineToRelative(-0.04f);
        v12.close();
        v12.moveTo(18.85f, 4.73f);
        v12.curveToRelative(0.38f, -0.38f, 0.67f, -0.84f, 0.84f, -1.35f);
        v12.curveToRelative(0.16f, -0.5f, -0.19f, -1.01f, -0.71f, -1.02f);
        v12.curveToRelative(-0.34f, 0.01f, -0.61f, 0.25f, -0.72f, 0.58f);
        v12.curveToRelative(-0.18f, 0.55f, -0.62f, 0.99f, -1.17f, 1.17f);
        v12.curveToRelative(-0.34f, 0.11f, -0.59f, 0.39f, -0.59f, 0.74f);
        v12.lineTo(16.5f, 5f);
        v12.curveToRelative(0f, 0.37f, 0.27f, 0.69f, 0.64f, 0.75f);
        v12.curveToRelative(1.93f, 0.31f, 3.36f, 2f, 3.36f, 4.02f);
        v12.verticalLineToRelative(1.48f);
        v12.curveToRelative(0f, 0.41f, 0.34f, 0.75f, 0.75f, 0.75f);
        v12.reflectiveCurveToRelative(0.75f, -0.34f, 0.75f, -0.75f);
        v12.lineTo(22f, 9.76f);
        v12.curveToRelative(0f, -2.22f, -1.28f, -4.14f, -3.15f, -5.03f);
        v12.close();
        v12.moveTo(14.61f, 8.65f);
        v12.horizontalLineToRelative(1.42f);
        v12.curveToRelative(1.05f, 0f, 1.97f, 0.74f, 1.97f, 2.05f);
        v12.verticalLineToRelative(0.55f);
        v12.curveToRelative(0f, 0.41f, 0.33f, 0.75f, 0.75f, 0.75f);
        v12.horizontalLineToRelative(0.01f);
        v12.curveToRelative(0.41f, 0f, 0.75f, -0.33f, 0.75f, -0.75f);
        v12.verticalLineToRelative(-0.89f);
        v12.curveToRelative(0f, -1.81f, -1.6f, -3.16f, -3.47f, -3.16f);
        v12.horizontalLineToRelative(-1.3f);
        v12.curveToRelative(-1.02f, 0f, -1.94f, -0.73f, -2.07f, -1.75f);
        v12.curveToRelative(-0.12f, -0.95f, 0.46f, -1.7f, 1.3f, -1.93f);
        v12.curveToRelative(0.32f, -0.09f, 0.54f, -0.38f, 0.54f, -0.72f);
        v12.curveToRelative(0f, -0.49f, -0.46f, -0.86f, -0.93f, -0.72f);
        v12.curveToRelative(-1.42f, 0.41f, -2.45f, 1.73f, -2.42f, 3.28f);
        v12.curveToRelative(0.02f, 1.85f, 1.61f, 3.29f, 3.45f, 3.29f);
        v12.close();
        v12.moveTo(4.12f, 5.29f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineTo(9f, 13f);
        v12.lineTo(3.5f, 13f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, 0.67f, -1.5f, 1.5f);
        v12.reflectiveCurveTo(2.67f, 16f, 3.5f, 16f);
        v12.lineTo(12f, 16f);
        v12.lineToRelative(6.29f, 6.29f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(4.12f, 5.29f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SmokeFreeKt._smokeFree = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

