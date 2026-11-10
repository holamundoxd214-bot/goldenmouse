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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noLuggage", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoLuggage", "Landroidx/compose/material/icons/Icons$Outlined;", "getNoLuggage", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoLuggageKt {
    private static ImageVector _noLuggage;

    static {
    }

    public static final ImageVector getNoLuggage(Outlined arg19) {
        ImageVector v0 = NoLuggageKt._noLuggage;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.NoLuggage", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 13.17f);
        v12.lineToRelative(-1.5f, -1.5f);
        v12.verticalLineTo(9f);
        v12.horizontalLineTo(16f);
        v12.verticalLineTo(13.17f);
        v12.close();
        v12.moveTo(19.780001f, 22.610001f);
        v12.lineToRelative(-1.85f, -1.85f);
        v12.curveTo(17.65f, 20.91f, 17.34f, 21f, 17f, 21f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.horizontalLineTo(9f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.verticalLineTo(8f);
        v12.curveToRelative(0f, -0.05f, 0.02f, -0.1f, 0.02f, -0.15f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(18.379999f, 18.379999f);
        v12.lineTo(19.780001f, 22.610001f);
        v12.close();
        v12.moveTo(16.17f, 19f);
        v12.lineToRelative(-3.42f, -3.42f);
        v12.verticalLineTo(18f);
        v12.horizontalLineToRelative(-1.5f);
        v12.verticalLineToRelative(-3.92f);
        v12.lineTo(9.5f, 12.33f);
        v12.verticalLineTo(18f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(-7.17f);
        v12.lineToRelative(-1f, -1f);
        v12.verticalLineTo(19f);
        v12.horizontalLineTo(16.17f);
        v12.close();
        v12.moveTo(12.75f, 9f);
        v12.horizontalLineToRelative(-0.92f);
        v12.lineToRelative(0.92f, 0.92f);
        v12.verticalLineTo(9f);
        v12.close();
        v12.moveTo(19f, 8f);
        v12.verticalLineToRelative(8.17f);
        v12.lineToRelative(-2f, -2f);
        v12.verticalLineTo(8f);
        v12.horizontalLineToRelative(-6.17f);
        v12.lineTo(9.84f, 7.01f);
        v12.lineTo(9f, 6.17f);
        v12.verticalLineTo(6f);
        v12.verticalLineTo(3f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(2f);
        v12.curveTo(18.1f, 6f, 19f, 6.9f, 19f, 8f);
        v12.close();
        v12.moveTo(10.5f, 6f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineTo(3.5f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineTo(6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoLuggageKt._noLuggage = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

