package androidx.compose.ui.text.platform;

import androidx.compose.runtime.State;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0003\u001A\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/text/platform/ImmutableBool;", "Landroidx/compose/runtime/State;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class ImmutableBool implements State {
    private final boolean value;

    public ImmutableBool(boolean arg1) {
        super();
        this.value = arg1;
    }

    public Boolean getValue() {
        return Boolean.valueOf(this.value);
    }

    public Object getValue() {
        return this.getValue();
    }
}

