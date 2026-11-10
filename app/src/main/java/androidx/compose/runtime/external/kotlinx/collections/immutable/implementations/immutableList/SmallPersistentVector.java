package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010*\n\u0002\b\u0005\b\u0001\u0018\u0000 )*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001)B\u0017\u0012\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001D\u0010\u000E\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\n\u001A\u00020\u000BH\u0002¢\u0006\u0002\u0010\u000FJ\u001B\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0012\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u001C\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u00112\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016J\"\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001A0\u0019H\u0016J$\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u001B\u001A\u00020\u000B2\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016J#\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u001B\u001A\u00020\u000B2\u0006\u0010\u0012\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001DJ\u0016\u0010\u001E\u001A\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u001B\u001A\u00020\u000BH\u0016J\u000E\u0010\u001F\u001A\b\u0012\u0004\u0012\u00028\u00000 H\u0016J\u0015\u0010!\u001A\u00020\u000B2\u0006\u0010\u0012\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u0015\u0010#\u001A\u00020\u000B2\u0006\u0010\u0012\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u0016\u0010$\u001A\b\u0012\u0004\u0012\u00028\u00000%2\u0006\u0010\u001B\u001A\u00020\u000BH\u0016J\u0016\u0010&\u001A\u00028\u00002\u0006\u0010\u001B\u001A\u00020\u000BH\u0096\u0002¢\u0006\u0002\u0010\'J#\u0010(\u001A\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u001B\u001A\u00020\u000B2\u0006\u0010\u0012\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001DR\u0018\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006*"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractPersistentList;", "buffer", "", "", "<init>", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "size", "", "getSize", "()I", "bufferOfSize", "(I)[Ljava/lang/Object;", "add", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "addAll", "elements", "", "removeAll", "predicate", "Lkotlin/Function1;", "", "index", "c", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "removeAt", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList$Builder;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "listIterator", "", "get", "(I)Ljava/lang/Object;", "set", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SmallPersistentVector extends AbstractPersistentList implements ImmutableList {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector$Companion;", "", "<init>", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector;", "", "getEMPTY", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final SmallPersistentVector getEMPTY() {
            return SmallPersistentVector.EMPTY;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final SmallPersistentVector EMPTY;
    private final Object[] buffer;

    static {
        SmallPersistentVector.Companion = new Companion(null);
        SmallPersistentVector.$stable = 8;
        SmallPersistentVector.EMPTY = new SmallPersistentVector(new Object[0]);
    }

    public SmallPersistentVector(Object[] arg1) {
        super();
        this.buffer = arg1;
        boolean v0 = arg1.length <= 0x20 ? true : false;
        CommonFunctionsKt.assert(v0);
    }

    public static final SmallPersistentVector access$getEMPTY$cp() {
        return SmallPersistentVector.EMPTY;
    }

    public PersistentCollection add(Object arg1) {
        return this.add(arg1);
    }

    public PersistentList add(Object arg4) {
        if(this.size() < 0x20) {
            Object[] v0 = Arrays.copyOf(this.buffer, this.size() + 1);
            Intrinsics.checkNotNullExpressionValue(v0, "copyOf(...)");
            v0[this.size()] = arg4;
            return new SmallPersistentVector(v0);
        }

        return new PersistentVector(this.buffer, UtilsKt.presizedBufferWith(arg4), this.size() + 1, 0);
    }

    public PersistentList add(int arg9, Object arg10) {
        ListImplementation.checkPositionIndex$runtime(arg9, this.size());
        if(arg9 == this.size()) {
            return this.add(arg10);
        }

        if(this.size() < 0x20) {
            Object[] v2 = this.bufferOfSize(this.size() + 1);
            ArraysKt.copyInto$default(this.buffer, v2, 0, 0, arg9, 6, null);
            ArraysKt.copyInto(this.buffer, v2, arg9 + 1, arg9, this.size());
            v2[arg9] = arg10;
            return new SmallPersistentVector(v2);
        }

        int v5 = arg9;
        Object[] v9 = Arrays.copyOf(this.buffer, this.buffer.length);
        Intrinsics.checkNotNullExpressionValue(v9, "copyOf(...)");
        ArraysKt.copyInto(this.buffer, v9, v5 + 1, v5, this.size() - 1);
        v9[v5] = arg10;
        return new PersistentVector(v9, UtilsKt.presizedBufferWith(this.buffer[0x1F]), this.size() + 1, 0);
    }

    public PersistentCollection addAll(Collection arg1) {
        return this.addAll(arg1);
    }

    public PersistentList addAll(Collection arg4) {
        if(this.size() + arg4.size() <= 0x20) {
            Object[] v0 = Arrays.copyOf(this.buffer, this.size() + arg4.size());
            Intrinsics.checkNotNullExpressionValue(v0, "copyOf(...)");
            int v3 = this.size();
            Iterator v4 = arg4.iterator();
            while(v4.hasNext()) {
                v0[v3] = v4.next();
                ++v3;
            }

            return new SmallPersistentVector(v0);
        }

        Builder v3_1 = ((PersistentList)this).builder();
        v3_1.addAll(arg4);
        return v3_1.build();
    }

    public PersistentList addAll(int arg9, Collection arg10) {
        ListImplementation.checkPositionIndex$runtime(arg9, this.size());
        if(this.size() + arg10.size() <= 0x20) {
            Object[] v2 = this.bufferOfSize(this.size() + arg10.size());
            ArraysKt.copyInto$default(this.buffer, v2, 0, 0, arg9, 6, null);
            ArraysKt.copyInto(this.buffer, v2, arg10.size() + arg9, arg9, this.size());
            Iterator v8 = arg10.iterator();
            for(arg9 = arg9; v8.hasNext(); ++arg9) {
                v2[arg9] = v8.next();
            }

            return new SmallPersistentVector(v2);
        }

        Builder v8_1 = ((PersistentList)this).builder();
        v8_1.addAll(arg9, arg10);
        return v8_1.build();
    }

    private final Object[] bufferOfSize(int arg1) {
        return new Object[arg1];
    }

    public androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection$Builder builder() {
        return this.builder();
    }

    public Builder builder() {
        return new PersistentVectorBuilder(this, null, this.buffer, 0);
    }

    public Object get(int arg2) {
        ListImplementation.checkElementIndex$runtime(arg2, this.size());
        return this.buffer[arg2];
    }

    public int getSize() {
        return this.buffer.length;
    }

    public int indexOf(Object arg1) {
        return ArraysKt.indexOf(this.buffer, arg1);
    }

    public int lastIndexOf(Object arg1) {
        return ArraysKt.lastIndexOf(this.buffer, arg1);
    }

    public ListIterator listIterator(int arg3) {
        ListImplementation.checkPositionIndex$runtime(arg3, this.size());
        return new BufferIterator(this.buffer, arg3, this.size());
    }

    public PersistentCollection removeAll(Function1 arg1) {
        return this.removeAll(arg1);
    }

    public PersistentList removeAll(Function1 arg9) {
        Object[] v0 = this.buffer;
        int v1 = this.size();
        int v2 = this.size();
        int v4 = 0;
        int v5 = 0;
        while(v4 < v2) {
            Object v6 = this.buffer[v4];
            if(arg9.invoke(v6).booleanValue()) {
                if(v5 == 0) {
                    v0 = Arrays.copyOf(this.buffer, this.buffer.length);
                    Intrinsics.checkNotNullExpressionValue(v0, "copyOf(...)");
                    v5 = 1;
                    v1 = v4;
                }
            }
            else if(v5 != 0) {
                v0[v1] = v6;
                ++v1;
            }

            ++v4;
        }

        if(v1 == this.size()) {
            return this;
        }

        if(v1 == 0) {
            return SmallPersistentVector.EMPTY;
        }

        return new SmallPersistentVector(ArraysKt.copyOfRange(v0, 0, v1));
    }

    public PersistentList removeAt(int arg4) {
        ListImplementation.checkElementIndex$runtime(arg4, this.size());
        if(this.size() == 1) {
            return SmallPersistentVector.EMPTY;
        }

        Object[] v0 = Arrays.copyOf(this.buffer, this.size() - 1);
        Intrinsics.checkNotNullExpressionValue(v0, "copyOf(...)");
        ArraysKt.copyInto(this.buffer, v0, arg4, arg4 + 1, this.size());
        return new SmallPersistentVector(v0);
    }

    public PersistentList set(int arg2, Object arg3) {
        ListImplementation.checkElementIndex$runtime(arg2, this.size());
        Object[] v1 = Arrays.copyOf(this.buffer, this.buffer.length);
        Intrinsics.checkNotNullExpressionValue(v1, "copyOf(...)");
        v1[arg2] = arg3;
        return new SmallPersistentVector(v1);
    }
}

