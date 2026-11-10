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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_addToDrive", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AddToDrive", "Landroidx/compose/material/icons/Icons$Filled;", "getAddToDrive", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AddToDriveKt {
    private static ImageVector _addToDrive;

    static {
    }

    public static final ImageVector getAddToDrive(Filled arg19) {
        ImageVector v0 = AddToDriveKt._addToDrive;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.AddToDrive", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 21f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineTo(20f);
        v12.close();
        v12.moveTo(15.03f, 21.5f);
        v12.horizontalLineTo(5.66f);
        v12.curveToRelative(-0.72f, 0f, -1.38f, -0.38f, -1.73f, -1f);
        v12.lineTo(1.57f, 16.4f);
        v12.curveToRelative(-0.36f, -0.62f, -0.35f, -1.38f, 0.01f, -2f);
        v12.lineTo(7.92f, 3.49f);
        v12.curveTo(8.28f, 2.88f, 8.94f, 2.5f, 9.65f, 2.5f);
        v12.horizontalLineToRelative(4.7f);
        v12.curveToRelative(0.71f, 0f, 1.37f, 0.38f, 1.73f, 0.99f);
        v12.lineToRelative(4.48f, 7.71f);
        v12.curveTo(20.059999f, 11.07f, 19.540001f, 11f, 19f, 11f);
        v12.curveToRelative(-0.28f, 0f, -0.56f, 0.02f, -0.84f, 0.06f);
        v12.lineTo(14.35f, 4.5f);
        v12.horizontalLineToRelative(-4.7f);
        v12.lineTo(3.31f, 15.41f);
        v12.lineToRelative(2.35f, 4.09f);
        v12.horizontalLineToRelative(7.89f);
        v12.curveTo(13.9f, 20.27f, 14.4f, 20.950001f, 15.03f, 21.5f);
        v12.close();
        v12.moveTo(13.34f, 15f);
        v12.curveTo(13.12f, 15.63f, 13f, 16.299999f, 13f, 17f);
        v12.horizontalLineTo(7.25f);
        v12.lineToRelative(-0.73f, -1.27f);
        v12.lineToRelative(4.58f, -7.98f);
        v12.horizontalLineToRelative(1.8f);
        v12.lineToRelative(2.53f, 4.42f);
        v12.curveToRelative(-0.56f, 0.42f, -1.05f, 0.93f, -1.44f, 1.51f);
        v12.lineToRelative(-2f, -3.49f);
        v12.lineTo(9.25f, 15f);
        v12.horizontalLineTo(13.34f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AddToDriveKt._addToDrive = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

