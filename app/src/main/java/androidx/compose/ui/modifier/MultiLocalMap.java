package androidx.compose.ui.modifier;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001BY\u0012\u0018\u0010\u0002\u001A\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u00126\u0010\u0006\u001A\u001C\u0012\u0018\b\u0001\u0012\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u0007\"\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0004\b\b\u0010\tJ,\u0010\f\u001A\u00020\r\"\u0004\b\u0000\u0010\u000E2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\u000E0\u00042\u0006\u0010\u0010\u001A\u0002H\u000EH\u0090\u0002¢\u0006\u0004\b\u0011\u0010\u0012J&\u0010\u0013\u001A\u0004\u0018\u0001H\u000E\"\u0004\b\u0000\u0010\u000E2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\u000E0\u0004H\u0090\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001A\u0010\u0016\u001A\u00020\u00172\n\u0010\u000F\u001A\u0006\u0012\u0002\b\u00030\u0004H\u0090\u0002¢\u0006\u0002\b\u0018R \u0010\n\u001A\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000BX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Landroidx/compose/ui/modifier/MultiLocalMap;", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "entry1", "Lkotlin/Pair;", "Landroidx/compose/ui/modifier/ModifierLocal;", "", "entries", "", "<init>", "(Lkotlin/Pair;[Lkotlin/Pair;)V", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "set", "", "T", "key", "value", "set$ui", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", "get", "get$ui", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "contains", "", "contains$ui", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MultiLocalMap extends ModifierLocalMap {
    public static final int $stable;
    private final SnapshotStateMap map;

    static {
    }

    public MultiLocalMap(Pair arg3, Pair[] arg4) {
        super(null);
        SnapshotStateMap v0 = SnapshotStateKt.mutableStateMapOf();
        this.map = v0;
        v0.put(arg3.getFirst(), arg3.getSecond());
        v0.putAll(MapsKt.toMap(arg4));
    }

    public boolean contains$ui(ModifierLocal arg1) {
        return this.map.containsKey(arg1);
    }

    public Object get$ui(ModifierLocal arg1) {
        Object v0 = this.map.get(arg1);
        if(v0 == null) {
            v0 = null;
        }

        return v0;
    }

    public void set$ui(ModifierLocal arg1, Object arg2) {
        this.map.put(arg1, arg2);
    }
}

