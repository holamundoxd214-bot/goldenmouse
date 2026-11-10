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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_personOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PersonOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getPersonOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PersonOffKt {
    private static ImageVector _personOff;

    static {
    }

    public static final ImageVector getPersonOff(Rounded arg19) {
        ImageVector v0 = PersonOffKt._personOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.PersonOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8.65f, 5.82f);
        v12.curveTo(9.36f, 4.72f, 10.6f, 4f, 12f, 4f);
        v12.curveToRelative(2.21f, 0f, 4f, 1.79f, 4f, 4f);
        v12.curveToRelative(0f, 1.4f, -0.72f, 2.64f, -1.82f, 3.35f);
        v12.lineTo(8.65f, 5.82f);
        v12.close();
        v12.moveTo(20f, 17.17f);
        v12.curveToRelative(-0.02f, -1.1f, -0.63f, -2.11f, -1.61f, -2.62f);
        v12.curveToRelative(-0.54f, -0.28f, -1.13f, -0.54f, -1.77f, -0.76f);
        v12.lineTo(20f, 17.17f);
        v12.close();
        v12.moveTo(20.49f, 20.49f);
        v12.lineTo(3.51f, 3.51f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(8.18f, 8.18f);
        v12.curveToRelative(-1.82f, 0.23f, -3.41f, 0.8f, -4.7f, 1.46f);
        v12.curveTo(4.6f, 15.08f, 4f, 16.110001f, 4f, 17.219999f);
        v12.lineTo(4f, 20f);
        v12.horizontalLineToRelative(13.17f);
        v12.lineToRelative(1.9f, 1.9f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(20.879999f, 21.51f, 20.879999f, 20.879999f, 20.49f, 20.49f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PersonOffKt._personOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

