package androidx.compose.ui.modifier;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u000F\u001A\u00020\u00102\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\u0011J,\u0010\u0012\u001A\u00020\u0010\"\u0004\b\u0000\u0010\u00132\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u0002H\u00130\u00032\u0006\u0010\b\u001A\u0002H\u0013H\u0090\u0002¢\u0006\u0004\b\u0014\u0010\u0015J&\u0010\u0016\u001A\u0004\u0018\u0001H\u0013\"\u0004\b\u0000\u0010\u00132\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u0002H\u00130\u0003H\u0090\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001A\u0010\u0019\u001A\u00020\u001A2\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003H\u0090\u0002¢\u0006\u0002\b\u001BR\u0012\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\b\u001A\u0004\u0018\u00010\u00072\b\u0010\u0006\u001A\u0004\u0018\u00010\u00078B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000E\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\f¨\u0006\u001C"}, d2={"Landroidx/compose/ui/modifier/SingleLocalMap;", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "key", "Landroidx/compose/ui/modifier/ModifierLocal;", "<init>", "(Landroidx/compose/ui/modifier/ModifierLocal;)V", "<set-?>", "", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "forceValue", "", "forceValue$ui", "set", "T", "set$ui", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", "get", "get$ui", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "contains", "", "contains$ui", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SingleLocalMap extends ModifierLocalMap {
    public static final int $stable;
    private final ModifierLocal key;
    private final MutableState value$delegate;

    static {
    }

    public SingleLocalMap(ModifierLocal arg2) {
        super(null);
        this.key = arg2;
        this.value$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    public boolean contains$ui(ModifierLocal arg1) {
        if(arg1 == this.key) {
            return 1;
        }

        return 0;
    }

    public final void forceValue$ui(Object arg1) {
        this.setValue(arg1);
    }

    public Object get$ui(ModifierLocal arg2) {
        int v2 = arg2 == this.key ? 1 : 0;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalStateException("Check failed.");
        }

        Object v1 = this.getValue();
        if(v1 == null) {
            v1 = null;
        }

        return v1;
    }

    private final Object getValue() {
        return this.value$delegate.getValue();
    }

    public void set$ui(ModifierLocal arg2, Object arg3) {
        int v2 = arg2 == this.key ? 1 : 0;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalStateException("Check failed.");
        }

        this.setValue(arg3);
    }

    private final void setValue(Object arg1) {
        this.value$delegate.setValue(arg1);
    }
}

