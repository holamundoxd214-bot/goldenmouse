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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_chat", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Chat", "Landroidx/compose/material/icons/Icons$TwoTone;", "getChat$annotations", "(Landroidx/compose/material/icons/Icons$TwoTone;)V", "getChat", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ChatKt {
    private static ImageVector _chat;

    static {
    }

    public static final ImageVector getChat(TwoTone arg19) {
        ImageVector v0 = ChatKt._chat;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Chat", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(20f, 4f);
        v0_1.lineTo(4f, 4f);
        v0_1.verticalLineToRelative(13.17f);
        v0_1.lineTo(5.17f, 16f);
        v0_1.lineTo(20f, 16f);
        v0_1.lineTo(20f, 4f);
        v0_1.close();
        v0_1.moveTo(14f, 14f);
        v0_1.lineTo(6f, 14f);
        v0_1.verticalLineToRelative(-2f);
        v0_1.horizontalLineToRelative(8f);
        v0_1.verticalLineToRelative(2f);
        v0_1.close();
        v0_1.moveTo(18f, 11f);
        v0_1.lineTo(6f, 11f);
        v0_1.lineTo(6f, 9f);
        v0_1.horizontalLineToRelative(12f);
        v0_1.verticalLineToRelative(2f);
        v0_1.close();
        v0_1.moveTo(18f, 8f);
        v0_1.lineTo(6f, 8f);
        v0_1.lineTo(6f, 6f);
        v0_1.horizontalLineToRelative(12f);
        v0_1.verticalLineToRelative(2f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 18f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(22f, 4f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.lineTo(4f, 2f);
        v12.curveToRelative(-1.1f, 0f, -1.99f, 0.9f, -1.99f, 2f);
        v12.lineTo(2f, 22f);
        v12.lineToRelative(4f, -4f);
        v12.horizontalLineToRelative(14f);
        v12.close();
        v12.moveTo(4f, 17.17f);
        v12.lineTo(4f, 4f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineToRelative(12f);
        v12.lineTo(5.17f, 16f);
        v12.lineTo(4f, 17.17f);
        v12.close();
        v12.moveTo(6f, 12f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(2f);
        v12.lineTo(6f, 14f);
        v12.close();
        v12.moveTo(6f, 9f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(2f);
        v12.lineTo(6f, 11f);
        v12.close();
        v12.moveTo(6f, 6f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(2f);
        v12.lineTo(6f, 8f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ChatKt._chat = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.TwoTone.Chat", replaceWith="<_subannotation>") public static void getChat$annotations(TwoTone arg0) {
    }
}

