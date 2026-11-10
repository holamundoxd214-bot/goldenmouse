package okio;

import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u0017*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u0005:\u0001\u0017B\u001D\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u0016\u0010\u0014\u001A\u00028\u00002\u0006\u0010\u0015\u001A\u00020\u0011H\u0096\u0002¢\u0006\u0002\u0010\u0016R\u0014\u0010\b\u001A\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u001A\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2={"Lokio/TypedOptions;", "T", "", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "list", "", "options", "Lokio/Options;", "<init>", "(Ljava/util/List;Lokio/Options;)V", "getOptions$okio", "()Lokio/Options;", "getList$okio", "()Ljava/util/List;", "size", "", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "Companion", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class TypedOptions extends AbstractList implements RandomAccess {
    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00060\b2\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u000B0\nH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2={"Lokio/TypedOptions$Companion;", "", "<init>", "()V", "of", "Lokio/TypedOptions;", "T", "values", "", "encode", "Lkotlin/Function1;", "Lokio/ByteString;", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final TypedOptions of(Iterable arg5, Function1 arg6) {
            Intrinsics.checkNotNullParameter(arg5, "values");
            Intrinsics.checkNotNullParameter(arg6, "encode");
            List v4 = CollectionsKt.toList(arg5);
            okio.Options$Companion v5 = Options.Companion;
            int v0 = v4.size();
            ByteString[] v1 = new ByteString[v0];
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                v1[v2] = arg6.invoke(v4.get(v2));
            }

            return new TypedOptions(v4, v5.of(v1));
        }
    }

    public static final Companion Companion;
    private final List list;
    private final Options options;

    static {
        TypedOptions.Companion = new Companion(null);
    }

    public TypedOptions(List arg2, Options arg3) {
        Intrinsics.checkNotNullParameter(arg2, "list");
        Intrinsics.checkNotNullParameter(arg3, "options");
        super();
        this.options = arg3;
        arg2 = CollectionsKt.toList(((Iterable)arg2));
        this.list = arg2;
        if(arg2.size() == arg3.size()) {
            return;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public Object get(int arg1) {
        return this.list.get(arg1);
    }

    public final List getList$okio() {
        return this.list;
    }

    public final Options getOptions$okio() {
        return this.options;
    }

    public int getSize() {
        return this.list.size();
    }

    @JvmStatic public static final TypedOptions of(Iterable arg1, Function1 arg2) {
        return TypedOptions.Companion.of(arg1, arg2);
    }
}

