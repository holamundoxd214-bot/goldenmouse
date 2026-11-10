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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_contactEmergency", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ContactEmergency", "Landroidx/compose/material/icons/Icons$Sharp;", "getContactEmergency", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ContactEmergencyKt {
    private static ImageVector _contactEmergency;

    static {
    }

    public static final ImageVector getContactEmergency(Sharp arg19) {
        ImageVector v0 = ContactEmergencyKt._contactEmergency;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.ContactEmergency", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(23.99f, 3f);
        v12.horizontalLineTo(0f);
        v12.verticalLineToRelative(18f);
        v12.horizontalLineToRelative(23.99f);
        v12.verticalLineTo(3f);
        v12.close();
        v12.moveTo(9f, 8f);
        v12.curveToRelative(1.65f, 0f, 3f, 1.35f, 3f, 3f);
        v12.reflectiveCurveToRelative(-1.35f, 3f, -3f, 3f);
        v12.reflectiveCurveToRelative(-3f, -1.35f, -3f, -3f);
        v12.reflectiveCurveTo(7.35f, 8f, 9f, 8f);
        v12.close();
        v12.moveTo(2.08f, 19f);
        v12.curveToRelative(1.38f, -2.39f, 3.96f, -4f, 6.92f, -4f);
        v12.reflectiveCurveToRelative(5.54f, 1.61f, 6.92f, 4f);
        v12.horizontalLineTo(2.08f);
        v12.close();
        v12.moveTo(20.969999f, 9.85f);
        v12.lineToRelative(-0.75f, 1.3f);
        v12.lineToRelative(-1.47f, -0.85f);
        v12.verticalLineTo(12f);
        v12.horizontalLineToRelative(-1.5f);
        v12.verticalLineToRelative(-1.7f);
        v12.lineToRelative(-1.47f, 0.85f);
        v12.lineToRelative(-0.75f, -1.3f);
        v12.lineTo(16.5f, 9f);
        v12.lineToRelative(-1.47f, -0.85f);
        v12.lineToRelative(0.75f, -1.3f);
        v12.lineToRelative(1.47f, 0.85f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(1.5f);
        v12.verticalLineToRelative(1.7f);
        v12.lineToRelative(1.47f, -0.85f);
        v12.lineToRelative(0.75f, 1.3f);
        v12.lineTo(19.5f, 9f);
        v12.lineTo(20.969999f, 9.85f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ContactEmergencyKt._contactEmergency = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

