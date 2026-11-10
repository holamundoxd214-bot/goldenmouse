package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.StretchFullProjection;
import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchScaling;
import kotlin.Metadata;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u000E\u001A\u00020\u000FH&J\u0012\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013H&J\u0010\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u0016H&J\u0018\u0010\u0017\u001A\u00020\u00112\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u0015\u001A\u00020\u001AH&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\u001BÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalIo;", "", "recoveryWithoutUiVerified", "", "getRecoveryWithoutUiVerified", "()Z", "canApply", "getCanApply", "canRestore", "getCanRestore", "projectionApplyMillis", "", "getProjectionApplyMillis", "()J", "read", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "size", "", "override", "Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "scaling", "value", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchScaling;", "projection", "identity", "", "Lcom/TryJeanPc/goldenmouse/stretch/StretchFullProjection;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface StretchPhysicalIo {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static boolean getCanApply(StretchPhysicalIo arg0) {
            return arg0.getCanApply();
        }

        @Deprecated public static boolean getCanRestore(StretchPhysicalIo arg0) {
            return arg0.getCanRestore();
        }

        @Deprecated public static long getProjectionApplyMillis(StretchPhysicalIo arg2) {
            return arg2.getProjectionApplyMillis();
        }
    }

    static boolean access$getCanApply$jd(StretchPhysicalIo arg0) {
        return super.getCanApply();
    }

    static boolean access$getCanRestore$jd(StretchPhysicalIo arg0) {
        return super.getCanRestore();
    }

    static long access$getProjectionApplyMillis$jd(StretchPhysicalIo arg2) {
        return super.getProjectionApplyMillis();
    }

    default boolean getCanApply() {
        return this.getRecoveryWithoutUiVerified();
    }

    default boolean getCanRestore() {
        return this.getRecoveryWithoutUiVerified();
    }

    default long getProjectionApplyMillis() {
        return -1;
    }

    boolean getRecoveryWithoutUiVerified();

    void projection(String arg1, StretchFullProjection arg2);

    StretchOriginalEvidence read();

    void scaling(StretchScaling arg1);

    void size(StretchSize arg1);
}

