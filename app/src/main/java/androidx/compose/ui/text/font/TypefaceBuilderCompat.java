package androidx.compose.ui.text.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface$Builder;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.ParcelFileDescriptor;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\rH\u0007J$\u0010\u000E\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\rH\u0007J$\u0010\u0011\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001A\u00020\u00132\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\rH\u0007J!\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00160\u0015*\u00020\r2\b\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0003¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2={"Landroidx/compose/ui/text/font/TypefaceBuilderCompat;", "", "<init>", "()V", "createFromAssets", "Landroid/graphics/Typeface;", "assetManager", "Landroid/content/res/AssetManager;", "path", "", "context", "Landroid/content/Context;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "createFromFile", "file", "Ljava/io/File;", "createFromFileDescriptor", "fileDescriptor", "Landroid/os/ParcelFileDescriptor;", "toVariationSettings", "", "Landroid/graphics/fonts/FontVariationAxis;", "(Landroidx/compose/ui/text/font/FontVariation$Settings;Landroid/content/Context;)[Landroid/graphics/fonts/FontVariationAxis;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class TypefaceBuilderCompat {
    public static final TypefaceBuilderCompat INSTANCE;

    static {
        TypefaceBuilderCompat.INSTANCE = new TypefaceBuilderCompat();
    }

    private TypefaceBuilderCompat() {
        super();
    }

    public final Typeface createFromAssets(AssetManager arg2, String arg3, Context arg4, Settings arg5) {
        if(arg4 == null) {
            return null;
        }

        return new Typeface$Builder(arg2, arg3).setFontVariationSettings(this.toVariationSettings(arg5, arg4)).build();
    }

    public final Typeface createFromFile(File arg2, Context arg3, Settings arg4) {
        if(arg3 == null) {
            return null;
        }

        return new Typeface$Builder(arg2).setFontVariationSettings(this.toVariationSettings(arg4, arg3)).build();
    }

    public final Typeface createFromFileDescriptor(ParcelFileDescriptor arg2, Context arg3, Settings arg4) {
        if(arg3 == null) {
            return null;
        }

        return new Typeface$Builder(arg2.getFileDescriptor()).setFontVariationSettings(this.toVariationSettings(arg4, arg3)).build();
    }

    private final FontVariationAxis[] toVariationSettings(Settings arg1, Context arg2) {
        Density v0;
        if(arg2 != null) {
            v0 = AndroidDensity_androidKt.Density(arg2);
        }
        else if(!arg1.getNeedsDensity$ui_text()) {
            v0 = DensityKt.Density(1f, 1f);
        }
        else {
            goto label_10;
        }

        return PlatformFontVariationSettings_androidKt.toAndroidArray(arg1, v0, PlatformFontVariationSettings_androidKt.getFontWeightAdjustment(arg2));
    label_10:
        throw new IllegalStateException("Required density, but not provided");
    }
}

