package kotlinx.serialization.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor$DefaultImpls;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\rH\u0016J\u0010\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\u0003H\u0016J\u0010\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0011\u001A\u00020\rH\u0016J\u0010\u0010\u0016\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\rH\u0016J\u0016\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0011\u001A\u00020\rH\u0016J\b\u0010\u001A\u001A\u00020\u0003H\u0016J\u0013\u0010\u001B\u001A\u00020\u00152\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0096\u0002J\b\u0010\u001E\u001A\u00020\rH\u0016J\b\u0010\u001F\u001A\u00020 H\u0002R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006!"}, d2={"Lkotlinx/serialization/internal/PrimitiveSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/PrimitiveKind;)V", "getSerialName", "()Ljava/lang/String;", "getKind", "()Lkotlinx/serialization/descriptors/PrimitiveKind;", "elementsCount", "", "getElementsCount", "()I", "getElementName", "index", "getElementIndex", "name", "isElementOptional", "", "getElementDescriptor", "getElementAnnotations", "", "", "toString", "equals", "other", "", "hashCode", "error", "", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PrimitiveSerialDescriptor implements SerialDescriptor {
    private final PrimitiveKind kind;
    private final String serialName;

    public PrimitiveSerialDescriptor(String arg2, PrimitiveKind arg3) {
        Intrinsics.checkNotNullParameter(arg2, "serialName");
        Intrinsics.checkNotNullParameter(arg3, "kind");
        super();
        this.serialName = arg2;
        this.kind = arg3;
    }

    public boolean equals(Object arg5) {
        if(this == (((PrimitiveSerialDescriptor)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof PrimitiveSerialDescriptor)) {
            return 0;
        }

        if((Intrinsics.areEqual(this.getSerialName(), ((PrimitiveSerialDescriptor)arg5).getSerialName())) && (Intrinsics.areEqual(this.getKind(), ((PrimitiveSerialDescriptor)arg5).getKind()))) {
            return 1;
        }

        return 0;
    }

    private final Void error() {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public List getAnnotations() {
        return DefaultImpls.getAnnotations(((SerialDescriptor)this));
    }

    public List getElementAnnotations(int arg1) {
        this.error();
        throw new KotlinNothingValueException();
    }

    public SerialDescriptor getElementDescriptor(int arg1) {
        this.error();
        throw new KotlinNothingValueException();
    }

    public int getElementIndex(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "name");
        this.error();
        throw new KotlinNothingValueException();
    }

    public String getElementName(int arg1) {
        this.error();
        throw new KotlinNothingValueException();
    }

    public int getElementsCount() {
        return 0;
    }

    public PrimitiveKind getKind() {
        return this.kind;
    }

    public SerialKind getKind() {
        return this.getKind();
    }

    public String getSerialName() {
        return this.serialName;
    }

    public int hashCode() {
        return this.getSerialName().hashCode() + this.getKind().hashCode() * 0x1F;
    }

    public boolean isElementOptional(int arg1) {
        this.error();
        throw new KotlinNothingValueException();
    }

    public boolean isInline() {
        return DefaultImpls.isInline(((SerialDescriptor)this));
    }

    public boolean isNullable() {
        return DefaultImpls.isNullable(((SerialDescriptor)this));
    }

    public String toString() {
        return "PrimitiveDescriptor(" + this.getSerialName() + ')';
    }
}

