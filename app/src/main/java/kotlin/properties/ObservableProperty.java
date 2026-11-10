package kotlin.properties;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\bF\u0012\u0006\u0010\u0004\u001A\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\t\u001A\u00020\n2\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001A\u00028\u00002\u0006\u0010\u000E\u001A\u00028\u0000H\u0094\u0080\u0004¢\u0006\u0002\u0010\u000FJ+\u0010\u0010\u001A\u00020\u00112\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001A\u00028\u00002\u0006\u0010\u000E\u001A\u00028\u0000H\u0094\u0080\u0004¢\u0006\u0002\u0010\u0012J%\u0010\u0013\u001A\u00028\u00002\b\u0010\u0014\u001A\u0004\u0018\u00010\u00032\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\fH\u0096\u0082\u0004¢\u0006\u0002\u0010\u0015J-\u0010\u0016\u001A\u00020\u00112\b\u0010\u0014\u001A\u0004\u0018\u00010\u00032\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0007\u001A\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0017J\n\u0010\u0018\u001A\u00020\u0019H\u0096\u0080\u0004R\u0011\u0010\u0007\u001A\u00028\u0000X\u0082\u008E\b¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u001A"}, d2={"Lkotlin/properties/ObservableProperty;", "V", "Lkotlin/properties/ReadWriteProperty;", "", "initialValue", "<init>", "(Ljava/lang/Object;)V", "value", "Ljava/lang/Object;", "beforeChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)Z", "afterChange", "", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "getValue", "thisRef", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class ObservableProperty implements ReadWriteProperty {
    private Object value;

    public ObservableProperty(Object arg1) {
        super();
        this.value = arg1;
    }

    protected void afterChange(KProperty arg1, Object arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "property");
    }

    protected boolean beforeChange(KProperty arg1, Object arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "property");
        return 1;
    }

    public Object getValue(Object arg1, KProperty arg2) {
        Intrinsics.checkNotNullParameter(arg2, "property");
        return this.value;
    }

    public void setValue(Object arg2, KProperty arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg3, "property");
        arg2 = this.value;
        if(!this.beforeChange(arg3, arg2, arg4)) {
            return;
        }

        this.value = arg4;
        this.afterChange(arg3, arg2, arg4);
    }

    public String toString() {
        return "ObservableProperty(value=" + this.value + ')';
    }
}

