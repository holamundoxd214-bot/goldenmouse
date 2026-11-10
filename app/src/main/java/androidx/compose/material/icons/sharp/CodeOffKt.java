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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_codeOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CodeOff", "Landroidx/compose/material/icons/Icons$Sharp;", "getCodeOff", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CodeOffKt {
    private static ImageVector _codeOff;

    static {
    }

    public static final ImageVector getCodeOff(Sharp arg18) {
        ImageVector v0 = CodeOffKt._codeOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.CodeOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(19.17f, 12f);
        v0_1.lineToRelative(-4.58f, -4.59f);
        v0_1.lineTo(16f, 6f);
        v0_1.lineToRelative(6f, 6f);
        v0_1.lineToRelative(-3.59f, 3.59f);
        v0_1.lineTo(17f, 14.17f);
        v0_1.lineTo(19.17f, 12f);
        v0_1.close();
        v0_1.moveTo(1.39f, 4.22f);
        v0_1.lineToRelative(4.19f, 4.19f);
        v0_1.lineTo(2f, 12f);
        v0_1.lineToRelative(6f, 6f);
        v0_1.lineToRelative(1.41f, -1.41f);
        v0_1.lineTo(4.83f, 12f);
        v0_1.lineTo(7f, 9.83f);
        v0_1.lineToRelative(12.78f, 12.78f);
        v0_1.lineToRelative(1.41f, -1.41f);
        v0_1.lineTo(2.81f, 2.81f);
        v0_1.lineTo(1.39f, 4.22f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CodeOffKt._codeOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

