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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_forward", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Forward", "Landroidx/compose/material/icons/Icons$TwoTone;", "getForward$annotations", "(Landroidx/compose/material/icons/Icons$TwoTone;)V", "getForward", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ForwardKt {
    private static ImageVector _forward;

    static {
    }

    public static final ImageVector getForward(TwoTone arg25) {
        ImageVector v0 = ForwardKt._forward;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Forward", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(14f, 14f);
        v0_1.verticalLineToRelative(1.17f);
        v0_1.lineTo(17.17f, 12f);
        v0_1.lineTo(14f, 8.83f);
        v0_1.verticalLineTo(10f);
        v0_1.horizontalLineTo(6f);
        v0_1.verticalLineToRelative(4f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(20f, 12f);
        v0_1.lineToRelative(-8f, -8f);
        v0_1.verticalLineToRelative(4f);
        v0_1.horizontalLineTo(4f);
        v0_1.verticalLineToRelative(8f);
        v0_1.horizontalLineToRelative(8f);
        v0_1.verticalLineToRelative(4f);
        v0_1.lineToRelative(8f, -8f);
        v0_1.close();
        v0_1.moveTo(6f, 14f);
        v0_1.verticalLineToRelative(-4f);
        v0_1.horizontalLineToRelative(8f);
        v0_1.verticalLineTo(8.83f);
        v0_1.lineTo(17.17f, 12f);
        v0_1.lineTo(14f, 15.17f);
        v0_1.verticalLineTo(14f);
        v0_1.horizontalLineTo(6f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ForwardKt._forward = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.TwoTone.Forward", replaceWith="<_subannotation>") public static void getForward$annotations(TwoTone arg0) {
    }
}

