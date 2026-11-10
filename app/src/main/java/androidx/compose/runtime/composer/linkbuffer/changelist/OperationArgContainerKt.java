package androidx.compose.runtime.composer.linkbuffer.changelist;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A$\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001A\u00060\u0004j\u0002`\u00052\n\u0010\u0006\u001A\u00060\u0004j\u0002`\u0005H\u0000¨\u0006\u0007"}, d2={"getLong", "", "Landroidx/compose/runtime/composer/linkbuffer/changelist/OperationArgContainer;", "highBitsParam", "", "Landroidx/compose/runtime/composer/linkbuffer/changelist/IntParameter;", "lowBitsParam", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class OperationArgContainerKt {
    public static final long getLong(OperationArgContainer arg4, int arg5, int arg6) {
        return (((long)arg4.getInt(arg5))) << 0x20 | (((long)arg4.getInt(arg6))) & 0xFFFFFFFFL;
    }
}

