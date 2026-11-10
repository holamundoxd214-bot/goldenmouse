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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_editOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "EditOff", "Landroidx/compose/material/icons/Icons$Filled;", "getEditOff", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EditOffKt {
    private static ImageVector _editOff;

    static {
    }

    public static final ImageVector getEditOff(Filled arg20) {
        ImageVector v0 = EditOffKt._editOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.EditOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.126f, 8.125f);
        v12.lineToRelative(1.937f, -1.937f);
        v12.lineToRelative(3.747f, 3.747f);
        v12.lineToRelative(-1.937f, 1.938f);
        v12.close();
        v12.moveTo(20.709999f, 5.63f);
        v12.lineToRelative(-2.34f, -2.34f);
        v12.arcToRelative(1f, 1f, 0f, false, false, -1.41f, 0f);
        v12.lineToRelative(-1.83f, 1.83f);
        v12.lineToRelative(3.75f, 3.75f);
        v12.lineTo(20.709999f, 7f);
        v12.arcToRelative(1f, 1f, 0f, false, false, 0f, -1.37f);
        v12.close();
        v12.moveTo(2f, 5f);
        v12.lineToRelative(6.63f, 6.63f);
        v12.lineTo(3f, 17.25f);
        v12.verticalLineTo(21f);
        v12.horizontalLineToRelative(3.75f);
        v12.lineToRelative(5.63f, -5.62f);
        v12.lineTo(18f, 21f);
        v12.lineToRelative(2f, -2f);
        v12.lineTo(4f, 3f);
        v12.lineTo(2f, 5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EditOffKt._editOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

