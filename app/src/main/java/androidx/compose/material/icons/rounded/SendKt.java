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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_send", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Send", "Landroidx/compose/material/icons/Icons$Rounded;", "getSend$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getSend", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SendKt {
    private static ImageVector _send;

    static {
    }

    public static final ImageVector getSend(Rounded arg19) {
        ImageVector v0 = SendKt._send;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Send", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(3.4f, 20.4f);
        v12.lineToRelative(17.450001f, -7.48f);
        v12.curveToRelative(0.81f, -0.35f, 0.81f, -1.49f, 0f, -1.84f);
        v12.lineTo(3.4f, 3.6f);
        v12.curveToRelative(-0.66f, -0.29f, -1.39f, 0.2f, -1.39f, 0.91f);
        v12.lineTo(2f, 9.12f);
        v12.curveToRelative(0f, 0.5f, 0.37f, 0.93f, 0.87f, 0.99f);
        v12.lineTo(17f, 12f);
        v12.lineTo(2.87f, 13.88f);
        v12.curveToRelative(-0.5f, 0.07f, -0.87f, 0.5f, -0.87f, 1f);
        v12.lineToRelative(0.01f, 4.61f);
        v12.curveToRelative(0f, 0.71f, 0.73f, 1.2f, 1.39f, 0.91f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SendKt._send = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Rounded.Send", replaceWith="<_subannotation>") public static void getSend$annotations(Rounded arg0) {
    }
}

