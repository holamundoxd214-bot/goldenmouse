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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_importContacts", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ImportContacts", "Landroidx/compose/material/icons/Icons$Rounded;", "getImportContacts", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ImportContactsKt {
    private static ImageVector _importContacts;

    static {
    }

    public static final ImageVector getImportContacts(Rounded arg19) {
        ImageVector v0 = ImportContactsKt._importContacts;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ImportContacts", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.5f, 4.5f);
        v12.curveToRelative(-1.95f, 0f, -4.05f, 0.4f, -5.5f, 1.5f);
        v12.curveToRelative(-1.45f, -1.1f, -3.55f, -1.5f, -5.5f, -1.5f);
        v12.curveToRelative(-1.45f, 0f, -2.99f, 0.22f, -4.28f, 0.79f);
        v12.curveTo(1.49f, 5.62f, 1f, 6.33f, 1f, 7.14f);
        v12.verticalLineToRelative(11.28f);
        v12.curveToRelative(0f, 1.3f, 1.22f, 2.26f, 2.48f, 1.94f);
        v12.curveToRelative(0.98f, -0.25f, 2.02f, -0.36f, 3.02f, -0.36f);
        v12.curveToRelative(1.56f, 0f, 3.22f, 0.26f, 4.56f, 0.92f);
        v12.curveToRelative(0.6f, 0.3f, 1.28f, 0.3f, 1.87f, 0f);
        v12.curveToRelative(1.34f, -0.67f, 3f, -0.92f, 4.56f, -0.92f);
        v12.curveToRelative(1f, 0f, 2.04f, 0.11f, 3.02f, 0.36f);
        v12.curveToRelative(1.26f, 0.33f, 2.48f, -0.63f, 2.48f, -1.94f);
        v12.verticalLineTo(7.14f);
        v12.curveToRelative(0f, -0.81f, -0.49f, -1.52f, -1.22f, -1.85f);
        v12.curveToRelative(-1.28f, -0.57f, -2.82f, -0.79f, -4.27f, -0.79f);
        v12.close();
        v12.moveTo(21f, 17.23f);
        v12.curveToRelative(0f, 0.63f, -0.58f, 1.09f, -1.2f, 0.98f);
        v12.curveToRelative(-0.75f, -0.14f, -1.53f, -0.2f, -2.3f, -0.2f);
        v12.curveToRelative(-1.7f, 0f, -4.15f, 0.65f, -5.5f, 1.5f);
        v12.verticalLineTo(8f);
        v12.curveToRelative(1.35f, -0.85f, 3.8f, -1.5f, 5.5f, -1.5f);
        v12.curveToRelative(0.92f, 0f, 1.83f, 0.09f, 2.7f, 0.28f);
        v12.curveToRelative(0.46f, 0.1f, 0.8f, 0.51f, 0.8f, 0.98f);
        v12.verticalLineToRelative(9.47f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ImportContactsKt._importContacts = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

