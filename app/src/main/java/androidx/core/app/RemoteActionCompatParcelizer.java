package androidx.core.app;

import androidx.versionedparcelable.VersionedParcel;

public class RemoteActionCompatParcelizer {
    public RemoteActionCompatParcelizer() {
        super();
    }

    public static RemoteActionCompat read(VersionedParcel arg3) {
        RemoteActionCompat v0 = new RemoteActionCompat();
        v0.mIcon = arg3.readVersionedParcelable(v0.mIcon, 1);
        v0.mTitle = arg3.readCharSequence(v0.mTitle, 2);
        v0.mContentDescription = arg3.readCharSequence(v0.mContentDescription, 3);
        v0.mActionIntent = arg3.readParcelable(v0.mActionIntent, 4);
        v0.mEnabled = arg3.readBoolean(v0.mEnabled, 5);
        v0.mShouldShowIcon = arg3.readBoolean(v0.mShouldShowIcon, 6);
        return v0;
    }

    public static void write(RemoteActionCompat arg2, VersionedParcel arg3) {
        arg3.setSerializationFlags(false, false);
        arg3.writeVersionedParcelable(arg2.mIcon, 1);
        arg3.writeCharSequence(arg2.mTitle, 2);
        arg3.writeCharSequence(arg2.mContentDescription, 3);
        arg3.writeParcelable(arg2.mActionIntent, 4);
        arg3.writeBoolean(arg2.mEnabled, 5);
        arg3.writeBoolean(arg2.mShouldShowIcon, 6);
    }
}

