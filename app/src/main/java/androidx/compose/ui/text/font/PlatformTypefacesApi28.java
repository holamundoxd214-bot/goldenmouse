package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\'\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u0013\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ)\u0010\u001C\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\u001D\u0010\u001EJ+\u0010\u001F\u001A\u00020\u00052\n\b\u0002\u0010 \u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\u000BH\u0002¢\u0006\u0004\b!\u0010\u001E¨\u0006\""}, d2={"Landroidx/compose/ui/text/font/PlatformTypefacesApi28;", "Landroidx/compose/ui/text/font/PlatformTypefaces;", "<init>", "()V", "optionalOnDeviceFontFamilyByName", "Landroid/graphics/Typeface;", "familyName", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "context", "Landroid/content/Context;", "optionalOnDeviceFontFamilyByName-78DK7lM", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Landroid/content/Context;)Landroid/graphics/Typeface;", "createDefault", "fontWeight", "fontStyle", "createDefault-FO1MlWM", "(Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "createNamed", "name", "Landroidx/compose/ui/text/font/GenericFontFamily;", "createNamed-RetOiIg", "(Landroidx/compose/ui/text/font/GenericFontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "loadNamedFromTypefaceCacheOrNull", "loadNamedFromTypefaceCacheOrNull-RetOiIg", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "createAndroidTypefaceApi28", "genericFontFamily", "createAndroidTypefaceApi28-RetOiIg", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class PlatformTypefacesApi28 implements PlatformTypefaces {
    public PlatformTypefacesApi28() {
        super();
    }

    private final Typeface createAndroidTypefaceApi28-RetOiIg(String arg1, FontWeight arg2, int arg3) {
        if((FontStyle.equals-impl0(arg3, FontStyle.Companion.getNormal-_-LCdwA())) && (Intrinsics.areEqual(arg2, FontWeight.Companion.getNormal()))) {
            String v0 = arg1;
            if(v0 != null && ((CharSequence)v0).length() != 0) {
                goto label_14;
            }

            return Typeface.DEFAULT;
        }

    label_14:
        Typeface v0_1 = arg1 == null ? Typeface.DEFAULT : Typeface.create(arg1, 0);
        return Typeface.create(v0_1, arg2.getWeight(), FontStyle.equals-impl0(arg3, FontStyle.Companion.getItalic-_-LCdwA()));
    }

    static Typeface createAndroidTypefaceApi28-RetOiIg$default(PlatformTypefacesApi28 arg0, String arg1, FontWeight arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = null;
        }

        return arg0.createAndroidTypefaceApi28-RetOiIg(arg1, arg2, arg3);
    }

    public Typeface createDefault-FO1MlWM(FontWeight arg2, int arg3) {
        return this.createAndroidTypefaceApi28-RetOiIg(null, arg2, arg3);
    }

    public Typeface createNamed-RetOiIg(GenericFontFamily arg1, FontWeight arg2, int arg3) {
        return this.createAndroidTypefaceApi28-RetOiIg(arg1.getName(), arg2, arg3);
    }

    private final Typeface loadNamedFromTypefaceCacheOrNull-RetOiIg(String arg6, FontWeight arg7, int arg8) {
        Typeface v1 = null;
        if(arg6.length() == 0) {
            return v1;
        }

        Typeface v6 = this.createAndroidTypefaceApi28-RetOiIg(arg6, arg7, arg8);
        if(!Intrinsics.areEqual(v6, TypefaceHelperMethodsApi28.INSTANCE.create(Typeface.DEFAULT, arg7.getWeight(), FontStyle.equals-impl0(arg8, FontStyle.Companion.getItalic-_-LCdwA()))) && !Intrinsics.areEqual(v6, this.createAndroidTypefaceApi28-RetOiIg(((String)v1), arg7, arg8))) {
            return v6;
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

