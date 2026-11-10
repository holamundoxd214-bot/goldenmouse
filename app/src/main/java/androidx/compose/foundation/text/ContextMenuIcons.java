package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0081@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\r\u001A\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000E\u0010\u0005J\u0010\u0010\u000F\u001A\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2={"Landroidx/compose/foundation/text/ContextMenuIcons;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class ContextMenuIcons {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u000B\u0010\u0007R\u0011\u0010\f\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\r\u0010\u0007R\u0011\u0010\u000E\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0007¨\u0006\u0010"}, d2={"Landroidx/compose/foundation/text/ContextMenuIcons$Companion;", "", "<init>", "()V", "ActionModeCutDrawable", "Landroidx/compose/foundation/text/ContextMenuIcons;", "getActionModeCutDrawable-3I4p1mQ", "()I", "ActionModeCopyDrawable", "getActionModeCopyDrawable-3I4p1mQ", "ActionModePasteDrawable", "getActionModePasteDrawable-3I4p1mQ", "ActionModeSelectAllDrawable", "getActionModeSelectAllDrawable-3I4p1mQ", "ID_NULL", "getID_NULL-3I4p1mQ", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getActionModeCopyDrawable-3I4p1mQ() {
            return ContextMenuIcons.constructor-impl(0x1010312);
        }

        public final int getActionModeCutDrawable-3I4p1mQ() {
            return ContextMenuIcons.constructor-impl(0x1010311);
        }

        public final int getActionModePasteDrawable-3I4p1mQ() {
            return ContextMenuIcons.constructor-impl(0x1010313);
        }

        public final int getActionModeSelectAllDrawable-3I4p1mQ() {
            return ContextMenuIcons.constructor-impl(0x101037E);
        }

        public final int getID_NULL-3I4p1mQ() {
            return ContextMenuIcons.constructor-impl(0);
        }
    }

    public static final Companion Companion;
    private final int value;

    static {
        ContextMenuIcons.Companion = new Companion(null);
    }

    private ContextMenuIcons(int arg1) {
        super();
        this.value = arg1;
    }

    public static final ContextMenuIcons box-impl(int arg1) {
        return new ContextMenuIcons(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return ContextMenuIcons.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof ContextMenuIcons)) {
            return 0;
        }

        if(arg2 != ((ContextMenuIcons)arg3).unbox-impl()) {
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
        return ContextMenuIcons.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return ContextMenuIcons.toString-impl(this.value);
    }

    public static String toString-impl(int arg2) {
        return "ContextMenuIcons(value=" + arg2 + ')';
    }

    public final int unbox-impl() {
        return this.value;
    }
}

