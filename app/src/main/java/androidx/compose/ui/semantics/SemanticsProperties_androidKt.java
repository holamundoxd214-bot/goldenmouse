package androidx.compose.ui.semantics;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u001AB\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u001E\b\u0002\u0010\u0006\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0007\"/\u0010\n\u001A\u00020\t*\u00020\u000B2\u0006\u0010\b\u001A\u00020\t8F@FX\u0086\u008E\u0002¢\u0006\u0012\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011*\u0004\b\f\u0010\r\"/\u0010\u0012\u001A\u00020\u0004*\u00020\u000B2\u0006\u0010\b\u001A\u00020\u00048F@FX\u0086\u008E\u0002¢\u0006\u0012\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017*\u0004\b\u0013\u0010\r¨\u0006\u0018"}, d2={"SemanticsPropertyKey", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "T", "name", "", "accessibilityExtraKey", "mergePolicy", "Lkotlin/Function2;", "<set-?>", "", "testTagsAsResourceId", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "getTestTagsAsResourceId$delegate", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/Object;", "getTestTagsAsResourceId", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", "setTestTagsAsResourceId", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Z)V", "accessibilityClassName", "getAccessibilityClassName$delegate", "getAccessibilityClassName", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", "setAccessibilityClassName", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/lang/String;)V", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SemanticsProperties_androidKt {
    static {
        KProperty[] v0 = new KProperty[2];
        Class v2 = SemanticsProperties_androidKt.class;
        v0[0] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "testTagsAsResourceId", "getTestTagsAsResourceId(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1));
        v0[1] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "accessibilityClassName", "getAccessibilityClassName(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1));
        SemanticsProperties_androidKt.$$delegatedProperties = v0;
        SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId();
        SemanticsPropertiesAndroid.INSTANCE.getAccessibilityClassName();
    }

    public static final SemanticsPropertyKey SemanticsPropertyKey(String arg2, String arg3, Function2 arg4) {
        return new SemanticsPropertyKey(arg2, false, arg4, arg3);
    }

    public static SemanticsPropertyKey SemanticsPropertyKey$default(String arg0, String arg1, Function2 arg2, int arg3, Object arg4) {
        SemanticsProperties_androidKt$SemanticsPropertyKey$1 v2;
        if((arg3 & 4) != 0) {
            v2 = SemanticsProperties_androidKt$SemanticsPropertyKey$1.INSTANCE;
        }

        return SemanticsProperties_androidKt.SemanticsPropertyKey(arg0, arg1, ((Function2)v2));
    }

    public static final String getAccessibilityClassName(SemanticsPropertyReceiver arg3) {
        return SemanticsPropertiesAndroid.INSTANCE.getAccessibilityClassName().getValue(arg3, SemanticsProperties_androidKt.$$delegatedProperties[1]);
    }

    private static Object getAccessibilityClassName$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsPropertiesAndroid.INSTANCE.getAccessibilityClassName();
    }

    public static final boolean getTestTagsAsResourceId(SemanticsPropertyReceiver arg3) {
        return SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId().getValue(arg3, SemanticsProperties_androidKt.$$delegatedProperties[0]).booleanValue();
    }

    private static Object getTestTagsAsResourceId$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId();
    }

    public static final void setAccessibilityClassName(SemanticsPropertyReceiver arg3, String arg4) {
        SemanticsPropertiesAndroid.INSTANCE.getAccessibilityClassName().setValue(arg3, SemanticsProperties_androidKt.$$delegatedProperties[1], arg4);
    }

    public static final void setTestTagsAsResourceId(SemanticsPropertyReceiver arg3, boolean arg4) {
        SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId().setValue(arg3, SemanticsProperties_androidKt.$$delegatedProperties[0], Boolean.valueOf(arg4));
    }
}

