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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_documentScanner", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DocumentScanner", "Landroidx/compose/material/icons/Icons$Outlined;", "getDocumentScanner", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DocumentScannerKt {
    private static ImageVector _documentScanner;

    static {
    }

    public static final ImageVector getDocumentScanner(Outlined arg19) {
        ImageVector v0 = DocumentScannerKt._documentScanner;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.DocumentScanner", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7f, 3f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineTo(2f);
        v12.verticalLineTo(1f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineTo(3f);
        v12.close();
        v12.moveTo(22f, 6f);
        v12.verticalLineTo(1f);
        v12.horizontalLineToRelative(-5f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineTo(22f);
        v12.close();
        v12.moveTo(7f, 21f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineTo(2f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineTo(21f);
        v12.close();
        v12.moveTo(20f, 18f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineToRelative(-5f);
        v12.horizontalLineTo(20f);
        v12.close();
        v12.moveTo(17f, 6f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(12f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineTo(6f);
        v12.close();
        v12.moveTo(19f, 18f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.horizontalLineTo(7f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.horizontalLineToRelative(10f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.verticalLineTo(18f);
        v12.close();
        v12.moveTo(15f, 8f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineTo(8f);
        v12.close();
        v12.moveTo(15f, 11f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineTo(11f);
        v12.close();
        v12.moveTo(15f, 14f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineTo(14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DocumentScannerKt._documentScanner = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

