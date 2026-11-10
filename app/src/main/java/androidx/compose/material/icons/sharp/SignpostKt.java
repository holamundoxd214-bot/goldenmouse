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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_signpost", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Signpost", "Landroidx/compose/material/icons/Icons$Sharp;", "getSignpost", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SignpostKt {
    private static ImageVector _signpost;

    static {
    }

    public static final ImageVector getSignpost(Sharp arg19) {
        ImageVector v0 = SignpostKt._signpost;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Signpost", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineTo(5.5f);
        v12.curveTo(4.67f, 4f, 4f, 4.67f, 4f, 5.5f);
        v12.verticalLineToRelative(3f);
        v12.curveTo(4f, 9.33f, 4.67f, 10f, 5.5f, 10f);
        v12.horizontalLineTo(11f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(6.62f);
        v12.curveToRelative(-0.4f, 0f, -0.78f, 0.16f, -1.06f, 0.44f);
        v12.lineToRelative(-1.5f, 1.5f);
        v12.curveToRelative(-0.59f, 0.59f, -0.59f, 1.54f, 0f, 2.12f);
        v12.lineToRelative(1.5f, 1.5f);
        v12.curveTo(5.84f, 17.84f, 6.22f, 18f, 6.62f, 18f);
        v12.horizontalLineTo(11f);
        v12.verticalLineToRelative(3f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(5.5f);
        v12.curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        v12.horizontalLineTo(13f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(4.38f);
        v12.curveToRelative(0.4f, 0f, 0.78f, -0.16f, 1.06f, -0.44f);
        v12.lineToRelative(1.5f, -1.5f);
        v12.curveToRelative(0.59f, -0.59f, 0.59f, -1.54f, 0f, -2.12f);
        v12.lineToRelative(-1.5f, -1.5f);
        v12.curveTo(18.16f, 4.16f, 17.780001f, 4f, 17.379999f, 4f);
        v12.horizontalLineTo(13f);
        v12.verticalLineTo(3f);
        v12.curveTo(13f, 2.45f, 12.55f, 2f, 12f, 2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SignpostKt._signpost = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

