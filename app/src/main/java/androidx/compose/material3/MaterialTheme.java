package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t8G¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\r8G¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u00118AX\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00110\u00158@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2={"Landroidx/compose/material3/MaterialTheme;", "", "<init>", "()V", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "getColorScheme", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ColorScheme;", "typography", "Landroidx/compose/material3/Typography;", "getTypography", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/Typography;", "shapes", "Landroidx/compose/material3/Shapes;", "getShapes", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/Shapes;", "motionScheme", "Landroidx/compose/material3/MotionScheme;", "getMotionScheme", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/MotionScheme;", "LocalMotionScheme", "Landroidx/compose/runtime/CompositionLocal;", "getLocalMotionScheme$material3", "()Landroidx/compose/runtime/CompositionLocal;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MaterialTheme {
    public static final int $stable;
    public static final MaterialTheme INSTANCE;

    static {
        MaterialTheme.INSTANCE = new MaterialTheme();
    }

    private MaterialTheme() {
        super();
    }

    public final ColorScheme getColorScheme(Composer arg3, int arg4) {
        int v0 = 0xDE8660E2;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-colorScheme>)121@5354L7:MaterialTheme.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.MaterialTheme.<get-colorScheme> (MaterialTheme.kt:121)");
        }

        ProvidableCompositionLocal v2 = ColorSchemeKt.getLocalColorScheme();
        ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v2_1 = arg3.consume(((CompositionLocal)v2));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((ColorScheme)v2_1);
    }

    public final CompositionLocal getLocalMotionScheme$material3() {
        return MaterialThemeKt.access$get_localMotionScheme$p();
    }

    public final MotionScheme getMotionScheme(Composer arg4, int arg5) {
        int v1 = 0xE1CDAF7D;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(<get-motionScheme>)141@6119L7:MaterialTheme.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.MaterialTheme.<get-motionScheme> (MaterialTheme.kt:141)");
        }

        CompositionLocal v3 = this.getLocalMotionScheme$material3();
        ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v3_1 = arg4.consume(v3);
        ComposerKt.sourceInformationMarkerEnd(arg4);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return ((MotionScheme)v3_1);
    }

    public final Shapes getShapes(Composer arg3, int arg4) {
        int v0 = 419509830;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-shapes>)137@5906L7:MaterialTheme.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.MaterialTheme.<get-shapes> (MaterialTheme.kt:137)");
        }

        ProvidableCompositionLocal v2 = ShapesKt.getLocalShapes();
        ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v2_1 = arg3.consume(((CompositionLocal)v2));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((Shapes)v2_1);
    }

    public final Typography getTypography(Composer arg3, int arg4) {
        int v0 = 0xC7CE1749;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-typography>)129@5640L7:MaterialTheme.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.MaterialTheme.<get-typography> (MaterialTheme.kt:129)");
        }

        ProvidableCompositionLocal v2 = TypographyKt.getLocalTypography();
        ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v2_1 = arg3.consume(((CompositionLocal)v2));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((Typography)v2_1);
    }
}

