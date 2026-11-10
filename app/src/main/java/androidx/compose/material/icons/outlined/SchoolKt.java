package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_school", "Landroidx/compose/ui/graphics/vector/ImageVector;", "School", "Landroidx/compose/material/icons/Icons$Outlined;", "getSchool", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SchoolKt {
    private static ImageVector _school;

    static {
    }

    public static final ImageVector getSchool(Outlined arg18) {
        ImageVector v0 = SchoolKt._school;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.School", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(12f, 3f);
        v0_1.lineTo(1f, 9f);
        v0_1.lineToRelative(4f, 2.18f);
        v0_1.verticalLineToRelative(6f);
        v0_1.lineTo(12f, 21f);
        v0_1.lineToRelative(7f, -3.82f);
        v0_1.verticalLineToRelative(-6f);
        v0_1.lineToRelative(2f, -1.09f);
        v0_1.lineTo(21f, 17f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.lineTo(23f, 9f);
        v0_1.lineTo(12f, 3f);
        v0_1.close();
        v0_1.moveTo(18.82f, 9f);
        v0_1.lineTo(12f, 12.72f);
        v0_1.lineTo(5.18f, 9f);
        v0_1.lineTo(12f, 5.28f);
        v0_1.lineTo(18.82f, 9f);
        v0_1.close();
        v0_1.moveTo(17f, 15.99f);
        v0_1.lineToRelative(-5f, 2.73f);
        v0_1.lineToRelative(-5f, -2.73f);
        v0_1.verticalLineToRelative(-3.72f);
        v0_1.lineTo(12f, 15f);
        v0_1.lineToRelative(5f, -2.73f);
        v0_1.verticalLineToRelative(3.72f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SchoolKt._school = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

