package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0083@\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\u0007\u001A\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001A\u00020\u0003HÖ\u0001J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0011"}, d2={"Landroidx/compose/material3/ListItemType;", "", "lines", "", "constructor-impl", "(I)I", "compareTo", "other", "compareTo-yh95HIg", "(II)I", "equals", "", "", "hashCode", "toString", "", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline final class ListItemType implements Comparable {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\r\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u000FH\u0080\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007¨\u0006\u0014"}, d2={"Landroidx/compose/material3/ListItemType$Companion;", "", "<init>", "()V", "OneLine", "Landroidx/compose/material3/ListItemType;", "getOneLine-AlXitO8", "()I", "I", "TwoLine", "getTwoLine-AlXitO8", "ThreeLine", "getThreeLine-AlXitO8", "invoke", "hasOverline", "", "hasSupporting", "isSupportingMultiline", "invoke-Z-LSjz4$material3", "(ZZZ)I", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getOneLine-AlXitO8() {
            return ListItemType.OneLine;
        }

        public final int getThreeLine-AlXitO8() {
            return ListItemType.ThreeLine;
        }

        public final int getTwoLine-AlXitO8() {
            return ListItemType.TwoLine;
        }

        public final int invoke-Z-LSjz4$material3(boolean arg1, boolean arg2, boolean arg3) {
            if((arg1) && (arg2) || (arg3)) {
                return this.getThreeLine-AlXitO8();
            }

            if(!arg1) {
                if(arg2) {
                }
                else {
                    return this.getOneLine-AlXitO8();
                }
            }

            return this.getTwoLine-AlXitO8();
        }
    }

    public static final Companion Companion;
    private static final int OneLine;
    private static final int ThreeLine;
    private static final int TwoLine;
    private final int lines;

    static {
        ListItemType.Companion = new Companion(null);
        ListItemType.OneLine = ListItemType.constructor-impl(1);
        ListItemType.TwoLine = ListItemType.constructor-impl(2);
        ListItemType.ThreeLine = ListItemType.constructor-impl(3);
    }

    private ListItemType(int arg1) {
        super();
        this.lines = arg1;
    }

    public static final int access$getOneLine$cp() {
        return ListItemType.OneLine;
    }

    public static final int access$getThreeLine$cp() {
        return ListItemType.ThreeLine;
    }

    public static final int access$getTwoLine$cp() {
        return ListItemType.TwoLine;
    }

    public static final ListItemType box-impl(int arg1) {
        return new ListItemType(arg1);
    }

    public int compareTo(Object arg1) {
        return this.compareTo-yh95HIg(((ListItemType)arg1).unbox-impl());
    }

    public static int compareTo-yh95HIg(int arg0, int arg1) {
        return Intrinsics.compare(arg0, arg1);
    }

    public int compareTo-yh95HIg(int arg1) {
        return ListItemType.compareTo-yh95HIg(this.lines, arg1);
    }

    private static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return ListItemType.equals-impl(this.lines, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof ListItemType)) {
            return 0;
        }

        if(arg2 != ((ListItemType)arg3).unbox-impl()) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(int arg0, int arg1) {
        if(arg0 == arg1) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return ListItemType.hashCode-impl(this.lines);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return ListItemType.toString-impl(this.lines);
    }

    public static String toString-impl(int arg2) {
        return "ListItemType(lines=" + arg2 + ')';
    }

    public final int unbox-impl() {
        return this.lines;
    }
}

