package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0006\u0010\f\u001A\u00020\rH\u0097\u0001J\u0011\u0010\u000E\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\rH\u0097\u0001J\u0011\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u0003H\u0097\u0001J\u0011\u0010\u0011\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\rH\u0097\u0001J\u0011\u0010\u0012\u001A\u00020\u00132\u0006\u0010\f\u001A\u00020\rH\u0097\u0001R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u001A\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u000B0\n8VX\u0097\u0005¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001A\u00020\r8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\u00138VX\u0096\u0005¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001C\u001A\u00020\u00138VX\u0097\u0005¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001BR\u0014\u0010\u001D\u001A\u00020\u001E8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b\u001F\u0010 ¨\u0006!"}, d2={"Lkotlinx/serialization/descriptors/WrappedSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "original", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getSerialName", "()Ljava/lang/String;", "getElementAnnotations", "", "", "index", "", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "", "annotations", "getAnnotations", "()Ljava/util/List;", "elementsCount", "getElementsCount", "()I", "isInline", "()Z", "isNullable", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WrappedSerialDescriptor implements SerialDescriptor {
    private final String serialName;

    public WrappedSerialDescriptor(String arg2, SerialDescriptor arg3) {
        Intrinsics.checkNotNullParameter(arg2, "serialName");
        Intrinsics.checkNotNullParameter(arg3, "original");
        super();
        this.$$delegate_0 = arg3;
        this.serialName = arg2;
    }

    public List getAnnotations() {
        return this.$$delegate_0.getAnnotations();
    }

    @ExperimentalSerializationApi public List getElementAnnotations(int arg1) {
        return this.$$delegate_0.getElementAnnotations(arg1);
    }

    @ExperimentalSerializationApi public SerialDescriptor getElementDescriptor(int arg1) {
        return this.$$delegate_0.getElementDescriptor(arg1);
    }

    @ExperimentalSerializationApi public int getElementIndex(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "name");
        return this.$$delegate_0.getElementIndex(arg2);
    }

    @ExperimentalSerializationApi public String getElementName(int arg1) {
        return this.$$delegate_0.getElementName(arg1);
    }

    public int getElementsCount() {
        return this.$$delegate_0.getElementsCount();
    }

    public SerialKind getKind() {
        return this.$$delegate_0.getKind();
    }

    public String getSerialName() {
        return this.serialName;
    }

    @ExperimentalSerializationApi public boolean isElementOptional(int arg1) {
        return this.$$delegate_0.isElementOptional(arg1);
    }

    public boolean isInline() {
        return this.$$delegate_0.isInline();
    }

    public boolean isNullable() {
        return this.$$delegate_0.isNullable();
    }
}

