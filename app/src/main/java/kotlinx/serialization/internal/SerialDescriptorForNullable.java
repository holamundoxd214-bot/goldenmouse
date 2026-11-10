package kotlinx.serialization.internal;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0013\u001A\u00020\u00112\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001A\u00020\tH\u0016J\b\u0010\u0017\u001A\u00020\u0018H\u0016J\u0017\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001A2\u0006\u0010\u001C\u001A\u00020\u0018H\u0097\u0001J\u0011\u0010\u001D\u001A\u00020\u00012\u0006\u0010\u001C\u001A\u00020\u0018H\u0097\u0001J\u0011\u0010\u001E\u001A\u00020\u00182\u0006\u0010\u001F\u001A\u00020\tH\u0097\u0001J\u0011\u0010 \u001A\u00020\t2\u0006\u0010\u001C\u001A\u00020\u0018H\u0097\u0001J\u0011\u0010!\u001A\u00020\u00112\u0006\u0010\u001C\u001A\u00020\u0018H\u0097\u0001R\u0014\u0010\u0003\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u001A\u0010\f\u001A\b\u0012\u0004\u0012\u00020\t0\rX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0012R\u001A\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001A8VX\u0097\u0005¢\u0006\u0006\u001A\u0004\b#\u0010$R\u0014\u0010%\u001A\u00020\u00188\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b&\u0010\'R\u0014\u0010(\u001A\u00020\u00118VX\u0096\u0005¢\u0006\u0006\u001A\u0004\b(\u0010\u0012R\u0014\u0010)\u001A\u00020*8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b+\u0010,¨\u0006-"}, d2={"Lkotlinx/serialization/internal/SerialDescriptorForNullable;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "original", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getOriginal$kotlinx_serialization_core", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "getSerialName", "()Ljava/lang/String;", "serialNames", "", "getSerialNames", "()Ljava/util/Set;", "isNullable", "", "()Z", "equals", "other", "", "toString", "hashCode", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "annotations", "getAnnotations", "()Ljava/util/List;", "elementsCount", "getElementsCount", "()I", "isInline", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SerialDescriptorForNullable implements SerialDescriptor, CachedNames {
    private final SerialDescriptor original;
    private final String serialName;
    private final Set serialNames;

    public SerialDescriptorForNullable(SerialDescriptor arg3) {
        Intrinsics.checkNotNullParameter(arg3, "original");
        super();
        this.original = arg3;
        this.serialName = arg3.getSerialName() + '?';
        this.serialNames = Platform_commonKt.cachedSerialNames(arg3);
    }

    public boolean equals(Object arg4) {
        if(this == (((SerialDescriptorForNullable)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof SerialDescriptorForNullable)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.original, ((SerialDescriptorForNullable)arg4).original)) {
            return 0;
        }

        return 1;
    }

    public List getAnnotations() {
        return this.original.getAnnotations();
    }

    @ExperimentalSerializationApi public List getElementAnnotations(int arg1) {
        return this.original.getElementAnnotations(arg1);
    }

    @ExperimentalSerializationApi public SerialDescriptor getElementDescriptor(int arg1) {
        return this.original.getElementDescriptor(arg1);
    }

    @ExperimentalSerializationApi public int getElementIndex(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "name");
        return this.original.getElementIndex(arg2);
    }

    @ExperimentalSerializationApi public String getElementName(int arg1) {
        return this.original.getElementName(arg1);
    }

    public int getElementsCount() {
        return this.original.getElementsCount();
    }

    public SerialKind getKind() {
        return this.original.getKind();
    }

    public final SerialDescriptor getOriginal$kotlinx_serialization_core() {
        return this.original;
    }

    public String getSerialName() {
        return this.serialName;
    }

    public Set getSerialNames() {
        return this.serialNames;
    }

    public int hashCode() {
        return this.original.hashCode() * 0x1F;
    }

    @ExperimentalSerializationApi public boolean isElementOptional(int arg1) {
        return this.original.isElementOptional(arg1);
    }

    public boolean isInline() {
        return this.original.isInline();
    }

    public boolean isNullable() {
        return 1;
    }

    public String toString() {
        return this.original + '?';
    }
}

