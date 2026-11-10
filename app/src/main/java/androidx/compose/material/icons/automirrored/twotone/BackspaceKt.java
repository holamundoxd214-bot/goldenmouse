package androidx.compose.material.icons.automirrored.twotone;

import androidx.compose.material.icons.Icons$AutoMirrored$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_backspace", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Backspace", "Landroidx/compose/material/icons/Icons$AutoMirrored$TwoTone;", "getBackspace", "(Landroidx/compose/material/icons/Icons$AutoMirrored$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BackspaceKt {
    private static ImageVector _backspace;

    static {
    }

    public static final ImageVector getBackspace(TwoTone arg19) {
        ImageVector v0 = BackspaceKt._backspace;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.TwoTone.Backspace", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7.06f, 5f);
        v12.lineTo(2.4f, 12f);
        v12.lineToRelative(4.67f, 7f);
        v12.horizontalLineTo(22f);
        v12.verticalLineTo(5f);
        v12.horizontalLineTo(7.06f);
        v12.curveToRelative(0.01f, 0f, 0.01f, 0f, 0f, 0f);
        v12.close();
        v12.moveTo(9f, 8.41f);
        v12.lineTo(10.41f, 7f);
        v12.lineTo(14f, 10.59f);
        v12.lineTo(17.59f, 7f);
        v12.lineTo(19f, 8.41f);
        v12.lineTo(15.41f, 12f);
        v12.lineTo(19f, 15.59f);
        v12.lineTo(17.59f, 17f);
        v12.lineTo(14f, 13.41f);
        v12.lineTo(10.41f, 17f);
        v12.lineTo(9f, 15.59f);
        v12.lineTo(12.59f, 12f);
        v12.lineTo(9f, 8.41f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(22f, 3f);
        v12.lineTo(7f, 3f);
        v12.curveToRelative(-0.69f, 0f, -1.23f, 0.35f, -1.59f, 0.88f);
        v12.lineTo(0f, 12f);
        v12.lineToRelative(5.41f, 8.11f);
        v12.curveToRelative(0.36f, 0.53f, 0.9f, 0.89f, 1.59f, 0.89f);
        v12.horizontalLineToRelative(15f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(24f, 5f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(22f, 19f);
        v12.lineTo(7.07f, 19f);
        v12.lineTo(2.4f, 12f);
        v12.lineToRelative(4.66f, -7f);
        v12.lineTo(22f, 5f);
        v12.verticalLineToRelative(14f);
        v12.close();
        v12.moveTo(10.41f, 17f);
        v12.lineTo(14f, 13.41f);
        v12.lineTo(17.59f, 17f);
        v12.lineTo(19f, 15.59f);
        v12.lineTo(15.41f, 12f);
        v12.lineTo(19f, 8.41f);
        v12.lineTo(17.59f, 7f);
        v12.lineTo(14f, 10.59f);
        v12.lineTo(10.41f, 7f);
        v12.lineTo(9f, 8.41f);
        v12.lineTo(12.59f, 12f);
        v12.lineTo(9f, 15.59f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BackspaceKt._backspace = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

