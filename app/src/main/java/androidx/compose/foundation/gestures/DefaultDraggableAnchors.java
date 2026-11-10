package androidx.compose.foundation.gestures;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001D\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\fJ\u0015\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000FJ\u0017\u0010\u0010\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001A\u00020\nH\u0016¢\u0006\u0002\u0010\u0012J\u001F\u0010\u0010\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001A\u00020\n2\u0006\u0010\u0013\u001A\u00020\u000EH\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001A\u00020\nH\u0016J\b\u0010\u0016\u001A\u00020\nH\u0016J\u0017\u0010\u001B\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u001C\u001A\u00020\u0018H\u0016¢\u0006\u0002\u0010\u001DJ\u0010\u0010\u001E\u001A\u00020\n2\u0006\u0010\u001C\u001A\u00020\u0018H\u0016J\u0013\u0010\u001F\u001A\u00020\u000E2\b\u0010 \u001A\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001A\u00020\u0018H\u0016J\b\u0010#\u001A\u00020$H\u0016J\f\u0010%\u001A\u00020\n*\u00020\u0006H\u0002J\f\u0010&\u001A\u00020\n*\u00020\u0006H\u0002R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001A\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001A¨\u0006\'"}, d2={"Landroidx/compose/foundation/gestures/DefaultDraggableAnchors;", "T", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "keys", "", "anchors", "", "<init>", "(Ljava/util/List;[F)V", "positionOf", "", "anchor", "(Ljava/lang/Object;)F", "hasPositionFor", "", "(Ljava/lang/Object;)Z", "closestAnchor", "position", "(F)Ljava/lang/Object;", "searchUpwards", "(FZ)Ljava/lang/Object;", "minPosition", "maxPosition", "size", "", "getSize", "()I", "anchorAt", "index", "(I)Ljava/lang/Object;", "positionAt", "equals", "other", "", "hashCode", "toString", "", "minOrNaN", "maxOrNaN", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DefaultDraggableAnchors implements DraggableAnchors {
    private final float[] anchors;
    private final List keys;
    private final int size;

    public DefaultDraggableAnchors(List arg3, float[] arg4) {
        super();
        this.keys = arg3;
        this.anchors = arg4;
        int v0 = arg3.size() == arg4.length ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("DraggableAnchors were constructed with inconsistent key-value sizes. Keys: " + arg3 + " | Anchors: " + ArraysKt.toList(arg4));
        }

        this.size = arg4.length;
    }

    public Object anchorAt(int arg1) {
        return CollectionsKt.getOrNull(this.keys, arg1);
    }

    public Object closestAnchor(float arg11) {
        float[] v0 = this.anchors;
        int v1 = v0.length;
        int v2 = -1;
        float v3 = Infinityf;
        int v4 = 0;
        int v6 = v2;
        int v5;
        for(v5 = 0; v4 < v1; v5 = v8) {
            int v8 = v5 + 1;
            float v7 = Math.abs(arg11 - v0[v4]);
            if(v7 <= v3) {
                v6 = v5;
                v3 = v7;
            }

            ++v4;
        }

        if(v6 == v2) {
            return null;
        }

        return this.keys.get(v6);
    }

    public Object closestAnchor(float arg12, boolean arg13) {
        float[] v0 = this.anchors;
        int v1 = v0.length;
        int v2 = -1;
        float v3 = Infinityf;
        int v4 = 0;
        int v6 = v2;
        float v7 = v3;
        int v5;
        for(v5 = 0; v4 < v1; v5 = v9) {
            float v8 = v0[v4];
            int v9 = v5 + 1;
            if(arg13) {
                v8 -= arg12;
            }
            else {
                v8 = arg12 - v8;
            }

            if(v8 < 0f) {
                v8 = v3;
            }

            if(v8 <= v7) {
                v6 = v5;
                v7 = v8;
            }

            ++v4;
        }

        if(v6 == v2) {
            return null;
        }

        return this.keys.get(v6);
    }

    public boolean equals(Object arg5) {
        if(this == (((DefaultDraggableAnchors)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof DefaultDraggableAnchors)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.keys, ((DefaultDraggableAnchors)arg5).keys)) {
            return 0;
        }

        if(!Arrays.equals(this.anchors, ((DefaultDraggableAnchors)arg5).anchors)) {
            return 0;
        }

        if(this.getSize() != ((DefaultDraggableAnchors)arg5).getSize()) {
            return 0;
        }

        return 1;
    }

    public int getSize() {
        return this.size;
    }

    public boolean hasPositionFor(Object arg1) {
        if(this.keys.indexOf(arg1) != -1) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return (this.keys.hashCode() * 0x1F + Arrays.hashCode(this.anchors)) * 0x1F + this.getSize();
    }

    private final float maxOrNaN(float[] arg4) {
        if(arg4.length == 0) {
            return NaNf;
        }

        float v3 = arg4[0];
        int v0 = ArraysKt.getLastIndex(arg4);
        int v1 = 1;
        if(1 <= v0) {
            while(true) {
                v3 = Math.max(v3, arg4[v1]);
                if(v1 != v0) {
                    ++v1;
                    continue;
                }

                return v3;
            }
        }

        return v3;
    }

    public float maxPosition() {
        return this.maxOrNaN(this.anchors);
    }

    private final float minOrNaN(float[] arg4) {
        if(arg4.length == 0) {
            return NaNf;
        }

        float v3 = arg4[0];
        int v0 = ArraysKt.getLastIndex(arg4);
        int v1 = 1;
        if(1 <= v0) {
            while(true) {
                v3 = Math.min(v3, arg4[v1]);
                if(v1 != v0) {
                    ++v1;
                    continue;
                }

                return v3;
            }
        }

        return v3;
    }

    public float minPosition() {
        return this.minOrNaN(this.anchors);
    }

    public float positionAt(int arg3) {
        float[] v2 = this.anchors;
        Function1 v0 = AnchoredDraggableKt.GetOrNan;
        if(arg3 >= 0 && arg3 < v2.length) {
            return v2[arg3];
        }

        return v0.invoke(Integer.valueOf(arg3)).floatValue();
    }

    public float positionOf(Object arg3) {
        int v3 = this.keys.indexOf(arg3);
        float[] v2 = this.anchors;
        Function1 v0 = AnchoredDraggableKt.GetOrNan;
        if(v3 >= 0 && v3 < v2.length) {
            return v2[v3];
        }

        return v0.invoke(Integer.valueOf(v3)).floatValue();
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("DraggableAnchors(anchors={");
        int v1 = this.getSize();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0.append(this.anchorAt(v2) + '=' + this.positionAt(v2));
            if(v2 < this.getSize() - 1) {
                v0.append(", ");
            }
        }

        v0.append("})");
        String v5 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v5, "toString(...)");
        return v5;
    }
}

