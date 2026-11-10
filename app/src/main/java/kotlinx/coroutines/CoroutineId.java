package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0019B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001A\u00020\u0002H\u0016J\u0010\u0010\u000B\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\rH\u0016J\u0018\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u0002H\u0016J\t\u0010\u0011\u001A\u00020\u0005HÆ\u0003J\u0013\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\u001A"}, d2={"Lkotlinx/coroutines/CoroutineId;", "Lkotlinx/coroutines/ThreadContextElement;", "", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "id", "", "<init>", "(J)V", "getId", "()J", "toString", "updateThreadContext", "context", "Lkotlin/coroutines/CoroutineContext;", "restoreThreadContext", "", "oldState", "component1", "copy", "equals", "", "other", "", "hashCode", "", "Key", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class CoroutineId extends AbstractCoroutineContextElement implements ThreadContextElement {
    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Lkotlinx/coroutines/CoroutineId$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineId;", "<init>", "()V", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Key implements kotlin.coroutines.CoroutineContext$Key {
        public Key(DefaultConstructorMarker arg1) {
            this();
        }

        private Key() {
            super();
        }
    }

    public static final Key Key;
    private final long id;

    static {
        CoroutineId.Key = new Key(null);
    }

    public CoroutineId(long arg2) {
        super(CoroutineId.Key);
        this.id = arg2;
    }

    public final long component1() {
        return this.id;
    }

    public final CoroutineId copy(long arg1) {
        return new CoroutineId(arg1);
    }

    public static CoroutineId copy$default(CoroutineId arg0, long arg1, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.id;
        }

        return arg0.copy(arg1);
    }

    public boolean equals(Object arg6) {
        if(this == (((CoroutineId)arg6))) {
            return 1;
        }

        if(!(arg6 instanceof CoroutineId)) {
            return 0;
        }

        if(this.id != ((CoroutineId)arg6).id) {
            return 0;
        }

        return 1;
    }

    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        return Long.hashCode(this.id);
    }

    public void restoreThreadContext(CoroutineContext arg1, Object arg2) {
        this.restoreThreadContext(arg1, ((String)arg2));
    }

    public void restoreThreadContext(CoroutineContext arg1, String arg2) {
        Thread.currentThread().setName(arg2);
    }

    public String toString() {
        return "CoroutineId(" + this.id + ')';
    }

    public Object updateThreadContext(CoroutineContext arg1) {
        return this.updateThreadContext(arg1);
    }

    public String updateThreadContext(CoroutineContext arg9) {
        String v9_1;
        Element v9 = arg9.get(CoroutineName.Key);
        if(v9 != null) {
            v9_1 = ((CoroutineName)v9).getName();
            if(v9_1 == null) {
                goto label_5;
            }
        }
        else {
        label_5:
            v9_1 = "coroutine";
        }

        Thread v0 = Thread.currentThread();
        String v1 = v0.getName();
        int v2 = StringsKt.lastIndexOf$default(v1, " @", 0, false, 6, null);
        if(v2 < 0) {
            v2 = v1.length();
        }

        StringBuilder v4 = new StringBuilder(v9_1.length() + v2 + 10);
        String v2_1 = v1.substring(0, v2);
        Intrinsics.checkNotNullExpressionValue(v2_1, "substring(...)");
        v4.append(v2_1);
        v4.append(" @");
        v4.append(v9_1);
        v4.append('#');
        v4.append(this.id);
        v0.setName(v4.toString());
        return v1;
    }
}

