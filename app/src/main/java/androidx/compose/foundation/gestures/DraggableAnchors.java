package androidx.compose.foundation.gestures;

import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\r\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00028\u0000H&¢\u0006\u0002\u0010\nJ\u0015\u0010\u000B\u001A\u00020\f2\u0006\u0010\t\u001A\u00028\u0000H&¢\u0006\u0002\u0010\rJ\u0017\u0010\u000E\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u000F\u001A\u00020\bH&¢\u0006\u0002\u0010\u0010J\u001F\u0010\u000E\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u000F\u001A\u00020\b2\u0006\u0010\u0011\u001A\u00020\fH&¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001A\u00020\bH&J\b\u0010\u0014\u001A\u00020\bH&J\u0017\u0010\u0015\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u0016\u001A\u00020\u0004H&¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\u0004H&R\u0012\u0010\u0003\u001A\u00020\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0001"}, d2={"Landroidx/compose/foundation/gestures/DraggableAnchors;", "T", "", "size", "", "getSize", "()I", "positionOf", "", "anchor", "(Ljava/lang/Object;)F", "hasPositionFor", "", "(Ljava/lang/Object;)Z", "closestAnchor", "position", "(F)Ljava/lang/Object;", "searchUpwards", "(FZ)Ljava/lang/Object;", "minPosition", "maxPosition", "anchorAt", "index", "(I)Ljava/lang/Object;", "positionAt", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface DraggableAnchors {
    Object anchorAt(int arg1);

    Object closestAnchor(float arg1);

    Object closestAnchor(float arg1, boolean arg2);

    int getSize();

    boolean hasPositionFor(Object arg1);

    float maxPosition();

    float minPosition();

    float positionAt(int arg1);

    float positionOf(Object arg1);
}

