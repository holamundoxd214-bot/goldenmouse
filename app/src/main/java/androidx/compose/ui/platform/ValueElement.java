package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\f\u001A\u0004\u0018\u00010\u0001HÆ\u0003J\u001F\u0010\r\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0014"}, d2={"Landroidx/compose/ui/platform/ValueElement;", "", "name", "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "getName", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ValueElement {
    public static final int $stable = 8;
    private final String name;
    private final Object value;

    static {
    }

    public ValueElement(String arg1, Object arg2) {
        super();
        this.name = arg1;
        this.value = arg2;
    }

    public final String component1() {
        return this.name;
    }

    public final Object component2() {
        return this.value;
    }

    public final ValueElement copy(String arg1, Object arg2) {
        return new ValueElement(arg1, arg2);
    }

    public static ValueElement copy$default(ValueElement arg0, String arg1, Object arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.name;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.value;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((ValueElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ValueElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.name, ((ValueElement)arg5).name)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.value, ((ValueElement)arg5).value)) {
            return 0;
        }

        return 1;
    }

    public final String getName() {
        return this.name;
    }

    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        int v0 = this.name.hashCode() * 0x1F;
        Object v1 = this.value;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        return v0 + v1_1;
    }

    public String toString() {
        return "ValueElement(name=" + this.name + ", value=" + this.value + ')';
    }
}

