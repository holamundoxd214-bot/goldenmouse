package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri$Builder;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.activity.OnBackPressedCallback$$ExternalSyntheticThrowIAE2;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import androidx.core.graphics.TypefaceCompat$ResourcesCallbackAdapter;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

public class FontsContractCompat {
    public final class Columns implements BaseColumns {
        public static final String FILE_ID = "file_id";
        public static final String ITALIC = "font_italic";
        public static final String RESULT_CODE = "result_code";
        public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
        public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
        public static final int RESULT_CODE_MALFORMED_QUERY = 3;
        public static final int RESULT_CODE_OK = 0;
        public static final String TTC_INDEX = "font_ttc_index";
        public static final String VARIATION_SETTINGS = "font_variation_settings";
        public static final String WEIGHT = "font_weight";

        public Columns() {
            super();
        }
    }

    public class FontFamilyResult {
        public static final int STATUS_OK = 0;
        public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
        public static final int STATUS_WRONG_CERTIFICATES = 1;
        private final List mFonts;
        private final int mStatusCode;

        FontFamilyResult(int arg1, List arg2) {
            super();
            this.mStatusCode = arg1;
            this.mFonts = arg2;
        }

        @Deprecated public FontFamilyResult(int arg1, FontInfo[] arg2) {
            super();
            this.mStatusCode = arg1;
            this.mFonts = Collections.singletonList(arg2);
        }

        static FontFamilyResult create(int arg1, FontInfo[] arg2) {
            return new FontFamilyResult(arg1, arg2);
        }

        static FontFamilyResult create(int arg1, List arg2) {
            return new FontFamilyResult(arg1, arg2);
        }

        public FontInfo[] getFonts() {
            return this.mFonts.get(0);
        }

        public List getFontsWithFallbacks() {
            return this.mFonts;
        }

        public int getStatusCode() {
            return this.mStatusCode;
        }

        boolean hasFallback() {
            if(this.mFonts.size() > 1) {
                return 1;
            }

            return 0;
        }
    }

    public class FontInfo {
        private final boolean mItalic;
        private final int mResultCode;
        private final int mTtcIndex;
        private final Uri mUri;
        private final String mVariationSettings;
        private final int mWeight;

        public FontInfo(String arg3, String arg4) {
            super();
            this.mUri = new Uri$Builder().scheme("systemfont").authority(arg3).build();
            this.mTtcIndex = 0;
            this.mWeight = 400;
            this.mItalic = false;
            this.mVariationSettings = arg4;
            this.mResultCode = 0;
        }

        public FontInfo(Uri arg1, int arg2, int arg3, boolean arg4, String arg5, int arg6) {
            super();
            this.mUri = Preconditions.checkNotNull(arg1);
            this.mTtcIndex = arg2;
            this.mWeight = arg3;
            this.mItalic = arg4;
            this.mVariationSettings = arg5;
            this.mResultCode = arg6;
        }

        @Deprecated public FontInfo(Uri arg8, int arg9, int arg10, boolean arg11, int arg12) {
            this(arg8, arg9, arg10, arg11, null, arg12);
        }

        static FontInfo create(Uri arg6, int arg7, int arg8, boolean arg9, int arg10) {
            return new FontInfo(arg6, arg7, arg8, arg9, arg10);
        }

        public int getResultCode() {
            return this.mResultCode;
        }

        public String getSystemFont() {
            if(this.isSystemFont()) {
                return this.mUri.getAuthority();
            }

            return null;
        }

        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        public Uri getUri() {
            return this.mUri;
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

        public boolean isSystemFont() {
            return Objects.equals(this.mUri.getScheme(), "systemfont");
        }
    }

    public class FontRequestCallback {
        @Retention(value=RetentionPolicy.SOURCE) @public interface FontRequestFailReason {
        }

        public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
        public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
        public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
        public static final int FAIL_REASON_MALFORMED_QUERY = 3;
        public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
        public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
        public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;
        @Deprecated public static final int RESULT_OK;
        static final int RESULT_SUCCESS;

        public FontRequestCallback() {
            super();
        }

        public void onTypefaceRequestFailed(int arg1) {
        }

