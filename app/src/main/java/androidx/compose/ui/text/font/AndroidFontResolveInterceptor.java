package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007H\u0016J\t\u0010\t\u001A\u00020\u0003HÂ\u0003J\u0013\u0010\n\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EHÖ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Landroidx/compose/ui/text/font/AndroidFontResolveInterceptor;", "Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "fontWeightAdjustment", "", "<init>", "(I)V", "interceptFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontWeight", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidFontResolveInterceptor implements PlatformResolveInterceptor {
    public static final int $stable;
    private final int fontWeightAdjustment;

    static {
    }

    public AndroidFontResolveInterceptor(int arg1) {
        super();
        this.fontWeightAdjustment = arg1;
    }

    private final int component1() {
        return this.fontWeightAdjustment;
    }

    public final AndroidFontResolveInterceptor copy(int arg1) {
        return new AndroidFontResolveInterceptor(arg1);
    }

    public static AndroidFontResolveInterceptor copy$default(AndroidFontResolveInterceptor arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.fontWeightAdjustment;
        }

        return arg0.copy(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((AndroidFontResolveInterceptor)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof AndroidFontResolveInterceptor)) {
            return 0;
        }

        if(this.fontWeightAdjustment != ((AndroidFontResolveInterceptor)arg4).fontWeightAdjustment) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return Integer.hashCode(this.fontWeightAdjustment);
    }

    public FontWeight interceptFontWeight(FontWeight arg3) {
        int v0 = this.fontWeightAdjustment;
        if(v0 != 0) {
            if(v0 == 0x7FFFFFFF) {
            }
            else {
                arg3 = new FontWeight(RangesKt.coerceIn(arg3.getWeight() + this.fontWeightAdjustment, 1, 1000));
            }
        }

        return arg3;
    }

    public String toString() {
        return "AndroidFontResolveInterceptor(fontWeightAdjustment=" + this.fontWeightAdjustment + ')';
    }
}

