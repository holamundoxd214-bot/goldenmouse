package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001A2\u00020\u0001:\u0001\u001ABµ\u0001\u0012\u001B\b\u0002\u0010\u0002\u001A\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006\u0012\u001B\b\u0002\u0010\u0007\u001A\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006\u0012\u001B\b\u0002\u0010\b\u001A\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006\u0012\u001B\b\u0002\u0010\t\u001A\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006\u0012\u001B\b\u0002\u0010\n\u001A\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006\u0012\u001B\b\u0002\u0010\u000B\u001A\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001A\u00020\u0019H\u0016R$\u0010\u0002\u001A\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR$\u0010\u0007\u001A\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000FR$\u0010\b\u001A\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000FR$\u0010\t\u001A\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000FR$\u0010\n\u001A\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u000FR$\u0010\u000B\u001A\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u000F¨\u0006\u001B"}, d2={"Landroidx/compose/foundation/text/KeyboardActions;", "", "onDone", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/KeyboardActionScope;", "", "Lkotlin/ExtensionFunctionType;", "onGo", "onNext", "onPrevious", "onSearch", "onSend", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnDone", "()Lkotlin/jvm/functions/Function1;", "getOnGo", "getOnNext", "getOnPrevious", "getOnSearch", "getOnSend", "equals", "", "other", "hashCode", "", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class KeyboardActions {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001C\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/foundation/text/KeyboardActions$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/foundation/text/KeyboardActions;", "getDefault$annotations", "getDefault", "()Landroidx/compose/foundation/text/KeyboardActions;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final KeyboardActions getDefault() {
            return KeyboardActions.Default;
        }

        public static void getDefault$annotations() {
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final KeyboardActions Default;
    private final Function1 onDone;
    private final Function1 onGo;
    private final Function1 onNext;
    private final Function1 onPrevious;
    private final Function1 onSearch;
    private final Function1 onSend;

    static {
        KeyboardActions.Companion = new Companion(null);
        KeyboardActions.Default = new KeyboardActions(null, null, null, null, null, null, 0x3F, null);
    }

    public KeyboardActions(Function1 arg2, Function1 arg3, Function1 arg4, Function1 arg5, Function1 arg6, Function1 arg7, int arg8, DefaultConstructorMarker arg9) {
        Function1 v0 = null;
        if((arg8 & 1) != 0) {
            arg2 = v0;
        }

        if((arg8 & 2) != 0) {
            arg3 = v0;
        }

        if((arg8 & 4) != 0) {
            arg4 = v0;
        }

        if((arg8 & 8) != 0) {
            arg5 = v0;
        }

        if((arg8 & 16) != 0) {
            arg6 = v0;
        }

        if((arg8 & 0x20) != 0) {
            arg7 = v0;
        }

        this(arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public KeyboardActions() {
        this(null, null, null, null, null, null, 0x3F, null);
    }

    public KeyboardActions(Function1 arg1, Function1 arg2, Function1 arg3, Function1 arg4, Function1 arg5, Function1 arg6) {
        super();
        this.onDone = arg1;
        this.onGo = arg2;
        this.onNext = arg3;
        this.onPrevious = arg4;
        this.onSearch = arg5;
        this.onSend = arg6;
    }

    public static final KeyboardActions access$getDefault$cp() {
        return KeyboardActions.Default;
    }

    public boolean equals(Object arg5) {
        if(this == (((KeyboardActions)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof KeyboardActions)) {
            return 0;
        }

        if(this.onDone == ((KeyboardActions)arg5).onDone && this.onGo == ((KeyboardActions)arg5).onGo && this.onNext == ((KeyboardActions)arg5).onNext && this.onPrevious == ((KeyboardActions)arg5).onPrevious && this.onSearch == ((KeyboardActions)arg5).onSearch && this.onSend == ((KeyboardActions)arg5).onSend) {
            return 1;
        }

        return 0;
    }

    public final Function1 getOnDone() {
        return this.onDone;
    }

    public final Function1 getOnGo() {
        return this.onGo;
    }

    public final Function1 getOnNext() {
        return this.onNext;
    }

    public final Function1 getOnPrevious() {
        return this.onPrevious;
    }

    public final Function1 getOnSearch() {
        return this.onSearch;
    }

    public final Function1 getOnSend() {
        return this.onSend;
    }

    public int hashCode() {
        Function1 v0 = this.onDone;
        int v1 = 0;
        int v0_1 = v0 != null ? v0.hashCode() : 0;
        v0_1 *= 0x1F;
        Function1 v2 = this.onGo;
        int v2_1 = v2 != null ? v2.hashCode() : 0;
        v0_1 = (v0_1 + v2_1) * 0x1F;
        v2 = this.onNext;
        v2_1 = v2 != null ? v2.hashCode() : 0;
        v0_1 = (v0_1 + v2_1) * 0x1F;
        v2 = this.onPrevious;
        v2_1 = v2 != null ? v2.hashCode() : 0;
        v0_1 = (v0_1 + v2_1) * 0x1F;
        v2 = this.onSearch;
        v2_1 = v2 != null ? v2.hashCode() : 0;
        v0_1 = (v0_1 + v2_1) * 0x1F;
        Function1 v3 = this.onSend;
        if(v3 != null) {
            v1 = v3.hashCode();
        }

        return v0_1 + v1;
    }
}

