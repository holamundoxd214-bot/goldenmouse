package androidx.compose.runtime;

import kotlin.Metadata;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u001A\u0010\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0001H\u0001\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0006\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0007\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\b\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\t\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\n\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000B\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\f\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\r\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000E\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000F\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0010\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"changedLowBitMask", "", "changedHighBitMask", "changedMask", "updateChangedFlags", "flags", "UsedFlag", "DefaultsInScopeFlag", "DefaultsInvalidFlag", "RequiresRecomposeFlag", "SkippedFlag", "RereadingFlag", "ForcedRecomposeFlag", "ForceReusing", "Paused", "Resuming", "ResetReusing", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class RecomposeScopeImplKt {
    private static final int DefaultsInScopeFlag = 2;
    private static final int DefaultsInvalidFlag = 4;
    private static final int ForceReusing = 0x80;
    private static final int ForcedRecomposeFlag = 0x40;
    private static final int Paused = 0x100;
    private static final int RequiresRecomposeFlag = 8;
    private static final int RereadingFlag = 0x20;
    private static final int ResetReusing = 0x400;
    private static final int Resuming = 0x200;
    private static final int SkippedFlag = 16;
    private static final int UsedFlag = 1;
    private static final int changedHighBitMask = 0x24924924;
    private static final int changedLowBitMask = 306783378;
    private static final int changedMask = -920350135;

    public static final int updateChangedFlags(int arg3) {
        int v0 = 306783378 & arg3;
        int v1 = 0x24924924 & arg3;
        return arg3 & -920350135 | (v1 >> 1 | v0) | v0 << 1 & v1;
    }
}

