package androidx.compose.material3.internal;

import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.os.ConfigurationCompat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\u001A\u0017\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001A+\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0012\u0010\u0006\u001A\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH\u0001¢\u0006\u0004\b\t\u0010\n\u001A-\u0010\u000B\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0016\u0010\u0006\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\u0010\f¨\u0006\r"}, d2={"getString", "", "string", "Landroidx/compose/material3/internal/Strings;", "getString-2EP1pXo", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "formatArgs", "", "", "getString-qBjtwXw", "(I[Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "formatString", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class Strings_androidKt {
    public static final String formatString(String arg1, Object[] arg2) {
        arg2 = Arrays.copyOf(arg2, arg2.length);
        arg1 = String.format(arg1, Arrays.copyOf(arg2, arg2.length));
        Intrinsics.checkNotNullExpressionValue(arg1, "format(...)");
        return arg1;
    }

    public static final String getString-2EP1pXo(int arg3, Composer arg4, int arg5) {
        int v1 = 0xC9E5EFED;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(getString)N(string:c#material3.internal.Strings)31@1161L7,32@1202L7:Strings.android.kt#mqatfk");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.internal.getString (Strings.android.kt:30)");
        }

        ProvidableCompositionLocal v5 = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        arg4.consume(((CompositionLocal)v5));
        ComposerKt.sourceInformationMarkerEnd(arg4);
        v5 = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v5_1 = arg4.consume(((CompositionLocal)v5));
        ComposerKt.sourceInformationMarkerEnd(arg4);
        String v3 = ((Context)v5_1).getResources().getString(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public static final String getString-qBjtwXw(int arg3, Object[] arg4, Composer arg5, int arg6) {
        int v1 = 0xAAED9C00;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(getString)N(string:c#material3.internal.Strings,formatArgs)39@1395L17,41@1488L7:Strings.android.kt#mqatfk");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.material3.internal.getString (Strings.android.kt:38)");
        }

        String v3 = Strings_androidKt.getString-2EP1pXo(arg3, arg5, arg6 & 14);
        ProvidableCompositionLocal v6 = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(arg5, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v6_1 = arg5.consume(((CompositionLocal)v6));
        ComposerKt.sourceInformationMarkerEnd(arg5);
        Locale v6_2 = ConfigurationCompat.getLocales(((Configuration)v6_1)).get(0);
        if(v6_2 == null) {
            v6_2 = Locale.getDefault();
        }

        arg4 = Arrays.copyOf(arg4, arg4.length);
        v3 = String.format(v6_2, v3, Arrays.copyOf(arg4, arg4.length));
        Intrinsics.checkNotNullExpressionValue(v3, "format(...)");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        return v3;
    }
}

