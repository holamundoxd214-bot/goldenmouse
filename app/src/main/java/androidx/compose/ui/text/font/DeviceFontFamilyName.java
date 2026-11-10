package androidx.compose.ui.text.font;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087@\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\r\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0013"}, d2={"Landroidx/compose/ui/text/font/DeviceFontFamilyName;", "", "name", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getName", "()Ljava/lang/String;", "equals", "", "other", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class DeviceFontFamilyName {
    private final String name;

    private DeviceFontFamilyName(String arg1) {
        super();
        this.name = arg1;
    }

    public static final DeviceFontFamilyName box-impl(String arg1) {
        return new DeviceFontFamilyName(arg1);
    }

    public static String constructor-impl(String arg1) {
        int v0 = arg1.length() > 0 ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("name may not be empty");
        }

        return arg1;
    }

    public boolean equals(Object arg1) {
        return DeviceFontFamilyName.equals-impl(this.name, arg1);
    }

    public static boolean equals-impl(String arg2, Object arg3) {
        if(!(arg3 instanceof DeviceFontFamilyName)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((DeviceFontFamilyName)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(String arg0, String arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return DeviceFontFamilyName.hashCode-impl(this.name);
    }

    public static int hashCode-impl(String arg0) {
        return arg0.hashCode();
    }

    public String toString() {
        return DeviceFontFamilyName.toString-impl(this.name);
    }

    public static String toString-impl(String arg2) {
        return "DeviceFontFamilyName(name=" + arg2 + ')';
    }

    public final String unbox-impl() {
        return this.name;
    }
}

