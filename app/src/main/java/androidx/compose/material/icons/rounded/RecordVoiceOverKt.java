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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_recordVoiceOver", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RecordVoiceOver", "Landroidx/compose/material/icons/Icons$Rounded;", "getRecordVoiceOver", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RecordVoiceOverKt {
    private static ImageVector _recordVoiceOver;

    static {
    }

    public static final ImageVector getRecordVoiceOver(Rounded arg20) {
        ImageVector v0 = RecordVoiceOverKt._recordVoiceOver;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.RecordVoiceOver", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9f, 9f);
        v12.moveToRelative(-4f, 0f);
        v12.arcToRelative(4f, 4f, 0f, true, true, 8f, 0f);
        v12.arcToRelative(4f, 4f, 0f, true, true, -8f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(9f, 15f);
        v12.curveToRelative(-2.67f, 0f, -8f, 1.34f, -8f, 4f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(0f, -2.66f, -5.33f, -4f, -8f, -4f);
        v12.close();
        v12.moveTo(15.47f, 7.77f);
        v12.curveToRelative(0.32f, 0.79f, 0.32f, 1.67f, 0f, 2.46f);
        v12.curveToRelative(-0.19f, 0.47f, -0.11f, 1f, 0.25f, 1.36f);
        v12.lineToRelative(0.03f, 0.03f);
        v12.curveToRelative(0.58f, 0.58f, 1.57f, 0.46f, 1.95f, -0.27f);
        v12.curveToRelative(0.76f, -1.45f, 0.76f, -3.15f, -0.02f, -4.66f);
        v12.curveToRelative(-0.38f, -0.74f, -1.38f, -0.88f, -1.97f, -0.29f);
        v12.lineToRelative(-0.01f, 0.01f);
        v12.curveToRelative(-0.34f, 0.35f, -0.42f, 0.89f, -0.23f, 1.36f);
        v12.close();
        v12.moveTo(19.18f, 2.89f);
        v12.curveToRelative(-0.4f, 0.4f, -0.46f, 1.02f, -0.13f, 1.48f);
        v12.curveToRelative(1.97f, 2.74f, 1.96f, 6.41f, -0.03f, 9.25f);
        v12.curveToRelative(-0.32f, 0.45f, -0.25f, 1.07f, 0.14f, 1.46f);
        v12.lineToRelative(0.03f, 0.03f);
        v12.curveToRelative(0.49f, 0.49f, 1.32f, 0.45f, 1.74f, -0.1f);
        v12.curveToRelative(2.75f, -3.54f, 2.76f, -8.37f, 0f, -12.02f);
        v12.curveToRelative(-0.42f, -0.55f, -1.26f, -0.59f, -1.75f, -0.1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RecordVoiceOverKt._recordVoiceOver = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

