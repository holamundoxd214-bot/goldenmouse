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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_api", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Api", "Landroidx/compose/material/icons/Icons$Rounded;", "getApi", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ApiKt {
    private static ImageVector _api;

    static {
    }

    public static final ImageVector getApi(Rounded arg19) {
        ImageVector v0 = ApiKt._api;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Api", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13f, 13f);
        v12.lineTo(13f, 13f);
        v12.curveToRelative(-0.56f, 0.56f, -1.45f, 0.56f, -2f, 0.01f);
        v12.lineTo(11f, 13f);
        v12.curveToRelative(-0.55f, -0.55f, -0.55f, -1.44f, 0f, -1.99f);
        v12.lineTo(11f, 11f);
        v12.curveToRelative(0.55f, -0.55f, 1.44f, -0.55f, 1.99f, 0f);
        v12.lineTo(13f, 11f);
        v12.curveTo(13.55f, 11.55f, 13.55f, 12.45f, 13f, 13f);
        v12.close();
        v12.moveTo(12f, 6f);
        v12.lineToRelative(2.12f, 2.12f);
        v12.lineToRelative(2.5f, -2.5f);
        v12.lineToRelative(-3.2f, -3.2f);
        v12.curveToRelative(-0.78f, -0.78f, -2.05f, -0.78f, -2.83f, 0f);
        v12.lineToRelative(-3.2f, 3.2f);
        v12.lineToRelative(2.5f, 2.5f);
        v12.lineTo(12f, 6f);
        v12.close();
        v12.moveTo(6f, 12f);
        v12.lineToRelative(2.12f, -2.12f);
        v12.lineToRelative(-2.5f, -2.5f);
        v12.lineToRelative(-3.2f, 3.2f);
        v12.curveToRelative(-0.78f, 0.78f, -0.78f, 2.05f, 0f, 2.83f);
        v12.lineToRelative(3.2f, 3.2f);
        v12.lineToRelative(2.5f, -2.5f);
        v12.lineTo(6f, 12f);
        v12.close();
        v12.moveTo(18f, 12f);
        v12.lineToRelative(-2.12f, 2.12f);
        v12.lineToRelative(2.5f, 2.5f);
        v12.lineToRelative(3.2f, -3.2f);
        v12.curveToRelative(0.78f, -0.78f, 0.78f, -2.05f, 0f, -2.83f);
        v12.lineToRelative(-3.2f, -3.2f);
        v12.lineToRelative(-2.5f, 2.5f);
        v12.lineTo(18f, 12f);
        v12.close();
        v12.moveTo(12f, 18f);
        v12.lineToRelative(-2.12f, -2.12f);
        v12.lineToRelative(-2.5f, 2.5f);
        v12.lineToRelative(3.2f, 3.2f);
        v12.curveToRelative(0.78f, 0.78f, 2.05f, 0.78f, 2.83f, 0f);
        v12.lineToRelative(3.2f, -3.2f);
        v12.lineToRelative(-2.5f, -2.5f);
        v12.lineTo(12f, 18f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ApiKt._api = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

