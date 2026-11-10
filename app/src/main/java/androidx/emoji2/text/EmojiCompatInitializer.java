package androidx.emoji2.text;

import android.content.Context;
import androidx.core.os.TraceCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class EmojiCompatInitializer implements Initializer {
    class BackgroundDefaultConfig extends Config {
        protected BackgroundDefaultConfig(Context arg2) {
            super(new BackgroundDefaultLoader(arg2));
            this.setMetadataLoadStrategy(1);
        }
    }

    class BackgroundDefaultLoader implements MetadataRepoLoader {
        private final Context mContext;

        BackgroundDefaultLoader(Context arg1) {
            super();
            this.mContext = arg1.getApplicationContext();
        }

        void doLoad(MetadataRepoLoaderCallback arg3, ThreadPoolExecutor arg4) {
            try {
                FontRequestEmojiCompatConfig v0 = DefaultEmojiCompatConfig.create(this.mContext);
                if(v0 != null) {
                    v0.setLoadingExecutor(((Executor)arg4));
                    v0.getMetadataRepoLoader().load(new MetadataRepoLoaderCallback(arg3, arg4) {
                        public void onFailed(Throwable arg2) {
                            try {
                                this.val$loaderCallback.onFailed(arg2);
                            }
                            catch(Throwable arg2) {
                                this.val$executor.shutdown();
                                throw arg2;
                            }

                            this.val$executor.shutdown();
                        }

                        public void onLoaded(MetadataRepo arg2) {
                            try {
                                this.val$loaderCallback.onLoaded(arg2);
                            }
                            catch(Throwable v2) {
                                this.val$executor.shutdown();
                                throw v2;
                            }

                            this.val$executor.shutdown();
                        }
                    });
                    return;
                }

                throw new RuntimeException("EmojiCompat font provider not available on this device.");
            }
            catch(Throwable v2) {
                arg3.onFailed(v2);
                arg4.shutdown();
                return;
            }
        }

        void lambda$load$0$androidx-emoji2-text-EmojiCompatInitializer$BackgroundDefaultLoader(MetadataRepoLoaderCallback arg1, ThreadPoolExecutor arg2) {
            this.doLoad(arg1, arg2);
        }

        public void load(MetadataRepoLoaderCallback arg3) {
            ThreadPoolExecutor v0 = ConcurrencyHelpers.createBackgroundPriorityExecutor("EmojiCompatInitializer");
            v0.execute(new EmojiCompatInitializer$BackgroundDefaultLoader$$ExternalSyntheticLambda0(this, arg3, v0));
        }
    }

    class LoadEmojiCompatRunnable implements Runnable {
        LoadEmojiCompatRunnable() {
            super();
        }

        public void run() {
            try {
                TraceCompat.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                if(EmojiCompat.isConfigured()) {
                    EmojiCompat.get().load();
                }
            }
            catch(Throwable v0) {
                TraceCompat.endSection();
                throw v0;
            }

            TraceCompat.endSection();
        }
    }

    private static final long STARTUP_THREAD_CREATION_DELAY_MS = 500;
    private static final String S_INITIALIZER_THREAD_NAME = "EmojiCompatInitializer";

    public EmojiCompatInitializer() {
        super();
    }

    public Boolean create(Context arg2) {
        EmojiCompat.init(new BackgroundDefaultConfig(arg2));
        this.delayUntilFirstResume(arg2);
        return Boolean.valueOf(true);
    }

    public Object create(Context arg1) {
        return this.create(arg1);
    }

    void delayUntilFirstResume(Context arg2) {
        Lifecycle v2 = AppInitializer.getInstance(arg2).initializeComponent(ProcessLifecycleInitializer.class).getLifecycle();
        v2.addObserver(new DefaultLifecycleObserver(v2) {
            public void onResume(LifecycleOwner arg1) {
                EmojiCompatInitializer.this.loadEmojiCompatAfterDelay();
                this.val$lifecycle.removeObserver(((LifecycleObserver)this));
            }
        });
    }

    public List dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    void loadEmojiCompatAfterDelay() {
        ConcurrencyHelpers.mainHandlerAsync().postDelayed(new LoadEmojiCompatRunnable(), 500);
    }
}

