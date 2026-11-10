package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_saveAs", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SaveAs", "Landroidx/compose/material/icons/Icons$Filled;", "getSaveAs", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SaveAsKt {
    private static ImageVector _saveAs;

    static {
    }

    public static final ImageVector getSaveAs(Filled arg19) {
        ImageVector v0 = SaveAsKt._saveAs;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.SaveAs", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 12.4f);
        v12.verticalLineTo(7f);
        v12.lineToRelative(-4f, -4f);
        v12.horizontalLineTo(5f);
        v12.curveTo(3.89f, 3f, 3f, 3.9f, 3f, 5f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.89f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(7.4f);
        v12.lineTo(21f, 12.4f);
        v12.close();
        v12.moveTo(15f, 15f);
        v12.curveToRelative(0f, 1.66f, -1.34f, 3f, -3f, 3f);
        v12.reflectiveCurveToRelative(-3f, -1.34f, -3f, -3f);
        v12.reflectiveCurveToRelative(1.34f, -3f, 3f, -3f);
        v12.reflectiveCurveTo(15f, 13.34f, 15f, 15f);
        v12.close();
        v12.moveTo(6f, 6f);
        v12.horizontalLineToRelative(9f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineTo(6f);
        v12.verticalLineTo(6f);
        v12.close();
        v12.moveTo(19.99f, 16.25f);
        v12.lineToRelative(1.77f, 1.77f);
        v12.lineTo(16.77f, 23f);
        v12.horizontalLineTo(15f);
        v12.verticalLineToRelative(-1.77f);
        v12.lineTo(19.99f, 16.25f);
        v12.close();
        v12.moveTo(23.25f, 16.51f);
        v12.lineToRelative(-0.85f, 0.85f);
        v12.lineToRelative(-1.77f, -1.77f);
        v12.lineToRelative(0.85f, -0.85f);
        v12.curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f);
        v12.lineToRelative(1.06f, 1.06f);
        v12.curveTo(23.450001f, 16f, 23.450001f, 16.32f, 23.25f, 16.51f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SaveAsKt._saveAs = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

