package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_policy", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Policy", "Landroidx/compose/material/icons/Icons$Sharp;", "getPolicy", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PolicyKt {
    private static ImageVector _policy;

    static {
    }

    public static final ImageVector getPolicy(Sharp arg20) {
        ImageVector v0 = PolicyKt._policy;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Policy", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 5f);
        v12.lineToRelative(-9f, -4f);
        v12.lineTo(3f, 5f);
        v12.verticalLineToRelative(6f);
        v12.curveToRelative(0f, 5.55f, 3.84f, 10.74f, 9f, 12f);
        v12.curveToRelative(2.3f, -0.56f, 4.33f, -1.9f, 5.88f, -3.71f);
        v12.lineToRelative(-3.12f, -3.12f);
        v12.curveToRelative(-1.94f, 1.29f, -4.58f, 1.07f, -6.29f, -0.64f);
        v12.curveToRelative(-1.95f, -1.95f, -1.95f, -5.12f, 0f, -7.07f);
        v12.curveToRelative(1.95f, -1.95f, 5.12f, -1.95f, 7.07f, 0f);
        v12.curveToRelative(1.71f, 1.71f, 1.92f, 4.35f, 0.64f, 6.29f);
        v12.lineToRelative(2.9f, 2.9f);
        v12.curveTo(20.290001f, 15.69f, 21f, 13.38f, 21f, 11f);
        v12.verticalLineTo(5f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 12f);
        v12.moveToRelative(-3f, 0f);
        v12.arcToRelative(3f, 3f, 0f, true, true, 6f, 0f);
        v12.arcToRelative(3f, 3f, 0f, true, true, -6f, 0f);
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PolicyKt._policy = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

