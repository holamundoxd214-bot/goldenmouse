package androidx.compose.foundation.text;

import android.os.Build$VERSION;
import androidx.compose.foundation.R$string;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0081@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\r\u001A\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000E\u0010\u0005J\u0010\u0010\u000F\u001A\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2={"Landroidx/compose/foundation/text/ContextMenuStrings;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class ContextMenuStrings {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u000B\u0010\u0007R\u0011\u0010\f\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\r\u0010\u0007R\u0011\u0010\u000E\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0007¨\u0006\u0010"}, d2={"Landroidx/compose/foundation/text/ContextMenuStrings$Companion;", "", "<init>", "()V", "Cut", "Landroidx/compose/foundation/text/ContextMenuStrings;", "getCut-9Hzcbyc", "()I", "Copy", "getCopy-9Hzcbyc", "Paste", "getPaste-9Hzcbyc", "SelectAll", "getSelectAll-9Hzcbyc", "Autofill", "getAutofill-9Hzcbyc", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getAutofill-9Hzcbyc() {
            int v1 = Build$VERSION.SDK_INT <= 26 ? string.androidx_compose_foundation_autofill : 0x104001A;
            return ContextMenuStrings.constructor-impl(v1);
        }

        public final int getCopy-9Hzcbyc() {
            return ContextMenuStrings.constructor-impl(0x1040001);
        }

        public final int getCut-9Hzcbyc() {
            return ContextMenuStrings.constructor-impl(0x1040003);
        }

        public final int getPaste-9Hzcbyc() {
            return ContextMenuStrings.constructor-impl(0x104000B);
        }

        public final int getSelectAll-9Hzcbyc() {
            return ContextMenuStrings.constructor-impl(0x104000D);
        }
    }

    public static final Companion Companion;
    private final int value;

    static {
        ContextMenuStrings.Companion = new Companion(null);
    }

    private ContextMenuStrings(int arg1) {
        super();
        this.value = arg1;
    }

    public static final ContextMenuStrings box-impl(int arg1) {
        return new ContextMenuStrings(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return ContextMenuStrings.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof ContextMenuStrings)) {
            return 0;
        }

        if(arg2 != ((ContextMenuStrings)arg3).unbox-impl()) {
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

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return ContextMenuStrings.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return ContextMenuStrings.toString-impl(this.value);
    }

    public static String toString-impl(int arg2) {
        return "ContextMenuStrings(value=" + arg2 + ')';
    }

    public final int unbox-impl() {
        return this.value;
    }
}

