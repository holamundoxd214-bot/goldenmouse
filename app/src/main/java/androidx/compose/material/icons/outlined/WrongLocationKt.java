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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wrongLocation", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WrongLocation", "Landroidx/compose/material/icons/Icons$Outlined;", "getWrongLocation", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WrongLocationKt {
    private static ImageVector _wrongLocation;

    static {
    }

    public static final ImageVector getWrongLocation(Outlined arg20) {
        ImageVector v0 = WrongLocationKt._wrongLocation;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.WrongLocation", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 11f);
        v12.curveToRelative(0f, 0.07f, 0f, 0.13f, 0f, 0.2f);
        v12.curveToRelative(0f, 2.34f, -1.95f, 5.44f, -6f, 9.14f);
        v12.curveToRelative(-4.05f, -3.7f, -6f, -6.79f, -6f, -9.14f);
        v12.curveTo(6f, 7.57f, 8.65f, 5f, 12f, 5f);
        v12.curveToRelative(0.34f, 0f, 0.68f, 0.03f, 1f, 0.08f);
        v12.verticalLineTo(3.06f);
        v12.curveTo(12.67f, 3.02f, 12.34f, 3f, 12f, 3f);
        v12.curveToRelative(-4.2f, 0f, -8f, 3.22f, -8f, 8.2f);
        v12.curveToRelative(0f, 3.32f, 2.67f, 7.25f, 8f, 11.8f);
        v12.curveToRelative(5.33f, -4.55f, 8f, -8.48f, 8f, -11.8f);
        v12.curveToRelative(0f, -0.07f, 0f, -0.13f, 0f, -0.2f);
        v12.horizontalLineTo(18f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 11f);
        v12.moveToRelative(-2f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, 4f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, -4f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(22.540001f, 2.88f);
        v0_1.lineToRelative(-1.42f, -1.42f);
        v0_1.lineToRelative(-2.12f, 2.13f);
        v0_1.lineToRelative(-2.12f, -2.13f);
        v0_1.lineToRelative(-1.42f, 1.42f);
        v0_1.lineToRelative(2.13f, 2.12f);
        v0_1.lineToRelative(-2.13f, 2.12f);
        v0_1.lineToRelative(1.42f, 1.42f);
        v0_1.lineToRelative(2.12f, -2.13f);
        v0_1.lineToRelative(2.12f, 2.13f);
        v0_1.lineToRelative(1.42f, -1.42f);
        v0_1.lineToRelative(-2.13f, -2.12f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WrongLocationKt._wrongLocation = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

