package kotlinx.serialization.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010(\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022B\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004\u0012 \u0012\u001E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0005j\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002`\u00060\u0003B#\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\b\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0004\b\n\u0010\u000BJ\u0018\u0010\u0010\u001A\u00020\u0011*\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0014J*\u0010\u0012\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140\u0013*\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0014J$\u0010\u0015\u001A\u001E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006H\u0014J(\u0010\u0016\u001A\u00020\u0011*\u001E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006H\u0014J4\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004*\u001E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006H\u0014J4\u0010\u0018\u001A\u001E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006*\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0014J0\u0010\u0019\u001A\u00020\u001A*\u001E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00062\u0006\u0010\u001B\u001A\u00020\u0011H\u0014JE\u0010\u001C\u001A\u00020\u001A*\u001E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00062\u0006\u0010\u001D\u001A\u00020\u00112\u0006\u0010\u001E\u001A\u00028\u00002\u0006\u0010\u001F\u001A\u00028\u0001H\u0014¢\u0006\u0002\u0010 R\u0014\u0010\f\u001A\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006!"}, d2={"Lkotlinx/serialization/internal/LinkedHashMapSerializer;", "K", "V", "Lkotlinx/serialization/internal/MapLikeSerializer;", "", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "kSerializer", "Lkotlinx/serialization/KSerializer;", "vSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "collectionSize", "", "collectionIterator", "", "", "builder", "builderSize", "toResult", "toBuilder", "checkCapacity", "", "size", "insertKeyValuePair", "index", "key", "value", "(Ljava/util/LinkedHashMap;ILjava/lang/Object;Ljava/lang/Object;)V", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LinkedHashMapSerializer extends MapLikeSerializer {
    private final SerialDescriptor descriptor;

    public LinkedHashMapSerializer(KSerializer arg2, KSerializer arg3) {
        Intrinsics.checkNotNullParameter(arg2, "kSerializer");
        Intrinsics.checkNotNullParameter(arg3, "vSerializer");
        super(arg2, arg3, null);
        this.descriptor = new LinkedHashMapClassDesc(arg2.getDescriptor(), arg3.getDescriptor());
    }

    public Object builder() {
        return this.builder();
    }

    protected LinkedHashMap builder() {
        return new LinkedHashMap();
    }

    public int builderSize(Object arg1) {
        return this.builderSize(((LinkedHashMap)arg1));
    }

    protected int builderSize(LinkedHashMap arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.size() * 2;
    }

    public void checkCapacity(Object arg1, int arg2) {
        this.checkCapacity(((LinkedHashMap)arg1), arg2);
    }

    protected void checkCapacity(LinkedHashMap arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
    }

    public Iterator collectionIterator(Object arg1) {
        return this.collectionIterator(((Map)arg1));
    }

    protected Iterator collectionIterator(Map arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.entrySet().iterator();
    }

    public int collectionSize(Object arg1) {
        return this.collectionSize(((Map)arg1));
    }

    protected int collectionSize(Map arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.size();
    }

    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    protected void insertKeyValuePair(LinkedHashMap arg1, int arg2, Object arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        ((Map)arg1).put(arg3, arg4);
    }

    public void insertKeyValuePair(Map arg1, int arg2, Object arg3, Object arg4) {
        this.insertKeyValuePair(((LinkedHashMap)arg1), arg2, arg3, arg4);
    }

    public Object toBuilder(Object arg1) {
        return this.toBuilder(((Map)arg1));
    }

    protected LinkedHashMap toBuilder(Map arg1) {
        LinkedHashMap v0_1;
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Map v0 = (arg1 instanceof LinkedHashMap) ? arg1 : null;
        if(v0 == null) {
            v0_1 = new LinkedHashMap(arg1);
        }

        return v0_1;
    }

    public Object toResult(Object arg1) {
        return this.toResult(((LinkedHashMap)arg1));
    }

    protected Map toResult(LinkedHashMap arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1;
    }
}

