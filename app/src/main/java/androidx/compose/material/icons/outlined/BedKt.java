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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_bed", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Bed", "Landroidx/compose/material/icons/Icons$Outlined;", "getBed", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BedKt {
    private static ImageVector _bed;

    static {
    }

    public static final ImageVector getBed(Outlined arg19) {
        ImageVector v0 = BedKt._bed;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Bed", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 10.78f);
        v12.verticalLineTo(8f);
        v12.curveToRelative(0f, -1.65f, -1.35f, -3f, -3f, -3f);
        v12.horizontalLineToRelative(-4f);
        v12.curveToRelative(-0.77f, 0f, -1.47f, 0.3f, -2f, 0.78f);
        v12.curveTo(11.47f, 5.3f, 10.77f, 5f, 10f, 5f);
        v12.horizontalLineTo(6f);
        v12.curveTo(4.35f, 5f, 3f, 6.35f, 3f, 8f);
        v12.verticalLineToRelative(2.78f);
        v12.curveTo(2.39f, 11.33f, 2f, 12.12f, 2f, 13f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-6f);
        v12.curveTo(22f, 12.12f, 21.610001f, 11.33f, 21f, 10.78f);
        v12.close();
        v12.moveTo(14f, 7f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-6f);
        v12.verticalLineTo(8f);
        v12.curveTo(13f, 7.45f, 13.45f, 7f, 14f, 7f);
        v12.close();
        v12.moveTo(5f, 8f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(5f);
        v12.verticalLineTo(8f);
        v12.close();
        v12.moveTo(4f, 15f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BedKt._bed = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

