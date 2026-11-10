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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_tableRestaurant", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TableRestaurant", "Landroidx/compose/material/icons/Icons$TwoTone;", "getTableRestaurant", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TableRestaurantKt {
    private static ImageVector _tableRestaurant;

    static {
    }

    public static final ImageVector getTableRestaurant(TwoTone arg19) {
        ImageVector v0 = TableRestaurantKt._tableRestaurant;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.TableRestaurant", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(5.18f, 6f);
        v0_1.lineToRelative(-0.85f, 3f);
        v0_1.lineToRelative(15.34f, 0f);
        v0_1.lineToRelative(-0.85f, -3f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.959999f, 9.73f);
        v12.lineToRelative(-1.43f, -5f);
        v12.curveTo(20.41f, 4.3f, 20.02f, 4f, 19.57f, 4f);
        v12.horizontalLineTo(4.43f);
        v12.curveTo(3.98f, 4f, 3.59f, 4.3f, 3.47f, 4.73f);
        v12.lineToRelative(-1.43f, 5f);
        v12.curveTo(1.86f, 10.36f, 2.34f, 11f, 3f, 11f);
        v12.horizontalLineToRelative(2.2f);
        v12.lineTo(4f, 20f);
        v12.horizontalLineToRelative(2f);
        v12.lineToRelative(0.67f, -5f);
        v12.horizontalLineToRelative(10.67f);
        v12.lineTo(18f, 20f);
        v12.horizontalLineToRelative(2f);
        v12.lineToRelative(-1.2f, -9f);
        v12.horizontalLineTo(21f);
        v12.curveTo(21.66f, 11f, 22.139999f, 10.36f, 21.959999f, 9.73f);
        v12.close();
        v12.moveTo(6.93f, 13f);
        v12.lineToRelative(0.27f, -2f);
        v12.horizontalLineToRelative(9.6f);
        v12.lineToRelative(0.27f, 2f);
        v12.horizontalLineTo(6.93f);
        v12.close();
        v12.moveTo(4.33f, 9f);
        v12.lineToRelative(0.86f, -3f);
        v12.horizontalLineToRelative(13.63f);
        v12.lineToRelative(0.86f, 3f);
        v12.horizontalLineTo(4.33f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TableRestaurantKt._tableRestaurant = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

