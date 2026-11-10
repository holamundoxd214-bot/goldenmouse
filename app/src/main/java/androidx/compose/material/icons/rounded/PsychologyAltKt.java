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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_psychologyAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PsychologyAlt", "Landroidx/compose/material/icons/Icons$Rounded;", "getPsychologyAlt", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PsychologyAltKt {
    private static ImageVector _psychologyAlt;

    static {
    }

    public static final ImageVector getPsychologyAlt(Rounded arg19) {
        ImageVector v0 = PsychologyAltKt._psychologyAlt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.PsychologyAlt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.940001f, 9.06f);
        v12.curveTo(19.5f, 5.73f, 16.57f, 3f, 13f, 3f);
        v12.curveTo(9.47f, 3f, 6.57f, 5.61f, 6.08f, 9f);
        v12.lineToRelative(-1.93f, 3.48f);
        v12.curveTo(3.74f, 13.14f, 4.22f, 14f, 5f, 14f);
        v12.horizontalLineToRelative(1f);
        v12.lineToRelative(0f, 2f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(5f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.lineToRelative(0f, -3.68f);
        v12.curveTo(18.620001f, 15.07f, 20.35f, 12.24f, 19.940001f, 9.06f);
        v12.close();
        v12.moveTo(12.5f, 14f);
        v12.curveToRelative(-0.41f, 0f, -0.74f, -0.33f, -0.74f, -0.74f);
        v12.curveToRelative(0f, -0.41f, 0.33f, -0.73f, 0.74f, -0.73f);
        v12.curveToRelative(0.41f, 0f, 0.73f, 0.32f, 0.73f, 0.73f);
        v12.curveTo(13.23f, 13.67f, 12.92f, 14f, 12.5f, 14f);
        v12.close();
        v12.moveTo(14.26f, 9.68f);
        v12.curveToRelative(-0.44f, 0.65f, -0.86f, 0.85f, -1.09f, 1.27f);
        v12.curveToRelative(-0.09f, 0.17f, -0.13f, 0.28f, -0.13f, 0.82f);
        v12.horizontalLineToRelative(-1.06f);
        v12.curveToRelative(0f, -0.29f, -0.04f, -0.75f, 0.18f, -1.16f);
        v12.curveToRelative(0.28f, -0.51f, 0.83f, -0.81f, 1.14f, -1.26f);
        v12.curveToRelative(0.33f, -0.47f, 0.15f, -1.36f, -0.8f, -1.36f);
        v12.curveToRelative(-0.62f, 0f, -0.92f, 0.47f, -1.05f, 0.86f);
        v12.lineToRelative(-0.96f, -0.4f);
        v12.curveTo(10.76f, 7.67f, 11.46f, 7f, 12.5f, 7f);
        v12.curveToRelative(0.86f, 0f, 1.45f, 0.39f, 1.75f, 0.88f);
        v12.curveTo(14.51f, 8.31f, 14.66f, 9.1f, 14.26f, 9.68f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PsychologyAltKt._psychologyAlt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

