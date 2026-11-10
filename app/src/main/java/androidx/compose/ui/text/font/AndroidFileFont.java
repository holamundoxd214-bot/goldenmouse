package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u0019\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0010¢\u0006\u0002\b\u0012J\b\u0010\u0017\u001A\u00020\u0014H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0016\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2={"Landroidx/compose/ui/text/font/AndroidFileFont;", "Landroidx/compose/ui/text/font/AndroidPreloadedFont;", "file", "Ljava/io/File;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "<init>", "(Ljava/io/File;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFile", "()Ljava/io/File;", "doLoad", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "doLoad$ui_text", "cacheKey", "", "getCacheKey", "()Ljava/lang/String;", "toString", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidFileFont extends AndroidPreloadedFont {
    public static final int $stable;
    private final String cacheKey;
    private final File file;

    static {
    }

    private AndroidFileFont(File arg2, FontWeight arg3, int arg4, Settings arg5) {
        super(arg3, arg4, arg5, null);
        this.file = arg2;
        this.setTypeface$ui_text(this.doLoad$ui_text(null));
    }

    public AndroidFileFont(File arg7, FontWeight arg8, int arg9, Settings arg10, int arg11, DefaultConstructorMarker arg12) {
        if((arg11 & 2) != 0) {
            arg8 = FontWeight.Companion.getNormal();
        }

        FontWeight v2 = arg8;
        if((arg11 & 4) != 0) {
            arg9 = FontStyle.Companion.getNormal-_-LCdwA();
        }

        this(arg7, v2, arg9, arg10, null);
    }

    public AndroidFileFont(File arg1, FontWeight arg2, int arg3, Settings arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    public Typeface doLoad$ui_text(Context arg3) {
        return TypefaceBuilderCompat.INSTANCE.createFromFile(this.file, arg3, this.getVariationSettings());
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public final File getFile() {
        return this.file;
    }

    public String toString() {
        return "Font(file=" + this.file + ", weight=" + this.getWeight() + ", style=" + FontStyle.toString-impl(this.getStyle-_-LCdwA()) + ')';
    }
}

