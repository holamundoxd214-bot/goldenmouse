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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_dataObject", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DataObject", "Landroidx/compose/material/icons/Icons$Filled;", "getDataObject", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DataObjectKt {
    private static ImageVector _dataObject;

    static {
    }

    public static final ImageVector getDataObject(Filled arg19) {
        ImageVector v0 = DataObjectKt._dataObject;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.DataObject", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4f, 7f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineTo(2f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 1.65f, 1.35f, 3f, 3f, 3f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(7f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(0f, -1.3f, -0.84f, -2.42f, -2f, -2.83f);
        v12.verticalLineToRelative(-0.34f);
        v12.curveTo(5.16f, 11.42f, 6f, 10.3f, 6f, 9f);
        v12.verticalLineTo(7f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineTo(4f);
        v12.horizontalLineTo(7f);
        v12.curveTo(5.35f, 4f, 4f, 5.35f, 4f, 7f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(21f, 10f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineTo(7f);
        v12.curveToRelative(0f, -1.65f, -1.35f, -3f, -3f, -3f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 1.3f, 0.84f, 2.42f, 2f, 2.83f);
        v12.verticalLineToRelative(0.34f);
        v12.curveToRelative(-1.16f, 0.41f, -2f, 1.52f, -2f, 2.83f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(1.65f, 0f, 3f, -1.35f, 3f, -3f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(-4f);
        v12.horizontalLineTo(21f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DataObjectKt._dataObject = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

