package androidx.compose.ui.text.android;

import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\tJ\u000E\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\tJ\u000E\u0010\u000F\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\tJ\u000E\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\tJ(\u0010\u0011\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Landroidx/compose/ui/text/android/HorizontalPositionCache;", "", "layout", "Landroidx/compose/ui/text/android/TextLayout;", "<init>", "(Landroidx/compose/ui/text/android/TextLayout;)V", "getLayout", "()Landroidx/compose/ui/text/android/TextLayout;", "cachedKey", "", "cachedValue", "", "getPrimaryDownstream", "offset", "getPrimaryUpstream", "getSecondaryDownstream", "getSecondaryUpstream", "get", "upstream", "", "cache", "primary", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class HorizontalPositionCache {
    private int cachedKey;
    private float cachedValue;
    private final TextLayout layout;

    public HorizontalPositionCache(TextLayout arg1) {
        super();
        this.layout = arg1;
        this.cachedKey = -1;
    }

    private final float get(int arg6, boolean arg7, boolean arg8, boolean arg9) {
        int v3;
        int v2;
        int v0 = 1;
        if(arg7) {
            v2 = LayoutCompat_androidKt.getLineForOffset(this.layout.getLayout(), arg6, arg7);
            v3 = this.layout.getLineStart(v2);
            v2 = this.layout.getLineEnd(v2);
            if(arg6 != v3 && arg6 != v2) {
                goto label_14;
            }

            v2 = 1;
        }
        else {
        label_14:
            v2 = 0;
        }

        v3 = arg6 * 4;
        if(arg9) {
            if(v2 != 0) {
                v0 = 0;
            }
        }
        else if(v2 != 0) {
            v0 = 2;
        }
        else {
            v0 = 3;
        }

        v3 += v0;
        if(this.cachedKey == v3) {
            return this.cachedValue;
        }

        TextLayout v0_1 = this.layout;
        float v6 = arg9 ? v0_1.getPrimaryHorizontal(arg6, arg7) : v0_1.getSecondaryHorizontal(arg6, arg7);
        if(arg8) {
            this.cachedKey = v3;
            this.cachedValue = v6;
        }

        return v6;
    }

    public final TextLayout getLayout() {
        return this.layout;
    }

    public final float getPrimaryDownstream(int arg3) {
        return this.get(arg3, false, false, true);
    }

    public final float getPrimaryUpstream(int arg2) {
        return this.get(arg2, true, true, true);
    }

    public final float getSecondaryDownstream(int arg2) {
        return this.get(arg2, false, false, false);
    }

    public final float getSecondaryUpstream(int arg3) {
        return this.get(arg3, true, true, false);
    }
}

