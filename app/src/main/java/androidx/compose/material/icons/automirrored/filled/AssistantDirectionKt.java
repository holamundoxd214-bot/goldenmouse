package androidx.compose.material.icons.automirrored.filled;

import androidx.compose.material.icons.Icons$AutoMirrored$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_assistantDirection", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AssistantDirection", "Landroidx/compose/material/icons/Icons$AutoMirrored$Filled;", "getAssistantDirection", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AssistantDirectionKt {
    private static ImageVector _assistantDirection;

    static {
    }

    public static final ImageVector getAssistantDirection(Filled arg19) {
        ImageVector v0 = AssistantDirectionKt._assistantDirection;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Filled.AssistantDirection", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14f, 10f);
        v12.lineTo(9f, 10f);
        v12.curveToRelative(-0.6f, 0f, -1f, 0.4f, -1f, 1f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(2.5f);
        v12.lineToRelative(3.5f, -3.5f);
        v12.lineTo(14f, 7.5f);
        v12.lineTo(14f, 10f);
        v12.close();
        v12.moveTo(12f, 1f);
        v12.curveTo(5.9f, 1f, 1f, 5.9f, 1f, 12f);
        v12.reflectiveCurveToRelative(4.9f, 11f, 11f, 11f);
        v12.reflectiveCurveToRelative(11f, -4.9f, 11f, -11f);
        v12.reflectiveCurveTo(18.1f, 1f, 12f, 1f);
        v12.close();
        v12.moveTo(19.73f, 12.58f);
        v12.lineToRelative(-7.19f, 7.22f);
        v12.curveToRelative(-0.35f, 0.27f, -0.79f, 0.27f, -1.15f, 0f);
        v12.lineTo(4.2f, 12.58f);
        v12.curveToRelative(-0.27f, -0.36f, -0.27f, -0.8f, 0f, -1.16f);
        v12.lineToRelative(7.19f, -7.22f);
        v12.curveToRelative(0.35f, -0.27f, 0.79f, -0.27f, 1.15f, 0f);
        v12.lineToRelative(7.19f, 7.22f);
        v12.curveToRelative(0.36f, 0.27f, 0.36f, 0.8f, 0f, 1.16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AssistantDirectionKt._assistantDirection = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

