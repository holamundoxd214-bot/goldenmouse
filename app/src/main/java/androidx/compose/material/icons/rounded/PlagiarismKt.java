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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_plagiarism", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Plagiarism", "Landroidx/compose/material/icons/Icons$Rounded;", "getPlagiarism", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PlagiarismKt {
    private static ImageVector _plagiarism;

    static {
    }

    public static final ImageVector getPlagiarism(Rounded arg20) {
        ImageVector v0 = PlagiarismKt._plagiarism;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Plagiarism", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.41f, 7.41f);
        v12.lineToRelative(-4.83f, -4.83f);
        v12.curveTo(14.21f, 2.21f, 13.7f, 2f, 13.17f, 2f);
        v12.horizontalLineTo(6f);
        v12.curveTo(4.9f, 2f, 4f, 2.9f, 4f, 4f);
        v12.verticalLineToRelative(16f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(8.83f);
        v12.curveTo(20f, 8.3f, 19.790001f, 7.79f, 19.41f, 7.41f);
        v12.close();
        v12.moveTo(15.74f, 18.74f);
        v12.lineTo(15.74f, 18.74f);
        v12.curveToRelative(-0.39f, 0.39f, -1.02f, 0.39f, -1.41f, 0f);
        v12.lineToRelative(-1.18f, -1.18f);
        v12.curveToRelative(-1.33f, 0.71f, -3.01f, 0.53f, -4.13f, -0.59f);
        v12.curveToRelative(-1.52f, -1.52f, -1.35f, -4.08f, 0.5f, -5.37f);
        v12.curveToRelative(1.16f, -0.81f, 2.78f, -0.81f, 3.95f, 0f);
        v12.curveToRelative(1.55f, 1.08f, 1.9f, 3.04f, 1.09f, 4.55f);
        v12.lineToRelative(1.18f, 1.18f);
        v12.curveTo(16.129999f, 17.719999f, 16.129999f, 18.35f, 15.74f, 18.74f);
        v12.close();
        v12.moveTo(14f, 9f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineTo(3.5f);
        v12.lineTo(18.5f, 9f);
        v12.horizontalLineTo(14f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(11.5f, 14.5f);
        v12.moveToRelative(-1.5f, 0f);
        v12.arcToRelative(1.5f, 1.5f, 0f, true, true, 3f, 0f);
        v12.arcToRelative(1.5f, 1.5f, 0f, true, true, -3f, 0f);
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PlagiarismKt._plagiarism = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

