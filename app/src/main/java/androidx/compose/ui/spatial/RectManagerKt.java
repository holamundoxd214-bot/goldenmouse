package androidx.compose.ui.spatial;

import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000B\u001A\u0013\u0010\u0005\u001A\u00020\u0006*\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t\u001A\r\u0010\u0011\u001A\u00020\u0006*\u00020\u0001H\u0080\b\"\u0018\u0010\u0000\u001A\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004\"\u001F\u0010\n\u001A\u00020\u0001*\u00020\u00068Â\u0002X\u0082\u0004¢\u0006\f\u0012\u0004\b\u000B\u0010\f\u001A\u0004\b\n\u0010\r\"\u001F\u0010\u000E\u001A\u00020\u0001*\u00020\u00068Â\u0002X\u0082\u0004¢\u0006\f\u0012\u0004\b\u000F\u0010\f\u001A\u0004\b\u0010\u0010\r¨\u0006\u0012"}, d2={"isSet", "", "Landroidx/compose/ui/unit/IntOffset;", "isSet--gyyYBs", "(J)Z", "analyzeComponents", "", "Landroidx/compose/ui/graphics/Matrix;", "analyzeComponents-58bKbWc", "([F)I", "isIdentity", "isIdentity$annotations", "(I)V", "(I)Z", "hasNonTranslationComponents", "getHasNonTranslationComponents$annotations", "getHasNonTranslationComponents", "toInt", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RectManagerKt {
    public static final int access$analyzeComponents-58bKbWc(float[] arg0) {
        return RectManagerKt.analyzeComponents-58bKbWc(arg0);
    }

    public static final boolean access$isSet--gyyYBs(long arg0) {
        return RectManagerKt.isSet--gyyYBs(arg0);
    }

    private static final int analyzeComponents-58bKbWc(float[] arg6) {
        int v2 = 0;
        if(arg6.length < 16) {
            return 0;
        }

        float v1 = 1f;
        int v0 = Float.compare(arg6[0], v1) != 0 || arg6[1] != 0f || arg6[2] != 0f || arg6[4] != 0f || arg6[5] != v1 || arg6[6] != 0f || arg6[8] != 0f || arg6[9] != 0f || arg6[10] != v1 ? 0 : 1;
        if(arg6[12] == 0f && arg6[13] == 0f && arg6[14] == 0f && arg6[15] == v1) {
            v2 = 1;
        }

        return v0 << 1 | v2;
    }

    private static final boolean getHasNonTranslationComponents(int arg0) {
        if((arg0 & 2) == 0) {
            return 1;
        }

        return 0;
    }

    private static void getHasNonTranslationComponents$annotations(int arg0) {
    }

    private static final boolean isIdentity(int arg1) {
        if(arg1 == 3) {
            return 1;
        }

        return 0;
    }

    private static void isIdentity$annotations(int arg0) {
    }

    private static final boolean isSet--gyyYBs(long arg2) {
        return IntOffset.equals-impl0(arg2, IntOffset.Companion.getMax-nOcc-ac()) ^ 1;
    }

    public static final int toInt(boolean arg0) {
        return arg0;
    }
}

