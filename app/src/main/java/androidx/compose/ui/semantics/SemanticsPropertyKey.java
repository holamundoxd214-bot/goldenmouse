package androidx.compose.ui.semantics;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u001E\b\u0002\u0010\u0005\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u0007\u0010\u000BBC\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u001C\u0010\u0005\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\rJ\u001F\u0010\u0018\u001A\u0004\u0018\u00018\u00002\b\u0010\u0019\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u001A\u001A\u00028\u0000¢\u0006\u0002\u0010\u001BJ\"\u0010\u001C\u001A\u00028\u00002\u0006\u0010\u001D\u001A\u00020\u001E2\n\u0010\u001F\u001A\u0006\u0012\u0002\b\u00030 H\u0086\u0002¢\u0006\u0002\u0010!J*\u0010\"\u001A\u00020#2\u0006\u0010\u001D\u001A\u00020\u001E2\n\u0010\u001F\u001A\u0006\u0012\u0002\b\u00030 2\u0006\u0010\u0012\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010$J\b\u0010%\u001A\u00020\u0004H\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR*\u0010\u0005\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u001E\u0010\t\u001A\u00020\n2\u0006\u0010\u0012\u001A\u00020\n@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u001C\u0010\f\u001A\u0004\u0018\u00010\u0004X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u000F\"\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2={"Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "T", "", "name", "", "mergePolicy", "Lkotlin/Function2;", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "isImportantForAccessibility", "", "(Ljava/lang/String;Z)V", "accessibilityExtraKey", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function2;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getMergePolicy$ui", "()Lkotlin/jvm/functions/Function2;", "value", "isImportantForAccessibility$ui", "()Z", "getAccessibilityExtraKey$ui", "setAccessibilityExtraKey$ui", "(Ljava/lang/String;)V", "merge", "parentValue", "childValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getValue", "thisRef", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "property", "Lkotlin/reflect/KProperty;", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "toString", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SemanticsPropertyKey {
    public static final int $stable = 8;
    private String accessibilityExtraKey;
    private boolean isImportantForAccessibility;
    private final Function2 mergePolicy;
    private final String name;

    static {
    }

    public SemanticsPropertyKey(String arg1, Function2 arg2, int arg3, DefaultConstructorMarker arg4) {
        androidx.compose.ui.semantics.SemanticsPropertyKey$1 v2;
        if((arg3 & 2) != 0) {
            v2 = androidx.compose.ui.semantics.SemanticsPropertyKey$1.INSTANCE;
        }

        this(arg1, ((Function2)v2));
    }

    public SemanticsPropertyKey(String arg1, boolean arg2, Function2 arg3, String arg4, int arg5, DefaultConstructorMarker arg6) {
        if((arg5 & 8) != 0) {
            arg4 = null;
        }

        this(arg1, arg2, arg3, arg4);
    }

    public SemanticsPropertyKey(String arg3, boolean arg4) {
        this(arg3, null, 2, null);
        this.isImportantForAccessibility = arg4;
    }

    public SemanticsPropertyKey(String arg1, Function2 arg2) {
        super();
        this.name = arg1;
        this.mergePolicy = arg2;
    }

    public SemanticsPropertyKey(String arg1, boolean arg2, Function2 arg3, String arg4) {
        this(arg1, arg3);
        this.isImportantForAccessibility = arg2;
        this.accessibilityExtraKey = arg4;
    }

    public final String getAccessibilityExtraKey$ui() {
        return this.accessibilityExtraKey;
    }

    public final Function2 getMergePolicy$ui() {
        return this.mergePolicy;
    }

    public final String getName() {
        return this.name;
    }

    public final Object getValue(SemanticsPropertyReceiver arg1, KProperty arg2) {
        return SemanticsPropertiesKt.throwSemanticsGetNotSupported();
    }

    public final boolean isImportantForAccessibility$ui() {
        return this.isImportantForAccessibility;
    }

    public final Object merge(Object arg1, Object arg2) {
        return this.mergePolicy.invoke(arg1, arg2);
    }

    public final void setAccessibilityExtraKey$ui(String arg1) {
        this.accessibilityExtraKey = arg1;
    }

    public final void setValue(SemanticsPropertyReceiver arg1, KProperty arg2, Object arg3) {
        arg1.set(this, arg3);
    }

    public String toString() {
        return "AccessibilityKey: " + this.name;
    }
}

