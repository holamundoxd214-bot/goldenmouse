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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_localOffer", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocalOffer", "Landroidx/compose/material/icons/Icons$Rounded;", "getLocalOffer", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LocalOfferKt {
    private static ImageVector _localOffer;

    static {
    }

    public static final ImageVector getLocalOffer(Rounded arg19) {
        ImageVector v0 = LocalOfferKt._localOffer;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.LocalOffer", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.41f, 11.58f);
        v12.lineToRelative(-9f, -9f);
        v12.curveTo(12.05f, 2.22f, 11.55f, 2f, 11f, 2f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(7f);
        v12.curveToRelative(0f, 0.55f, 0.22f, 1.05f, 0.59f, 1.42f);
        v12.lineToRelative(9f, 9f);
        v12.curveToRelative(0.36f, 0.36f, 0.86f, 0.58f, 1.41f, 0.58f);
        v12.reflectiveCurveToRelative(1.05f, -0.22f, 1.41f, -0.59f);
        v12.lineToRelative(7f, -7f);
        v12.curveToRelative(0.37f, -0.36f, 0.59f, -0.86f, 0.59f, -1.41f);
        v12.reflectiveCurveToRelative(-0.23f, -1.06f, -0.59f, -1.42f);
        v12.close();
        v12.moveTo(5.5f, 7f);
        v12.curveTo(4.67f, 7f, 4f, 6.33f, 4f, 5.5f);
        v12.reflectiveCurveTo(4.67f, 4f, 5.5f, 4f);
        v12.reflectiveCurveTo(7f, 4.67f, 7f, 5.5f);
        v12.reflectiveCurveTo(6.33f, 7f, 5.5f, 7f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LocalOfferKt._localOffer = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

