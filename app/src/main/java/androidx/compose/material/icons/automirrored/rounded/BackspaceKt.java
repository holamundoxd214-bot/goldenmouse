package androidx.compose.material.icons.automirrored.rounded;

import androidx.compose.material.icons.Icons$AutoMirrored$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_backspace", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Backspace", "Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;", "getBackspace", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BackspaceKt {
    private static ImageVector _backspace;

    static {
    }

    public static final ImageVector getBackspace(Rounded arg19) {
        ImageVector v0 = BackspaceKt._backspace;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Rounded.Backspace", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 3f);
        v12.lineTo(7f, 3f);
        v12.curveToRelative(-0.69f, 0f, -1.23f, 0.35f, -1.59f, 0.88f);
        v12.lineTo(0.37f, 11.45f);
        v12.curveToRelative(-0.22f, 0.34f, -0.22f, 0.77f, 0f, 1.11f);
        v12.lineToRelative(5.04f, 7.56f);
        v12.curveToRelative(0.36f, 0.52f, 0.9f, 0.88f, 1.59f, 0.88f);
        v12.horizontalLineToRelative(15f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(24f, 5f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(18.299999f, 16.299999f);
        v12.curveToRelative(-0.39f, 0.39f, -1.02f, 0.39f, -1.41f, 0f);
        v12.lineTo(14f, 13.41f);
        v12.lineToRelative(-2.89f, 2.89f);
        v12.curveToRelative(-0.39f, 0.39f, -1.02f, 0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(12.59f, 12f);
        v12.lineTo(9.7f, 9.11f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0f);
        v12.lineTo(14f, 10.59f);
        v12.lineToRelative(2.89f, -2.89f);
        v12.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0f);
        v12.curveToRelative(0.39f, 0.39f, 0.39f, 1.02f, 0f, 1.41f);
        v12.lineTo(15.41f, 12f);
        v12.lineToRelative(2.89f, 2.89f);
        v12.curveToRelative(0.38f, 0.38f, 0.38f, 1.02f, 0f, 1.41f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BackspaceKt._backspace = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

