package kotlin.enums;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \r*\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004:\u0001\rB\u0017\bF\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u000B\u001A\u00020\fH\u0082\u0080\u0004R\u0015\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\nX\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lkotlin/enums/EnumEntriesSerializationProxy;", "E", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "entries", "", "<init>", "([Ljava/lang/Enum;)V", "c", "Ljava/lang/Class;", "readResolve", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class EnumEntriesSerializationProxy implements Serializable {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lkotlin/enums/EnumEntriesSerializationProxy$Companion;", "", "<init>", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    private static final Companion Companion;
    private final Class c;
    private static final long serialVersionUID;

    static {
        EnumEntriesSerializationProxy.Companion = new Companion(null);
    }

    public EnumEntriesSerializationProxy(Enum[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "entries");
        super();
        Class v2 = arg2.getClass().getComponentType();
        Intrinsics.checkNotNull(v2);
        this.c = v2;
    }

    private final Object readResolve() {
        Object[] v1 = this.c.getEnumConstants();
        Intrinsics.checkNotNullExpressionValue(v1, "getEnumConstants(...)");
        return EnumEntriesKt.enumEntries(((Enum[])v1));
    }
}

