package kotlin.jvm.internal;

import java.lang.reflect.GenericDeclaration;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.reflect.KTypeParameter;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b&\u0018\u00002\u00020\u0001B\u0015\bF\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0003H\u0096\u0082\u0004J\n\u0010\u0012\u001A\u00020\u0013H\u0096\u0080\u0004J\n\u0010\u0014\u001A\u00020\u0015H\u0096\u0080\u0004R\u0019\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004X\u0080\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u001D\u0010\t\u001A\u0004\u0018\u00010\n8@X\u0080\u0084\n¢\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000B\u0010\f¨\u0006\u0016"}, d2={"Lkotlin/jvm/internal/KTypeParameterBase;", "Lkotlin/reflect/KTypeParameter;", "container", "", "Lkotlin/jvm/internal/TypeParameterContainer;", "<init>", "(Ljava/lang/Object;)V", "getContainer$kotlin_stdlib", "()Ljava/lang/Object;", "javaContainingDeclaration", "Ljava/lang/reflect/GenericDeclaration;", "getJavaContainingDeclaration$kotlin_stdlib", "()Ljava/lang/reflect/GenericDeclaration;", "javaContainingDeclaration$delegate", "Lkotlin/Lazy;", "equals", "", "other", "hashCode", "", "toString", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class KTypeParameterBase implements KTypeParameter {
    private final Object container;
    private final Lazy javaContainingDeclaration$delegate;

    public KTypeParameterBase(Object arg2) {
        Intrinsics.checkNotNullParameter(arg2, "container");
        super();
        this.container = arg2;
        this.javaContainingDeclaration$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KTypeParameterBase$$ExternalSyntheticLambda0(this));
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof KTypeParameterBase)) && (Intrinsics.areEqual(this.getName(), ((KTypeParameterBase)arg3).getName())) && (Intrinsics.areEqual(this.container, ((KTypeParameterBase)arg3).container))) {
            return 1;
        }

        return 0;
    }

    public final Object getContainer$kotlin_stdlib() {
        return this.container;
    }

    public final GenericDeclaration getJavaContainingDeclaration$kotlin_stdlib() {
        return this.javaContainingDeclaration$delegate.getValue();
    }

    public int hashCode() {
        return this.container.hashCode() * 0x1F + this.getName().hashCode();
    }

    static final GenericDeclaration javaContainingDeclaration_delegate$lambda$0(KTypeParameterBase arg2) {
        Object v2 = arg2.container;
        GenericDeclaration v1 = null;
        if((v2 instanceof KotlinGenericDeclaration)) {
        }
        else {
            v2 = v1;
        }

        if(v2 != null) {
            return ((KotlinGenericDeclaration)v2).findJavaDeclaration();
        }

        return v1;
    }

    public String toString() {
        return TypeParameterReference.Companion.toString(((KTypeParameter)this));
    }
}

