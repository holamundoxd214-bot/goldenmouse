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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_contactPage", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ContactPage", "Landroidx/compose/material/icons/Icons$Sharp;", "getContactPage", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ContactPageKt {
    private static ImageVector _contactPage;

    static {
    }

    public static final ImageVector getContactPage(Sharp arg19) {
        ImageVector v0 = ContactPageKt._contactPage;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.ContactPage", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14f, 2f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(20f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineTo(8f);
        v12.lineTo(14f, 2f);
        v12.close();
        v12.moveTo(12f, 10f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f);
        v12.curveTo(10f, 10.9f, 10.9f, 10f, 12f, 10f);
        v12.close();
        v12.moveTo(16f, 18f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(-0.57f);
        v12.curveToRelative(0f, -0.81f, 0.48f, -1.53f, 1.22f, -1.85f);
        v12.curveTo(10.07f, 15.21f, 11.01f, 15f, 12f, 15f);
        v12.curveToRelative(0.99f, 0f, 1.93f, 0.21f, 2.78f, 0.58f);
        v12.curveTo(15.52f, 15.9f, 16f, 16.620001f, 16f, 17.43f);
        v12.verticalLineTo(18f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ContactPageKt._contactPage = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

