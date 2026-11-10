package androidx.compose.ui.res;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.font.AndroidTypeface_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.LoadedFontFamily;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.font.Typeface;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0015\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u0004H\u0007¢\u0006\u0002\u0010\b\u001A\u0018\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0004H\u0003\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001C\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"cacheLock", "Ljava/lang/Object;", "syncLoadedTypefaces", "", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/Typeface;", "fontResource", "fontFamily", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/font/Typeface;", "fontResourceFromContext", "context", "Landroid/content/Context;", "a", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FontResources_androidKt {
    private static final Object cacheLock;
    private static final Map syncLoadedTypefaces;

    static {
        FontResources_androidKt.cacheLock = new Object();
        FontResources_androidKt.syncLoadedTypefaces = new LinkedHashMap();
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Prefer to preload fonts using FontFamily.Resolver.", replaceWith="<_subannotation>") public static final Typeface fontResource(FontFamily arg3, Composer arg4, int arg5) {
        int v1 = 0xF4A02609;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(fontResource)52@1896L7:FontResources.android.kt#ccshc7");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.ui.res.fontResource (FontResources.android.kt:51)");
        }

        ProvidableCompositionLocal v5 = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v5_1 = arg4.consume(((CompositionLocal)v5));
        ComposerKt.sourceInformationMarkerEnd(arg4);
        Typeface v3 = FontResources_androidKt.fontResourceFromContext(((Context)v5_1), arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Prefer to preload fonts using FontFamily.Resolver.", replaceWith="<_subannotation>") private static final Typeface fontResourceFromContext(Context arg5, FontFamily arg6) {
        Typeface v4_1;
        int v1 = 4;
        List v2 = null;
        if(!(arg6 instanceof SystemFontFamily)) {
            if((arg6 instanceof LoadedFontFamily)) {
            }
            else {
                return AndroidTypeface_androidKt.Typeface$default(arg5, arg6, v2, v1, v2);
            }
        }

        Object v0 = FontResources_androidKt.cacheLock;
        __monitor_enter(v0);
        try {
            Map v3 = FontResources_androidKt.syncLoadedTypefaces;
            Object v4 = v3.get(arg6);
            if(v4 == null) {
                v4_1 = AndroidTypeface_androidKt.Typeface$default(arg5, arg6, v2, v1, v2);
                v3.put(arg6, v4_1);
            }

            __monitor_exit(v0);
            return v4_1;
        }
        catch(Throwable v5) {
            __monitor_exit(v0);
            throw v5;
        }
    }
}

