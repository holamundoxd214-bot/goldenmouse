package android.support.v4.app;

import androidx.core.app.RemoteActionCompat;
import androidx.versionedparcelable.VersionedParcel;

public final class RemoteActionCompatParcelizer extends androidx.core.app.RemoteActionCompatParcelizer {
    public RemoteActionCompatParcelizer() {
        super();
    }

    public static RemoteActionCompat read(VersionedParcel arg0) {
        return androidx.core.app.RemoteActionCompatParcelizer.read(arg0);
    }

    public static void write(RemoteActionCompat arg0, VersionedParcel arg1) {
        androidx.core.app.RemoteActionCompatParcelizer.write(arg0, arg1);
    }
}

