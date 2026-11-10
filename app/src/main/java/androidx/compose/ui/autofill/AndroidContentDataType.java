package androidx.compose.ui.autofill;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0083@\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0005J\u0010\u0010\u0010\u001A\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2={"Landroidx/compose/ui/autofill/AndroidContentDataType;", "Landroidx/compose/ui/autofill/ContentDataType;", "androidAutofillType", "", "constructor-impl", "(I)I", "getAndroidAutofillType", "()I", "equals", "", "other", "", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline final class AndroidContentDataType implements ContentDataType {
    private final int androidAutofillType;

    private AndroidContentDataType(int arg1) {
        super();
        this.androidAutofillType = arg1;
    }

    public static final AndroidContentDataType box-impl(int arg1) {
        return new AndroidContentDataType(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return AndroidContentDataType.equals-impl(this.androidAutofillType, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof AndroidContentDataType)) {
            return 0;
        }

        if(arg2 != ((AndroidContentDataType)arg3).unbox-impl()) {
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

    public final int getAndroidAutofillType() {
        return this.androidAutofillType;
    }

    public int hashCode() {
        return AndroidContentDataType.hashCode-impl(this.androidAutofillType);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return AndroidContentDataType.toString-impl(this.androidAutofillType);
    }

    public static String toString-impl(int arg2) {
        return "AndroidContentDataType(androidAutofillType=" + arg2 + ')';
    }

    public final int unbox-impl() {
        return this.androidAutofillType;
    }
}

