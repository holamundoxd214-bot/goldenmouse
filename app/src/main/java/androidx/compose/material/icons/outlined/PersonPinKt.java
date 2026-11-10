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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_personPin", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PersonPin", "Landroidx/compose/material/icons/Icons$Outlined;", "getPersonPin", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PersonPinKt {
    private static ImageVector _personPin;

    static {
    }

    public static final ImageVector getPersonPin(Outlined arg19) {
        ImageVector v0 = PersonPinKt._personPin;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.PersonPin", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 2f);
        v12.lineTo(5f, 2f);
        v12.curveToRelative(-1.11f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.89f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(4f);
        v12.lineToRelative(3f, 3f);
        v12.lineToRelative(3f, -3f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(21f, 4f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(19f, 18f);
        v12.horizontalLineToRelative(-4.83f);
        v12.lineToRelative(-0.59f, 0.59f);
        v12.lineTo(12f, 20.17f);
        v12.lineToRelative(-1.59f, -1.59f);
        v12.lineToRelative(-0.58f, -0.58f);
        v12.lineTo(5f, 18f);
        v12.lineTo(5f, 4f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineToRelative(14f);
        v12.close();
        v12.moveTo(12f, 11f);
        v12.curveToRelative(1.65f, 0f, 3f, -1.35f, 3f, -3f);
        v12.reflectiveCurveToRelative(-1.35f, -3f, -3f, -3f);
        v12.reflectiveCurveToRelative(-3f, 1.35f, -3f, 3f);
        v12.reflectiveCurveToRelative(1.35f, 3f, 3f, 3f);
        v12.close();
        v12.moveTo(12f, 7f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.close();
        v12.moveTo(18f, 15.58f);
        v12.curveToRelative(0f, -2.5f, -3.97f, -3.58f, -6f, -3.58f);
        v12.reflectiveCurveToRelative(-6f, 1.08f, -6f, 3.58f);
        v12.lineTo(6f, 17f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(-1.42f);
        v12.close();
        v12.moveTo(8.48f, 15f);
        v12.curveToRelative(0.74f, -0.51f, 2.23f, -1f, 3.52f, -1f);
        v12.reflectiveCurveToRelative(2.78f, 0.49f, 3.52f, 1f);
        v12.lineTo(8.48f, 15f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PersonPinKt._personPin = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

