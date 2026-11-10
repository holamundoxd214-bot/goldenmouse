package androidx.compose.runtime.composer.linkbuffer;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u0007\u001A\u0015\u0010\u000E\u001A\u00020\u00012\n\u0010\u000F\u001A\u00060\u0001j\u0002`\u0003H\u0080\b\u001A\u0015\u0010\u0010\u001A\u00020\u00012\n\u0010\u000F\u001A\u00060\u0001j\u0002`\u0003H\u0080\b\u001A!\u0010\u0010\u001A\u00060\u0001j\u0002`\u00032\n\u0010\u000F\u001A\u00060\u0001j\u0002`\u00032\u0006\u0010\u0011\u001A\u00020\u0001H\u0080\b\u001A\u0015\u0010\u0012\u001A\u00020\u00132\n\u0010\u000F\u001A\u00060\u0001j\u0002`\u0003H\u0080\b\u001A\u0018\u0010\u0014\u001A\u00060\u0001j\u0002`\u00032\n\u0010\u000F\u001A\u00060\u0001j\u0002`\u0003H\u0000\u001A\u0015\u0010\u0015\u001A\u00020\u00012\n\u0010\u000F\u001A\u00060\u0001j\u0002`\u0003H\u0080\b\u001A\u0015\u0010\u0016\u001A\u00020\u00012\n\u0010\u000F\u001A\u00060\u0001j\u0002`\u0003H\u0080\b\u001A\u0015\u0010\u0017\u001A\u00020\u00012\n\u0010\u000F\u001A\u00060\u0001j\u0002`\u0003H\u0080\b\u001A\u0014\u0010\u0019\u001A\u00020\u00012\n\u0010\u000F\u001A\u00060\u0001j\u0002`\u0003H\u0000\"\u0012\u0010\u0002\u001A\u00060\u0001j\u0002`\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0004\u001A\u00060\u0001j\u0002`\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0005\u001A\u00060\u0001j\u0002`\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0006\u001A\u00060\u0001j\u0002`\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0007\u001A\u00060\u0001j\u0002`\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0012\u0010\b\u001A\u00060\u0001j\u0002`\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0012\u0010\t\u001A\u00060\u0001j\u0002`\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0012\u0010\n\u001A\u00060\u0001j\u0002`\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0012\u0010\u000B\u001A\u00060\u0001j\u0002`\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\f\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\r\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0018\u001A\u00060\u0001j\u0002`\u0003X\u0080T¢\u0006\u0002\n\u0000*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u001A"}, d2={"GroupFlags", "", "IsNodeFlag", "Landroidx/compose/runtime/composer/linkbuffer/GroupFlags;", "HasObjectKeyFlag", "HasAuxSlotFlag", "IsRecompositionRequiredFlag", "HasRecompositionRequiredFlag", "IsMovableContentFlag", "HasMovableContentFlag", "IsSubcompositionContextFlag", "HasSubcompositionContextFlag", "HasMarkFlags", "IsMarkFlags", "groupFlagsNodeCount", "flags", "groupFlagsChildNodeCount", "count", "groupFlagsIsMarkedDeleted", "", "propagatingFlagsOf", "auxSlotIndex", "objectKeySlotIndex", "nodeSlotIndex", "UtilitySlotsMask", "utilitySlotsCountForFlags", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class GroupFlagsKt {
    public static final int HasAuxSlotFlag = 0x2000000;
    public static final int HasMarkFlags = 0xA8000000;
    public static final int HasMovableContentFlag = 0x20000000;
    public static final int HasObjectKeyFlag = 0x1000000;
    public static final int HasRecompositionRequiredFlag = 0x8000000;
    public static final int HasSubcompositionContextFlag = 0x80000000;
    public static final int IsMarkFlags = 0x54000000;
    public static final int IsMovableContentFlag = 0x10000000;
    public static final int IsNodeFlag = 0x800000;
    public static final int IsRecompositionRequiredFlag = 0x4000000;
    public static final int IsSubcompositionContextFlag = 0x40000000;
    public static final int UtilitySlotsMask = 0x3800000;

    public static final int auxSlotIndex(int arg1) {
        return Integer.bitCount(arg1 & 0x1800000);
    }

    public static final int groupFlagsChildNodeCount(int arg1) {
        return arg1 & 0x7FFFFF;
    }

    public static final int groupFlagsChildNodeCount(int arg1, int arg2) {
        return arg1 & 0xFF800000 | arg2;
    }

    public static final boolean groupFlagsIsMarkedDeleted(int arg1) {
        if((arg1 & 0x7FFFFF) == 0x7FFFFF) {
            return 1;
        }

        return 0;
    }

    public static final int groupFlagsNodeCount(int arg2) {
        if((arg2 & 0x800000) == 0x800000) {
            return 1;
        }

        return arg2 & 0x7FFFFF;
    }

    public static final int nodeSlotIndex(int arg0) {
        return 0;
    }

    public static final int objectKeySlotIndex(int arg1) {
        return Integer.bitCount(arg1 & 0x800000);
    }

    public static final int propagatingFlagsOf(int arg2) {
        return (arg2 & 0x54000000) << 1 | 0xA8000000 & arg2;
    }

    public static final int utilitySlotsCountForFlags(int arg1) {
        return Integer.bitCount(arg1 & 0x3800000);
    }
}

