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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_voicemail", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Voicemail", "Landroidx/compose/material/icons/Icons$Rounded;", "getVoicemail", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VoicemailKt {
    private static ImageVector _voicemail;

    static {
    }

    public static final ImageVector getVoicemail(Rounded arg19) {
        ImageVector v0 = VoicemailKt._voicemail;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Voicemail", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.5f, 6f);
        v12.curveTo(15.46f, 6f, 13f, 8.46f, 13f, 11.5f);
        v12.curveToRelative(0f, 1.33f, 0.47f, 2.55f, 1.26f, 3.5f);
        v12.lineTo(9.74f, 15f);
        v12.curveToRelative(0.79f, -0.95f, 1.26f, -2.17f, 1.26f, -3.5f);
        v12.curveTo(11f, 8.46f, 8.54f, 6f, 5.5f, 6f);
        v12.reflectiveCurveTo(0f, 8.46f, 0f, 11.5f);
        v12.reflectiveCurveTo(2.46f, 17f, 5.5f, 17f);
        v12.horizontalLineToRelative(13f);
        v12.curveToRelative(3.04f, 0f, 5.5f, -2.46f, 5.5f, -5.5f);
        v12.reflectiveCurveTo(21.540001f, 6f, 18.5f, 6f);
        v12.close();
        v12.moveTo(5.5f, 15f);
        v12.curveTo(3.57f, 15f, 2f, 13.43f, 2f, 11.5f);
        v12.reflectiveCurveTo(3.57f, 8f, 5.5f, 8f);
        v12.reflectiveCurveTo(9f, 9.57f, 9f, 11.5f);
        v12.reflectiveCurveTo(7.43f, 15f, 5.5f, 15f);
        v12.close();
        v12.moveTo(18.5f, 15f);
        v12.curveToRelative(-1.93f, 0f, -3.5f, -1.57f, -3.5f, -3.5f);
        v12.reflectiveCurveTo(16.57f, 8f, 18.5f, 8f);
        v12.reflectiveCurveTo(22f, 9.57f, 22f, 11.5f);
        v12.reflectiveCurveTo(20.43f, 15f, 18.5f, 15f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VoicemailKt._voicemail = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

