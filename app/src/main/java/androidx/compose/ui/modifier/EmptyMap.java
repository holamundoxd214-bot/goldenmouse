package androidx.compose.ui.modifier;

import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001A\u00020\u0005\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\t\u001A\u0002H\u0006H\u0090\u0002¢\u0006\u0004\b\n\u0010\u000BJ$\u0010\f\u001A\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00060\bH\u0090\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u001A\u0010\u000F\u001A\u00020\u00102\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\bH\u0090\u0002¢\u0006\u0002\b\u0011¨\u0006\u0012"}, d2={"Landroidx/compose/ui/modifier/EmptyMap;", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "<init>", "()V", "set", "", "T", "key", "Landroidx/compose/ui/modifier/ModifierLocal;", "value", "set$ui", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)Ljava/lang/Void;", "get", "get$ui", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "contains", "", "contains$ui", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class EmptyMap extends ModifierLocalMap {
    public static final int $stable;
    public static final EmptyMap INSTANCE;

    static {
        EmptyMap.INSTANCE = new EmptyMap();
    }

    private EmptyMap() {
        super(null);
    }

    public boolean contains$ui(ModifierLocal arg1) {
        return 0;
    }

    public Object get$ui(ModifierLocal arg1) {
        throw new IllegalStateException("".toString());
    }

    public Void set$ui(ModifierLocal arg1, Object arg2) {
        throw new IllegalStateException("".toString());
    }

    public void set$ui(ModifierLocal arg1, Object arg2) {
        this.set$ui(arg1, arg2);
    }
}

