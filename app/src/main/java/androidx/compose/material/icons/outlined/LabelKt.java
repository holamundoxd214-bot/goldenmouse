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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_label", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Label", "Landroidx/compose/material/icons/Icons$Outlined;", "getLabel$annotations", "(Landroidx/compose/material/icons/Icons$Outlined;)V", "getLabel", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LabelKt {
    private static ImageVector _label;

    static {
    }

    public static final ImageVector getLabel(Outlined arg19) {
        ImageVector v0 = LabelKt._label;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Label", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.629999f, 5.84f);
        v12.curveTo(17.27f, 5.33f, 16.67f, 5f, 16f, 5f);
        v12.lineTo(5f, 5.01f);
        v12.curveTo(3.9f, 5.01f, 3f, 5.9f, 3f, 7f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 1.99f, 2f, 1.99f);
        v12.lineTo(16f, 19f);
        v12.curveToRelative(0.67f, 0f, 1.27f, -0.33f, 1.63f, -0.84f);
        v12.lineTo(22f, 12f);
        v12.lineToRelative(-4.37f, -6.16f);
        v12.close();
        v12.moveTo(16f, 17f);
        v12.horizontalLineTo(5f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(11f);
        v12.lineToRelative(3.55f, 5f);
        v12.lineTo(16f, 17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LabelKt._label = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Outlined.Label", replaceWith="<_subannotation>") public static void getLabel$annotations(Outlined arg0) {
    }
}

