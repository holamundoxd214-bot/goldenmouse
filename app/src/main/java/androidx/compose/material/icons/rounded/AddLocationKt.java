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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_addLocation", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AddLocation", "Landroidx/compose/material/icons/Icons$Rounded;", "getAddLocation", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AddLocationKt {
    private static ImageVector _addLocation;

    static {
    }

    public static final ImageVector getAddLocation(Rounded arg19) {
        ImageVector v0 = AddLocationKt._addLocation;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.AddLocation", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13f, 7f);
        v12.curveToRelative(0f, -0.55f, -0.44f, -1f, -1f, -1f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.44f, -1f, 1f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(9f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.44f, -1f, 1f);
        v12.curveToRelative(0f, 0.55f, 0.44f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 0.55f, 0.44f, 1f, 1f, 1f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.44f, 1f, -1f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.44f, 1f, -1f);
        v12.curveToRelative(0f, -0.55f, -0.44f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(7f);
        v12.close();
        v12.moveTo(12f, 2f);
        v12.curveToRelative(4.2f, 0f, 8f, 3.22f, 8f, 8.2f);
        v12.curveToRelative(0f, 3.18f, -2.45f, 6.92f, -7.34f, 11.23f);
        v12.curveToRelative(-0.38f, 0.33f, -0.95f, 0.33f, -1.33f, 0f);
        v12.curveTo(6.45f, 17.120001f, 4f, 13.38f, 4f, 10.2f);
        v12.curveTo(4f, 5.22f, 7.8f, 2f, 12f, 2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AddLocationKt._addLocation = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

