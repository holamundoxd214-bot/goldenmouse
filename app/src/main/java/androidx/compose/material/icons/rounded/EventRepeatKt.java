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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_eventRepeat", "Landroidx/compose/ui/graphics/vector/ImageVector;", "EventRepeat", "Landroidx/compose/material/icons/Icons$Rounded;", "getEventRepeat", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EventRepeatKt {
    private static ImageVector _eventRepeat;

    static {
    }

    public static final ImageVector getEventRepeat(Rounded arg19) {
        ImageVector v0 = EventRepeatKt._eventRepeat;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.EventRepeat", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 12f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineTo(3f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineTo(8f);
        v12.verticalLineTo(3f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveTo(6f, 2.45f, 6f, 3f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineTo(5f);
        v12.curveTo(3.9f, 4f, 3f, 4.9f, 3f, 6f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(7f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(5f);
        v12.verticalLineTo(10f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(21f);
        v12.close();
        v12.moveTo(15.13f, 20f);
        v12.curveToRelative(-0.55f, 0f, -0.91f, 0.56f, -0.68f, 1.06f);
        v12.curveTo(15.23f, 22.790001f, 16.969999f, 24f, 19f, 24f);
        v12.curveToRelative(2.76f, 0f, 5f, -2.24f, 5f, -5f);
        v12.reflectiveCurveToRelative(-2.24f, -5f, -5f, -5f);
        v12.curveToRelative(-1.36f, 0f, -2.6f, 0.55f, -3.5f, 1.43f);
        v12.lineToRelative(0f, -0.68f);
        v12.curveToRelative(0f, -0.41f, -0.34f, -0.75f, -0.75f, -0.75f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(14.34f, 14f, 14f, 14.34f, 14f, 14.75f);
        v12.verticalLineTo(17f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(2.25f);
        v12.curveToRelative(0.41f, 0f, 0.75f, -0.34f, 0.75f, -0.75f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.41f, -0.34f, -0.75f, -0.75f, -0.75f);
        v12.lineToRelative(-0.7f, 0f);
        v12.curveToRelative(0.63f, -0.62f, 1.5f, -1f, 2.45f, -1f);
        v12.curveToRelative(1.93f, 0f, 3.5f, 1.57f, 3.5f, 3.5f);
        v12.reflectiveCurveToRelative(-1.57f, 3.5f, -3.5f, 3.5f);
        v12.curveToRelative(-1.42f, 0f, -2.64f, -0.85f, -3.19f, -2.06f);
        v12.curveTo(15.69f, 20.17f, 15.42f, 20f, 15.13f, 20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EventRepeatKt._eventRepeat = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

