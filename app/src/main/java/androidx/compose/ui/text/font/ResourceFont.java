package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B9\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0019\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\u001A\u0010\u001BJA\u0010\u0019\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\b\u001A\u00020\tH\u0007¢\u0006\u0004\b\u001C\u0010\u001DJ\u0013\u0010\u001E\u001A\u00020\u001F2\b\u0010 \u001A\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001A\u00020\u0003H\u0016J\b\u0010#\u001A\u00020$H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0012\u0010\u000FR\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u001E\u0010\n\u001A\u00020\u000B8\u0016X\u0097\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u000F¨\u0006%"}, d2={"Landroidx/compose/ui/text/font/ResourceFont;", "Landroidx/compose/ui/text/font/Font;", "resId", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "loadingStrategy", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "<init>", "(ILandroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getResId", "()I", "getWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getStyle-_-LCdwA", "I", "getVariationSettings", "()Landroidx/compose/ui/text/font/FontVariation$Settings;", "getLoadingStrategy-PKNRLFQ$annotations", "()V", "getLoadingStrategy-PKNRLFQ", "copy", "copy-RetOiIg", "(ILandroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/ResourceFont;", "copy-F3nL8kk", "(ILandroidx/compose/ui/text/font/FontWeight;IILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/ResourceFont;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ResourceFont implements Font {
    public static final int $stable;
    private final int loadingStrategy;
    private final int resId;
    private final int style;
    private final Settings variationSettings;
    private final FontWeight weight;

    static {
    }

    public ResourceFont(int arg1, FontWeight arg2, int arg3, Settings arg4, int arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    public ResourceFont(int arg8, FontWeight arg9, int arg10, Settings arg11, int arg12, int arg13, DefaultConstructorMarker arg14) {
        if((arg13 & 2) != 0) {
            arg9 = FontWeight.Companion.getNormal();
        }

        FontWeight v2 = arg9;
        if((arg13 & 4) != 0) {
            arg10 = FontStyle.Companion.getNormal-_-LCdwA();
        }

        int v3 = arg10;
        if((arg13 & 8) != 0) {
            arg11 = FontVariation.INSTANCE.Settings-6EWAqTQ(v2, v3, new Setting[0]);
        }

        Settings v4 = arg11;
        if((arg13 & 16) != 0) {
            arg12 = FontLoadingStrategy.Companion.getAsync-PKNRLFQ();
        }

        this(arg8, v2, v3, v4, arg12, null);
    }

    private ResourceFont(int arg1, FontWeight arg2, int arg3, Settings arg4, int arg5) {
        super();
        this.resId = arg1;
        this.weight = arg2;
        this.style = arg3;
        this.variationSettings = arg4;
        this.loadingStrategy = arg5;
    }

    public final ResourceFont copy-F3nL8kk(int arg8, FontWeight arg9, int arg10, int arg11, Settings arg12) {
        return new ResourceFont(arg8, arg9, arg10, arg12, arg11, null);
    }

    public static ResourceFont copy-F3nL8kk$default(ResourceFont arg0, int arg1, FontWeight arg2, int arg3, int arg4, Settings arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg1 = arg0.resId;
        }

        if((arg6 & 2) != 0) {
            arg2 = arg0.getWeight();
        }

        if((arg6 & 4) != 0) {
            arg3 = arg0.getStyle-_-LCdwA();
        }

        if((arg6 & 8) != 0) {
            arg4 = arg0.getLoadingStrategy-PKNRLFQ();
        }

        if((arg6 & 16) != 0) {
            arg5 = arg0.variationSettings;
        }

        return arg0.copy-F3nL8kk(arg1, arg2, arg3, arg4, arg5);
    }

    public final ResourceFont copy-RetOiIg(int arg9, FontWeight arg10, int arg11) {
        return ResourceFont.copy-F3nL8kk$default(this, arg9, arg10, arg11, this.getLoadingStrategy-PKNRLFQ(), null, 16, null);
    }

    public static ResourceFont copy-RetOiIg$default(ResourceFont arg0, int arg1, FontWeight arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.resId;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.getWeight();
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.getStyle-_-LCdwA();
        }

        return arg0.copy-RetOiIg(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((ResourceFont)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ResourceFont)) {
            return 0;
        }

        if(this.resId != ((ResourceFont)arg5).resId) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getWeight(), ((ResourceFont)arg5).getWeight())) {
            return 0;
        }

        if(!FontStyle.equals-impl0(this.getStyle-_-LCdwA(), ((ResourceFont)arg5).getStyle-_-LCdwA())) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.variationSettings, ((ResourceFont)arg5).variationSettings)) {
            return 0;
        }

        if(!FontLoadingStrategy.equals-impl0(this.getLoadingStrategy-PKNRLFQ(), ((ResourceFont)arg5).getLoadingStrategy-PKNRLFQ())) {
            return 0;
        }

        return 1;
    }

    public int getLoadingStrategy-PKNRLFQ() {
        return this.loadingStrategy;
    }

    public static void getLoadingStrategy-PKNRLFQ$annotations() {
    }

    public final int getResId() {
        return this.resId;
    }

    public int getStyle-_-LCdwA() {
        return this.style;
    }

    public final Settings getVariationSettings() {
        return this.variationSettings;
    }

    public FontWeight getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return (((this.resId * 0x1F + this.getWeight().hashCode()) * 0x1F + FontStyle.hashCode-impl(this.getStyle-_-LCdwA())) * 0x1F + FontLoadingStrategy.hashCode-impl(this.getLoadingStrategy-PKNRLFQ())) * 0x1F + this.variationSettings.hashCode();
    }

    public String toString() {
        return "ResourceFont(resId=" + this.resId + ", weight=" + this.getWeight() + ", style=" + FontStyle.toString-impl(this.getStyle-_-LCdwA()) + ", loadingStrategy=" + FontLoadingStrategy.toString-impl(this.getLoadingStrategy-PKNRLFQ()) + ')';
    }
}

