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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_speakerNotesOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SpeakerNotesOff", "Landroidx/compose/material/icons/Icons$Outlined;", "getSpeakerNotesOff", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SpeakerNotesOffKt {
    private static ImageVector _speakerNotesOff;

    static {
    }

    public static final ImageVector getSpeakerNotesOff(Outlined arg19) {
        ImageVector v0 = SpeakerNotesOffKt._speakerNotesOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.SpeakerNotesOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 4f);
        v12.verticalLineToRelative(12f);
        v12.horizontalLineToRelative(-1.34f);
        v12.lineToRelative(1.91f, 1.91f);
        v12.curveTo(21.389999f, 17.66f, 22f, 16.9f, 22f, 16f);
        v12.lineTo(22f, 4f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.lineTo(4.66f, 2f);
        v12.lineToRelative(2f, 2f);
        v12.lineTo(20f, 4f);
        v12.close();
        v12.moveTo(6f, 12f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.lineTo(6f, 14f);
        v12.close();
        v12.moveTo(18f, 9f);
        v12.horizontalLineToRelative(-6.34f);
        v12.lineToRelative(2f, 2f);
        v12.lineTo(18f, 11f);
        v12.close();
        v12.moveTo(18f, 6f);
        v12.horizontalLineToRelative(-8f);
        v12.verticalLineToRelative(1.34f);
        v12.lineToRelative(0.66f, 0.66f);
        v12.lineTo(18f, 8f);
        v12.close();
        v12.moveTo(1.41f, 1.59f);
        v12.lineTo(0f, 3f);
        v12.lineToRelative(2.01f, 2.01f);
        v12.lineTo(2f, 22f);
        v12.lineToRelative(4f, -4f);
        v12.horizontalLineToRelative(9f);
        v12.lineToRelative(5.73f, 5.73f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(1.41f, 1.59f);
        v12.close();
        v12.moveTo(5.17f, 16f);
        v12.lineTo(4f, 17.17f);
        v12.lineTo(4f, 7f);
        v12.lineToRelative(2f, 2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.lineToRelative(5f, 5f);
        v12.lineTo(5.17f, 16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SpeakerNotesOffKt._speakerNotesOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

