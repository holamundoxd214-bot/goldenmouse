package androidx.compose.material3.internal;

import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A2\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0011\u0010\u0006\u001A\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2={"ProvideContentColorTextStyle", "", "contentColor", "Landroidx/compose/ui/graphics/Color;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "ProvideContentColorTextStyle-3J-VO9M", "(JLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ProvideContentColorTextStyleKt {
    public static final void ProvideContentColorTextStyle-3J-VO9M(long arg7, TextStyle arg9, Function2 arg10, Composer arg11, int arg12) {
        int v3;
        int v1;
        int v0 = 0xD72CAA18;
        arg11 = arg11.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg11, "C(ProvideContentColorTextStyle)N(contentColor:c#ui.graphics.Color,textStyle,content)39@1424L7,40@1453L152:ProvideContentColorTextStyle.kt#mqatfk");
        int v2 = 2;
        if((arg12 & 6) == 0) {
            v1 = arg11.changed(arg7) ? 4 : v2;
            v1 |= arg12;
        }
        else {
            v1 = arg12;
        }

        if((arg12 & 0x30) == 0) {
            v3 = arg11.changed(arg9) ? 0x20 : 16;
            v1 |= v3;
        }

        if((arg12 & 0x180) == 0) {
            v3 = arg11.changedInstance(arg10) ? 0x100 : 0x80;
            v1 |= v3;
        }

        boolean v3_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg11.shouldExecute(v3_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.internal.ProvideContentColorTextStyle (ProvideContentColorTextStyle.kt:38)");
            }

            ProvidableCompositionLocal v0_1 = TextKt.getLocalTextStyle();
            ComposerKt.sourceInformationMarkerStart(arg11, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_2 = arg11.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(arg11);
            TextStyle v0_3 = ((TextStyle)v0_2).merge(arg9);
            ProvidedValue[] v2_1 = new ProvidedValue[v2];
            v2_1[0] = ContentColorKt.getLocalContentColor().provides(Color.box-impl(arg7));
            v2_1[1] = TextKt.getLocalTextStyle().provides(v0_3);
            CompositionLocalKt.CompositionLocalProvider(v2_1, arg10, arg11, ProvidedValue.$stable | v1 >> 3 & 0x70);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_72;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg11.skipToGroupEnd();
        }

    label_72:
        ScopeUpdateScope v11 = arg11.endRestartGroup();
        if(v11 != null) {
            v11.updateScope(new ProvideContentColorTextStyleKt$$ExternalSyntheticLambda0(arg7, arg9, arg10, arg12));
        }
    }

    static final Unit ProvideContentColorTextStyle_3J_VO9M$lambda$0(long arg6, TextStyle arg8, Function2 arg9, int arg10, Composer arg11, int arg12) {
        ProvideContentColorTextStyleKt.ProvideContentColorTextStyle-3J-VO9M(arg6, arg8, arg9, arg11, RecomposeScopeImplKt.updateChangedFlags(arg10 | 1));
        return Unit.INSTANCE;
    }
}

