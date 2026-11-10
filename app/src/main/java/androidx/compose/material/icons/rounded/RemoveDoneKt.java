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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_removeDone", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RemoveDone", "Landroidx/compose/material/icons/Icons$Rounded;", "getRemoveDone", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RemoveDoneKt {
    private static ImageVector _removeDone;

    static {
    }

    public static final ImageVector getRemoveDone(Rounded arg19) {
        ImageVector v0 = RemoveDoneKt._removeDone;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.RemoveDone", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4.14f, 2.69f);
        v12.lineTo(4.14f, 2.69f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(9.67f, 9.67f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.lineToRelative(-3.54f, -3.53f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(4.24f, 4.24f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(2.12f, -2.12f);
        v12.lineToRelative(5.89f, 5.89f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(5.55f, 2.69f);
        v12.curveTo(5.16f, 2.3f, 4.53f, 2.3f, 4.14f, 2.69f);
        v12.close();
        v12.moveTo(18.049999f, 12.36f);
        v12.lineToRelative(4.24f, -4.24f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.03f, -0.01f, -1.42f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.39f, -0.38f, -1.02f, -0.38f, -1.41f, 0.01f);
        v12.lineToRelative(-4.24f, 4.24f);
        v12.lineTo(18.049999f, 12.36f);
        v12.close();
        v12.moveTo(16.639999f, 6.7f);
        v12.lineTo(16.639999f, 6.7f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineToRelative(-1.42f, 1.42f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(1.42f, -1.42f);
        v12.curveTo(17.030001f, 7.72f, 17.030001f, 7.09f, 16.639999f, 6.7f);
        v12.close();
        v12.moveTo(1.79f, 13.06f);
        v12.lineToRelative(4.95f, 4.95f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(3.2f, 11.65f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(1.4f, 12.04f, 1.4f, 12.67f, 1.79f, 13.06f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RemoveDoneKt._removeDone = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

