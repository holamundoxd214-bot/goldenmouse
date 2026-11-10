package androidx.compose.ui.semantics;

import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001A\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\b¨\u0006\f"}, d2={"Landroidx/compose/ui/semantics/SemanticsPropertiesAndroid;", "", "<init>", "()V", "TestTagsAsResourceId", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "", "getTestTagsAsResourceId", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "AccessibilityClassName", "", "getAccessibilityClassName", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SemanticsPropertiesAndroid {
    public static final int $stable;
    private static final SemanticsPropertyKey AccessibilityClassName;
    public static final SemanticsPropertiesAndroid INSTANCE;
    private static final SemanticsPropertyKey TestTagsAsResourceId;

    static {
        SemanticsPropertiesAndroid.INSTANCE = new SemanticsPropertiesAndroid();
        SemanticsPropertiesAndroid.TestTagsAsResourceId = new SemanticsPropertyKey("TestTagsAsResourceId", false, SemanticsPropertiesAndroid$TestTagsAsResourceId$1.INSTANCE, null, 8, null);
        SemanticsPropertiesAndroid.AccessibilityClassName = new SemanticsPropertyKey("AccessibilityClassName", true, SemanticsPropertiesAndroid$AccessibilityClassName$1.INSTANCE, null, 8, null);
        SemanticsPropertiesAndroid.$stable = 8;
    }

    private SemanticsPropertiesAndroid() {
        super();
    }

    public final SemanticsPropertyKey getAccessibilityClassName() {
        return SemanticsPropertiesAndroid.AccessibilityClassName;
    }

    public final SemanticsPropertyKey getTestTagsAsResourceId() {
        return SemanticsPropertiesAndroid.TestTagsAsResourceId;
    }
}

