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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_moveToInbox", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MoveToInbox", "Landroidx/compose/material/icons/Icons$Outlined;", "getMoveToInbox", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MoveToInboxKt {
    private static ImageVector _moveToInbox;

    static {
    }

    public static final ImageVector getMoveToInbox(Outlined arg19) {
        ImageVector v0 = MoveToInboxKt._moveToInbox;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.MoveToInbox", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 9f);
        v12.horizontalLineToRelative(-2.55f);
        v12.lineTo(13.45f, 6f);
        v12.horizontalLineToRelative(-2.9f);
        v12.verticalLineToRelative(3f);
        v12.lineTo(8f, 9f);
        v12.lineToRelative(4f, 4f);
        v12.close();
        v12.moveTo(19f, 3f);
        v12.lineTo(4.99f, 3f);
        v12.curveTo(3.88f, 3f, 3f, 3.9f, 3f, 5f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.88f, 2f, 1.99f, 2f);
        v12.lineTo(19f, 21f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(21f, 5f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(19f, 19f);
        v12.lineTo(5f, 19f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(3.56f);
        v12.curveToRelative(0.69f, 1.19f, 1.97f, 2f, 3.45f, 2f);
        v12.reflectiveCurveToRelative(2.75f, -0.81f, 3.45f, -2f);
        v12.lineTo(19f, 16f);
        v12.verticalLineToRelative(3f);
        v12.close();
        v12.moveTo(19f, 14f);
        v12.horizontalLineToRelative(-4.99f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f);
        v12.lineTo(5f, 14f);
        v12.lineToRelative(-0.01f, -9f);
        v12.lineTo(19f, 5f);
        v12.verticalLineToRelative(9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MoveToInboxKt._moveToInbox = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

