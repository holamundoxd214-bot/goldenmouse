package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0010\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\b\u0010\u000F\u001A\u00020\u0010H\u0016J\u0018\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\u0003H\u0016J\b\u0010\u0015\u001A\u00020\u0003H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u0017"}, d2={"Landroidx/activity/result/ActivityResult;", "Landroid/os/Parcelable;", "resultCode", "", "data", "Landroid/content/Intent;", "<init>", "(ILandroid/content/Intent;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getResultCode", "()I", "getData", "()Landroid/content/Intent;", "toString", "", "writeToParcel", "", "dest", "flags", "describeContents", "Companion", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ActivityResult implements Parcelable {
    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007R\u001C\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000B\u0010\u0003¨\u0006\f"}, d2={"Landroidx/activity/result/ActivityResult$Companion;", "", "<init>", "()V", "resultCodeToString", "", "resultCode", "", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/activity/result/ActivityResult;", "getCREATOR$annotations", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static void getCREATOR$annotations() {
        }

        @JvmStatic public final String resultCodeToString(int arg1) {
            if(arg1 != -1) {
                if(arg1 != 0) {
                    return String.valueOf(arg1);
                }

                return "RESULT_CANCELED";
            }

            return "RESULT_OK";
        }
    }

    public static final Parcelable$Creator CREATOR;
    public static final Companion Companion;
    private final Intent data;
    private final int resultCode;

    static {
        ActivityResult.Companion = new Companion(null);
        ActivityResult.CREATOR = new ActivityResult$Companion$CREATOR$1();
    }

    public ActivityResult(int arg1, Intent arg2) {
        super();
        this.resultCode = arg1;
        this.data = arg2;
    }

    public ActivityResult(Parcel arg3) {
        Object v3_1;
        Intrinsics.checkNotNullParameter(arg3, "parcel");
        int v0 = arg3.readInt();
        if(arg3.readInt() == 0) {
            Intent v3 = null;
        }
        else {
            v3_1 = Intent.CREATOR.createFromParcel(arg3);
        }

        this(v0, ((Intent)v3_1));
    }

    public int describeContents() {
        return 0;
    }

    public final Intent getData() {
        return this.data;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    @JvmStatic public static final String resultCodeToString(int arg1) {
        return ActivityResult.Companion.resultCodeToString(arg1);
    }

    public String toString() {
        return "ActivityResult{resultCode=" + ActivityResult.Companion.resultCodeToString(this.resultCode) + ", data=" + this.data + '}';
    }

    public void writeToParcel(Parcel arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "dest");
        arg2.writeInt(this.resultCode);
        int v0 = this.data == null ? 0 : 1;
        arg2.writeInt(v0);
        Intent v1 = this.data;
        if(v1 != null) {
            v1.writeToParcel(arg2, arg3);
        }
    }
}

