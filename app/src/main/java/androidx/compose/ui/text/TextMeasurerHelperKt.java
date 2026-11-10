package androidx.compose.ui.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0017\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0005\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"DefaultCacheSize", "", "rememberTextMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "cacheSize", "(ILandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/text/TextMeasurer;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextMeasurerHelperKt {
    private static final int DefaultCacheSize = 8;

    static {
    }

    public static final TextMeasurer rememberTextMeasurer(int arg6, Composer arg7, int arg8, int arg9) {
        int v1 = 0x5BAE9057;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(rememberTextMeasurer)42@1995L7,43@2034L7,44@2089L7,46@2109L151:TextMeasurerHelper.kt#ruzxt2");
        int v0 = 1;
        if((arg9 & 1) != 0) {
            arg6 = TextMeasurerHelperKt.DefaultCacheSize;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.ui.text.rememberTextMeasurer (TextMeasurerHelper.kt:41)");
        }

        ProvidableCompositionLocal v9 = CompositionLocalsKt.getLocalFontFamilyResolver();
        ComposerKt.sourceInformationMarkerStart(arg7, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v9_1 = arg7.consume(((CompositionLocal)v9));
        ComposerKt.sourceInformationMarkerEnd(arg7);
        ProvidableCompositionLocal v3 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg7, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v3_1 = arg7.consume(((CompositionLocal)v3));
        ComposerKt.sourceInformationMarkerEnd(arg7);
        ProvidableCompositionLocal v4 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(arg7, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v1_1 = arg7.consume(((CompositionLocal)v4));
        ComposerKt.sourceInformationMarkerEnd(arg7);
        ComposerKt.sourceInformationMarkerStart(arg7, 0x2A4BF58E, "CC(remember):TextMeasurerHelper.kt#9igjgp");
        int v2 = arg7.changed(v9_1) | arg7.changed(v3_1) | arg7.changed(v1_1.ordinal());
        int v5 = 4;
        if((arg8 & 14 ^ 6) <= v5 || !arg7.changed(arg6)) {
            if((arg8 & 6) == v5) {
            }
            else {
                v0 = 0;
            }
        }

        arg8 = v2 | v0;
        Object v0_1 = arg7.rememberedValue();
        if(arg8 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            TextMeasurer v0_2 = new TextMeasurer(((Resolver)v9_1), ((Density)v3_1), ((LayoutDirection)v1_1), arg6);
            arg7.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        return ((TextMeasurer)v0_1);
    }
}

