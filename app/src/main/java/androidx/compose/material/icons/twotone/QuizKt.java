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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_quiz", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Quiz", "Landroidx/compose/material/icons/Icons$TwoTone;", "getQuiz", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class QuizKt {
    private static ImageVector _quiz;

    static {
    }

    public static final ImageVector getQuiz(TwoTone arg19) {
        ImageVector v0 = QuizKt._quiz;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Quiz", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8f, 4f);
        v12.verticalLineToRelative(12f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineTo(4f);
        v12.horizontalLineTo(8f);
        v12.close();
        v12.moveTo(14.74f, 14.69f);
        v12.curveTo(14.54f, 14.9f, 14.3f, 15f, 14.01f, 15f);
        v12.curveToRelative(-0.29f, 0f, -0.54f, -0.1f, -0.74f, -0.31f);
        v12.curveToRelative(-0.21f, -0.21f, -0.31f, -0.45f, -0.31f, -0.74f);
        v12.curveToRelative(0f, -0.29f, 0.1f, -0.54f, 0.31f, -0.74f);
        v12.curveToRelative(0.21f, -0.2f, 0.45f, -0.3f, 0.74f, -0.3f);
        v12.curveToRelative(0.29f, 0f, 0.54f, 0.1f, 0.74f, 0.3f);
        v12.curveToRelative(0.2f, 0.2f, 0.3f, 0.45f, 0.3f, 0.74f);
        v12.curveTo(15.05f, 14.24f, 14.94f, 14.49f, 14.74f, 14.69f);
        v12.close();
        v12.moveTo(16.51f, 8.83f);
        v12.curveToRelative(-0.23f, 0.34f, -0.54f, 0.69f, -0.92f, 1.06f);
        v12.curveToRelative(-0.3f, 0.27f, -0.51f, 0.52f, -0.64f, 0.75f);
        v12.curveToRelative(-0.12f, 0.23f, -0.18f, 0.49f, -0.18f, 0.78f);
        v12.verticalLineToRelative(0.4f);
        v12.horizontalLineToRelative(-1.52f);
        v12.verticalLineToRelative(-0.56f);
        v12.curveToRelative(0f, -0.42f, 0.09f, -0.78f, 0.26f, -1.09f);
        v12.curveTo(13.69f, 9.85f, 14f, 9.5f, 14.46f, 9.1f);
        v12.curveToRelative(0.32f, -0.29f, 0.55f, -0.54f, 0.69f, -0.74f);
        v12.curveToRelative(0.14f, -0.2f, 0.21f, -0.44f, 0.21f, -0.72f);
        v12.curveToRelative(0f, -0.36f, -0.12f, -0.65f, -0.36f, -0.87f);
        v12.curveToRelative(-0.24f, -0.23f, -0.57f, -0.34f, -0.99f, -0.34f);
        v12.curveToRelative(-0.4f, 0f, -0.72f, 0.12f, -0.97f, 0.36f);
        v12.curveToRelative(-0.25f, 0.24f, -0.42f, 0.53f, -0.53f, 0.87f);
        v12.lineToRelative(-1.37f, -0.57f);
        v12.curveToRelative(0.18f, -0.55f, 0.52f, -1.03f, 1f, -1.45f);
        v12.curveTo(12.63f, 5.21f, 13.25f, 5f, 13.99f, 5f);
        v12.curveToRelative(0.56f, 0f, 1.05f, 0.11f, 1.49f, 0.33f);
        v12.curveToRelative(0.44f, 0.22f, 0.78f, 0.53f, 1.02f, 0.93f);
        v12.curveToRelative(0.24f, 0.4f, 0.36f, 0.84f, 0.36f, 1.33f);
        v12.curveTo(16.860001f, 8.08f, 16.75f, 8.49f, 16.51f, 8.83f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(4f, 6f);
        v12.horizontalLineTo(2f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(4f);
        v12.verticalLineTo(6f);
        v12.close();
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
        v12.moveTo(20f, 16f);
        v12.horizontalLineTo(8f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineTo(16f);
        v12.close();
        v12.moveTo(13.51f, 10.16f);
        v12.curveToRelative(0.41f, -0.73f, 1.18f, -1.16f, 1.63f, -1.8f);
        v12.curveToRelative(0.48f, -0.68f, 0.21f, -1.94f, -1.14f, -1.94f);
        v12.curveToRelative(-0.88f, 0f, -1.32f, 0.67f, -1.5f, 1.23f);
        v12.lineToRelative(-1.37f, -0.57f);
        v12.curveTo(11.51f, 5.96f, 12.52f, 5f, 13.99f, 5f);
        v12.curveToRelative(1.23f, 0f, 2.08f, 0.56f, 2.51f, 1.26f);
        v12.curveToRelative(0.37f, 0.6f, 0.58f, 1.73f, 0.01f, 2.57f);
        v12.curveToRelative(-0.63f, 0.93f, -1.23f, 1.21f, -1.56f, 1.81f);
        v12.curveToRelative(-0.13f, 0.24f, -0.18f, 0.4f, -0.18f, 1.18f);
        v12.horizontalLineToRelative(-1.52f);
        v12.curveTo(13.26f, 11.41f, 13.19f, 10.74f, 13.51f, 10.16f);
        v12.close();
        v12.moveTo(12.95f, 13.95f);
        v12.curveToRelative(0f, -0.59f, 0.47f, -1.04f, 1.05f, -1.04f);
        v12.curveToRelative(0.59f, 0f, 1.04f, 0.45f, 1.04f, 1.04f);
        v12.curveToRelative(0f, 0.58f, -0.44f, 1.05f, -1.04f, 1.05f);
        v12.curveTo(13.42f, 15f, 12.95f, 14.53f, 12.95f, 13.95f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        QuizKt._quiz = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

