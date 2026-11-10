package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u000E\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0018\u0010\u0013\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\n0\u00142\u0012\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\n0\u0014H\u0016J\b\u0010\u000E\u001A\u00020\nH\u0016J\u001E\u0010\u000E\u001A\u00020\n2\u0014\u0010\u0019\u001A\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014H\u0002J\b\u0010\u001A\u001A\u00020\nH\u0016J\u001A\u0010\u001B\u001A\u00020\n2\b\u0010\u001C\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u001D\u001A\u00020\u0010H\u0016J\u0010\u0010\u001E\u001A\u00020\n2\u0006\u0010\u001F\u001A\u00020 H\u0016JD\u0010!\u001A\u00020\n2\u0006\u0010\"\u001A\u00020\u00102\u0006\u0010#\u001A\u00020$2\u0006\u0010%\u001A\u00020&2\u0012\u0010\'\u001A\u000E\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\n0\u00142\u0006\u0010)\u001A\u00020 2\u0006\u0010*\u001A\u00020 H\u0016J\b\u0010+\u001A\u00020\nH\u0016R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006,"}, d2={"Landroidx/compose/foundation/text/input/internal/AndroidLegacyPlatformTextInputServiceAdapter;", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;", "<init>", "()V", "job", "Lkotlinx/coroutines/Job;", "currentRequest", "Landroidx/compose/foundation/text/input/internal/LegacyTextInputMethodRequest;", "backingStylusHandwritingTrigger", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "stylusHandwritingTrigger", "getStylusHandwritingTrigger", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "startInput", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onEditCommand", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/input/EditCommand;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "initializeRequest", "stopInput", "updateState", "oldValue", "newValue", "notifyFocusedRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "updateTextLayoutResult", "textFieldValue", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "textFieldToRootTransform", "Landroidx/compose/ui/graphics/Matrix;", "innerTextFieldBounds", "decorationBoxBounds", "startStylusHandwriting", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidLegacyPlatformTextInputServiceAdapter extends LegacyPlatformTextInputServiceAdapter {
    public static final int $stable = 8;
    private MutableSharedFlow backingStylusHandwritingTrigger;
    private LegacyTextInputMethodRequest currentRequest;
    private Job job;

    static {
    }

    public AndroidLegacyPlatformTextInputServiceAdapter() {
        super();
    }

    public static final MutableSharedFlow access$getStylusHandwritingTrigger(AndroidLegacyPlatformTextInputServiceAdapter arg0) {
        return arg0.getStylusHandwritingTrigger();
    }

    public static final void access$setCurrentRequest$p(AndroidLegacyPlatformTextInputServiceAdapter arg0, LegacyTextInputMethodRequest arg1) {
        arg0.currentRequest = arg1;
    }

    public static final void access$startInput$localToScreen(LegacyPlatformTextInputNode arg0, float[] arg1) {
        AndroidLegacyPlatformTextInputServiceAdapter.startInput$localToScreen(arg0, arg1);
    }

    private final MutableSharedFlow getStylusHandwritingTrigger() {
        MutableSharedFlow v0 = this.backingStylusHandwritingTrigger;
        if(v0 != null) {
            return v0;
        }

        MutableSharedFlow v1 = null;
        if(!StylusHandwriting_androidKt.isStylusHandwritingSupported()) {
            return v1;
        }

        v0 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_LATEST, 2, v1);
        this.backingStylusHandwritingTrigger = v0;
        return v0;
    }

    public void notifyFocusedRect(Rect arg1) {
        LegacyTextInputMethodRequest v0 = this.currentRequest;
        if(v0 != null) {
            v0.notifyFocusedRect(arg1);
        }
    }

    private final void startInput(Function1 arg4) {
        LegacyPlatformTextInputNode v0 = this.getTextInputModifierNode();
        if(v0 == null) {
            return;
        }

        this.job = v0.launchTextInputSession(new AndroidLegacyPlatformTextInputServiceAdapter$startInput$2(arg4, this, v0, null));
    }

    public void startInput() {
        this.startInput(null);
    }

    public void startInput(TextFieldValue arg7, ImeOptions arg8, Function1 arg9, Function1 arg10) {
        this.startInput(new AndroidLegacyPlatformTextInputServiceAdapter$$ExternalSyntheticLambda0(arg7, this, arg8, arg9, arg10));
    }

    static final Unit startInput$lambda$0(TextFieldValue arg1, AndroidLegacyPlatformTextInputServiceAdapter arg2, ImeOptions arg3, Function1 arg4, Function1 arg5, LegacyTextInputMethodRequest arg6) {
        arg6.startInput(arg1, arg2.getTextInputModifierNode(), arg3, arg4, arg5);
        return Unit.INSTANCE;
    }

    private static final void startInput$localToScreen(LegacyPlatformTextInputNode arg1, float[] arg2) {
        LayoutCoordinates v1 = arg1.getLayoutCoordinates();
        if(v1 != null) {
            if(v1.isAttached()) {
            }
            else {
                v1 = null;
            }

            if(v1 == null) {
                return;
            }

            v1.transformToScreen-58bKbWc(arg2);
        }
    }

    public void startStylusHandwriting() {
        MutableSharedFlow v1 = this.getStylusHandwritingTrigger();
        if(v1 != null) {
            v1.tryEmit(Unit.INSTANCE);
        }
    }

    public void stopInput() {
        Job v0 = this.job;
        CancellationException v1 = null;
        if(v0 != null) {
            DefaultImpls.cancel$default(v0, v1, 1, v1);
        }

        this.job = ((Job)v1);
        MutableSharedFlow v3 = this.getStylusHandwritingTrigger();
        if(v3 != null) {
            v3.resetReplayCache();
        }
    }

    public void updateState(TextFieldValue arg1, TextFieldValue arg2) {
        LegacyTextInputMethodRequest v0 = this.currentRequest;
        if(v0 != null) {
            v0.updateState(arg1, arg2);
        }
    }

    public void updateTextLayoutResult(TextFieldValue arg1, OffsetMapping arg2, TextLayoutResult arg3, Function1 arg4, Rect arg5, Rect arg6) {
        LegacyTextInputMethodRequest v0 = this.currentRequest;
        if(v0 != null) {
            v0.updateTextLayoutResult(arg1, arg2, arg3, arg5, arg6);
        }
    }
}

