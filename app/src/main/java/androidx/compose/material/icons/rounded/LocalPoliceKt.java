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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_localPolice", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocalPolice", "Landroidx/compose/material/icons/Icons$Rounded;", "getLocalPolice", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LocalPoliceKt {
    private static ImageVector _localPolice;

    static {
    }

    public static final ImageVector getLocalPolice(Rounded arg19) {
        ImageVector v0 = LocalPoliceKt._localPolice;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.LocalPolice", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.5f, 12.59f);
        v12.lineToRelative(0.63f, 2.73f);
        v12.curveToRelative(0.1f, 0.43f, -0.37f, 0.77f, -0.75f, 0.54f);
        v12.lineTo(12f, 14.42f);
        v12.lineToRelative(-2.39f, 1.44f);
        v12.curveToRelative(-0.38f, 0.23f, -0.85f, -0.11f, -0.75f, -0.54f);
        v12.lineTo(9.5f, 12.6f);
        v12.lineToRelative(-2.1f, -1.81f);
        v12.curveTo(7.06f, 10.5f, 7.24f, 9.95f, 7.68f, 9.91f);
        v12.lineToRelative(2.78f, -0.24f);
        v12.lineToRelative(1.08f, -2.56f);
        v12.curveToRelative(0.17f, -0.41f, 0.75f, -0.41f, 0.92f, 0f);
        v12.lineToRelative(1.08f, 2.55f);
        v12.lineToRelative(2.78f, 0.24f);
        v12.curveToRelative(0.44f, 0.04f, 0.62f, 0.59f, 0.28f, 0.88f);
        v12.lineTo(14.5f, 12.59f);
        v12.close();
        v12.moveTo(4.19f, 4.47f);
        v12.curveTo(3.47f, 4.79f, 3f, 5.51f, 3f, 6.3f);
        v12.verticalLineTo(11f);
        v12.curveToRelative(0f, 5.55f, 3.84f, 10.74f, 9f, 12f);
        v12.curveToRelative(5.16f, -1.26f, 9f, -6.45f, 9f, -12f);
        v12.verticalLineTo(6.3f);
        v12.curveToRelative(0f, -0.79f, -0.47f, -1.51f, -1.19f, -1.83f);
        v12.lineToRelative(-7f, -3.11f);
        v12.curveToRelative(-0.52f, -0.23f, -1.11f, -0.23f, -1.62f, 0f);
        v12.lineTo(4.19f, 4.47f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LocalPoliceKt._localPolice = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

