package androidx.emoji2.text;

import android.os.Build$VERSION;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

class EmojiExclusions {
    class EmojiExclusions_Api34 {
        private EmojiExclusions_Api34() {
            super();
        }

        static Set getExclusions() {
            return EmojiExclusions_Reflections.getExclusions();
        }
    }

    class EmojiExclusions_Reflections {
        private EmojiExclusions_Reflections() {
            super();
        }

        static Set getExclusions() {
            Object v0;
            try {
                v0 = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet").invoke(null);
                if(v0 == null) {
                    return Collections.emptySet();
                }

                Iterator v1 = ((Set)v0).iterator();
                do {
                    if(v1.hasNext()) {
                        if((v1.next() instanceof int[])) {
                            continue;
                        }

                        break;
                    }

                    goto label_19;
                }
                while(true);

                Set v0_1 = Collections.emptySet();
            }
            catch(Throwable ) {
                goto label_20;
            }

        label_19:
            return ((Set)v0);
        label_20:
            return Collections.emptySet();
        }
    }

    private EmojiExclusions() {
        super();
    }

    static Set getEmojiExclusions() {
        if(Build$VERSION.SDK_INT >= 34) {
            return EmojiExclusions_Api34.getExclusions();
        }

        return EmojiExclusions_Reflections.getExclusions();
    }
}

