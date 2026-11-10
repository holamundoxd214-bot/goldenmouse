package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_backspace", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Backspace", "Landroidx/compose/material/icons/Icons$Sharp;", "getBackspace$annotations", "(Landroidx/compose/material/icons/Icons$Sharp;)V", "getBackspace", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BackspaceKt {
    private static ImageVector _backspace;

    static {
    }

    public static final ImageVector getBackspace(Sharp arg18) {
        ImageVector v0 = BackspaceKt._backspace;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Backspace", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v2 = new PathBuilder();
        v2.moveTo(24f, 3f);
        v2.lineTo(6f, 3f);
        v2.lineToRelative(-6f, 9f);
        v2.lineToRelative(6f, 9f);
        v2.horizontalLineToRelative(18f);
        v2.lineTo(24f, 3f);
        v2.close();
        v2.moveTo(19f, 15.59f);
        v2.lineTo(17.59f, 17f);
        v2.lineTo(14f, 13.41f);
        v2.lineTo(10.41f, 17f);
        v2.lineTo(9f, 15.59f);
        v2.lineTo(12.59f, 12f);
        v2.lineTo(9f, 8.41f);
        v2.lineTo(10.41f, 7f);
        v2.lineTo(14f, 10.59f);
        v2.lineTo(17.59f, 7f);
        v2.lineTo(19f, 8.41f);
        v2.lineTo(15.41f, 12f);
        v2.lineTo(19f, 15.59f);
        v2.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v2.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BackspaceKt._backspace = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Sharp.Backspace", replaceWith="<_subannotation>") public static void getBackspace$annotations(Sharp arg0) {
    }
}

