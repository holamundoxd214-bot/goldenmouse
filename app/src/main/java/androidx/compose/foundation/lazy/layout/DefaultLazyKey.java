package androidx.compose.foundation.lazy.layout;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0083\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0003H\u0016J\b\u0010\u000B\u001A\u00020\u0003H\u0016J\t\u0010\f\u001A\u00020\u0003HÂ\u0003J\u0013\u0010\r\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Landroidx/compose/foundation/lazy/layout/DefaultLazyKey;", "Landroid/os/Parcelable;", "index", "", "<init>", "(I)V", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "describeContents", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DefaultLazyKey implements Parcelable {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001C\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003¨\u0006\b"}, d2={"Landroidx/compose/foundation/lazy/layout/DefaultLazyKey$Companion;", "", "<init>", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/compose/foundation/lazy/layout/DefaultLazyKey;", "getCREATOR$annotations", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static void getCREATOR$annotations() {
        }
    }

    public static final Parcelable$Creator CREATOR;
    public static final Companion Companion;
    private final int index;

    static {
        DefaultLazyKey.Companion = new Companion(null);
        DefaultLazyKey.CREATOR = new DefaultLazyKey$Companion$CREATOR$1();
    }

    public DefaultLazyKey(int arg1) {
        super();
        this.index = arg1;
    }

    private final int component1() {
        return this.index;
    }

    public final DefaultLazyKey copy(int arg1) {
        return new DefaultLazyKey(arg1);
    }

    public static DefaultLazyKey copy$default(DefaultLazyKey arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.index;
        }

        return arg0.copy(arg1);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object arg4) {
        if(this == (((DefaultLazyKey)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof DefaultLazyKey)) {
            return 0;
        }

        if(this.index != ((DefaultLazyKey)arg4).index) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return Integer.hashCode(this.index);
    }

    public String toString() {
        return "DefaultLazyKey(index=" + this.index + ')';
    }

    public void writeToParcel(Parcel arg1, int arg2) {
        arg1.writeInt(this.index);
    }
}

