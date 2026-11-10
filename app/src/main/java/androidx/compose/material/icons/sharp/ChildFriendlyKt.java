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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_childFriendly", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ChildFriendly", "Landroidx/compose/material/icons/Icons$Sharp;", "getChildFriendly", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ChildFriendlyKt {
    private static ImageVector _childFriendly;

    static {
    }

    public static final ImageVector getChildFriendly(Sharp arg19) {
        ImageVector v0 = ChildFriendlyKt._childFriendly;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.ChildFriendly", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13f, 2f);
        v12.verticalLineToRelative(8f);
        v12.horizontalLineToRelative(8f);
        v12.curveToRelative(0f, -4.42f, -3.58f, -8f, -8f, -8f);
        v12.close();
        v12.moveTo(19.32f, 15.89f);
        v12.curveTo(20.370001f, 14.54f, 21f, 12.84f, 21f, 11f);
        v12.lineTo(6.44f, 11f);
        v12.lineToRelative(-0.95f, -2f);
        v12.lineTo(2f, 9f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2.22f);
        v12.reflectiveCurveToRelative(1.89f, 4.07f, 2.12f, 4.42f);
        v12.curveToRelative(-1.1f, 0.59f, -1.84f, 1.75f, -1.84f, 3.08f);
        v12.curveTo(4.5f, 20.43f, 6.07f, 22f, 8f, 22f);
        v12.curveToRelative(1.76f, 0f, 3.22f, -1.3f, 3.46f, -3f);
        v12.horizontalLineToRelative(2.08f);
        v12.curveToRelative(0.24f, 1.7f, 1.7f, 3f, 3.46f, 3f);
        v12.curveToRelative(1.93f, 0f, 3.5f, -1.57f, 3.5f, -3.5f);
        v12.curveToRelative(0f, -1.04f, -0.46f, -1.97f, -1.18f, -2.61f);
        v12.close();
        v12.moveTo(8f, 20f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveTo(7.17f, 17f, 8f, 17f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(8.83f, 20f, 8f, 20f);
        v12.close();
        v12.moveTo(17f, 20f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveTo(16.17f, 17f, 17f, 17f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(17.83f, 20f, 17f, 20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ChildFriendlyKt._childFriendly = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

