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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_editLocation", "Landroidx/compose/ui/graphics/vector/ImageVector;", "EditLocation", "Landroidx/compose/material/icons/Icons$Rounded;", "getEditLocation", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EditLocationKt {
    private static ImageVector _editLocation;

    static {
    }

    public static final ImageVector getEditLocation(Rounded arg19) {
        ImageVector v0 = EditLocationKt._editLocation;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.EditLocation", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveToRelative(-4.2f, 0f, -8f, 3.22f, -8f, 8.2f);
        v12.curveToRelative(0f, 3.18f, 2.45f, 6.92f, 7.34f, 11.23f);
        v12.curveToRelative(0.38f, 0.33f, 0.95f, 0.33f, 1.33f, 0f);
        v12.curveTo(17.549999f, 17.120001f, 20f, 13.38f, 20f, 10.2f);
        v12.curveTo(20f, 5.22f, 16.200001f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(9.73f, 13.5f);
        v12.horizontalLineTo(8.5f);
        v12.verticalLineToRelative(-1.44f);
        v12.lineToRelative(3.93f, -3.92f);
        v12.lineToRelative(1.43f, 1.43f);
        v12.lineToRelative(-3.77f, 3.78f);
        v12.curveTo(9.99f, 13.45f, 9.87f, 13.5f, 9.73f, 13.5f);
        v12.close();
        v12.moveTo(15.28f, 8.16f);
        v12.lineToRelative(-0.7f, 0.7f);
        v12.lineToRelative(-1.44f, -1.44f);
        v12.lineToRelative(0.7f, -0.7f);
        v12.curveToRelative(0.15f, -0.15f, 0.39f, -0.15f, 0.54f, 0f);
        v12.lineToRelative(0.9f, 0.9f);
        v12.curveTo(15.43f, 7.77f, 15.43f, 8.01f, 15.28f, 8.16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EditLocationKt._editLocation = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

