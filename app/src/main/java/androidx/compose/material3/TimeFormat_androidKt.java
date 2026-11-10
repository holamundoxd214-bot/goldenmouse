package androidx.compose.material3;

import android.content.Context;
import android.text.format.DateFormat;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\"\u0014\u0010\u0000\u001A\u00020\u00018AX\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0000\u0010\u0002¨\u0006\u0003"}, d2={"is24HourFormat", "", "(Landroidx/compose/runtime/Composer;I)Z", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TimeFormat_androidKt {
    public static final boolean is24HourFormat(Composer arg3, int arg4) {
        int v1 = 0xC60333F9;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(<get-is24HourFormat>)24@966L7:TimeFormat.android.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.material3.<get-is24HourFormat> (TimeFormat.android.kt:24)");
        }

        ProvidableCompositionLocal v4 = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v4_1 = arg3.consume(((CompositionLocal)v4));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        boolean v4_2 = DateFormat.is24HourFormat(((Context)v4_1));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v4_2;
    }
}

