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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_campaign", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Campaign", "Landroidx/compose/material/icons/Icons$Rounded;", "getCampaign", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CampaignKt {
    private static ImageVector _campaign;

    static {
    }

    public static final ImageVector getCampaign(Rounded arg19) {
        ImageVector v0 = CampaignKt._campaign;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Campaign", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 12f);
        v12.lineTo(18f, 12f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-2f);
        v12.curveTo(18.450001f, 11f, 18f, 11.45f, 18f, 12f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(16.59f, 16.82f);
        v12.curveToRelative(-0.33f, 0.44f, -0.24f, 1.05f, 0.2f, 1.37f);
        v12.curveToRelative(0.53f, 0.39f, 1.09f, 0.81f, 1.62f, 1.21f);
        v12.curveToRelative(0.44f, 0.33f, 1.06f, 0.24f, 1.38f, -0.2f);
        v12.curveToRelative(0f, -0.01f, 0.01f, -0.01f, 0.01f, -0.02f);
        v12.curveToRelative(0.33f, -0.44f, 0.24f, -1.06f, -0.2f, -1.38f);
        v12.curveToRelative(-0.53f, -0.4f, -1.09f, -0.82f, -1.61f, -1.21f);
        v12.curveToRelative(-0.44f, -0.33f, -1.06f, -0.23f, -1.39f, 0.21f);
        v12.curveTo(16.6f, 16.809999f, 16.59f, 16.82f, 16.59f, 16.82f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(19.809999f, 4.81f);
        v12.curveToRelative(0f, -0.01f, -0.01f, -0.01f, -0.01f, -0.02f);
        v12.curveToRelative(-0.33f, -0.44f, -0.95f, -0.53f, -1.38f, -0.2f);
        v12.curveToRelative(-0.53f, 0.4f, -1.1f, 0.82f, -1.62f, 1.22f);
        v12.curveToRelative(-0.44f, 0.33f, -0.52f, 0.95f, -0.19f, 1.38f);
        v12.curveToRelative(0f, 0.01f, 0.01f, 0.01f, 0.01f, 0.02f);
        v12.curveToRelative(0.33f, 0.44f, 0.94f, 0.53f, 1.38f, 0.2f);
        v12.curveToRelative(0.53f, -0.39f, 1.09f, -0.82f, 1.62f, -1.22f);
        v12.curveTo(20.049999f, 5.87f, 20.129999f, 5.25f, 19.809999f, 4.81f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(8f, 9f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(3f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(1f);
        v12.lineToRelative(5f, 3f);
        v12.verticalLineTo(6f);
        v12.lineTo(8f, 9f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(15.5f, 12f);
        v12.curveToRelative(0f, -1.33f, -0.58f, -2.53f, -1.5f, -3.35f);
        v12.verticalLineToRelative(6.69f);
        v12.curveTo(14.92f, 14.53f, 15.5f, 13.33f, 15.5f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CampaignKt._campaign = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

