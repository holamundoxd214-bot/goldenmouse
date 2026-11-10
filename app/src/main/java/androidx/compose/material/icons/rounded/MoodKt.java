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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_mood", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Mood", "Landroidx/compose/material/icons/Icons$Rounded;", "getMood", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MoodKt {
    private static ImageVector _mood;

    static {
    }

    public static final ImageVector getMood(Rounded arg19) {
        ImageVector v0 = MoodKt._mood;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Mood", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.99f, 2f);
        v12.curveTo(6.47f, 2f, 2f, 6.48f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.47f, 10f, 9.99f, 10f);
        v12.curveTo(17.52f, 22f, 22f, 17.52f, 22f, 12f);
        v12.reflectiveCurveTo(17.52f, 2f, 11.99f, 2f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-4.42f, 0f, -8f, -3.58f, -8f, -8f);
        v12.reflectiveCurveToRelative(3.58f, -8f, 8f, -8f);
        v12.reflectiveCurveToRelative(8f, 3.58f, 8f, 8f);
        v12.reflectiveCurveToRelative(-3.58f, 8f, -8f, 8f);
        v12.close();
        v12.moveTo(15.5f, 11f);
        v12.curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.reflectiveCurveTo(16.33f, 8f, 15.5f, 8f);
        v12.reflectiveCurveTo(14f, 8.67f, 14f, 9.5f);
        v12.reflectiveCurveToRelative(0.67f, 1.5f, 1.5f, 1.5f);
        v12.close();
        v12.moveTo(8.5f, 11f);
        v12.curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.reflectiveCurveTo(9.33f, 8f, 8.5f, 8f);
        v12.reflectiveCurveTo(7f, 8.67f, 7f, 9.5f);
        v12.reflectiveCurveTo(7.67f, 11f, 8.5f, 11f);
        v12.close();
        v12.moveTo(12f, 17.5f);
        v12.curveToRelative(2.03f, 0f, 3.8f, -1.11f, 4.75f, -2.75f);
        v12.curveToRelative(0.19f, -0.33f, -0.05f, -0.75f, -0.44f, -0.75f);
        v12.lineTo(7.69f, 14f);
        v12.curveToRelative(-0.38f, 0f, -0.63f, 0.42f, -0.44f, 0.75f);
        v12.curveToRelative(0.95f, 1.64f, 2.72f, 2.75f, 4.75f, 2.75f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MoodKt._mood = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

