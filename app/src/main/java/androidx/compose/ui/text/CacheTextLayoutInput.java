package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001A\u00020\tH\u0016J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001H\u0096\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/ui/text/CacheTextLayoutInput;", "", "textLayoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "<init>", "(Landroidx/compose/ui/text/TextLayoutInput;)V", "getTextLayoutInput", "()Landroidx/compose/ui/text/TextLayoutInput;", "hashCode", "", "equals", "", "other", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CacheTextLayoutInput {
    public static final int $stable;
    private final TextLayoutInput textLayoutInput;

    static {
    }

    public CacheTextLayoutInput(TextLayoutInput arg1) {
        super();
        this.textLayoutInput = arg1;
    }

    public boolean equals(Object arg6) {
        if(this == (((CacheTextLayoutInput)arg6))) {
            return 1;
        }

        if(!(arg6 instanceof CacheTextLayoutInput)) {
            return 0;
        }

        TextLayoutInput v5 = this.textLayoutInput;
        if(!Intrinsics.areEqual(v5.getText(), ((CacheTextLayoutInput)arg6).textLayoutInput.getText())) {
            return 0;
        }

        if(!v5.getStyle().hasSameLayoutAffectingAttributes(((CacheTextLayoutInput)arg6).textLayoutInput.getStyle())) {
            return 0;
        }

        if(!Intrinsics.areEqual(v5.getPlaceholders(), ((CacheTextLayoutInput)arg6).textLayoutInput.getPlaceholders())) {
            return 0;
        }

        if(v5.getMaxLines() != ((CacheTextLayoutInput)arg6).textLayoutInput.getMaxLines()) {
            return 0;
        }

        if(v5.getSoftWrap() != ((CacheTextLayoutInput)arg6).textLayoutInput.getSoftWrap()) {
            return 0;
        }

        if(!TextOverflow.equals-impl0(v5.getOverflow-gIe3tQ8(), ((CacheTextLayoutInput)arg6).textLayoutInput.getOverflow-gIe3tQ8())) {
            return 0;
        }

        if(!Intrinsics.areEqual(v5.getDensity(), ((CacheTextLayoutInput)arg6).textLayoutInput.getDensity())) {
            return 0;
        }

        if(v5.getLayoutDirection() != ((CacheTextLayoutInput)arg6).textLayoutInput.getLayoutDirection()) {
            return 0;
        }

        if(v5.getFontFamilyResolver() != ((CacheTextLayoutInput)arg6).textLayoutInput.getFontFamilyResolver()) {
            return 0;
        }

        if(!Constraints.equals-impl0(v5.getConstraints-msEJaDk(), ((CacheTextLayoutInput)arg6).textLayoutInput.getConstraints-msEJaDk())) {
            return 0;
        }

        return 1;
    }

    public final TextLayoutInput getTextLayoutInput() {
        return this.textLayoutInput;
    }

    public int hashCode() {
        return ((((((((this.textLayoutInput.getText().hashCode() * 0x1F + this.textLayoutInput.getStyle().hashCodeLayoutAffectingAttributes$ui_text()) * 0x1F + this.textLayoutInput.getPlaceholders().hashCode()) * 0x1F + this.textLayoutInput.getMaxLines()) * 0x1F + Boolean.hashCode(this.textLayoutInput.getSoftWrap())) * 0x1F + TextOverflow.hashCode-impl(this.textLayoutInput.getOverflow-gIe3tQ8())) * 0x1F + this.textLayoutInput.getDensity().hashCode()) * 0x1F + this.textLayoutInput.getLayoutDirection().hashCode()) * 0x1F + this.textLayoutInput.getFontFamilyResolver().hashCode()) * 0x1F + Constraints.hashCode-impl(this.textLayoutInput.getConstraints-msEJaDk());
    }
}

