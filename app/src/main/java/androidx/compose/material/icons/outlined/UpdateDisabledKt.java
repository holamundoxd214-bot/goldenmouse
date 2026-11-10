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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_updateDisabled", "Landroidx/compose/ui/graphics/vector/ImageVector;", "UpdateDisabled", "Landroidx/compose/material/icons/Icons$Outlined;", "getUpdateDisabled", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class UpdateDisabledKt {
    private static ImageVector _updateDisabled;

    static {
    }

    public static final ImageVector getUpdateDisabled(Outlined arg19) {
        ImageVector v0 = UpdateDisabledKt._updateDisabled;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.UpdateDisabled", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.940001f, 13f);
        v12.curveToRelative(-0.15f, 1.38f, -0.62f, 2.67f, -1.33f, 3.79f);
        v12.lineToRelative(-1.47f, -1.47f);
        v12.curveToRelative(0.38f, -0.71f, 0.65f, -1.49f, 0.77f, -2.32f);
        v12.horizontalLineTo(20.940001f);
        v12.close();
        v12.moveTo(8.67f, 5.84f);
        v12.curveTo(9.66f, 5.31f, 10.8f, 5f, 12f, 5f);
        v12.curveToRelative(2.37f, 0f, 4.47f, 1.19f, 5.74f, 3f);
        v12.horizontalLineTo(15f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2.36f);
        v12.curveTo(17.35f, 4.32f, 14.83f, 3f, 12f, 3f);
        v12.curveToRelative(-1.76f, 0f, -3.4f, 0.51f, -4.78f, 1.39f);
        v12.lineTo(8.67f, 5.84f);
        v12.close();
        v12.moveTo(11f, 7f);
        v12.verticalLineToRelative(1.17f);
        v12.lineToRelative(2f, 2f);
        v12.verticalLineTo(7f);
        v12.horizontalLineTo(11f);
        v12.close();
        v12.moveTo(19.780001f, 22.610001f);
        v12.lineToRelative(-3f, -3f);
        v12.curveTo(15.39f, 20.48f, 13.76f, 21f, 12f, 21f);
        v12.curveToRelative(-4.97f, 0f, -9f, -4.03f, -9f, -9f);
        v12.curveToRelative(0f, -1.76f, 0.51f, -3.4f, 1.39f, -4.78f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(18.379999f, 18.379999f);
        v12.lineTo(19.780001f, 22.610001f);
        v12.close();
        v12.moveTo(15.32f, 18.15f);
        v12.lineTo(5.84f, 8.67f);
        v12.curveTo(5.31f, 9.66f, 5f, 10.8f, 5f, 12f);
        v12.curveToRelative(0f, 3.86f, 3.14f, 7f, 7f, 7f);
        v12.curveTo(13.2f, 19f, 14.34f, 18.690001f, 15.32f, 18.15f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        UpdateDisabledKt._updateDisabled = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

