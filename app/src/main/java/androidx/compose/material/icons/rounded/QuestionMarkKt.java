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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_questionMark", "Landroidx/compose/ui/graphics/vector/ImageVector;", "QuestionMark", "Landroidx/compose/material/icons/Icons$Rounded;", "getQuestionMark", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class QuestionMarkKt {
    private static ImageVector _questionMark;

    static {
    }

    public static final ImageVector getQuestionMark(Rounded arg19) {
        ImageVector v0 = QuestionMarkKt._questionMark;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.QuestionMark", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7.92f, 7.54f);
        v12.curveTo(7.12f, 7.2f, 6.78f, 6.21f, 7.26f, 5.49f);
        v12.curveTo(8.23f, 4.05f, 9.85f, 3f, 11.99f, 3f);
        v12.curveToRelative(2.35f, 0f, 3.96f, 1.07f, 4.78f, 2.41f);
        v12.curveToRelative(0.7f, 1.15f, 1.11f, 3.3f, 0.03f, 4.9f);
        v12.curveToRelative(-1.2f, 1.77f, -2.35f, 2.31f, -2.97f, 3.45f);
        v12.curveToRelative(-0.15f, 0.27f, -0.24f, 0.49f, -0.3f, 0.94f);
        v12.curveToRelative(-0.09f, 0.73f, -0.69f, 1.3f, -1.43f, 1.3f);
        v12.curveToRelative(-0.87f, 0f, -1.58f, -0.75f, -1.48f, -1.62f);
        v12.curveToRelative(0.06f, -0.51f, 0.18f, -1.04f, 0.46f, -1.54f);
        v12.curveToRelative(0.77f, -1.39f, 2.25f, -2.21f, 3.11f, -3.44f);
        v12.curveToRelative(0.91f, -1.29f, 0.4f, -3.7f, -2.18f, -3.7f);
        v12.curveToRelative(-1.17f, 0f, -1.93f, 0.61f, -2.4f, 1.34f);
        v12.curveTo(9.26f, 7.61f, 8.53f, 7.79f, 7.92f, 7.54f);
        v12.close();
        v12.moveTo(14f, 20f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveTo(14f, 18.9f, 14f, 20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        QuestionMarkKt._questionMark = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

