package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001A4\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0000¨\u0006\n"}, d2={"tapPressTextFieldModifier", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "onTap", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldPressGestureFilterKt {
    public static DisposableEffectResult $r8$lambda$_mTH2cLvy8nafp99RKgHfp0ZpmQ(MutableState arg0, MutableInteractionSource arg1, DisposableEffectScope arg2) {
        return TextFieldPressGestureFilterKt.tapPressTextFieldModifier$lambda$0$1$0(arg0, arg1, arg2);
    }

    public static final Modifier tapPressTextFieldModifier(Modifier arg0, MutableInteractionSource arg1, boolean arg2, Function1 arg3) {
        if(arg2) {
            arg0 = ComposedModifierKt.composed$default(arg0, null, new TextFieldPressGestureFilterKt$$ExternalSyntheticLambda0(arg3, arg1), 1, null);
        }

        return arg0;
    }

    public static Modifier tapPressTextFieldModifier$default(Modifier arg0, MutableInteractionSource arg1, boolean arg2, Function1 arg3, int arg4, Object arg5) {
        return TextFieldPressGestureFilterKt.tapPressTextFieldModifier(arg0, arg1, true, arg3);
    }

    static final Modifier tapPressTextFieldModifier$lambda$0(Function1 arg4, MutableInteractionSource arg5, Modifier arg6, Composer arg7, int arg8) {
        TextFieldPressGestureFilterKt$$ExternalSyntheticLambda1 v3_1;
        CoroutineScope v6_2;
        int v6 = 0xF9DFB8D5;
        arg7.startReplaceGroup(v6);
        ComposerKt.sourceInformation(arg7, "C40@1628L24,41@1690L58,42@1778L27,43@1854L343,43@1818L379,52@2251L1562:TextFieldPressGestureFilter.kt#423gt5");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v6, arg8, -1, "androidx.compose.foundation.text.tapPressTextFieldModifier.<anonymous> (TextFieldPressGestureFilter.kt:40)");
        }

        ComposerKt.sourceInformationMarkerStart(arg7, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart(arg7, 0x28C0FDC4, "CC(remember):Effects.kt#9igjgp");
        Object v6_1 = arg7.rememberedValue();
        if(v6_1 == Composer.Companion.getEmpty()) {
            v6_2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, arg7);
            arg7.updateRememberedValue(v6_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        ComposerKt.sourceInformationMarkerEnd(arg7);
        String v0 = "CC(remember):TextFieldPressGestureFilter.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg7, 0xD4E2CF, v0);
        Object v8 = arg7.rememberedValue();
        if(v8 == Composer.Companion.getEmpty()) {
            MutableState v8_1 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            arg7.updateRememberedValue(v8_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        State v4 = SnapshotStateKt.rememberUpdatedState(arg4, arg7, 0);
        ComposerKt.sourceInformationMarkerStart(arg7, 0xD4F86C, v0);
        boolean v2 = arg7.changed(arg5);
        Object v3 = arg7.rememberedValue();
        if((v2) || v3 == Composer.Companion.getEmpty()) {
            v3_1 = new TextFieldPressGestureFilterKt$$ExternalSyntheticLambda1(((MutableState)v8), arg5);
            arg7.updateRememberedValue(v3_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        EffectsKt.DisposableEffect(arg5, ((Function1)v3_1), arg7, 0);
        Companion v1 = Modifier.Companion;
        ComposerKt.sourceInformationMarkerStart(arg7, 0xD52ECF, v0);
        int v0_1 = arg7.changedInstance(v6_2) | arg7.changed(arg5) | arg7.changed(v4);
        Object v2_1 = arg7.rememberedValue();
        if(v0_1 != 0 || v2_1 == Composer.Companion.getEmpty()) {
            TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1 v2_2 = new TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1(v6_2, ((MutableState)v8), arg5, v4);
            arg7.updateRememberedValue(v2_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        Modifier v4_1 = SuspendingPointerInputFilterKt.pointerInput(((Modifier)v1), arg5, ((PointerInputEventHandler)v2_1));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg7.endReplaceGroup();
        return v4_1;
    }

    private static final DisposableEffectResult tapPressTextFieldModifier$lambda$0$1$0(MutableState arg0, MutableInteractionSource arg1, DisposableEffectScope arg2) {
        return new TextFieldPressGestureFilterKt$tapPressTextFieldModifier$lambda$0$1$0$$inlined$onDispose$1(arg0, arg1);
    }
}

