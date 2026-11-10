package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_contactless", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Contactless", "Landroidx/compose/material/icons/Icons$Filled;", "getContactless", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ContactlessKt {
    private static ImageVector _contactless;

    static {
    }

    public static final ImageVector getContactless(Filled arg19) {
        ImageVector v0 = ContactlessKt._contactless;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Contactless", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.curveToRelative(0f, 5.52f, 4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.curveTo(22f, 6.48f, 17.52f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(8.46f, 14.45f);
        v12.lineTo(7.1f, 13.83f);
        v12.curveToRelative(0.28f, -0.61f, 0.41f, -1.24f, 0.4f, -1.86f);
        v12.curveToRelative(-0.01f, -0.63f, -0.14f, -1.24f, -0.4f, -1.8f);
        v12.lineToRelative(1.36f, -0.63f);
        v12.curveToRelative(0.35f, 0.75f, 0.53f, 1.56f, 0.54f, 2.4f);
        v12.curveTo(9.01f, 12.8f, 8.83f, 13.64f, 8.46f, 14.45f);
        v12.close();
        v12.moveTo(11.53f, 16.01f);
        v12.lineToRelative(-1.3f, -0.74f);
        v12.curveToRelative(0.52f, -0.92f, 0.78f, -1.98f, 0.78f, -3.15f);
        v12.curveToRelative(0f, -1.19f, -0.27f, -2.33f, -0.8f, -3.4f);
        v12.lineToRelative(1.34f, -0.67f);
        v12.curveToRelative(0.64f, 1.28f, 0.96f, 2.65f, 0.96f, 4.07f);
        v12.curveTo(12.51f, 13.55f, 12.18f, 14.86f, 11.53f, 16.01f);
        v12.close();
        v12.moveTo(14.67f, 17.33f);
        v12.lineToRelative(-1.35f, -0.66f);
        v12.curveToRelative(0.78f, -1.6f, 1.18f, -3.18f, 1.18f, -4.69f);
        v12.curveToRelative(0f, -1.51f, -0.4f, -3.07f, -1.18f, -4.64f);
        v12.lineToRelative(1.34f, -0.67f);
        v12.curveTo(15.56f, 8.45f, 16f, 10.23f, 16f, 11.98f);
        v12.curveTo(16f, 13.72f, 15.56f, 15.52f, 14.67f, 17.33f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ContactlessKt._contactless = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

