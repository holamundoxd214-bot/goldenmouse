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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_contactSupport", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ContactSupport", "Landroidx/compose/material/icons/Icons$Rounded;", "getContactSupport$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getContactSupport", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ContactSupportKt {
    private static ImageVector _contactSupport;

    static {
    }

    public static final ImageVector getContactSupport(Rounded arg19) {
        ImageVector v0 = ContactSupportKt._contactSupport;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ContactSupport", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.5f, 2f);
        v12.curveTo(6.81f, 2f, 3f, 5.81f, 3f, 10.5f);
        v12.reflectiveCurveTo(6.81f, 19f, 11.5f, 19f);
        v12.horizontalLineToRelative(0.5f);
        v12.verticalLineToRelative(3f);
        v12.curveToRelative(4.86f, -2.34f, 8f, -7f, 8f, -11.5f);
        v12.curveTo(20f, 5.81f, 16.190001f, 2f, 11.5f, 2f);
        v12.close();
        v12.moveTo(12.5f, 16.5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.close();
        v12.moveTo(12.9f, 11.72f);
        v12.curveToRelative(-0.01f, 0.01f, -0.02f, 0.03f, -0.03f, 0.05f);
        v12.curveToRelative(-0.05f, 0.08f, -0.1f, 0.16f, -0.14f, 0.24f);
        v12.curveToRelative(-0.02f, 0.03f, -0.03f, 0.07f, -0.04f, 0.11f);
        v12.curveToRelative(-0.03f, 0.07f, -0.06f, 0.14f, -0.08f, 0.21f);
        v12.curveToRelative(-0.07f, 0.21f, -0.1f, 0.43f, -0.1f, 0.68f);
        v12.lineTo(10.5f, 13.01f);
        v12.curveToRelative(0f, -0.51f, 0.08f, -0.94f, 0.2f, -1.3f);
        v12.curveToRelative(0f, -0.01f, 0f, -0.02f, 0.01f, -0.03f);
        v12.curveToRelative(0.01f, -0.04f, 0.04f, -0.06f, 0.05f, -0.1f);
        v12.curveToRelative(0.06f, -0.16f, 0.13f, -0.3f, 0.22f, -0.44f);
        v12.curveToRelative(0.03f, -0.05f, 0.07f, -0.1f, 0.1f, -0.15f);
        v12.curveToRelative(0.03f, -0.04f, 0.05f, -0.09f, 0.08f, -0.12f);
        v12.lineToRelative(0.01f, 0.01f);
        v12.curveToRelative(0.84f, -1.1f, 2.21f, -1.44f, 2.32f, -2.68f);
        v12.curveToRelative(0.09f, -0.98f, -0.61f, -1.93f, -1.57f, -2.13f);
        v12.curveToRelative(-1.04f, -0.22f, -1.98f, 0.39f, -2.3f, 1.28f);
        v12.curveToRelative(-0.14f, 0.36f, -0.47f, 0.65f, -0.88f, 0.65f);
        v12.horizontalLineToRelative(-0.2f);
        v12.curveToRelative(-0.6f, 0f, -1.04f, -0.59f, -0.87f, -1.17f);
        v12.curveToRelative(0.55f, -1.82f, 2.37f, -3.09f, 4.43f, -2.79f);
        v12.curveToRelative(1.69f, 0.25f, 3.04f, 1.64f, 3.33f, 3.33f);
        v12.curveToRelative(0.44f, 2.44f, -1.63f, 3.03f, -2.53f, 4.35f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ContactSupportKt._contactSupport = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Rounded.ContactSupport", replaceWith="<_subannotation>") public static void getContactSupport$annotations(Rounded arg0) {
    }
}

