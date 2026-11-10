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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_militaryTech", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MilitaryTech", "Landroidx/compose/material/icons/Icons$Outlined;", "getMilitaryTech", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MilitaryTechKt {
    private static ImageVector _militaryTech;

    static {
    }

    public static final ImageVector getMilitaryTech(Outlined arg19) {
        ImageVector v0 = MilitaryTechKt._militaryTech;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.MilitaryTech", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17f, 10.43f);
        v12.verticalLineTo(2f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(8.43f);
        v12.curveToRelative(0f, 0.35f, 0.18f, 0.68f, 0.49f, 0.86f);
        v12.lineToRelative(4.18f, 2.51f);
        v12.lineToRelative(-0.99f, 2.34f);
        v12.lineToRelative(-3.41f, 0.29f);
        v12.lineToRelative(2.59f, 2.24f);
        v12.lineTo(9.07f, 22f);
        v12.lineTo(12f, 20.23f);
        v12.lineTo(14.93f, 22f);
        v12.lineToRelative(-0.78f, -3.33f);
        v12.lineToRelative(2.59f, -2.24f);
        v12.lineToRelative(-3.41f, -0.29f);
        v12.lineToRelative(-0.99f, -2.34f);
        v12.lineToRelative(4.18f, -2.51f);
        v12.curveTo(16.82f, 11.11f, 17f, 10.79f, 17f, 10.43f);
        v12.close();
        v12.moveTo(11f, 11.07f);
        v12.lineToRelative(-2f, -1.2f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(11.07f);
        v12.close();
        v12.moveTo(15f, 9.87f);
        v12.lineToRelative(-2f, 1.2f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(9.87f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MilitaryTechKt._militaryTech = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

