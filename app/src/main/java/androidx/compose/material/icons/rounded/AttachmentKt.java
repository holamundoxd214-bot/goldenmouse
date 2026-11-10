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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_attachment", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Attachment", "Landroidx/compose/material/icons/Icons$Rounded;", "getAttachment", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AttachmentKt {
    private static ImageVector _attachment;

    static {
    }

    public static final ImageVector getAttachment(Rounded arg19) {
        ImageVector v0 = AttachmentKt._attachment;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Attachment", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.75f, 16f);
        v12.horizontalLineTo(7.17f);
        v12.curveToRelative(-2.09f, 0f, -3.95f, -1.53f, -4.15f, -3.61f);
        v12.curveTo(2.79f, 10.01f, 4.66f, 8f, 7f, 8f);
        v12.horizontalLineToRelative(12.36f);
        v12.curveToRelative(1.31f, 0f, 2.5f, 0.94f, 2.63f, 2.24f);
        v12.curveToRelative(0.15f, 1.5f, -1.02f, 2.76f, -2.49f, 2.76f);
        v12.horizontalLineTo(9f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(8.75f);
        v12.curveToRelative(0.41f, 0f, 0.75f, -0.34f, 0.75f, -0.75f);
        v12.reflectiveCurveToRelative(-0.34f, -0.75f, -0.75f, -0.75f);
        v12.horizontalLineTo(9.14f);
        v12.curveToRelative(-1.31f, 0f, -2.5f, 0.94f, -2.63f, 2.24f);
        v12.curveToRelative(-0.15f, 1.5f, 1.02f, 2.76f, 2.49f, 2.76f);
        v12.horizontalLineToRelative(10.33f);
        v12.curveToRelative(2.09f, 0f, 3.95f, -1.53f, 4.15f, -3.61f);
        v12.curveToRelative(0.23f, -2.39f, -1.64f, -4.39f, -3.98f, -4.39f);
        v12.horizontalLineTo(7.23f);
        v12.curveToRelative(-2.87f, 0f, -5.44f, 2.1f, -5.71f, 4.96f);
        v12.curveToRelative(-0.3f, 3.29f, 2.26f, 6.04f, 5.48f, 6.04f);
        v12.horizontalLineToRelative(10.75f);
        v12.curveToRelative(0.41f, 0f, 0.75f, -0.34f, 0.75f, -0.75f);
        v12.reflectiveCurveToRelative(-0.34f, -0.75f, -0.75f, -0.75f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AttachmentKt._attachment = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

