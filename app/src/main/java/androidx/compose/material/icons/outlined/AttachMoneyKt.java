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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_attachMoney", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AttachMoney", "Landroidx/compose/material/icons/Icons$Outlined;", "getAttachMoney", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AttachMoneyKt {
    private static ImageVector _attachMoney;

    static {
    }

    public static final ImageVector getAttachMoney(Outlined arg19) {
        ImageVector v0 = AttachMoneyKt._attachMoney;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.AttachMoney", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.8f, 10.9f);
        v12.curveToRelative(-2.27f, -0.59f, -3f, -1.2f, -3f, -2.15f);
        v12.curveToRelative(0f, -1.09f, 1.01f, -1.85f, 2.7f, -1.85f);
        v12.curveToRelative(1.78f, 0f, 2.44f, 0.85f, 2.5f, 2.1f);
        v12.horizontalLineToRelative(2.21f);
        v12.curveToRelative(-0.07f, -1.72f, -1.12f, -3.3f, -3.21f, -3.81f);
        v12.verticalLineTo(3f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineToRelative(2.16f);
        v12.curveToRelative(-1.94f, 0.42f, -3.5f, 1.68f, -3.5f, 3.61f);
        v12.curveToRelative(0f, 2.31f, 1.91f, 3.46f, 4.7f, 4.13f);
        v12.curveToRelative(2.5f, 0.6f, 3f, 1.48f, 3f, 2.41f);
        v12.curveToRelative(0f, 0.69f, -0.49f, 1.79f, -2.7f, 1.79f);
        v12.curveToRelative(-2.06f, 0f, -2.87f, -0.92f, -2.98f, -2.1f);
        v12.horizontalLineToRelative(-2.2f);
        v12.curveToRelative(0.12f, 2.19f, 1.76f, 3.42f, 3.68f, 3.83f);
        v12.verticalLineTo(21f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(-2.15f);
        v12.curveToRelative(1.95f, -0.37f, 3.5f, -1.5f, 3.5f, -3.55f);
        v12.curveToRelative(0f, -2.84f, -2.43f, -3.81f, -4.7f, -4.4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AttachMoneyKt._attachMoney = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

