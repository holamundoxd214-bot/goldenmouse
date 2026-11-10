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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_editOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "EditOff", "Landroidx/compose/material/icons/Icons$Outlined;", "getEditOff", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EditOffKt {
    private static ImageVector _editOff;

    static {
    }

    public static final ImageVector getEditOff(Outlined arg19) {
        ImageVector v0 = EditOffKt._editOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.EditOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.06f, 9.02f);
        v12.lineToRelative(0.92f, 0.92f);
        v12.lineToRelative(-1.11f, 1.11f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(2.52f, -2.52f);
        v12.lineToRelative(-3.75f, -3.75f);
        v12.lineToRelative(-2.52f, 2.52f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineTo(14.06f, 9.02f);
        v12.close();
        v12.moveTo(20.709999f, 7.04f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(-2.34f, -2.34f);
        v12.curveTo(18.17f, 3.09f, 17.92f, 3f, 17.66f, 3f);
        v12.reflectiveCurveToRelative(-0.51f, 0.1f, -0.7f, 0.29f);
        v12.lineToRelative(-1.83f, 1.83f);
        v12.lineToRelative(3.75f, 3.75f);
        v12.lineTo(20.709999f, 7.04f);
        v12.close();
        v12.moveTo(2.81f, 2.81f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineToRelative(7.32f, 7.32f);
        v12.lineTo(3f, 17.25f);
        v12.verticalLineTo(21f);
        v12.horizontalLineToRelative(3.75f);
        v12.lineToRelative(5.71f, -5.71f);
        v12.lineToRelative(7.32f, 7.32f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(2.81f, 2.81f);
        v12.close();
        v12.moveTo(5.92f, 19f);
        v12.horizontalLineTo(5f);
        v12.verticalLineToRelative(-0.92f);
        v12.lineToRelative(5.13f, -5.13f);
        v12.lineToRelative(0.92f, 0.92f);
        v12.lineTo(5.92f, 19f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EditOffKt._editOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

