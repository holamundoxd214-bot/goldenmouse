package com.TryJeanPc.goldenmouse.stretch.agent;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\b\b\u0002\u0010\t\u001A\u00020\b\u0012\b\b\u0002\u0010\n\u001A\u00020\b¢\u0006\u0004\b\u000B\u0010\fJ\u0006\u0010\u001A\u001A\u00020\u0003J\t\u0010\u001B\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u001C\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u001D\u001A\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001E\u001A\u00020\bHÆ\u0003J\t\u0010\u001F\u001A\u00020\bHÆ\u0003J\t\u0010 \u001A\u00020\bHÆ\u0003JI\u0010!\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\bHÆ\u0001J\u0013\u0010\"\u001A\u00020\u00172\b\u0010#\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001A\u00020%HÖ\u0001J\t\u0010&\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000ER\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0013R\u0011\u0010\n\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001A\u00020\u00178F¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019¨\u0006\'"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPairResult;", "", "code", "", "errorType", "appliedReadback", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "writesMillis", "", "projectionApplyMillis", "readbackMillis", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;JJJ)V", "getCode", "()Ljava/lang/String;", "getErrorType", "getAppliedReadback", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "getWritesMillis", "()J", "getProjectionApplyMillis", "getReadbackMillis", "physicalRecoveryAccredited", "", "getPhysicalRecoveryAccredited", "()Z", "safeCode", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchPairResult {
    public static final int $stable;
    private final StretchOriginalEvidence appliedReadback;
    private final String code;
    private final String errorType;
    private final long projectionApplyMillis;
    private final long readbackMillis;
    private final long writesMillis;

    static {
    }

    public StretchPairResult(String arg3, String arg4, StretchOriginalEvidence arg5, long arg6, long arg8, long arg10, int arg12, DefaultConstructorMarker arg13) {
        String v0 = null;
        if((arg12 & 2) != 0) {
            arg4 = v0;
        }

        if((arg12 & 4) != 0) {
            arg5 = ((StretchOriginalEvidence)v0);
        }

        long v0_1 = -1;
        if((arg12 & 8) != 0) {
            arg6 = v0_1;
        }

        if((arg12 & 16) != 0) {
            arg8 = v0_1;
        }

        if((arg12 & 0x20) != 0) {
            arg10 = v0_1;
        }

        this(arg3, arg4, arg5, arg6, arg8, arg10);
    }

    public StretchPairResult(String arg2, String arg3, StretchOriginalEvidence arg4, long arg5, long arg7, long arg9) {
        Intrinsics.checkNotNullParameter(arg2, "code");
        super();
        this.code = arg2;
        this.errorType = arg3;
        this.appliedReadback = arg4;
        this.writesMillis = arg5;
        this.projectionApplyMillis = arg7;
        this.readbackMillis = arg9;
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.errorType;
    }

    public final StretchOriginalEvidence component3() {
        return this.appliedReadback;
    }

    public final long component4() {
        return this.writesMillis;
    }

    public final long component5() {
        return this.projectionApplyMillis;
    }

    public final long component6() {
        return this.readbackMillis;
    }

    public final StretchPairResult copy(String arg11, String arg12, StretchOriginalEvidence arg13, long arg14, long arg16, long arg18) {
        Intrinsics.checkNotNullParameter(arg11, "code");
        return new StretchPairResult(arg11, arg12, arg13, arg14, arg16, arg18);
    }

    public static StretchPairResult copy$default(StretchPairResult arg0, String arg1, String arg2, StretchOriginalEvidence arg3, long arg4, long arg6, long arg8, int arg10, Object arg11) {
        if((arg10 & 1) != 0) {
            arg1 = arg0.code;
        }

        if((arg10 & 2) != 0) {
            arg2 = arg0.errorType;
        }

        if((arg10 & 4) != 0) {
            arg3 = arg0.appliedReadback;
        }

        if((arg10 & 8) != 0) {
            arg4 = arg0.writesMillis;
        }

        if((arg10 & 16) != 0) {
            arg6 = arg0.projectionApplyMillis;
        }

        if((arg10 & 0x20) != 0) {
            arg8 = arg0.readbackMillis;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg6, arg8);
    }

    public boolean equals(Object arg8) {
        if(this == (((StretchPairResult)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof StretchPairResult)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.code, ((StretchPairResult)arg8).code)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.errorType, ((StretchPairResult)arg8).errorType)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.appliedReadback, ((StretchPairResult)arg8).appliedReadback)) {
            return 0;
        }

        if(this.writesMillis != ((StretchPairResult)arg8).writesMillis) {
            return 0;
        }

        if(this.projectionApplyMillis != ((StretchPairResult)arg8).projectionApplyMillis) {
            return 0;
        }

        if(this.readbackMillis != ((StretchPairResult)arg8).readbackMillis) {
            return 0;
        }

        return 1;
    }

    public final StretchOriginalEvidence getAppliedReadback() {
        return this.appliedReadback;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getErrorType() {
        return this.errorType;
    }

    public final boolean getPhysicalRecoveryAccredited() {
        return 0;
    }

    public final long getProjectionApplyMillis() {
        return this.projectionApplyMillis;
    }

    public final long getReadbackMillis() {
        return this.readbackMillis;
    }

    public final long getWritesMillis() {
        return this.writesMillis;
    }

    public int hashCode() {
        int v0 = this.code.hashCode() * 0x1F;
        String v1 = this.errorType;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        StretchOriginalEvidence v1_2 = this.appliedReadback;
        if(v1_2 == null) {
        }
        else {
            v2 = v1_2.hashCode();
        }

        return (((v0 + v2) * 0x1F + Long.hashCode(this.writesMillis)) * 0x1F + Long.hashCode(this.projectionApplyMillis)) * 0x1F + Long.hashCode(this.readbackMillis);
    }

    public final String safeCode() {
        String v0 = this.code;
        String v4 = this.errorType;
        if(v4 != null) {
            if(new Regex("[A-Za-z0-9_]{1,60}").matches(v4)) {
            }
            else {
                v4 = null;
            }

            if(v4 != null) {
                Locale v1 = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(v1, "ROOT");
                v4 = v4.toUpperCase(v1);
                Intrinsics.checkNotNullExpressionValue(v4, "toUpperCase(...)");
                if(v4 == null) {
                    goto label_19;
                }
            }
            else {
            label_19:
                v4 = "UNKNOWN";
            }

            v4 = "_" + v4;
            if(v4 != null) {
                goto label_27;
            }

            goto label_26;
        }
        else {
        label_26:
            v4 = "";
        }

    label_27:
        return v0 + v4;
    }

    public String toString() {
        return "StretchPairResult(code=" + this.code + ", errorType=" + this.errorType + ", appliedReadback=" + this.appliedReadback + ", writesMillis=" + this.writesMillis + ", projectionApplyMillis=" + this.projectionApplyMillis + ", readbackMillis=" + this.readbackMillis + ")";
    }
}

