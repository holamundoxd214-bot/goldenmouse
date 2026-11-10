package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000B\u001A\u00020\fHÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000E"}, d2={"Landroidx/compose/material3/ExposedDropdownMenuAnchorType;", "", "name", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "toString", "toString-impl", "equals", "", "other", "hashCode", "", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class ExposedDropdownMenuAnchorType {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/material3/ExposedDropdownMenuAnchorType$Companion;", "", "<init>", "()V", "PrimaryNotEditable", "Landroidx/compose/material3/ExposedDropdownMenuAnchorType;", "getPrimaryNotEditable-oYjWRB4", "()Ljava/lang/String;", "Ljava/lang/String;", "PrimaryEditable", "getPrimaryEditable-oYjWRB4", "SecondaryEditable", "getSecondaryEditable-oYjWRB4", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final String getPrimaryEditable-oYjWRB4() {
            return ExposedDropdownMenuAnchorType.PrimaryEditable;
        }

        public final String getPrimaryNotEditable-oYjWRB4() {
            return ExposedDropdownMenuAnchorType.PrimaryNotEditable;
        }

        public final String getSecondaryEditable-oYjWRB4() {
            return ExposedDropdownMenuAnchorType.SecondaryEditable;
        }
    }

    public static final Companion Companion;
    private static final String PrimaryEditable;
    private static final String PrimaryNotEditable;
    private static final String SecondaryEditable;
    private final String name;

    static {
        ExposedDropdownMenuAnchorType.Companion = new Companion(null);
        ExposedDropdownMenuAnchorType.PrimaryNotEditable = ExposedDropdownMenuAnchorType.constructor-impl("PrimaryNotEditable");
        ExposedDropdownMenuAnchorType.PrimaryEditable = ExposedDropdownMenuAnchorType.constructor-impl("PrimaryEditable");
        ExposedDropdownMenuAnchorType.SecondaryEditable = ExposedDropdownMenuAnchorType.constructor-impl("SecondaryEditable");
    }

    private ExposedDropdownMenuAnchorType(String arg1) {
        super();
        this.name = arg1;
    }

    public static final String access$getPrimaryEditable$cp() {
        return ExposedDropdownMenuAnchorType.PrimaryEditable;
    }

    public static final String access$getPrimaryNotEditable$cp() {
        return ExposedDropdownMenuAnchorType.PrimaryNotEditable;
    }

    public static final String access$getSecondaryEditable$cp() {
        return ExposedDropdownMenuAnchorType.SecondaryEditable;
    }

    public static final ExposedDropdownMenuAnchorType box-impl(String arg1) {
        return new ExposedDropdownMenuAnchorType(arg1);
    }

    private static String constructor-impl(String arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return ExposedDropdownMenuAnchorType.equals-impl(this.name, arg1);
    }

    public static boolean equals-impl(String arg2, Object arg3) {
        if(!(arg3 instanceof ExposedDropdownMenuAnchorType)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((ExposedDropdownMenuAnchorType)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(String arg0, String arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public int hashCode() {
        return ExposedDropdownMenuAnchorType.hashCode-impl(this.name);
    }

    public static int hashCode-impl(String arg0) {
        return arg0.hashCode();
    }

    public String toString() {
        return ExposedDropdownMenuAnchorType.toString-impl(this.name);
    }

    public static String toString-impl(String arg0) {
        return arg0;
    }

    public final String unbox-impl() {
        return this.name;
    }
}

