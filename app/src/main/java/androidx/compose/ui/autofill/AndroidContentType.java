package androidx.compose.ui.autofill;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\u0001H\u0096\u0002R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u000B"}, d2={"Landroidx/compose/ui/autofill/AndroidContentType;", "Landroidx/compose/ui/autofill/ContentType;", "androidAutofillHints", "", "", "<init>", "(Ljava/util/Set;)V", "getAndroidAutofillHints", "()Ljava/util/Set;", "plus", "other", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class AndroidContentType implements ContentType {
    private final Set androidAutofillHints;

    public AndroidContentType(Set arg1) {
        super();
        this.androidAutofillHints = arg1;
    }

    public final Set getAndroidAutofillHints() {
        return this.androidAutofillHints;
    }

    public ContentType plus(ContentType arg2) {
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.ui.autofill.AndroidContentType");
        return new AndroidContentType(SetsKt.plus(this.androidAutofillHints, ((AndroidContentType)arg2).androidAutofillHints));
    }
}

