package kotlin.properties;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0001H\u0086\u0080\u0004J\u0081\u0001\u0010\u0007\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\u0006\u0010\b\u001A\u0002H\u00062Q\b\u0004\u0010\t\u001AK\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000B¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000E\u0012\u0013\u0012\u0011H\u0006¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000F\u0012\u0013\u0012\u0011H\u0006¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\nH\u0086\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0081\u0001\u0010\u0013\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\u0006\u0010\b\u001A\u0002H\u00062Q\b\u0004\u0010\t\u001AK\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000B¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000E\u0012\u0013\u0012\u0011H\u0006¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000F\u0012\u0013\u0012\u0011H\u0006¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00140\nH\u0086\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2={"Lkotlin/properties/Delegates;", "", "<init>", "()V", "notNull", "Lkotlin/properties/ReadWriteProperty;", "T", "observable", "initialValue", "onChange", "Lkotlin/Function3;", "Lkotlin/reflect/KProperty;", "Lkotlin/ParameterName;", "name", "property", "oldValue", "newValue", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlin/properties/ReadWriteProperty;", "vetoable", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Delegates {
    public static final Delegates INSTANCE;

    static {
        Delegates.INSTANCE = new Delegates();
    }

    private Delegates() {
        super();
    }

    public final ReadWriteProperty notNull() {
        return new NotNullVar();
    }

    public final ReadWriteProperty observable(Object arg1, Function3 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "onChange");
        return new Delegates$observable$1(arg1, arg2);
    }

    public final ReadWriteProperty vetoable(Object arg1, Function3 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "onChange");
        return new Delegates$vetoable$1(arg1, arg2);
    }
}

