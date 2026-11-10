package kotlinx.serialization;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;

@Documented @Retention(value=RetentionPolicy.RUNTIME) @Target(value={ElementType.TYPE, ElementType.TYPE_USE}) @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0016\u0012\u0014\b\u0002\u0010\u0002\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003R\u001B\u0010\u0002\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2={"Lkotlinx/serialization/Serializable;", "", "with", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "()Ljava/lang/Class;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) @MustBeDocumented @kotlin.annotation.Target(allowedTargets={AnnotationTarget.PROPERTY, AnnotationTarget.CLASS, AnnotationTarget.TYPE}) @public interface Serializable {
    Class with();
}

