package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\r\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000E\u0010\fJ\b\u0010\u0015\u001A\u00020\u0016H\u0016J!\u0010\u0017\u001A\u00020\u00132\u0017\u0010\u0018\u001A\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b\u0014H\u0016J\b\u0010\u0019\u001A\u00020\u0016H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R%\u0010\u000F\u001A\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b\u00140\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Landroidx/compose/foundation/text/input/internal/DefaultImeEditCommandScope;", "Landroidx/compose/foundation/text/input/internal/ImeEditCommandScope;", "transformedTextFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;)V", "batchDepth", "", "mapFromTransformed", "Landroidx/compose/ui/text/TextRange;", "range", "mapFromTransformed-GEjPoXI", "(J)J", "mapToTransformed", "mapToTransformed-GEjPoXI", "editCommands", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "", "Lkotlin/ExtensionFunctionType;", "beginBatchEdit", "", "edit", "block", "endBatchEdit", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DefaultImeEditCommandScope implements ImeEditCommandScope {
    public static final int $stable = 8;
    private int batchDepth;
    private final MutableVector editCommands;
    private final TransformedTextFieldState transformedTextFieldState;

    static {
    }

    public DefaultImeEditCommandScope(TransformedTextFieldState arg3) {
        super();
        this.transformedTextFieldState = arg3;
        this.editCommands = new MutableVector(new Function1[16], 0);
    }

    public boolean beginBatchEdit() {
        ++this.batchDepth;
        return 1;
    }

    public void edit(Function1 arg2) {
        this.beginBatchEdit();
        this.editCommands.add(arg2);
        this.endBatchEdit();
    }

    public boolean endBatchEdit() {
        int v0 = this.batchDepth - 1;
        this.batchDepth = v0;
        if(v0 == 0 && this.editCommands.getSize() != 0) {
            TransformedTextFieldState v0_1 = this.transformedTextFieldState;
            TextFieldState v2 = TransformedTextFieldState.access$getTextFieldState$p(v0_1);
            InputTransformation v3 = TransformedTextFieldState.access$getInputTransformation$p(v0_1);
            TextFieldEditUndoBehavior v4 = TextFieldEditUndoBehavior.MergeIfPossible;
            v2.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
            TextFieldBuffer v5 = v2.getMainBuffer$foundation();
            MutableVector v6 = this.editCommands;
            Object[] v7 = v6.content;
            int v6_1 = v6.getSize();
            int v8;
            for(v8 = 0; v8 < v6_1; ++v8) {
                v7[v8].invoke(v5);
            }

            TransformedTextFieldState.access$updateWedgeAffinity(v0_1, v5);
            v2.commitEditAsUser(v3, false, v4);
            this.editCommands.clear();
        }

        if(this.batchDepth > 0) {
            return 1;
        }

        return 0;
    }

    public long mapFromTransformed-GEjPoXI(long arg1) {
        return this.transformedTextFieldState.mapFromTransformed-GEjPoXI(arg1);
    }

    public long mapToTransformed-GEjPoXI(long arg1) {
        return this.transformedTextFieldState.mapToTransformed-GEjPoXI(arg1);
    }
}

