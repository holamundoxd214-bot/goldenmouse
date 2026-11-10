package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager$NameNotFoundException;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.os.TraceCompat;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat$FontFamilyResult;
import androidx.core.provider.FontsContractCompat$FontInfo;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class FontRequestEmojiCompatConfig extends Config {
    public class ExponentialBackoffRetryPolicy extends RetryPolicy {
        private long mRetryOrigin;
        private final long mTotalMs;

        public ExponentialBackoffRetryPolicy(long arg1) {
            super();
            this.mTotalMs = arg1;
        }

        public long getRetryDelay() {
            long v2 = 0;
            if(this.mRetryOrigin == v2) {
                this.mRetryOrigin = SystemClock.uptimeMillis();
                return v2;
            }

            long v0 = SystemClock.uptimeMillis() - this.mRetryOrigin;
            if(v0 > this.mTotalMs) {
                return -1;
            }

            return Math.min(Math.max(v0, 1000), this.mTotalMs - v0);
        }
    }

    public class FontProviderHelper {
        public FontProviderHelper() {
            super();
        }

        public Typeface buildTypeface(Context arg2, FontInfo arg3) throws PackageManager$NameNotFoundException {
            return FontsContractCompat.buildTypeface(arg2, null, new FontInfo[]{arg3});
        }

        public FontFamilyResult fetchFonts(Context arg1, FontRequest arg2) throws PackageManager$NameNotFoundException {
            return FontsContractCompat.fetchFonts(arg1, null, arg2);
        }

        public void registerObserver(Context arg1, Uri arg2, ContentObserver arg3) {
            arg1.getContentResolver().registerContentObserver(arg2, false, arg3);
        }

        public void unregisterObserver(Context arg1, ContentObserver arg2) {
            arg1.getContentResolver().unregisterContentObserver(arg2);
        }
    }

    class FontRequestMetadataLoader implements MetadataRepoLoader {
        private static final String S_TRACE_BUILD_TYPEFACE = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface";
        MetadataRepoLoaderCallback mCallback;
        private final Context mContext;
        private Executor mExecutor;
        private final FontProviderHelper mFontProviderHelper;
        private final Object mLock;
        private Handler mMainHandler;
        private Runnable mMainHandlerLoadCallback;
        private ThreadPoolExecutor mMyThreadPoolExecutor;
        private ContentObserver mObserver;
        private final FontRequest mRequest;
        private RetryPolicy mRetryPolicy;

        FontRequestMetadataLoader(Context arg2, FontRequest arg3, FontProviderHelper arg4) {
            super();
            this.mLock = new Object();
            Preconditions.checkNotNull(arg2, "Context cannot be null");
            Preconditions.checkNotNull(arg3, "FontRequest cannot be null");
            this.mContext = arg2.getApplicationContext();
            this.mRequest = arg3;
            this.mFontProviderHelper = arg4;
        }

        private void cleanUp() {
            Object v0 = this.mLock;
            __monitor_enter(v0);
            MetadataRepoLoaderCallback v1 = null;
            try {
                this.mCallback = v1;
                ContentObserver v2 = this.mObserver;
                if(v2 != null) {
                    this.mFontProviderHelper.unregisterObserver(this.mContext, v2);
                    this.mObserver = ((ContentObserver)v1);
                }

                Handler v2_1 = this.mMainHandler;
                if(v2_1 != null) {
                    v2_1.removeCallbacks(this.mMainHandlerLoadCallback);
                }

                this.mMainHandler = ((Handler)v1);
                ThreadPoolExecutor v2_2 = this.mMyThreadPoolExecutor;
                if(v2_2 != null) {
                    v2_2.shutdown();
                }

                this.mExecutor = ((Executor)v1);
                this.mMyThreadPoolExecutor = ((ThreadPoolExecutor)v1);
                __monitor_exit(v0);
                return;
            label_23:
                __monitor_exit(v0);
            }
            catch(Throwable v5) {
                goto label_23;
            }

            throw v5;
        }

        void createMetadata() {
            MetadataRepo v0_3;
            Object v3;
            int v2;
            FontInfo v1_1;
            String v0 = "fetchFonts result is not OK. (";
            Object v1 = this.mLock;
            __monitor_enter(v1);
            try {
                if(this.mCallback == null) {
                    __monitor_exit(v1);
                    return;
                }

                __monitor_exit(v1);
            }
            catch(Throwable v8) {
                try {
                label_82:
                    __monitor_exit(v1);
                }
                catch(Throwable v8) {
                    goto label_82;
                }

                throw v8;
            }

            try {
                v1_1 = this.retrieveFontInfo();
                v2 = v1_1.getResultCode();
                if(v2 == 2) {
                    v3 = this.mLock;
                    __monitor_enter(v3);
                    goto label_14;
                }

                goto label_28;
            }
            catch(Throwable v0_1) {
                goto label_70;
            }

            try {
            label_14:
                RetryPolicy v4 = this.mRetryPolicy;
                if(v4 != null) {
                    long v4_1 = v4.getRetryDelay();
                    if(v4_1 >= 0) {
                        this.scheduleRetry(v1_1.getUri(), v4_1);
                        __monitor_exit(v3);
                        return;
                    }
                }

                __monitor_exit(v3);
                goto label_28;
            label_26:
                __monitor_exit(v3);
            }
            catch(Throwable v0_1) {
                goto label_26;
            }

            try {
                throw v0_1;
            }
            catch(Throwable v0_1) {
                goto label_70;
            }

        label_28:
            if(v2 != 0) {
                goto label_60;
            }

            try {
                TraceCompat.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                Typeface v0_2 = this.mFontProviderHelper.buildTypeface(this.mContext, v1_1);
                ByteBuffer v1_2 = TypefaceCompatUtil.mmap(this.mContext, null, v1_1.getUri());
                if(v1_2 != null && v0_2 != null) {
                    v0_3 = MetadataRepo.create(v0_2, v1_2);
                    goto label_41;
                }

                goto label_53;
            }
            catch(Throwable v0_1) {
                goto label_58;
            }

            try {
            label_41:
                TraceCompat.endSection();
                v1 = this.mLock;
                __monitor_enter(v1);
            }
            catch(Throwable v0_1) {
                goto label_70;
            }

            try {
                MetadataRepoLoaderCallback v2_1 = this.mCallback;
                if(v2_1 != null) {
                    v2_1.onLoaded(v0_3);
                }

                __monitor_exit(v1);
                goto label_48;
            }
            catch(Throwable v0_1) {
                try {
                label_51:
                    __monitor_exit(v1);
                }
                catch(Throwable v0_1) {
                    goto label_51;
                }

                try {
                    throw v0_1;
                label_48:
                    this.cleanUp();
                    return;
                }
                catch(Throwable v0_1) {
                    goto label_70;
                }
            }

            try {
            label_53:
                throw new RuntimeException("Unable to open file.");
            }
            catch(Throwable v0_1) {
                try {
                label_58:
                    TraceCompat.endSection();
                    throw v0_1;
                label_60:
                    throw new RuntimeException(v0 + v2 + ")");
                }
                catch(Throwable v0_1) {
                label_70:
                    Object v2_2 = this.mLock;
                    __monitor_enter(v2_2);
                    try {
                        MetadataRepoLoaderCallback v1_3 = this.mCallback;
                        if(v1_3 != null) {
                            v1_3.onFailed(v0_1);
                        }

                        __monitor_exit(v2_2);
                    }
                    catch(Throwable v8) {
                        try {
                        label_79:
                            __monitor_exit(v2_2);
                        }
                        catch(Throwable v8) {
                            goto label_79;
                        }

                        throw v8;
                    }

                    this.cleanUp();
                    return;
                }
            }
        }

        public void load(MetadataRepoLoaderCallback arg2) {
            Preconditions.checkNotNull(arg2, "LoaderCallback cannot be null");
            Object v0 = this.mLock;
            __monitor_enter(v0);
            try {
                this.mCallback = arg2;
                __monitor_exit(v0);
            }
            catch(Throwable v1) {
                try {
                label_9:
                    __monitor_exit(v0);
                }
                catch(Throwable v1) {
                    goto label_9;
                }

                throw v1;
            }

            this.loadInternal();
        }

        void loadInternal() {
            Object v0 = this.mLock;
            __monitor_enter(v0);
            try {
                if(this.mCallback == null) {
                    __monitor_exit(v0);
                    return;
                }

                if(this.mExecutor == null) {
                    ThreadPoolExecutor v1 = ConcurrencyHelpers.createBackgroundPriorityExecutor("emojiCompat");
                    this.mMyThreadPoolExecutor = v1;
                    this.mExecutor = ((Executor)v1);
                }

                this.mExecutor.execute(new FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda0(this));
                __monitor_exit(v0);
                return;
            label_19:
                __monitor_exit(v0);
            }
            catch(Throwable v3) {
                goto label_19;
            }

            throw v3;
        }

        private FontInfo retrieveFontInfo() {
            FontFamilyResult v3_1;
            try {
                v3_1 = this.mFontProviderHelper.fetchFonts(this.mContext, this.mRequest);
            }
            catch(PackageManager$NameNotFoundException v3) {
                throw new RuntimeException("provider not found", ((Throwable)v3));
            }

            if(v3_1.getStatusCode() == 0) {
                FontInfo[] v3_2 = v3_1.getFonts();
                if(v3_2 != null && v3_2.length != 0) {
                    return v3_2[0];
                }

                throw new RuntimeException("fetchFonts failed (empty result)");
            }

            throw new RuntimeException("fetchFonts failed (" + v3_1.getStatusCode() + ")");
        }

        private void scheduleRetry(Uri arg6, long arg7) {
            Object v0 = this.mLock;
            __monitor_enter(v0);
            try {
                Handler v1 = this.mMainHandler;
                if(v1 == null) {
                    v1 = ConcurrencyHelpers.mainHandlerAsync();
                    this.mMainHandler = v1;
                }

                if(this.mObserver == null) {
                    androidx.emoji2.text.FontRequestEmojiCompatConfig$FontRequestMetadataLoader$1 v2 = new ContentObserver(v1) {
                        public void onChange(boolean arg1, Uri arg2) {
                            FontRequestMetadataLoader.this.loadInternal();
                        }
                    };
                    this.mObserver = ((ContentObserver)v2);
                    this.mFontProviderHelper.registerObserver(this.mContext, arg6, ((ContentObserver)v2));
                }

                if(this.mMainHandlerLoadCallback == null) {
                    this.mMainHandlerLoadCallback = new FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda1(this);
                }

                v1.postDelayed(this.mMainHandlerLoadCallback, arg7);
                __monitor_exit(v0);
                return;
            label_24:
                __monitor_exit(v0);
            }
            catch(Throwable v5) {
                goto label_24;
            }

            throw v5;
        }

        public void setExecutor(Executor arg2) {
            Object v0 = this.mLock;
            __monitor_enter(v0);
            try {
                this.mExecutor = arg2;
                __monitor_exit(v0);
                return;
            label_6:
                __monitor_exit(v0);
            }
            catch(Throwable v1) {
                goto label_6;
            }

            throw v1;
        }

        public void setRetryPolicy(RetryPolicy arg2) {
            Object v0 = this.mLock;
            __monitor_enter(v0);
            try {
                this.mRetryPolicy = arg2;
                __monitor_exit(v0);
                return;
            label_6:
                __monitor_exit(v0);
            }
            catch(Throwable v1) {
                goto label_6;
            }

            throw v1;
        }
    }

    public abstract class RetryPolicy {
        public RetryPolicy() {
            super();
        }

        public abstract long getRetryDelay();
    }

    private static final FontProviderHelper DEFAULT_FONTS_CONTRACT;

    static {
        FontRequestEmojiCompatConfig.DEFAULT_FONTS_CONTRACT = new FontProviderHelper();
    }

    public FontRequestEmojiCompatConfig(Context arg3, FontRequest arg4) {
        super(new FontRequestMetadataLoader(arg3, arg4, FontRequestEmojiCompatConfig.DEFAULT_FONTS_CONTRACT));
    }

    public FontRequestEmojiCompatConfig(Context arg2, FontRequest arg3, FontProviderHelper arg4) {
        super(new FontRequestMetadataLoader(arg2, arg3, arg4));
    }

    @Deprecated public FontRequestEmojiCompatConfig setHandler(Handler arg1) {
        if(arg1 == null) {
            return this;
        }

        this.setLoadingExecutor(ConcurrencyHelpers.convertHandlerToExecutor(arg1));
        return this;
    }

    public FontRequestEmojiCompatConfig setLoadingExecutor(Executor arg2) {
        this.getMetadataRepoLoader().setExecutor(arg2);
        return this;
    }

    public FontRequestEmojiCompatConfig setRetryPolicy(RetryPolicy arg2) {
        this.getMetadataRepoLoader().setRetryPolicy(arg2);
        return this;
    }
}

