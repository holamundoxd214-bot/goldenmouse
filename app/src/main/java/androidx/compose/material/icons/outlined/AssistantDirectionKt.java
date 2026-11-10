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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_assistantDirection", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AssistantDirection", "Landroidx/compose/material/icons/Icons$Outlined;", "getAssistantDirection$annotations", "(Landroidx/compose/material/icons/Icons$Outlined;)V", "getAssistantDirection", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AssistantDirectionKt {
    private static ImageVector _assistantDirection;

    static {
    }

    public static final ImageVector getAssistantDirection(Outlined arg19) {
        ImageVector v0 = AssistantDirectionKt._assistantDirection;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.AssistantDirection", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 1f);
        v12.curveTo(5.9f, 1f, 1f, 5.9f, 1f, 12f);
        v12.reflectiveCurveToRelative(4.9f, 11f, 11f, 11f);
        v12.reflectiveCurveToRelative(11f, -4.9f, 11f, -11f);
        v12.reflectiveCurveTo(18.1f, 1f, 12f, 1f);
        v12.close();
        v12.moveTo(12f, 21f);
        v12.curveToRelative(-4.99f, 0f, -9f, -4.01f, -9f, -9f);
        v12.reflectiveCurveToRelative(4.01f, -9f, 9f, -9f);
        v12.reflectiveCurveToRelative(9f, 4.01f, 9f, 9f);
        v12.reflectiveCurveTo(16.99f, 21f, 12f, 21f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(19.73f, 11.42f);
        v12.lineTo(12.54f, 4.2f);
        v12.curveToRelative(-0.36f, -0.27f, -0.8f, -0.27f, -1.15f, 0f);
        v12.lineTo(4.2f, 11.42f);
        v12.curveToRelative(-0.27f, 0.36f, -0.27f, 0.8f, 0f, 1.16f);
        v12.lineToRelative(7.19f, 7.22f);
        v12.curveToRelative(0.36f, 0.27f, 0.8f, 0.27f, 1.15f, 0f);
        v12.lineToRelative(7.19f, -7.22f);
        v12.curveTo(20.09f, 12.22f, 20.09f, 11.69f, 19.73f, 11.42f);
        v12.close();
        v12.moveTo(13.5f, 14.5f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.lineTo(13.17f, 12f);
        v12.horizontalLineTo(10f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(-4f);
        v12.curveToRelative(0f, -0.6f, 0.4f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(4.17f);
        v12.lineToRelative(-1.09f, -1.09f);
        v12.lineTo(13.5f, 7.5f);
        v12.lineTo(17f, 11f);
        v12.lineTo(13.5f, 14.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AssistantDirectionKt._assistantDirection = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Outlined.AssistantDirection", replaceWith="<_subannotation>") public static void getAssistantDirection$annotations(Outlined arg0) {
    }
}

