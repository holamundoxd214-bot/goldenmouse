package kotlin.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.RepeatableContainer;

@Repeatable(value=Container.class) @Retention(value=RetentionPolicy.SOURCE) @Target(value={ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR}) @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0081\u0002\u0018\u00002\u00020\u0001BN\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u000E\b\u0002\u0010\u0004\u001A\u00020\u0003B\u0004\b\b(\u0005\u0012\u0010\b\u0002\u0010\u0006\u001A\u00020\u0007B\u0006\b\n0\u00078\b\u0012\u0010\b\u0002\u0010\t\u001A\u00020\nB\u0006\b\n0\n8\u000B\u0012\u000E\b\u0002\u0010\f\u001A\u00020\rB\u0004\b\u0003\u0010\u0001R\u0013\u0010\u0002\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u000ER\u0013\u0010\u0004\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u000ER\u0013\u0010\u0006\u001A\u00020\u0007X\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u000FR\u0013\u0010\t\u001A\u00020\nX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\t\u0010\u0010R\u0013\u0010\f\u001A\u00020\rX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\f\u0010\u0011¨\u0006\u0012"}, d2={"Lkotlin/internal/RequireKotlin;", "", "version", "", "message", "", "level", "Lkotlin/DeprecationLevel;", "ERROR", "versionKind", "Lkotlin/internal/RequireKotlinVersionKind;", "LANGUAGE_VERSION", "errorCode", "", "()Ljava/lang/String;", "()Lkotlin/DeprecationLevel;", "()Lkotlin/internal/RequireKotlinVersionKind;", "()I", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) @kotlin.annotation.Repeatable @kotlin.annotation.Retention(value=AnnotationRetention.SOURCE) @kotlin.annotation.Target(allowedTargets={AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.TYPEALIAS}) @public interface RequireKotlin {
    @Retention(value=RetentionPolicy.SOURCE) @Target(value={ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR}) @Metadata(k=3, mv={2, 3, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.SOURCE) @kotlin.annotation.Target(allowedTargets={AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.TYPEALIAS}) @RepeatableContainer @public interface Container {
        RequireKotlin[] value();
    }

    int errorCode();

    DeprecationLevel level();

    String message();

    String version();

    RequireKotlinVersionKind versionKind();
}

