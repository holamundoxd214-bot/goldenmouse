package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001A\u00020\u0002*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0004J\u0010\u0010\t\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\u0002H\u0004J\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0014J\u0018\u0010\r\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u0002H\u0014J\b\u0010\u0010\u001A\u00020\u0002H\u0004¨\u0006\u0011"}, d2={"Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/internal/TaggedDecoder;", "", "<init>", "()V", "getTag", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "", "nested", "nestedName", "elementName", "descriptor", "composeName", "parentName", "childName", "renderTagStack", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) @InternalSerializationApi public abstract class NamedValueDecoder extends TaggedDecoder {
    public NamedValueDecoder() {
        super();
    }

    protected String composeName(String arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "parentName");
        Intrinsics.checkNotNullParameter(arg2, "childName");
        if(arg1.length() == 0) {
            return arg2;
        }

        return arg1 + '.' + arg2;
    }

    protected String elementName(SerialDescriptor arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "descriptor");
        return arg1.getElementName(arg2);
    }

    public Object getTag(SerialDescriptor arg1, int arg2) {
        return this.getTag(arg1, arg2);
    }

    protected final String getTag(SerialDescriptor arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return this.nested(this.elementName(arg2, arg3));
    }

    protected final String nested(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "nestedName");
        Object v0 = this.getCurrentTagOrNull();
        if(v0 == null) {
            String v0_1 = "";
        }

        return this.composeName(((String)v0), arg2);
    }

    protected final String renderTagStack() {
        if(this.getTagStack$kotlinx_serialization_core().isEmpty()) {
            return "$";
        }

        return CollectionsKt.joinToString$default(this.getTagStack$kotlinx_serialization_core(), ".", "$.", null, 0, null, null, 60, null);
    }
}

