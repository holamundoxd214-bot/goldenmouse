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
import androidx.compose.ui.state.ToggleableState;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001AC\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0002\b\n\u001AM\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\f2\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\r\u001AU\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\u0010\u000B\u001A\u0004\u0018\u00010\f2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0004\u001A\u00020\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\u0010\u001A=\u0010\u0011\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u00132\b\b\u0002\u0010\u0004\u001A\u00020\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\t0\u0015H\u0007¢\u0006\u0002\b\u0016\u001AG\u0010\u0011\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u00132\b\b\u0002\u0010\u0004\u001A\u00020\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\f2\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0017\u001AO\u0010\u0011\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u00132\b\u0010\u000B\u001A\u0004\u0018\u00010\f2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0004\u001A\u00020\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0018¨\u0006\u0019"}, d2={"toggleable", "Landroidx/compose/ui/Modifier;", "value", "", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", "onValueChange", "Lkotlin/Function1;", "", "toggleable-XHw0xAI", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "toggleable-oSLSa3U", "indication", "Landroidx/compose/foundation/Indication;", "toggleable-O2vRcR0", "triStateToggleable", "state", "Landroidx/compose/ui/state/ToggleableState;", "onClick", "Lkotlin/Function0;", "triStateToggleable-XHw0xAI", "triStateToggleable-oSLSa3U", "triStateToggleable-O2vRcR0", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ToggleableKt {
    public static final Modifier toggleable-O2vRcR0(Modifier arg11, boolean arg12, MutableInteractionSource arg13, Indication arg14, boolean arg15, Role arg16, Function1 arg17) {
        Modifier v1_1;
        ToggleableElement v1;
        if((arg14 instanceof IndicationNodeFactory)) {
            v1 = new ToggleableElement(arg12, arg13, arg14, false, arg15, arg16, arg17, null);
        }
        else if(arg14 == null) {
            v1 = new ToggleableElement(arg12, arg13, null, false, arg15, arg16, arg17, null);
        }
        else if(arg13 != null) {
            v1_1 = IndicationKt.indication(Modifier.Companion, arg13, arg14).then(new ToggleableElement(arg12, arg13, null, false, arg15, arg16, arg17, null));
        }
        else {
            v1_1 = ComposedModifierKt.composed$default(Modifier.Companion, null, new ToggleableKt$toggleable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1(arg14, arg12, arg15, arg16, arg17), 1, null);
        }

        return arg11.then(((Modifier)v1));
    }

    public static Modifier toggleable-O2vRcR0$default(Modifier arg7, boolean arg8, MutableInteractionSource arg9, Indication arg10, boolean arg11, Role arg12, Function1 arg13, int arg14, Object arg15) {
        if((arg14 & 16) != 0) {
            arg12 = null;
        }

        return ToggleableKt.toggleable-O2vRcR0(arg7, arg8, arg9, arg10, true, arg12, arg13);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Replaced with new overload that only supports IndicationNodeFactory instances inside LocalIndication, and does not use composed") public static final Modifier toggleable-XHw0xAI(Modifier arg2, boolean arg3, boolean arg4, Role arg5, Function1 arg6) {
        ToggleableKt$toggleable-XHw0xAI$$inlined$debugInspectorInfo$1 v0;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v0 = new ToggleableKt$toggleable-XHw0xAI$$inlined$debugInspectorInfo$1(arg3, arg4, arg5, arg6);
        }
        else {
            Function1 v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return ComposedModifierKt.composed(arg2, ((Function1)v0), new ToggleableKt$$ExternalSyntheticLambda0(arg3, arg4, arg5, arg6));
    }

    public static Modifier toggleable-XHw0xAI$default(Modifier arg0, boolean arg1, boolean arg2, Role arg3, Function1 arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = null;
        }

        return ToggleableKt.toggleable-XHw0xAI(arg0, arg1, true, arg3, arg4);
    }

    public static final Modifier toggleable-oSLSa3U(Modifier arg9, boolean arg10, boolean arg11, Role arg12, MutableInteractionSource arg13, Function1 arg14) {
        return arg9.then(new ToggleableElement(arg10, arg13, null, true, arg11, arg12, arg14, null));
    }

    public static Modifier toggleable-oSLSa3U$default(Modifier arg6, boolean arg7, boolean arg8, Role arg9, MutableInteractionSource arg10, Function1 arg11, int arg12, Object arg13) {
        Role v13 = null;
        Role v3 = (arg12 & 4) != 0 ? v13 : arg9;
        MutableInteractionSource v4 = (arg12 & 8) != 0 ? ((MutableInteractionSource)v13) : arg10;
        return ToggleableKt.toggleable-oSLSa3U(arg6, arg7, true, v3, v4, arg11);
    }

    static final Modifier toggleable_XHw0xAI$lambda$1(boolean arg7, boolean arg8, Role arg9, Function1 arg10, Modifier arg11, Composer arg12, int arg13) {
        int v11 = 0x114E1E09;
        arg12.startReplaceGroup(v11);
        ComposerKt.sourceInformation(arg12, "C86@3831L7:Toggleable.kt#gro6r2");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v11, arg13, -1, "androidx.compose.foundation.selection.toggleable.<anonymous> (Toggleable.kt:86)");
        }

        ProvidableCompositionLocal v11_1 = IndicationKt.getLocalIndication();
        ComposerKt.sourceInformationMarkerStart(arg12, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v11_2 = arg12.consume(((CompositionLocal)v11_1));
        ComposerKt.sourceInformationMarkerEnd(arg12);
        Object v3 = v11_2;
        if((v3 instanceof IndicationNodeFactory)) {
            arg12.startReplaceGroup(0xD19B7DFE);
            arg12.endReplaceGroup();
            v11_2 = null;
        }
        else {
            arg12.startReplaceGroup(-778206200);
            ComposerKt.sourceInformation(arg12, "95@4278L39");
            ComposerKt.sourceInformationMarkerStart(arg12, 0xF63EFDD0, "CC(remember):Toggleable.kt#9igjgp");
            v11_2 = arg12.rememberedValue();
            if(v11_2 == Composer.Companion.getEmpty()) {
                MutableInteractionSource v11_3 = InteractionSourceKt.MutableInteractionSource();
                arg12.updateRememberedValue(v11_3);
            }

            ComposerKt.sourceInformationMarkerEnd(arg12);
            arg12.endReplaceGroup();
        }

        Object v2 = v11_2;
        Modifier v7 = ToggleableKt.toggleable-O2vRcR0(Modifier.Companion, arg7, ((MutableInteractionSource)v2), ((Indication)v3), arg8, arg9, arg10);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg12.endReplaceGroup();
        return v7;
    }

    public static final Modifier triStateToggleable-O2vRcR0(Modifier arg11, ToggleableState arg12, MutableInteractionSource arg13, Indication arg14, boolean arg15, Role arg16, Function0 arg17) {
        Modifier v1_1;
        TriStateToggleableElement v1;
        if((arg14 instanceof IndicationNodeFactory)) {
            v1 = new TriStateToggleableElement(arg12, arg13, arg14, false, arg15, arg16, arg17, null);
        }
        else if(arg14 == null) {
            v1 = new TriStateToggleableElement(arg12, arg13, null, false, arg15, arg16, arg17, null);
        }
        else if(arg13 != null) {
            v1_1 = IndicationKt.indication(Modifier.Companion, arg13, arg14).then(new TriStateToggleableElement(arg12, arg13, null, false, arg15, arg16, arg17, null));
        }
        else {
            v1_1 = ComposedModifierKt.composed$default(Modifier.Companion, null, new ToggleableKt$triStateToggleable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1(arg14, arg12, arg15, arg16, arg17), 1, null);
        }

        return arg11.then(((Modifier)v1));
    }

    public static Modifier triStateToggleable-O2vRcR0$default(Modifier arg7, ToggleableState arg8, MutableInteractionSource arg9, Indication arg10, boolean arg11, Role arg12, Function0 arg13, int arg14, Object arg15) {
        if((arg14 & 16) != 0) {
            arg12 = null;
        }

        return ToggleableKt.triStateToggleable-O2vRcR0(arg7, arg8, arg9, arg10, true, arg12, arg13);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Replaced with new overload that only supports IndicationNodeFactory instances inside LocalIndication, and does not use composed") public static final Modifier triStateToggleable-XHw0xAI(Modifier arg2, ToggleableState arg3, boolean arg4, Role arg5, Function0 arg6) {
        Function1 v0_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            ToggleableKt$triStateToggleable-XHw0xAI$$inlined$debugInspectorInfo$1 v0 = new ToggleableKt$triStateToggleable-XHw0xAI$$inlined$debugInspectorInfo$1(arg3, arg4, arg5, arg6);
        }
        else {
            v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return ComposedModifierKt.composed(arg2, v0_1, new ToggleableKt$$ExternalSyntheticLambda1(arg3, arg4, arg5, arg6));
    }

    public static Modifier triStateToggleable-XHw0xAI$default(Modifier arg0, ToggleableState arg1, boolean arg2, Role arg3, Function0 arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = null;
        }

        return ToggleableKt.triStateToggleable-XHw0xAI(arg0, arg1, true, arg3, arg4);
    }

    public static final Modifier triStateToggleable-oSLSa3U(Modifier arg9, ToggleableState arg10, boolean arg11, Role arg12, MutableInteractionSource arg13, Function0 arg14) {
        return arg9.then(new TriStateToggleableElement(arg10, arg13, null, true, arg11, arg12, arg14, null));
    }

    public static Modifier triStateToggleable-oSLSa3U$default(Modifier arg6, ToggleableState arg7, boolean arg8, Role arg9, MutableInteractionSource arg10, Function0 arg11, int arg12, Object arg13) {
        Role v13 = null;
        Role v3 = (arg12 & 4) != 0 ? v13 : arg9;
        MutableInteractionSource v4 = (arg12 & 8) != 0 ? ((MutableInteractionSource)v13) : arg10;
        return ToggleableKt.triStateToggleable-oSLSa3U(arg6, arg7, true, v3, v4, arg11);
    }

    static final Modifier triStateToggleable_XHw0xAI$lambda$1(ToggleableState arg7, boolean arg8, Role arg9, Function0 arg10, Modifier arg11, Composer arg12, int arg13) {
        int v11 = -1808118329;
        arg12.startReplaceGroup(v11);
        ComposerKt.sourceInformation(arg12, "C393@17019L7:Toggleable.kt#gro6r2");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v11, arg13, -1, "androidx.compose.foundation.selection.triStateToggleable.<anonymous> (Toggleable.kt:393)");
        }

        ProvidableCompositionLocal v11_1 = IndicationKt.getLocalIndication();
        ComposerKt.sourceInformationMarkerStart(arg12, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v11_2 = arg12.consume(((CompositionLocal)v11_1));
        ComposerKt.sourceInformationMarkerEnd(arg12);
        Object v3 = v11_2;
        if((v3 instanceof IndicationNodeFactory)) {
            arg12.startReplaceGroup(0x6CE34D80);
            arg12.endReplaceGroup();
            v11_2 = null;
        }
        else {
            arg12.startReplaceGroup(0x6CE5538A);
            ComposerKt.sourceInformation(arg12, "402@17466L39");
            ComposerKt.sourceInformationMarkerStart(arg12, 1860056590, "CC(remember):Toggleable.kt#9igjgp");
            v11_2 = arg12.rememberedValue();
            if(v11_2 == Composer.Companion.getEmpty()) {
                MutableInteractionSource v11_3 = InteractionSourceKt.MutableInteractionSource();
                arg12.updateRememberedValue(v11_3);
            }

            ComposerKt.sourceInformationMarkerEnd(arg12);
            arg12.endReplaceGroup();
        }

        Object v2 = v11_2;
        Modifier v7 = ToggleableKt.triStateToggleable-O2vRcR0(Modifier.Companion, arg7, ((MutableInteractionSource)v2), ((Indication)v3), arg8, arg9, arg10);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg12.endReplaceGroup();
        return v7;
    }
}

