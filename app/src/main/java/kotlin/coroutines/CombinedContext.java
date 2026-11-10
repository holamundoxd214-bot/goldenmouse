package kotlin.coroutines;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001(B\u0019\bF\u0012\u0006\u0010\u0004\u001A\u00020\u0001\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\t\u001A\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00062\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\n0\fH\u0096\u0082\u0004¢\u0006\u0002\u0010\rJ7\u0010\u000E\u001A\u0002H\u000F\"\u0004\b\u0000\u0010\u000F2\u0006\u0010\u0010\u001A\u0002H\u000F2\u0018\u0010\u0011\u001A\u0014\u0012\u0004\u0012\u0002H\u000F\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u000F0\u0012H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001A\u00020\u00012\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\fH\u0096\u0080\u0004J\n\u0010\u0015\u001A\u00020\u0016H\u0082\u0080\u0004J\u0012\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0005\u001A\u00020\u0006H\u0082\u0080\u0004J\u0012\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u0000H\u0082\u0080\u0004J\u0014\u0010\u001B\u001A\u00020\u00182\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0096\u0082\u0004J\n\u0010\u001E\u001A\u00020\u0016H\u0096\u0080\u0004J\n\u0010\u001F\u001A\u00020 H\u0096\u0080\u0004J\n\u0010!\u001A\u00020\u001DH\u0082\u0080\u0004J\u001B\u0010\"\u001A\u00020#2\n\u0010$\u001A\u00060%j\u0002`&H\u0082\u0080\u0004¢\u0006\u0002\u0010\'R\u000F\u0010\u0004\u001A\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0005\u001A\u00020\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006)"}, d2={"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "minusKey", "size", "", "contains", "", "containsAll", "context", "equals", "other", "", "hashCode", "toString", "", "writeReplace", "readObject", "", "input", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "(Ljava/io/ObjectInputStream;)V", "Serialized", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class CombinedContext implements Serializable, CoroutineContext {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \r2\u00060\u0001j\u0002`\u0002:\u0001\rB\u0017\bF\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u000B\u001A\u00020\fH\u0082\u0080\u0004R\u001D\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\t¨\u0006\u000E"}, d2={"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "elements", "", "Lkotlin/coroutines/CoroutineContext;", "<init>", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class Serialized implements Serializable {
        @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lkotlin/coroutines/CombinedContext$Serialized$Companion;", "", "<init>", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
            public Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private Companion() {
                super();
            }
        }

        public static final Companion Companion;
        private final CoroutineContext[] elements;
        private static final long serialVersionUID;

        static {
            Serialized.Companion = new Companion(null);
        }

        public Serialized(CoroutineContext[] arg2) {
            Intrinsics.checkNotNullParameter(arg2, "elements");
            super();
            this.elements = arg2;
        }

        public final CoroutineContext[] getElements() {
            return this.elements;
        }

        private final Object readResolve() {
            CoroutineContext[] v4 = this.elements;
            EmptyCoroutineContext v0 = EmptyCoroutineContext.INSTANCE;
            int v1 = v4.length;
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                CoroutineContext v0_1 = ((CoroutineContext)v0).plus(v4[v2]);
            }

            return v0;
        }
    }

    private final Element element;
    private final CoroutineContext left;

    public CombinedContext(CoroutineContext arg2, Element arg3) {
        Intrinsics.checkNotNullParameter(arg2, "left");
        Intrinsics.checkNotNullParameter(arg3, "element");
        super();
        this.left = arg2;
        this.element = arg3;
    }

    private final boolean contains(Element arg2) {
        return Intrinsics.areEqual(this.get(arg2.getKey()), arg2);
    }

    private final boolean containsAll(CombinedContext arg2) {
        CoroutineContext v2;
        while(true) {
            if(!this.contains(arg2.element)) {
                return 0;
            }

            v2 = ((CombinedContext)v2).left;
            if(!(v2 instanceof CombinedContext)) {
                break;
            }
        }

        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
        return this.contains(((Element)v2));
    }

    public boolean equals(Object arg3) {
        if(this != (((CombinedContext)arg3)) && (!(arg3 instanceof CombinedContext) || ((CombinedContext)arg3).size() != this.size() || !((CombinedContext)arg3).containsAll(this))) {
            return 0;
        }

        return 1;
    }

    public Object fold(Object arg2, Function2 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "operation");
        return arg3.invoke(this.left.fold(arg2, arg3), this.element);
    }

    public Element get(Key arg2) {
        CoroutineContext v1;
        Intrinsics.checkNotNullParameter(arg2, "key");
        while(true) {
            Element v0 = this.element.get(arg2);
            if(v0 != null) {
                return v0;
            }

            v1 = ((CombinedContext)v1).left;
            if(!(v1 instanceof CombinedContext)) {
                break;
            }
        }

        return v1.get(arg2);
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    public CoroutineContext minusKey(Key arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        Element v0 = this.element.get(arg3);
        CoroutineContext v1 = this.left;
        if(v0 != null) {
            return v1;
        }

        CoroutineContext v3 = v1.minusKey(arg3);
        if(v3 == this.left) {
            return this;
        }

        if(v3 == EmptyCoroutineContext.INSTANCE) {
            return this.element;
        }

        return new CombinedContext(v3, this.element);
    }

    public CoroutineContext plus(CoroutineContext arg1) {
        return DefaultImpls.plus(((CoroutineContext)this), arg1);
    }

    private final void readObject(ObjectInputStream arg1) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final int size() {
        int v0;
        for(v0 = 2; true; ++v0) {
            CoroutineContext v2 = ((CombinedContext)v2).left;
            if((v2 instanceof CombinedContext)) {
            }
            else {
                this = null;
            }

            if(v2 == null) {
                return v0;
            }
        }
    }

    public String toString() {
        return "[" + this.fold("", new CombinedContext$$ExternalSyntheticLambda1()) + ']';
    }

    static final String toString$lambda$0(String arg1, Element arg2) {
        Intrinsics.checkNotNullParameter(arg1, "acc");
        Intrinsics.checkNotNullParameter(arg2, "element");
        if(arg1.length() == 0) {
            return arg2.toString();
        }

        return arg1 + ", " + arg2;
    }

    private final Object writeReplace() {
        int v0 = this.size();
        CoroutineContext[] v1 = new CoroutineContext[v0];
        IntRef v2 = new IntRef();
        this.fold(Unit.INSTANCE, new CombinedContext$$ExternalSyntheticLambda0(v1, v2));
        if(v2.element == v0) {
            return new Serialized(v1);
        }

        throw new IllegalStateException("Check failed.");
    }

    static final Unit writeReplace$lambda$0(CoroutineContext[] arg1, IntRef arg2, Unit arg3, Element arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<unused var>");
        Intrinsics.checkNotNullParameter(arg4, "element");
        int v3 = arg2.element;
        arg2.element = v3 + 1;
        arg1[v3] = ((CoroutineContext)arg4);
        return Unit.INSTANCE;
    }
}

