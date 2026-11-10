package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextHighlightType;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.TextInclusionStrategy;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.SetSelectionCommand;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

@Metadata(d1={"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u000E\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0000¢\u0006\u0002\b\u0010J+\u0010\u0011\u001A\u00020\u0012*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00132\u0006\u0010\t\u001A\u00020\n2\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0000¢\u0006\u0002\b\u0016J,\u0010\u0017\u001A\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\t\u001A\u00020\n2\u000E\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u001C\u0010\u001A\u001A\u00020\r*\u00020\u00062\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\t\u001A\u00020\nH\u0002J\u001C\u0010\u001B\u001A\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001A\u00020\u001C2\u0006\u0010\t\u001A\u00020\nH\u0002J\u001C\u0010\u001D\u001A\u00020\r*\u00020\u00062\u0006\u0010\u0018\u001A\u00020\u001C2\u0006\u0010\t\u001A\u00020\nH\u0002J,\u0010\u001E\u001A\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001A\u00020\u001F2\u0006\u0010\t\u001A\u00020\n2\u000E\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u001C\u0010 \u001A\u00020\r*\u00020\u00062\u0006\u0010\u0018\u001A\u00020\u001F2\u0006\u0010\t\u001A\u00020\nH\u0002J\u001C\u0010!\u001A\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001A\u00020\"2\u0006\u0010\t\u001A\u00020\nH\u0002J\u001C\u0010#\u001A\u00020\r*\u00020\u00062\u0006\u0010\u0018\u001A\u00020\"2\u0006\u0010\t\u001A\u00020\nH\u0002J&\u0010$\u001A\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001A\u00020%2\u0006\u0010\t\u001A\u00020\n2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0002J&\u0010&\u001A\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001A\u00020\'2\u0006\u0010\t\u001A\u00020\n2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0002J&\u0010(\u001A\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001A\u00020)2\u0006\u0010\t\u001A\u00020\n2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0002J#\u0010*\u001A\u00020\r*\u00020\u00062\u0006\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020\u0012H\u0002¢\u0006\u0004\b.\u0010/J\u0014\u00100\u001A\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001A\u00020\bH\u0002J#\u00101\u001A\u00020\r*\u00020\u00062\u0006\u00102\u001A\u00020,2\u0006\u00103\u001A\u000204H\u0002¢\u0006\u0004\b5\u00106JA\u0010\u0004\u001A\u00020\u0005*\u0002072\u0006\u0010\u0018\u001A\u00020\b2\b\u00108\u001A\u0004\u0018\u0001092\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0000¢\u0006\u0002\b\u0010J-\u0010\u0011\u001A\u00020\u0012*\u0002072\u0006\u0010\u0018\u001A\u00020\u00132\b\u00108\u001A\u0004\u0018\u0001092\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0000¢\u0006\u0002\b\u0016J2\u0010\u0017\u001A\u00020\u0005*\u0002072\u0006\u0010\u0018\u001A\u00020\u00192\b\u0010=\u001A\u0004\u0018\u0001092\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J\u001E\u0010\u001A\u001A\u00020\r*\u0002072\u0006\u0010\u0018\u001A\u00020\u00192\b\u00108\u001A\u0004\u0018\u000109H\u0002J0\u0010\u001B\u001A\u00020\u0005*\u0002072\u0006\u0010\u0018\u001A\u00020\u001C2\u0006\u0010>\u001A\u00020?2\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J\u001E\u0010\u001D\u001A\u00020\r*\u0002072\u0006\u0010\u0018\u001A\u00020\u001C2\b\u00108\u001A\u0004\u0018\u000109H\u0002J2\u0010\u001E\u001A\u00020\u0005*\u0002072\u0006\u0010\u0018\u001A\u00020\u001F2\b\u0010=\u001A\u0004\u0018\u0001092\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J\u001E\u0010 \u001A\u00020\r*\u0002072\u0006\u0010\u0018\u001A\u00020\u001F2\b\u00108\u001A\u0004\u0018\u000109H\u0002J0\u0010!\u001A\u00020\u0005*\u0002072\u0006\u0010\u0018\u001A\u00020\"2\u0006\u0010>\u001A\u00020?2\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J\u001E\u0010#\u001A\u00020\r*\u0002072\u0006\u0010\u0018\u001A\u00020\"2\b\u00108\u001A\u0004\u0018\u000109H\u0002J:\u0010$\u001A\u00020\u0005*\u0002072\u0006\u0010\u0018\u001A\u00020%2\u0006\u0010>\u001A\u00020?2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J2\u0010&\u001A\u00020\u0005*\u0002072\u0006\u0010\u0018\u001A\u00020\'2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J:\u0010(\u001A\u00020\u0005*\u0002072\u0006\u0010\u0018\u001A\u00020)2\u0006\u0010>\u001A\u00020?2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J,\u0010@\u001A\u00020\r2\u0006\u0010A\u001A\u00020\u00052\u0006\u0010>\u001A\u00020B2\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J5\u0010C\u001A\u00020\r2\u0006\u00102\u001A\u00020,2\b\u0010=\u001A\u0004\u0018\u0001092\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002¢\u0006\u0004\bD\u0010EJ;\u0010F\u001A\u00020\r2\u0006\u00102\u001A\u00020,2\u0006\u0010>\u001A\u00020?2\u0006\u0010-\u001A\u00020\u00122\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002¢\u0006\u0004\bG\u0010HJ$\u0010I\u001A\u00020\u00052\u0006\u0010\u0018\u001A\u00020\b2\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J\u0013\u0010J\u001A\u00020K*\u00020\u0005H\u0002¢\u0006\u0004\bL\u0010M¨\u0006N"}, d2={"Landroidx/compose/foundation/text/input/internal/HandwritingGestureApi34;", "", "<init>", "()V", "performHandwritingGesture", "", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "handwritingGesture", "Landroid/view/inputmethod/HandwritingGesture;", "layoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "updateSelectionState", "Lkotlin/Function0;", "", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "performHandwritingGesture$foundation", "previewHandwritingGesture", "", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "previewHandwritingGesture$foundation", "performSelectGesture", "gesture", "Landroid/view/inputmethod/SelectGesture;", "previewSelectGesture", "performDeleteGesture", "Landroid/view/inputmethod/DeleteGesture;", "previewDeleteGesture", "performSelectRangeGesture", "Landroid/view/inputmethod/SelectRangeGesture;", "previewSelectRangeGesture", "performDeleteRangeGesture", "Landroid/view/inputmethod/DeleteRangeGesture;", "previewDeleteRangeGesture", "performJoinOrSplitGesture", "Landroid/view/inputmethod/JoinOrSplitGesture;", "performInsertGesture", "Landroid/view/inputmethod/InsertGesture;", "performRemoveSpaceGesture", "Landroid/view/inputmethod/RemoveSpaceGesture;", "performDeletion", "rangeInTransformedText", "Landroidx/compose/ui/text/TextRange;", "adjustRange", "performDeletion-Sb-Bc2M", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JZ)V", "fallback", "highlightRange", "range", "type", "Landroidx/compose/foundation/text/input/TextHighlightType;", "highlightRange-XJREzCE", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JI)V", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "textFieldSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "editCommandConsumer", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/EditCommand;", "textSelectionManager", "text", "Landroidx/compose/ui/text/AnnotatedString;", "performInsertionOnLegacyTextField", "offset", "", "performSelectionOnLegacyTextField", "performSelectionOnLegacyTextField-8ffj60Q", "(JLandroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function1;)V", "performDeletionOnLegacyTextField", "performDeletionOnLegacyTextField-vJH6DeI", "(JLandroidx/compose/ui/text/AnnotatedString;ZLkotlin/jvm/functions/Function1;)V", "fallbackOnLegacyTextField", "toTextGranularity", "Landroidx/compose/ui/text/TextGranularity;", "toTextGranularity-NUwxegE", "(I)I", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class HandwritingGestureApi34 {
    public static final int $stable;
    public static final HandwritingGestureApi34 INSTANCE;

    static {
        HandwritingGestureApi34.INSTANCE = new HandwritingGestureApi34();
    }

    private HandwritingGestureApi34() {
        super();
    }

    private final int fallback(TransformedTextFieldState arg8, HandwritingGesture arg9) {
        TextFieldState v7 = TransformedTextFieldState.access$getTextFieldState$p(arg8);
        InputTransformation v0 = TransformedTextFieldState.access$getInputTransformation$p(arg8);
        TextFieldEditUndoBehavior v1 = TextFieldEditUndoBehavior.MergeIfPossible;
        v7.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer v2 = v7.getMainBuffer$foundation();
        v2.clearHighlight$foundation();
        TransformedTextFieldState.access$updateWedgeAffinity(arg8, v2);
        v7.commitEditAsUser(v0, true, v1);
        String v7_1 = arg9.getFallbackText();
        if(v7_1 == null) {
            return 3;
        }

        TransformedTextFieldState.replaceSelectedText$default(arg8, v7_1, true, null, false, 12, null);
        return 5;
    }

    private final int fallbackOnLegacyTextField(HandwritingGesture arg2, Function1 arg3) {
        String v1 = arg2.getFallbackText();
        if(v1 == null) {
            return 3;
        }

        arg3.invoke(new CommitTextCommand(v1, 1));
        return 5;
    }

    private final void highlightRange-XJREzCE(TransformedTextFieldState arg1, long arg2, int arg4) {
        if(TextRange.getCollapsed-impl(arg2)) {
            TextFieldState v0 = TransformedTextFieldState.access$getTextFieldState$p(arg1);
            InputTransformation v2 = TransformedTextFieldState.access$getInputTransformation$p(arg1);
            TextFieldEditUndoBehavior v3 = TextFieldEditUndoBehavior.MergeIfPossible;
            v0.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
            TextFieldBuffer v4 = v0.getMainBuffer$foundation();
            v4.clearHighlight$foundation();
            TransformedTextFieldState.access$updateWedgeAffinity(arg1, v4);
            v0.commitEditAsUser(v2, true, v3);
            return;
        }

        arg1.highlightCharsIn-7RAjNK8(arg4, arg2);
    }

    private final int performDeleteGesture(LegacyTextFieldState arg10, DeleteGesture arg11, AnnotatedString arg12, Function1 arg13) {
        int v0 = this.toTextGranularity-NUwxegE(arg11.getGranularity());
        long v4 = HandwritingGesture_androidKt.access$getRangeForScreenRect-OH9lIzo(arg10, RectHelper_androidKt.toComposeRect(arg11.getDeletionArea()), v0, TextInclusionStrategy.Companion.getContainsCenter());
        if(TextRange.getCollapsed-impl(v4)) {
            return HandwritingGestureApi34.INSTANCE.fallbackOnLegacyTextField(((HandwritingGesture)arg11), arg13);
        }

        this.performDeletionOnLegacyTextField-vJH6DeI(v4, arg12, TextGranularity.equals-impl0(v0, TextGranularity.Companion.getWord-DRrd7Zo()), arg13);
        return 1;
    }

    private final int performDeleteGesture(TransformedTextFieldState arg4, DeleteGesture arg5, TextLayoutState arg6) {
        int v0 = this.toTextGranularity-NUwxegE(arg5.getGranularity());
        long v1 = HandwritingGesture_androidKt.access$getRangeForScreenRect-OH9lIzo(arg6, RectHelper_androidKt.toComposeRect(arg5.getDeletionArea()), v0, TextInclusionStrategy.Companion.getContainsCenter());
        if(TextRange.getCollapsed-impl(v1)) {
            return HandwritingGestureApi34.INSTANCE.fallback(arg4, ((HandwritingGesture)arg5));
        }

        this.performDeletion-Sb-Bc2M(arg4, v1, TextGranularity.equals-impl0(v0, TextGranularity.Companion.getWord-DRrd7Zo()));
        return 1;
    }

    private final int performDeleteRangeGesture(LegacyTextFieldState arg11, DeleteRangeGesture arg12, AnnotatedString arg13, Function1 arg14) {
        int v0 = this.toTextGranularity-NUwxegE(arg12.getGranularity());
        long v5 = HandwritingGesture_androidKt.access$getRangeForScreenRects-O048IG0(arg11, RectHelper_androidKt.toComposeRect(arg12.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(arg12.getDeletionEndArea()), v0, TextInclusionStrategy.Companion.getContainsCenter());
        if(TextRange.getCollapsed-impl(v5)) {
            return HandwritingGestureApi34.INSTANCE.fallbackOnLegacyTextField(((HandwritingGesture)arg12), arg14);
        }

        this.performDeletionOnLegacyTextField-vJH6DeI(v5, arg13, TextGranularity.equals-impl0(v0, TextGranularity.Companion.getWord-DRrd7Zo()), arg14);
        return 1;
    }

    private final int performDeleteRangeGesture(TransformedTextFieldState arg5, DeleteRangeGesture arg6, TextLayoutState arg7) {
        int v0 = this.toTextGranularity-NUwxegE(arg6.getGranularity());
        long v1 = HandwritingGesture_androidKt.access$getRangeForScreenRects-O048IG0(arg7, RectHelper_androidKt.toComposeRect(arg6.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(arg6.getDeletionEndArea()), v0, TextInclusionStrategy.Companion.getContainsCenter());
        if(TextRange.getCollapsed-impl(v1)) {
            return HandwritingGestureApi34.INSTANCE.fallback(arg5, ((HandwritingGesture)arg6));
        }

        this.performDeletion-Sb-Bc2M(arg5, v1, TextGranularity.equals-impl0(v0, TextGranularity.Companion.getWord-DRrd7Zo()));
        return 1;
    }

    private final void performDeletion-Sb-Bc2M(TransformedTextFieldState arg9, long arg10, boolean arg12) {
        if(arg12) {
            arg10 = HandwritingGesture_androidKt.access$adjustHandwritingDeleteGestureRange-72CqOWE(arg10, arg9.getVisualText());
        }

        TransformedTextFieldState.replaceText-M8tDOmk$default(arg9, "", arg10, null, false, 12, null);
    }

    private final void performDeletionOnLegacyTextField-vJH6DeI(long arg2, AnnotatedString arg4, boolean arg5, Function1 arg6) {
        if(arg5) {
            arg2 = HandwritingGesture_androidKt.access$adjustHandwritingDeleteGestureRange-72CqOWE(arg2, ((CharSequence)arg4));
        }

        arg6.invoke(HandwritingGesture_androidKt.access$compoundEditCommand(new EditCommand[]{new SetSelectionCommand(TextRange.getEnd-impl(arg2), TextRange.getEnd-impl(arg2)), new DeleteSurroundingTextCommand(TextRange.getLength-impl(arg2), 0)}));
    }

    public final int performHandwritingGesture$foundation(LegacyTextFieldState arg4, HandwritingGesture arg5, TextFieldSelectionManager arg6, ViewConfiguration arg7, Function1 arg8) {
        TextFieldSelectionManager v0 = arg6;
        AnnotatedString v6 = arg4.getUntransformedText();
        int v1 = 3;
        if(v6 == null) {
            return v1;
        }

        TextLayoutResultProxy v2 = arg4.getLayoutResult();
        if(v2 != null) {
            TextLayoutResult v2_1 = v2.getValue();
            if(v2_1 != null) {
                TextLayoutInput v2_2 = v2_1.getLayoutInput();
                if(v2_2 != null) {
                    AnnotatedString v2_3 = v2_2.getText();
                }
                else {
                    goto label_13;
                }
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            Object v2_4 = null;
        }

        if(!Intrinsics.areEqual(v6, v2_4)) {
            return v1;
        }

        if((arg5 instanceof SelectGesture)) {
            return this.performSelectGesture(arg4, ((SelectGesture)arg5), v0, arg8);
        }

        if((arg5 instanceof DeleteGesture)) {
            return this.performDeleteGesture(arg4, ((DeleteGesture)arg5), v6, arg8);
        }

        if((arg5 instanceof SelectRangeGesture)) {
            return this.performSelectRangeGesture(arg4, ((SelectRangeGesture)arg5), v0, arg8);
        }

        if((arg5 instanceof DeleteRangeGesture)) {
            return this.performDeleteRangeGesture(arg4, ((DeleteRangeGesture)arg5), v6, arg8);
        }

        if((arg5 instanceof JoinOrSplitGesture)) {
            return this.performJoinOrSplitGesture(arg4, ((JoinOrSplitGesture)arg5), v6, arg7, arg8);
        }

        if((arg5 instanceof InsertGesture)) {
            return this.performInsertGesture(arg4, ((InsertGesture)arg5), arg7, arg8);
        }

        if((arg5 instanceof RemoveSpaceGesture)) {
            return this.performRemoveSpaceGesture(arg4, ((RemoveSpaceGesture)arg5), v6, arg7, arg8);
        }

        return 2;
    }

    public final int performHandwritingGesture$foundation(TransformedTextFieldState arg2, HandwritingGesture arg3, TextLayoutState arg4, Function0 arg5, ViewConfiguration arg6) {
        if((arg3 instanceof SelectGesture)) {
            return this.performSelectGesture(arg2, ((SelectGesture)arg3), arg4, arg5);
        }

        if((arg3 instanceof DeleteGesture)) {
            return this.performDeleteGesture(arg2, ((DeleteGesture)arg3), arg4);
        }

        if((arg3 instanceof SelectRangeGesture)) {
            return this.performSelectRangeGesture(arg2, ((SelectRangeGesture)arg3), arg4, arg5);
        }

        if((arg3 instanceof DeleteRangeGesture)) {
            return this.performDeleteRangeGesture(arg2, ((DeleteRangeGesture)arg3), arg4);
        }

        if((arg3 instanceof JoinOrSplitGesture)) {
            return this.performJoinOrSplitGesture(arg2, ((JoinOrSplitGesture)arg3), arg4, arg6);
        }

        if((arg3 instanceof InsertGesture)) {
            return this.performInsertGesture(arg2, ((InsertGesture)arg3), arg4, arg6);
        }

        if((arg3 instanceof RemoveSpaceGesture)) {
            return this.performRemoveSpaceGesture(arg2, ((RemoveSpaceGesture)arg3), arg4, arg6);
        }

        return 2;
    }

    private final int performInsertGesture(LegacyTextFieldState arg3, InsertGesture arg4, ViewConfiguration arg5, Function1 arg6) {
        if(arg5 == null) {
            return this.fallbackOnLegacyTextField(((HandwritingGesture)arg4), arg6);
        }

        int v5 = HandwritingGesture_androidKt.access$getOffsetForHandwritingGesture-d-4ec7I(arg3, HandwritingGesture_androidKt.access$toOffset(arg4.getInsertionPoint()), arg5);
        if(v5 != -1) {
            TextLayoutResultProxy v3 = arg3.getLayoutResult();
            if(v3 != null) {
                TextLayoutResult v3_1 = v3.getValue();
                if(v3_1 != null && (HandwritingGesture_androidKt.access$isBiDiBoundary(v3_1, v5))) {
                    goto label_19;
                }
            }

            this.performInsertionOnLegacyTextField(v5, arg4.getTextToInsert(), arg6);
            return 1;
        }

    label_19:
        return this.fallbackOnLegacyTextField(((HandwritingGesture)arg4), arg6);
    }

    private final int performInsertGesture(TransformedTextFieldState arg9, InsertGesture arg10, TextLayoutState arg11, ViewConfiguration arg12) {
        int v11 = HandwritingGesture_androidKt.access$getOffsetForHandwritingGesture-d-4ec7I(arg11, HandwritingGesture_androidKt.access$toOffset(arg10.getInsertionPoint()), arg12);
        if(v11 == -1) {
            return this.fallback(arg9, ((HandwritingGesture)arg10));
        }

        TransformedTextFieldState.replaceText-M8tDOmk$default(arg9, arg10.getTextToInsert(), TextRangeKt.TextRange(v11), null, false, 12, null);
        return 1;
    }

    private final void performInsertionOnLegacyTextField(int arg2, String arg3, Function1 arg4) {
        arg4.invoke(HandwritingGesture_androidKt.access$compoundEditCommand(new EditCommand[]{new SetSelectionCommand(arg2, arg2), new CommitTextCommand(arg3, 1)}));
    }

    private final int performJoinOrSplitGesture(LegacyTextFieldState arg8, JoinOrSplitGesture arg9, AnnotatedString arg10, ViewConfiguration arg11, Function1 arg12) {
        if(arg11 == null) {
            return this.fallbackOnLegacyTextField(((HandwritingGesture)arg9), arg12);
        }

        int v11 = HandwritingGesture_androidKt.access$getOffsetForHandwritingGesture-d-4ec7I(arg8, HandwritingGesture_androidKt.access$toOffset(arg9.getJoinOrSplitPoint()), arg11);
        if(v11 != -1) {
            TextLayoutResultProxy v8 = arg8.getLayoutResult();
            if(v8 != null) {
                TextLayoutResult v8_1 = v8.getValue();
                if(v8_1 != null && (HandwritingGesture_androidKt.access$isBiDiBoundary(v8_1, v11))) {
                    goto label_30;
                }
            }

            long v2 = HandwritingGesture_androidKt.access$rangeOfWhitespaces(arg10, v11);
            if(TextRange.getCollapsed-impl(v2)) {
                this.performInsertionOnLegacyTextField(TextRange.getStart-impl(v2), " ", arg12);
            }
            else {
                this.performDeletionOnLegacyTextField-vJH6DeI(v2, arg10, false, arg12);
            }

            return 1;
        }

    label_30:
        return this.fallbackOnLegacyTextField(((HandwritingGesture)arg9), arg12);
    }

    private final int performJoinOrSplitGesture(TransformedTextFieldState arg10, JoinOrSplitGesture arg11, TextLayoutState arg12, ViewConfiguration arg13) {
        if(arg10.getOutputText() != arg10.getUntransformedText()) {
            return 3;
        }

        int v13 = HandwritingGesture_androidKt.access$getOffsetForHandwritingGesture-d-4ec7I(arg12, HandwritingGesture_androidKt.access$toOffset(arg11.getJoinOrSplitPoint()), arg13);
        if(v13 != -1) {
            TextLayoutResult v12 = arg12.getLayoutResult();
            if(v12 != null && (HandwritingGesture_androidKt.access$isBiDiBoundary(v12, v13))) {
                goto label_33;
            }

            long v3 = HandwritingGesture_androidKt.access$rangeOfWhitespaces(arg10.getVisualText(), v13);
            if(TextRange.getCollapsed-impl(v3)) {
                TransformedTextFieldState.replaceText-M8tDOmk$default(arg10, " ", v3, null, false, 12, null);
            }
            else {
                this.performDeletion-Sb-Bc2M(arg10, v3, false);
            }

            return 1;
        }

    label_33:
        return this.fallback(arg10, ((HandwritingGesture)arg11));
    }

    private final int performRemoveSpaceGesture(LegacyTextFieldState arg9, RemoveSpaceGesture arg10, AnnotatedString arg11, ViewConfiguration arg12, Function1 arg13) {
        TextLayoutResultProxy v0 = arg9.getLayoutResult();
        TextLayoutResult v0_1 = v0 != null ? v0.getValue() : null;
        long v0_2 = HandwritingGesture_androidKt.access$getRangeForRemoveSpaceGesture-5iVPX68(v0_1, HandwritingGesture_androidKt.access$toOffset(arg10.getStartPoint()), HandwritingGesture_androidKt.access$toOffset(arg10.getEndPoint()), arg9.getLayoutCoordinates(), arg12);
        if(TextRange.getCollapsed-impl(v0_2)) {
            return HandwritingGestureApi34.INSTANCE.fallbackOnLegacyTextField(((HandwritingGesture)arg10), arg13);
        }

        IntRef v9 = new IntRef();
        int v12 = -1;
        v9.element = v12;
        IntRef v2 = new IntRef();
        v2.element = v12;
        String v11 = new Regex("\\s+").replace(TextRangeKt.substring-FDrldGo(((CharSequence)arg11), v0_2), new HandwritingGestureApi34$$ExternalSyntheticLambda2(v9, v2));
        if(v9.element != v12) {
            if(v2.element == v12) {
            }
            else {
                int v8 = TextRange.getStart-impl(v0_2) + v9.element;
                int v10 = TextRange.getStart-impl(v0_2) + v2.element;
                String v9_1 = v11.substring(v9.element, v11.length() - (TextRange.getLength-impl(v0_2) - v2.element));
                Intrinsics.checkNotNullExpressionValue(v9_1, "substring(...)");
                arg13.invoke(HandwritingGesture_androidKt.access$compoundEditCommand(new EditCommand[]{new SetSelectionCommand(v8, v10), new CommitTextCommand(v9_1, 1)}));
                return 1;
            }
        }

        return this.fallbackOnLegacyTextField(((HandwritingGesture)arg10), arg13);
    }

    private final int performRemoveSpaceGesture(TransformedTextFieldState arg10, RemoveSpaceGesture arg11, TextLayoutState arg12, ViewConfiguration arg13) {
        long v1 = HandwritingGesture_androidKt.access$getRangeForRemoveSpaceGesture-5iVPX68(arg12.getLayoutResult(), HandwritingGesture_androidKt.access$toOffset(arg11.getStartPoint()), HandwritingGesture_androidKt.access$toOffset(arg11.getEndPoint()), arg12.getTextLayoutNodeCoordinates(), arg13);
        if(TextRange.getCollapsed-impl(v1)) {
            return HandwritingGestureApi34.INSTANCE.fallback(arg10, arg11);
        }

        IntRef v3 = new IntRef();
        int v4 = -1;
        v3.element = v4;
        IntRef v5 = new IntRef();
        v5.element = v4;
        String v6 = new Regex("\\s+").replace(TextRangeKt.substring-FDrldGo(arg10.getVisualText(), v1), new HandwritingGestureApi34$$ExternalSyntheticLambda0(v3, v5));
        if(v3.element != v4) {
            if(v5.element == v4) {
            }
            else {
                long v7 = TextRangeKt.TextRange(TextRange.getStart-impl(v1) + v3.element, TextRange.getStart-impl(v1) + v5.element);
                String v1_1 = v6.substring(v3.element, v6.length() - (TextRange.getLength-impl(v1) - v5.element));
                Intrinsics.checkNotNullExpressionValue(v1_1, "substring(...)");
                TransformedTextFieldState.replaceText-M8tDOmk$default(arg10, ((CharSequence)v1_1), v7, null, false, 12, null);
                return 1;
            }
        }

        return this.fallback(arg10, arg11);
    }

    static final CharSequence performRemoveSpaceGesture$lambda$1(IntRef arg2, IntRef arg3, MatchResult arg4) {
        if(arg2.element == -1) {
            arg2.element = arg4.getRange().getFirst();
        }

        arg3.element = arg4.getRange().getLast() + 1;
        return "";
    }

    static final CharSequence performRemoveSpaceGesture$lambda$3(IntRef arg2, IntRef arg3, MatchResult arg4) {
        if(arg2.element == -1) {
            arg2.element = arg4.getRange().getFirst();
        }

        arg3.element = arg4.getRange().getLast() + 1;
        return "";
    }

    private final int performSelectGesture(LegacyTextFieldState arg4, SelectGesture arg5, TextFieldSelectionManager arg6, Function1 arg7) {
        long v0 = HandwritingGesture_androidKt.access$getRangeForScreenRect-OH9lIzo(arg4, RectHelper_androidKt.toComposeRect(arg5.getSelectionArea()), this.toTextGranularity-NUwxegE(arg5.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
        if(TextRange.getCollapsed-impl(v0)) {
            return HandwritingGestureApi34.INSTANCE.fallbackOnLegacyTextField(((HandwritingGesture)arg5), arg7);
        }

        this.performSelectionOnLegacyTextField-8ffj60Q(v0, arg6, arg7);
        return 1;
    }

    private final int performSelectGesture(TransformedTextFieldState arg3, SelectGesture arg4, TextLayoutState arg5, Function0 arg6) {
        long v0 = HandwritingGesture_androidKt.access$getRangeForScreenRect-OH9lIzo(arg5, RectHelper_androidKt.toComposeRect(arg4.getSelectionArea()), this.toTextGranularity-NUwxegE(arg4.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
        if(TextRange.getCollapsed-impl(v0)) {
            return HandwritingGestureApi34.INSTANCE.fallback(arg3, ((HandwritingGesture)arg4));
        }

        arg3.selectCharsIn-5zc-tL8(v0);
        if(arg6 != null) {
            arg6.invoke();
        }

        return 1;
    }

    private final int performSelectRangeGesture(LegacyTextFieldState arg5, SelectRangeGesture arg6, TextFieldSelectionManager arg7, Function1 arg8) {
        long v0 = HandwritingGesture_androidKt.access$getRangeForScreenRects-O048IG0(arg5, RectHelper_androidKt.toComposeRect(arg6.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(arg6.getSelectionEndArea()), this.toTextGranularity-NUwxegE(arg6.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
        if(TextRange.getCollapsed-impl(v0)) {
            return HandwritingGestureApi34.INSTANCE.fallbackOnLegacyTextField(((HandwritingGesture)arg6), arg8);
        }

        this.performSelectionOnLegacyTextField-8ffj60Q(v0, arg7, arg8);
        return 1;
    }

    private final int performSelectRangeGesture(TransformedTextFieldState arg4, SelectRangeGesture arg5, TextLayoutState arg6, Function0 arg7) {
        long v0 = HandwritingGesture_androidKt.access$getRangeForScreenRects-O048IG0(arg6, RectHelper_androidKt.toComposeRect(arg5.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(arg5.getSelectionEndArea()), this.toTextGranularity-NUwxegE(arg5.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
        if(TextRange.getCollapsed-impl(v0)) {
            return HandwritingGestureApi34.INSTANCE.fallback(arg4, ((HandwritingGesture)arg5));
        }

        arg4.selectCharsIn-5zc-tL8(v0);
        if(arg7 != null) {
            arg7.invoke();
        }

        return 1;
    }

    private final void performSelectionOnLegacyTextField-8ffj60Q(long arg2, TextFieldSelectionManager arg4, Function1 arg5) {
        arg5.invoke(new SetSelectionCommand(TextRange.getStart-impl(arg2), TextRange.getEnd-impl(arg2)));
        if(arg4 != null) {
            arg4.enterSelectionMode$foundation(true);
        }
    }

    private final void previewDeleteGesture(LegacyTextFieldState arg2, DeleteGesture arg3, TextFieldSelectionManager arg4) {
        if(arg4 != null) {
            arg4.setDeletionPreviewHighlight-5zc-tL8$foundation(HandwritingGesture_androidKt.access$getRangeForScreenRect-OH9lIzo(arg2, RectHelper_androidKt.toComposeRect(arg3.getDeletionArea()), this.toTextGranularity-NUwxegE(arg3.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()));
        }
    }

    private final void previewDeleteGesture(TransformedTextFieldState arg3, DeleteGesture arg4, TextLayoutState arg5) {
        this.highlightRange-XJREzCE(arg3, HandwritingGesture_androidKt.access$getRangeForScreenRect-OH9lIzo(arg5, RectHelper_androidKt.toComposeRect(arg4.getDeletionArea()), this.toTextGranularity-NUwxegE(arg4.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()), TextHighlightType.Companion.getHandwritingDeletePreview-s-xJuwY());
    }

    private final void previewDeleteRangeGesture(LegacyTextFieldState arg3, DeleteRangeGesture arg4, TextFieldSelectionManager arg5) {
        if(arg5 != null) {
            arg5.setDeletionPreviewHighlight-5zc-tL8$foundation(HandwritingGesture_androidKt.access$getRangeForScreenRects-O048IG0(arg3, RectHelper_androidKt.toComposeRect(arg4.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(arg4.getDeletionEndArea()), this.toTextGranularity-NUwxegE(arg4.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()));
        }
    }

    private final void previewDeleteRangeGesture(TransformedTextFieldState arg4, DeleteRangeGesture arg5, TextLayoutState arg6) {
        this.highlightRange-XJREzCE(arg4, HandwritingGesture_androidKt.access$getRangeForScreenRects-O048IG0(arg6, RectHelper_androidKt.toComposeRect(arg5.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(arg5.getDeletionEndArea()), this.toTextGranularity-NUwxegE(arg5.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()), TextHighlightType.Companion.getHandwritingDeletePreview-s-xJuwY());
    }

    public final boolean previewHandwritingGesture$foundation(LegacyTextFieldState arg4, PreviewableHandwritingGesture arg5, TextFieldSelectionManager arg6, CancellationSignal arg7) {
        AnnotatedString v0 = arg4.getUntransformedText();
        if(v0 == null) {
            return 0;
        }

        TextLayoutResultProxy v2 = arg4.getLayoutResult();
        if(v2 != null) {
            TextLayoutResult v2_1 = v2.getValue();
            if(v2_1 != null) {
                TextLayoutInput v2_2 = v2_1.getLayoutInput();
                if(v2_2 != null) {
                    AnnotatedString v2_3 = v2_2.getText();
                }
                else {
                    goto label_12;
                }
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            Object v2_4 = null;
        }

        if(!Intrinsics.areEqual(v0, v2_3)) {
            return 0;
        }

        if((arg5 instanceof SelectGesture)) {
            this.previewSelectGesture(arg4, ((SelectGesture)arg5), arg6);
        }
        else if((arg5 instanceof DeleteGesture)) {
            this.previewDeleteGesture(arg4, ((DeleteGesture)arg5), arg6);
        }
        else if((arg5 instanceof SelectRangeGesture)) {
            this.previewSelectRangeGesture(arg4, ((SelectRangeGesture)arg5), arg6);
        }
        else if((arg5 instanceof DeleteRangeGesture)) {
            this.previewDeleteRangeGesture(arg4, ((DeleteRangeGesture)arg5), arg6);
        }
        else {
            return 0;
        }

        if(arg7 != null) {
            arg7.setOnCancelListener(new HandwritingGestureApi34$$ExternalSyntheticLambda3(arg6));
        }

        return 1;
    }

    public final boolean previewHandwritingGesture$foundation(TransformedTextFieldState arg2, PreviewableHandwritingGesture arg3, TextLayoutState arg4, CancellationSignal arg5) {
        if((arg3 instanceof SelectGesture)) {
            this.previewSelectGesture(arg2, ((SelectGesture)arg3), arg4);
        }
        else if((arg3 instanceof DeleteGesture)) {
            this.previewDeleteGesture(arg2, ((DeleteGesture)arg3), arg4);
        }
        else if((arg3 instanceof SelectRangeGesture)) {
            this.previewSelectRangeGesture(arg2, ((SelectRangeGesture)arg3), arg4);
        }
        else if((arg3 instanceof DeleteRangeGesture)) {
            this.previewDeleteRangeGesture(arg2, ((DeleteRangeGesture)arg3), arg4);
        }
        else {
            return 0;
        }

        if(arg5 != null) {
            arg5.setOnCancelListener(new HandwritingGestureApi34$$ExternalSyntheticLambda1(arg2));
        }

        return 1;
    }

    static final void previewHandwritingGesture$lambda$0(TransformedTextFieldState arg4) {
        TextFieldState v0 = TransformedTextFieldState.access$getTextFieldState$p(arg4);
        InputTransformation v1 = TransformedTextFieldState.access$getInputTransformation$p(arg4);
        TextFieldEditUndoBehavior v2 = TextFieldEditUndoBehavior.MergeIfPossible;
        v0.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer v3 = v0.getMainBuffer$foundation();
        v3.clearHighlight$foundation();
        TransformedTextFieldState.access$updateWedgeAffinity(arg4, v3);
        v0.commitEditAsUser(v1, true, v2);
    }

    static final void previewHandwritingGesture$lambda$1(TextFieldSelectionManager arg0) {
        if(arg0 != null) {
            arg0.clearPreviewHighlight$foundation();
        }
    }

    private final void previewSelectGesture(LegacyTextFieldState arg2, SelectGesture arg3, TextFieldSelectionManager arg4) {
        if(arg4 != null) {
            arg4.setSelectionPreviewHighlight-5zc-tL8$foundation(HandwritingGesture_androidKt.access$getRangeForScreenRect-OH9lIzo(arg2, RectHelper_androidKt.toComposeRect(arg3.getSelectionArea()), this.toTextGranularity-NUwxegE(arg3.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()));
        }
    }

    private final void previewSelectGesture(TransformedTextFieldState arg3, SelectGesture arg4, TextLayoutState arg5) {
        this.highlightRange-XJREzCE(arg3, HandwritingGesture_androidKt.access$getRangeForScreenRect-OH9lIzo(arg5, RectHelper_androidKt.toComposeRect(arg4.getSelectionArea()), this.toTextGranularity-NUwxegE(arg4.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()), TextHighlightType.Companion.getHandwritingSelectPreview-s-xJuwY());
    }

    private final void previewSelectRangeGesture(LegacyTextFieldState arg3, SelectRangeGesture arg4, TextFieldSelectionManager arg5) {
        if(arg5 != null) {
            arg5.setSelectionPreviewHighlight-5zc-tL8$foundation(HandwritingGesture_androidKt.access$getRangeForScreenRects-O048IG0(arg3, RectHelper_androidKt.toComposeRect(arg4.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(arg4.getSelectionEndArea()), this.toTextGranularity-NUwxegE(arg4.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()));
        }
    }

    private final void previewSelectRangeGesture(TransformedTextFieldState arg4, SelectRangeGesture arg5, TextLayoutState arg6) {
        this.highlightRange-XJREzCE(arg4, HandwritingGesture_androidKt.access$getRangeForScreenRects-O048IG0(arg6, RectHelper_androidKt.toComposeRect(arg5.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(arg5.getSelectionEndArea()), this.toTextGranularity-NUwxegE(arg5.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()), TextHighlightType.Companion.getHandwritingSelectPreview-s-xJuwY());
    }

    private final int toTextGranularity-NUwxegE(int arg1) {
        if(arg1 != 1) {
            if(arg1 != 2) {
                return TextGranularity.Companion.getCharacter-DRrd7Zo();
            }

            return TextGranularity.Companion.getCharacter-DRrd7Zo();
        }

        return TextGranularity.Companion.getWord-DRrd7Zo();
    }
}

