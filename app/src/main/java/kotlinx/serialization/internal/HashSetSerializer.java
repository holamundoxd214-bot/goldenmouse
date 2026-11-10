package kotlinx.serialization.internal;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012*\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00010\u0004j\b\u0012\u0004\u0012\u0002H\u0001`\u00050\u0002B\u0015\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000E\u001A\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014J\u001C\u0010\u000F\u001A\u00020\u0010*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014J\"\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014J\"\u0010\u0012\u001A\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0014J$\u0010\u0013\u001A\u00020\u0014*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u0015\u001A\u00020\u0010H\u0014J1\u0010\u0016\u001A\u00020\u0014*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u0017\u001A\u00020\u00102\u0006\u0010\u0018\u001A\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0019R\u0014\u0010\n\u001A\u00020\u000BX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u001A"}, d2={"Lkotlinx/serialization/internal/HashSetSerializer;", "E", "Lkotlinx/serialization/internal/CollectionSerializer;", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "eSerializer", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "builder", "builderSize", "", "toResult", "toBuilder", "checkCapacity", "", "size", "insert", "index", "element", "(Ljava/util/HashSet;ILjava/lang/Object;)V", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class HashSetSerializer extends CollectionSerializer {
    private final SerialDescriptor descriptor;

    public HashSetSerializer(KSerializer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "eSerializer");
        super(arg2);
        this.descriptor = new HashSetClassDesc(arg2.getDescriptor());
    }

    public Object builder() {
        return this.builder();
    }

    protected HashSet builder() {
        return new HashSet();
    }

    public int builderSize(Object arg1) {
        return this.builderSize(((HashSet)arg1));
    }

    protected int builderSize(HashSet arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.size();
    }

    public void checkCapacity(Object arg1, int arg2) {
        this.checkCapacity(((HashSet)arg1), arg2);
    }

    protected void checkCapacity(HashSet arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
    }

    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public void insert(Object arg1, int arg2, Object arg3) {
        this.insert(((HashSet)arg1), arg2, arg3);
    }

    protected void insert(HashSet arg1, int arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.add(arg3);
    }

    public Object toBuilder(Object arg1) {
        return this.toBuilder(((Set)arg1));
    }

    protected HashSet toBuilder(Set arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Set v0 = (arg1 instanceof HashSet) ? arg1 : null;
        if(v0 == null) {
            HashSet v0_1 = new HashSet(((Collection)arg1));
        }

        return ((HashSet)v0);
    }

    public Object toResult(Object arg1) {
        return this.toResult(((HashSet)arg1));
    }

    protected Set toResult(HashSet arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1;
    }
}

