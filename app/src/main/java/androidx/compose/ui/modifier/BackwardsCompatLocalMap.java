package androidx.compose.ui.modifier;

import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\t\u001A\u00020\n\"\u0004\b\u0000\u0010\u000B2\f\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u000B0\r2\u0006\u0010\u000E\u001A\u0002H\u000BH\u0090\u0002¢\u0006\u0004\b\u000F\u0010\u0010J&\u0010\u0011\u001A\u0004\u0018\u0001H\u000B\"\u0004\b\u0000\u0010\u000B2\f\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u000B0\rH\u0090\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001A\u0010\u0014\u001A\u00020\u00152\n\u0010\f\u001A\u0006\u0012\u0002\b\u00030\rH\u0090\u0002¢\u0006\u0002\b\u0016R\u001E\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0017"}, d2={"Landroidx/compose/ui/modifier/BackwardsCompatLocalMap;", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "element", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "<init>", "(Landroidx/compose/ui/modifier/ModifierLocalProvider;)V", "getElement", "()Landroidx/compose/ui/modifier/ModifierLocalProvider;", "setElement", "set", "", "T", "key", "Landroidx/compose/ui/modifier/ModifierLocal;", "value", "set$ui", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", "get", "get$ui", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "contains", "", "contains$ui", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BackwardsCompatLocalMap extends ModifierLocalMap {
    public static final int $stable = 8;
    private ModifierLocalProvider element;

    static {
    }

    public BackwardsCompatLocalMap(ModifierLocalProvider arg2) {
        super(null);
        this.element = arg2;
    }

    public boolean contains$ui(ModifierLocal arg1) {
        if(arg1 == this.element.getKey()) {
            return 1;
        }

        return 0;
    }

    public Object get$ui(ModifierLocal arg2) {
        int v2 = arg2 == this.element.getKey() ? 1 : 0;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalStateException("Check failed.");
        }

        return this.element.getValue();
    }

    public final ModifierLocalProvider getElement() {
        return this.element;
    }

    public void set$ui(ModifierLocal arg1, Object arg2) {
        throw new IllegalStateException("Set is not allowed on a backwards compat provider".toString());
    }

    public final void setElement(ModifierLocalProvider arg1) {
        this.element = arg1;
    }
}

