package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\n\u001A\u00020\u000B*\u00020\fH\u0016J\f\u0010\r\u001A\u00020\u000B*\u00020\u000EH\u0016J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001A\u00020\u0016H\u0016R\u000E\u0010\u0002\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0003\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/text/input/FilterChain;", "Landroidx/compose/foundation/text/input/InputTransformation;", "first", "second", "<init>", "(Landroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/InputTransformation;)V", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "transformInput", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "toString", "", "equals", "", "other", "", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class FilterChain implements InputTransformation {
    private final InputTransformation first;
    private final InputTransformation second;

    public FilterChain(InputTransformation arg1, InputTransformation arg2) {
        super();
        this.first = arg1;
        this.second = arg2;
    }

    public void applySemantics(SemanticsPropertyReceiver arg2) {
        this.first.applySemantics(arg2);
        this.second.applySemantics(arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((FilterChain)arg5))) {
            return 1;
        }

        if(arg5 == null) {
            return 0;
        }

        if(this.getClass() != arg5.getClass()) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.first, ((FilterChain)arg5).first)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.second, ((FilterChain)arg5).second)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getKeyboardOptions(), ((FilterChain)arg5).getKeyboardOptions())) {
            return 0;
        }

        return 1;
    }

    public KeyboardOptions getKeyboardOptions() {
        KeyboardOptions v0 = this.second.getKeyboardOptions();
        if(v0 != null) {
            v0 = v0.fillUnspecifiedValuesWith$foundation(this.first.getKeyboardOptions());
            if(v0 == null) {
            }
            else {
                return v0;
            }
        }

        return this.first.getKeyboardOptions();
    }

    public int hashCode() {
        int v0 = (this.first.hashCode() * 0x1F + this.second.hashCode()) * 0x20;
        KeyboardOptions v2 = this.getKeyboardOptions();
        int v2_1 = v2 != null ? v2.hashCode() : 0;
        return v0 + v2_1;
    }

    public String toString() {
        return this.first + ".then(" + this.second + ')';
    }

    public void transformInput(TextFieldBuffer arg2) {
        this.first.transformInput(arg2);
        this.second.transformInput(arg2);
    }
}

