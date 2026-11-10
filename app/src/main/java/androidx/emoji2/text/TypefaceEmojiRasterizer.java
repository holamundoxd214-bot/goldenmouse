package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TypefaceEmojiRasterizer {
    @Retention(value=RetentionPolicy.SOURCE) @public interface HasGlyph {
    }

    static final int HAS_GLYPH_ABSENT = 1;
    static final int HAS_GLYPH_EXISTS = 2;
    static final int HAS_GLYPH_UNKNOWN;
    private volatile int mCache;
    private final int mIndex;
    private final MetadataRepo mMetadataRepo;
    private static final ThreadLocal sMetadataItem;

    static {
        TypefaceEmojiRasterizer.sMetadataItem = new ThreadLocal();
    }

    TypefaceEmojiRasterizer(MetadataRepo arg2, int arg3) {
        super();
        this.mCache = 0;
        this.mMetadataRepo = arg2;
        this.mIndex = arg3;
    }

    public void draw(Canvas arg10, float arg11, float arg12, Paint arg13) {
        Typeface v0 = this.mMetadataRepo.getTypeface();
        Typeface v1 = arg13.getTypeface();
        arg13.setTypeface(v0);
        arg10.drawText(this.mMetadataRepo.getEmojiCharArray(), this.mIndex * 2, 2, arg11, arg12, arg13);
        arg13.setTypeface(v1);
    }

    public int getCodepointAt(int arg1) {
        return this.getMetadataItem().codepoints(arg1);
    }

    public int getCodepointsLength() {
        return this.getMetadataItem().codepointsLength();
    }

    public short getCompatAdded() {
        return this.getMetadataItem().compatAdded();
    }

    public int getHasGlyph() {
        return this.mCache & 3;
    }

    public int getHeight() {
        return this.getMetadataItem().height();
    }

    public int getId() {
        return this.getMetadataItem().id();
    }

    private MetadataItem getMetadataItem() {
        ThreadLocal v0 = TypefaceEmojiRasterizer.sMetadataItem;
        Object v1 = v0.get();
        if(v1 == null) {
            MetadataItem v1_1 = new MetadataItem();
            v0.set(v1_1);
        }

        this.mMetadataRepo.getMetadataList().list(((MetadataItem)v1), this.mIndex);
        return ((MetadataItem)v1);
    }

    public short getSdkAdded() {
        return this.getMetadataItem().sdkAdded();
    }

    public Typeface getTypeface() {
        return this.mMetadataRepo.getTypeface();
    }

    public int getWidth() {
        return this.getMetadataItem().width();
    }

    public boolean isDefaultEmoji() {
        return this.getMetadataItem().emojiStyle();
    }

    public boolean isPreferredSystemRender() {
        if((this.mCache & 4) > 0) {
            return 1;
        }

        return 0;
    }

    public void resetHasGlyphCache() {
        if(this.isPreferredSystemRender()) {
            this.mCache = 4;
            return;
        }

        this.mCache = 0;
    }

    public void setExclusion(boolean arg2) {
        int v0 = this.getHasGlyph();
        if(arg2) {
            this.mCache = v0 | 4;
            return;
        }

        this.mCache = v0;
    }

    public void setHasGlyph(boolean arg2) {
        int v0 = this.mCache & 4;
        int v2 = arg2 ? v0 | 2 : v0 | 1;
        this.mCache = v2;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder();
        v0.append(super.toString());
        v0.append(", id:");
        v0.append(Integer.toHexString(this.getId()));
        v0.append(", codepoints:");
        int v1 = this.getCodepointsLength();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0.append(Integer.toHexString(this.getCodepointAt(v2)));
            v0.append(" ");
        }

        return v0.toString();
    }
}

