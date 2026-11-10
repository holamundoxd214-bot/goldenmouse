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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_localDining", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocalDining", "Landroidx/compose/material/icons/Icons$Rounded;", "getLocalDining", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LocalDiningKt {
    private static ImageVector _localDining;

    static {
    }

    public static final ImageVector getLocalDining(Rounded arg19) {
        ImageVector v0 = LocalDiningKt._localDining;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.LocalDining", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8.1f, 13.34f);
        v12.lineToRelative(2.83f, -2.83f);
        v12.lineToRelative(-6.19f, -6.18f);
        v12.curveToRelative(-0.48f, -0.48f, -1.31f, -0.35f, -1.61f, 0.27f);
        v12.curveToRelative(-0.71f, 1.49f, -0.45f, 3.32f, 0.78f, 4.56f);
        v12.lineToRelative(4.19f, 4.18f);
        v12.close();
        v12.moveTo(14.88f, 11.53f);
        v12.curveToRelative(1.53f, 0.71f, 3.68f, 0.21f, 5.27f, -1.38f);
        v12.curveToRelative(1.91f, -1.91f, 2.28f, -4.65f, 0.81f, -6.12f);
        v12.curveToRelative(-1.46f, -1.46f, -4.2f, -1.1f, -6.12f, 0.81f);
        v12.curveToRelative(-1.59f, 1.59f, -2.09f, 3.74f, -1.38f, 5.27f);
        v12.lineToRelative(-9.05f, 9.05f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineTo(12f, 14.41f);
        v12.lineToRelative(6.18f, 6.18f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(13.41f, 13f);
        v12.lineToRelative(1.47f, -1.47f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LocalDiningKt._localDining = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

