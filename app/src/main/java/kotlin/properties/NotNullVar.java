package kotlin.properties;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00010\u0003B\t\bF¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\b\u001A\u00028\u00002\b\u0010\t\u001A\u0004\u0018\u00010\u00022\n\u0010\n\u001A\u0006\u0012\u0002\b\u00030\u000BH\u0096\u0082\u0004¢\u0006\u0002\u0010\fJ-\u0010\r\u001A\u00020\u000E2\b\u0010\t\u001A\u0004\u0018\u00010\u00022\n\u0010\n\u001A\u0006\u0012\u0002\b\u00030\u000B2\u0006\u0010\u0006\u001A\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u000FJ\n\u0010\u0010\u001A\u00020\u0011H\u0096\u0080\u0004R\u0013\u0010\u0006\u001A\u0004\u0018\u00018\u0000X\u0082\u008E\b¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0012"}, d2={"Lkotlin/properties/NotNullVar;", "T", "", "Lkotlin/properties/ReadWriteProperty;", "<init>", "()V", "value", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class NotNullVar implements ReadWriteProperty {
    private Object value;

    public NotNullVar() {
        super();
    }

    public Object getValue(Object arg2, KProperty arg3) {
        Intrinsics.checkNotNullParameter(arg3, "property");
        Object v1 = this.value;
        if(v1 != null) {
            return v1;
        }

        throw new IllegalStateException("Property " + arg3.getName() + " should be initialized before get.");
    }

    public void setValue(Object arg1, KProperty arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg2, "property");
        Intrinsics.checkNotNullParameter(arg3, "value");
        this.value = arg3;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("NotNullProperty(");
        String v3 = this.value != null ? "value=" + this.value : "value not initialized yet";
        return v0.append(v3).append(')').toString();
    }
}

