package androidx.compose.material3;

import androidx.compose.runtime.RecomposeScope;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001C\u0010\u0005\u001A\u0004\u0018\u00010\u0002X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\u001C\u0010\u0011\u001A\u0004\u0018\u00010\u0012X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2={"Landroidx/compose/material3/FadeInFadeOutState;", "T", "", "<init>", "()V", "current", "getCurrent", "()Ljava/lang/Object;", "setCurrent", "(Ljava/lang/Object;)V", "items", "", "Landroidx/compose/material3/FadeInFadeOutAnimationItem;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "scope", "Landroidx/compose/runtime/RecomposeScope;", "getScope", "()Landroidx/compose/runtime/RecomposeScope;", "setScope", "(Landroidx/compose/runtime/RecomposeScope;)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class FadeInFadeOutState {
    private Object current;
    private List items;
    private RecomposeScope scope;

    public FadeInFadeOutState() {
        super();
        this.current = new Object();
        this.items = new ArrayList();
    }

    public final Object getCurrent() {
        return this.current;
    }

    public final List getItems() {
        return this.items;
    }

    public final RecomposeScope getScope() {
        return this.scope;
    }

    public final void setCurrent(Object arg1) {
        this.current = arg1;
    }

    public final void setItems(List arg1) {
        this.items = arg1;
    }

    public final void setScope(RecomposeScope arg1) {
        this.scope = arg1;
    }
}

