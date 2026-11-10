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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_build", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Build", "Landroidx/compose/material/icons/Icons$Outlined;", "getBuild", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BuildKt {
    private static ImageVector _build;

    static {
    }

    public static final ImageVector getBuild(Outlined arg19) {
        ImageVector v0 = BuildKt._build;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Build", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22.610001f, 18.99f);
        v12.lineToRelative(-9.08f, -9.08f);
        v12.curveToRelative(0.93f, -2.34f, 0.45f, -5.1f, -1.44f, -7f);
        v12.curveTo(9.79f, 0.61f, 6.21f, 0.4f, 3.66f, 2.26f);
        v12.lineTo(7.5f, 6.11f);
        v12.lineTo(6.08f, 7.52f);
        v12.lineTo(2.25f, 3.69f);
        v12.curveTo(0.39f, 6.23f, 0.6f, 9.82f, 2.9f, 12.11f);
        v12.curveToRelative(1.86f, 1.86f, 4.57f, 2.35f, 6.89f, 1.48f);
        v12.lineToRelative(9.11f, 9.11f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(2.3f, -2.3f);
        v12.curveToRelative(0.4f, -0.38f, 0.4f, -1.01f, 0f, -1.41f);
        v12.close();
        v12.moveTo(19.610001f, 20.59f);
        v12.lineToRelative(-9.46f, -9.46f);
        v12.curveToRelative(-0.61f, 0.45f, -1.29f, 0.72f, -2f, 0.82f);
        v12.curveToRelative(-1.36f, 0.2f, -2.79f, -0.21f, -3.83f, -1.25f);
        v12.curveTo(3.37f, 9.76f, 2.93f, 8.5f, 3f, 7.26f);
        v12.lineToRelative(3.09f, 3.09f);
        v12.lineToRelative(4.24f, -4.24f);
        v12.lineToRelative(-3.09f, -3.09f);
        v12.curveToRelative(1.24f, -0.07f, 2.49f, 0.37f, 3.44f, 1.31f);
        v12.curveToRelative(1.08f, 1.08f, 1.49f, 2.57f, 1.24f, 3.96f);
        v12.curveToRelative(-0.12f, 0.71f, -0.42f, 1.37f, -0.88f, 1.96f);
        v12.lineToRelative(9.45f, 9.45f);
        v12.lineToRelative(-0.88f, 0.89f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BuildKt._build = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

