package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.CoreTextFieldKt;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextFieldDelegate;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.autofill.ContentDataType;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.autofill.FillableData;
import androidx.compose.ui.autofill.FillableData_androidKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteAllCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BW\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\n\u0012\u0006\u0010\f\u001A\u00020\n\u0012\u0006\u0010\r\u001A\u00020\u000E\u0012\u0006\u0010\u000F\u001A\u00020\u0010\u0012\u0006\u0010\u0011\u001A\u00020\u0012\u0012\u0006\u0010\u0013\u001A\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\f\u0010<\u001A\u00020=*\u00020>H\u0016JV\u0010?\u001A\u00020=2\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014J(\u0010@\u001A\u00020=2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010A\u001A\u00020B2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\nH\u0002R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER\u001A\u0010\u0007\u001A\u00020\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R\u001A\u0010\t\u001A\u00020\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001A\u0010\u000B\u001A\u00020\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\'\u0010$\"\u0004\b(\u0010&R\u001A\u0010\f\u001A\u00020\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010$\"\u0004\b)\u0010&R\u001A\u0010\r\u001A\u00020\u000EX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001A\u0010\u000F\u001A\u00020\u0010X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b.\u0010/\"\u0004\b0\u00101R\u001A\u0010\u0011\u001A\u00020\u0012X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b2\u00103\"\u0004\b4\u00105R\u001A\u0010\u0013\u001A\u00020\u0014X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b6\u00107\"\u0004\b8\u00109R\u0014\u0010:\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b;\u0010$¨\u0006C"}, d2={"Landroidx/compose/foundation/text/input/internal/CoreTextFieldSemanticsModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "transformedText", "Landroidx/compose/ui/text/input/TransformedText;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "readOnly", "", "enabled", "isPassword", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "<init>", "(Landroidx/compose/ui/text/input/TransformedText;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/LegacyTextFieldState;ZZZLandroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/ui/focus/FocusRequester;)V", "getTransformedText", "()Landroidx/compose/ui/text/input/TransformedText;", "setTransformedText", "(Landroidx/compose/ui/text/input/TransformedText;)V", "getValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "getState", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "setState", "(Landroidx/compose/foundation/text/LegacyTextFieldState;)V", "getReadOnly", "()Z", "setReadOnly", "(Z)V", "getEnabled", "setEnabled", "setPassword", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "setOffsetMapping", "(Landroidx/compose/ui/text/input/OffsetMapping;)V", "getManager", "()Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "setManager", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;)V", "getImeOptions", "()Landroidx/compose/ui/text/input/ImeOptions;", "setImeOptions", "(Landroidx/compose/ui/text/input/ImeOptions;)V", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "shouldMergeDescendantSemantics", "getShouldMergeDescendantSemantics", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "updateNodeSemantics", "handleTextUpdateFromSemantics", "text", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CoreTextFieldSemanticsModifierNode extends DelegatingNode implements SemanticsModifierNode {
    public static final int $stable = 8;
    private boolean enabled;
    private FocusRequester focusRequester;
    private ImeOptions imeOptions;
    private boolean isPassword;
    private TextFieldSelectionManager manager;
    private OffsetMapping offsetMapping;
    private boolean readOnly;
    private LegacyTextFieldState state;
    private TransformedText transformedText;
    private TextFieldValue value;

    static {
    }

    public CoreTextFieldSemanticsModifierNode(TransformedText arg1, TextFieldValue arg2, LegacyTextFieldState arg3, boolean arg4, boolean arg5, boolean arg6, OffsetMapping arg7, TextFieldSelectionManager arg8, ImeOptions arg9, FocusRequester arg10) {
        super();
        this.transformedText = arg1;
        this.value = arg2;
        this.state = arg3;
        this.readOnly = arg4;
        this.enabled = arg5;
        this.isPassword = arg6;
        this.offsetMapping = arg7;
        this.manager = arg8;
        this.imeOptions = arg9;
        this.focusRequester = arg10;
        arg8.setRequestAutofillAction$foundation(new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda4(this));
    }

    static final Unit _init_$lambda$0(CoreTextFieldSemanticsModifierNode arg0) {
        DelegatableNodeKt.requestAutofill(((DelegatableNode)arg0));
        return Unit.INSTANCE;
    }

    public void applySemantics(SemanticsPropertyReceiver arg10) {
        SemanticsPropertiesKt.setInputText(arg10, this.value.getAnnotatedString());
        SemanticsPropertiesKt.setEditableText(arg10, this.transformedText.getText());
        SemanticsPropertiesKt.setTextSelectionRange-FDrldGo(arg10, this.value.getSelection-d9O1mEE());
        SemanticsPropertiesKt.setContentDataType(arg10, ContentDataType.Companion.getText());
        FillableData v0 = FillableData_androidKt.createFromText(FillableData.Companion, this.value.getAnnotatedString());
        if(v0 != null) {
            SemanticsPropertiesKt.setFillableData(arg10, v0);
        }

        String v1 = null;
        SemanticsPropertiesKt.onFillData$default(arg10, v1, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda5(this), 1, v1);
        int v0_1 = this.imeOptions.getKeyboardType-PjHm6EE();
        if(KeyboardType.equals-impl0(v0_1, KeyboardType.Companion.getEmail-PjHm6EE())) {
            SemanticsPropertiesKt.setContentType(arg10, ContentType.Companion.getEmailAddress());
        }
        else {
            if(!KeyboardType.equals-impl0(v0_1, KeyboardType.Companion.getPassword-PjHm6EE())) {
                if(KeyboardType.equals-impl0(v0_1, KeyboardType.Companion.getNumberPassword-PjHm6EE())) {
                }
                else {
                    if(KeyboardType.equals-impl0(v0_1, KeyboardType.Companion.getPhone-PjHm6EE())) {
                        SemanticsPropertiesKt.setContentType(arg10, ContentType.Companion.getPhoneNumber());
                    }
                    else {
                    }

                    goto label_53;
                }
            }

            SemanticsPropertiesKt.setContentType(arg10, ContentType.Companion.getPassword());
        }

    label_53:
        if(!this.enabled) {
            SemanticsPropertiesKt.disabled(arg10);
        }

        if(this.isPassword) {
            SemanticsPropertiesKt.password(arg10);
        }

        boolean v0_2 = !this.enabled || (this.readOnly) ? false : true;
        SemanticsPropertiesKt.setEditable(arg10, v0_2);
        SemanticsPropertiesKt.getTextLayoutResult$default(arg10, v1, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda7(this), 1, v1);
        if(v0_2) {
            SemanticsPropertiesKt.setText$default(arg10, v1, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda8(this), 1, v1);
            SemanticsPropertiesKt.insertTextAtCursor$default(arg10, v1, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda9(this, arg10), 1, v1);
        }

        SemanticsPropertiesKt.setSelection$default(arg10, v1, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda10(this), 1, v1);
        SemanticsPropertyReceiver v3 = arg10;
        SemanticsPropertiesKt.onImeAction-9UiTYpY$default(v3, this.imeOptions.getImeAction-eUduSuo(), null, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda11(this), 2, null);
        SemanticsPropertiesKt.onClick$default(v3, v1, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda12(this), 1, v1);
        SemanticsPropertiesKt.onLongClick$default(v3, v1, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda1(this), 1, v1);
        if(!TextRange.getCollapsed-impl(this.value.getSelection-d9O1mEE()) && !this.isPassword) {
            SemanticsPropertiesKt.copyText$default(v3, v1, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda2(this), 1, v1);
            if((this.enabled) && !this.readOnly) {
                SemanticsPropertiesKt.cutText$default(v3, v1, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda3(this), 1, v1);
            }
        }

        if((this.enabled) && !this.readOnly) {
            SemanticsPropertiesKt.pasteText$default(v3, v1, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda6(this), 1, v1);
        }
    }

    static final boolean applySemantics$lambda$1(CoreTextFieldSemanticsModifierNode arg4, FillableData arg5) {
        arg4.state.setJustAutofilled(true);
        arg4.state.setAutofillHighlightOn(true);
        LegacyTextFieldState v0 = arg4.state;
        CharSequence v5 = arg5.getTextValue();
        Intrinsics.checkNotNull(v5, "null cannot be cast to non-null type kotlin.String");
        arg4.handleTextUpdateFromSemantics(v0, ((String)v5), arg4.readOnly, arg4.enabled);
        return 1;
    }

    static final boolean applySemantics$lambda$10(CoreTextFieldSemanticsModifierNode arg0) {
        arg0.manager.cut$foundation();
        return 1;
    }

    static final boolean applySemantics$lambda$11(CoreTextFieldSemanticsModifierNode arg0) {
        arg0.manager.paste$foundation();
        return 1;
    }

    static final boolean applySemantics$lambda$2(CoreTextFieldSemanticsModifierNode arg1, List arg2) {
        if(arg1.state.getLayoutResult() != null) {
            TextLayoutResultProxy v1 = arg1.state.getLayoutResult();
            Intrinsics.checkNotNull(v1);
            arg2.add(v1.getValue());
            return 1;
        }

        return 0;
    }

    static final boolean applySemantics$lambda$3(CoreTextFieldSemanticsModifierNode arg3, AnnotatedString arg4) {
        arg3.handleTextUpdateFromSemantics(arg3.state, arg4.getText(), arg3.readOnly, arg3.enabled);
        return 1;
    }

    static final boolean applySemantics$lambda$4(CoreTextFieldSemanticsModifierNode arg9, SemanticsPropertyReceiver arg10, AnnotatedString arg11) {
        if(!arg9.readOnly) {
            if(!arg9.enabled) {
            }
            else {
                TextInputSession v10 = arg9.state.getInputSession();
                if(v10 != null) {
                    TextFieldDelegate.Companion.onEditCommand$foundation(CollectionsKt.listOf(new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(arg11, 1)}), arg9.state.getProcessor(), arg9.state.getOnValueChange(), v10);
                }
                else {
                    arg9.state.getOnValueChange().invoke(new TextFieldValue(StringsKt.replaceRange(arg9.value.getText(), TextRange.getStart-impl(arg9.value.getSelection-d9O1mEE()), TextRange.getEnd-impl(arg9.value.getSelection-d9O1mEE()), arg11).toString(), TextRangeKt.TextRange(TextRange.getStart-impl(arg9.value.getSelection-d9O1mEE()) + arg11.length()), null, 4, null));
                }

                return 1;
            }
        }

        return 0;
    }

    static final boolean applySemantics$lambda$5(CoreTextFieldSemanticsModifierNode arg8, int arg9, int arg10, boolean arg11) {
        if(arg11) {
        }
        else {
            arg9 = arg8.offsetMapping.transformedToOriginal(arg9);
        }

        if(arg11) {
        }
        else {
            arg10 = arg8.offsetMapping.transformedToOriginal(arg10);
        }

        if(!arg8.enabled) {
            return 0;
        }

        if(arg9 == TextRange.getStart-impl(arg8.value.getSelection-d9O1mEE()) && arg10 == TextRange.getEnd-impl(arg8.value.getSelection-d9O1mEE())) {
            return 0;
        }

        if(Math.min(arg9, arg10) >= 0 && Math.max(arg9, arg10) <= arg8.value.getAnnotatedString().length()) {
            if((arg11) || arg9 == arg10) {
                arg8.manager.exitSelectionMode$foundation();
            }
            else {
                TextFieldSelectionManager.enterSelectionMode$foundation$default(arg8.manager, false, 1, null);
            }

            arg8.state.getOnValueChange().invoke(new TextFieldValue(arg8.value.getAnnotatedString(), TextRangeKt.TextRange(arg9, arg10), null, 4, null));
            return 1;
        }

        arg8.manager.exitSelectionMode$foundation();
        return 0;
    }

    static final boolean applySemantics$lambda$6(CoreTextFieldSemanticsModifierNode arg1) {
        arg1.state.getOnImeActionPerformed().invoke(ImeAction.box-impl(arg1.imeOptions.getImeAction-eUduSuo()));
        return 1;
    }

    static final boolean applySemantics$lambda$7(CoreTextFieldSemanticsModifierNode arg3) {
        CoreTextFieldKt.tapToFocus(arg3.state, arg3.focusRequester, arg3.readOnly ^ 1);
        return 1;
    }

    static final boolean applySemantics$lambda$8(CoreTextFieldSemanticsModifierNode arg3) {
        TextFieldSelectionManager.enterSelectionMode$foundation$default(arg3.manager, false, 1, null);
        return 1;
    }

    static final boolean applySemantics$lambda$9(CoreTextFieldSemanticsModifierNode arg3) {
        TextFieldSelectionManager.copy$foundation$default(arg3.manager, false, 1, null);
        return 1;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final ImeOptions getImeOptions() {
        return this.imeOptions;
    }

    public final TextFieldSelectionManager getManager() {
        return this.manager;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final boolean getReadOnly() {
        return this.readOnly;
    }

    public boolean getShouldMergeDescendantSemantics() {
        return 1;
    }

    public final LegacyTextFieldState getState() {
        return this.state;
    }

    public final TransformedText getTransformedText() {
        return this.transformedText;
    }

    public final TextFieldValue getValue() {
        return this.value;
    }

    private final void handleTextUpdateFromSemantics(LegacyTextFieldState arg8, String arg9, boolean arg10, boolean arg11) {
        if(!arg10) {
            if(!arg11) {
            }
            else {
                TextInputSession v10 = arg8.getInputSession();
                if(v10 != null) {
                    TextFieldDelegate.Companion.onEditCommand$foundation(CollectionsKt.listOf(new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(arg9, 1)}), arg8.getProcessor(), arg8.getOnValueChange(), v10);
                    return;
                }
                else {
                    arg8.getOnValueChange().invoke(new TextFieldValue(arg9, TextRangeKt.TextRange(arg9.length()), null, 4, null));
                }
            }
        }
    }

    public final boolean isPassword() {
        return this.isPassword;
    }

    public final void setEnabled(boolean arg1) {
        this.enabled = arg1;
    }

    public final void setFocusRequester(FocusRequester arg1) {
        this.focusRequester = arg1;
    }

    public final void setImeOptions(ImeOptions arg1) {
        this.imeOptions = arg1;
    }

    public final void setManager(TextFieldSelectionManager arg1) {
        this.manager = arg1;
    }

    public final void setOffsetMapping(OffsetMapping arg1) {
        this.offsetMapping = arg1;
    }

    public final void setPassword(boolean arg1) {
        this.isPassword = arg1;
    }

    public final void setReadOnly(boolean arg1) {
        this.readOnly = arg1;
    }

    public final void setState(LegacyTextFieldState arg1) {
        this.state = arg1;
    }

    public final void setTransformedText(TransformedText arg1) {
        this.transformedText = arg1;
    }

    public final void setValue(TextFieldValue arg1) {
        this.value = arg1;
    }

    public final void updateNodeSemantics(TransformedText arg11, TextFieldValue arg12, LegacyTextFieldState arg13, boolean arg14, boolean arg15, boolean arg16, OffsetMapping arg17, TextFieldSelectionManager arg18, ImeOptions arg19, FocusRequester arg20) {
        boolean v0 = arg15;
        TextFieldSelectionManager v1 = arg18;
        ImeOptions v2 = arg19;
        boolean v3 = this.enabled;
        int v4 = 1;
        int v6 = !v3 || (this.readOnly) ? 0 : 1;
        boolean v7 = this.isPassword;
        ImeOptions v8 = this.imeOptions;
        TextFieldSelectionManager v9 = this.manager;
        if(!v0 || (arg14)) {
            v4 = 0;
        }
        else {
        }

        this.transformedText = arg11;
        this.value = arg12;
        this.state = arg13;
        this.readOnly = arg14;
        this.enabled = v0;
        this.offsetMapping = arg17;
        this.manager = v1;
        this.imeOptions = v2;
        this.focusRequester = arg20;
        if(v0 != v3 || v4 != v6 || !Intrinsics.areEqual(v2, v8) || arg16 != v7 || !TextRange.getCollapsed-impl(arg12.getSelection-d9O1mEE())) {
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }

        if(!Intrinsics.areEqual(v1, v9)) {
            v1.setRequestAutofillAction$foundation(new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0(this));
        }
    }

    static final Unit updateNodeSemantics$lambda$0(CoreTextFieldSemanticsModifierNode arg0) {
        DelegatableNodeKt.requestAutofill(((DelegatableNode)arg0));
        return Unit.INSTANCE;
    }
}

