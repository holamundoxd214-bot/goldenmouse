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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_militaryTech", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MilitaryTech", "Landroidx/compose/material/icons/Icons$Rounded;", "getMilitaryTech", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MilitaryTechKt {
    private static ImageVector _militaryTech;

    static {
    }

    public static final ImageVector getMilitaryTech(Rounded arg19) {
        ImageVector v0 = MilitaryTechKt._militaryTech;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.MilitaryTech", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17f, 10.43f);
        v12.verticalLineTo(3f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(8f);
        v12.curveTo(7.45f, 2f, 7f, 2.45f, 7f, 3f);
        v12.verticalLineToRelative(7.43f);
        v12.curveToRelative(0f, 0.35f, 0.18f, 0.68f, 0.49f, 0.86f);
        v12.lineToRelative(4.18f, 2.51f);
        v12.lineToRelative(-0.99f, 2.34f);
        v12.lineToRelative(-2.22f, 0.19f);
        v12.curveTo(8f, 16.370001f, 7.82f, 16.92f, 8.16f, 17.209999f);
        v12.lineToRelative(1.69f, 1.46f);
        v12.lineToRelative(-0.51f, 2.18f);
        v12.curveToRelative(-0.1f, 0.43f, 0.37f, 0.77f, 0.75f, 0.54f);
        v12.lineTo(12f, 20.23f);
        v12.lineToRelative(1.91f, 1.15f);
        v12.curveToRelative(0.38f, 0.23f, 0.85f, -0.11f, 0.75f, -0.54f);
        v12.lineToRelative(-0.51f, -2.18f);
        v12.lineToRelative(1.69f, -1.46f);
        v12.curveToRelative(0.33f, -0.29f, 0.16f, -0.84f, -0.29f, -0.88f);
        v12.lineToRelative(-2.22f, -0.19f);
        v12.lineToRelative(-0.99f, -2.34f);
        v12.lineToRelative(4.18f, -2.51f);
        v12.curveTo(16.82f, 11.11f, 17f, 10.79f, 17f, 10.43f);
        v12.close();
        v12.moveTo(13f, 12.23f);
        v12.lineToRelative(-1f, 0.6f);
        v12.lineToRelative(-1f, -0.6f);
        v12.verticalLineTo(3f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(12.23f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MilitaryTechKt._militaryTech = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

