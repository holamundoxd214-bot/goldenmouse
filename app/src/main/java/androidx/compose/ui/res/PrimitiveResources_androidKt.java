package androidx.compose.ui.res;

import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0017\u0010\u0000\u001A\u00020\u00012\b\b\u0001\u0010\u0002\u001A\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0003\u001A\u0017\u0010\u0004\u001A\u00020\u00052\b\b\u0001\u0010\u0002\u001A\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006\u001A\u0017\u0010\u0007\u001A\u00020\b2\b\b\u0001\u0010\u0002\u001A\u00020\u0001H\u0007¢\u0006\u0002\u0010\t\u001A\u0017\u0010\n\u001A\u00020\u000B2\b\b\u0001\u0010\u0002\u001A\u00020\u0001H\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2={"integerResource", "", "id", "(ILandroidx/compose/runtime/Composer;I)I", "integerArrayResource", "", "(ILandroidx/compose/runtime/Composer;I)[I", "booleanResource", "", "(ILandroidx/compose/runtime/Composer;I)Z", "dimensionResource", "Landroidx/compose/ui/unit/Dp;", "(ILandroidx/compose/runtime/Composer;I)F", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PrimitiveResources_androidKt {
    public static final boolean booleanResource(int arg3, Composer arg4, int arg5) {
        int v1 = 0xE63A2F31;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(booleanResource)61@1806L7:PrimitiveResources.android.kt#ccshc7");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.ui.res.booleanResource (PrimitiveResources.android.kt:60)");
        }

        ProvidableCompositionLocal v5 = AndroidCompositionLocals_androidKt.getLocalResources();
        ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v5_1 = arg4.consume(((CompositionLocal)v5));
        ComposerKt.sourceInformationMarkerEnd(arg4);
        boolean v3 = ((Resources)v5_1).getBoolean(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public static final float dimensionResource(int arg3, Composer arg4, int arg5) {
        int v1 = 0x2FF10657;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(dimensionResource)73@2080L7,74@2121L7:PrimitiveResources.android.kt#ccshc7");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.ui.res.dimensionResource (PrimitiveResources.android.kt:72)");
        }

        ProvidableCompositionLocal v5 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v5_1 = arg4.consume(((CompositionLocal)v5));
        ComposerKt.sourceInformationMarkerEnd(arg4);
        ProvidableCompositionLocal v2 = AndroidCompositionLocals_androidKt.getLocalResources();
        ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v0 = arg4.consume(((CompositionLocal)v2));
        ComposerKt.sourceInformationMarkerEnd(arg4);
        float v3 = Dp.constructor-impl(((Resources)v0).getDimension(arg3) / ((Density)v5_1).getDensity());
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public static final int[] integerArrayResource(int arg3, Composer arg4, int arg5) {
        int v1 = 0xFA65CCAA;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(integerArrayResource)49@1544L7:PrimitiveResources.android.kt#ccshc7");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.ui.res.integerArrayResource (PrimitiveResources.android.kt:48)");
        }

        ProvidableCompositionLocal v5 = AndroidCompositionLocals_androidKt.getLocalResources();
        ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v5_1 = arg4.consume(((CompositionLocal)v5));
        ComposerKt.sourceInformationMarkerEnd(arg4);
        int[] v3 = ((Resources)v5_1).getIntArray(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public static final int integerResource(int arg3, Composer arg4, int arg5) {
        int v1 = 916701108;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(integerResource)37@1260L7:PrimitiveResources.android.kt#ccshc7");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.ui.res.integerResource (PrimitiveResources.android.kt:36)");
        }

        ProvidableCompositionLocal v5 = AndroidCompositionLocals_androidKt.getLocalResources();
        ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v5_1 = arg4.consume(((CompositionLocal)v5));
        ComposerKt.sourceInformationMarkerEnd(arg4);
        arg3 = ((Resources)v5_1).getInteger(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return arg3;
    }
}

