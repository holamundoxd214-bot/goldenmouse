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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_downhillSkiing", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DownhillSkiing", "Landroidx/compose/material/icons/Icons$TwoTone;", "getDownhillSkiing", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DownhillSkiingKt {
    private static ImageVector _downhillSkiing;

    static {
    }

    public static final ImageVector getDownhillSkiing(TwoTone arg19) {
        ImageVector v0 = DownhillSkiingKt._downhillSkiing;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.DownhillSkiing", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.5f, 4.5f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f);
        v12.reflectiveCurveToRelative(0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveTo(18.5f, 3.4f, 18.5f, 4.5f);
        v12.close();
        v12.moveTo(15.78f, 20.9f);
        v12.lineToRelative(0.76f, 0.27f);
        v12.curveToRelative(0.62f, 0.21f, 1.27f, 0.33f, 1.96f, 0.33f);
        v12.curveToRelative(0.84f, 0f, 1.65f, -0.18f, 2.38f, -0.5f);
        v12.lineTo(22f, 22.129999f);
        v12.curveTo(20.950001f, 22.68f, 19.76f, 23f, 18.5f, 23f);
        v12.curveToRelative(-0.86f, 0f, -1.68f, -0.14f, -2.45f, -0.41f);
        v12.lineTo(2f, 17.469999f);
        v12.lineToRelative(0.5f, -1.41f);
        v12.lineToRelative(6.9f, 2.51f);
        v12.lineToRelative(1.72f, -4.44f);
        v12.lineTo(7.55f, 10.4f);
        v12.curveTo(6.66f, 9.46f, 6.88f, 7.93f, 8f, 7.28f);
        v12.lineToRelative(3.48f, -2.01f);
        v12.curveToRelative(1.1f, -0.64f, 2.52f, -0.1f, 2.91f, 1.11f);
        v12.lineToRelative(0.33f, 1.08f);
        v12.curveToRelative(0.44f, 1.42f, 1.48f, 2.57f, 2.83f, 3.14f);
        v12.lineTo(18.07f, 9f);
        v12.lineToRelative(1.43f, 0.46f);
        v12.lineToRelative(-1.12f, 3.45f);
        v12.curveToRelative(-2.45f, -0.4f, -4.48f, -2.07f, -5.38f, -4.32f);
        v12.lineToRelative(-2.53f, 1.45f);
        v12.lineToRelative(3.03f, 3.46f);
        v12.lineToRelative(-2.22f, 5.76f);
        v12.lineToRelative(3.09f, 1.12f);
        v12.lineToRelative(2.1f, -6.44f);
        v12.horizontalLineToRelative(0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.46f, 0.18f, 0.94f, 0.31f, 1.44f, 0.41f);
        v12.lineTo(15.78f, 20.9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DownhillSkiingKt._downhillSkiing = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

