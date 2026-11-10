package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0017\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000F\u001A\u00020\u00102\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0016\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004J\u0011\u0010\u0012\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0004H\u0086\u0002J\u0013\u0010\u0014\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0015\u001A\u00020\u0016H\u0016J\b\u0010\u0017\u001A\u00020\u0018H\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0015\u0010\u0006\u001A\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\r¨\u0006\u0019"}, d2={"Landroidx/compose/ui/graphics/Interval;", "T", "", "start", "", "end", "data", "<init>", "(FFLjava/lang/Object;)V", "getStart", "()F", "getEnd", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "overlaps", "", "other", "contains", "value", "equals", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public class Interval {
    public static final int $stable;
    private final Object data;
    private final float end;
    private final float start;

    static {
    }

    public Interval(float arg1, float arg2, Object arg3) {
        super();
        this.start = arg1;
        this.end = arg2;
        this.data = arg3;
    }

    public Interval(float arg1, float arg2, Object arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        this(arg1, arg2, arg3);
    }

    public final boolean contains(float arg3) {
        float v0 = this.start;
        if(Float.compare(arg3, this.end) <= 0 && v0 <= arg3) {
            return 1;
        }

        return 0;
    }

    public boolean equals(Object arg5) {
        if(this == (((Interval)arg5))) {
            return 1;
        }

        if(arg5 != null) {
            if(this.getClass() != arg5.getClass()) {
            }
            else if(this.start == ((Interval)arg5).start && this.end == ((Interval)arg5).end) {
                if(!Intrinsics.areEqual(this.data, ((Interval)arg5).data)) {
                    return 0;
                }
                else {
                    return 1;
                }
            }
        }

        return 0;
    }

    public final Object getData() {
        return this.data;
    }

    public final float getEnd() {
        return this.end;
    }

    public final float getStart() {
        return this.start;
    }

    public int hashCode() {
        int v0 = (Float.hashCode(this.start) * 0x1F + Float.hashCode(this.end)) * 0x1F;
        Object v2 = this.data;
        int v2_1 = v2 != null ? v2.hashCode() : 0;
        return v0 + v2_1;
    }

    public final boolean overlaps(float arg2, float arg3) {
        if(this.start <= arg3 && this.end >= arg2) {
            return 1;
        }

        return 0;
    }

    public final boolean overlaps(Interval arg3) {
        if(this.start <= arg3.end && this.end >= arg3.start) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return "Interval(start=" + this.start + ", end=" + this.end + ", data=" + this.data + ')';
    }
}

