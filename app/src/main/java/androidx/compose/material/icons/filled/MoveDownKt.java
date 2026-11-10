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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_moveDown", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MoveDown", "Landroidx/compose/material/icons/Icons$Filled;", "getMoveDown", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MoveDownKt {
    private static ImageVector _moveDown;

    static {
    }

    public static final ImageVector getMoveDown(Filled arg19) {
        ImageVector v0 = MoveDownKt._moveDown;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.MoveDown", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(3f, 11f);
        v12.curveToRelative(0f, 2.45f, 1.76f, 4.47f, 4.08f, 4.91f);
        v12.lineToRelative(-1.49f, -1.49f);
        v12.lineTo(7f, 13f);
        v12.lineToRelative(4f, 4.01f);
        v12.lineTo(7f, 21f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.lineToRelative(1.58f, -1.58f);
        v12.lineToRelative(0f, -0.06f);
        v12.curveTo(3.7f, 17.540001f, 1f, 14.58f, 1f, 11f);
        v12.curveToRelative(0f, -3.87f, 3.13f, -7f, 7f, -7f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(8f);
        v12.curveTo(5.24f, 6f, 3f, 8.24f, 3f, 11f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(22f, 11f);
        v0_1.verticalLineTo(4f);
        v0_1.horizontalLineToRelative(-9f);
        v0_1.verticalLineToRelative(7f);
        v0_1.horizontalLineTo(22f);
        v0_1.close();
        v0_1.moveTo(20f, 9f);
        v0_1.horizontalLineToRelative(-5f);
        v0_1.verticalLineTo(6f);
        v0_1.horizontalLineToRelative(5f);
        v0_1.verticalLineTo(9f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(13f, 13f);
        v0_1.horizontalLineToRelative(9f);
        v0_1.verticalLineToRelative(7f);
        v0_1.horizontalLineToRelative(-9f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MoveDownKt._moveDown = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

