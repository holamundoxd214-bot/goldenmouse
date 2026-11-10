package androidx.compose.ui.text.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0010¢\u0006\u0002\b\u0016J\b\u0010\u0019\u001A\u00020\u0005H\u0016J\u0013\u0010\u001A\u001A\u00020\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0096\u0002J\b\u0010\u001E\u001A\u00020\u001FH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0017\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0011¨\u0006 "}, d2={"Landroidx/compose/ui/text/font/AndroidAssetFont;", "Landroidx/compose/ui/text/font/AndroidPreloadedFont;", "assetManager", "Landroid/content/res/AssetManager;", "path", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "<init>", "(Landroid/content/res/AssetManager;Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAssetManager", "()Landroid/content/res/AssetManager;", "getPath", "()Ljava/lang/String;", "doLoad", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "doLoad$ui_text", "cacheKey", "getCacheKey", "toString", "equals", "", "other", "", "hashCode", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidAssetFont extends AndroidPreloadedFont {
    public static final int $stable;
    private final AssetManager assetManager;
    private final String cacheKey;
    private final String path;

    static {
    }

    private AndroidAssetFont(AssetManager arg2, String arg3, FontWeight arg4, int arg5, Settings arg6) {
        super(arg4, arg5, arg6, null);
        this.assetManager = arg2;
        this.path = arg3;
        this.setTypeface$ui_text(this.doLoad$ui_text(null));
        this.cacheKey = "asset:" + arg3;
    }

    public AndroidAssetFont(AssetManager arg8, String arg9, FontWeight arg10, int arg11, Settings arg12, int arg13, DefaultConstructorMarker arg14) {
        if((arg13 & 4) != 0) {
            arg10 = FontWeight.Companion.getNormal();
        }

        FontWeight v3 = arg10;
        if((arg13 & 8) != 0) {
            arg11 = FontStyle.Companion.getNormal-_-LCdwA();
        }

        this(arg8, arg9, v3, arg11, arg12, null);
    }

    public AndroidAssetFont(AssetManager arg1, String arg2, FontWeight arg3, int arg4, Settings arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    public Typeface doLoad$ui_text(Context arg4) {
        return TypefaceBuilderCompat.INSTANCE.createFromAssets(this.assetManager, this.path, arg4, this.getVariationSettings());
    }

    public boolean equals(Object arg5) {
        if(this == (((AndroidAssetFont)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof AndroidAssetFont)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.path, ((AndroidAssetFont)arg5).path)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getVariationSettings(), ((AndroidAssetFont)arg5).getVariationSettings())) {
            return 0;
        }

        return 1;
    }

    public final AssetManager getAssetManager() {
        return this.assetManager;
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public final String getPath() {
        return this.path;
    }

    public int hashCode() {
        return this.path.hashCode() * 0x1F + this.getVariationSettings().hashCode();
    }

    public String toString() {
        return "Font(assetManager, path=" + this.path + ", weight=" + this.getWeight() + ", style=" + FontStyle.toString-impl(this.getStyle-_-LCdwA()) + ')';
    }
}

