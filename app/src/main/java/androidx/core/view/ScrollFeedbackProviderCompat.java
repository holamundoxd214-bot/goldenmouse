package androidx.core.view;

import android.os.Build$VERSION;
import android.view.ScrollFeedbackProvider;
import android.view.View;

public class ScrollFeedbackProviderCompat {
    class ScrollFeedbackProviderApi35Impl implements ScrollFeedbackProviderImpl {
        private final ScrollFeedbackProvider mProvider;

        ScrollFeedbackProviderApi35Impl(View arg1) {
            super();
            this.mProvider = ScrollFeedbackProvider.createProvider(arg1);
        }

        public void onScrollLimit(int arg1, int arg2, int arg3, boolean arg4) {
            this.mProvider.onScrollLimit(arg1, arg2, arg3, arg4);
        }

        public void onScrollProgress(int arg1, int arg2, int arg3, int arg4) {
            this.mProvider.onScrollProgress(arg1, arg2, arg3, arg4);
        }

        public void onSnapToItem(int arg1, int arg2, int arg3) {
            this.mProvider.onSnapToItem(arg1, arg2, arg3);
        }
    }

    class ScrollFeedbackProviderBaseImpl implements ScrollFeedbackProviderImpl {
        ScrollFeedbackProviderBaseImpl(ScrollFeedbackProviderCompat-IA arg1) {
            this();
        }

        private ScrollFeedbackProviderBaseImpl() {
            super();
        }

        public void onScrollLimit(int arg1, int arg2, int arg3, boolean arg4) {
        }

        public void onScrollProgress(int arg1, int arg2, int arg3, int arg4) {
        }

        public void onSnapToItem(int arg1, int arg2, int arg3) {
        }
    }

    interface ScrollFeedbackProviderImpl {
        void onScrollLimit(int arg1, int arg2, int arg3, boolean arg4);

        void onScrollProgress(int arg1, int arg2, int arg3, int arg4);

        void onSnapToItem(int arg1, int arg2, int arg3);
    }

    private final ScrollFeedbackProviderImpl mImpl;

    private ScrollFeedbackProviderCompat(View arg3) {
        super();
        if(Build$VERSION.SDK_INT >= 35) {
            this.mImpl = new ScrollFeedbackProviderApi35Impl(arg3);
            return;
        }

        this.mImpl = new ScrollFeedbackProviderBaseImpl(null);
    }

    public static ScrollFeedbackProviderCompat createProvider(View arg1) {
        return new ScrollFeedbackProviderCompat(arg1);
    }

    public void onScrollLimit(int arg1, int arg2, int arg3, boolean arg4) {
        this.mImpl.onScrollLimit(arg1, arg2, arg3, arg4);
    }

    public void onScrollProgress(int arg1, int arg2, int arg3, int arg4) {
        this.mImpl.onScrollProgress(arg1, arg2, arg3, arg4);
    }

    public void onSnapToItem(int arg1, int arg2, int arg3) {
        this.mImpl.onSnapToItem(arg1, arg2, arg3);
    }
}

