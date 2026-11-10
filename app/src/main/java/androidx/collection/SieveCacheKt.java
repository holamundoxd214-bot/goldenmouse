package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u0015\n\u0002\b\u0006\u001A\u0011\u0010\"\u001A\u00020\u00012\u0006\u0010#\u001A\u00020\u0001H\u0080\b\u001A\u0019\u0010$\u001A\u00020\u00012\u0006\u0010%\u001A\u00020\u00012\u0006\u0010\u0014\u001A\u00020\bH\u0080\b\u001A\u0011\u0010&\u001A\u00020\u00012\u0006\u0010\'\u001A\u00020\bH\u0080\b\u001A)\u0010(\u001A\u00020\u00012\u0006\u0010#\u001A\u00020\u00012\u0006\u0010)\u001A\u00020\b2\u0006\u0010\'\u001A\u00020\b2\u0006\u0010%\u001A\u00020*H\u0080\b\u001A)\u0010(\u001A\u00020\u00012\u0006\u0010#\u001A\u00020\u00012\u0006\u0010)\u001A\u00020\b2\u0006\u0010\'\u001A\u00020\b2\u0006\u0010%\u001A\u00020\u0003H\u0080\b\u001A\u0019\u0010+\u001A\u00020\u00012\u0006\u0010\u001E\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\bH\u0080\b\u001A\u0019\u0010,\u001A\u00020\u00012\u0006\u0010%\u001A\u00020\u00012\u0006\u0010\u001E\u001A\u00020\bH\u0080\b\u001A\u0011\u0010-\u001A\u00020\u00012\u0006\u0010%\u001A\u00020\u0001H\u0080\b\u001A\u0019\u0010.\u001A\u00020\u00012\u0006\u0010#\u001A\u00020\u00012\u0006\u0010\'\u001A\u00020\bH\u0080\b\u001A\u0019\u0010/\u001A\u00020\u00012\u0006\u0010#\u001A\u00020\u00012\u0006\u0010)\u001A\u00020\bH\u0080\b\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u0005\"\u000E\u0010\u0006\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0007\u001A\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\t\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\n\u001A\u00020\b8\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u000B\u0010\f\"\u0016\u0010\r\u001A\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u000E\u0010\f\"\u000E\u0010\u000F\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0010\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0011\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0012\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0013\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0014\u001A\u00020\b*\u00020\u00018À\u0002X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016\"\u001F\u0010\u0017\u001A\u00020\b*\u00020\u00018À\u0002X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\u0016\"\u001F\u0010\u001B\u001A\u00020\b*\u00020\u00018À\u0002X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001C\u0010\u0019\u001A\u0004\b\u001D\u0010\u0016\"\u0019\u0010\u001E\u001A\u00020\b*\u00020\u00018À\u0002X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u0016\"\u0019\u0010 \u001A\u00020\b*\u00020\u00018À\u0002X\u0080\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u0016¨\u00060"}, d2={"EmptyNode", "", "EmptyNodes", "", "getEmptyNodes", "()[J", "InvalidMapping", "InvalidMappingLink", "", "MaxSize", "NodeInvalidLink", "getNodeInvalidLink$annotations", "()V", "NodeLinkMask", "getNodeLinkMask$annotations", "NodeLinksMask", "NodeMetaAndNextMask", "NodeMetaAndPreviousMask", "NodeMetaMask", "NodeVisitedBit", "dst", "getDst", "(J)I", "nextNode", "getNextNode$annotations", "(J)V", "getNextNode", "previousNode", "getPreviousNode$annotations", "getPreviousNode", "src", "getSrc", "visited", "getVisited", "clearVisitedBit", "node", "createDstMapping", "mapping", "createLinkToNext", "next", "createLinks", "previous", "", "createMapping", "createSrcMapping", "eraseSrcMapping", "setLinkToNext", "setLinkToPrevious", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class SieveCacheKt {
    public static final long EmptyNode = 0x3FFFFFFFFFFFFFFFL;
    private static final long[] EmptyNodes = null;
    public static final long InvalidMapping = 0x7FFFFFFF7FFFFFFFL;
    public static final int InvalidMappingLink = 0x7FFFFFFF;
    private static final long MaxSize = 0x7FFFFFFE;
    public static final int NodeInvalidLink = 0x7FFFFFFF;
    public static final long NodeLinkMask = 0x7FFFFFFF;
    public static final long NodeLinksMask = 0x3FFFFFFFFFFFFFFFL;
    public static final long NodeMetaAndNextMask = -4611686016279904257L;
    public static final long NodeMetaAndPreviousMask = -2147483648;
    public static final long NodeMetaMask = -4611686018427387904L;
    public static final long NodeVisitedBit = 0x4000000000000000L;

    static {
        SieveCacheKt.EmptyNodes = new long[0];
    }

    public static final long clearVisitedBit(long arg2) {
        return arg2 & 0x3FFFFFFFFFFFFFFFL;
    }

    public static final long createDstMapping(long arg2, int arg4) {
        return arg2 & -4294967296L | (((long)arg4));
    }

    public static final long createLinkToNext(int arg4) {
        return (((long)arg4)) & 0x7FFFFFFF | 0x3FFFFFFF80000000L;
    }

    public static final long createLinks(long arg3, int arg5, int arg6, int[] arg7) {
        Intrinsics.checkNotNullParameter(arg7, "mapping");
        arg3 &= -4611686018427387904L;
        int v0 = 0x7FFFFFFF;
        arg5 = arg5 == v0 ? v0 : arg7[arg5];
        arg3 = (arg3 | (((long)arg5))) << 0x1F;
        if(arg6 == v0) {
        }
        else {
            v0 = arg7[arg6];
        }

        return arg3 | (((long)v0));
    }

    public static final long createLinks(long arg5, int arg7, int arg8, long[] arg9) {
        Intrinsics.checkNotNullParameter(arg9, "mapping");
        arg5 &= -4611686018427387904L;
        long v0 = 0xFFFFFFFFL;
        int v2 = 0x7FFFFFFF;
        arg7 = arg7 == v2 ? v2 : ((int)(arg9[arg7] & v0));
        arg5 = (arg5 | (((long)arg7))) << 0x1F;
        if(arg8 == v2) {
        }
        else {
            v2 = ((int)(arg9[arg8] & v0));
        }

        return arg5 | (((long)v2));
    }

    public static final long createMapping(int arg2, int arg3) {
        return (((long)arg3)) | (((long)arg2)) << 0x20;
    }

    public static final long createSrcMapping(long arg4, int arg6) {
        return arg4 & 0xFFFFFFFFL | (((long)arg6)) << 0x20;
    }

    public static final long eraseSrcMapping(long arg2) {
        return arg2 & 0xFFFFFFFFL | -4294967296L;
    }

    public static final int getDst(long arg2) {
        return ((int)(arg2 & 0xFFFFFFFFL));
    }

    public static final long[] getEmptyNodes() {
        return SieveCacheKt.EmptyNodes;
    }

    public static final int getNextNode(long arg2) {
        return ((int)(arg2 & 0x7FFFFFFF));
    }

    public static void getNextNode$annotations(long arg0) {
    }

    public static void getNodeInvalidLink$annotations() {
    }

    public static void getNodeLinkMask$annotations() {
    }

    public static final int getPreviousNode(long arg2) {
        return ((int)(arg2 >> 0x1F & 0x7FFFFFFF));
    }

    public static void getPreviousNode$annotations(long arg0) {
    }

    public static final int getSrc(long arg2) {
        return ((int)(arg2 >> 0x20 & 0xFFFFFFFFL));
    }

    public static final int getVisited(long arg2) {
        return ((int)(arg2 >> 62 & 1));
    }

    public static final long setLinkToNext(long arg4, int arg6) {
        return arg4 & -2147483648 | (((long)arg6)) & 0x7FFFFFFF;
    }

    public static final long setLinkToPrevious(long arg4, int arg6) {
        return arg4 & -4611686016279904257L | ((((long)arg6)) & 0x7FFFFFFF) << 0x1F;
    }
}

