package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\r\u0010\u0000\u001A\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2={"defaultTimePickerLayoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "(Landroidx/compose/runtime/Composer;I)I", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TimePicker_androidKt {
    public static final int defaultTimePickerLayoutType(Composer arg3, int arg4) {
        int v1 = 0xD500E250;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(defaultTimePickerLayoutType)26@977L7:TimePicker.android.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.material3.defaultTimePickerLayoutType (TimePicker.android.kt:26)");
        }

        ProvidableCompositionLocal v4 = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v4_1 = arg3.consume(((CompositionLocal)v4));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        arg4 = ((Configuration)v4_1).screenHeightDp < ((Configuration)v4_1).screenWidthDp ? TimePickerLayoutType.Companion.getHorizontal-QJTpgSE() : TimePickerLayoutType.Companion.getVertical-QJTpgSE();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return arg4;
    }
}

