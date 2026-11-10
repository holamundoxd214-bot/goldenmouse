package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_speakerPhone", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SpeakerPhone", "Landroidx/compose/material/icons/Icons$Filled;", "getSpeakerPhone", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SpeakerPhoneKt {
    private static ImageVector _speakerPhone;

    static {
    }

    public static final ImageVector getSpeakerPhone(Filled arg19) {
        ImageVector v0 = SpeakerPhoneKt._speakerPhone;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.SpeakerPhone", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7f, 7.07f);
        v12.lineTo(8.43f, 8.5f);
        v12.curveToRelative(0.91f, -0.91f, 2.18f, -1.48f, 3.57f, -1.48f);
        v12.reflectiveCurveToRelative(2.66f, 0.57f, 3.57f, 1.48f);
        v12.lineTo(17f, 7.07f);
        v12.curveTo(15.72f, 5.79f, 13.95f, 5f, 12f, 5f);
        v12.reflectiveCurveToRelative(-3.72f, 0.79f, -5f, 2.07f);
        v12.close();
        v12.moveTo(12f, 1f);
        v12.curveTo(8.98f, 1f, 6.24f, 2.23f, 4.25f, 4.21f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.curveTo(7.28f, 4f, 9.53f, 3f, 12f, 3f);
        v12.reflectiveCurveToRelative(4.72f, 1f, 6.34f, 2.62f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.curveTo(17.76f, 2.23f, 15.02f, 1f, 12f, 1f);
        v12.close();
        v12.moveTo(14.86f, 10.01f);
        v12.lineTo(9.14f, 10f);
        v12.curveTo(8.51f, 10f, 8f, 10.51f, 8f, 11.14f);
        v12.verticalLineToRelative(9.71f);
        v12.curveToRelative(0f, 0.63f, 0.51f, 1.14f, 1.14f, 1.14f);
        v12.horizontalLineToRelative(5.71f);
        v12.curveToRelative(0.63f, 0f, 1.14f, -0.51f, 1.14f, -1.14f);
        v12.verticalLineToRelative(-9.71f);
        v12.curveToRelative(0.01f, -0.63f, -0.5f, -1.13f, -1.13f, -1.13f);
        v12.close();
        v12.moveTo(15f, 20f);
        v12.lineTo(9f, 20f);
        v12.verticalLineToRelative(-8f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(8f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SpeakerPhoneKt._speakerPhone = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

