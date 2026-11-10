package androidx.emoji2.text;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class EmojiCompat {
    @Retention(value=RetentionPolicy.SOURCE) @public interface CodepointSequenceMatchResult {
    }

    final class CompatInternal19 extends CompatInternal {
        private volatile MetadataRepo mMetadataRepo;
        private volatile EmojiProcessor mProcessor;

        CompatInternal19(EmojiCompat arg1) {
            super(arg1);
        }

        String getAssetSignature() {
            String v0 = this.mMetadataRepo.getMetadataList().sourceSha();
            if(v0 == null) {
                v0 = "";
            }

            return v0;
        }

        int getEmojiEnd(CharSequence arg1, int arg2) {
            return this.mProcessor.getEmojiEnd(arg1, arg2);
        }

        public int getEmojiMatch(CharSequence arg1, int arg2) {
            return this.mProcessor.getEmojiMatch(arg1, arg2);
        }

        int getEmojiStart(CharSequence arg1, int arg2) {
            return this.mProcessor.getEmojiStart(arg1, arg2);
        }

        boolean hasEmojiGlyph(CharSequence arg1) {
            if(this.mProcessor.getEmojiMatch(arg1) == 1) {
                return 1;
            }

            return 0;
        }

        boolean hasEmojiGlyph(CharSequence arg1, int arg2) {
            if(this.mProcessor.getEmojiMatch(arg1, arg2) == 1) {
                return 1;
            }

            return 0;
        }

        void loadMetadata() {
            try {
                this.mEmojiCompat.mMetadataLoader.load(new MetadataRepoLoaderCallback() {
                    public void onFailed(Throwable arg1) {
                        CompatInternal19.this.mEmojiCompat.onMetadataLoadFailed(arg1);
                    }

                    public void onLoaded(MetadataRepo arg1) {
                        CompatInternal19.this.onMetadataLoadSuccess(arg1);
                    }
                });
                return;
            }
            catch(Throwable v0) {
                this.mEmojiCompat.onMetadataLoadFailed(v0);
                return;
            }
        }

        void onMetadataLoadSuccess(MetadataRepo arg9) {
            if(arg9 == null) {
                this.mEmojiCompat.onMetadataLoadFailed(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }

            this.mMetadataRepo = arg9;
            this.mProcessor = new EmojiProcessor(this.mMetadataRepo, this.mEmojiCompat.mSpanFactory, this.mEmojiCompat.mGlyphChecker, this.mEmojiCompat.mUseEmojiAsDefaultStyle, this.mEmojiCompat.mEmojiAsDefaultStyleExceptions, EmojiExclusions.getEmojiExclusions());
            this.mEmojiCompat.onMetadataLoadSuccess();
        }

        CharSequence process(CharSequence arg1, int arg2, int arg3, int arg4, boolean arg5) {
            return this.mProcessor.process(arg1, arg2, arg3, arg4, arg5);
        }

        void updateEditorInfoAttrs(EditorInfo arg4) {
            arg4.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.mMetadataRepo.getMetadataVersion());
            arg4.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.mEmojiCompat.mReplaceAll);
        }
    }

    class CompatInternal {
        final EmojiCompat mEmojiCompat;

        CompatInternal(EmojiCompat arg1) {
            super();
            this.mEmojiCompat = arg1;
        }

        String getAssetSignature() {
            return "";
        }

        int getEmojiEnd(CharSequence arg1, int arg2) {
            return -1;
        }

        public int getEmojiMatch(CharSequence arg1, int arg2) {
            return 0;
        }

        int getEmojiStart(CharSequence arg1, int arg2) {
            return -1;
        }

        boolean hasEmojiGlyph(CharSequence arg1) {
            return 0;
        }

        boolean hasEmojiGlyph(CharSequence arg1, int arg2) {
            return 0;
        }

        void loadMetadata() {
            this.mEmojiCompat.onMetadataLoadSuccess();
        }

        CharSequence process(CharSequence arg1, int arg2, int arg3, int arg4, boolean arg5) {
            return arg1;
        }

        void updateEditorInfoAttrs(EditorInfo arg1) {
        }
    }

    public abstract class Config {
        int[] mEmojiAsDefaultStyleExceptions;
        int mEmojiSpanIndicatorColor;
        boolean mEmojiSpanIndicatorEnabled;
        GlyphChecker mGlyphChecker;
        Set mInitCallbacks;
        int mMetadataLoadStrategy;
        final MetadataRepoLoader mMetadataLoader;
        boolean mReplaceAll;
        SpanFactory mSpanFactory;
        boolean mUseEmojiAsDefaultStyle;

        protected Config(MetadataRepoLoader arg2) {
            super();
            this.mEmojiSpanIndicatorColor = 0xFF00FF00;
            this.mMetadataLoadStrategy = 0;
            this.mGlyphChecker = new DefaultGlyphChecker();
            Preconditions.checkNotNull(arg2, "metadataLoader cannot be null.");
            this.mMetadataLoader = arg2;
        }

        protected final MetadataRepoLoader getMetadataRepoLoader() {
            return this.mMetadataLoader;
        }

        public Config registerInitCallback(InitCallback arg2) {
            Preconditions.checkNotNull(arg2, "initCallback cannot be null");
            if(this.mInitCallbacks == null) {
                this.mInitCallbacks = new ArraySet();
            }

            this.mInitCallbacks.add(arg2);
            return this;
        }

        public Config setEmojiSpanIndicatorColor(int arg1) {
            this.mEmojiSpanIndicatorColor = arg1;
            return this;
        }

        public Config setEmojiSpanIndicatorEnabled(boolean arg1) {
            this.mEmojiSpanIndicatorEnabled = arg1;
            return this;
        }

        public Config setGlyphChecker(GlyphChecker arg2) {
            Preconditions.checkNotNull(arg2, "GlyphChecker cannot be null");
            this.mGlyphChecker = arg2;
            return this;
        }

        public Config setMetadataLoadStrategy(int arg1) {
            this.mMetadataLoadStrategy = arg1;
            return this;
        }

        public Config setReplaceAll(boolean arg1) {
            this.mReplaceAll = arg1;
            return this;
        }

        public Config setSpanFactory(SpanFactory arg1) {
            this.mSpanFactory = arg1;
            return this;
        }

        public Config setUseEmojiAsDefaultStyle(boolean arg2) {
            return this.setUseEmojiAsDefaultStyle(arg2, null);
        }

        public Config setUseEmojiAsDefaultStyle(boolean arg4, List arg5) {
            this.mUseEmojiAsDefaultStyle = arg4;
            if((arg4) && arg5 != null) {
                this.mEmojiAsDefaultStyleExceptions = new int[arg5.size()];
                Iterator v4 = arg5.iterator();
                int v5;
                for(v5 = 0; v4.hasNext(); ++v5) {
                    this.mEmojiAsDefaultStyleExceptions[v5] = v4.next().intValue();
                }

                Arrays.sort(this.mEmojiAsDefaultStyleExceptions);
                return this;
            }

            this.mEmojiAsDefaultStyleExceptions = null;
            return this;
        }

        public Config unregisterInitCallback(InitCallback arg2) {
            Preconditions.checkNotNull(arg2, "initCallback cannot be null");
            Set v0 = this.mInitCallbacks;
            if(v0 != null) {
                v0.remove(arg2);
            }

            return this;
        }
    }

    public class DefaultSpanFactory implements SpanFactory {
        public DefaultSpanFactory() {
            super();
        }

        public EmojiSpan createSpan(TypefaceEmojiRasterizer arg1) {
            return new TypefaceEmojiSpan(arg1);
        }
    }

    public interface GlyphChecker {
        boolean hasGlyph(CharSequence arg1, int arg2, int arg3, int arg4);
    }

    public abstract class InitCallback {
        public InitCallback() {
            super();
        }

        public void onFailed(Throwable arg1) {
        }

        public void onInitialized() {
        }
    }

    class ListenerDispatcher implements Runnable {
        private final List mInitCallbacks;
        private final int mLoadState;
        private final Throwable mThrowable;

        ListenerDispatcher(Collection arg2, int arg3, Throwable arg4) {
            super();
            Preconditions.checkNotNull(arg2, "initCallbacks cannot be null");
            this.mInitCallbacks = new ArrayList(arg2);
            this.mLoadState = arg3;
            this.mThrowable = arg4;
        }

        ListenerDispatcher(Collection arg2, int arg3) {
            this(arg2, arg3, null);
        }

        ListenerDispatcher(InitCallback arg3, int arg4) {
            this(Arrays.asList(new InitCallback[]{Preconditions.checkNotNull(arg3, "initCallback cannot be null")}), arg4, null);
        }

        public void run() {
            int v0 = this.mInitCallbacks.size();
            int v3 = 0;
            if(this.mLoadState != 1) {
                while(v3 < v0) {
                    this.mInitCallbacks.get(v3).onFailed(this.mThrowable);
                    ++v3;
                }
            }
            else {
                while(v3 < v0) {
                    this.mInitCallbacks.get(v3).onInitialized();
                    ++v3;
                }
            }
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface LoadStrategy {
    }

    public interface MetadataRepoLoader {
        void load(MetadataRepoLoaderCallback arg1);
    }

    public abstract class MetadataRepoLoaderCallback {
        public MetadataRepoLoaderCallback() {
            super();
        }

        public abstract void onFailed(Throwable arg1);

        public abstract void onLoaded(MetadataRepo arg1);
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface ReplaceStrategy {
    }

    public interface SpanFactory {
        EmojiSpan createSpan(TypefaceEmojiRasterizer arg1);
    }

    private static final Object CONFIG_LOCK = null;
    public static final String EDITOR_INFO_METAVERSION_KEY = "android.support.text.emoji.emojiCompat_metadataVersion";
    public static final String EDITOR_INFO_REPLACE_ALL_KEY = "android.support.text.emoji.emojiCompat_replaceAll";
    static final int EMOJI_COUNT_UNLIMITED = 0x7FFFFFFF;
    public static final int EMOJI_FALLBACK = 2;
    public static final int EMOJI_SUPPORTED = 1;
    public static final int EMOJI_UNSUPPORTED = 0;
    private static final Object INSTANCE_LOCK = null;
    public static final int LOAD_STATE_DEFAULT = 3;
    public static final int LOAD_STATE_FAILED = 2;
    public static final int LOAD_STATE_LOADING = 0;
    public static final int LOAD_STATE_SUCCEEDED = 1;
    public static final int LOAD_STRATEGY_DEFAULT = 0;
    public static final int LOAD_STRATEGY_MANUAL = 1;
    private static final String NOT_INITIALIZED_ERROR_TEXT = "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK\'s manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.";
    public static final int REPLACE_STRATEGY_ALL = 1;
    public static final int REPLACE_STRATEGY_DEFAULT = 0;
    public static final int REPLACE_STRATEGY_NON_EXISTENT = 2;
    final int[] mEmojiAsDefaultStyleExceptions;
    private final int mEmojiSpanIndicatorColor;
    private final boolean mEmojiSpanIndicatorEnabled;
    private final GlyphChecker mGlyphChecker;
    private final CompatInternal mHelper;
    private final Set mInitCallbacks;
    private final ReadWriteLock mInitLock;
    private volatile int mLoadState;
    private final Handler mMainHandler;
    private final int mMetadataLoadStrategy;
    final MetadataRepoLoader mMetadataLoader;
    final boolean mReplaceAll;
    private final SpanFactory mSpanFactory;
    final boolean mUseEmojiAsDefaultStyle;
    private static volatile boolean sHasDoneDefaultConfigLookup;
    private static volatile EmojiCompat sInstance;

    static {
        EmojiCompat.INSTANCE_LOCK = new Object();
        EmojiCompat.CONFIG_LOCK = new Object();
    }

    private EmojiCompat(Config arg3) {
        super();
        this.mInitLock = new ReentrantReadWriteLock();
        this.mLoadState = 3;
        this.mReplaceAll = arg3.mReplaceAll;
        this.mUseEmojiAsDefaultStyle = arg3.mUseEmojiAsDefaultStyle;
        this.mEmojiAsDefaultStyleExceptions = arg3.mEmojiAsDefaultStyleExceptions;
        this.mEmojiSpanIndicatorEnabled = arg3.mEmojiSpanIndicatorEnabled;
        this.mEmojiSpanIndicatorColor = arg3.mEmojiSpanIndicatorColor;
        this.mMetadataLoader = arg3.mMetadataLoader;
        this.mMetadataLoadStrategy = arg3.mMetadataLoadStrategy;
        this.mGlyphChecker = arg3.mGlyphChecker;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        ArraySet v0 = new ArraySet();
        this.mInitCallbacks = ((Set)v0);
        SpanFactory v1 = arg3.mSpanFactory;
        if(v1 != null) {
        }
        else {
            DefaultSpanFactory v1_1 = new DefaultSpanFactory();
        }

        this.mSpanFactory = v1;
        if(arg3.mInitCallbacks != null && !arg3.mInitCallbacks.isEmpty()) {
            ((Set)v0).addAll(arg3.mInitCallbacks);
        }

        this.mHelper = new CompatInternal19(this);
        this.loadMetadata();
    }

    static SpanFactory access$000(EmojiCompat arg0) {
        return arg0.mSpanFactory;
    }

    static GlyphChecker access$100(EmojiCompat arg0) {
        return arg0.mGlyphChecker;
    }

    public static EmojiCompat get() {
        Object v0 = EmojiCompat.INSTANCE_LOCK;
        __monitor_enter(v0);
        try {
            EmojiCompat v1_1 = EmojiCompat.sInstance;
            boolean v2 = v1_1 != null ? true : false;
            Preconditions.checkState(v2, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK\'s manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
            __monitor_exit(v0);
            return v1_1;
        label_12:
            __monitor_exit(v0);
        }
        catch(Throwable v1) {
            goto label_12;
        }

        throw v1;
    }

    public String getAssetSignature() {
        Preconditions.checkState(this.isInitialized(), "Not initialized yet");
        return this.mHelper.getAssetSignature();
    }

    public int getEmojiEnd(CharSequence arg3, int arg4) {
        Preconditions.checkState(this.isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(arg3, "charSequence cannot be null");
        return this.mHelper.getEmojiEnd(arg3, arg4);
    }

    public int getEmojiMatch(CharSequence arg3, int arg4) {
        Preconditions.checkState(this.isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(arg3, "sequence cannot be null");
        return this.mHelper.getEmojiMatch(arg3, arg4);
    }

    public int getEmojiSpanIndicatorColor() {
        return this.mEmojiSpanIndicatorColor;
    }

    public int getEmojiStart(CharSequence arg3, int arg4) {
        Preconditions.checkState(this.isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(arg3, "charSequence cannot be null");
        return this.mHelper.getEmojiStart(arg3, arg4);
    }

    public int getLoadState() {
        int v0_1;
        this.mInitLock.readLock().lock();
        try {
            v0_1 = this.mLoadState;
        }
        catch(Throwable v0) {
            this.mInitLock.readLock().unlock();
            throw v0;
        }

        this.mInitLock.readLock().unlock();
        return v0_1;
    }

    public static boolean handleDeleteSurroundingText(InputConnection arg0, Editable arg1, int arg2, int arg3, boolean arg4) {
        return EmojiProcessor.handleDeleteSurroundingText(arg0, arg1, arg2, arg3, arg4);
    }

    public static boolean handleOnKeyDown(Editable arg0, int arg1, KeyEvent arg2) {
        return EmojiProcessor.handleOnKeyDown(arg0, arg1, arg2);
    }

    @Deprecated public boolean hasEmojiGlyph(CharSequence arg3) {
        Preconditions.checkState(this.isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(arg3, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(arg3);
    }

    @Deprecated public boolean hasEmojiGlyph(CharSequence arg3, int arg4) {
        Preconditions.checkState(this.isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(arg3, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(arg3, arg4);
    }

    public static EmojiCompat init(Context arg1) {
        return EmojiCompat.init(arg1, null);
    }

    public static EmojiCompat init(Context arg1, DefaultEmojiCompatConfigFactory arg2) {
        if(EmojiCompat.sHasDoneDefaultConfigLookup) {
            return EmojiCompat.sInstance;
        }

        if(arg2 != null) {
        }
        else {
            arg2 = new DefaultEmojiCompatConfigFactory(null);
        }

        Config v1 = arg2.create(arg1);
        Object v2 = EmojiCompat.CONFIG_LOCK;
        __monitor_enter(v2);
        try {
            if(!EmojiCompat.sHasDoneDefaultConfigLookup) {
                if(v1 != null) {
                    EmojiCompat.init(v1);
                }

                EmojiCompat.sHasDoneDefaultConfigLookup = true;
            }

            __monitor_exit(v2);
            return EmojiCompat.sInstance;
        label_22:
            __monitor_exit(v2);
        }
        catch(Throwable v1_1) {
            goto label_22;
        }

        throw v1_1;
    }

    public static EmojiCompat init(Config arg2) {
        EmojiCompat v0 = EmojiCompat.sInstance;
        if(v0 == null) {
            Object v1 = EmojiCompat.INSTANCE_LOCK;
            __monitor_enter(v1);
            try {
                v0 = EmojiCompat.sInstance;
                if(v0 == null) {
                    v0 = new EmojiCompat(arg2);
                    EmojiCompat.sInstance = v0;
                }

                __monitor_exit(v1);
                return v0;
            label_12:
                __monitor_exit(v1);
            }
            catch(Throwable v2) {
                goto label_12;
            }

            throw v2;
        }

        return v0;
    }

    public static boolean isConfigured() {
        if(EmojiCompat.sInstance != null) {
            return 1;
        }

        return 0;
    }

    public boolean isEmojiSpanIndicatorEnabled() {
        return this.mEmojiSpanIndicatorEnabled;
    }

    private boolean isInitialized() {
        if(this.getLoadState() == 1) {
            return 1;
        }

        return 0;
    }

    public void load() {
        boolean v2 = true;
        if(this.mMetadataLoadStrategy == 1) {
        }
        else {
            v2 = false;
        }

        Preconditions.checkState(v2, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if(this.isInitialized()) {
            return;
        }

        this.mInitLock.writeLock().lock();
        try {
            if(this.mLoadState != 0) {
                goto label_20;
            }
        }
        catch(Throwable v0) {
            goto label_30;
        }

        this.mInitLock.writeLock().unlock();
        return;
        try {
        label_20:
            this.mLoadState = 0;
        }
        catch(Throwable v0) {
        label_30:
            this.mInitLock.writeLock().unlock();
            throw v0;
        }

        this.mInitLock.writeLock().unlock();
        this.mHelper.loadMetadata();
    }

    private void loadMetadata() {
        this.mInitLock.writeLock().lock();
        try {
            if(this.mMetadataLoadStrategy == 0) {
                this.mLoadState = 0;
            }
        }
        catch(Throwable v0) {
            this.mInitLock.writeLock().unlock();
            throw v0;
        }

        this.mInitLock.writeLock().unlock();
        if(this.getLoadState() == 0) {
            this.mHelper.loadMetadata();
        }
    }

    void onMetadataLoadFailed(Throwable arg4) {
        ArrayList v0 = new ArrayList();
        this.mInitLock.writeLock().lock();
        int v1 = 2;
        try {
            this.mLoadState = v1;
            ((Collection)v0).addAll(this.mInitCallbacks);
            this.mInitCallbacks.clear();
        }
        catch(Throwable arg4) {
            this.mInitLock.writeLock().unlock();
            throw arg4;
        }

        this.mInitLock.writeLock().unlock();
        this.mMainHandler.post(new ListenerDispatcher(((Collection)v0), this.mLoadState, arg4));
    }

    void onMetadataLoadSuccess() {
        ArrayList v0 = new ArrayList();
        this.mInitLock.writeLock().lock();
        try {
            this.mLoadState = 1;
            ((Collection)v0).addAll(this.mInitCallbacks);
            this.mInitCallbacks.clear();
        }
        catch(Throwable v0_1) {
            this.mInitLock.writeLock().unlock();
            throw v0_1;
        }

        this.mInitLock.writeLock().unlock();
        this.mMainHandler.post(new ListenerDispatcher(((Collection)v0), this.mLoadState));
    }

    public CharSequence process(CharSequence arg5, int arg6, int arg7, int arg8, int arg9) {
        boolean v9;
        Preconditions.checkState(this.isInitialized(), "Not initialized yet");
        Preconditions.checkArgumentNonnegative(arg6, "start cannot be negative");
        Preconditions.checkArgumentNonnegative(arg7, "end cannot be negative");
        Preconditions.checkArgumentNonnegative(arg8, "maxEmojiCount cannot be negative");
        boolean v0 = false;
        boolean v2 = arg6 <= arg7 ? true : false;
        Preconditions.checkArgument(v2, "start should be <= than end");
        if(arg5 == null) {
            return null;
        }

        v2 = arg6 <= arg5.length() ? true : false;
        Preconditions.checkArgument(v2, "start should be < than charSequence length");
        v2 = arg7 <= arg5.length() ? true : false;
        Preconditions.checkArgument(v2, "end should be < than charSequence length");
        if(arg5.length() != 0) {
            if(arg6 == arg7) {
            }
            else {
                if(arg9 != 1) {
                    if(arg9 != 2) {
                        v0 = this.mReplaceAll;
                    }

                    v9 = v0;
                }
                else {
                    v9 = true;
                }

                return this.mHelper.process(arg5, arg6, arg7, arg8, v9);
            }
        }

        return arg5;
    }

    public CharSequence process(CharSequence arg3) {
        int v1 = arg3 == null ? 0 : arg3.length();
        return this.process(arg3, 0, v1);
    }

    public CharSequence process(CharSequence arg2, int arg3, int arg4) {
        return this.process(arg2, arg3, arg4, 0x7FFFFFFF);
    }

    public CharSequence process(CharSequence arg7, int arg8, int arg9, int arg10) {
        return this.process(arg7, arg8, arg9, arg10, 0);
    }

    public void registerInitCallback(InitCallback arg4) {
        Preconditions.checkNotNull(arg4, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        try {
            if(this.mLoadState == 1 || this.mLoadState == 2) {
                this.mMainHandler.post(new ListenerDispatcher(arg4, this.mLoadState));
            }
            else {
                this.mInitCallbacks.add(arg4);
            }
        }
        catch(Throwable v4) {
            this.mInitLock.writeLock().unlock();
            throw v4;
        }

        this.mInitLock.writeLock().unlock();
    }

    public static EmojiCompat reset(Config arg2) {
        Object v0 = EmojiCompat.INSTANCE_LOCK;
        __monitor_enter(v0);
        try {
            EmojiCompat v1 = new EmojiCompat(arg2);
            EmojiCompat.sInstance = v1;
            __monitor_exit(v0);
            return v1;
        label_8:
            __monitor_exit(v0);
        }
        catch(Throwable v2) {
            goto label_8;
        }

        throw v2;
    }

    public static EmojiCompat reset(EmojiCompat arg1) {
        Object v0 = EmojiCompat.INSTANCE_LOCK;
        __monitor_enter(v0);
        try {
            EmojiCompat.sInstance = arg1;
            __monitor_exit(v0);
            return EmojiCompat.sInstance;
        label_7:
            __monitor_exit(v0);
        }
        catch(Throwable v1) {
            goto label_7;
        }

        throw v1;
    }

    public static void skipDefaultConfigurationLookup(boolean arg1) {
        Object v0 = EmojiCompat.CONFIG_LOCK;
        __monitor_enter(v0);
        try {
            EmojiCompat.sHasDoneDefaultConfigLookup = arg1;
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

    public void unregisterInitCallback(InitCallback arg2) {
        Preconditions.checkNotNull(arg2, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        try {
            this.mInitCallbacks.remove(arg2);
        }
        catch(Throwable v2) {
            this.mInitLock.writeLock().unlock();
            throw v2;
        }

        this.mInitLock.writeLock().unlock();
    }

    public void updateEditorInfo(EditorInfo arg2) {
        if(this.isInitialized()) {
            if(arg2 == null) {
            }
            else {
                if(arg2.extras == null) {
                    arg2.extras = new Bundle();
                }

                this.mHelper.updateEditorInfoAttrs(arg2);
            }
        }
    }
}

