package androidx.emoji2.viewsintegration;

import android.text.Editable$Factory;
import android.text.Editable;
import androidx.emoji2.text.SpannableBuilder;

final class EmojiEditableFactory extends Editable$Factory {
    private static final Object INSTANCE_LOCK;
    private static volatile Editable$Factory sInstance;
    private static Class sWatcherClass;

    static {
        EmojiEditableFactory.INSTANCE_LOCK = new Object();
    }

    private EmojiEditableFactory() {
        super();
        try {
            EmojiEditableFactory.sWatcherClass = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, this.getClass().getClassLoader());
            return;
        }
        catch(Throwable ) {
            return;
        }
    }

    public static Editable$Factory getInstance() {
        if(EmojiEditableFactory.sInstance == null) {
            Object v0 = EmojiEditableFactory.INSTANCE_LOCK;
            __monitor_enter(v0);
            try {
                if(EmojiEditableFactory.sInstance == null) {
                    EmojiEditableFactory.sInstance = new EmojiEditableFactory();
                }

                __monitor_exit(v0);
                goto label_14;
            label_12:
                __monitor_exit(v0);
            }
            catch(Throwable v1) {
                goto label_12;
            }

            throw v1;
        }

    label_14:
        return EmojiEditableFactory.sInstance;
    }

    public Editable newEditable(CharSequence arg2) {
        Class v0 = EmojiEditableFactory.sWatcherClass;
        if(v0 != null) {
            return SpannableBuilder.create(v0, arg2);
        }

        return super.newEditable(arg2);
    }
}

