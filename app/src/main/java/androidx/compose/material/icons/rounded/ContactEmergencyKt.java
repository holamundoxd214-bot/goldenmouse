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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_contactEmergency", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ContactEmergency", "Landroidx/compose/material/icons/Icons$Rounded;", "getContactEmergency", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ContactEmergencyKt {
    private static ImageVector _contactEmergency;

    static {
    }

    public static final ImageVector getContactEmergency(Rounded arg19) {
        ImageVector v0 = ContactEmergencyKt._contactEmergency;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ContactEmergency", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 3f);
        v12.horizontalLineTo(2f);
        v12.curveTo(0.9f, 3f, 0f, 3.9f, 0f, 5f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(20f);
        v12.curveToRelative(1.1f, 0f, 1.99f, -0.9f, 1.99f, -2f);
        v12.lineTo(24f, 5f);
        v12.curveTo(24f, 3.9f, 23.1f, 3f, 22f, 3f);
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
        v12.moveTo(20.6f, 10.5f);
        v12.lineTo(20.6f, 10.5f);
        v12.curveToRelative(-0.21f, 0.36f, -0.67f, 0.48f, -1.02f, 0.27f);
        v12.lineToRelative(-0.82f, -0.48f);
        v12.verticalLineToRelative(0.95f);
        v12.curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f);
        v12.verticalLineTo(10.3f);
        v12.lineToRelative(-0.82f, 0.48f);
        v12.curveToRelative(-0.36f, 0.21f, -0.82f, 0.08f, -1.02f, -0.27f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.21f, -0.36f, -0.08f, -0.82f, 0.27f, -1.02f);
        v12.lineTo(16.5f, 9f);
        v12.lineToRelative(-0.82f, -0.48f);
        v12.curveToRelative(-0.36f, -0.21f, -0.48f, -0.67f, -0.27f, -1.02f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.21f, -0.36f, 0.67f, -0.48f, 1.02f, -0.27f);
        v12.lineToRelative(0.82f, 0.48f);
        v12.verticalLineTo(6.75f);
        v12.curveTo(17.25f, 6.34f, 17.59f, 6f, 18f, 6f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f);
        v12.verticalLineTo(7.7f);
        v12.lineToRelative(0.82f, -0.48f);
        v12.curveToRelative(0.36f, -0.21f, 0.82f, -0.08f, 1.02f, 0.27f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0.21f, 0.36f, 0.08f, 0.82f, -0.27f, 1.02f);
        v12.lineTo(19.5f, 9f);
        v12.lineToRelative(0.82f, 0.48f);
        v12.curveTo(20.68f, 9.68f, 20.809999f, 10.14f, 20.6f, 10.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ContactEmergencyKt._contactEmergency = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

