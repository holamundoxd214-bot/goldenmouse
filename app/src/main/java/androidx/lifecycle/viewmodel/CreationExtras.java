package androidx.lifecycle.viewmodel;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\b&\u0018\u0000 \u00162\u00020\u0001:\u0003\u0014\u0015\u0016B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\t\u001A\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\n0\u0006H¦\u0002¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001A\u00020\u0011H\u0016J\b\u0010\u0012\u001A\u00020\u0013H\u0016R&\u0010\u0004\u001A\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0017"}, d2={"Landroidx/lifecycle/viewmodel/CreationExtras;", "", "<init>", "()V", "extras", "", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "getExtras$lifecycle_viewmodel", "()Ljava/util/Map;", "get", "T", "key", "(Landroidx/lifecycle/viewmodel/CreationExtras$Key;)Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "toString", "", "Key", "Empty", "Companion", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class CreationExtras {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0006\b\u0000\u0010\u0006\u0018\u0001H\u0087\b¨\u0006\u0007"}, d2={"Landroidx/lifecycle/viewmodel/CreationExtras$Companion;", "", "<init>", "()V", "Key", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "T", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final Key Key() {
            Intrinsics.needClassReification();
            return new CreationExtras$Companion$Key$1();
        }
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001A\u0004\u0018\u0001H\u0005\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0096\u0002¢\u0006\u0002\u0010\b¨\u0006\t"}, d2={"Landroidx/lifecycle/viewmodel/CreationExtras$Empty;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "<init>", "()V", "get", "T", "key", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "(Landroidx/lifecycle/viewmodel/CreationExtras$Key;)Ljava/lang/Object;", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Empty extends CreationExtras {
        public static final Empty INSTANCE;

        static {
            Empty.INSTANCE = new Empty();
        }

        private Empty() {
            super();
        }

        public Object get(Key arg1) {
            Intrinsics.checkNotNullParameter(arg1, "key");
            return null;
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2={"Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "T", "", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public interface Key {
    }

    public static final Companion Companion;
    private final Map extras;

    static {
        CreationExtras.Companion = new Companion(null);
    }

    public CreationExtras() {
        super();
        this.extras = new LinkedHashMap();
    }

    public boolean equals(Object arg2) {
        if(((arg2 instanceof CreationExtras)) && (Intrinsics.areEqual(this.extras, ((CreationExtras)arg2).extras))) {
            return 1;
        }

        return 0;
    }

    public abstract Object get(Key arg1);

    public final Map getExtras$lifecycle_viewmodel() {
        return this.extras;
    }

    public int hashCode() {
        return this.extras.hashCode();
    }

    public String toString() {
        return "CreationExtras(extras=" + this.extras + ")";
    }
}