        public void onTypefaceRetrieved(Typeface arg1) {
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface TypefaceStyle {
    }

    @Deprecated public static final String PARCEL_FONT_RESULTS = "font_results";
    @Deprecated static final int RESULT_CODE_PROVIDER_NOT_FOUND = -1;
    @Deprecated static final int RESULT_CODE_WRONG_CERTIFICATES = -2;

    private FontsContractCompat() {
        super();
    }

    public static Typeface buildTypeface(Context arg1, CancellationSignal arg2, FontInfo[] arg3) {
        return TypefaceCompat.createFromFontInfo(arg1, arg2, arg3, 0);
    }

    public static FontFamilyResult fetchFonts(Context arg0, CancellationSignal arg1, FontRequest arg2) throws PackageManager$NameNotFoundException {
        return FontProvider.getFontFamilyResult(arg0, OnBackPressedCallback$$ExternalSyntheticThrowIAE2.m(arg2), arg1);
    }

    @Deprecated public static Typeface getFontSync(Context arg2, FontRequest arg3, FontCallback arg4, Handler arg5, boolean arg6, int arg7, int arg8) {
        return FontsContractCompat.requestFont(arg2, OnBackPressedCallback$$ExternalSyntheticThrowIAE2.m(arg3), arg8, arg6, arg7, FontCallback.getHandler(arg5), new ResourcesCallbackAdapter(arg4));
    }

    @Deprecated public static ProviderInfo getProvider(PackageManager arg0, FontRequest arg1, Resources arg2) throws PackageManager$NameNotFoundException {
        return FontProvider.getProvider(arg0, arg1, arg2);
    }

    @Deprecated public static Map prepareFontData(Context arg0, FontInfo[] arg1, CancellationSignal arg2) {
        return TypefaceCompatUtil.readFontInfoIntoByteBuffer(arg0, arg1, arg2);
    }

    public static Typeface requestFont(Context arg1, List arg2, int arg3, boolean arg4, int arg5, Handler arg6, FontRequestCallback arg7) {
        CallbackWrapper v0 = new CallbackWrapper(arg7, RequestExecutor.createHandlerExecutor(arg6));
        if(arg4) {
            if(arg2.size() <= 1) {
                return FontRequestWorker.requestFontSync(arg1, arg2.get(0), v0, arg3, arg5);
            }

            throw new IllegalArgumentException("Fallbacks with blocking fetches are not supported for performance reasons");
        }

        return FontRequestWorker.requestFontAsync(arg1, arg2, arg3, null, v0);
    }

    public static Typeface requestFont(Context arg0, FontRequest arg1, int arg2, boolean arg3, int arg4, Handler arg5, FontRequestCallback arg6) {
        return FontsContractCompat.requestFont(arg0, OnBackPressedCallback$$ExternalSyntheticThrowIAE2.m(arg1), arg2, arg3, arg4, arg5, arg6);
    }

    public static void requestFont(Context arg1, FontRequest arg2, int arg3, Executor arg4, Executor arg5, FontRequestCallback arg6) {
        FontRequestWorker.requestFontAsync(arg1.getApplicationContext(), OnBackPressedCallback$$ExternalSyntheticThrowIAE2.m(arg2), arg3, arg4, new CallbackWrapper(arg6, arg5));
    }

    @Deprecated public static void requestFont(Context arg1, FontRequest arg2, FontRequestCallback arg3, Handler arg4) {
        FontRequestWorker.requestFontAsync(arg1.getApplicationContext(), OnBackPressedCallback$$ExternalSyntheticThrowIAE2.m(arg2), 0, RequestExecutor.createHandlerExecutor(arg4), new CallbackWrapper(arg3));
    }

    public static void requestFontWithFallbackChain(Context arg1, List arg2, int arg3, Executor arg4, Executor arg5, FontRequestCallback arg6) {
        FontRequestWorker.requestFontAsync(arg1.getApplicationContext(), arg2, arg3, arg4, new CallbackWrapper(arg6, arg5));
    }

    @Deprecated public static void resetCache() {
        FontRequestWorker.resetTypefaceCache();
    }

    public static void resetTypefaceCache() {
        FontRequestWorker.resetTypefaceCache();
    }
}

