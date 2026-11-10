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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_nightShelter", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NightShelter", "Landroidx/compose/material/icons/Icons$Filled;", "getNightShelter", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NightShelterKt {
    private static ImageVector _nightShelter;

    static {
    }

    public static final ImageVector getNightShelter(Filled arg19) {
        ImageVector v0 = NightShelterKt._nightShelter;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.NightShelter", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 3f);
        v12.lineTo(4f, 9f);
        v12.verticalLineToRelative(12f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineTo(9f);
        v12.lineTo(12f, 3f);
        v12.close();
        v12.moveTo(9.75f, 12.5f);
        v12.curveToRelative(0.69f, 0f, 1.25f, 0.56f, 1.25f, 1.25f);
        v12.reflectiveCurveTo(10.44f, 15f, 9.75f, 15f);
        v12.reflectiveCurveTo(8.5f, 14.44f, 8.5f, 13.75f);
        v12.reflectiveCurveTo(9.06f, 12.5f, 9.75f, 12.5f);
        v12.close();
        v12.moveTo(17f, 18f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(-1.5f);
        v12.horizontalLineTo(8f);
        v12.verticalLineTo(18f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(-7f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(4.5f);
        v12.horizontalLineToRelative(3.5f);
        v12.verticalLineTo(12f);
        v12.horizontalLineTo(15f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.verticalLineTo(18f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NightShelterKt._nightShelter = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

