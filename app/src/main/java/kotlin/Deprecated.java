package kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;

@Documented @Retention(value=RetentionPolicy.RUNTIME) @Target(value={ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE}) @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B@\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\"\b\u0002\u0010\u0004\u001A\u00020\u0005B\u0018\b\u000BB\u0014\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\b\b\u0012\u0002\b\f\u0012\u0010\b\u0002\u0010\t\u001A\u00020\nB\u0006\b\n0\n8\u000BR\u0013\u0010\u0002\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0002\u0010\fR\u0013\u0010\u0004\u001A\u00020\u0005X\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0004\u0010\rR\u0013\u0010\t\u001A\u00020\nX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\t\u0010\u000E¨\u0006\u000F"}, d2={"Lkotlin/Deprecated;", "", "message", "", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "", "imports", "level", "Lkotlin/DeprecationLevel;", "WARNING", "()Ljava/lang/String;", "()Lkotlin/ReplaceWith;", "()Lkotlin/DeprecationLevel;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) @MustBeDocumented @kotlin.annotation.Target(allowedTargets={AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.TYPEALIAS}) @public interface Deprecated {
    DeprecationLevel level();

    String message();

    ReplaceWith replaceWith();
}

