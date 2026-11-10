package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\t\b\u0087@\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00002\u0006\u0010\u0007\u001A\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0007\u001A\u00020\u0000H\u0000¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u000FH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u0013\u0010\u0014\u001A\u00020\u000B2\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001A\u00020\u0003HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0018"}, d2={"Landroidx/compose/foundation/layout/WindowInsetsSides;", "", "value", "", "constructor-impl", "(I)I", "plus", "sides", "plus-gK_yJZ4", "(II)I", "hasAny", "", "hasAny-bkgdKaI$foundation_layout", "(II)Z", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "valueToString", "valueToString-impl", "equals", "other", "hashCode", "Companion", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class WindowInsetsSides {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001A\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001A\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0016\u0010\u000B\u001A\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0016\u0010\r\u001A\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007R\u0013\u0010\u000F\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0018\u0010\u0007R\u0013\u0010\u0019\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u001A\u0010\u0007R\u0013\u0010\u001B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u001C\u0010\u0007R\u0013\u0010\u001D\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u001E\u0010\u0007¨\u0006\u001F"}, d2={"Landroidx/compose/foundation/layout/WindowInsetsSides$Companion;", "", "<init>", "()V", "AllowLeftInLtr", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "getAllowLeftInLtr-JoeWqyM$foundation_layout", "()I", "I", "AllowRightInLtr", "getAllowRightInLtr-JoeWqyM$foundation_layout", "AllowLeftInRtl", "getAllowLeftInRtl-JoeWqyM$foundation_layout", "AllowRightInRtl", "getAllowRightInRtl-JoeWqyM$foundation_layout", "Start", "getStart-JoeWqyM", "End", "getEnd-JoeWqyM", "Top", "getTop-JoeWqyM", "Bottom", "getBottom-JoeWqyM", "Left", "getLeft-JoeWqyM", "Right", "getRight-JoeWqyM", "Horizontal", "getHorizontal-JoeWqyM", "Vertical", "getVertical-JoeWqyM", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getAllowLeftInLtr-JoeWqyM$foundation_layout() {
            return WindowInsetsSides.AllowLeftInLtr;
        }

        public final int getAllowLeftInRtl-JoeWqyM$foundation_layout() {
            return WindowInsetsSides.AllowLeftInRtl;
        }

        public final int getAllowRightInLtr-JoeWqyM$foundation_layout() {
            return WindowInsetsSides.AllowRightInLtr;
        }

        public final int getAllowRightInRtl-JoeWqyM$foundation_layout() {
            return WindowInsetsSides.AllowRightInRtl;
        }

        public final int getBottom-JoeWqyM() {
            return WindowInsetsSides.Bottom;
        }

        public final int getEnd-JoeWqyM() {
            return WindowInsetsSides.End;
        }

        public final int getHorizontal-JoeWqyM() {
            return WindowInsetsSides.Horizontal;
        }

        public final int getLeft-JoeWqyM() {
            return WindowInsetsSides.Left;
        }

        public final int getRight-JoeWqyM() {
            return WindowInsetsSides.Right;
        }

        public final int getStart-JoeWqyM() {
            return WindowInsetsSides.Start;
        }

        public final int getTop-JoeWqyM() {
            return WindowInsetsSides.Top;
        }

        public final int getVertical-JoeWqyM() {
            return WindowInsetsSides.Vertical;
        }
    }

    private static final int AllowLeftInLtr;
    private static final int AllowLeftInRtl;
    private static final int AllowRightInLtr;
    private static final int AllowRightInRtl;
    private static final int Bottom;
    public static final Companion Companion;
    private static final int End;
    private static final int Horizontal;
    private static final int Left;
    private static final int Right;
    private static final int Start;
    private static final int Top;
    private static final int Vertical;
    private final int value;

    static {
        WindowInsetsSides.Companion = new Companion(null);
        int v0 = WindowInsetsSides.constructor-impl(8);
        WindowInsetsSides.AllowLeftInLtr = v0;
        int v1 = WindowInsetsSides.constructor-impl(4);
        WindowInsetsSides.AllowRightInLtr = v1;
        int v2 = WindowInsetsSides.constructor-impl(2);
        WindowInsetsSides.AllowLeftInRtl = v2;
        int v3 = WindowInsetsSides.constructor-impl(1);
        WindowInsetsSides.AllowRightInRtl = v3;
        WindowInsetsSides.Start = WindowInsetsSides.plus-gK_yJZ4(v0, v3);
        WindowInsetsSides.End = WindowInsetsSides.plus-gK_yJZ4(v1, v2);
        int v4 = WindowInsetsSides.constructor-impl(16);
        WindowInsetsSides.Top = v4;
        int v5 = WindowInsetsSides.constructor-impl(0x20);
        WindowInsetsSides.Bottom = v5;
        v0 = WindowInsetsSides.plus-gK_yJZ4(v0, v2);
        WindowInsetsSides.Left = v0;
        v1 = WindowInsetsSides.plus-gK_yJZ4(v1, v3);
        WindowInsetsSides.Right = v1;
        WindowInsetsSides.Horizontal = WindowInsetsSides.plus-gK_yJZ4(v0, v1);
        WindowInsetsSides.Vertical = WindowInsetsSides.plus-gK_yJZ4(v4, v5);
    }

    private WindowInsetsSides(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getAllowLeftInLtr$cp() {
        return WindowInsetsSides.AllowLeftInLtr;
    }

    public static final int access$getAllowLeftInRtl$cp() {
        return WindowInsetsSides.AllowLeftInRtl;
    }

    public static final int access$getAllowRightInLtr$cp() {
        return WindowInsetsSides.AllowRightInLtr;
    }

    public static final int access$getAllowRightInRtl$cp() {
        return WindowInsetsSides.AllowRightInRtl;
    }

    public static final int access$getBottom$cp() {
        return WindowInsetsSides.Bottom;
    }

    public static final int access$getEnd$cp() {
        return WindowInsetsSides.End;
    }

    public static final int access$getHorizontal$cp() {
        return WindowInsetsSides.Horizontal;
    }

    public static final int access$getLeft$cp() {
        return WindowInsetsSides.Left;
    }

    public static final int access$getRight$cp() {
        return WindowInsetsSides.Right;
    }

    public static final int access$getStart$cp() {
        return WindowInsetsSides.Start;
    }

    public static final int access$getTop$cp() {
        return WindowInsetsSides.Top;
    }

    public static final int access$getVertical$cp() {
        return WindowInsetsSides.Vertical;
    }

    public static final WindowInsetsSides box-impl(int arg1) {
        return new WindowInsetsSides(arg1);
    }

    private static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return WindowInsetsSides.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof WindowInsetsSides)) {
            return 0;
        }

        if(arg2 != ((WindowInsetsSides)arg3).unbox-impl()) {
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

    public static final boolean hasAny-bkgdKaI$foundation_layout(int arg0, int arg1) {
        if((arg0 & arg1) != 0) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return WindowInsetsSides.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public static final int plus-gK_yJZ4(int arg0, int arg1) {
        return WindowInsetsSides.constructor-impl(arg0 | arg1);
    }

    public String toString() {
        return WindowInsetsSides.toString-impl(this.value);
    }

    public static String toString-impl(int arg2) {
        return "WindowInsetsSides(" + WindowInsetsSides.valueToString-impl(arg2) + ')';
    }

    public final int unbox-impl() {
        return this.value;
    }

    private static final String valueToString-impl(int arg3) {
        StringBuilder v0 = new StringBuilder();
        if((arg3 & WindowInsetsSides.Start) == WindowInsetsSides.Start) {
            WindowInsetsSides.valueToString_impl$lambda$0$appendPlus(v0, "Start");
        }

        if((arg3 & WindowInsetsSides.Left) == WindowInsetsSides.Left) {
            WindowInsetsSides.valueToString_impl$lambda$0$appendPlus(v0, "Left");
        }

        if((arg3 & WindowInsetsSides.Top) == WindowInsetsSides.Top) {
            WindowInsetsSides.valueToString_impl$lambda$0$appendPlus(v0, "Top");
        }

        if((arg3 & WindowInsetsSides.End) == WindowInsetsSides.End) {
            WindowInsetsSides.valueToString_impl$lambda$0$appendPlus(v0, "End");
        }

        if((arg3 & WindowInsetsSides.Right) == WindowInsetsSides.Right) {
            WindowInsetsSides.valueToString_impl$lambda$0$appendPlus(v0, "Right");
        }

        if((arg3 & WindowInsetsSides.Bottom) == WindowInsetsSides.Bottom) {
            WindowInsetsSides.valueToString_impl$lambda$0$appendPlus(v0, "Bottom");
        }

        String v3 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v3, "toString(...)");
        return v3;
    }

    private static final void valueToString_impl$lambda$0$appendPlus(StringBuilder arg1, String arg2) {
        if(arg1.length() > 0) {
            arg1.append('+');
        }

        arg1.append(arg2);
    }
}

