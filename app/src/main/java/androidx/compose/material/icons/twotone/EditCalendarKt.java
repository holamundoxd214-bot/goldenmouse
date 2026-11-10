package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_editCalendar", "Landroidx/compose/ui/graphics/vector/ImageVector;", "EditCalendar", "Landroidx/compose/material/icons/Icons$TwoTone;", "getEditCalendar", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EditCalendarKt {
    private static ImageVector _editCalendar;

    static {
    }

    public static final ImageVector getEditCalendar(TwoTone arg19) {
        ImageVector v0 = EditCalendarKt._editCalendar;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.EditCalendar", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(5f, 6f);
        v0_1.horizontalLineToRelative(14f);
        v0_1.verticalLineToRelative(2f);
        v0_1.horizontalLineToRelative(-14f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(5f, 10f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineTo(2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(8f);
        v12.verticalLineTo(2f);
        v12.horizontalLineTo(6f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(5f);
        v12.curveTo(3.89f, 4f, 3.01f, 4.9f, 3.01f, 6f);
        v12.lineTo(3f, 20f);
        v12.curveToRelative(0f, 1.1f, 0.89f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(7f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(5f);
        v12.verticalLineTo(10f);
        v12.close();
        v12.moveTo(5f, 6f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(5f);
        v12.verticalLineTo(6f);
        v12.close();
        v12.moveTo(22.84f, 16.280001f);
        v12.lineToRelative(-0.71f, 0.71f);
        v12.lineToRelative(-2.12f, -2.12f);
        v12.lineToRelative(0.71f, -0.71f);
        v12.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0f);
        v12.lineToRelative(0.71f, 0.71f);
        v12.curveTo(23.23f, 15.26f, 23.23f, 15.89f, 22.84f, 16.280001f);
        v12.close();
        v12.moveTo(19.299999f, 15.58f);
        v12.lineToRelative(2.12f, 2.12f);
        v12.lineToRelative(-5.3f, 5.3f);
        v12.horizontalLineTo(14f);
        v12.verticalLineToRelative(-2.12f);
        v12.lineTo(19.299999f, 15.58f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EditCalendarKt._editCalendar = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

