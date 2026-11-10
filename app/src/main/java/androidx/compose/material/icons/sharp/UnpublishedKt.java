package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_unpublished", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Unpublished", "Landroidx/compose/material/icons/Icons$Sharp;", "getUnpublished", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class UnpublishedKt {
    private static ImageVector _unpublished;

    static {
    }

    public static final ImageVector getUnpublished(Sharp arg19) {
        ImageVector v0 = UnpublishedKt._unpublished;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Unpublished", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.190001f, 21.190001f);
        v12.lineTo(2.81f, 2.81f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineToRelative(2.27f, 2.27f);
        v12.curveTo(2.61f, 8.07f, 2f, 9.96f, 2f, 12f);
        v12.curveToRelative(0f, 5.52f, 4.48f, 10f, 10f, 10f);
        v12.curveToRelative(2.04f, 0f, 3.93f, -0.61f, 5.51f, -1.66f);
        v12.lineToRelative(2.27f, 2.27f);
        v12.lineTo(21.190001f, 21.190001f);
        v12.close();
        v12.moveTo(10.59f, 16.6f);
        v12.lineToRelative(-4.24f, -4.24f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(2.83f, 2.83f);
        v12.lineToRelative(0.18f, -0.18f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineTo(10.59f, 16.6f);
        v12.close();
        v12.moveTo(13.59f, 10.76f);
        v12.lineToRelative(-7.1f, -7.1f);
        v12.curveTo(8.07f, 2.61f, 9.96f, 2f, 12f, 2f);
        v12.curveToRelative(5.52f, 0f, 10f, 4.48f, 10f, 10f);
        v12.curveToRelative(0f, 2.04f, -0.61f, 3.93f, -1.66f, 5.51f);
        v12.lineToRelative(-5.34f, -5.34f);
        v12.lineToRelative(2.65f, -2.65f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.lineTo(13.59f, 10.76f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        UnpublishedKt._unpublished = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

