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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_grade", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Grade", "Landroidx/compose/material/icons/Icons$Rounded;", "getGrade", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class GradeKt {
    private static ImageVector _grade;

    static {
    }

    public static final ImageVector getGrade(Rounded arg19) {
        ImageVector v0 = GradeKt._grade;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Grade", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 17.27f);
        v12.lineToRelative(5.17f, 3.12f);
        v12.curveToRelative(0.38f, 0.23f, 0.85f, -0.11f, 0.75f, -0.54f);
        v12.lineToRelative(-1.37f, -5.88f);
        v12.lineToRelative(4.56f, -3.95f);
        v12.curveToRelative(0.33f, -0.29f, 0.16f, -0.84f, -0.29f, -0.88f);
        v12.lineToRelative(-6.01f, -0.51f);
        v12.lineToRelative(-2.35f, -5.54f);
        v12.curveToRelative(-0.17f, -0.41f, -0.75f, -0.41f, -0.92f, 0f);
        v12.lineTo(9.19f, 8.63f);
        v12.lineToRelative(-6.01f, 0.51f);
        v12.curveToRelative(-0.44f, 0.04f, -0.62f, 0.59f, -0.28f, 0.88f);
        v12.lineToRelative(4.56f, 3.95f);
        v12.lineToRelative(-1.37f, 5.88f);
        v12.curveToRelative(-0.1f, 0.43f, 0.37f, 0.77f, 0.75f, 0.54f);
        v12.lineTo(12f, 17.27f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        GradeKt._grade = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

