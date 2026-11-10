package androidx.compose.runtime.snapshots;

import android.os.Parcel;
import kotlin.jvm.functions.Function1;

public final class SnapshotStateList$Companion$CREATOR$1$$ExternalSyntheticLambda0 implements Function1 {
    public SnapshotStateList$Companion$CREATOR$1$$ExternalSyntheticLambda0(Parcel arg1, ClassLoader arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return SnapshotStateList$Companion$CREATOR$1.createFromParcel$lambda$0(this.f$0, this.f$1, ((Integer)arg2).intValue());
    }
}

