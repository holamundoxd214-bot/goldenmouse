package androidx.compose.runtime;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\n"}, d2={"Landroidx/compose/runtime/NestedMovableContent;", "", "content", "Landroidx/compose/runtime/MovableContentStateReference;", "container", "<init>", "(Landroidx/compose/runtime/MovableContentStateReference;Landroidx/compose/runtime/MovableContentStateReference;)V", "getContent", "()Landroidx/compose/runtime/MovableContentStateReference;", "getContainer", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class NestedMovableContent {
    private final MovableContentStateReference container;
    private final MovableContentStateReference content;

    public NestedMovableContent(MovableContentStateReference arg1, MovableContentStateReference arg2) {
        super();
        this.content = arg1;
        this.container = arg2;
    }

    public final MovableContentStateReference getContainer() {
        return this.container;
    }

    public final MovableContentStateReference getContent() {
        return this.content;
    }
}

