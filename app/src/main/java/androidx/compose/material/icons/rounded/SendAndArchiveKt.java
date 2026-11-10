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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_sendAndArchive", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SendAndArchive", "Landroidx/compose/material/icons/Icons$Rounded;", "getSendAndArchive$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getSendAndArchive", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SendAndArchiveKt {
    private static ImageVector _sendAndArchive;

    static {
    }

    public static final ImageVector getSendAndArchive(Rounded arg19) {
        ImageVector v0 = SendAndArchiveKt._sendAndArchive;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SendAndArchive", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17f, 12f);
        v12.curveToRelative(-2.76f, 0f, -5f, 2.24f, -5f, 5f);
        v12.reflectiveCurveToRelative(2.24f, 5f, 5f, 5f);
        v12.reflectiveCurveToRelative(5f, -2.24f, 5f, -5f);
        v12.reflectiveCurveTo(19.76f, 12f, 17f, 12f);
        v12.close();
        v12.moveTo(19.15f, 17.85f);
        v12.lineToRelative(-1.79f, 1.79f);
        v12.curveToRelative(-0.2f, 0.2f, -0.51f, 0.2f, -0.71f, 0f);
        v12.lineToRelative(-1.79f, -1.79f);
        v12.curveTo(14.54f, 17.540001f, 14.76f, 17f, 15.21f, 17f);
        v12.horizontalLineToRelative(1.29f);
        v12.verticalLineToRelative(-2.5f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f);
        v12.verticalLineTo(17f);
        v12.horizontalLineToRelative(1.29f);
        v12.curveTo(19.24f, 17f, 19.459999f, 17.540001f, 19.15f, 17.85f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(17f, 10f);
        v12.curveToRelative(0.1f, 0f, 0.19f, 0.01f, 0.28f, 0.01f);
        v12.lineTo(3f, 4f);
        v12.verticalLineToRelative(6f);
        v12.lineToRelative(8f, 2f);
        v12.lineToRelative(-8f, 2f);
        v12.verticalLineToRelative(6f);
        v12.lineToRelative(7f, -2.95f);
        v12.curveToRelative(0f, -0.02f, 0f, -0.03f, 0f, -0.05f);
        v12.curveTo(10f, 13.13f, 13.13f, 10f, 17f, 10f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SendAndArchiveKt._sendAndArchive = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Rounded.SendAndArchive", replaceWith="<_subannotation>") public static void getSendAndArchive$annotations(Rounded arg0) {
    }
}

