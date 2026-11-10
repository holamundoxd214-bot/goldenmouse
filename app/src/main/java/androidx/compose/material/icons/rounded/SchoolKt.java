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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_school", "Landroidx/compose/ui/graphics/vector/ImageVector;", "School", "Landroidx/compose/material/icons/Icons$Rounded;", "getSchool", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SchoolKt {
    private static ImageVector _school;

    static {
    }

    public static final ImageVector getSchool(Rounded arg19) {
        ImageVector v0 = SchoolKt._school;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.School", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(5f, 13.18f);
        v12.verticalLineToRelative(2.81f);
        v12.curveToRelative(0f, 0.73f, 0.4f, 1.41f, 1.04f, 1.76f);
        v12.lineToRelative(5f, 2.73f);
        v12.curveToRelative(0.6f, 0.33f, 1.32f, 0.33f, 1.92f, 0f);
        v12.lineToRelative(5f, -2.73f);
        v12.curveToRelative(0.64f, -0.35f, 1.04f, -1.03f, 1.04f, -1.76f);
        v12.verticalLineToRelative(-2.81f);
        v12.lineToRelative(-6.04f, 3.3f);
        v12.curveToRelative(-0.6f, 0.33f, -1.32f, 0.33f, -1.92f, 0f);
        v12.lineTo(5f, 13.18f);
        v12.close();
        v12.moveTo(11.04f, 3.52f);
        v12.lineToRelative(-8.43f, 4.6f);
        v12.curveToRelative(-0.69f, 0.38f, -0.69f, 1.38f, 0f, 1.76f);
        v12.lineToRelative(8.43f, 4.6f);
        v12.curveToRelative(0.6f, 0.33f, 1.32f, 0.33f, 1.92f, 0f);
        v12.lineTo(21f, 10.09f);
        v12.lineTo(21f, 16f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.lineTo(23f, 9.59f);
        v12.curveToRelative(0f, -0.37f, -0.2f, -0.7f, -0.52f, -0.88f);
        v12.lineToRelative(-9.52f, -5.19f);
        v12.curveToRelative(-0.6f, -0.32f, -1.32f, -0.32f, -1.92f, 0f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SchoolKt._school = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

