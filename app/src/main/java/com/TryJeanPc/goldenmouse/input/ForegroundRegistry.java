package com.TryJeanPc.goldenmouse.input;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u0002\u001A\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000E\u001A\u00020\rJ\u0016\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\rJ\u000E\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0011\u001A\u00020\u0006J\u001E\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0016\u001A\u00020\u00042\u0006\u0010\u0017\u001A\u00020\u00042\u0006\u0010\u0018\u001A\u00020\u0010J\u0016\u0010\u0019\u001A\u00020\u00142\u0006\u0010\u0016\u001A\u00020\u00042\u0006\u0010\u0017\u001A\u00020\u0004J\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005R \u0010\u0002\u001A\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001A\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"Lcom/TryJeanPc/goldenmouse/input/ForegroundRegistry;", "", "packagesForUid", "Lkotlin/Function1;", "", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "processes", "", "initialPackage", "version", "", "revision", "seedIfUnchanged", "", "packageName", "expected", "seed", "", "changed", "pid", "uid", "foreground", "died", "current", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class ForegroundRegistry {
    public static final int $stable = 8;
    private String initialPackage;
    private final Function1 packagesForUid;
    private final Map processes;
    private long version;

    static {
    }

    public ForegroundRegistry(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "packagesForUid");
        super();
        this.packagesForUid = arg2;
        this.processes = new LinkedHashMap();
    }

    public final void changed(int arg5, int arg6, boolean arg7) {
        Object v6;
        __monitor_enter(this);
        try {
            ++this.version;
            v6 = this.packagesForUid.invoke(Integer.valueOf(arg6));
            if(CollectionsKt.contains(v6, this.initialPackage)) {
                this.initialPackage = null;
            }
        }
        catch(Throwable v5) {
            goto label_24;
        }

        Map v0 = this.processes;
        if(arg7) {
            try {
                v0.put(Integer.valueOf(arg5), v6);
                goto label_21;
            label_19:
                v0.remove(Integer.valueOf(arg5));
            }
            catch(Throwable v5) {
                try {
                label_24:
                    __monitor_exit(this);
                }
                catch(Throwable v5) {
                    goto label_24;
                }

                throw v5;
            }
        }
        else {
            goto label_19;
        }

    label_21:
        __monitor_exit(this);
    }

    public final Set current() {
        Set v0_1;
        __monitor_enter(this);
        try {
            v0_1 = SetsKt.plus(CollectionsKt.toSet(CollectionsKt.flatten(this.processes.values())), CollectionsKt.listOfNotNull(this.initialPackage));
        }
        catch(Throwable v0) {
            try {
            label_11:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_11;
            }

            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    public final void died(int arg5, int arg6) {
        __monitor_enter(this);
        try {
            ++this.version;
            if(CollectionsKt.contains(this.packagesForUid.invoke(Integer.valueOf(arg6)), this.initialPackage)) {
                this.initialPackage = null;
            }

            this.processes.remove(Integer.valueOf(arg5));
        }
        catch(Throwable v5) {
            try {
            label_19:
                __monitor_exit(this);
            }
            catch(Throwable v5) {
                goto label_19;
            }

            throw v5;
        }

        __monitor_exit(this);
    }

    public final long revision() {
        long v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.version;
        }
        catch(Throwable v0) {
            try {
            label_5:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_5;
            }

            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    public final void seed(String arg5) {
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg5, "packageName");
            this.initialPackage = arg5;
            ++this.version;
        }
        catch(Throwable v5) {
            try {
            label_11:
                __monitor_exit(this);
            }
            catch(Throwable v5) {
                goto label_11;
            }

            throw v5;
        }

        __monitor_exit(this);
    }

    public final boolean seedIfUnchanged(String arg3, long arg4) {
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg3, "packageName");
            if(this.version == arg4) {
                goto label_8;
            }
        }
        catch(Throwable v3) {
            goto label_13;
        }

        __monitor_exit(this);
        return 0;
        try {
        label_8:
            this.seed(arg3);
        }
        catch(Throwable v3) {
            try {
            label_13:
                __monitor_exit(this);
            }
            catch(Throwable v3) {
                goto label_13;
            }

            throw v3;
        }

        __monitor_exit(this);
        return 1;
    }
}

