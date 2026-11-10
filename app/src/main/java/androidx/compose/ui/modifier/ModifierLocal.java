package androidx.compose.ui.modifier;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\b\u0004\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001A\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b\u0082\u0001\u0001\t¨\u0006\n"}, d2={"Landroidx/compose/ui/modifier/ModifierLocal;", "T", "", "defaultFactory", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "getDefaultFactory$ui", "()Lkotlin/jvm/functions/Function0;", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class ModifierLocal {
    public static final int $stable;
    private final Function0 defaultFactory;

    static {
    }

    private ModifierLocal(Function0 arg1) {
        super();
        this.defaultFactory = arg1;
    }

    public ModifierLocal(Function0 arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    public final Function0 getDefaultFactory$ui() {
        return this.defaultFactory;
    }
}

