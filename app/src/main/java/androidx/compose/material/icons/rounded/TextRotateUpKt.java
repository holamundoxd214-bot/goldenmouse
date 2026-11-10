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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_textRotateUp", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TextRotateUp", "Landroidx/compose/material/icons/Icons$Rounded;", "getTextRotateUp", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TextRotateUpKt {
    private static ImageVector _textRotateUp;

    static {
    }

    public static final ImageVector getTextRotateUp(Rounded arg19) {
        ImageVector v0 = TextRotateUpKt._textRotateUp;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.TextRotateUp", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.35f, 4.35f);
        v12.curveToRelative(-0.2f, -0.2f, -0.51f, -0.2f, -0.71f, 0f);
        v12.lineToRelative(-1.79f, 1.79f);
        v12.curveToRelative(-0.31f, 0.32f, -0.09f, 0.86f, 0.36f, 0.86f);
        v12.horizontalLineTo(17f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(0.79f);
        v12.curveToRelative(0.45f, 0f, 0.67f, -0.54f, 0.35f, -0.85f);
        v12.lineToRelative(-1.79f, -1.8f);
        v12.close();
        v12.moveTo(11.8f, 15.5f);
        v12.verticalLineToRelative(-5f);
        v12.lineToRelative(1.6f, -0.66f);
        v12.curveToRelative(0.36f, -0.14f, 0.6f, -0.49f, 0.6f, -0.88f);
        v12.curveToRelative(0f, -0.69f, -0.71f, -1.15f, -1.34f, -0.88f);
        v12.lineToRelative(-8.97f, 3.88f);
        v12.curveToRelative(-0.42f, 0.17f, -0.69f, 0.58f, -0.69f, 1.04f);
        v12.curveToRelative(0f, 0.46f, 0.27f, 0.87f, 0.69f, 1.05f);
        v12.lineToRelative(8.97f, 3.88f);
        v12.curveToRelative(0.63f, 0.27f, 1.34f, -0.2f, 1.34f, -0.89f);
        v12.curveToRelative(0f, -0.39f, -0.24f, -0.74f, -0.6f, -0.89f);
        v12.lineToRelative(-1.6f, -0.65f);
        v12.close();
        v12.moveTo(4.98f, 13f);
        v12.lineTo(10f, 11.13f);
        v12.verticalLineToRelative(3.74f);
        v12.lineTo(4.98f, 13f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TextRotateUpKt._textRotateUp = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

