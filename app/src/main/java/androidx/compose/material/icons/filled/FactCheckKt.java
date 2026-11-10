package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector$Builder;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_factCheck", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FactCheck", "Landroidx/compose/material/icons/Icons$Filled;", "getFactCheck$annotations", "(Landroidx/compose/material/icons/Icons$Filled;)V", "getFactCheck", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FactCheckKt {
    private static ImageVector _factCheck;

    static {
    }

    public static final ImageVector getFactCheck(Filled arg19) {
        ImageVector v0 = FactCheckKt._factCheck;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.FactCheck", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = PathFillType.Companion.getEvenOdd-Rg-k1Os();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 3f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.9f, 3f, 2f, 3.9f, 2f, 5f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(5f);
        v12.curveTo(22f, 3.9f, 21.1f, 3f, 20f, 3f);
        v12.close();
        v12.moveTo(10f, 17f);
        v12.horizontalLineTo(5f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineTo(17f);
        v12.close();
        v12.moveTo(10f, 13f);
        v12.horizontalLineTo(5f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineTo(13f);
        v12.close();
        v12.moveTo(10f, 9f);
        v12.horizontalLineTo(5f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineTo(9f);
        v12.close();
        v12.moveTo(14.82f, 15f);
        v12.lineTo(12f, 12.16f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(1.41f, 1.42f);
        v12.lineTo(17.99f, 9f);
        v12.lineToRelative(1.42f, 1.42f);
        v12.lineTo(14.82f, 15f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FactCheckKt._factCheck = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Filled.FactCheck", replaceWith="<_subannotation>") public static void getFactCheck$annotations(Filled arg0) {
    }
}

