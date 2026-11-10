package androidx.compose.material.icons.automirrored.outlined;

import androidx.compose.material.icons.Icons$AutoMirrored$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_listAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ListAlt", "Landroidx/compose/material/icons/Icons$AutoMirrored$Outlined;", "getListAlt", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ListAltKt {
    private static ImageVector _listAlt;

    static {
    }

    public static final ImageVector getListAlt(Outlined arg19) {
        ImageVector v0 = ListAltKt._listAlt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Outlined.ListAlt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11f, 7f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-6f);
        v12.close();
        v12.moveTo(11f, 11f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-6f);
        v12.close();
        v12.moveTo(11f, 15f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-6f);
        v12.close();
        v12.moveTo(7f, 7f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.lineTo(7f, 9f);
        v12.close();
        v12.moveTo(7f, 11f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.lineTo(7f, 13f);
        v12.close();
        v12.moveTo(7f, 15f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.lineTo(7f, 17f);
        v12.close();
        v12.moveTo(20.1f, 3f);
        v12.lineTo(3.9f, 3f);
        v12.curveToRelative(-0.5f, 0f, -0.9f, 0.4f, -0.9f, 0.9f);
        v12.verticalLineToRelative(16.200001f);
        v12.curveToRelative(0f, 0.4f, 0.4f, 0.9f, 0.9f, 0.9f);
        v12.horizontalLineToRelative(16.200001f);
        v12.curveToRelative(0.4f, 0f, 0.9f, -0.5f, 0.9f, -0.9f);
        v12.lineTo(21f, 3.9f);
        v12.curveToRelative(0f, -0.5f, -0.5f, -0.9f, -0.9f, -0.9f);
        v12.close();
        v12.moveTo(19f, 19f);
        v12.lineTo(5f, 19f);
        v12.lineTo(5f, 5f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineToRelative(14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ListAltKt._listAlt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

