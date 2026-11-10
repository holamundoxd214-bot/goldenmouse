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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_realEstateAgent", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RealEstateAgent", "Landroidx/compose/material/icons/Icons$Outlined;", "getRealEstateAgent", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RealEstateAgentKt {
    private static ImageVector _realEstateAgent;

    static {
    }

    public static final ImageVector getRealEstateAgent(Outlined arg19) {
        ImageVector v0 = RealEstateAgentKt._realEstateAgent;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.RealEstateAgent", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 6.5f);
        v12.verticalLineTo(14f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(7.5f);
        v12.lineTo(14f, 4f);
        v12.lineTo(9f, 7.5f);
        v12.verticalLineTo(9f);
        v12.horizontalLineTo(7f);
        v12.verticalLineTo(6.5f);
        v12.lineToRelative(7f, -5f);
        v12.lineTo(21f, 6.5f);
        v12.close();
        v12.moveTo(15.5f, 7f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(7f);
        v12.close();
        v12.moveTo(13.5f, 7f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(7f);
        v12.close();
        v12.moveTo(15.5f, 9f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(9f);
        v12.close();
        v12.moveTo(13.5f, 9f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(9f);
        v12.close();
        v12.moveTo(19f, 16f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(0f, -1.2f, -0.75f, -2.28f, -1.87f, -2.7f);
        v12.lineTo(8.97f, 11f);
        v12.horizontalLineTo(1f);
        v12.verticalLineToRelative(11f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(-1.44f);
        v12.lineToRelative(7f, 1.94f);
        v12.lineToRelative(8f, -2.5f);
        v12.verticalLineToRelative(-1f);
        v12.curveTo(22f, 17.34f, 20.66f, 16f, 19f, 16f);
        v12.close();
        v12.moveTo(3f, 20f);
        v12.verticalLineToRelative(-7f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(7f);
        v12.horizontalLineTo(3f);
        v12.close();
        v12.moveTo(13.97f, 20.41f);
        v12.lineTo(7f, 18.48f);
        v12.verticalLineTo(13f);
        v12.horizontalLineToRelative(1.61f);
        v12.lineToRelative(5.82f, 2.17f);
        v12.curveTo(14.77f, 15.3f, 15f, 15.63f, 15f, 16f);
        v12.curveToRelative(0f, 0f, -1.99f, -0.05f, -2.3f, -0.15f);
        v12.lineToRelative(-2.38f, -0.79f);
        v12.lineToRelative(-0.63f, 1.9f);
        v12.lineToRelative(2.38f, 0.79f);
        v12.curveToRelative(0.51f, 0.17f, 1.04f, 0.26f, 1.58f, 0.26f);
        v12.horizontalLineTo(19f);
        v12.curveToRelative(0.39f, 0f, 0.74f, 0.23f, 0.9f, 0.56f);
        v12.lineTo(13.97f, 20.41f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RealEstateAgentKt._realEstateAgent = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

