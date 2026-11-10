package com.TryJeanPc.goldenmouse.profile;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0013"}, d2={"Lcom/TryJeanPc/goldenmouse/profile/RejectedMacroPayload;", "", "settingsJson", "", "reason", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSettingsJson", "()Ljava/lang/String;", "getReason", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RejectedMacroPayload {
    public static final int $stable;
    private final String reason;
    private final String settingsJson;

    static {
    }

    public RejectedMacroPayload(String arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "settingsJson");
        Intrinsics.checkNotNullParameter(arg3, "reason");
        super();
        this.settingsJson = arg2;
        this.reason = arg3;
    }

    public final String component1() {
        return this.settingsJson;
    }

    public final String component2() {
        return this.reason;
    }

    public final RejectedMacroPayload copy(String arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "settingsJson");
        Intrinsics.checkNotNullParameter(arg2, "reason");
        return new RejectedMacroPayload(arg1, arg2);
    }

    public static RejectedMacroPayload copy$default(RejectedMacroPayload arg0, String arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.settingsJson;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.reason;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((RejectedMacroPayload)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof RejectedMacroPayload)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.settingsJson, ((RejectedMacroPayload)arg5).settingsJson)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.reason, ((RejectedMacroPayload)arg5).reason)) {
            return 0;
        }

        return 1;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getSettingsJson() {
        return this.settingsJson;
    }

    public int hashCode() {
        return this.settingsJson.hashCode() * 0x1F + this.reason.hashCode();
    }

    public String toString() {
        return "RejectedMacroPayload(settingsJson=" + this.settingsJson + ", reason=" + this.reason + ")";
    }
}

