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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_restore", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Restore", "Landroidx/compose/material/icons/Icons$Rounded;", "getRestore", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RestoreKt {
    private static ImageVector _restore;

    static {
    }

    public static final ImageVector getRestore(Rounded arg19) {
        ImageVector v0 = RestoreKt._restore;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Restore", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13.25f, 3f);
        v12.curveToRelative(-5.09f, -0.14f, -9.26f, 3.94f, -9.26f, 9f);
        v12.lineTo(2.2f, 12f);
        v12.curveToRelative(-0.45f, 0f, -0.67f, 0.54f, -0.35f, 0.85f);
        v12.lineToRelative(2.79f, 2.8f);
        v12.curveToRelative(0.2f, 0.2f, 0.51f, 0.2f, 0.71f, 0f);
        v12.lineToRelative(2.79f, -2.8f);
        v12.curveToRelative(0.32f, -0.31f, 0.09f, -0.85f, -0.35f, -0.85f);
        v12.horizontalLineToRelative(-1.8f);
        v12.curveToRelative(0f, -3.9f, 3.18f, -7.05f, 7.1f, -7f);
        v12.curveToRelative(3.72f, 0.05f, 6.85f, 3.18f, 6.9f, 6.9f);
        v12.curveToRelative(0.05f, 3.91f, -3.1f, 7.1f, -7f, 7.1f);
        v12.curveToRelative(-1.61f, 0f, -3.1f, -0.55f, -4.28f, -1.48f);
        v12.curveToRelative(-0.4f, -0.31f, -0.96f, -0.28f, -1.32f, 0.08f);
        v12.curveToRelative(-0.42f, 0.43f, -0.39f, 1.13f, 0.08f, 1.5f);
        v12.curveToRelative(1.52f, 1.19f, 3.44f, 1.9f, 5.52f, 1.9f);
        v12.curveToRelative(5.05f, 0f, 9.14f, -4.17f, 9f, -9.26f);
        v12.curveToRelative(-0.13f, -4.69f, -4.05f, -8.61f, -8.74f, -8.74f);
        v12.close();
        v12.moveTo(12.74f, 8f);
        v12.curveToRelative(-0.41f, 0f, -0.75f, 0.34f, -0.75f, 0.75f);
        v12.verticalLineToRelative(3.68f);
        v12.curveToRelative(0f, 0.35f, 0.19f, 0.68f, 0.49f, 0.86f);
        v12.lineToRelative(3.12f, 1.85f);
        v12.curveToRelative(0.36f, 0.21f, 0.82f, 0.09f, 1.03f, -0.26f);
        v12.curveToRelative(0.21f, -0.36f, 0.09f, -0.82f, -0.26f, -1.03f);
        v12.lineToRelative(-2.88f, -1.71f);
        v12.verticalLineToRelative(-3.4f);
        v12.curveToRelative(0f, -0.4f, -0.33f, -0.74f, -0.75f, -0.74f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RestoreKt._restore = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

