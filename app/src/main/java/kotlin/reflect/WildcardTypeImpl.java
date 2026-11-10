package kotlin.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u001D\bF\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00040\tH\u0016¢\u0006\u0002\u0010\nJ\u0013\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00040\tH\u0016¢\u0006\u0002\u0010\nJ\n\u0010\f\u001A\u00020\rH\u0096\u0080\u0004J\u0014\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0096\u0082\u0004J\n\u0010\u0012\u001A\u00020\u0013H\u0096\u0080\u0004J\n\u0010\u0014\u001A\u00020\rH\u0096\u0080\u0004R\u0011\u0010\u0003\u001A\u0004\u0018\u00010\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001A\u0004\u0018\u00010\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Lkotlin/reflect/WildcardTypeImpl;", "Ljava/lang/reflect/WildcardType;", "Lkotlin/reflect/TypeImpl;", "upperBound", "Ljava/lang/reflect/Type;", "lowerBound", "<init>", "(Ljava/lang/reflect/Type;Ljava/lang/reflect/Type;)V", "getUpperBounds", "", "()[Ljava/lang/reflect/Type;", "getLowerBounds", "getTypeName", "", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class WildcardTypeImpl implements WildcardType, TypeImpl {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001A\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Lkotlin/reflect/WildcardTypeImpl$Companion;", "", "<init>", "()V", "STAR", "Lkotlin/reflect/WildcardTypeImpl;", "getSTAR", "()Lkotlin/reflect/WildcardTypeImpl;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final WildcardTypeImpl getSTAR() {
            return WildcardTypeImpl.STAR;
        }
    }

    public static final Companion Companion;
    private static final WildcardTypeImpl STAR;
    private final Type lowerBound;
    private final Type upperBound;

    static {
        WildcardTypeImpl.Companion = new Companion(null);
        WildcardTypeImpl.STAR = new WildcardTypeImpl(null, null);
    }

    public WildcardTypeImpl(Type arg1, Type arg2) {
        super();
        this.upperBound = arg1;
        this.lowerBound = arg2;
    }

    public static final WildcardTypeImpl access$getSTAR$cp() {
        return WildcardTypeImpl.STAR;
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof WildcardType)) && (Arrays.equals(this.getUpperBounds(), ((WildcardType)arg3).getUpperBounds())) && (Arrays.equals(this.getLowerBounds(), ((WildcardType)arg3).getLowerBounds()))) {
            return 1;
        }

        return 0;
    }

    public Type[] getLowerBounds() {
        Type v2 = this.lowerBound;
        if(v2 == null) {
            return new Type[0];
        }

        return new Type[]{v2};
    }

    public String getTypeName() {
        if(this.lowerBound != null) {
            return "? super " + TypesJVMKt.typeToString(this.lowerBound);
        }

        Type v0 = this.upperBound;
        if(v0 != null && !Intrinsics.areEqual(v0, Object.class)) {
            return "? extends " + TypesJVMKt.typeToString(this.upperBound);
        }

        return "?";
    }

    public Type[] getUpperBounds() {
        Type[] v0 = new Type[1];
        Type v2 = this.upperBound;
        if(v2 == null) {
            Class v2_1 = Object.class;
        }

        v0[0] = v2;
        return v0;
    }

    public int hashCode() {
        return Arrays.hashCode(this.getLowerBounds()) ^ Arrays.hashCode(this.getUpperBounds());
    }

    public String toString() {
        return this.getTypeName();
    }
}

