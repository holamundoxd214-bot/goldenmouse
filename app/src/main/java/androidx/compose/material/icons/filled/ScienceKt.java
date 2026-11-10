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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_science", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Science", "Landroidx/compose/material/icons/Icons$Filled;", "getScience", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ScienceKt {
    private static ImageVector _science;

    static {
    }

    public static final ImageVector getScience(Filled arg19) {
        ImageVector v0 = ScienceKt._science;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Science", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.799999f, 18.4f);
        v12.lineTo(14f, 10.67f);
        v12.verticalLineTo(6.5f);
        v12.lineToRelative(1.35f, -1.69f);
        v12.curveTo(15.61f, 4.48f, 15.38f, 4f, 14.96f, 4f);
        v12.horizontalLineTo(9.04f);
        v12.curveTo(8.62f, 4f, 8.39f, 4.48f, 8.65f, 4.81f);
        v12.lineTo(10f, 6.5f);
        v12.verticalLineToRelative(4.17f);
        v12.lineTo(4.2f, 18.4f);
        v12.curveTo(3.71f, 19.059999f, 4.18f, 20f, 5f, 20f);
        v12.horizontalLineToRelative(14f);
        v12.curveTo(19.82f, 20f, 20.290001f, 19.059999f, 19.799999f, 18.4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ScienceKt._science = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

