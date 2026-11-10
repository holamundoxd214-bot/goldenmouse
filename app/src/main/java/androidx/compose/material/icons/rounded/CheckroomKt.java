package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_checkroom", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Checkroom", "Landroidx/compose/material/icons/Icons$Rounded;", "getCheckroom", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CheckroomKt {
    private static ImageVector _checkroom;

    static {
    }

    public static final ImageVector getCheckroom(Rounded arg19) {
        ImageVector v0 = CheckroomKt._checkroom;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Checkroom", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.6f, 18.200001f);
        v12.lineTo(13f, 11.75f);
        v12.verticalLineToRelative(-0.91f);
        v12.curveToRelative(1.65f, -0.49f, 2.8f, -2.17f, 2.43f, -4.05f);
        v12.curveToRelative(-0.26f, -1.31f, -1.3f, -2.4f, -2.61f, -2.7f);
        v12.curveToRelative(-1.76f, -0.4f, -3.37f, 0.53f, -4.02f, 1.98f);
        v12.curveTo(8.5f, 6.74f, 8.98f, 7.5f, 9.71f, 7.5f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.39f, 0f, 0.75f, -0.22f, 0.9f, -0.57f);
        v12.curveTo(10.84f, 6.38f, 11.37f, 6f, 12f, 6f);
        v12.curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f);
        v12.curveToRelative(0f, 0.84f, -0.69f, 1.52f, -1.53f, 1.5f);
        v12.curveTo(11.43f, 8.99f, 11f, 9.45f, 11f, 9.99f);
        v12.lineToRelative(0f, 1.76f);
        v12.lineTo(2.4f, 18.200001f);
        v12.curveTo(1.63f, 18.780001f, 2.04f, 20f, 3f, 20f);
        v12.horizontalLineToRelative(9f);
        v12.horizontalLineToRelative(9f);
        v12.curveTo(21.959999f, 20f, 22.370001f, 18.780001f, 21.6f, 18.200001f);
        v12.close();
        v12.moveTo(6f, 18f);
        v12.lineToRelative(6f, -4.5f);
        v12.lineToRelative(6f, 4.5f);
        v12.horizontalLineTo(6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CheckroomKt._checkroom = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

