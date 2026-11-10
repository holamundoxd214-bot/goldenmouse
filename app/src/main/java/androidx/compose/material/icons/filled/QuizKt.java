package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_quiz", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Quiz", "Landroidx/compose/material/icons/Icons$Filled;", "getQuiz", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class QuizKt {
    private static ImageVector _quiz;

    static {
    }

    public static final ImageVector getQuiz(Filled arg19) {
        ImageVector v0 = QuizKt._quiz;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Quiz", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4f, 6f);
        v12.horizontalLineTo(2f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(4f);
        v12.verticalLineTo(6f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(20f, 2f);
        v12.horizontalLineTo(8f);
        v12.curveTo(6.9f, 2f, 6f, 2.9f, 6f, 4f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(4f);
        v12.curveTo(22f, 2.9f, 21.1f, 2f, 20f, 2f);
        v12.close();
        v12.moveTo(14.01f, 15f);
        v12.curveToRelative(-0.59f, 0f, -1.05f, -0.47f, -1.05f, -1.05f);
        v12.curveToRelative(0f, -0.59f, 0.47f, -1.04f, 1.05f, -1.04f);
        v12.curveToRelative(0.59f, 0f, 1.04f, 0.45f, 1.04f, 1.04f);
        v12.curveTo(15.04f, 14.53f, 14.6f, 15f, 14.01f, 15f);
        v12.close();
        v12.moveTo(16.51f, 8.83f);
        v12.curveToRelative(-0.63f, 0.93f, -1.23f, 1.21f, -1.56f, 1.81f);
        v12.curveToRelative(-0.13f, 0.24f, -0.18f, 0.4f, -0.18f, 1.18f);
        v12.horizontalLineToRelative(-1.52f);
        v12.curveToRelative(0f, -0.41f, -0.06f, -1.08f, 0.26f, -1.65f);
        v12.curveToRelative(0.41f, -0.73f, 1.18f, -1.16f, 1.63f, -1.8f);
        v12.curveToRelative(0.48f, -0.68f, 0.21f, -1.94f, -1.14f, -1.94f);
        v12.curveToRelative(-0.88f, 0f, -1.32f, 0.67f, -1.5f, 1.23f);
        v12.lineToRelative(-1.37f, -0.57f);
        v12.curveTo(11.51f, 5.96f, 12.52f, 5f, 13.99f, 5f);
        v12.curveToRelative(1.23f, 0f, 2.08f, 0.56f, 2.51f, 1.26f);
        v12.curveTo(16.870001f, 6.87f, 17.08f, 7.99f, 16.51f, 8.83f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        QuizKt._quiz = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

