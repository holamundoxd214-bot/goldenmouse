package androidx.emoji2.text;

import java.util.concurrent.ThreadPoolExecutor;

public final class EmojiCompatInitializer$BackgroundDefaultLoader$$ExternalSyntheticLambda0 implements Runnable {
    public EmojiCompatInitializer$BackgroundDefaultLoader$$ExternalSyntheticLambda0(BackgroundDefaultLoader arg1, MetadataRepoLoaderCallback arg2, ThreadPoolExecutor arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final void run() {
        this.f$0.lambda$load$0$androidx-emoji2-text-EmojiCompatInitializer$BackgroundDefaultLoader(this.f$1, this.f$2);
    }
}

