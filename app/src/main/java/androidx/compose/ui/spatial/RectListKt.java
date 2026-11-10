package androidx.compose.ui.spatial;

import kotlin.Metadata;
import kotlin.ULong;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000B\n\u0002\b-\u001A\u0019\u0010\u001B\u001A\u00020\u000E2\u0006\u0010\u001C\u001A\u00020\u00012\u0006\u0010\u001D\u001A\u00020\u0001H\u0080\b\u001AA\u0010\u001E\u001A\u00020\u000E2\u0006\u0010\u001F\u001A\u00020\u00012\u0006\u0010 \u001A\u00020\u00012\u0006\u0010!\u001A\u00020\u00012\u0006\u0010\"\u001A\u00020#2\u0006\u0010$\u001A\u00020#2\u0006\u0010%\u001A\u00020#2\u0006\u0010&\u001A\u00020#H\u0080\b\u001A\u0011\u0010\'\u001A\u00020\u00012\u0006\u0010(\u001A\u00020\u000EH\u0080\b\u001A\u0011\u0010)\u001A\u00020\u00012\u0006\u0010(\u001A\u00020\u000EH\u0080\b\u001A\u0011\u0010*\u001A\u00020\u00012\u0006\u0010(\u001A\u00020\u000EH\u0080\b\u001A\u0019\u0010+\u001A\u00020\u000E2\u0006\u0010(\u001A\u00020\u000E2\u0006\u0010 \u001A\u00020\u0001H\u0080\b\u001A\u0011\u0010,\u001A\u00020\u000E2\u0006\u0010(\u001A\u00020\u000EH\u0080\b\u001A\u0011\u0010-\u001A\u00020\u000E2\u0006\u0010(\u001A\u00020\u000EH\u0080\b\u001A!\u0010.\u001A\u00020\u000E2\u0006\u0010(\u001A\u00020\u000E2\u0006\u0010$\u001A\u00020#2\u0006\u0010%\u001A\u00020#H\u0080\b\u001A\u0019\u0010/\u001A\u00020\u000E2\u0006\u0010(\u001A\u00020\u000E2\u0006\u0010!\u001A\u00020\u0001H\u0080\b\u001A\u0011\u00100\u001A\u00020\u00012\u0006\u0010(\u001A\u00020\u000EH\u0080\b\u001A\u0011\u00101\u001A\u00020\u00012\u0006\u0010(\u001A\u00020\u000EH\u0080\b\u001A\u0011\u00102\u001A\u00020\u00012\u0006\u0010(\u001A\u00020\u000EH\u0080\b\u001A\u0011\u00103\u001A\u00020\u00012\u0006\u0010(\u001A\u00020\u000EH\u0080\b\u001A\u0011\u00104\u001A\u00020\u000E2\u0006\u0010(\u001A\u00020\u000EH\u0080\b\u001A!\u00105\u001A\u00020\u000E2\u0006\u0010(\u001A\u00020\u000E2\u0006\u0010\"\u001A\u00020#2\u0006\u0010&\u001A\u00020#H\u0080\b\u001A\u0011\u00106\u001A\u00020\u00012\u0006\u00107\u001A\u00020\u000EH\u0080\b\u001A\u0011\u00108\u001A\u00020\u00012\u0006\u00107\u001A\u00020\u000EH\u0080\b\u001A)\u00109\u001A\u00020#2\u0006\u0010:\u001A\u00020\u000E2\u0006\u0010;\u001A\u00020\u000E2\u0006\u0010<\u001A\u00020\u000E2\u0006\u0010=\u001A\u00020\u000EH\u0080\b\u001A\r\u0010>\u001A\u00020\u000E*\u00020#H\u0080\b\u001AP\u0010?\u001A\u00020\u00012\u0006\u0010@\u001A\u00020\u00012\u0006\u0010A\u001A\u00020\u00012\u0006\u0010B\u001A\u00020\u00012\u0006\u0010C\u001A\u00020\u00012\u0006\u0010D\u001A\u00020\u00012\u0006\u0010E\u001A\u00020\u00012\u0006\u0010F\u001A\u00020\u00012\u0006\u0010G\u001A\u00020\u00012\u0006\u0010H\u001A\u00020\u0001H\u0000\u001A8\u0010I\u001A\u00020\u00012\u0006\u0010J\u001A\u00020\u00012\u0006\u0010K\u001A\u00020\u00012\u0006\u0010L\u001A\u00020\u00012\u0006\u0010M\u001A\u00020\u00012\u0006\u0010N\u001A\u00020\u00012\u0006\u0010O\u001A\u00020\u0001H\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0005\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0006\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0007\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\b\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\t\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\n\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000B\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\f\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\r\u001A\u00020\u000EX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0014\u0010\u0011\u001A\u00020\u000EX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0010\"\u000E\u0010\u0013\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0014\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0015\u001A\u00020\u000EX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0010\"\u000E\u0010\u0017\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0018\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0019\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001A\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006P"}, d2={"LongsPerItem", "", "InitialSize", "Lower25Bits", "Lower10Bits", "MaxSupportedId", "MaxSupportedLastChildOffset", "BitOffsetForParentId", "BitOffsetForLastChildOffset", "BitOffsetForUpdated", "BitOffsetForFocusable", "BitOffsetForGesturable", "BitOffsetForHasCallbacks", "EverythingButLastChildOffset", "", "getEverythingButLastChildOffset", "()J", "EverythingButParentId", "getEverythingButParentId", "PackedIntsLowestBit", "PackedIntsHighestBit", "TombStone", "getTombStone", "AxisNorth", "AxisSouth", "AxisWest", "AxisEast", "packXY", "x", "y", "packMeta", "itemId", "parentId", "lastChildOffset", "updated", "", "focusable", "gesturable", "hasCallbacks", "unpackMetaValue", "meta", "unpackMetaParentId", "unpackMetaLastChildOffset", "metaWithParentId", "metaMarkUpdated", "metaUnMarkUpdated", "metaMarkFlags", "metaWithLastChildOffset", "unpackMetaFocusable", "unpackMetaGesturable", "unpackMetaUpdated", "unpackMetaHasCallbacks", "metaMarkUpdatedIfHasCallbacks", "metaMarkUpdatedAndHasCallbacks", "unpackX", "xy", "unpackY", "rectIntersectsRect", "srcLT", "srcRB", "destLT", "destRB", "toLong", "distanceScore", "axis", "queryL", "queryT", "queryR", "queryB", "l", "t", "r", "b", "distanceScoreAlongAxis", "distanceMin", "distanceMax", "queryCrossAxisMax", "queryCrossAxisMin", "crossAxisMax", "crossAxisMin", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RectListKt {
    public static final int AxisEast = 3;
    public static final int AxisNorth = 0;
    public static final int AxisSouth = 1;
    public static final int AxisWest = 2;
    public static final int BitOffsetForFocusable = 61;
    public static final int BitOffsetForGesturable = 62;
    public static final int BitOffsetForHasCallbacks = 0x3F;
    public static final int BitOffsetForLastChildOffset = 50;
    public static final int BitOffsetForParentId = 25;
    public static final int BitOffsetForUpdated = 60;
    private static final long EverythingButLastChildOffset = 0;
    private static final long EverythingButParentId = 0;
    public static final int InitialSize = 0x40;
    public static final int LongsPerItem = 3;
    public static final int Lower10Bits = 0x3FF;
    private static final int Lower25Bits = 0x1FFFFFF;
    private static final int MaxSupportedId = 0x1FFFFFF;
    public static final int MaxSupportedLastChildOffset = 0x3FF;
    private static final long PackedIntsHighestBit = -9223372034707292160L;
    private static final long PackedIntsLowestBit = 0x100000001L;
    private static final long TombStone;

    static {
        RectListKt.EverythingButLastChildOffset = ULong.constructor-impl(ULong.constructor-impl(ULong.constructor-impl(0x3FF) << 50) ^ -1);
        RectListKt.EverythingButParentId = ULong.constructor-impl(ULong.constructor-impl(ULong.constructor-impl(0x1FFFFFF) << 25) ^ -1);
        RectListKt.TombStone = (((long)Math.min(0, 0x3FF))) << 50 | 0x3FFFFFFFFFFFFL;
    }

    public static final int distanceScore(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
        if(arg1 != 0) {
            if(arg1 != 1) {
                if(arg1 != 2) {
                    if(arg1 != 3) {
                        return 0x7FFFFFFF;
                    }

                    return RectListKt.distanceScoreAlongAxis(arg6, arg4, arg5, arg3, arg9, arg7);
                }

                return RectListKt.distanceScoreAlongAxis(arg2, arg8, arg5, arg3, arg9, arg7);
            }

            return RectListKt.distanceScoreAlongAxis(arg7, arg5, arg4, arg2, arg8, arg6);
        }

        return RectListKt.distanceScoreAlongAxis(arg3, arg9, arg4, arg2, arg8, arg6);
    }

    public static final int distanceScoreAlongAxis(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        return (arg0 - arg1 + 1) * (arg2 - arg3 + Math.max(arg3, arg5) - Math.min(arg2, arg4) + 1);
    }

    public static final long getEverythingButLastChildOffset() {
        return RectListKt.EverythingButLastChildOffset;
    }

    public static final long getEverythingButParentId() {
        return RectListKt.EverythingButParentId;
    }

    public static final long getTombStone() {
        return RectListKt.TombStone;
    }

    public static final long metaMarkFlags(long arg4, boolean arg6, boolean arg7) {
        return arg4 & -6917529027641081857L | (((long)(((int)arg6)))) * 0x2000000000000000L | (((long)(((int)arg7)))) * 0x4000000000000000L;
    }

    public static final long metaMarkUpdated(long arg2) {
        return arg2 | 0x1000000000000000L;
    }

    public static final long metaMarkUpdatedAndHasCallbacks(long arg4, boolean arg6, boolean arg7) {
        return arg4 & 0x6FFFFFFFFFFFFFFFL | (((long)(((int)arg6)))) * 0x1000000000000000L | (((long)(((int)arg7)))) * -9223372036854775808L;
    }

    public static final long metaMarkUpdatedIfHasCallbacks(long arg4) {
        return arg4 | (arg4 >> 0x3F & 1) << 60;
    }

    public static final long metaUnMarkUpdated(long arg2) {
        return arg2 & -1152921504606846977L;
    }

    public static final long metaWithLastChildOffset(long arg2, int arg4) {
        return arg2 & RectListKt.getEverythingButLastChildOffset() | (((long)Math.min(arg4, 0x3FF))) << 50;
    }

    public static final long metaWithParentId(long arg2, int arg4) {
        return arg2 & RectListKt.getEverythingButParentId() | (((long)(arg4 & 0x1FFFFFF))) << 25;
    }

    public static final long packMeta(int arg3, int arg4, int arg5, boolean arg6, boolean arg7, boolean arg8, boolean arg9) {
        return (((long)(((int)arg8)))) << 62 | (((long)(((int)arg9)))) << 0x3F | (((long)(((int)arg7)))) << 61 | (((long)(((int)arg6)))) << 60 | (((long)Math.min(arg5, 0x3FF))) << 50 | (((long)(arg4 & 0x1FFFFFF))) << 25 | (((long)(arg3 & 0x1FFFFFF)));
    }

    public static final long packXY(int arg4, int arg5) {
        return (((long)arg5)) & 0xFFFFFFFFL | (((long)arg4)) << 0x20;
    }

    public static final boolean rectIntersectsRect(long arg0, long arg2, long arg4, long arg6) {
        if(((arg6 - arg0 - 0x100000001L | arg2 - arg4 - 0x100000001L) & -9223372034707292160L) == 0) {
            return 1;
        }

        return 0;
    }

    public static final long toLong(boolean arg2) {
        return ((long)(((int)arg2)));
    }

    public static final int unpackMetaFocusable(long arg1) {
        return (((int)(arg1 >> 61))) & 1;
    }

    public static final int unpackMetaGesturable(long arg1) {
        return (((int)(arg1 >> 62))) & 1;
    }

    public static final int unpackMetaHasCallbacks(long arg1) {
        return (((int)(arg1 >> 0x3F))) & 1;
    }

    public static final int unpackMetaLastChildOffset(long arg1) {
        return (((int)(arg1 >> 50))) & 0x3FF;
    }

    public static final int unpackMetaParentId(long arg1) {
        return (((int)(arg1 >> 25))) & 0x1FFFFFF;
    }

    public static final int unpackMetaUpdated(long arg1) {
        return (((int)(arg1 >> 60))) & 1;
    }

    public static final int unpackMetaValue(long arg0) {
        return (((int)arg0)) & 0x1FFFFFF;
    }

    public static final int unpackX(long arg1) {
        return ((int)(arg1 >> 0x20));
    }

    public static final int unpackY(long arg0) {
        return ((int)arg0);
    }
}

