package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\bH\u0014J-\u0010\t\u001A\u00028\u00002\n\u0010\n\u001A\u0006\u0012\u0002\b\u00030\b2\u000E\b\u0004\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\fH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0012\u0010\u000E\u001A\u00020\u000F2\n\u0010\n\u001A\u0006\u0012\u0002\b\u00030\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2={"Lkotlinx/serialization/internal/ClassValueReferences;", "T", "Ljava/lang/ClassValue;", "Lkotlinx/serialization/internal/MutableSoftReference;", "<init>", "()V", "computeValue", "type", "Ljava/lang/Class;", "getOrSet", "key", "factory", "Lkotlin/Function0;", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isStored", "", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) final class ClassValueReferences extends ClassValue {
    public ClassValueReferences() {
        super();
    }

    public Object computeValue(Class arg1) {
        return this.computeValue(arg1);
    }

    protected MutableSoftReference computeValue(Class arg1) {
        Intrinsics.checkNotNullParameter(arg1, "type");
        return new MutableSoftReference();
    }

    public final Object getOrSet(Class arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "factory");
        Object v1 = this.get(arg2);
        Intrinsics.checkNotNullExpressionValue(v1, "get(...)");
        Object v2 = ((MutableSoftReference)v1).reference.get();
        if(v2 != null) {
            return v2;
        }

        return ((MutableSoftReference)v1).getOrSetWithLock(new ClassValueReferences$getOrSet$2(arg3));
    }

    public final boolean isStored(Class arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        if(this.get(arg2).reference.get() != null) {
            return 1;
        }

        return 0;
    }
}

