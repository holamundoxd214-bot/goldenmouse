package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.SetSelectionCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B-\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ)\u0010\u0012\u001A\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0019\u0010\u0015\u001A\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0016¢\u0006\u0002\b\u0017J\u0006\u0010\u0018\u001A\u00020\u0000J\u0006\u0010\u0019\u001A\u00020\u0000J\u0014\u0010\u001A\u001A\u00020\u001B*\u00020\u00072\u0006\u0010\u001C\u001A\u00020\u001BH\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0010\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\r¨\u0006\u001D"}, d2={"Landroidx/compose/foundation/text/selection/TextFieldPreparedSelection;", "Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "currentValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "layoutResultProxy", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "<init>", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/TextLayoutResultProxy;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;)V", "getCurrentValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "getLayoutResultProxy", "()Landroidx/compose/foundation/text/TextLayoutResultProxy;", "value", "getValue", "deleteIfSelectedOr", "", "Landroidx/compose/ui/text/input/EditCommand;", "or", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "moveCursorUpByPage", "moveCursorDownByPage", "jumpByPagesOffset", "", "pagesAmount", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextFieldPreparedSelection extends BaseTextPreparedSelection {
    public static final int $stable = 8;
    private final TextFieldValue currentValue;
    private final TextLayoutResultProxy layoutResultProxy;

    static {
    }

    public TextFieldPreparedSelection(TextFieldValue arg9, OffsetMapping arg10, TextLayoutResultProxy arg11, TextPreparedSelectionState arg12) {
        AnnotatedString v1 = arg9.getAnnotatedString();
        long v2 = arg9.getSelection-d9O1mEE();
        TextLayoutResult v0 = arg11 != null ? arg11.getValue() : null;
        super(v1, v2, v0, arg10, arg12, null);
        this.currentValue = arg9;
        this.layoutResultProxy = arg11;
    }

    public TextFieldPreparedSelection(TextFieldValue arg1, OffsetMapping arg2, TextLayoutResultProxy arg3, TextPreparedSelectionState arg4, int arg5, DefaultConstructorMarker arg6) {
        if((arg5 & 2) != 0) {
            arg2 = OffsetMapping.Companion.getIdentity();
        }

        if((arg5 & 8) != 0) {
            arg4 = new TextPreparedSelectionState();
        }

        this(arg1, arg2, arg3, arg4);
    }

    public final List deleteIfSelectedOr(Function1 arg5) {
        if(TextRange.getCollapsed-impl(this.getSelection-d9O1mEE())) {
            Object v4 = arg5.invoke(this);
            if(v4 != null) {
                return CollectionsKt.listOf(v4);
            }

            return null;
        }

        return CollectionsKt.listOf(new EditCommand[]{new CommitTextCommand("", 0), new SetSelectionCommand(TextRange.getMin-impl(this.getSelection-d9O1mEE()), TextRange.getMin-impl(this.getSelection-d9O1mEE()))});
    }

    public final TextFieldValue getCurrentValue() {
        return this.currentValue;
    }

    public final TextLayoutResultProxy getLayoutResultProxy() {
        return this.layoutResultProxy;
    }

    public final TextFieldValue getValue() {
        return TextFieldValue.copy-3r_uNRQ$default(this.currentValue, this.getAnnotatedString(), this.getSelection-d9O1mEE(), null, 4, null);
    }

    private final int jumpByPagesOffset(TextLayoutResultProxy arg9, int arg10) {
        Rect v2_1;
        Object v2;
        LayoutCoordinates v0 = arg9.getInnerTextFieldCoordinates();
        if(v0 != null) {
            LayoutCoordinates v1 = arg9.getDecorationBoxCoordinates();
            v2 = null;
            if(v1 != null) {
                v2_1 = LayoutCoordinates.localBoundingBoxOf$default(v1, v0, false, 2, v2);
            }

            if((((Rect)v2)) != null) {
                goto label_11;
            }

            goto label_9;
        }
        else {
        label_9:
            v2_1 = Rect.Companion.getZero();
        }

    label_11:
        Rect v0_1 = arg9.getValue().getCursorRect(this.getOffsetMapping().originalToTransformed(TextRange.getEnd-impl(this.currentValue.getSelection-d9O1mEE())));
        return this.getOffsetMapping().transformedToOriginal(arg9.getValue().getOffsetForPosition-k-4lQ0M(Offset.constructor-impl((((long)Float.floatToRawIntBits(v0_1.getLeft()))) << 0x20 | (((long)Float.floatToRawIntBits(v0_1.getTop() + Float.intBitsToFloat(((int)(((Rect)v2).getSize-NH-jbRc() & 0xFFFFFFFFL))) * (((float)arg10))))) & 0xFFFFFFFFL)));
    }

    public final TextFieldPreparedSelection moveCursorDownByPage() {
        TextFieldPreparedSelection v0 = this;
        if(((BaseTextPreparedSelection)v0).getText$foundation().length() > 0) {
            TextLayoutResultProxy v1 = this.layoutResultProxy;
            if(v1 != null) {
                this.setCursor(this.jumpByPagesOffset(v1, 1));
            }
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return v0;
    }

    public final TextFieldPreparedSelection moveCursorUpByPage() {
        TextFieldPreparedSelection v0 = this;
        if(((BaseTextPreparedSelection)v0).getText$foundation().length() > 0) {
            TextLayoutResultProxy v1 = this.layoutResultProxy;
            if(v1 != null) {
                this.setCursor(this.jumpByPagesOffset(v1, -1));
            }
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return v0;
    }
}

