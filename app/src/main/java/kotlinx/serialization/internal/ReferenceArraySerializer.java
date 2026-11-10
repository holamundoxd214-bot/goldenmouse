package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\n\b\u0001\u0010\u0003*\u0004\u0018\u0001H\u00012*\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00030\u0006j\b\u0012\u0004\u0012\u0002H\u0003`\u00070\u0004B#\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\t\u0012\f\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00010\u000B¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0012\u001A\u00020\u0013*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0014¢\u0006\u0002\u0010\u0014J\u001D\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00010\u0016*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0014¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001A\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007H\u0014J\u001C\u0010\u0019\u001A\u00020\u0013*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007H\u0014J\'\u0010\u001A\u001A\b\u0012\u0004\u0012\u00028\u00010\u0005*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007H\u0014¢\u0006\u0002\u0010\u001BJ\'\u0010\u001C\u001A\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0014¢\u0006\u0002\u0010\u001DJ$\u0010\u001E\u001A\u00020\u001F*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00072\u0006\u0010 \u001A\u00020\u0013H\u0014J1\u0010!\u001A\u00020\u001F*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00072\u0006\u0010\"\u001A\u00020\u00132\u0006\u0010#\u001A\u00028\u0001H\u0014¢\u0006\u0002\u0010$R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000E\u001A\u00020\u000FX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006%"}, d2={"Lkotlinx/serialization/internal/ReferenceArraySerializer;", "ElementKlass", "", "Element", "Lkotlinx/serialization/internal/CollectionLikeSerializer;", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "kClass", "Lkotlin/reflect/KClass;", "eSerializer", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "collectionSize", "", "([Ljava/lang/Object;)I", "collectionIterator", "", "([Ljava/lang/Object;)Ljava/util/Iterator;", "builder", "builderSize", "toResult", "(Ljava/util/ArrayList;)[Ljava/lang/Object;", "toBuilder", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "checkCapacity", "", "size", "insert", "index", "element", "(Ljava/util/ArrayList;ILjava/lang/Object;)V", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ReferenceArraySerializer extends CollectionLikeSerializer {
    private final SerialDescriptor descriptor;
    private final KClass kClass;

    public ReferenceArraySerializer(KClass arg2, KSerializer arg3) {
        Intrinsics.checkNotNullParameter(arg2, "kClass");
        Intrinsics.checkNotNullParameter(arg3, "eSerializer");
        super(arg3, null);
        this.kClass = arg2;
        this.descriptor = new ArrayClassDesc(arg3.getDescriptor());
    }

    public Object builder() {
        return this.builder();
    }

    protected ArrayList builder() {
        return new ArrayList();
    }

    public int builderSize(Object arg1) {
        return this.builderSize(((ArrayList)arg1));
    }

    protected int builderSize(ArrayList arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.size();
    }

    public void checkCapacity(Object arg1, int arg2) {
        this.checkCapacity(((ArrayList)arg1), arg2);
    }

    protected void checkCapacity(ArrayList arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.ensureCapacity(arg2);
    }

    public Iterator collectionIterator(Object arg1) {
        return this.collectionIterator(((Object[])arg1));
    }

    protected Iterator collectionIterator(Object[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return ArrayIteratorKt.iterator(arg1);
    }

    public int collectionSize(Object arg1) {
        return this.collectionSize(((Object[])arg1));
    }

    protected int collectionSize(Object[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.length;
    }

    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public void insert(Object arg1, int arg2, Object arg3) {
        this.insert(((ArrayList)arg1), arg2, arg3);
    }

    protected void insert(ArrayList arg1, int arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.add(arg2, arg3);
    }

    public Object toBuilder(Object arg1) {
        return this.toBuilder(((Object[])arg1));
    }

    protected ArrayList toBuilder(Object[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new ArrayList(ArraysKt.asList(arg1));
    }

    public Object toResult(Object arg1) {
        return this.toResult(((ArrayList)arg1));
    }

    protected Object[] toResult(ArrayList arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return PlatformKt.toNativeArrayImpl(arg2, this.kClass);
    }
}

