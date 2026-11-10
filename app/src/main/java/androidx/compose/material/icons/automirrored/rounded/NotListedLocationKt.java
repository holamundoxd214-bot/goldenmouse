package androidx.compose.material.icons.automirrored.rounded;

import androidx.compose.material.icons.Icons$AutoMirrored$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_notListedLocation", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NotListedLocation", "Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;", "getNotListedLocation", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NotListedLocationKt {
    private static ImageVector _notListedLocation;

    static {
    }

    public static final ImageVector getNotListedLocation(Rounded arg19) {
        ImageVector v0 = NotListedLocationKt._notListedLocation;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Rounded.NotListedLocation", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveToRelative(-4.2f, 0f, -8f, 3.22f, -8f, 8.2f);
        v12.curveToRelative(0f, 3.18f, 2.45f, 6.92f, 7.34f, 11.22f);
        v12.curveToRelative(0.38f, 0.33f, 0.95f, 0.33f, 1.33f, 0f);
        v12.curveTo(17.549999f, 17.120001f, 20f, 13.38f, 20f, 10.2f);
        v12.curveTo(20f, 5.22f, 16.200001f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(12.01f, 16f);
        v12.curveToRelative(-0.59f, 0f, -1.05f, -0.47f, -1.05f, -1.05f);
        v12.curveToRelative(0f, -0.59f, 0.47f, -1.04f, 1.05f, -1.04f);
        v12.curveToRelative(0.59f, 0f, 1.04f, 0.45f, 1.04f, 1.04f);
        v12.curveTo(13.05f, 15.53f, 12.61f, 16f, 12.01f, 16f);
        v12.close();
        v12.moveTo(14.52f, 9.83f);
        v12.curveToRelative(-0.63f, 0.93f, -1.23f, 1.21f, -1.56f, 1.81f);
        v12.curveToRelative(-0.08f, 0.14f, -0.13f, 0.26f, -0.16f, 0.49f);
        v12.curveToRelative(-0.05f, 0.39f, -0.36f, 0.68f, -0.75f, 0.68f);
        v12.horizontalLineToRelative(-0.03f);
        v12.curveToRelative(-0.44f, 0f, -0.79f, -0.38f, -0.75f, -0.82f);
        v12.curveToRelative(0.03f, -0.27f, 0.09f, -0.57f, 0.25f, -0.84f);
        v12.curveToRelative(0.41f, -0.73f, 1.18f, -1.16f, 1.63f, -1.8f);
        v12.curveToRelative(0.48f, -0.68f, 0.21f, -1.94f, -1.14f, -1.94f);
        v12.curveToRelative(-0.61f, 0f, -1.01f, 0.32f, -1.26f, 0.7f);
        v12.curveToRelative(-0.19f, 0.29f, -0.57f, 0.39f, -0.89f, 0.25f);
        v12.curveToRelative(-0.42f, -0.18f, -0.6f, -0.7f, -0.34f, -1.07f);
        v12.curveTo(10.03f, 6.55f, 10.88f, 6f, 12f, 6f);
        v12.curveToRelative(1.23f, 0f, 2.08f, 0.56f, 2.51f, 1.26f);
        v12.curveTo(14.87f, 7.87f, 15.09f, 8.99f, 14.52f, 9.83f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NotListedLocationKt._notListedLocation = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

