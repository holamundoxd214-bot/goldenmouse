package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\f\u001A\u00020\u0003HÆ\u0083\u0004J\n\u0010\r\u001A\u00020\u0005HÆ\u0083\u0004J\u001E\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0081\u0004J\u0014\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001A\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001A\u00020\u0003HÖ\u0081\u0004R\u0015\u0010\u0002\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001A\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0015"}, d2={"Lkotlin/text/MatchGroup;", "", "value", "", "range", "Lkotlin/ranges/IntRange;", "<init>", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "getValue", "()Ljava/lang/String;", "getRange", "()Lkotlin/ranges/IntRange;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class MatchGroup {
    private final IntRange range;
    private final String value;

    public MatchGroup(String arg2, IntRange arg3) {
        Intrinsics.checkNotNullParameter(arg2, "value");
        Intrinsics.checkNotNullParameter(arg3, "range");
        super();
        this.value = arg2;
        this.range = arg3;
    }

    public final String component1() {
        return this.value;
    }

    public final IntRange component2() {
        return this.range;
    }

    public final MatchGroup copy(String arg1, IntRange arg2) {
        Intrinsics.checkNotNullParameter(arg1, "value");
        Intrinsics.checkNotNullParameter(arg2, "range");
        return new MatchGroup(arg1, arg2);
    }

    public static MatchGroup copy$default(MatchGroup arg0, String arg1, IntRange arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.value;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.range;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((MatchGroup)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof MatchGroup)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.value, ((MatchGroup)arg5).value)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.range, ((MatchGroup)arg5).range)) {
            return 0;
        }

        return 1;
    }

    public final IntRange getRange() {
        return this.range;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode() * 0x1F + this.range.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.value + ", range=" + this.range + ')';
    }
}

