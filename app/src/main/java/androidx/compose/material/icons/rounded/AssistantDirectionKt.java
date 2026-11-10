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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_assistantDirection", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AssistantDirection", "Landroidx/compose/material/icons/Icons$Rounded;", "getAssistantDirection$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getAssistantDirection", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AssistantDirectionKt {
    private static ImageVector _assistantDirection;

    static {
    }

    public static final ImageVector getAssistantDirection(Rounded arg19) {
        ImageVector v0 = AssistantDirectionKt._assistantDirection;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.AssistantDirection", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13.5f, 10f);
        v12.horizontalLineTo(9f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(3f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(3.5f);
        v12.verticalLineToRelative(1.29f);
        v12.curveToRelative(0f, 0.45f, 0.54f, 0.67f, 0.85f, 0.35f);
        v12.lineToRelative(2.29f, -2.29f);
        v12.curveToRelative(0.2f, -0.2f, 0.2f, -0.51f, 0f, -0.71f);
        v12.lineToRelative(-2.29f, -2.29f);
        v12.curveToRelative(-0.31f, -0.31f, -0.85f, -0.09f, -0.85f, 0.35f);
        v12.verticalLineTo(10f);
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
        v12.curveTo(20.09f, 11.69f, 20.09f, 12.22f, 19.73f, 12.58f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AssistantDirectionKt._assistantDirection = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Rounded.AssistantDirection", replaceWith="<_subannotation>") public static void getAssistantDirection$annotations(Rounded arg0) {
    }
}

