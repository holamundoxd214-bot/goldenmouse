package androidx.activity.result;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001B2\u00020\u0001:\u0002\u001A\u001BB1\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0010\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\t\u0010\rJ\b\u0010\u0015\u001A\u00020\u0007H\u0016J\u0018\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\f2\u0006\u0010\u0019\u001A\u00020\u0007H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0013¨\u0006\u001C"}, d2={"Landroidx/activity/result/IntentSenderRequest;", "Landroid/os/Parcelable;", "intentSender", "Landroid/content/IntentSender;", "fillInIntent", "Landroid/content/Intent;", "flagsMask", "", "flagsValues", "<init>", "(Landroid/content/IntentSender;Landroid/content/Intent;II)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getIntentSender", "()Landroid/content/IntentSender;", "getFillInIntent", "()Landroid/content/Intent;", "getFlagsMask", "()I", "getFlagsValues", "describeContents", "writeToParcel", "", "dest", "flags", "Builder", "Companion", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class IntentSenderRequest implements Parcelable {
    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\u000E\u001A\u00020\u00002\b\u0010\t\u001A\u0004\u0018\u00010\nJ\u0016\u0010\u000F\u001A\u00020\u00002\u0006\u0010\u0010\u001A\u00020\f2\u0006\u0010\u0011\u001A\u00020\fJ\u0006\u0010\u0012\u001A\u00020\u0013R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/activity/result/IntentSenderRequest$Builder;", "", "intentSender", "Landroid/content/IntentSender;", "<init>", "(Landroid/content/IntentSender;)V", "pendingIntent", "Landroid/app/PendingIntent;", "(Landroid/app/PendingIntent;)V", "fillInIntent", "Landroid/content/Intent;", "flagsMask", "", "flagsValues", "setFillInIntent", "setFlags", "values", "mask", "build", "Landroidx/activity/result/IntentSenderRequest;", "Flag", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Builder {
        private Intent fillInIntent;
        private int flagsMask;
        private int flagsValues;
        private final IntentSender intentSender;

        public Builder(PendingIntent arg2) {
            Intrinsics.checkNotNullParameter(arg2, "pendingIntent");
            IntentSender v2 = arg2.getIntentSender();
            Intrinsics.checkNotNullExpressionValue(v2, "getIntentSender(...)");
            this(v2);
        }

        public Builder(IntentSender arg2) {
            Intrinsics.checkNotNullParameter(arg2, "intentSender");
            super();
            this.intentSender = arg2;
        }

        public final IntentSenderRequest build() {
            return new IntentSenderRequest(this.intentSender, this.fillInIntent, this.flagsMask, this.flagsValues);
        }

        public final Builder setFillInIntent(Intent arg1) {
            this.fillInIntent = arg1;
            return this;
        }

        public final Builder setFlags(int arg1, int arg2) {
            this.flagsValues = arg1;
            this.flagsMask = arg2;
            return this;
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001C\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003¨\u0006\b"}, d2={"Landroidx/activity/result/IntentSenderRequest$Companion;", "", "<init>", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/activity/result/IntentSenderRequest;", "getCREATOR$annotations", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
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
    private final Intent fillInIntent;
    private final int flagsMask;
    private final int flagsValues;
    private final IntentSender intentSender;

    static {
        IntentSenderRequest.Companion = new Companion(null);
        IntentSenderRequest.CREATOR = new IntentSenderRequest$Companion$CREATOR$1();
    }

    public IntentSenderRequest(IntentSender arg2, Intent arg3, int arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg2, "intentSender");
        super();
        this.intentSender = arg2;
        this.fillInIntent = arg3;
        this.flagsMask = arg4;
        this.flagsValues = arg5;
    }

    public IntentSenderRequest(IntentSender arg2, Intent arg3, int arg4, int arg5, int arg6, DefaultConstructorMarker arg7) {
        if((arg6 & 2) != 0) {
            arg3 = null;
        }

        this(arg2, arg3, 0, 0);
    }

    public IntentSenderRequest(Parcel arg4) {
        Intrinsics.checkNotNullParameter(arg4, "parcel");
        Parcelable v0 = arg4.readParcelable(IntentSender.class.getClassLoader());
        Intrinsics.checkNotNull(v0);
        this(((IntentSender)v0), arg4.readParcelable(Intent.class.getClassLoader()), arg4.readInt(), arg4.readInt());
    }

    public int describeContents() {
        return 0;
    }

    public final Intent getFillInIntent() {
        return this.fillInIntent;
    }

    public final int getFlagsMask() {
        return this.flagsMask;
    }

    public final int getFlagsValues() {
        return this.flagsValues;
    }

    public final IntentSender getIntentSender() {
        return this.intentSender;
    }

    public void writeToParcel(Parcel arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "dest");
        arg2.writeParcelable(this.intentSender, arg3);
        arg2.writeParcelable(this.fillInIntent, arg3);
        arg2.writeInt(this.flagsMask);
        arg2.writeInt(this.flagsValues);
    }
}

