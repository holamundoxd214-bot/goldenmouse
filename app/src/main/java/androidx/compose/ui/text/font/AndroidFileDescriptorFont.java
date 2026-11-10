package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u0019\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0010¢\u0006\u0002\b\u0012J\b\u0010\u0017\u001A\u00020\u0014H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0016\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2={"Landroidx/compose/ui/text/font/AndroidFileDescriptorFont;", "Landroidx/compose/ui/text/font/AndroidPreloadedFont;", "fileDescriptor", "Landroid/os/ParcelFileDescriptor;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "<init>", "(Landroid/os/ParcelFileDescriptor;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFileDescriptor", "()Landroid/os/ParcelFileDescriptor;", "doLoad", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "doLoad$ui_text", "cacheKey", "", "getCacheKey", "()Ljava/lang/String;", "toString", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidFileDescriptorFont extends AndroidPreloadedFont {
    public static final int $stable;
    private final String cacheKey;
    private final ParcelFileDescriptor fileDescriptor;

    static {
    }

    private AndroidFileDescriptorFont(ParcelFileDescriptor arg2, FontWeight arg3, int arg4, Settings arg5) {
        super(arg3, arg4, arg5, null);
        this.fileDescriptor = arg2;
        this.setTypeface$ui_text(this.doLoad$ui_text(null));
    }

    public AndroidFileDescriptorFont(ParcelFileDescriptor arg7, FontWeight arg8, int arg9, Settings arg10, int arg11, DefaultConstructorMarker arg12) {
        if((arg11 & 2) != 0) {
            arg8 = FontWeight.Companion.getNormal();
        }

        FontWeight v2 = arg8;
        if((arg11 & 4) != 0) {
            arg9 = FontStyle.Companion.getNormal-_-LCdwA();
        }

        this(arg7, v2, arg9, arg10, null);
    }

    public AndroidFileDescriptorFont(ParcelFileDescriptor arg1, FontWeight arg2, int arg3, Settings arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    public Typeface doLoad$ui_text(Context arg3) {
        return TypefaceBuilderCompat.INSTANCE.createFromFileDescriptor(this.fileDescriptor, arg3, this.getVariationSettings());
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public final ParcelFileDescriptor getFileDescriptor() {
        return this.fileDescriptor;
    }

    public String toString() {
        return "Font(fileDescriptor=" + this.fileDescriptor + ", weight=" + this.getWeight() + ", style=" + FontStyle.toString-impl(this.getStyle-_-LCdwA()) + ')';
    }
}

