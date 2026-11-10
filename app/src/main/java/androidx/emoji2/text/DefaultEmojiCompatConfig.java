package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build$VERSION;
import android.util.Log;
import androidx.core.provider.FontRequest;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class DefaultEmojiCompatConfig {
    public class DefaultEmojiCompatConfigFactory {
        private static final String DEFAULT_EMOJI_QUERY = "emojicompat-emoji-font";
        private static final String INTENT_LOAD_EMOJI_FONT = "androidx.content.action.LOAD_EMOJI_FONT";
        private static final String TAG = "emoji2.text.DefaultEmojiConfig";
        private final DefaultEmojiCompatConfigHelper mHelper;

        public DefaultEmojiCompatConfigFactory(DefaultEmojiCompatConfigHelper arg1) {
            super();
            if(arg1 != null) {
            }
            else {
                arg1 = DefaultEmojiCompatConfigFactory.getHelperForApi();
            }

            this.mHelper = arg1;
        }

        private Config configOrNull(Context arg1, FontRequest arg2) {
            if(arg2 == null) {
                return null;
            }

            return new FontRequestEmojiCompatConfig(arg1, arg2);
        }

        private List convertToByteArray(Signature[] arg4) {
            ArrayList v3 = new ArrayList();
            int v0 = arg4.length;
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                ((List)v3).add(arg4[v1].toByteArray());
            }

            return Collections.singletonList(v3);
        }

        public Config create(Context arg2) {
            return this.configOrNull(arg2, this.queryForDefaultFontRequest(arg2));
        }

        private FontRequest generateFontRequestFrom(ProviderInfo arg3, PackageManager arg4) throws PackageManager$NameNotFoundException {
            return new FontRequest(arg3.authority, arg3.packageName, "emojicompat-emoji-font", this.convertToByteArray(this.mHelper.getSigningSignatures(arg4, arg3.packageName)));
        }

        private static DefaultEmojiCompatConfigHelper getHelperForApi() {
            if(Build$VERSION.SDK_INT >= 28) {
                return new DefaultEmojiCompatConfigHelper_API28();
            }

            return new DefaultEmojiCompatConfigHelper_API19();
        }

        private boolean hasFlagSystem(ProviderInfo arg1) {
            if(arg1 != null && arg1.applicationInfo != null && (arg1.applicationInfo.flags & 1) == 1) {
                return 1;
            }

            return 0;
        }

        private ProviderInfo queryDefaultInstalledContentProvider(PackageManager arg4) {
            ProviderInfo v0;
            Iterator v4 = this.mHelper.queryIntentContentProviders(arg4, new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
            do {
                if(!v4.hasNext()) {
                    return null;
                }

                v0 = this.mHelper.getProviderInfo(v4.next());
            }
            while(!this.hasFlagSystem(v0));

            return v0;
        }

        FontRequest queryForDefaultFontRequest(Context arg3) {
            PackageManager v3 = arg3.getPackageManager();
            Preconditions.checkNotNull(v3, "Package manager required to locate emoji font provider");
            ProviderInfo v0 = this.queryDefaultInstalledContentProvider(v3);
            FontRequest v1 = null;
            if(v0 == null) {
                return v1;
            }

            try {
                return this.generateFontRequestFrom(v0, v3);
            }
            catch(PackageManager$NameNotFoundException v2) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", ((Throwable)v2));
                return v1;
            }
        }
    }

    public class DefaultEmojiCompatConfigHelper {
        public DefaultEmojiCompatConfigHelper() {
            super();
        }

        public ProviderInfo getProviderInfo(ResolveInfo arg1) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }

        public Signature[] getSigningSignatures(PackageManager arg1, String arg2) throws PackageManager$NameNotFoundException {
            return arg1.getPackageInfo(arg2, 0x40).signatures;
        }

        public List queryIntentContentProviders(PackageManager arg1, Intent arg2, int arg3) {
            return Collections.emptyList();
        }
    }

    public class DefaultEmojiCompatConfigHelper_API19 extends DefaultEmojiCompatConfigHelper {
        public DefaultEmojiCompatConfigHelper_API19() {
            super();
        }

        public ProviderInfo getProviderInfo(ResolveInfo arg1) {
            return arg1.providerInfo;
        }

        public List queryIntentContentProviders(PackageManager arg1, Intent arg2, int arg3) {
            return arg1.queryIntentContentProviders(arg2, arg3);
        }
    }

    public class DefaultEmojiCompatConfigHelper_API28 extends DefaultEmojiCompatConfigHelper_API19 {
        public DefaultEmojiCompatConfigHelper_API28() {
            super();
        }

        public Signature[] getSigningSignatures(PackageManager arg1, String arg2) throws PackageManager$NameNotFoundException {
            return arg1.getPackageInfo(arg2, 0x40).signatures;
        }
    }

    private DefaultEmojiCompatConfig() {
        super();
    }

    public static FontRequestEmojiCompatConfig create(Context arg2) {
        return new DefaultEmojiCompatConfigFactory(null).create(arg2);
    }
}

