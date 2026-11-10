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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_linkedCamera", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LinkedCamera", "Landroidx/compose/material/icons/Icons$Sharp;", "getLinkedCamera", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LinkedCameraKt {
    private static ImageVector _linkedCamera;

    static {
    }

    public static final ImageVector getLinkedCamera(Sharp arg20) {
        ImageVector v0 = LinkedCameraKt._linkedCamera;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.LinkedCamera", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 14f);
        v12.moveToRelative(-3f, 0f);
        v12.arcToRelative(3f, 3f, 0f, true, true, 6f, 0f);
        v12.arcToRelative(3f, 3f, 0f, true, true, -6f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(18f, 8f);
        v12.horizontalLineToRelative(1.33f);
        v12.curveToRelative(0f, -1.84f, -1.49f, -3.33f, -3.33f, -3.33f);
        v12.lineTo(16f, 6f);
        v12.curveToRelative(1.11f, 0f, 2f, 0.89f, 2f, 2f);
        v12.close();
        v12.moveTo(20.67f, 8f);
        v12.lineTo(22f, 8f);
        v12.curveToRelative(0f, -3.31f, -2.69f, -6f, -6f, -6f);
        v12.verticalLineToRelative(1.33f);
        v12.curveToRelative(2.58f, 0f, 4.67f, 2.09f, 4.67f, 4.67f);
        v12.close();
        v12.moveTo(15f, 7f);
        v12.lineTo(15f, 4f);
        v12.lineTo(9f, 4f);
        v12.lineTo(7.17f, 6f);
        v12.lineTo(2f, 6f);
        v12.verticalLineToRelative(16f);
        v12.horizontalLineToRelative(20f);
        v12.lineTo(22f, 9f);
        v12.horizontalLineToRelative(-5f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(12f, 19f);
        v12.curveToRelative(-2.76f, 0f, -5f, -2.24f, -5f, -5f);
        v12.reflectiveCurveToRelative(2.24f, -5f, 5f, -5f);
        v12.reflectiveCurveToRelative(5f, 2.24f, 5f, 5f);
        v12.reflectiveCurveToRelative(-2.24f, 5f, -5f, 5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LinkedCameraKt._linkedCamera = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

