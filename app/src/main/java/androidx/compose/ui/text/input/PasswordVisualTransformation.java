package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0096\u0002J\b\u0010\u0010\u001A\u00020\u0011H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Landroidx/compose/ui/text/input/PasswordVisualTransformation;", "Landroidx/compose/ui/text/input/VisualTransformation;", "mask", "", "<init>", "(C)V", "getMask", "()C", "filter", "Landroidx/compose/ui/text/input/TransformedText;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "equals", "", "other", "", "hashCode", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PasswordVisualTransformation implements VisualTransformation {
    public static final int $stable;
    private final char mask;

    static {
    }

    public PasswordVisualTransformation() {
        this('\u0000', 1, null);
    }

    public PasswordVisualTransformation(char arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = '•';
        }

        this(arg1);
    }

    public PasswordVisualTransformation(char arg1) {
        super();
        this.mask = arg1;
    }

    public boolean equals(Object arg4) {
        if(this == (((PasswordVisualTransformation)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof PasswordVisualTransformation)) {
            return 0;
        }

        if(this.mask != ((PasswordVisualTransformation)arg4).mask) {
            return 0;
        }

        return 1;
    }

    public TransformedText filter(AnnotatedString arg4) {
        return new TransformedText(new AnnotatedString(StringsKt.repeat(String.valueOf(this.mask), arg4.getText().length()), null, 2, null), OffsetMapping.Companion.getIdentity());
    }

    public final char getMask() {
        return this.mask;
    }

    public int hashCode() {
        return Character.hashCode(this.mask);
    }
}

