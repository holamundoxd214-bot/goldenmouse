package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\'\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J9\u0010\u0011\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00072\u0006\u0010\u0015\u001A\u00020\t2\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0019H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ)\u0010\u001C\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00072\u0006\u0010\u0015\u001A\u00020\tH\u0002¢\u0006\u0004\b\u001D\u0010\u001EJ/\u0010\u001F\u001A\u00020\u00052\n\b\u0002\u0010 \u001A\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tH\u0002¢\u0006\u0004\b!\u0010\u001E¨\u0006\""}, d2={"Landroidx/compose/ui/text/font/PlatformTypefacesApi;", "Landroidx/compose/ui/text/font/PlatformTypefaces;", "<init>", "()V", "createDefault", "Landroid/graphics/Typeface;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "createDefault-FO1MlWM", "(Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "createNamed", "name", "Landroidx/compose/ui/text/font/GenericFontFamily;", "createNamed-RetOiIg", "(Landroidx/compose/ui/text/font/GenericFontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "optionalOnDeviceFontFamilyByName", "familyName", "", "weight", "style", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "context", "Landroid/content/Context;", "optionalOnDeviceFontFamilyByName-78DK7lM", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Landroid/content/Context;)Landroid/graphics/Typeface;", "loadNamedFromTypefaceCacheOrNull", "loadNamedFromTypefaceCacheOrNull-RetOiIg", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "createAndroidTypefaceUsingTypefaceStyle", "genericFontFamily", "createAndroidTypefaceUsingTypefaceStyle-RetOiIg", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class PlatformTypefacesApi implements PlatformTypefaces {
    public PlatformTypefacesApi() {
        super();
    }

    private final Typeface createAndroidTypefaceUsingTypefaceStyle-RetOiIg(String arg1, FontWeight arg2, int arg3) {
        if((FontStyle.equals-impl0(arg3, FontStyle.Companion.getNormal-_-LCdwA())) && (Intrinsics.areEqual(arg2, FontWeight.Companion.getNormal()))) {
            String v0 = arg1;
            if(v0 != null && ((CharSequence)v0).length() != 0) {
                goto label_14;
            }

            return Typeface.DEFAULT;
        }

    label_14:
        int v0_1 = AndroidFontUtils_androidKt.getAndroidTypefaceStyle-FO1MlWM(arg2, arg3);
        String v2 = arg1;
        if(v2 != null) {
            if(((CharSequence)v2).length() == 0) {
            }
            else {
                return Typeface.create(arg1, v0_1);
            }
        }

        return Typeface.defaultFromStyle(v0_1);
    }

    static Typeface createAndroidTypefaceUsingTypefaceStyle-RetOiIg$default(PlatformTypefacesApi arg0, String arg1, FontWeight arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = null;
        }

        if((arg4 & 2) != 0) {
            arg2 = FontWeight.Companion.getNormal();
        }

        if((arg4 & 4) != 0) {
            arg3 = FontStyle.Companion.getNormal-_-LCdwA();
        }

        return arg0.createAndroidTypefaceUsingTypefaceStyle-RetOiIg(arg1, arg2, arg3);
    }

    public Typeface createDefault-FO1MlWM(FontWeight arg2, int arg3) {
        return this.createAndroidTypefaceUsingTypefaceStyle-RetOiIg(null, arg2, arg3);
    }

    public Typeface createNamed-RetOiIg(GenericFontFamily arg2, FontWeight arg3, int arg4) {
        Typeface v0 = this.loadNamedFromTypefaceCacheOrNull-RetOiIg(PlatformTypefaces_androidKt.getWeightSuffixForFallbackFamilyName(arg2.getName(), arg3), arg3, arg4);
        if(v0 == null) {
            return this.createAndroidTypefaceUsingTypefaceStyle-RetOiIg(arg2.getName(), arg3, arg4);
        }

        return v0;
    }

    private final Typeface loadNamedFromTypefaceCacheOrNull-RetOiIg(String arg4, FontWeight arg5, int arg6) {
        Typeface v1 = null;
        if(arg4.length() == 0) {
            return v1;
        }

        Typeface v4 = this.createAndroidTypefaceUsingTypefaceStyle-RetOiIg(arg4, arg5, arg6);
        if(!Intrinsics.areEqual(v4, Typeface.create(Typeface.DEFAULT, AndroidFontUtils_androidKt.getAndroidTypefaceStyle-FO1MlWM(arg5, arg6))) && !Intrinsics.areEqual(v4, this.createAndroidTypefaceUsingTypefaceStyle-RetOiIg(((String)v1), arg5, arg6))) {
            return v4;
        }

        return v1;
    }

    public Typeface optionalOnDeviceFontFamilyByName-78DK7lM(String arg2, FontWeight arg3, int arg4, Settings arg5, Context arg6) {
        Typeface v1;
        if(Intrinsics.areEqual(arg2, FontFamily.Companion.getSansSerif().getName())) {
            v1 = this.createNamed-RetOiIg(FontFamily.Companion.getSansSerif(), arg3, arg4);
        }
        else if(Intrinsics.areEqual(arg2, FontFamily.Companion.getSerif().getName())) {
            v1 = this.createNamed-RetOiIg(FontFamily.Companion.getSerif(), arg3, arg4);
        }
        else if(Intrinsics.areEqual(arg2, FontFamily.Companion.getMonospace().getName())) {
            v1 = this.createNamed-RetOiIg(FontFamily.Companion.getMonospace(), arg3, arg4);
        }
        else if(Intrinsics.areEqual(arg2, FontFamily.Companion.getCursive().getName())) {
            v1 = this.createNamed-RetOiIg(FontFamily.Companion.getCursive(), arg3, arg4);
        }
        else {
            v1 = this.loadNamedFromTypefaceCacheOrNull-RetOiIg(arg2, arg3, arg4);
        }

        return PlatformTypefaces_androidKt.setFontVariationSettings(v1, arg5, arg6);
    }
}

