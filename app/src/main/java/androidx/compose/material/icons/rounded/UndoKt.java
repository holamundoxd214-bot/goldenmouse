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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_undo", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Undo", "Landroidx/compose/material/icons/Icons$Rounded;", "getUndo$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getUndo", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class UndoKt {
    private static ImageVector _undo;

    static {
    }

    public static final ImageVector getUndo(Rounded arg19) {
        ImageVector v0 = UndoKt._undo;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Undo", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.5f, 8f);
        v12.curveToRelative(-2.65f, 0f, -5.05f, 0.99f, -6.9f, 2.6f);
        v12.lineTo(3.71f, 8.71f);
        v12.curveTo(3.08f, 8.08f, 2f, 8.52f, 2f, 9.41f);
        v12.verticalLineTo(15f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(5.59f);
        v12.curveToRelative(0.89f, 0f, 1.34f, -1.08f, 0.71f, -1.71f);
        v12.lineToRelative(-1.91f, -1.91f);
        v12.curveToRelative(1.39f, -1.16f, 3.16f, -1.88f, 5.12f, -1.88f);
        v12.curveToRelative(3.16f, 0f, 5.89f, 1.84f, 7.19f, 4.5f);
        v12.curveToRelative(0.27f, 0.56f, 0.91f, 0.84f, 1.5f, 0.64f);
        v12.curveToRelative(0.71f, -0.23f, 1.07f, -1.04f, 0.75f, -1.72f);
        v12.curveTo(20.23f, 10.42f, 16.65f, 8f, 12.5f, 8f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        UndoKt._undo = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Rounded.Undo", replaceWith="<_subannotation>") public static void getUndo$annotations(Rounded arg0) {
    }
}

