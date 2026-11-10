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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_rowing", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Rowing", "Landroidx/compose/material/icons/Icons$Rounded;", "getRowing", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RowingKt {
    private static ImageVector _rowing;

    static {
    }

    public static final ImageVector getRowing(Rounded arg19) {
        ImageVector v0 = RowingKt._rowing;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Rowing", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4.75f, 18.25f);
        v12.curveToRelative(-0.41f, 0.41f, -0.41f, 1.09f, 0f, 1.5f);
        v12.curveToRelative(0.41f, 0.41f, 1.09f, 0.41f, 1.5f, 0f);
        v12.lineTo(9f, 17f);
        v12.horizontalLineToRelative(2f);
        v12.lineToRelative(-2.5f, -2.5f);
        v12.lineToRelative(-3.75f, 3.75f);
        v12.close();
        v12.moveTo(15f, 5f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.close();
        v12.moveTo(20.290001f, 20.299999f);
        v12.lineToRelative(-2f, -2.01f);
        v12.curveToRelative(-0.18f, -0.18f, -0.44f, -0.29f, -0.71f, -0.29f);
        v12.lineTo(16.5f, 18f);
        v12.lineToRelative(-6.29f, -6.29f);
        v12.curveToRelative(0.79f, -0.33f, 1.66f, -0.87f, 2.29f, -1.39f);
        v12.verticalLineToRelative(2.27f);
        v12.lineToRelative(3.58f, 3.58f);
        v12.curveToRelative(0.57f, -0.55f, 0.92f, -1.32f, 0.92f, -2.16f);
        v12.lineTo(17f, 8.26f);
        v12.curveTo(17f, 7.02f, 15.98f, 6f, 14.74f, 6f);
        v12.horizontalLineToRelative(-0.02f);
        v12.curveToRelative(-0.34f, 0f, -0.67f, 0.09f, -0.96f, 0.23f);
        v12.curveToRelative(-0.26f, 0.12f, -0.5f, 0.29f, -0.69f, 0.5f);
        v12.lineToRelative(-1.4f, 1.55f);
        v12.curveTo(10.61f, 9.45f, 8.66f, 10.35f, 7f, 10.32f);
        v12.curveToRelative(-0.6f, 0f, -1.08f, 0.48f, -1.08f, 1.08f);
        v12.curveToRelative(0f, 0.6f, 0.48f, 1.08f, 1.08f, 1.08f);
        v12.curveToRelative(0.31f, 0f, 0.61f, -0.03f, 0.9f, -0.07f);
        v12.lineToRelative(7.11f, 7.09f);
        v12.verticalLineToRelative(1.08f);
        v12.curveToRelative(0f, 0.26f, 0.1f, 0.52f, 0.29f, 0.7f);
        v12.lineToRelative(1.99f, 2.01f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.42f, 0f);
        v12.lineToRelative(1.58f, -1.58f);
        v12.curveToRelative(0.39f, -0.38f, 0.39f, -1.02f, 0f, -1.41f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RowingKt._rowing = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

