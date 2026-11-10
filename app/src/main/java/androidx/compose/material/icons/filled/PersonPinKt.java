package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_personPin", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PersonPin", "Landroidx/compose/material/icons/Icons$Filled;", "getPersonPin", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PersonPinKt {
    private static ImageVector _personPin;

    static {
    }

    public static final ImageVector getPersonPin(Filled arg19) {
        ImageVector v0 = PersonPinKt._personPin;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.PersonPin", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveToRelative(-4.97f, 0f, -9f, 4.03f, -9f, 9f);
        v12.curveToRelative(0f, 4.17f, 2.84f, 7.67f, 6.69f, 8.69f);
        v12.lineTo(12f, 22f);
        v12.lineToRelative(2.31f, -2.31f);
        v12.curveTo(18.16f, 18.67f, 21f, 15.17f, 21f, 11f);
        v12.curveToRelative(0f, -4.97f, -4.03f, -9f, -9f, -9f);
        v12.close();
        v12.moveTo(12f, 4f);
        v12.curveToRelative(1.66f, 0f, 3f, 1.34f, 3f, 3f);
        v12.reflectiveCurveToRelative(-1.34f, 3f, -3f, 3f);
        v12.reflectiveCurveToRelative(-3f, -1.34f, -3f, -3f);
        v12.reflectiveCurveToRelative(1.34f, -3f, 3f, -3f);
        v12.close();
        v12.moveTo(12f, 18.299999f);
        v12.curveToRelative(-2.5f, 0f, -4.71f, -1.28f, -6f, -3.22f);
        v12.curveToRelative(0.03f, -1.99f, 4f, -3.08f, 6f, -3.08f);
        v12.curveToRelative(1.99f, 0f, 5.97f, 1.09f, 6f, 3.08f);
        v12.curveToRelative(-1.29f, 1.94f, -3.5f, 3.22f, -6f, 3.22f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PersonPinKt._personPin = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

