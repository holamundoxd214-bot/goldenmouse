package androidx.compose.ui.modifier;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001A\u00020\u0005\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\t\u001A\u0002H\u0006H \u0002¢\u0006\u0004\b\n\u0010\u000BJ&\u0010\f\u001A\u0004\u0018\u0001H\u0006\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00060\bH \u0002¢\u0006\u0004\b\r\u0010\u000EJ\u001A\u0010\u000F\u001A\u00020\u00102\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\bH \u0002¢\u0006\u0002\b\u0011\u0082\u0001\u0004\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2={"Landroidx/compose/ui/modifier/ModifierLocalMap;", "", "<init>", "()V", "set", "", "T", "key", "Landroidx/compose/ui/modifier/ModifierLocal;", "value", "set$ui", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", "get", "get$ui", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "contains", "", "contains$ui", "Landroidx/compose/ui/modifier/BackwardsCompatLocalMap;", "Landroidx/compose/ui/modifier/EmptyMap;", "Landroidx/compose/ui/modifier/MultiLocalMap;", "Landroidx/compose/ui/modifier/SingleLocalMap;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class ModifierLocalMap {
    public static final int $stable;

    static {
    }

    private ModifierLocalMap() {
        super();
    }

    public ModifierLocalMap(DefaultConstructorMarker arg1) {
        this();
    }

    public abstract boolean contains$ui(ModifierLocal arg1);

    public abstract Object get$ui(ModifierLocal arg1);

    public abstract void set$ui(ModifierLocal arg1, Object arg2);
}

