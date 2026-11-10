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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_details", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Details", "Landroidx/compose/material/icons/Icons$Rounded;", "getDetails", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DetailsKt {
    private static ImageVector _details;

    static {
    }

    public static final ImageVector getDetails(Rounded arg19) {
        ImageVector v0 = DetailsKt._details;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Details", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.13f, 4.57f);
        v12.lineToRelative(-8.3f, 14.94f);
        v12.curveTo(2.46f, 20.18f, 2.94f, 21f, 3.7f, 21f);
        v12.horizontalLineToRelative(16.6f);
        v12.curveToRelative(0.76f, 0f, 1.24f, -0.82f, 0.87f, -1.49f);
        v12.lineToRelative(-8.3f, -14.94f);
        v12.curveTo(12.49f, 3.89f, 11.51f, 3.89f, 11.13f, 4.57f);
        v12.close();
        v12.moveTo(13f, 8.92f);
        v12.lineTo(18.6f, 19f);
        v12.horizontalLineTo(13f);
        v12.verticalLineTo(8.92f);
        v12.close();
        v12.moveTo(11f, 8.92f);
        v12.verticalLineTo(19f);
        v12.horizontalLineTo(5.4f);
        v12.lineTo(11f, 8.92f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DetailsKt._details = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

