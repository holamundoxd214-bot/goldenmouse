package androidx.core.flagging;

import android.os.flagging.AconfigPackage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0007H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Landroidx/core/flagging/AconfigPackageCompatApi36Impl;", "Landroidx/core/flagging/AconfigPackageCompat;", "aconfigPackageImpl", "Landroid/os/flagging/AconfigPackage;", "<init>", "(Landroid/os/flagging/AconfigPackage;)V", "getBooleanFlagValue", "", "flagName", "", "defaultValue", "core"}, k=1, mv={2, 1, 0}, xi=0x30) final class AconfigPackageCompatApi36Impl implements AconfigPackageCompat {
    private final AconfigPackage aconfigPackageImpl;

    public AconfigPackageCompatApi36Impl(AconfigPackage arg2) {
        Intrinsics.checkNotNullParameter(arg2, "aconfigPackageImpl");
        super();
        this.aconfigPackageImpl = arg2;
    }

    public boolean getBooleanFlagValue(String arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "flagName");
        return this.aconfigPackageImpl.getBooleanFlagValue(arg2, arg3);
    }
}

