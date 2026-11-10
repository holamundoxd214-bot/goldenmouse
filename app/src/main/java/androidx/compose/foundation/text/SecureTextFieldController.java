package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000E\u0010\u0016\u001A\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001A\u00020\u0015H\u0002R\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Landroidx/compose/foundation/text/SecureTextFieldController;", "", "obfuscationMaskState", "Landroidx/compose/runtime/State;", "", "<init>", "(Landroidx/compose/runtime/State;)V", "passwordInputTransformation", "Landroidx/compose/foundation/text/PasswordInputTransformation;", "getPasswordInputTransformation", "()Landroidx/compose/foundation/text/PasswordInputTransformation;", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "getCodepointTransformation", "()Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "focusChangeModifier", "Landroidx/compose/ui/Modifier;", "getFocusChangeModifier", "()Landroidx/compose/ui/Modifier;", "resetTimerSignal", "Lkotlinx/coroutines/channels/Channel;", "", "observeHideEvents", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleHide", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SecureTextFieldController {
    public static final int $stable = 8;
    private final CodepointTransformation codepointTransformation;
    private final Modifier focusChangeModifier;
    private final State obfuscationMaskState;
    private final PasswordInputTransformation passwordInputTransformation;
    private final Channel resetTimerSignal;

    static {
    }

    public SecureTextFieldController(State arg3) {
        super();
        this.obfuscationMaskState = arg3;
        this.passwordInputTransformation = new PasswordInputTransformation(new SecureTextFieldController$passwordInputTransformation$1(this));
        this.codepointTransformation = new SecureTextFieldController$$ExternalSyntheticLambda0(this);
        this.focusChangeModifier = FocusChangedModifierKt.onFocusChanged(Modifier.Companion, new SecureTextFieldController$$ExternalSyntheticLambda1(this));
        this.resetTimerSignal = ChannelKt.Channel$default(0x7FFFFFFF, null, null, 6, null);
    }

    public static final void access$scheduleHide(SecureTextFieldController arg0) {
        arg0.scheduleHide();
    }

    static final int codepointTransformation$lambda$0(SecureTextFieldController arg1, int arg2, int arg3) {
        if(arg2 == arg1.passwordInputTransformation.getRevealCodepointIndex$foundation()) {
            return arg3;
        }

        return arg1.obfuscationMaskState.getValue().charValue();
    }

    static final Unit focusChangeModifier$lambda$0(SecureTextFieldController arg0, FocusState arg1) {
        if(!arg1.isFocused()) {
            arg0.passwordInputTransformation.hide();
        }

        return Unit.INSTANCE;
    }

    public final CodepointTransformation getCodepointTransformation() {
        return this.codepointTransformation;
    }

    public final Modifier getFocusChangeModifier() {
        return this.focusChangeModifier;
    }

    public final PasswordInputTransformation getPasswordInputTransformation() {
        return this.passwordInputTransformation;
    }

    public final Object observeHideEvents(Continuation arg4) {
        Object v3 = FlowKt.collectLatest(FlowKt.consumeAsFlow(this.resetTimerSignal), new SecureTextFieldController$observeHideEvents$2(this, null), arg4);
        if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v3;
        }

        return Unit.INSTANCE;
    }

    private final void scheduleHide() {
        if(ChannelResult.isFailure-impl(this.resetTimerSignal.trySend-JP2dKIU(Unit.INSTANCE))) {
            this.passwordInputTransformation.hide();
        }
    }
}

