package androidx.compose.foundation.text.input;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0006\u001A\u00020\u0007*\u00020\bH\u0016J\f\u0010\t\u001A\u00020\u0007*\u00020\nH\u0016J\b\u0010\u000B\u001A\u00020\fH\u0016J\t\u0010\r\u001A\u00020\u0003HÂ\u0003J\u0013\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001A\u00020\u0003HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Landroidx/compose/foundation/text/input/MaxLengthFilter;", "Landroidx/compose/foundation/text/input/InputTransformation;", "maxLength", "", "<init>", "(I)V", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "transformInput", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "toString", "", "component1", "copy", "equals", "", "other", "", "hashCode", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class MaxLengthFilter implements InputTransformation {
    private final int maxLength;

    public MaxLengthFilter(int arg1) {
        super();
        this.maxLength = arg1;
        int v0 = arg1 >= 0 ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("maxLength must be at least zero");
        }
    }

    public void applySemantics(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setMaxTextLength(arg1, this.maxLength);
    }

    private final int component1() {
        return this.maxLength;
    }

    public final MaxLengthFilter copy(int arg1) {
        return new MaxLengthFilter(arg1);
    }

    public static MaxLengthFilter copy$default(MaxLengthFilter arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.maxLength;
        }

        return arg0.copy(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((MaxLengthFilter)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof MaxLengthFilter)) {
            return 0;
        }

        if(this.maxLength != ((MaxLengthFilter)arg4).maxLength) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return Integer.hashCode(this.maxLength);
    }

    public String toString() {
        return "InputTransformation.maxLength(" + this.maxLength + ')';
    }

    public void transformInput(TextFieldBuffer arg2) {
        if(arg2.getLength() > this.maxLength) {
            arg2.revertAllChanges();
        }
    }
}

