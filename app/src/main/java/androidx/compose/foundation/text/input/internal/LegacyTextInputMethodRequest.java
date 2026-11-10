package androidx.compose.foundation.text.input.internal;

import android.graphics.Rect;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.platform.PlatformTextInputMethodRequest;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJN\u00102\u001A\u00020\u00072\u0006\u0010\u0019\u001A\u00020\u001A2\b\u00103\u001A\u0004\u0018\u0001042\u0006\u0010\u001E\u001A\u00020\u001F2\u0018\u0010\u000E\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000F\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070\u0005J\u0010\u00105\u001A\u00020#2\u0006\u00106\u001A\u000207H\u0016J\u0018\u00108\u001A\u00020\u00072\b\u00109\u001A\u0004\u0018\u00010\u001A2\u0006\u0010:\u001A\u00020\u001AJ\u000E\u0010;\u001A\u00020\u00072\u0006\u0010<\u001A\u00020=J.\u0010>\u001A\u00020\u00072\u0006\u0010?\u001A\u00020\u001A2\u0006\u0010@\u001A\u00020A2\u0006\u0010B\u001A\u00020C2\u0006\u0010D\u001A\u00020=2\u0006\u0010E\u001A\u00020=J\b\u0010F\u001A\u00020\u0007H\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000E\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000F\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u0019\u001A\u00020\u001A@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u000E\u0010\u001E\u001A\u00020\u001FX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010 \u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!X\u0082\u000E¢\u0006\u0002\n\u0000R\u001B\u0010$\u001A\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001A\u0004\b&\u0010\'R\u001C\u0010*\u001A\u0004\u0018\u00010+X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000E\u00100\u001A\u000201X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2={"Landroidx/compose/foundation/text/input/internal/LegacyTextInputMethodRequest;", "Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;", "view", "Landroid/view/View;", "localToScreen", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Matrix;", "", "inputMethodManager", "Landroidx/compose/foundation/text/input/internal/InputMethodManager;", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/input/internal/InputMethodManager;)V", "getView", "()Landroid/view/View;", "onEditCommand", "", "Landroidx/compose/ui/text/input/EditCommand;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "legacyTextFieldState", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "textFieldSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "state", "getState", "()Landroidx/compose/ui/text/input/TextFieldValue;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "ics", "", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/foundation/text/input/internal/RecordingInputConnection;", "baseInputConnection", "Landroid/view/inputmethod/BaseInputConnection;", "getBaseInputConnection", "()Landroid/view/inputmethod/BaseInputConnection;", "baseInputConnection$delegate", "Lkotlin/Lazy;", "focusedRect", "Landroid/graphics/Rect;", "getFocusedRect$foundation", "()Landroid/graphics/Rect;", "setFocusedRect$foundation", "(Landroid/graphics/Rect;)V", "cursorAnchorInfoController", "Landroidx/compose/foundation/text/input/internal/LegacyCursorAnchorInfoController;", "startInput", "textInputNode", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter$LegacyPlatformTextInputNode;", "createInputConnection", "outAttributes", "Landroid/view/inputmethod/EditorInfo;", "updateState", "oldValue", "newValue", "notifyFocusedRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "updateTextLayoutResult", "textFieldValue", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldBounds", "decorationBoxBounds", "restartInputImmediately", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LegacyTextInputMethodRequest implements PlatformTextInputMethodRequest {
    public static final int $stable = 8;
    private final Lazy baseInputConnection$delegate;
    private final LegacyCursorAnchorInfoController cursorAnchorInfoController;
    private Rect focusedRect;
    private List ics;
    private ImeOptions imeOptions;
    private final InputMethodManager inputMethodManager;
    private LegacyTextFieldState legacyTextFieldState;
    private Function1 onEditCommand;
    private Function1 onImeActionPerformed;
    private TextFieldValue state;
    private TextFieldSelectionManager textFieldSelectionManager;
    private final View view;
    private ViewConfiguration viewConfiguration;

    static {
    }

    public LegacyTextInputMethodRequest(View arg8, Function1 arg9, InputMethodManager arg10) {
        super();
        this.view = arg8;
        this.inputMethodManager = arg10;
        this.onEditCommand = new LegacyTextInputMethodRequest$$ExternalSyntheticLambda0();
        this.onImeActionPerformed = new LegacyTextInputMethodRequest$$ExternalSyntheticLambda1();
        this.state = new TextFieldValue("", TextRange.Companion.getZero-d9O1mEE(), null, 4, null);
        this.imeOptions = ImeOptions.Companion.getDefault();
        this.ics = new ArrayList();
        this.baseInputConnection$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new LegacyTextInputMethodRequest$$ExternalSyntheticLambda2(this));
        this.cursorAnchorInfoController = new LegacyCursorAnchorInfoController(arg9, arg10);
    }

    public static final BaseInputConnection access$getBaseInputConnection(LegacyTextInputMethodRequest arg0) {
        return arg0.getBaseInputConnection();
    }

    public static final LegacyCursorAnchorInfoController access$getCursorAnchorInfoController$p(LegacyTextInputMethodRequest arg0) {
        return arg0.cursorAnchorInfoController;
    }

    public static final List access$getIcs$p(LegacyTextInputMethodRequest arg0) {
        return arg0.ics;
    }

    public static final Function1 access$getOnEditCommand$p(LegacyTextInputMethodRequest arg0) {
        return arg0.onEditCommand;
    }

    public static final Function1 access$getOnImeActionPerformed$p(LegacyTextInputMethodRequest arg0) {
        return arg0.onImeActionPerformed;
    }

    static final BaseInputConnection baseInputConnection_delegate$lambda$0(LegacyTextInputMethodRequest arg2) {
        return new BaseInputConnection(arg2.view, false);
    }

    public InputConnection createInputConnection(EditorInfo arg1) {
        return this.createInputConnection(arg1);
    }

    public RecordingInputConnection createInputConnection(EditorInfo arg10) {
        EditorInfo_androidKt.update-pLxbY9I$default(arg10, this.state.getText(), this.state.getSelection-d9O1mEE(), this.imeOptions, null, 8, null);
        LegacyPlatformTextInputServiceAdapter_androidKt.updateWithEmojiCompat(arg10);
        RecordingInputConnection v0 = new RecordingInputConnection(this.state, new LegacyTextInputMethodRequest$createInputConnection$1(this), this.imeOptions.getAutoCorrect(), this.legacyTextFieldState, this.textFieldSelectionManager, this.viewConfiguration);
        this.ics.add(new WeakReference(v0));
        return v0;
    }

    private final BaseInputConnection getBaseInputConnection() {
        return this.baseInputConnection$delegate.getValue();
    }

    public final Rect getFocusedRect$foundation() {
        return this.focusedRect;
    }

    public final TextFieldValue getState() {
        return this.state;
    }

    public final View getView() {
        return this.view;
    }

    public final void notifyFocusedRect(androidx.compose.ui.geometry.Rect arg5) {
        this.focusedRect = new Rect(MathKt.roundToInt(arg5.getLeft()), MathKt.roundToInt(arg5.getTop()), MathKt.roundToInt(arg5.getRight()), MathKt.roundToInt(arg5.getBottom()));
        if(this.ics.isEmpty()) {
            Rect v5 = this.focusedRect;
            if(v5 != null) {
                this.view.requestRectangleOnScreen(new Rect(v5));
            }
        }
    }

    static final Unit onEditCommand$lambda$0(List arg0) {
        return Unit.INSTANCE;
    }

    static final Unit onImeActionPerformed$lambda$0(ImeAction arg0) {
        return Unit.INSTANCE;
    }

    private final void restartInputImmediately() {
        this.inputMethodManager.restartInput();
    }

    public final void setFocusedRect$foundation(Rect arg1) {
        this.focusedRect = arg1;
    }

    public final void startInput(TextFieldValue arg1, LegacyPlatformTextInputNode arg2, ImeOptions arg3, Function1 arg4, Function1 arg5) {
        this.state = arg1;
        this.imeOptions = arg3;
        this.onEditCommand = arg4;
        this.onImeActionPerformed = arg5;
        ViewConfiguration v1 = null;
        LegacyTextFieldState v3 = arg2 != null ? arg2.getLegacyTextFieldState() : ((LegacyTextFieldState)v1);
        this.legacyTextFieldState = v3;
        TextFieldSelectionManager v3_1 = arg2 != null ? arg2.getTextFieldSelectionManager() : ((TextFieldSelectionManager)v1);
        this.textFieldSelectionManager = v3_1;
        if(arg2 != null) {
            v1 = arg2.getViewConfiguration();
        }

        this.viewConfiguration = v1;
    }

    public final void updateState(TextFieldValue arg7, TextFieldValue arg8) {
        int v1 = 0;
        int v0 = !TextRange.equals-impl0(this.state.getSelection-d9O1mEE(), arg8.getSelection-d9O1mEE()) || !Intrinsics.areEqual(this.state.getComposition-MzsxiRA(), arg8.getComposition-MzsxiRA()) ? 1 : 0;
        this.state = arg8;
        int v2 = this.ics.size();
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            Object v4 = this.ics.get(v3).get();
            if(v4 != null) {
                ((RecordingInputConnection)v4).setTextFieldValue$foundation(arg8);
            }
        }

        this.cursorAnchorInfoController.invalidate();
        if(!Intrinsics.areEqual(arg7, arg8)) {
            if(arg7 != null) {
                if(Intrinsics.areEqual(arg7.getText(), arg8.getText())) {
                    if(!TextRange.equals-impl0(arg7.getSelection-d9O1mEE(), arg8.getSelection-d9O1mEE())) {
                    }
                    else if(!Intrinsics.areEqual(arg7.getComposition-MzsxiRA(), arg8.getComposition-MzsxiRA())) {
                        goto label_65;
                    }

                    goto label_67;
                }

            label_65:
                this.restartInputImmediately();
                return;
            }

        label_67:
            int v7_1 = this.ics.size();
            while(v1 < v7_1) {
                Object v8_1 = this.ics.get(v1).get();
                if(v8_1 != null) {
                    ((RecordingInputConnection)v8_1).updateInputState(this.state, this.inputMethodManager);
                }

                ++v1;
            }
        }
        else if(v0 != 0) {
            InputMethodManager v7 = this.inputMethodManager;
            v0 = TextRange.getMin-impl(arg8.getSelection-d9O1mEE());
            int v8 = TextRange.getMax-impl(arg8.getSelection-d9O1mEE());
            TextRange v1_1 = this.state.getComposition-MzsxiRA();
            v2 = -1;
            v1 = v1_1 != null ? TextRange.getMin-impl(v1_1.unbox-impl()) : v2;
            TextRange v6 = this.state.getComposition-MzsxiRA();
            if(v6 != null) {
                v2 = TextRange.getMax-impl(v6.unbox-impl());
            }

            v7.updateSelection(v0, v8, v1, v2);
            return;
        }
    }

    public final void updateTextLayoutResult(TextFieldValue arg1, OffsetMapping arg2, TextLayoutResult arg3, androidx.compose.ui.geometry.Rect arg4, androidx.compose.ui.geometry.Rect arg5) {
        this.cursorAnchorInfoController.updateTextLayoutResult(arg1, arg2, arg3, arg4, arg5);
    }
}

