package androidx.compose.ui.text.font;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001A=\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000BH\u0007¢\u0006\u0004\b\f\u0010\r\u001A5\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000BH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001A5\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u00132\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000BH\u0007¢\u0006\u0004\b\u0010\u0010\u0014\u001A\b\u0010\u0015\u001A\u00020\u0016H\u0002¨\u0006\u0017"}, d2={"Font", "Landroidx/compose/ui/text/font/Font;", "path", "", "assetManager", "Landroid/content/res/AssetManager;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "Font-MuC2MFs", "(Ljava/lang/String;Landroid/content/res/AssetManager;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "file", "Ljava/io/File;", "Font-Ej4NQ78", "(Ljava/io/File;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "fileDescriptor", "Landroid/os/ParcelFileDescriptor;", "(Landroid/os/ParcelFileDescriptor;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "generateAndroidFontKtForApiCompatibility", "", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidFontKt {
    public static final Font Font-Ej4NQ78(ParcelFileDescriptor arg6, FontWeight arg7, int arg8, Settings arg9) {
        return new AndroidFileDescriptorFont(arg6, arg7, arg8, arg9, null);
    }

    public static final Font Font-Ej4NQ78(File arg6, FontWeight arg7, int arg8, Settings arg9) {
        return new AndroidFileFont(arg6, arg7, arg8, arg9, null);
    }

    public static Font Font-Ej4NQ78$default(ParcelFileDescriptor arg0, FontWeight arg1, int arg2, Settings arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg1 = FontWeight.Companion.getNormal();
        }

        if((arg4 & 4) != 0) {
            arg2 = FontStyle.Companion.getNormal-_-LCdwA();
        }

        if((arg4 & 8) != 0) {
            arg3 = FontVariation.INSTANCE.Settings-6EWAqTQ(arg1, arg2, new Setting[0]);
        }

        return AndroidFontKt.Font-Ej4NQ78(arg0, arg1, arg2, arg3);
    }

    public static Font Font-Ej4NQ78$default(File arg0, FontWeight arg1, int arg2, Settings arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg1 = FontWeight.Companion.getNormal();
        }

        if((arg4 & 4) != 0) {
            arg2 = FontStyle.Companion.getNormal-_-LCdwA();
        }

        if((arg4 & 8) != 0) {
            arg3 = FontVariation.INSTANCE.Settings-6EWAqTQ(arg1, arg2, new Setting[0]);
        }

        return AndroidFontKt.Font-Ej4NQ78(arg0, arg1, arg2, arg3);
    }

    public static final Font Font-MuC2MFs(String arg7, AssetManager arg8, FontWeight arg9, int arg10, Settings arg11) {
        return new AndroidAssetFont(arg8, arg7, arg9, arg10, arg11, null);
    }

    public static Font Font-MuC2MFs$default(String arg0, AssetManager arg1, FontWeight arg2, int arg3, Settings arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg2 = FontWeight.Companion.getNormal();
        }

        if((arg5 & 8) != 0) {
            arg3 = FontStyle.Companion.getNormal-_-LCdwA();
        }

        if((arg5 & 16) != 0) {
            arg4 = FontVariation.INSTANCE.Settings-6EWAqTQ(arg2, arg3, new Setting[0]);
        }

        return AndroidFontKt.Font-MuC2MFs(arg0, arg1, arg2, arg3, arg4);
    }

    private static final void generateAndroidFontKtForApiCompatibility() {
    }
}

