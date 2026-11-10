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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_localPolice", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocalPolice", "Landroidx/compose/material/icons/Icons$Filled;", "getLocalPolice", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LocalPoliceKt {
    private static ImageVector _localPolice;

    static {
    }

    public static final ImageVector getLocalPolice(Filled arg19) {
        ImageVector v0 = LocalPoliceKt._localPolice;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.LocalPolice", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 1f);
        v12.lineTo(3f, 5f);
        v12.verticalLineToRelative(6f);
        v12.curveToRelative(0f, 5.55f, 3.84f, 10.74f, 9f, 12f);
        v12.curveToRelative(5.16f, -1.26f, 9f, -6.45f, 9f, -12f);
        v12.verticalLineTo(5f);
        v12.lineTo(12f, 1f);
        v12.close();
        v12.moveTo(14.5f, 12.59f);
        v12.lineToRelative(0.9f, 3.88f);
        v12.lineTo(12f, 14.42f);
        v12.lineToRelative(-3.4f, 2.05f);
        v12.lineToRelative(0.9f, -3.87f);
        v12.lineToRelative(-3f, -2.59f);
        v12.lineToRelative(3.96f, -0.34f);
        v12.lineTo(12f, 6.02f);
        v12.lineToRelative(1.54f, 3.64f);
        v12.lineTo(17.5f, 10f);
        v12.lineTo(14.5f, 12.59f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LocalPoliceKt._localPolice = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

