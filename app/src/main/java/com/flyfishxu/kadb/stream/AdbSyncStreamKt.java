package com.flyfishxu.kadb.stream;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0005\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0006\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0007\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\b\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\t\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\n\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000B\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\f\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\r\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000E\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000F\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0010\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0011\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0012\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0013\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0014\u001A\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0016\u001A\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0017\u001A\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0019\u001A\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001A\u001A\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u001A\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00010\u001CX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001E¨\u0006\u001F"}, d2={"ID_LSTAT_V1", "", "ID_STAT_V2", "ID_LSTAT_V2", "ID_LIST_V1", "ID_LIST_V2", "ID_DENT_V1", "ID_DENT_V2", "ID_SEND_V1", "ID_SEND_V2", "ID_RECV_V1", "ID_RECV_V2", "ID_DATA", "ID_DONE", "ID_OKAY", "ID_FAIL", "ID_QUIT", "FEATURE_STAT_V2", "FEATURE_LS_V2", "FEATURE_SENDRECV_V2", "SYNC_PATH_MAX", "", "NAME_MAX", "LIST_V1_DONE_TAIL_BYTES", "", "LIST_V2_DONE_TAIL_BYTES", "SYNC_DATA_MAX", "SYNC_IDS", "", "getSYNC_IDS", "()Ljava/util/Set;", "kadb"}, k=2, mv={2, 3, 0}, xi=0x30) public final class AdbSyncStreamKt {
    private static final String FEATURE_LS_V2 = "ls_v2";
    private static final String FEATURE_SENDRECV_V2 = "sendrecv_v2";
    private static final String FEATURE_STAT_V2 = "stat_v2";
    private static final String ID_DATA = "DATA";
    private static final String ID_DENT_V1 = "DENT";
    private static final String ID_DENT_V2 = "DNT2";
    private static final String ID_DONE = "DONE";
    private static final String ID_FAIL = "FAIL";
    private static final String ID_LIST_V1 = "LIST";
    private static final String ID_LIST_V2 = "LIS2";
    private static final String ID_LSTAT_V1 = "STAT";
    private static final String ID_LSTAT_V2 = "LST2";
    private static final String ID_OKAY = "OKAY";
    private static final String ID_QUIT = "QUIT";
    private static final String ID_RECV_V1 = "RECV";
    private static final String ID_RECV_V2 = "RCV2";
    private static final String ID_SEND_V1 = "SEND";
    private static final String ID_SEND_V2 = "SND2";
    private static final String ID_STAT_V2 = "STA2";
    private static final long LIST_V1_DONE_TAIL_BYTES = 16;
    private static final long LIST_V2_DONE_TAIL_BYTES = 72;
    private static final int NAME_MAX = 0xFF;
    private static final int SYNC_DATA_MAX = 0x10000;
    private static final Set SYNC_IDS = null;
    private static final int SYNC_PATH_MAX = 0x400;

    static {
        AdbSyncStreamKt.SYNC_IDS = SetsKt.setOf(new String[]{"STAT", "STA2", "LST2", "LIST", "LIS2", "DENT", "DNT2", "SEND", "SND2", "RECV", "RCV2", "DATA", "DONE", "OKAY", "FAIL", "QUIT"});
    }

    public static final Set getSYNC_IDS() {
        return AdbSyncStreamKt.SYNC_IDS;
    }
}

