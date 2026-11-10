package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_texture", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Texture", "Landroidx/compose/material/icons/Icons$TwoTone;", "getTexture", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TextureKt {
    private static ImageVector _texture;

    static {
    }

    public static final ImageVector getTexture(TwoTone arg19) {
        ImageVector v0 = TextureKt._texture;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Texture", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.88f, 3f);
        v12.lineTo(3f, 11.88f);
        v12.verticalLineToRelative(2.83f);
        v12.lineTo(14.71f, 3f);
        v12.close();
        v12.moveTo(3f, 5f);
        v12.verticalLineToRelative(2f);
        v12.lineToRelative(4f, -4f);
        v12.lineTo(5f, 3f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.close();
        v12.moveTo(19.51f, 3.08f);
        v12.lineTo(3.08f, 19.51f);
        v12.curveToRelative(0.09f, 0.34f, 0.27f, 0.65f, 0.51f, 0.9f);
        v12.curveToRelative(0.25f, 0.24f, 0.56f, 0.42f, 0.9f, 0.51f);
        v12.lineTo(20.93f, 4.49f);
        v12.curveToRelative(-0.19f, -0.69f, -0.73f, -1.23f, -1.42f, -1.41f);
        v12.close();
        v12.moveTo(21f, 9.29f);
        v12.lineTo(9.29f, 21f);
        v12.horizontalLineToRelative(2.83f);
        v12.lineTo(21f, 12.12f);
        v12.close();
        v12.moveTo(20.41f, 20.41f);
        v12.curveToRelative(0.37f, -0.36f, 0.59f, -0.86f, 0.59f, -1.41f);
        v12.verticalLineToRelative(-2f);
        v12.lineToRelative(-4f, 4f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.55f, 0f, 1.05f, -0.22f, 1.41f, -0.59f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TextureKt._texture = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

