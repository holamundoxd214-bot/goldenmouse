package androidx.compose.ui.text;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0010\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0016\u001A\u00020\u0017H\u0016J\b\u0010\u0018\u001A\u00020\u0019H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\f\u0010\nR\u0013\u0010\u0005\u001A\u00020\u0006¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\r\u0010\u000E¨\u0006\u001A"}, d2={"Landroidx/compose/ui/text/Placeholder;", "", "width", "Landroidx/compose/ui/unit/TextUnit;", "height", "placeholderVerticalAlign", "Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "<init>", "(JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getWidth-XSAIIZE", "()J", "J", "getHeight-XSAIIZE", "getPlaceholderVerticalAlign-J6kI3mc", "()I", "I", "copy", "copy-K8Q-__8", "(JJI)Landroidx/compose/ui/text/Placeholder;", "equals", "", "other", "hashCode", "", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Placeholder {
    public static final int $stable;
    private final long height;
    private final int placeholderVerticalAlign;
    private final long width;

    static {
    }

    private Placeholder(long arg3, long arg5, int arg7) {
        super();
        this.width = arg3;
        this.height = arg5;
        this.placeholderVerticalAlign = arg7;
        long v0 = 0;
        int v2 = Long.compare(TextUnit.getRawType-impl(arg3), v0);
        int v3 = 1;
        v2 = v2 == 0 ? 1 : 0;
        if(v2 != 0) {
            InlineClassHelperKt.throwIllegalArgumentException("width cannot be TextUnit.Unspecified");
        }

        if(TextUnit.getRawType-impl(arg5) == v0) {
        }
        else {
            v3 = 0;
        }

        if(v3 != 0) {
            InlineClassHelperKt.throwIllegalArgumentException("height cannot be TextUnit.Unspecified");
        }
    }

    public Placeholder(long arg1, long arg3, int arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg3, arg5);
    }

    public final Placeholder copy-K8Q-__8(long arg8, long arg10, int arg12) {
        return new Placeholder(arg8, arg10, arg12, null);
    }

    public static Placeholder copy-K8Q-__8$default(Placeholder arg6, long arg7, long arg9, int arg11, int arg12, Object arg13) {
        if((arg12 & 1) != 0) {
            arg7 = arg6.width;
        }

        long v1 = arg7;
        if((arg12 & 2) != 0) {
            arg9 = arg6.height;
        }

        long v3 = arg9;
        if((arg12 & 4) != 0) {
            arg11 = arg6.placeholderVerticalAlign;
        }

        return arg6.copy-K8Q-__8(v1, v3, arg11);
    }

    public boolean equals(Object arg8) {
        if(this == (((Placeholder)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof Placeholder)) {
            return 0;
        }

        if(!TextUnit.equals-impl0(this.width, ((Placeholder)arg8).width)) {
            return 0;
        }

        if(!TextUnit.equals-impl0(this.height, ((Placeholder)arg8).height)) {
            return 0;
        }

        if(!PlaceholderVerticalAlign.equals-impl0(this.placeholderVerticalAlign, ((Placeholder)arg8).placeholderVerticalAlign)) {
            return 0;
        }

        return 1;
    }

    public final long getHeight-XSAIIZE() {
        return this.height;
    }

    public final int getPlaceholderVerticalAlign-J6kI3mc() {
        return this.placeholderVerticalAlign;
    }

    public final long getWidth-XSAIIZE() {
        return this.width;
    }

    public int hashCode() {
        return (TextUnit.hashCode-impl(this.width) * 0x1F + TextUnit.hashCode-impl(this.height)) * 0x1F + PlaceholderVerticalAlign.hashCode-impl(this.placeholderVerticalAlign);
    }

    public String toString() {
        return "Placeholder(width=" + TextUnit.toString-impl(this.width) + ", height=" + TextUnit.toString-impl(this.height) + ", placeholderVerticalAlign=" + PlaceholderVerticalAlign.toString-impl(this.placeholderVerticalAlign) + ')';
    }
}

