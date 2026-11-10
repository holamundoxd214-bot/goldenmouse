package androidx.compose.foundation.text.input;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.text.AnnotatedString$Range;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A#\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001A\u0012\u0010\b\u001A\u00020\t*\u00020\u00012\u0006\u0010\n\u001A\u00020\u0003\u001A\u0012\u0010\u000B\u001A\u00020\t*\u00020\u00012\u0006\u0010\n\u001A\u00020\u0003\u001A\n\u0010\f\u001A\u00020\t*\u00020\u0001\u001AA\u0010\r\u001A\u0012\u0012\u000E\u0012\f\u0012\u0004\u0012\u00020\u00100\u000Fj\u0002`\u00110\u000E2\b\u0010\u0012\u001A\u0004\u0018\u00010\u00052\u0018\u0010\u0013\u001A\u0014\u0012\u000E\u0012\f\u0012\u0004\u0012\u00020\u00100\u000Fj\u0002`\u0011\u0018\u00010\u0014H\u0002¢\u0006\u0002\b\u0015\u001A\n\u0010\u0016\u001A\u00020\u0017*\u00020\u0001¨\u0006\u0018"}, d2={"rememberTextFieldState", "Landroidx/compose/foundation/text/input/TextFieldState;", "initialText", "", "initialSelection", "Landroidx/compose/ui/text/TextRange;", "rememberTextFieldState-Le-punE", "(Ljava/lang/String;JLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/text/input/TextFieldState;", "setTextAndPlaceCursorAtEnd", "", "text", "setTextAndSelectAll", "clearText", "finalizeComposingAnnotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "composition", "annotationList", "Landroidx/compose/runtime/collection/MutableVector;", "finalizeComposingAnnotations-itr0ztk", "toTextFieldBuffer", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldStateKt {
    public static TextFieldState $r8$lambda$VwpNrlwIb0RHFBtR_sNeGlnCzfI(String arg0, long arg1) {
        return TextFieldStateKt.rememberTextFieldState_Le_punE$lambda$0$0(arg0, arg1);
    }

    public static final List access$finalizeComposingAnnotations-itr0ztk(TextRange arg0, MutableVector arg1) {
        return TextFieldStateKt.finalizeComposingAnnotations-itr0ztk(arg0, arg1);
    }

    public static final void clearText(TextFieldState arg3) {
        TextFieldBuffer v0 = arg3.startEdit();
        try {
            TextFieldBufferKt.delete(v0, 0, v0.getLength());
            TextFieldBufferKt.placeCursorAtEnd(v0);
            arg3.commitEdit(v0);
        }
        catch(Throwable v0_1) {
            arg3.finishEditing();
            throw v0_1;
        }

        arg3.finishEditing();
    }

    private static final List finalizeComposingAnnotations-itr0ztk(TextRange arg24, MutableVector arg25) {
        if(arg25 != null && arg25.getSize() != 0) {
            return CollectionsKt.toList(arg25.asMutableList());
        }

        if(arg24 != null && !TextRange.getCollapsed-impl(arg24.unbox-impl())) {
            return CollectionsKt.listOf(new Range(new SpanStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, TextDecoration.Companion.getUnderline(), null, null, null, 0xEFFF, null), TextRange.getMin-impl(arg24.unbox-impl()), TextRange.getMax-impl(arg24.unbox-impl())));
        }

        return CollectionsKt.emptyList();
    }

    public static final TextFieldState rememberTextFieldState-Le-punE(String arg7, long arg8, Composer arg10, int arg11, int arg12) {
        TextFieldStateKt$$ExternalSyntheticLambda0 v12_1;
        int v1 = 0x431414AD;
        ComposerKt.sourceInformationMarkerStart(arg10, v1, "C(rememberTextFieldState)N(initialText,initialSelection:c#ui.text.TextRange)660@29526L49,660@29479L96:TextFieldState.kt#hp9ohv");
        if((arg12 & 1) != 0) {
            arg7 = "";
        }

        if((arg12 & 2) != 0) {
            arg8 = TextRangeKt.TextRange(arg7.length());
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg11, -1, "androidx.compose.foundation.text.input.rememberTextFieldState (TextFieldState.kt:660)");
        }

        arg12 = 0;
        Object[] v0 = new Object[0];
        Saver v1_1 = Saver.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(arg10, -832457250, "CC(remember):TextFieldState.kt#9igjgp");
        int v3 = 4;
        int v2 = (arg11 & 14 ^ 6) > v3 && (arg10.changed(arg7)) || (arg11 & 6) == v3 ? 1 : 0;
        int v5 = 0x30;
        int v6 = 0x20;
        if((arg11 & 0x70 ^ v5) > v6 && (arg10.changed(arg8)) || (arg11 & v5) == v6) {
            arg12 = 1;
        }

        arg11 = v2 | arg12;
        Object v12 = arg10.rememberedValue();
        if(arg11 != 0 || v12 == Composer.Companion.getEmpty()) {
            v12_1 = new TextFieldStateKt$$ExternalSyntheticLambda0(arg7, arg8);
            arg10.updateRememberedValue(v12_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        Object v7 = RememberSaveableKt.rememberSaveable(v0, ((androidx.compose.runtime.saveable.Saver)v1_1), ((Function0)v12_1), arg10, v5);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        return ((TextFieldState)v7);
    }

    private static final TextFieldState rememberTextFieldState_Le_punE$lambda$0$0(String arg2, long arg3) {
        return new TextFieldState(arg2, arg3, null);
    }

    public static final void setTextAndPlaceCursorAtEnd(TextFieldState arg3, String arg4) {
        TextFieldBuffer v0 = arg3.startEdit();
        try {
            v0.replace(0, v0.getLength(), ((CharSequence)arg4));
            TextFieldBufferKt.placeCursorAtEnd(v0);
            arg3.commitEdit(v0);
        }
        catch(Throwable v4) {
            arg3.finishEditing();
            throw v4;
        }

        arg3.finishEditing();
    }

    public static final void setTextAndSelectAll(TextFieldState arg3, String arg4) {
        TextFieldBuffer v0 = arg3.startEdit();
        try {
            v0.replace(0, v0.getLength(), ((CharSequence)arg4));
            TextFieldBufferKt.selectAll(v0);
            arg3.commitEdit(v0);
        }
        catch(Throwable v4) {
            arg3.finishEditing();
            throw v4;
        }

        arg3.finishEditing();
    }

    public static final TextFieldBuffer toTextFieldBuffer(TextFieldState arg7) {
        TextFieldBuffer v0 = new TextFieldBuffer(arg7.getValue$foundation(), null, null, null, 14, null);
        v0.setCanCallAddStyle$foundation(true);
        return v0;
    }
}

