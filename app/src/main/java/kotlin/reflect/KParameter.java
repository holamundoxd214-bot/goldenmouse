package kotlin.reflect;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u0018R\u0013\u0010\u0002\u001A\u00020\u0003X¦\u0084\b¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0006\u001A\u0004\u0018\u00010\u0007X¦\u0084\b¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0013\u0010\n\u001A\u00020\u000BX¦\u0084\b¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0013\u0010\u000E\u001A\u00020\u000FX¦\u0084\b¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001A\u00020\u0013X¦\u0084\b¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0014R\u001B\u0010\u0015\u001A\u00020\u00138&X§\u0084\b¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0015\u0010\u0014¨\u0006\u0019"}, d2={"Lkotlin/reflect/KParameter;", "Lkotlin/reflect/KAnnotatedElement;", "index", "", "getIndex", "()I", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "kind", "Lkotlin/reflect/KParameter$Kind;", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "isOptional", "", "()Z", "isVararg", "isVararg$annotations", "()V", "Kind", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public interface KParameter extends KAnnotatedElement {
    @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class DefaultImpls {
        public static void isVararg$annotations() {
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lkotlin/reflect/KParameter$Kind;", "", "<init>", "(Ljava/lang/String;I)V", "INSTANCE", "CONTEXT", "EXTENSION_RECEIVER", "VALUE", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public enum Kind {
        public static final enum Kind CONTEXT;
        public static final enum Kind EXTENSION_RECEIVER;
        public static final enum Kind INSTANCE;
        public static final enum Kind VALUE;

        private static final Kind[] $values() {
            return new Kind[]{Kind.INSTANCE, Kind.CONTEXT, Kind.EXTENSION_RECEIVER, Kind.VALUE};
        }

        static {
            Kind.INSTANCE = new Kind("INSTANCE", 0);
            Kind.CONTEXT = new Kind("CONTEXT", 1);
            Kind.EXTENSION_RECEIVER = new Kind("EXTENSION_RECEIVER", 2);
            Kind.VALUE = new Kind("VALUE", 3);
            Kind[] v0 = Kind.$values();
            Kind.$VALUES = v0;
            Kind.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private Kind(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return Kind.$ENTRIES;
        }

        public static Kind valueOf(String arg1) {
            return Enum.valueOf(Kind.class, arg1);
        }

        public static Kind[] values() {
            return Kind.$VALUES.clone();
        }
    }

    int getIndex();

    Kind getKind();

    String getName();

    KType getType();

    boolean isOptional();

    boolean isVararg();
}

