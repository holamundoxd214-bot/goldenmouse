package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_attachment", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Attachment", "Landroidx/compose/material/icons/Icons$Sharp;", "getAttachment", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AttachmentKt {
    private static ImageVector _attachment;

    static {
    }

    public static final ImageVector getAttachment(Sharp arg19) {
        ImageVector v0 = AttachmentKt._attachment;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Attachment", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.5f, 16f);
        v12.horizontalLineTo(7f);
        v12.curveToRelative(-2.21f, 0f, -4f, -1.79f, -4f, -4f);
        v12.reflectiveCurveToRelative(1.79f, -4f, 4f, -4f);
        v12.horizontalLineToRelative(12.5f);
        v12.curveToRelative(1.38f, 0f, 2.5f, 1.12f, 2.5f, 2.5f);
        v12.reflectiveCurveTo(20.879999f, 13f, 19.5f, 13f);
        v12.horizontalLineTo(9f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(9.5f);
        v12.verticalLineTo(9.5f);
        v12.horizontalLineTo(9f);
        v12.curveToRelative(-1.38f, 0f, -2.5f, 1.12f, -2.5f, 2.5f);
        v12.reflectiveCurveToRelative(1.12f, 2.5f, 2.5f, 2.5f);
        v12.horizontalLineToRelative(10.5f);
        v12.curveToRelative(2.21f, 0f, 4f, -1.79f, 4f, -4f);
        v12.reflectiveCurveToRelative(-1.79f, -4f, -4f, -4f);
        v12.horizontalLineTo(7f);
        v12.curveToRelative(-3.04f, 0f, -5.5f, 2.46f, -5.5f, 5.5f);
        v12.reflectiveCurveToRelative(2.46f, 5.5f, 5.5f, 5.5f);
        v12.horizontalLineToRelative(11.5f);
        v12.verticalLineTo(16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AttachmentKt._attachment = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

