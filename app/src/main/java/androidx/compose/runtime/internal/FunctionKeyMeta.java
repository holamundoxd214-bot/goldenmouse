package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.RepeatableContainer;

@ComposeCompilerApi @Repeatable(value=Container.class) @Retention(value=RetentionPolicy.CLASS) @Target(value={ElementType.TYPE, ElementType.METHOD}) @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003R\u000F\u0010\u0002\u001A\u00020\u0003¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0006R\u000F\u0010\u0004\u001A\u00020\u0003¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0006R\u000F\u0010\u0005\u001A\u00020\u0003¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/runtime/internal/FunctionKeyMeta;", "", "key", "", "startOffset", "endOffset", "()I", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) @kotlin.annotation.Repeatable @kotlin.annotation.Retention(value=AnnotationRetention.BINARY) @kotlin.annotation.Target(allowedTargets={AnnotationTarget.CLASS, AnnotationTarget.FUNCTION}) @public interface FunctionKeyMeta {
    @Retention(value=RetentionPolicy.CLASS) @Target(value={ElementType.TYPE, ElementType.METHOD}) @Metadata(k=3, mv={2, 1, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.BINARY) @kotlin.annotation.Target(allowedTargets={AnnotationTarget.CLASS, AnnotationTarget.FUNCTION}) @RepeatableContainer @public interface Container {
        FunctionKeyMeta[] value();
    }

    int endOffset();

    int key();

    int startOffset();
}

