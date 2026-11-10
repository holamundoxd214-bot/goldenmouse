package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\u001A\u001C\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\u0010\u0000\u001A\u0004\u0018\u00010\u0004\"\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u000E\u0010\t\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000B\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"indication", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "Landroidx/compose/foundation/Indication;", "LocalIndication", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalIndication", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "RememberUpdatedInstanceDeprecationMessage", "", "IndicationInstanceDeprecationMessage", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class IndicationKt {
    private static final String IndicationInstanceDeprecationMessage = "IndicationInstance has been deprecated along with the rememberUpdatedInstance that returns it. Indication implementations should instead use Modifier.Node APIs, and should be returned from IndicationNodeFactory#create. For a migration guide and background information, please visit developer.android.com";
    private static final ProvidableCompositionLocal LocalIndication = null;
    private static final String RememberUpdatedInstanceDeprecationMessage = "rememberUpdatedInstance has been deprecated - implementers should instead implement IndicationNodeFactory#create for improved performance and efficiency. Callers should check if the Indication is an IndicationNodeFactory, and call that API instead. For a migration guide and background information, please visit developer.android.com";

    static {
        IndicationKt.LocalIndication = CompositionLocalKt.compositionLocalOf$default(null, new IndicationKt$$ExternalSyntheticLambda0(), 1, null);
    }

    static final Indication LocalIndication$lambda$0() {
        return DefaultDebugIndication.INSTANCE;
    }

    public static final ProvidableCompositionLocal getLocalIndication() {
        return IndicationKt.LocalIndication;
    }

    public static final Modifier indication(Modifier arg2, InteractionSource arg3, Indication arg4) {
        Function1 v0_1;
        if(arg4 == null) {
            return arg2;
        }

        if((arg4 instanceof IndicationNodeFactory)) {
            return arg2.then(new IndicationModifierElement(arg3, ((IndicationNodeFactory)arg4)));
        }

        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            IndicationKt$indication$$inlined$debugInspectorInfo$1 v0 = new IndicationKt$indication$$inlined$debugInspectorInfo$1(arg3, arg4);
        }
        else {
            v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return ComposedModifierKt.composed(arg2, v0_1, new IndicationKt$$ExternalSyntheticLambda1(arg4, arg3));
    }

    static final Modifier indication$lambda$1(Indication arg2, InteractionSource arg3, Modifier arg4, Composer arg5, int arg6) {
        int v4 = 0xEAE6CFBB;
        arg5.startReplaceGroup(v4);
        ComposerKt.sourceInformation(arg5, "C177@8952L42,178@9007L51:Indication.kt#71ulvw");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v4, arg6, -1, "androidx.compose.foundation.indication.<anonymous> (Indication.kt:176)");
        }

        IndicationInstance v2 = arg2.rememberUpdatedInstance(arg3, arg5, 0);
        ComposerKt.sourceInformationMarkerStart(arg5, 0xCC71DE6E, "CC(remember):Indication.kt#9igjgp");
        boolean v3 = arg5.changed(v2);
        Object v4_1 = arg5.rememberedValue();
        if((v3) || v4_1 == Composer.Companion.getEmpty()) {
            IndicationModifier v4_2 = new IndicationModifier(v2);
            arg5.updateRememberedValue(v4_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg5.endReplaceGroup();
        return ((Modifier)v4_1);
    }
}

