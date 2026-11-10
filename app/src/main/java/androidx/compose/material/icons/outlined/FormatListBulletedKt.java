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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_formatListBulleted", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FormatListBulleted", "Landroidx/compose/material/icons/Icons$Outlined;", "getFormatListBulleted$annotations", "(Landroidx/compose/material/icons/Icons$Outlined;)V", "getFormatListBulleted", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FormatListBulletedKt {
    private static ImageVector _formatListBulleted;

    static {
    }

    public static final ImageVector getFormatListBulleted(Outlined arg19) {
        ImageVector v0 = FormatListBulletedKt._formatListBulleted;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.FormatListBulleted", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4f, 10.5f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, 0.67f, -1.5f, 1.5f);
        v12.reflectiveCurveToRelative(0.67f, 1.5f, 1.5f, 1.5f);
        v12.reflectiveCurveToRelative(1.5f, -0.67f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(-0.67f, -1.5f, -1.5f, -1.5f);
        v12.close();
        v12.moveTo(4f, 4.5f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, 0.67f, -1.5f, 1.5f);
        v12.reflectiveCurveTo(3.17f, 7.5f, 4f, 7.5f);
        v12.reflectiveCurveTo(5.5f, 6.83f, 5.5f, 6f);
        v12.reflectiveCurveTo(4.83f, 4.5f, 4f, 4.5f);
        v12.close();
        v12.moveTo(4f, 16.5f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, 0.68f, -1.5f, 1.5f);
        v12.reflectiveCurveToRelative(0.68f, 1.5f, 1.5f, 1.5f);
        v12.reflectiveCurveToRelative(1.5f, -0.68f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(-0.67f, -1.5f, -1.5f, -1.5f);
        v12.close();
        v12.moveTo(7f, 19f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineToRelative(-2f);
        v12.lineTo(7f, 17f);
        v12.verticalLineToRelative(2f);
        v12.close();
        v12.moveTo(7f, 13f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineToRelative(-2f);
        v12.lineTo(7f, 11f);
        v12.verticalLineToRelative(2f);
        v12.close();
        v12.moveTo(7f, 5f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(14f);
        v12.lineTo(21f, 5f);
        v12.lineTo(7f, 5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FormatListBulletedKt._formatListBulleted = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Outlined.FormatListBulleted", replaceWith="<_subannotation>") public static void getFormatListBulleted$annotations(Outlined arg0) {
    }
}

