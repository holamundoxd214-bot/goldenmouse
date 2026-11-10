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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_recordVoiceOver", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RecordVoiceOver", "Landroidx/compose/material/icons/Icons$TwoTone;", "getRecordVoiceOver", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RecordVoiceOverKt {
    private static ImageVector _recordVoiceOver;

    static {
    }

    public static final ImageVector getRecordVoiceOver(TwoTone arg20) {
        ImageVector v0 = RecordVoiceOverKt._recordVoiceOver;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.RecordVoiceOver", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9f, 9f);
        v12.moveToRelative(-2f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, 4f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, -4f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(9f, 17f);
        v12.curveToRelative(-2.69f, 0f, -5.77f, 1.28f, -6f, 2f);
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(-0.2f, -0.71f, -3.3f, -2f, -6f, -2f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(9f, 13f);
        v12.curveToRelative(2.21f, 0f, 4f, -1.79f, 4f, -4f);
        v12.reflectiveCurveToRelative(-1.79f, -4f, -4f, -4f);
        v12.reflectiveCurveToRelative(-4f, 1.79f, -4f, 4f);
        v12.reflectiveCurveToRelative(1.79f, 4f, 4f, 4f);
        v12.close();
        v12.moveTo(9f, 7f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.reflectiveCurveToRelative(-0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f);
        v12.reflectiveCurveToRelative(0.9f, -2f, 2f, -2f);
        v12.close();
        v12.moveTo(9f, 15f);
        v12.curveToRelative(-2.67f, 0f, -8f, 1.34f, -8f, 4f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(0f, -2.66f, -5.33f, -4f, -8f, -4f);
        v12.close();
        v12.moveTo(3f, 19f);
        v12.curveToRelative(0.22f, -0.72f, 3.31f, -2f, 6f, -2f);
        v12.curveToRelative(2.7f, 0f, 5.8f, 1.29f, 6f, 2f);
        v12.lineTo(3f, 19f);
        v12.close();
        v12.moveTo(16.76f, 5.36f);
        v12.lineToRelative(-1.68f, 1.69f);
        v12.curveToRelative(0.84f, 1.18f, 0.84f, 2.71f, 0f, 3.89f);
        v12.lineToRelative(1.68f, 1.69f);
        v12.curveToRelative(2.02f, -2.02f, 2.02f, -5.07f, 0f, -7.27f);
        v12.close();
        v12.moveTo(20.07f, 2f);
        v12.lineToRelative(-1.63f, 1.63f);
        v12.curveToRelative(2.77f, 3.02f, 2.77f, 7.56f, 0f, 10.74f);
        v12.lineTo(20.07f, 16f);
        v12.curveToRelative(3.9f, -3.89f, 3.91f, -9.95f, 0f, -14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RecordVoiceOverKt._recordVoiceOver = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

