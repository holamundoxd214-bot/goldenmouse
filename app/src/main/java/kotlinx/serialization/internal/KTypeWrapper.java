package kotlinx.serialization.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0014\u001A\u00020\u00122\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001A\u00020\u0018H\u0016J\b\u0010\u0019\u001A\u00020\u001AH\u0016R\u000E\u0010\u0002\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u000B0\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\tR\u0016\u0010\r\u001A\u0004\u0018\u00010\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0013¨\u0006\u001B"}, d2={"Lkotlinx/serialization/internal/KTypeWrapper;", "Lkotlin/reflect/KType;", "origin", "<init>", "(Lkotlin/reflect/KType;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "arguments", "Lkotlin/reflect/KTypeProjection;", "getArguments", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "isMarkedNullable", "", "()Z", "equals", "other", "", "hashCode", "", "toString", "", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) final class KTypeWrapper implements KType {
    private final KType origin;

    public KTypeWrapper(KType arg2) {
        Intrinsics.checkNotNullParameter(arg2, "origin");
        super();
        this.origin = arg2;
    }

    public boolean equals(Object arg5) {
        if(arg5 == null) {
            return 0;
        }

        KType v1 = this.origin;
        KClassifier v3 = null;
        Object v2 = (arg5 instanceof KTypeWrapper) ? arg5 : v3;
        if(v2 != null) {
            KType v2_1 = ((KTypeWrapper)v2).origin;
        }
        else {
            v2 = v3;
        }

        if(!Intrinsics.areEqual(v1, v2)) {
            return 0;
        }

        KClassifier v4 = this.getClassifier();
        if((v4 instanceof KClass)) {
            if((arg5 instanceof KType)) {
            }
            else {
                arg5 = v3;
            }

            if(arg5 != null) {
                v3 = ((KType)arg5).getClassifier();
            }

            if(v3 == null) {
                return 0;
            }

            if(!(v3 instanceof KClass)) {
                return 0;
            }

            return Intrinsics.areEqual(JvmClassMappingKt.getJavaClass(((KClass)v4)), JvmClassMappingKt.getJavaClass(((KClass)v3)));
        }

        return 0;
    }

    public List getAnnotations() {
        return this.origin.getAnnotations();
    }

    public List getArguments() {
        return this.origin.getArguments();
    }

    public KClassifier getClassifier() {
        return this.origin.getClassifier();
    }

    public int hashCode() {
        return this.origin.hashCode();
    }

    public boolean isMarkedNullable() {
        return this.origin.isMarkedNullable();
    }

    public String toString() {
        return "KTypeWrapper: " + this.origin;
    }
}

