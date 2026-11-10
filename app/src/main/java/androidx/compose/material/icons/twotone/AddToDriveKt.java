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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_addToDrive", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AddToDrive", "Landroidx/compose/material/icons/Icons$TwoTone;", "getAddToDrive", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AddToDriveKt {
    private static ImageVector _addToDrive;

    static {
    }

    public static final ImageVector getAddToDrive(TwoTone arg19) {
        ImageVector v0 = AddToDriveKt._addToDrive;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.AddToDrive", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 11f);
        v12.curveToRelative(0.17f, 0f, 0.33f, 0.01f, 0.49f, 0.02f);
        v12.lineTo(15f, 3f);
        v12.horizontalLineTo(9f);
        v12.lineToRelative(5.68f, 9.84f);
        v12.curveTo(15.77f, 11.71f, 17.299999f, 11f, 19f, 11f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(8.15f, 4.52f);
        v0_1.lineToRelative(-6.15f, 10.98f);
        v0_1.lineToRelative(3f, 5.5f);
        v0_1.lineToRelative(6.33f, -10.97f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(13.2f, 15.5f);
        v12.horizontalLineTo(9.9f);
        v12.lineTo(6.73f, 21f);
        v12.horizontalLineToRelative(7.81f);
        v12.curveTo(13.58f, 19.940001f, 13f, 18.540001f, 13f, 17f);
        v12.curveTo(13f, 16.48f, 13.07f, 15.98f, 13.2f, 15.5f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(20f, 16f);
        v0_1.lineToRelative(0f, -3f);
        v0_1.lineToRelative(-2f, 0f);
        v0_1.lineToRelative(0f, 3f);
        v0_1.lineToRelative(-3f, 0f);
        v0_1.lineToRelative(0f, 2f);
        v0_1.lineToRelative(3f, 0f);
        v0_1.lineToRelative(0f, 3f);
        v0_1.lineToRelative(1f, 0f);
        v0_1.lineToRelative(1f, 0f);
        v0_1.lineToRelative(0f, -3f);
        v0_1.lineToRelative(3f, 0f);
        v0_1.lineToRelative(0f, -2f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AddToDriveKt._addToDrive = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

