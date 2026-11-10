package androidx.compose.material3.internal;

import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001B\u0012\u0012\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\nJ\u0015\u0010\u000B\u001A\u00020\f2\u0006\u0010\t\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\rJ\u0017\u0010\u000E\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u000F\u001A\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0010J\u001F\u0010\u000E\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\fH\u0016¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001A\u00020\u0005H\u0016J\b\u0010\u0014\u001A\u00020\u0005H\u0016J\u0013\u0010\u0019\u001A\u00020\f2\b\u0010\u001A\u001A\u0004\u0018\u00010\u001BH\u0096\u0002J\b\u0010\u001C\u001A\u00020\u0016H\u0016J\b\u0010\u001D\u001A\u00020\u001EH\u0016R\u001A\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001A\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u0006\u001F"}, d2={"Landroidx/compose/material3/internal/MapDraggableAnchors;", "T", "Landroidx/compose/material3/internal/DraggableAnchors;", "anchors", "", "", "<init>", "(Ljava/util/Map;)V", "positionOf", "value", "(Ljava/lang/Object;)F", "hasAnchorFor", "", "(Ljava/lang/Object;)Z", "closestAnchor", "position", "(F)Ljava/lang/Object;", "searchUpwards", "(FZ)Ljava/lang/Object;", "minAnchor", "maxAnchor", "size", "", "getSize", "()I", "equals", "other", "", "hashCode", "toString", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class MapDraggableAnchors implements DraggableAnchors {
    private final Map anchors;

    public MapDraggableAnchors(Map arg1) {
        super();
        this.anchors = arg1;
    }

    public Object closestAnchor(float arg7) {
        Object v0;
        Iterator v6 = this.anchors.entrySet().iterator();
        Object v1 = null;
        if(!v6.hasNext()) {
            v0 = v1;
        }
        else {
            v0 = v6.next();
            if(!v6.hasNext()) {
            }
            else {
                float v2 = Math.abs(arg7 - v0.getValue().floatValue());
                do {
                    Object v3 = v6.next();
                    float v4 = Math.abs(arg7 - v3.getValue().floatValue());
                    if(Float.compare(v2, v4) > 0) {
                        v0 = v3;
                        v2 = v4;
                    }

                    if(v6.hasNext()) {
                        continue;
                    }

                    break;
                }
                while(true);
            }
        }

        if(v0 != null) {
            return ((Map$Entry)v0).getKey();
        }

        return v1;
    }

    public Object closestAnchor(float arg9, boolean arg10) {
        Object v0;
        Iterator v8 = this.anchors.entrySet().iterator();
        Object v1 = null;
        if(!v8.hasNext()) {
            v0 = v1;
        }
        else {
            v0 = v8.next();
            if(!v8.hasNext()) {
            }
            else {
                float v2 = v0.getValue().floatValue();
                if(arg10) {
                    v2 -= arg9;
                }
                else {
                    v2 = arg9 - v2;
                }

                float v5 = Infinityf;
                if(Float.compare(v2, 0f) < 0) {
                    v2 = v5;
                }

                do {
                    Object v4 = v8.next();
                    float v6 = v4.getValue().floatValue();
                    if(arg10) {
                        v6 -= arg9;
                    }
                    else {
                        v6 = arg9 - v6;
                    }

                    if(v6 < 0f) {
                        v6 = v5;
                    }

                    if(Float.compare(v2, v6) > 0) {
                        v0 = v4;
                        v2 = v6;
                    }

                    if(v8.hasNext()) {
                        continue;
                    }

                    break;
                }
                while(true);
            }
        }

        if(v0 != null) {
            return ((Map$Entry)v0).getKey();
        }

        return v1;
    }

    public boolean equals(Object arg2) {
        if(this == (((MapDraggableAnchors)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof MapDraggableAnchors)) {
            return 0;
        }

        return Intrinsics.areEqual(this.anchors, ((MapDraggableAnchors)arg2).anchors);
    }

    public int getSize() {
        return this.anchors.size();
    }

    public boolean hasAnchorFor(Object arg1) {
        return this.anchors.containsKey(arg1);
    }

    public int hashCode() {
        return this.anchors.hashCode() * 0x1F;
    }

    public float maxAnchor() {
        Float v0 = CollectionsKt.maxOrNull(this.anchors.values());
        if(v0 != null) {
            return v0.floatValue();
        }

        return NaNf;
    }

    public float minAnchor() {
        Float v0 = CollectionsKt.minOrNull(this.anchors.values());
        if(v0 != null) {
            return v0.floatValue();
        }

        return NaNf;
    }

    public float positionOf(Object arg1) {
        Object v0 = this.anchors.get(arg1);
        if(v0 != null) {
            return ((Float)v0).floatValue();
        }

        return NaNf;
    }

    public String toString() {
        return "MapDraggableAnchors(" + this.anchors + ')';
    }
}

