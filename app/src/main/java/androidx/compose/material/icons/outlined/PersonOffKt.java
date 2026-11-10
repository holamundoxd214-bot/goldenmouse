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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_personOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PersonOff", "Landroidx/compose/material/icons/Icons$Outlined;", "getPersonOff", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PersonOffKt {
    private static ImageVector _personOff;

    static {
    }

    public static final ImageVector getPersonOff(Outlined arg19) {
        ImageVector v0 = PersonOffKt._personOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.PersonOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 17.17f);
        v12.lineToRelative(-3.37f, -3.38f);
        v12.curveToRelative(0.64f, 0.22f, 1.23f, 0.48f, 1.77f, 0.76f);
        v12.curveTo(19.370001f, 15.06f, 19.98f, 16.07f, 20f, 17.17f);
        v12.close();
        v12.moveTo(21.190001f, 21.190001f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.lineTo(17.17f, 20f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(-2.78f);
        v12.curveToRelative(0f, -1.12f, 0.61f, -2.15f, 1.61f, -2.66f);
        v12.curveToRelative(1.29f, -0.66f, 2.87f, -1.22f, 4.67f, -1.45f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(21.190001f, 21.190001f);
        v12.close();
        v12.moveTo(15.17f, 18f);
        v12.lineToRelative(-3f, -3f);
        v12.curveToRelative(-0.06f, 0f, -0.11f, 0f, -0.17f, 0f);
        v12.curveToRelative(-2.37f, 0f, -4.29f, 0.73f, -5.48f, 1.34f);
        v12.curveTo(6.2f, 16.5f, 6f, 16.84f, 6f, 17.219999f);
        v12.verticalLineTo(18f);
        v12.horizontalLineTo(15.17f);
        v12.close();
        v12.moveTo(12f, 6f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.curveToRelative(0f, 0.86f, -0.54f, 1.59f, -1.3f, 1.87f);
        v12.lineToRelative(1.48f, 1.48f);
        v12.curveTo(15.28f, 10.64f, 16f, 9.4f, 16f, 8f);
        v12.curveToRelative(0f, -2.21f, -1.79f, -4f, -4f, -4f);
        v12.curveToRelative(-1.4f, 0f, -2.64f, 0.72f, -3.35f, 1.82f);
        v12.lineToRelative(1.48f, 1.48f);
        v12.curveTo(10.41f, 6.54f, 11.14f, 6f, 12f, 6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PersonOffKt._personOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

