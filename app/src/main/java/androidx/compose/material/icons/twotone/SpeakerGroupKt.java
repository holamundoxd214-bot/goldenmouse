package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_speakerGroup", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SpeakerGroup", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSpeakerGroup", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SpeakerGroupKt {
    private static ImageVector _speakerGroup;

    static {
    }

    public static final ImageVector getSpeakerGroup(TwoTone arg19) {
        ImageVector v0 = SpeakerGroupKt._speakerGroup;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.SpeakerGroup", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10f, 16.99f);
        v12.lineToRelative(8f, 0.01f);
        v12.lineTo(18f, 3f);
        v12.horizontalLineToRelative(-8f);
        v12.verticalLineToRelative(13.99f);
        v12.close();
        v12.moveTo(14f, 4f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.89f, 2f, 2f);
        v12.reflectiveCurveToRelative(-0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.89f, -2f, -2f);
        v12.reflectiveCurveToRelative(0.9f, -2f, 2f, -2f);
        v12.close();
        v12.moveTo(14f, 9f);
        v12.curveToRelative(1.93f, 0f, 3.5f, 1.57f, 3.5f, 3.5f);
        v12.reflectiveCurveTo(15.93f, 16f, 14f, 16f);
        v12.reflectiveCurveToRelative(-3.5f, -1.57f, -3.5f, -3.5f);
        v12.reflectiveCurveTo(12.07f, 9f, 14f, 9f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(18.200001f, 1f);
        v12.lineTo(9.8f, 1f);
        v12.curveTo(8.81f, 1f, 8f, 1.81f, 8f, 2.8f);
        v12.verticalLineToRelative(14.4f);
        v12.curveToRelative(0f, 0.99f, 0.81f, 1.79f, 1.8f, 1.79f);
        v12.lineToRelative(8.4f, 0.01f);
        v12.curveToRelative(0.99f, 0f, 1.8f, -0.81f, 1.8f, -1.8f);
        v12.lineTo(20f, 2.8f);
        v12.curveToRelative(0f, -0.99f, -0.81f, -1.8f, -1.8f, -1.8f);
        v12.close();
        v12.moveTo(18f, 17f);
        v12.lineToRelative(-8f, -0.01f);
        v12.lineTo(10f, 3f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(14f);
        v12.close();
        v12.moveTo(14f, 8f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.89f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.89f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.close();
        v12.moveTo(14f, 16f);
        v12.curveToRelative(1.93f, 0f, 3.5f, -1.57f, 3.5f, -3.5f);
        v12.reflectiveCurveTo(15.93f, 9f, 14f, 9f);
        v12.reflectiveCurveToRelative(-3.5f, 1.57f, -3.5f, 3.5f);
        v12.reflectiveCurveTo(12.07f, 16f, 14f, 16f);
        v12.close();
        v12.moveTo(14f, 11f);
        v12.curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(14.83f, 14f, 14f, 14f);
        v12.reflectiveCurveToRelative(-1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveToRelative(0.67f, -1.5f, 1.5f, -1.5f);
        v12.close();
        v12.moveTo(6f, 5f);
        v12.lineTo(4f, 5f);
        v12.verticalLineToRelative(16f);
        v12.curveToRelative(0f, 1.1f, 0.89f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(-2f);
        v12.lineTo(6f, 21f);
        v12.lineTo(6f, 5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SpeakerGroupKt._speakerGroup = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

