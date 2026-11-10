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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_contactless", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Contactless", "Landroidx/compose/material/icons/Icons$Rounded;", "getContactless", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ContactlessKt {
    private static ImageVector _contactless;

    static {
    }

    public static final ImageVector getContactless(Rounded arg19) {
        ImageVector v0 = ContactlessKt._contactless;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Contactless", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.moveTo(8.75f, 13.68f);
        v12.curveToRelative(-0.13f, 0.43f, -0.62f, 0.63f, -1.02f, 0.45f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.34f, -0.16f, -0.51f, -0.54f, -0.4f, -0.9f);
        v12.curveToRelative(0.12f, -0.41f, 0.18f, -0.83f, 0.17f, -1.24f);
        v12.curveToRelative(-0.01f, -0.41f, -0.06f, -0.8f, -0.17f, -1.18f);
        v12.curveToRelative(-0.1f, -0.36f, 0.06f, -0.75f, 0.4f, -0.9f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.42f, -0.19f, 0.91f, 0.04f, 1.04f, 0.49f);
        v12.curveToRelative(0.15f, 0.51f, 0.22f, 1.03f, 0.23f, 1.57f);
        v12.curveTo(9f, 12.53f, 8.92f, 13.11f, 8.75f, 13.68f);
        v12.close();
        v12.moveTo(11.89f, 15.27f);
        v12.curveToRelative(-0.17f, 0.41f, -0.67f, 0.57f, -1.06f, 0.35f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.33f, -0.19f, -0.46f, -0.59f, -0.32f, -0.94f);
        v12.curveToRelative(0.33f, -0.77f, 0.49f, -1.63f, 0.49f, -2.56f);
        v12.curveToRelative(0f, -0.96f, -0.18f, -1.89f, -0.53f, -2.78f);
        v12.curveToRelative(-0.14f, -0.36f, 0.02f, -0.76f, 0.36f, -0.94f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.39f, -0.2f, 0.87f, -0.02f, 1.03f, 0.39f);
        v12.curveToRelative(0.42f, 1.06f, 0.63f, 2.18f, 0.63f, 3.33f);
        v12.curveTo(12.51f, 13.25f, 12.3f, 14.31f, 11.89f, 15.27f);
        v12.close();
        v12.moveTo(15f, 16.6f);
        v12.curveToRelative(-0.17f, 0.4f, -0.64f, 0.58f, -1.02f, 0.39f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.35f, -0.17f, -0.52f, -0.59f, -0.37f, -0.95f);
        v12.curveToRelative(0.59f, -1.39f, 0.89f, -2.75f, 0.89f, -4.06f);
        v12.curveToRelative(0f, -1.31f, -0.3f, -2.65f, -0.88f, -4.01f);
        v12.curveToRelative(-0.16f, -0.36f, 0.01f, -0.78f, 0.36f, -0.95f);
        v12.curveTo(14.37f, 6.82f, 14.83f, 7f, 15f, 7.4f);
        v12.curveToRelative(0.66f, 1.54f, 1f, 3.08f, 1f, 4.58f);
        v12.curveTo(16f, 13.48f, 15.66f, 15.04f, 15f, 16.6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ContactlessKt._contactless = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

