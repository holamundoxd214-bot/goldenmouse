package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_importContacts", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ImportContacts", "Landroidx/compose/material/icons/Icons$Outlined;", "getImportContacts", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ImportContactsKt {
    private static ImageVector _importContacts;

    static {
    }

    public static final ImageVector getImportContacts(Outlined arg19) {
        ImageVector v0 = ImportContactsKt._importContacts;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.ImportContacts", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 5f);
        v12.curveToRelative(-1.11f, -0.35f, -2.33f, -0.5f, -3.5f, -0.5f);
        v12.curveToRelative(-1.95f, 0f, -4.05f, 0.4f, -5.5f, 1.5f);
        v12.curveToRelative(-1.45f, -1.1f, -3.55f, -1.5f, -5.5f, -1.5f);
        v12.reflectiveCurveTo(2.45f, 4.9f, 1f, 6f);
        v12.verticalLineToRelative(14.65f);
        v12.curveToRelative(0f, 0.25f, 0.25f, 0.5f, 0.5f, 0.5f);
        v12.curveToRelative(0.1f, 0f, 0.15f, -0.05f, 0.25f, -0.05f);
        v12.curveTo(3.1f, 20.450001f, 5.05f, 20f, 6.5f, 20f);
        v12.curveToRelative(1.95f, 0f, 4.05f, 0.4f, 5.5f, 1.5f);
        v12.curveToRelative(1.35f, -0.85f, 3.8f, -1.5f, 5.5f, -1.5f);
        v12.curveToRelative(1.65f, 0f, 3.35f, 0.3f, 4.75f, 1.05f);
        v12.curveToRelative(0.1f, 0.05f, 0.15f, 0.05f, 0.25f, 0.05f);
        v12.curveToRelative(0.25f, 0f, 0.5f, -0.25f, 0.5f, -0.5f);
        v12.lineTo(23f, 6f);
        v12.curveToRelative(-0.6f, -0.45f, -1.25f, -0.75f, -2f, -1f);
        v12.close();
        v12.moveTo(21f, 18.5f);
        v12.curveToRelative(-1.1f, -0.35f, -2.3f, -0.5f, -3.5f, -0.5f);
        v12.curveToRelative(-1.7f, 0f, -4.15f, 0.65f, -5.5f, 1.5f);
        v12.lineTo(12f, 8f);
        v12.curveToRelative(1.35f, -0.85f, 3.8f, -1.5f, 5.5f, -1.5f);
        v12.curveToRelative(1.2f, 0f, 2.4f, 0.15f, 3.5f, 0.5f);
        v12.verticalLineToRelative(11.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ImportContactsKt._importContacts = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

