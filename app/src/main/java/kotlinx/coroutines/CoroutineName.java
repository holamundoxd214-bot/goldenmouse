package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001A\u00020\u0003H\u0016J\t\u0010\t\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EHÖ\u0003J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Lkotlinx/coroutines/CoroutineName;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "toString", "component1", "copy", "equals", "", "other", "", "hashCode", "", "Key", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class CoroutineName extends AbstractCoroutineContextElement {
    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Lkotlinx/coroutines/CoroutineName$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineName;", "<init>", "()V", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Key implements kotlin.coroutines.CoroutineContext$Key {
        public Key(DefaultConstructorMarker arg1) {
            this();
        }

        private Key() {
            super();
        }
    }

    public static final Key Key;
    private final String name;

    static {
        CoroutineName.Key = new Key(null);
    }

    public CoroutineName(String arg2) {
        super(CoroutineName.Key);
        this.name = arg2;
    }

    public final String component1() {
        return this.name;
    }

    public final CoroutineName copy(String arg1) {
        return new CoroutineName(arg1);
    }

    public static CoroutineName copy$default(CoroutineName arg0, String arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.name;
        }

        return arg0.copy(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((CoroutineName)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof CoroutineName)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.name, ((CoroutineName)arg4).name)) {
            return 0;
        }

        return 1;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return "CoroutineName(" + this.name + ')';
    }
}

