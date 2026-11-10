package androidx.compose.runtime;

import androidx.collection.IntList;
import androidx.collection.ObjectList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002BA\u0012\u000E\u0010\u0003\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u000E\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000EJ\u000E\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002R\u0016\u0010\u0003\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u0012\u001A\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2={"Landroidx/compose/runtime/ComposePausableCompositionException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "instances", "Landroidx/collection/ObjectList;", "", "reused", "operations", "Landroidx/collection/IntList;", "lastOperation", "", "cause", "", "<init>", "(Landroidx/collection/ObjectList;Landroidx/collection/ObjectList;Landroidx/collection/IntList;ILjava/lang/Throwable;)V", "operationsSequence", "Lkotlin/sequences/Sequence;", "", "message", "getMessage$annotations", "()V", "getMessage", "()Ljava/lang/String;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class ComposePausableCompositionException extends RuntimeException {
    private final ObjectList instances;
    private final int lastOperation;
    private final IntList operations;
    private final ObjectList reused;

    public ComposePausableCompositionException(ObjectList arg1, ObjectList arg2, IntList arg3, int arg4, Throwable arg5) {
        super(arg5);
        this.instances = arg1;
        this.reused = arg2;
        this.operations = arg3;
        this.lastOperation = arg4;
    }

    public static final ObjectList access$getInstances$p(ComposePausableCompositionException arg0) {
        return arg0.instances;
    }

    public static final int access$getLastOperation$p(ComposePausableCompositionException arg0) {
        return arg0.lastOperation;
    }

    public static final IntList access$getOperations$p(ComposePausableCompositionException arg0) {
        return arg0.operations;
    }

    public static final ObjectList access$getReused$p(ComposePausableCompositionException arg0) {
        return arg0.reused;
    }

    public String getMessage() {
        return StringsKt.trimMargin$default("\n            |Failed to execute op number " + this.lastOperation + ":\n            |" + CollectionsKt.joinToString$default(CollectionsKt.takeLast(SequencesKt.toList(this.operationsSequence()), 50), "\n", null, null, 0, null, null, 62, null) + "\n            ", null, 1, null);
    }

    public static void getMessage$annotations() {
    }

    private final Sequence operationsSequence() {
        return SequencesKt.sequence(new ComposePausableCompositionException$operationsSequence$1(this, null));
    }
}

