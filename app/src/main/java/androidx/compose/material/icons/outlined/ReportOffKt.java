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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_reportOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ReportOff", "Landroidx/compose/material/icons/Icons$Outlined;", "getReportOff", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ReportOffKt {
    private static ImageVector _reportOff;

    static {
    }

    public static final ImageVector getReportOff(Outlined arg20) {
        ImageVector v0 = ReportOffKt._reportOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.ReportOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(9.1f, 5f);
        v0_1.horizontalLineToRelative(5.8f);
        v0_1.lineTo(19f, 9.1f);
        v0_1.verticalLineToRelative(5.8f);
        v0_1.lineToRelative(-0.22f, 0.22f);
        v0_1.lineToRelative(1.42f, 1.41f);
        v0_1.lineToRelative(0.8f, -0.8f);
        v0_1.verticalLineTo(8.27f);
        v0_1.lineTo(15.73f, 3f);
        v0_1.horizontalLineTo(8.27f);
        v0_1.lineToRelative(-0.8f, 0.8f);
        v0_1.lineToRelative(1.41f, 1.42f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 16f);
        v12.moveToRelative(-1f, 0f);
        v12.arcToRelative(1f, 1f, 0f, true, true, 2f, 0f);
        v12.arcToRelative(1f, 1f, 0f, true, true, -2f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(13f, 9.33f);
        v0_1.verticalLineTo(7f);
        v0_1.horizontalLineToRelative(-2f);
        v0_1.verticalLineToRelative(0.33f);
        v0_1.close();
        v0_1.moveTo(2.41f, 1.58f);
        v0_1.lineTo(1f, 2.99f);
        v0_1.lineToRelative(3.64f, 3.64f);
        v0_1.lineTo(3f, 8.27f);
        v0_1.verticalLineToRelative(7.46f);
        v0_1.lineTo(8.27f, 21f);
        v0_1.horizontalLineToRelative(7.46f);
        v0_1.lineToRelative(1.64f, -1.64f);
        v0_1.lineTo(21.01f, 23f);
        v0_1.lineToRelative(1.41f, -1.41f);
        v0_1.lineTo(2.41f, 1.58f);
        v0_1.close();
        v0_1.moveTo(14.9f, 19f);
        v0_1.horizontalLineTo(9.1f);
        v0_1.lineTo(5f, 14.9f);
        v0_1.verticalLineTo(9.1f);
        v0_1.lineToRelative(1.05f, -1.05f);
        v0_1.lineToRelative(9.9f, 9.9f);
        v0_1.lineTo(14.9f, 19f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ReportOffKt._reportOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

