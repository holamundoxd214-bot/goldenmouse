package androidx.compose.ui.text.input;

import android.graphics.Rect;
import android.view.Choreographer;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.input.pointer.MatrixPositionCalculator;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;

@Deprecated(message="Only exists to support the legacy TextInputService APIs. It is not used by any Compose code. A copy of this class in foundation is used by the legacy BasicTextField.") @Metadata(d1={"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001:\u0001RB)\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\f\u001A\u00020\u0005¢\u0006\u0004\b\n\u0010\rJ\u0010\u00103\u001A\u0004\u0018\u0001042\u0006\u00105\u001A\u000206J\u0006\u00107\u001A\u00020\u0011JF\u00108\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001E\u001A\u00020\u001F2\u0018\u0010\u0012\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u00160\u00132\u0012\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\u0013H\u0016J\b\u00108\u001A\u00020\u0016H\u0016J\b\u00109\u001A\u00020\u0016H\u0016J\b\u0010:\u001A\u00020\u0016H\u0016J\b\u0010;\u001A\u00020\u0016H\u0016J\u0010\u0010<\u001A\u00020\u00162\u0006\u0010=\u001A\u000200H\u0002J\b\u0010>\u001A\u00020\u0016H\u0002J\u001A\u0010?\u001A\u00020\u00162\b\u0010@\u001A\u0004\u0018\u00010\u001A2\u0006\u0010A\u001A\u00020\u001AH\u0016J\u0010\u0010B\u001A\u00020\u00162\u0006\u0010C\u001A\u00020DH\u0017JD\u0010E\u001A\u00020\u00162\u0006\u0010F\u001A\u00020\u001A2\u0006\u0010G\u001A\u00020H2\u0006\u0010I\u001A\u00020J2\u0012\u0010K\u001A\u000E\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u00160\u00132\u0006\u0010M\u001A\u00020D2\u0006\u0010N\u001A\u00020DH\u0016J\b\u0010O\u001A\u00020\u0016H\u0002J\u0010\u0010P\u001A\u00020\u00162\u0006\u0010Q\u001A\u00020\u0011H\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R \u0010\u0012\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u0019\u001A\u00020\u001A@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u000E\u0010\u001E\u001A\u00020\u001FX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010 \u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!X\u0082\u000E¢\u0006\u0002\n\u0000R\u001B\u0010$\u001A\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001A\u0004\b&\u0010\'R\u0010\u0010*\u001A\u0004\u0018\u00010+X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010,\u001A\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001A\b\u0012\u0004\u0012\u0002000/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00101\u001A\u0004\u0018\u000102X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006S"}, d2={"Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "view", "Landroid/view/View;", "rootPositionCalculator", "Landroidx/compose/ui/input/pointer/MatrixPositionCalculator;", "inputMethodManager", "Landroidx/compose/ui/text/input/InputMethodManager;", "inputCommandProcessorExecutor", "Ljava/util/concurrent/Executor;", "<init>", "(Landroid/view/View;Landroidx/compose/ui/input/pointer/MatrixPositionCalculator;Landroidx/compose/ui/text/input/InputMethodManager;Ljava/util/concurrent/Executor;)V", "positionCalculator", "(Landroid/view/View;Landroidx/compose/ui/input/pointer/MatrixPositionCalculator;)V", "getView", "()Landroid/view/View;", "editorHasFocus", "", "onEditCommand", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/input/EditCommand;", "", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "state", "getState$ui", "()Landroidx/compose/ui/text/input/TextFieldValue;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "ics", "", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/ui/text/input/RecordingInputConnection;", "baseInputConnection", "Landroid/view/inputmethod/BaseInputConnection;", "getBaseInputConnection", "()Landroid/view/inputmethod/BaseInputConnection;", "baseInputConnection$delegate", "Lkotlin/Lazy;", "focusedRect", "Landroid/graphics/Rect;", "cursorAnchorInfoController", "Landroidx/compose/ui/text/input/CursorAnchorInfoController;", "textInputCommandQueue", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/text/input/TextInputServiceAndroid$TextInputCommand;", "frameCallback", "Ljava/lang/Runnable;", "createInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "isEditorFocused", "startInput", "stopInput", "showSoftwareKeyboard", "hideSoftwareKeyboard", "sendInputCommand", "command", "processInputCommands", "updateState", "oldValue", "newValue", "notifyFocusedRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "updateTextLayoutResult", "textFieldValue", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "textFieldToRootTransform", "Landroidx/compose/ui/graphics/Matrix;", "innerTextFieldBounds", "decorationBoxBounds", "restartInputImmediately", "setKeyboardVisibleImmediately", "visible", "TextInputCommand", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextInputServiceAndroid implements PlatformTextInputService {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/text/input/TextInputServiceAndroid$TextInputCommand;", "", "<init>", "(Ljava/lang/String;I)V", "StartInput", "StopInput", "ShowKeyboard", "HideKeyboard", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) enum TextInputCommand {
        public static final enum TextInputCommand HideKeyboard;
        public static final enum TextInputCommand ShowKeyboard;
        public static final enum TextInputCommand StartInput;
        public static final enum TextInputCommand StopInput;

        private static final TextInputCommand[] $values() {
            return new TextInputCommand[]{TextInputCommand.StartInput, TextInputCommand.StopInput, TextInputCommand.ShowKeyboard, TextInputCommand.HideKeyboard};
        }

        static {
            TextInputCommand.StartInput = new TextInputCommand("StartInput", 0);
            TextInputCommand.StopInput = new TextInputCommand("StopInput", 1);
            TextInputCommand.ShowKeyboard = new TextInputCommand("ShowKeyboard", 2);
            TextInputCommand.HideKeyboard = new TextInputCommand("HideKeyboard", 3);
            TextInputCommand[] v0 = TextInputCommand.$values();
            TextInputCommand.$VALUES = v0;
            TextInputCommand.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private TextInputCommand(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return TextInputCommand.$ENTRIES;
        }

        public static TextInputCommand valueOf(String arg1) {
            return Enum.valueOf(TextInputCommand.class, arg1);
        }

        public static TextInputCommand[] values() {
            return TextInputCommand.$VALUES.clone();
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[TextInputCommand.values().length];
            try {
                v0[TextInputCommand.StartInput.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[TextInputCommand.StopInput.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[TextInputCommand.ShowKeyboard.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[TextInputCommand.HideKeyboard.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 8;
    private final Lazy baseInputConnection$delegate;
    private final CursorAnchorInfoController cursorAnchorInfoController;
    private boolean editorHasFocus;
    private Rect focusedRect;
    private Runnable frameCallback;
    private List ics;
    private ImeOptions imeOptions;
    private final Executor inputCommandProcessorExecutor;
    private final InputMethodManager inputMethodManager;
    private Function1 onEditCommand;
    private Function1 onImeActionPerformed;
    private TextFieldValue state;
    private final MutableVector textInputCommandQueue;
    private final View view;

    static {
    }

    public TextInputServiceAndroid(View arg9, MatrixPositionCalculator arg10) {
        this(arg9, arg10, new InputMethodManagerImpl(arg9), null, 8, null);
    }

    public TextInputServiceAndroid(View arg1, MatrixPositionCalculator arg2, InputMethodManager arg3, Executor arg4, int arg5, DefaultConstructorMarker arg6) {
        if((arg5 & 8) != 0) {
            arg4 = TextInputServiceAndroid_androidKt.asExecutor(Choreographer.getInstance());
        }

        this(arg1, arg2, arg3, arg4);
    }

    public TextInputServiceAndroid(View arg8, MatrixPositionCalculator arg9, InputMethodManager arg10, Executor arg11) {
        super();
        this.view = arg8;
        this.inputMethodManager = arg10;
        this.inputCommandProcessorExecutor = arg11;
        this.onEditCommand = TextInputServiceAndroid$onEditCommand$1.INSTANCE;
        this.onImeActionPerformed = TextInputServiceAndroid$onImeActionPerformed$1.INSTANCE;
        this.state = new TextFieldValue("", TextRange.Companion.getZero-d9O1mEE(), null, 4, null);
        this.imeOptions = ImeOptions.Companion.getDefault();
        this.ics = new ArrayList();
        this.baseInputConnection$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new TextInputServiceAndroid$baseInputConnection$2(this));
        this.cursorAnchorInfoController = new CursorAnchorInfoController(arg9, arg10);
        this.textInputCommandQueue = new MutableVector(new TextInputCommand[16], 0);
    }

    public static final BaseInputConnection access$getBaseInputConnection(TextInputServiceAndroid arg0) {
        return arg0.getBaseInputConnection();
    }

    public static final CursorAnchorInfoController access$getCursorAnchorInfoController$p(TextInputServiceAndroid arg0) {
        return arg0.cursorAnchorInfoController;
    }

    public static final List access$getIcs$p(TextInputServiceAndroid arg0) {
        return arg0.ics;
    }

    public static final Function1 access$getOnEditCommand$p(TextInputServiceAndroid arg0) {
        return arg0.onEditCommand;
    }

    public static final Function1 access$getOnImeActionPerformed$p(TextInputServiceAndroid arg0) {
        return arg0.onImeActionPerformed;
    }

    public final InputConnection createInputConnection(EditorInfo arg4) {
        if(!this.editorHasFocus) {
            return null;
        }

        TextInputServiceAndroid_androidKt.update(arg4, this.imeOptions, this.state);
        TextInputServiceAndroid_androidKt.access$updateWithEmojiCompat(arg4);
        RecordingInputConnection v2 = new RecordingInputConnection(this.state, new TextInputServiceAndroid$createInputConnection$1(this), this.imeOptions.getAutoCorrect());
        this.ics.add(new WeakReference(v2));
        return ((InputConnection)v2);
    }

    private final BaseInputConnection getBaseInputConnection() {
        return this.baseInputConnection$delegate.getValue();
    }

    public final TextFieldValue getState$ui() {
        return this.state;
    }

    public final View getView() {
        return this.view;
    }

    public void hideSoftwareKeyboard() {
        this.sendInputCommand(TextInputCommand.HideKeyboard);
    }

    public final boolean isEditorFocused() {
        return this.editorHasFocus;
    }

    @Deprecated(message="This method should not be called, used BringIntoViewRequester instead.") public void notifyFocusedRect(androidx.compose.ui.geometry.Rect arg5) {
        this.focusedRect = new Rect(MathKt.roundToInt(arg5.getLeft()), MathKt.roundToInt(arg5.getTop()), MathKt.roundToInt(arg5.getRight()), MathKt.roundToInt(arg5.getBottom()));
        if(this.ics.isEmpty()) {
            Rect v5 = this.focusedRect;
            if(v5 != null) {
                this.view.requestRectangleOnScreen(new Rect(v5));
            }
        }
    }

    private final void processInputCommands() {
        if(!this.view.isFocused()) {
            View v0 = this.view.getRootView().findFocus();
            if(v0 != null && (v0.onCheckIsTextEditor())) {
                this.textInputCommandQueue.clear();
                return;
            }
        }

        ObjectRef v0_1 = new ObjectRef();
        ObjectRef v2 = new ObjectRef();
        MutableVector v3 = this.textInputCommandQueue;
        Object[] v4 = v3.content;
        int v3_1 = v3.getSize();
        int v6;
        for(v6 = 0; v6 < v3_1; ++v6) {
            TextInputServiceAndroid.processInputCommands$applyToState(v4[v6], v0_1, v2);
        }

        this.textInputCommandQueue.clear();
        if(Intrinsics.areEqual(v0_1.element, Boolean.valueOf(true))) {
            this.restartInputImmediately();
        }

        Object v1 = v2.element;
        if(v1 != null) {
            this.setKeyboardVisibleImmediately(((Boolean)v1).booleanValue());
        }

        if(Intrinsics.areEqual(v0_1.element, Boolean.valueOf(false))) {
            this.restartInputImmediately();
        }
    }

    private static final void processInputCommands$applyToState(TextInputCommand arg4, ObjectRef arg5, ObjectRef arg6) {
        int v0 = WhenMappings.$EnumSwitchMapping$0[arg4.ordinal()];
        boolean v1 = true;
        Boolean v2 = Boolean.valueOf(true);
        if(v0 != 1) {
            if(v0 != 2) {
                if(v0 != 3) {
                    if(v0 == 4) {
                    }
                    else {
                        throw new NoWhenBranchMatchedException();
                    }
                }

                if(!Intrinsics.areEqual(arg5.element, Boolean.valueOf(false))) {
                    if(arg4 == TextInputCommand.ShowKeyboard) {
                    }
                    else {
                        v1 = false;
                    }

                    arg6.element = Boolean.valueOf(v1);
                }

                return;
            }

            arg5.element = Boolean.valueOf(false);
            arg6.element = Boolean.valueOf(false);
            return;
        }

        arg5.element = v2;
        arg6.element = v2;
    }

    private final void restartInputImmediately() {
        this.inputMethodManager.restartInput();
    }

    private final void sendInputCommand(TextInputCommand arg2) {
        this.textInputCommandQueue.add(arg2);
        if(this.frameCallback == null) {
            TextInputServiceAndroid$$ExternalSyntheticLambda0 v2 = new TextInputServiceAndroid$$ExternalSyntheticLambda0(this);
            this.inputCommandProcessorExecutor.execute(((Runnable)v2));
            this.frameCallback = ((Runnable)v2);
        }
    }

    static final void sendInputCommand$lambda$0(TextInputServiceAndroid arg1) {
        arg1.frameCallback = null;
        arg1.processInputCommands();
    }

    private final void setKeyboardVisibleImmediately(boolean arg1) {
        InputMethodManager v0 = this.inputMethodManager;
        if(arg1) {
            v0.showSoftInput();
            return;
        }

        v0.hideSoftInput();
    }

    public void showSoftwareKeyboard() {
        this.sendInputCommand(TextInputCommand.ShowKeyboard);
    }

    public void startInput() {
        this.sendInputCommand(TextInputCommand.StartInput);
    }

    public void startInput(TextFieldValue arg2, ImeOptions arg3, Function1 arg4, Function1 arg5) {
        this.editorHasFocus = true;
        this.state = arg2;
        this.imeOptions = arg3;
        this.onEditCommand = arg4;
        this.onImeActionPerformed = arg5;
        this.sendInputCommand(TextInputCommand.StartInput);
    }

    public void stopInput() {
        this.editorHasFocus = false;
        this.onEditCommand = TextInputServiceAndroid$stopInput$1.INSTANCE;
        this.onImeActionPerformed = TextInputServiceAndroid$stopInput$2.INSTANCE;
        this.focusedRect = null;
        this.sendInputCommand(TextInputCommand.StopInput);
    }

    public void updateState(TextFieldValue arg7, TextFieldValue arg8) {
        int v1 = 0;
        int v0 = !TextRange.equals-impl0(this.state.getSelection-d9O1mEE(), arg8.getSelection-d9O1mEE()) || !Intrinsics.areEqual(this.state.getComposition-MzsxiRA(), arg8.getComposition-MzsxiRA()) ? 1 : 0;
        this.state = arg8;
        int v2 = this.ics.size();
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            Object v4 = this.ics.get(v3).get();
            if(v4 != null) {
                ((RecordingInputConnection)v4).setMTextFieldValue$ui(arg8);
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

    public void updateTextLayoutResult(TextFieldValue arg1, OffsetMapping arg2, TextLayoutResult arg3, Function1 arg4, androidx.compose.ui.geometry.Rect arg5, androidx.compose.ui.geometry.Rect arg6) {
        this.cursorAnchorInfoController.updateTextLayoutResult(arg1, arg2, arg3, arg4, arg5, arg6);
    }
}

