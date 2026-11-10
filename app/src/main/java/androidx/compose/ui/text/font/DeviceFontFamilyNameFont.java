package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001A\u00020\u0015J\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001A\u001A\u00020\u001BH\u0016J\b\u0010\u001C\u001A\u00020\u001DH\u0016R\u0010\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0016\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0011\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001E"}, d2={"Landroidx/compose/ui/text/font/DeviceFontFamilyNameFont;", "Landroidx/compose/ui/text/font/AndroidFont;", "familyName", "Landroidx/compose/ui/text/font/DeviceFontFamilyName;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Ljava/lang/String;", "getWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getStyle-_-LCdwA", "()I", "I", "loadCached", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class DeviceFontFamilyNameFont extends AndroidFont {
    private final String familyName;
    private final int style;
    private final FontWeight weight;

    private DeviceFontFamilyNameFont(String arg4, FontWeight arg5, int arg6, Settings arg7) {
        super(FontLoadingStrategy.Companion.getOptionalLocal-PKNRLFQ(), NamedFontLoader.INSTANCE, arg7, null);
        this.familyName = arg4;
        this.weight = arg5;
        this.style = arg6;
    }

    public DeviceFontFamilyNameFont(String arg1, FontWeight arg2, int arg3, Settings arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    public boolean equals(Object arg5) {
        if(this == (((DeviceFontFamilyNameFont)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof DeviceFontFamilyNameFont)) {
            return 0;
        }

        if(!DeviceFontFamilyName.equals-impl0(this.familyName, ((DeviceFontFamilyNameFont)arg5).familyName)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getWeight(), ((DeviceFontFamilyNameFont)arg5).getWeight())) {
            return 0;
        }

        if(!FontStyle.equals-impl0(this.getStyle-_-LCdwA(), ((DeviceFontFamilyNameFont)arg5).getStyle-_-LCdwA())) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getVariationSettings(), ((DeviceFontFamilyNameFont)arg5).getVariationSettings())) {
            return 0;
        }

        return 1;
    }

    public int getStyle-_-LCdwA() {
        return this.style;
    }

    public FontWeight getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return ((DeviceFontFamilyName.hashCode-impl(this.familyName) * 0x1F + this.getWeight().hashCode()) * 0x1F + FontStyle.hashCode-impl(this.getStyle-_-LCdwA())) * 0x1F + this.getVariationSettings().hashCode();
    }

    public final Typeface loadCached(Context arg7) {
        return PlatformTypefaces_androidKt.PlatformTypefaces().optionalOnDeviceFontFamilyByName-78DK7lM(this.familyName, this.getWeight(), this.getStyle-_-LCdwA(), this.getVariationSettings(), arg7);
    }

    public String toString() {
        return "Font(familyName=\"" + DeviceFontFamilyName.toString-impl(this.familyName) + "\", weight=" + this.getWeight() + ", style=" + FontStyle.toString-impl(this.getStyle-_-LCdwA()) + ')';
    }
}

