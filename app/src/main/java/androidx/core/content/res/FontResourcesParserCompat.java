package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.core.R$styleable;
import androidx.core.provider.FontRequest;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class FontResourcesParserCompat {
    public interface FamilyResourceEntry {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface FetchStrategy {
    }

    public final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {
        private final FontFileResourceEntry[] mEntries;

        public FontFamilyFilesResourceEntry(FontFileResourceEntry[] arg1) {
            super();
            this.mEntries = arg1;
        }

        public FontFileResourceEntry[] getEntries() {
            return this.mEntries;
        }
    }

    public final class FontFileResourceEntry {
        private final String mFileName;
        private final boolean mItalic;
        private final int mResourceId;
        private final int mTtcIndex;
        private final String mVariationSettings;
        private final int mWeight;

        public FontFileResourceEntry(String arg1, int arg2, boolean arg3, String arg4, int arg5, int arg6) {
            super();
            this.mFileName = arg1;
            this.mWeight = arg2;
            this.mItalic = arg3;
            this.mVariationSettings = arg4;
            this.mTtcIndex = arg5;
            this.mResourceId = arg6;
        }

        public String getFileName() {
            return this.mFileName;
        }

        public int getResourceId() {
            return this.mResourceId;
        }

        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        public String getVariationSettings() {
            return this.mVariationSettings;
        }

        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }
    }

    public final class ProviderResourceEntry implements FamilyResourceEntry {
        private final List mRequests;
        private final int mStrategy;
        private final String mSystemFontFamilyName;
        private final int mTimeoutMs;

        public ProviderResourceEntry(List arg1, int arg2, int arg3, String arg4) {
            super();
            this.mRequests = arg1;
            this.mStrategy = arg2;
            this.mTimeoutMs = arg3;
            this.mSystemFontFamilyName = arg4;
        }

        public ProviderResourceEntry(FontRequest arg2, int arg3, int arg4) {
            this(Collections.singletonList(arg2), arg3, arg4, null);
        }

        public FontRequest getFallbackRequest() {
            if(this.mRequests.size() < 2) {
                return null;
            }

            return this.mRequests.get(1);
        }

        public int getFetchStrategy() {
            return this.mStrategy;
        }

        public FontRequest getRequest() {
            return this.mRequests.get(0);
        }

        public List getRequests() {
            return this.mRequests;
        }

        public String getSystemFontFamilyName() {
            return this.mSystemFontFamilyName;
        }

        public int getTimeout() {
            return this.mTimeoutMs;
        }
    }

    private static final int DEFAULT_TIMEOUT_MILLIS = 500;
    public static final int FETCH_STRATEGY_ASYNC = 1;
    public static final int FETCH_STRATEGY_BLOCKING = 0;
    public static final int INFINITE_TIMEOUT_VALUE = -1;
    private static final int ITALIC = 1;
    private static final int NORMAL_WEIGHT = 400;

    private FontResourcesParserCompat() {
        super();
    }

    private static int getType(TypedArray arg0, int arg1) {
        return arg0.getType(arg1);
    }

    public static FamilyResourceEntry parse(XmlPullParser arg3, Resources arg4) throws XmlPullParserException, IOException {
        while(true) {
            int v0 = arg3.next();
            int v1 = 2;
            if(v0 != v1 && v0 != 1) {
                continue;
            }

            break;
        }

        if(v0 == v1) {
            return FontResourcesParserCompat.readFamilies(arg3, arg4);
        }

        throw new XmlPullParserException("No start tag found");
    }

    public static List readCerts(Resources arg5, int arg6) {
        ArrayList v1;
        List v5_1;
        if(arg6 == 0) {
            return Collections.emptyList();
        }

        TypedArray v0 = arg5.obtainTypedArray(arg6);
        try {
            if(v0.length() != 0) {
                goto label_9;
            }

            v5_1 = Collections.emptyList();
        }
        catch(Throwable v5) {
            goto label_31;
        }

        v0.recycle();
        return v5_1;
        try {
        label_9:
            v1 = new ArrayList();
            if(FontResourcesParserCompat.getType(v0, 0) == 1) {
                for(arg6 = 0; arg6 < v0.length(); ++arg6) {
                    int v3 = v0.getResourceId(arg6, 0);
                    if(v3 != 0) {
                        ((List)v1).add(FontResourcesParserCompat.toByteArrayList(arg5.getStringArray(v3)));
                    }
                }
            }
            else {
                ((List)v1).add(FontResourcesParserCompat.toByteArrayList(arg5.getStringArray(arg6)));
            }
        }
        catch(Throwable v5) {
        label_31:
            v0.recycle();
            throw v5;
        }

        v0.recycle();
        return ((List)v1);
    }

    private static FontRequest readFallback(XmlPullParser arg8, Resources arg9, String arg10, String arg11, List arg12) throws XmlPullParserException, IOException {
        FontRequest v1;
        TypedArray v9 = arg9.obtainAttributes(Xml.asAttributeSet(arg8), styleable.FontFamilyProviderFallback);
        try {
            String v4 = v9.getString(styleable.FontFamilyProviderFallback_fontProviderQuery);
            String v6 = v9.getString(styleable.FontFamilyProviderFallback_fontProviderSystemFontFamily);
            String v7 = v9.getString(styleable.FontFamilyProviderFallback_fontVariationSettings);
            if(v4 == null) {
                goto label_22;
            }

            while(arg8.next() != 3) {
                FontResourcesParserCompat.skip(arg8);
            }

            v1 = new FontRequest(arg10, arg11, v4, arg12, v6, v7);
        }
        catch(Throwable v0) {
            goto label_28;
        }

        v9.recycle();
        return v1;
        try {
        label_22:
            throw new XmlPullParserException("query attribute must be set in fallback element");
        }
        catch(Throwable v0) {
        label_28:
            v9.recycle();
            throw v0;
        }
    }

    private static FamilyResourceEntry readFamilies(XmlPullParser arg3, Resources arg4) throws XmlPullParserException, IOException {
        String v1 = null;
        arg3.require(2, v1, "font-family");
        if(arg3.getName().equals("font-family")) {
            return FontResourcesParserCompat.readFamily(arg3, arg4);
        }

        FontResourcesParserCompat.skip(arg3);
        return ((FamilyResourceEntry)v1);
    }

    private static FamilyResourceEntry readFamily(XmlPullParser arg13, Resources arg14) throws XmlPullParserException, IOException {
        TypedArray v0 = arg14.obtainAttributes(Xml.asAttributeSet(arg13), styleable.FontFamily);
        String v3 = v0.getString(styleable.FontFamily_fontProviderAuthority);
        String v4 = v0.getString(styleable.FontFamily_fontProviderPackage);
        String v5 = v0.getString(styleable.FontFamily_fontProviderQuery);
        String v1 = v0.getString(styleable.FontFamily_fontProviderFallbackQuery);
        int v2 = v0.getResourceId(styleable.FontFamily_fontProviderCerts, 0);
        int v9 = v0.getInteger(styleable.FontFamily_fontProviderFetchStrategy, 1);
        int v10 = v0.getInteger(styleable.FontFamily_fontProviderFetchTimeout, 500);
        String v11 = v0.getString(styleable.FontFamily_fontProviderSystemFontFamily);
        v0.recycle();
        int v0_1 = 2;
        int v7 = 3;
        if(v3 != null && v4 != null) {
            List v6 = FontResourcesParserCompat.readCerts(arg14, v2);
            ArrayList v12 = new ArrayList();
            while(arg13.next() != v7) {
                if(arg13.getEventType() != v0_1) {
                }
                else if(arg13.getName().equals("fallback")) {
                    ((List)v12).add(FontResourcesParserCompat.readFallback(arg13, arg14, v3, v4, v6));
                }
                else {
                    FontResourcesParserCompat.skip(arg13);
                }
            }

            if(!((List)v12).isEmpty()) {
                return new ProviderResourceEntry(((List)v12), v9, v10, v11);
            }
            else if(v5 != null) {
                ((List)v12).add(new FontRequest(v3, v4, v5, v6, null, null));
                if(v1 != null) {
                    ((List)v12).add(new FontRequest(v3, v4, v1, v6, null, null));
                }

                return new ProviderResourceEntry(((List)v12), v9, v10, v11);
            }
            else {
                throw new IllegalArgumentException("The provider font XML requires query attribute or fallback children.");
            }
        }

        ArrayList v1_1 = new ArrayList();
        while(arg13.next() != v7) {
            if(arg13.getEventType() != v0_1) {
                continue;
            }

            if(arg13.getName().equals("font")) {
                ((List)v1_1).add(FontResourcesParserCompat.readFont(arg13, arg14));
                continue;
            }

            FontResourcesParserCompat.skip(arg13);
        }

        if(((List)v1_1).isEmpty()) {
            return null;
        }

        return new FontFamilyFilesResourceEntry(((List)v1_1).toArray(new FontFileResourceEntry[0]));
    }

    private static FontFileResourceEntry readFont(XmlPullParser arg9, Resources arg10) throws XmlPullParserException, IOException {
        TypedArray v10 = arg10.obtainAttributes(Xml.asAttributeSet(arg9), styleable.FontFamilyFont);
        int v0 = v10.hasValue(styleable.FontFamilyFont_fontWeight) ? styleable.FontFamilyFont_fontWeight : styleable.FontFamilyFont_android_fontWeight;
        int v4 = v10.getInt(v0, 400);
        v0 = v10.hasValue(styleable.FontFamilyFont_fontStyle) ? styleable.FontFamilyFont_fontStyle : styleable.FontFamilyFont_android_fontStyle;
        boolean v5 = 1 == v10.getInt(v0, 0) ? true : false;
        v0 = v10.hasValue(styleable.FontFamilyFont_ttcIndex) ? styleable.FontFamilyFont_ttcIndex : styleable.FontFamilyFont_android_ttcIndex;
        int v2 = v10.hasValue(styleable.FontFamilyFont_fontVariationSettings) ? styleable.FontFamilyFont_fontVariationSettings : styleable.FontFamilyFont_android_fontVariationSettings;
        String v6 = v10.getString(v2);
        int v7 = v10.getInt(v0, 0);
        v0 = v10.hasValue(styleable.FontFamilyFont_font) ? styleable.FontFamilyFont_font : styleable.FontFamilyFont_android_font;
        int v8 = v10.getResourceId(v0, 0);
        String v3 = v10.getString(v0);
        v10.recycle();
        while(arg9.next() != 3) {
            FontResourcesParserCompat.skip(arg9);
        }

        return new FontFileResourceEntry(v3, v4, v5, v6, v7, v8);
    }

    private static void skip(XmlPullParser arg3) throws XmlPullParserException, IOException {
        int v0;
        for(v0 = 1; v0 > 0; ++v0) {
            int v1 = arg3.next();
            if(v1 != 2) {
                if(v1 != 3) {
                    continue;
                }

                --v0;
                continue;
            }
        }
    }

    private static List toByteArrayList(String[] arg5) {
        ArrayList v0 = new ArrayList();
        int v1 = arg5.length;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            ((List)v0).add(Base64.decode(arg5[v3], 0));
        }

        return ((List)v0);
    }
}

