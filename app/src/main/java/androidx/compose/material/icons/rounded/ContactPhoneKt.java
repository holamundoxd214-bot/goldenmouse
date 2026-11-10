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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_contactPhone", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ContactPhone", "Landroidx/compose/material/icons/Icons$Rounded;", "getContactPhone", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ContactPhoneKt {
    private static ImageVector _contactPhone;

    static {
    }

    public static final ImageVector getContactPhone(Rounded arg19) {
        ImageVector v0 = ContactPhoneKt._contactPhone;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ContactPhone", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 3f);
        v12.lineTo(2f, 3f);
        v12.curveTo(0.9f, 3f, 0f, 3.9f, 0f, 5f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(20f);
        v12.curveToRelative(1.1f, 0f, 1.99f, -0.9f, 1.99f, -2f);
        v12.lineTo(24f, 5f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(8f, 6f);
        v12.curveToRelative(1.66f, 0f, 3f, 1.34f, 3f, 3f);
        v12.reflectiveCurveToRelative(-1.34f, 3f, -3f, 3f);
        v12.reflectiveCurveToRelative(-3f, -1.34f, -3f, -3f);
        v12.reflectiveCurveToRelative(1.34f, -3f, 3f, -3f);
        v12.close();
        v12.moveTo(14f, 18f);
        v12.lineTo(2f, 18f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(0f, -2f, 4f, -3.1f, 6f, -3.1f);
        v12.reflectiveCurveToRelative(6f, 1.1f, 6f, 3.1f);
        v12.verticalLineToRelative(1f);
        v12.close();
        v12.moveTo(17.85f, 14f);
        v12.horizontalLineToRelative(1.39f);
        v12.curveToRelative(0.16f, 0f, 0.3f, 0.07f, 0.4f, 0.2f);
        v12.lineToRelative(1.1f, 1.45f);
        v12.curveToRelative(0.15f, 0.2f, 0.13f, 0.48f, -0.05f, 0.65f);
        v12.lineToRelative(-1.36f, 1.36f);
        v12.curveToRelative(-0.18f, 0.18f, -0.48f, 0.2f, -0.67f, 0.04f);
        v12.curveToRelative(-1.13f, -0.96f, -1.97f, -2.25f, -2.38f, -3.71f);
        v12.curveToRelative(-0.18f, -0.63f, -0.28f, -1.3f, -0.28f, -1.99f);
        v12.reflectiveCurveToRelative(0.1f, -1.36f, 0.28f, -2f);
        v12.curveToRelative(0.41f, -1.47f, 1.25f, -2.75f, 2.38f, -3.71f);
        v12.curveToRelative(0.2f, -0.17f, 0.49f, -0.14f, 0.67f, 0.04f);
        v12.lineToRelative(1.36f, 1.36f);
        v12.curveToRelative(0.18f, 0.18f, 0.2f, 0.46f, 0.05f, 0.65f);
        v12.lineToRelative(-1.1f, 1.45f);
        v12.curveToRelative(-0.09f, 0.13f, -0.24f, 0.2f, -0.4f, 0.2f);
        v12.horizontalLineToRelative(-1.39f);
        v12.curveToRelative(-0.22f, 0.63f, -0.35f, 1.3f, -0.35f, 2f);
        v12.reflectiveCurveToRelative(0.13f, 1.38f, 0.35f, 2.01f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ContactPhoneKt._contactPhone = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

