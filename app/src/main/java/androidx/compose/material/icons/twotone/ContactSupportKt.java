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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_contactSupport", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ContactSupport", "Landroidx/compose/material/icons/Icons$TwoTone;", "getContactSupport$annotations", "(Landroidx/compose/material/icons/Icons$TwoTone;)V", "getContactSupport", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ContactSupportKt {
    private static ImageVector _contactSupport;

    static {
    }

    public static final ImageVector getContactSupport(TwoTone arg19) {
        ImageVector v0 = ContactSupportKt._contactSupport;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.ContactSupport", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.5f, 3f);
        v12.curveTo(7.36f, 3f, 4f, 6.36f, 4f, 10.5f);
        v12.reflectiveCurveTo(7.36f, 18f, 11.5f, 18f);
        v12.lineTo(13f, 18f);
        v12.verticalLineToRelative(2.3f);
        v12.curveToRelative(3.64f, -2.3f, 6f, -6.08f, 6f, -9.8f);
        v12.curveTo(19f, 6.36f, 15.64f, 3f, 11.5f, 3f);
        v12.close();
        v12.moveTo(12.5f, 16.5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.close();
        v12.moveTo(12.5f, 13f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(0f, -3.25f, 3f, -3f, 3f, -5f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(0f, -2.21f, 1.79f, -4f, 4f, -4f);
        v12.reflectiveCurveToRelative(4f, 1.79f, 4f, 4f);
        v12.curveToRelative(0f, 2.5f, -3f, 2.75f, -3f, 5f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(11.5f, 1f);
        v12.curveTo(6.26f, 1f, 2f, 5.26f, 2f, 10.5f);
        v12.curveToRelative(0f, 5.07f, 3.99f, 9.23f, 9f, 9.49f);
        v12.verticalLineToRelative(3.6f);
        v12.lineToRelative(1.43f, -0.69f);
        v12.curveTo(17.559999f, 20.43f, 21f, 15.45f, 21f, 10.5f);
        v12.curveTo(21f, 5.26f, 16.74f, 1f, 11.5f, 1f);
        v12.close();
        v12.moveTo(13f, 20.299999f);
        v12.lineTo(13f, 18f);
        v12.horizontalLineToRelative(-1.5f);
        v12.curveTo(7.36f, 18f, 4f, 14.64f, 4f, 10.5f);
        v12.reflectiveCurveTo(7.36f, 3f, 11.5f, 3f);
        v12.reflectiveCurveTo(19f, 6.36f, 19f, 10.5f);
        v12.curveToRelative(0f, 3.73f, -2.36f, 7.51f, -6f, 9.8f);
        v12.close();
        v12.moveTo(10.5f, 14.5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-2f);
        v12.close();
        v12.moveTo(11.5f, 4f);
        v12.curveToRelative(-2.21f, 0f, -4f, 1.79f, -4f, 4f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.curveToRelative(0f, 2f, -3f, 1.75f, -3f, 5f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0f, -2.25f, 3f, -2.5f, 3f, -5f);
        v12.curveToRelative(0f, -2.21f, -1.79f, -4f, -4f, -4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ContactSupportKt._contactSupport = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.TwoTone.ContactSupport", replaceWith="<_subannotation>") public static void getContactSupport$annotations(TwoTone arg0) {
    }
}

