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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_editLocationAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "EditLocationAlt", "Landroidx/compose/material/icons/Icons$Outlined;", "getEditLocationAlt", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EditLocationAltKt {
    private static ImageVector _editLocationAlt;

    static {
    }

    public static final ImageVector getEditLocationAlt(Outlined arg19) {
        ImageVector v0 = EditLocationAltKt._editLocationAlt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.EditLocationAlt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11f, 11f);
        v12.horizontalLineToRelative(2.12f);
        v12.lineToRelative(6.16f, -6.16f);
        v12.lineToRelative(-2.12f, -2.12f);
        v12.lineTo(11f, 8.88f);
        v12.verticalLineTo(11f);
        v12.close();
        v12.moveTo(20.709999f, 2f);
        v12.lineTo(20f, 1.29f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineToRelative(-0.72f, 0.72f);
        v12.lineToRelative(2.12f, 2.12f);
        v12.lineToRelative(0.72f, -0.72f);
        v12.curveTo(21.1f, 3.02f, 21.1f, 2.39f, 20.709999f, 2f);
        v12.close();
        v12.moveTo(17.9f, 9.05f);
        v12.curveTo(17.959999f, 9.41f, 18f, 9.79f, 18f, 10.2f);
        v12.curveToRelative(0f, 1.71f, -1.08f, 4.64f, -6f, 9.14f);
        v12.curveToRelative(-4.92f, -4.49f, -6f, -7.43f, -6f, -9.14f);
        v12.curveTo(6f, 6.17f, 9.09f, 4f, 12f, 4f);
        v12.curveToRelative(0.32f, 0f, 0.65f, 0.03f, 0.97f, 0.08f);
        v12.lineToRelative(1.65f, -1.65f);
        v12.curveTo(13.78f, 2.16f, 12.9f, 2f, 12f, 2f);
        v12.curveToRelative(-4.2f, 0f, -8f, 3.22f, -8f, 8.2f);
        v12.curveToRelative(0f, 3.32f, 2.67f, 7.25f, 8f, 11.8f);
        v12.curveToRelative(5.33f, -4.55f, 8f, -8.48f, 8f, -11.8f);
        v12.curveToRelative(0f, -1.01f, -0.16f, -1.94f, -0.45f, -2.8f);
        v12.lineTo(17.9f, 9.05f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EditLocationAltKt._editLocationAlt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

