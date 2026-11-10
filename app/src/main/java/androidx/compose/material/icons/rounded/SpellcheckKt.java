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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_spellcheck", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Spellcheck", "Landroidx/compose/material/icons/Icons$Rounded;", "getSpellcheck", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SpellcheckKt {
    private static ImageVector _spellcheck;

    static {
    }

    public static final ImageVector getSpellcheck(Rounded arg19) {
        ImageVector v0 = SpellcheckKt._spellcheck;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Spellcheck", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13.12f, 16f);
        v12.curveToRelative(0.69f, 0f, 1.15f, -0.69f, 0.9f, -1.32f);
        v12.lineTo(9.77f, 3.87f);
        v12.curveTo(9.56f, 3.34f, 9.06f, 3f, 8.5f, 3f);
        v12.reflectiveCurveToRelative(-1.06f, 0.34f, -1.27f, 0.87f);
        v12.lineTo(2.98f, 14.68f);
        v12.curveToRelative(-0.25f, 0.63f, 0.22f, 1.32f, 0.9f, 1.32f);
        v12.curveToRelative(0.4f, 0f, 0.76f, -0.25f, 0.91f, -0.63f);
        v12.lineTo(5.67f, 13f);
        v12.horizontalLineToRelative(5.64f);
        v12.lineToRelative(0.9f, 2.38f);
        v12.curveToRelative(0.15f, 0.37f, 0.51f, 0.62f, 0.91f, 0.62f);
        v12.close();
        v12.moveTo(6.43f, 11f);
        v12.lineTo(8.5f, 5.48f);
        v12.lineTo(10.57f, 11f);
        v12.lineTo(6.43f, 11f);
        v12.close();
        v12.moveTo(20.889999f, 12.29f);
        v12.lineToRelative(-7.39f, 7.39f);
        v12.lineToRelative(-2.97f, -2.97f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(3.68f, 3.68f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(8.08f, -8.09f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.curveToRelative(-0.38f, -0.39f, -1.02f, -0.39f, -1.4f, -0.01f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SpellcheckKt._spellcheck = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

