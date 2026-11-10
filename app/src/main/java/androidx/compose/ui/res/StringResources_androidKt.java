package androidx.compose.ui.res;

import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\u001A\u0017\u0010\u0000\u001A\u00020\u00012\b\b\u0001\u0010\u0002\u001A\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001A+\u0010\u0000\u001A\u00020\u00012\b\b\u0001\u0010\u0002\u001A\u00020\u00032\u0012\u0010\u0005\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001A\u001D\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0001\u0010\u0002\u001A\u00020\u0003H\u0007¢\u0006\u0002\u0010\n\u001A\u001F\u0010\u000B\u001A\u00020\u00012\b\b\u0001\u0010\u0002\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u0003H\u0007¢\u0006\u0002\u0010\r\u001A3\u0010\u000B\u001A\u00020\u00012\b\b\u0001\u0010\u0002\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u00032\u0012\u0010\u0005\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0007¢\u0006\u0002\u0010\u000E¨\u0006\u000F"}, d2={"stringResource", "", "id", "", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "formatArgs", "", "", "(I[Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "stringArrayResource", "(ILandroidx/compose/runtime/Composer;I)[Ljava/lang/String;", "pluralStringResource", "count", "(IILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "(II[Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class StringResources_androidKt {
    public static final String pluralStringResource(int arg3, int arg4, Composer arg5, int arg6) {
        int v1 = 0x6A60FE9A;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(pluralStringResource)P(1)72@2102L7:StringResources.android.kt#ccshc7");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.ui.res.pluralStringResource (StringResources.android.kt:71)");
        }

        ProvidableCompositionLocal v6 = AndroidCompositionLocals_androidKt.getLocalResources();
        ComposerKt.sourceInformationMarkerStart(arg5, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v6_1 = arg5.consume(((CompositionLocal)v6));
        ComposerKt.sourceInformationMarkerEnd(arg5);
        String v3 = ((Resources)v6_1).getQuantityString(arg3, arg4);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        return v3;
    }

    public static final String pluralStringResource(int arg3, int arg4, Object[] arg5, Composer arg6, int arg7) {
        int v1 = 0x1F2F822D;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(pluralStringResource)P(2)86@2549L7:StringResources.android.kt#ccshc7");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.compose.ui.res.pluralStringResource (StringResources.android.kt:85)");
        }

        ProvidableCompositionLocal v7 = AndroidCompositionLocals_androidKt.getLocalResources();
        ComposerKt.sourceInformationMarkerStart(arg6, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v7_1 = arg6.consume(((CompositionLocal)v7));
        ComposerKt.sourceInformationMarkerEnd(arg6);
        String v3 = ((Resources)v7_1).getQuantityString(arg3, arg4, Arrays.copyOf(arg5, arg5.length));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        return v3;
    }

    public static final String[] stringArrayResource(int arg3, Composer arg4, int arg5) {
        int v1 = 1562162650;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(stringArrayResource)59@1777L7:StringResources.android.kt#ccshc7");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.ui.res.stringArrayResource (StringResources.android.kt:58)");
        }

        ProvidableCompositionLocal v5 = AndroidCompositionLocals_androidKt.getLocalResources();
        ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v5_1 = arg4.consume(((CompositionLocal)v5));
        ComposerKt.sourceInformationMarkerEnd(arg4);
        String[] v3 = ((Resources)v5_1).getStringArray(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public static final String stringResource(int arg3, Composer arg4, int arg5) {
        int v1 = 0x48F30C41;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(stringResource)34@1145L7:StringResources.android.kt#ccshc7");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.ui.res.stringResource (StringResources.android.kt:33)");
        }

        ProvidableCompositionLocal v5 = AndroidCompositionLocals_androidKt.getLocalResources();
        ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v5_1 = arg4.consume(((CompositionLocal)v5));
        ComposerKt.sourceInformationMarkerEnd(arg4);
        String v3 = ((Resources)v5_1).getString(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public static final String stringResource(int arg3, Object[] arg4, Composer arg5, int arg6) {
        int v1 = 2071230100;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(stringResource)P(1)47@1490L7:StringResources.android.kt#ccshc7");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.ui.res.stringResource (StringResources.android.kt:46)");
        }

        ProvidableCompositionLocal v6 = AndroidCompositionLocals_androidKt.getLocalResources();
        ComposerKt.sourceInformationMarkerStart(arg5, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v6_1 = arg5.consume(((CompositionLocal)v6));
        ComposerKt.sourceInformationMarkerEnd(arg5);
        String v3 = ((Resources)v6_1).getString(arg3, Arrays.copyOf(arg4, arg4.length));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        return v3;
    }
}

