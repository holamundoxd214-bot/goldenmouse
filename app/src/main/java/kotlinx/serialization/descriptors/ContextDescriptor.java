package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.ExperimentalSerializationApi;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001B\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0096\u0002J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\b\u0010\u0011\u001A\u00020\bH\u0016J\u0017\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001A\u00020\u0010H\u0097\u0001J\u0011\u0010\u0016\u001A\u00020\u00012\u0006\u0010\u0015\u001A\u00020\u0010H\u0097\u0001J\u0011\u0010\u0017\u001A\u00020\u00102\u0006\u0010\u0018\u001A\u00020\bH\u0097\u0001J\u0011\u0010\u0019\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\u0010H\u0097\u0001J\u0011\u0010\u001A\u001A\u00020\f2\u0006\u0010\u0015\u001A\u00020\u0010H\u0097\u0001R\u000E\u0010\u0002\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u001A\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00140\u00138VX\u0097\u0005¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001E\u001A\u00020\u00108\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\f8VX\u0096\u0005¢\u0006\u0006\u001A\u0004\b!\u0010\"R\u0014\u0010#\u001A\u00020\f8VX\u0097\u0005¢\u0006\u0006\u001A\u0004\b#\u0010\"R\u0014\u0010$\u001A\u00020%8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b&\u0010\'¨\u0006("}, d2={"Lkotlinx/serialization/descriptors/ContextDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "original", "kClass", "Lkotlin/reflect/KClass;", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/reflect/KClass;)V", "serialName", "", "getSerialName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "annotations", "getAnnotations", "()Ljava/util/List;", "elementsCount", "getElementsCount", "()I", "isInline", "()Z", "isNullable", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) final class ContextDescriptor implements SerialDescriptor {
    public final KClass kClass;
    private final SerialDescriptor original;
    private final String serialName;

    public ContextDescriptor(SerialDescriptor arg2, KClass arg3) {
        Intrinsics.checkNotNullParameter(arg2, "original");
        Intrinsics.checkNotNullParameter(arg3, "kClass");
        super();
        this.original = arg2;
        this.kClass = arg3;
        this.serialName = arg2.getSerialName() + '<' + arg3.getSimpleName() + '>';
    }

    public boolean equals(Object arg4) {
        if((arg4 instanceof ContextDescriptor)) {
        }
        else {
            ContextDescriptor v4 = null;
        }

        if(0 == 0) {
            return 0;
        }

        if((Intrinsics.areEqual(this.original, v4.original)) && (Intrinsics.areEqual(v4.kClass, this.kClass))) {
            return 1;
        }

        return 0;
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

    public String getSerialName() {
        return this.serialName;
    }

    public int hashCode() {
        return this.kClass.hashCode() * 0x1F + this.getSerialName().hashCode();
    }

    @ExperimentalSerializationApi public boolean isElementOptional(int arg1) {
        return this.original.isElementOptional(arg1);
    }

    public boolean isInline() {
        return this.original.isInline();
    }

    public boolean isNullable() {
        return this.original.isNullable();
    }

    public String toString() {
        return "ContextDescriptor(kClass: " + this.kClass + ", original: " + this.original + ')';
    }
}

