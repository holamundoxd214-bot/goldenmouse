package androidx.compose.foundation.selection;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A=\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0002\b\n\u001AG\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\f2\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\r\u001AO\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\u0010\u000B\u001A\u0004\u0018\u00010\f2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0004\u001A\u00020\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\u0010¨\u0006\u0011"}, d2={"selectable", "Landroidx/compose/ui/Modifier;", "selected", "", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "selectable-XHw0xAI", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectable-oSLSa3U", "indication", "Landroidx/compose/foundation/Indication;", "selectable-O2vRcR0", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SelectableKt {
    public static final Modifier selectable-O2vRcR0(Modifier arg11, boolean arg12, MutableInteractionSource arg13, Indication arg14, boolean arg15, Role arg16, Function0 arg17) {
        Modifier v1_1;
        SelectableElement v1;
        if((arg14 instanceof IndicationNodeFactory)) {
            v1 = new SelectableElement(arg12, arg13, arg14, false, arg15, arg16, arg17, null);
        }
        else if(arg14 == null) {
            v1 = new SelectableElement(arg12, arg13, null, false, arg15, arg16, arg17, null);
        }
        else if(arg13 != null) {
            v1_1 = IndicationKt.indication(Modifier.Companion, arg13, arg14).then(new SelectableElement(arg12, arg13, null, false, arg15, arg16, arg17, null));
        }
        else {
            v1_1 = ComposedModifierKt.composed$default(Modifier.Companion, null, new SelectableKt$selectable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1(arg14, arg12, arg15, arg16, arg17), 1, null);
        }

        return arg11.then(((Modifier)v1));
    }

    public static Modifier selectable-O2vRcR0$default(Modifier arg7, boolean arg8, MutableInteractionSource arg9, Indication arg10, boolean arg11, Role arg12, Function0 arg13, int arg14, Object arg15) {
        if((arg14 & 16) != 0) {
            arg12 = null;
        }

        return SelectableKt.selectable-O2vRcR0(arg7, arg8, arg9, arg10, true, arg12, arg13);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Replaced with new overload that only supports IndicationNodeFactory instances inside LocalIndication, and does not use composed") public static final Modifier selectable-XHw0xAI(Modifier arg2, boolean arg3, boolean arg4, Role arg5, Function0 arg6) {
        SelectableKt$selectable-XHw0xAI$$inlined$debugInspectorInfo$1 v0;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v0 = new SelectableKt$selectable-XHw0xAI$$inlined$debugInspectorInfo$1(arg3, arg4, arg5, arg6);
        }
        else {
            Function1 v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return ComposedModifierKt.composed(arg2, ((Function1)v0), new SelectableKt$$ExternalSyntheticLambda0(arg3, arg4, arg5, arg6));
    }

    public static Modifier selectable-XHw0xAI$default(Modifier arg0, boolean arg1, boolean arg2, Role arg3, Function0 arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = null;
        }

        return SelectableKt.selectable-XHw0xAI(arg0, arg1, true, arg3, arg4);
    }

    public static final Modifier selectable-oSLSa3U(Modifier arg9, boolean arg10, boolean arg11, Role arg12, MutableInteractionSource arg13, Function0 arg14) {
        return arg9.then(new SelectableElement(arg10, arg13, null, true, arg11, arg12, arg14, null));
    }

    public static Modifier selectable-oSLSa3U$default(Modifier arg6, boolean arg7, boolean arg8, Role arg9, MutableInteractionSource arg10, Function0 arg11, int arg12, Object arg13) {
        Role v13 = null;
        Role v3 = (arg12 & 4) != 0 ? v13 : arg9;
        MutableInteractionSource v4 = (arg12 & 8) != 0 ? ((MutableInteractionSource)v13) : arg10;
        return SelectableKt.selectable-oSLSa3U(arg6, arg7, true, v3, v4, arg11);
    }

    static final Modifier selectable_XHw0xAI$lambda$1(boolean arg7, boolean arg8, Role arg9, Function0 arg10, Modifier arg11, Composer arg12, int arg13) {
        int v11 = 0x815D0778;
        arg12.startReplaceGroup(v11);
        ComposerKt.sourceInformation(arg12, "C82@3691L7:Selectable.kt#gro6r2");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v11, arg13, -1, "androidx.compose.foundation.selection.selectable.<anonymous> (Selectable.kt:82)");
        }

        ProvidableCompositionLocal v11_1 = IndicationKt.getLocalIndication();
        ComposerKt.sourceInformationMarkerStart(arg12, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v11_2 = arg12.consume(((CompositionLocal)v11_1));
        ComposerKt.sourceInformationMarkerEnd(arg12);
        Object v3 = v11_2;
        if((v3 instanceof IndicationNodeFactory)) {
            arg12.startReplaceGroup(0x28EA6A2F);
            arg12.endReplaceGroup();
            v11_2 = null;
        }
        else {
            arg12.startReplaceGroup(0x28EC7039);
            ComposerKt.sourceInformation(arg12, "91@4138L39");
            ComposerKt.sourceInformationMarkerStart(arg12, -1640413313, "CC(remember):Selectable.kt#9igjgp");
            v11_2 = arg12.rememberedValue();
            if(v11_2 == Composer.Companion.getEmpty()) {
                MutableInteractionSource v11_3 = InteractionSourceKt.MutableInteractionSource();
                arg12.updateRememberedValue(v11_3);
            }

            ComposerKt.sourceInformationMarkerEnd(arg12);
            arg12.endReplaceGroup();
        }

        Object v2 = v11_2;
        Modifier v7 = SelectableKt.selectable-O2vRcR0(Modifier.Companion, arg7, ((MutableInteractionSource)v2), ((Indication)v3), arg8, arg9, arg10);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg12.endReplaceGroup();
        return v7;
    }
}

