package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@ComposeCompilerApi @Retention(value=RetentionPolicy.RUNTIME) @Target(value={ElementType.METHOD}) @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0010\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005R\u000F\u0010\u0002\u001A\u00020\u0003¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0006R\u000F\u0010\u0004\u001A\u00020\u0005¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/runtime/internal/LiveLiteralInfo;", "", "key", "", "offset", "", "()Ljava/lang/String;", "()I", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.RUNTIME) @kotlin.annotation.Target(allowedTargets={AnnotationTarget.FUNCTION}) @public interface LiveLiteralInfo {
    String key();

    int offset();
}

