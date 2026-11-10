package androidx.compose.material3.internal;

import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00028\u0000H&¢\u0006\u0002\u0010\tJ\u0017\u0010\n\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u000B\u001A\u00020\u0004H&¢\u0006\u0002\u0010\fJ\u001F\u0010\n\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u000B\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\bH&¢\u0006\u0002\u0010\u000EJ\b\u0010\u000F\u001A\u00020\u0004H&J\b\u0010\u0010\u001A\u00020\u0004H&R\u0012\u0010\u0011\u001A\u00020\u0012X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2={"Landroidx/compose/material3/internal/DraggableAnchors;", "T", "", "positionOf", "", "value", "(Ljava/lang/Object;)F", "hasAnchorFor", "", "(Ljava/lang/Object;)Z", "closestAnchor", "position", "(F)Ljava/lang/Object;", "searchUpwards", "(FZ)Ljava/lang/Object;", "minAnchor", "maxAnchor", "size", "", "getSize", "()I", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public interface DraggableAnchors {
    Object closestAnchor(float arg1, boolean arg2);

    Object closestAnchor(float arg1);

    int getSize();

    boolean hasAnchorFor(Object arg1);

    float maxAnchor();

    float minAnchor();

    float positionOf(Object arg1);
}

