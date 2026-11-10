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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_eco", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Eco", "Landroidx/compose/material/icons/Icons$Rounded;", "getEco", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EcoKt {
    private static ImageVector _eco;

    static {
    }

    public static final ImageVector getEco(Rounded arg19) {
        ImageVector v0 = EcoKt._eco;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Eco", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.950001f, 5.97f);
        v12.curveToRelative(-0.05f, -1.04f, -0.89f, -1.88f, -1.92f, -1.92f);
        v12.curveTo(17.33f, 4.02f, 16.66f, 4f, 16.01f, 4f);
        v12.curveTo(10.98f, 4f, 7.49f, 4.97f, 5.55f, 6.91f);
        v12.curveToRelative(-3.68f, 3.68f, -3.15f, 8.9f, 0.09f, 11.9f);
        v12.curveToRelative(0.01f, 0f, 0.01f, 0f, 0.01f, 0f);
        v12.curveToRelative(1.51f, -4.22f, 4.52f, -7.16f, 7.67f, -8.8f);
        v12.curveToRelative(-0.21f, 0.18f, -4.7f, 3.58f, -5.51f, 10.25f);
        v12.curveToRelative(1.05f, 0.48f, 2.2f, 0.75f, 3.36f, 0.75f);
        v12.curveToRelative(2.05f, 0f, 4.16f, -0.8f, 5.92f, -2.55f);
        v12.curveTo(19.280001f, 16.26f, 20.23f, 12.1f, 19.950001f, 5.97f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EcoKt._eco = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

