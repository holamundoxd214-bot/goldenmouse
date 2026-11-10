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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_unpublished", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Unpublished", "Landroidx/compose/material/icons/Icons$Rounded;", "getUnpublished", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class UnpublishedKt {
    private static ImageVector _unpublished;

    static {
    }

    public static final ImageVector getUnpublished(Rounded arg19) {
        ImageVector v0 = UnpublishedKt._unpublished;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Unpublished", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.49f, 20.49f);
        v12.lineTo(3.51f, 3.51f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(1.56f, 1.56f);
        v12.curveToRelative(-1.25f, 1.88f, -1.88f, 4.21f, -1.59f, 6.7f);
        v12.curveToRelative(0.53f, 4.54f, 4.21f, 8.22f, 8.74f, 8.74f);
        v12.curveToRelative(2.49f, 0.29f, 4.81f, -0.34f, 6.7f, -1.59f);
        v12.lineToRelative(1.56f, 1.56f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(20.879999f, 21.51f, 20.879999f, 20.879999f, 20.49f, 20.49f);
        v12.close();
        v12.moveTo(9.88f, 15.89f);
        v12.lineToRelative(-2.83f, -2.83f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0f);
        v12.lineToRelative(2.12f, 2.12f);
        v12.lineToRelative(0.18f, -0.18f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(-0.88f, 0.88f);
        v12.curveTo(10.9f, 16.280001f, 10.27f, 16.280001f, 9.88f, 15.89f);
        v12.close();
        v12.moveTo(13.59f, 10.76f);
        v12.lineToRelative(-7.1f, -7.1f);
        v12.curveToRelative(1.88f, -1.25f, 4.21f, -1.88f, 6.7f, -1.59f);
        v12.curveToRelative(4.54f, 0.53f, 8.22f, 4.21f, 8.74f, 8.74f);
        v12.curveToRelative(0.29f, 2.49f, -0.34f, 4.82f, -1.59f, 6.7f);
        v12.lineToRelative(-5.34f, -5.34f);
        v12.lineToRelative(1.94f, -1.94f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineTo(13.59f, 10.76f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        UnpublishedKt._unpublished = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

