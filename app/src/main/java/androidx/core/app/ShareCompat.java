package androidx.core.app;

import android.app.Activity;
import android.content.ClipData$Item;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

public final class ShareCompat {
    public class IntentBuilder {
        private ArrayList mBccAddresses;
        private ArrayList mCcAddresses;
        private CharSequence mChooserTitle;
        private final Context mContext;
        private final Intent mIntent;
        private IntentSender mIntentSender;
        private ArrayList mStreams;
        private ArrayList mToAddresses;

        public IntentBuilder(Context arg4) {
            super();
            this.mContext = Preconditions.checkNotNull(arg4);
            Intent v0 = new Intent().setAction("android.intent.action.SEND");
            this.mIntent = v0;
            v0.putExtra("androidx.core.app.EXTRA_CALLING_PACKAGE", arg4.getPackageName());
            v0.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", arg4.getPackageName());
            v0.addFlags(0x80000);
            while(true) {
                if(!(arg4 instanceof ContextWrapper)) {
                    break;
                }
                else if((arg4 instanceof Activity)) {
                }
                else {
                    arg4 = ((ContextWrapper)arg4).getBaseContext();
                    continue;
                }

                goto label_24;
            }

            arg4 = null;
        label_24:
            if(arg4 != null) {
                ComponentName v4 = ((Activity)arg4).getComponentName();
                this.mIntent.putExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY", ((Parcelable)v4));
                this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", ((Parcelable)v4));
            }
        }

        public IntentBuilder addEmailBcc(String arg2) {
            ArrayList v0 = this.mBccAddresses;
            if(v0 == null) {
                v0 = new ArrayList();
                this.mBccAddresses = v0;
            }

            v0.add(arg2);
            return this;
        }

        public IntentBuilder addEmailBcc(String[] arg2) {
            this.combineArrayExtra("android.intent.extra.BCC", arg2);
            return this;
        }

        public IntentBuilder addEmailCc(String arg2) {
            ArrayList v0 = this.mCcAddresses;
            if(v0 == null) {
                v0 = new ArrayList();
                this.mCcAddresses = v0;
            }

            v0.add(arg2);
            return this;
        }

        public IntentBuilder addEmailCc(String[] arg2) {
            this.combineArrayExtra("android.intent.extra.CC", arg2);
            return this;
        }

        public IntentBuilder addEmailTo(String arg2) {
            ArrayList v0 = this.mToAddresses;
            if(v0 == null) {
                v0 = new ArrayList();
                this.mToAddresses = v0;
            }

            v0.add(arg2);
            return this;
        }

        public IntentBuilder addEmailTo(String[] arg2) {
            this.combineArrayExtra("android.intent.extra.EMAIL", arg2);
            return this;
        }

        public IntentBuilder addStream(Uri arg2) {
            ArrayList v0 = this.mStreams;
            if(v0 == null) {
                v0 = new ArrayList();
                this.mStreams = v0;
            }

            v0.add(arg2);
            return this;
        }

        private void combineArrayExtra(String arg5, ArrayList arg6) {
            String[] v0 = this.mIntent.getStringArrayExtra(arg5);
            int v2 = v0 != null ? v0.length : 0;
            String[] v3 = new String[arg6.size() + v2];
            arg6.toArray(((Object[])v3));
            if(v0 != null) {
                System.arraycopy(v0, 0, v3, arg6.size(), v2);
            }

            this.mIntent.putExtra(arg5, v3);
        }

        private void combineArrayExtra(String arg5, String[] arg6) {
            Intent v4 = this.getIntent();
            String[] v0 = v4.getStringArrayExtra(arg5);
            int v2 = v0 != null ? v0.length : 0;
            String[] v3 = new String[arg6.length + v2];
            if(v0 != null) {
                System.arraycopy(v0, 0, v3, 0, v2);
            }

            System.arraycopy(arg6, 0, v3, v2, arg6.length);
            v4.putExtra(arg5, v3);
        }

        public Intent createChooserIntent() {
            return Intent.createChooser(this.getIntent(), this.mChooserTitle, this.mIntentSender);
        }

        @Deprecated public static IntentBuilder from(Activity arg1) {
            return new IntentBuilder(((Context)arg1));
        }

        Context getContext() {
            return this.mContext;
        }

        public Intent getIntent() {
            ArrayList v0 = this.mToAddresses;
            ArrayList v1 = null;
            if(v0 != null) {
                this.combineArrayExtra("android.intent.extra.EMAIL", v0);
                this.mToAddresses = v1;
            }

            v0 = this.mCcAddresses;
            if(v0 != null) {
                this.combineArrayExtra("android.intent.extra.CC", v0);
                this.mCcAddresses = v1;
            }

            v0 = this.mBccAddresses;
            if(v0 != null) {
                this.combineArrayExtra("android.intent.extra.BCC", v0);
                this.mBccAddresses = v1;
            }

            v0 = this.mStreams;
            String v2 = "android.intent.extra.STREAM";
            if(v0 == null || v0.size() <= 1) {
                this.mIntent.setAction("android.intent.action.SEND");
                v0 = this.mStreams;
                if(v0 != null && !v0.isEmpty()) {
                    this.mIntent.putExtra(v2, this.mStreams.get(0));
                    ShareCompat.migrateExtraStreamToClipData(this.mIntent, this.mStreams);
                    goto label_56;
                }

                this.mIntent.removeExtra(v2);
                this.mIntent.setClipData(((ClipData)v1));
                this.mIntent.setFlags(this.mIntent.getFlags() & -2);
            }
            else {
                this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
                this.mIntent.putParcelableArrayListExtra(v2, this.mStreams);
                ShareCompat.migrateExtraStreamToClipData(this.mIntent, this.mStreams);
            }

        label_56:
            return this.mIntent;
        }

        public IntentBuilder setChooserTitle(int arg2) {
            return this.setChooserTitle(this.mContext.getText(arg2));
        }

        public IntentBuilder setChooserTitle(CharSequence arg1) {
            this.mChooserTitle = arg1;
            return this;
        }

        public IntentBuilder setEmailBcc(String[] arg3) {
            this.mIntent.putExtra("android.intent.extra.BCC", arg3);
            return this;
        }

        public IntentBuilder setEmailCc(String[] arg3) {
            this.mIntent.putExtra("android.intent.extra.CC", arg3);
            return this;
        }

        public IntentBuilder setEmailTo(String[] arg3) {
            if(this.mToAddresses != null) {
                this.mToAddresses = null;
            }

            this.mIntent.putExtra("android.intent.extra.EMAIL", arg3);
            return this;
        }

        public IntentBuilder setHtmlText(String arg3) {
            this.mIntent.putExtra("android.intent.extra.HTML_TEXT", arg3);
            if(!this.mIntent.hasExtra("android.intent.extra.TEXT")) {
                this.setText(Html.fromHtml(arg3));
            }

            return this;
        }

        public IntentBuilder setIntentSender(IntentSender arg1) {
            this.mIntentSender = arg1;
            return this;
        }

        public IntentBuilder setStream(Uri arg2) {
            this.mStreams = null;
            if(arg2 != null) {
                this.addStream(arg2);
            }

            return this;
        }

        public IntentBuilder setSubject(String arg3) {
            this.mIntent.putExtra("android.intent.extra.SUBJECT", arg3);
            return this;
        }

        public IntentBuilder setText(CharSequence arg3) {
            this.mIntent.putExtra("android.intent.extra.TEXT", arg3);
            return this;
        }

        public IntentBuilder setType(String arg2) {
            this.mIntent.setType(arg2);
            return this;
        }

        public void startChooser() {
            this.mContext.startActivity(this.createChooserIntent());
        }
    }

    public class IntentReader {
        private static final String TAG = "IntentReader";
        private final ComponentName mCallingActivity;
        private final String mCallingPackage;
        private final Context mContext;
        private final Intent mIntent;
        private ArrayList mStreams;

        public IntentReader(Activity arg2) {
            this(Preconditions.checkNotNull(arg2), arg2.getIntent());
        }

        public IntentReader(Context arg1, Intent arg2) {
            super();
            this.mContext = Preconditions.checkNotNull(arg1);
            this.mIntent = Preconditions.checkNotNull(arg2);
            this.mCallingPackage = ShareCompat.getCallingPackage(arg2);
            this.mCallingActivity = ShareCompat.getCallingActivity(arg2);
        }

        @Deprecated public static IntentReader from(Activity arg1) {
            return new IntentReader(arg1);
        }

        public ComponentName getCallingActivity() {
            return this.mCallingActivity;
        }

        public Drawable getCallingActivityIcon() {
            Drawable v1 = null;
            if(this.mCallingActivity == null) {
                return v1;
            }

            PackageManager v0 = this.mContext.getPackageManager();
            try {
                return v0.getActivityIcon(this.mCallingActivity);
            }
            catch(PackageManager$NameNotFoundException v3) {
                Log.e("IntentReader", "Could not retrieve icon for calling activity", ((Throwable)v3));
                return v1;
            }
        }

        public Drawable getCallingApplicationIcon() {
            Drawable v1 = null;
            if(this.mCallingPackage == null) {
                return v1;
            }

            PackageManager v0 = this.mContext.getPackageManager();
            try {
                return v0.getApplicationIcon(this.mCallingPackage);
            }
            catch(PackageManager$NameNotFoundException v3) {
                Log.e("IntentReader", "Could not retrieve icon for calling application", ((Throwable)v3));
                return v1;
            }
        }

        public CharSequence getCallingApplicationLabel() {
            CharSequence v1 = null;
            if(this.mCallingPackage == null) {
                return v1;
            }

            PackageManager v0 = this.mContext.getPackageManager();
            try {
                return v0.getApplicationLabel(v0.getApplicationInfo(this.mCallingPackage, 0));
            }
            catch(PackageManager$NameNotFoundException v3) {
                Log.e("IntentReader", "Could not retrieve label for calling application", ((Throwable)v3));
                return v1;
            }
        }

        public String getCallingPackage() {
            return this.mCallingPackage;
        }

        public String[] getEmailBcc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
        }

        public String[] getEmailCc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
        }

        public String[] getEmailTo() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        public String getHtmlText() {
            String v0 = this.mIntent.getStringExtra("android.intent.extra.HTML_TEXT");
            if(v0 == null) {
                CharSequence v2 = this.getText();
                if((v2 instanceof Spanned)) {
                    return Html.toHtml(((Spanned)v2));
                }
                else if(v2 != null) {
                    return Html.escapeHtml(v2);
                }
            }

            return v0;
        }

        public Uri getStream() {
            return this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
        }

        public Uri getStream(int arg4) {
            String v1 = "android.intent.extra.STREAM";
            if(this.mStreams == null && (this.isMultipleShare())) {
                this.mStreams = this.mIntent.getParcelableArrayListExtra(v1);
            }

            ArrayList v0 = this.mStreams;
            if(v0 != null) {
                return v0.get(arg4);
            }

            if(arg4 == 0) {
                return this.mIntent.getParcelableExtra(v1);
            }

            throw new IndexOutOfBoundsException("Stream items available: " + this.getStreamCount() + " index requested: " + arg4);
        }

        public int getStreamCount() {
            String v1 = "android.intent.extra.STREAM";
            if(this.mStreams == null && (this.isMultipleShare())) {
                this.mStreams = this.mIntent.getParcelableArrayListExtra(v1);
            }

            ArrayList v0 = this.mStreams;
            if(v0 != null) {
                return v0.size();
            }

            return this.mIntent.hasExtra(v1);
        }

        public String getSubject() {
            return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
        }

        public CharSequence getText() {
            return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        public String getType() {
            return this.mIntent.getType();
        }

        public boolean isMultipleShare() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
        }

        public boolean isShareIntent() {
            String v1 = this.mIntent.getAction();
            if(!"android.intent.action.SEND".equals(v1)) {
                if("android.intent.action.SEND_MULTIPLE".equals(v1)) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.mIntent.getAction());
        }
    }

    public static final String EXTRA_CALLING_ACTIVITY = "androidx.core.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_ACTIVITY_INTEROP = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "androidx.core.app.EXTRA_CALLING_PACKAGE";
    public static final String EXTRA_CALLING_PACKAGE_INTEROP = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";

    private ShareCompat() {
        super();
    }

    @Deprecated public static void configureMenuItem(Menu arg1, int arg2, IntentBuilder arg3) {
        MenuItem v1 = arg1.findItem(arg2);
        if(v1 != null) {
            ShareCompat.configureMenuItem(v1, arg3);
            return;
        }

        throw new IllegalArgumentException("Could not find menu item with id " + arg2 + " in the supplied menu");
    }

    @Deprecated public static void configureMenuItem(MenuItem arg3, IntentBuilder arg4) {
        ActionProvider v0 = arg3.getActionProvider();
        if(!(v0 instanceof ShareActionProvider)) {
            ShareActionProvider v0_1 = new ShareActionProvider(arg4.getContext());
        }

        ((ShareActionProvider)v0).setShareHistoryFileName(".sharecompat_" + arg4.getContext().getClass().getName());
        ((ShareActionProvider)v0).setShareIntent(arg4.getIntent());
        arg3.setActionProvider(v0);
    }

    public static ComponentName getCallingActivity(Activity arg1) {
        Intent v0 = arg1.getIntent();
        ComponentName v1 = arg1.getCallingActivity();
        if(v1 == null) {
            v1 = ShareCompat.getCallingActivity(v0);
        }

        return v1;
    }

    static ComponentName getCallingActivity(Intent arg1) {
        Parcelable v0 = arg1.getParcelableExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY");
        if(v0 == null) {
            return arg1.getParcelableExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY");
        }

        return ((ComponentName)v0);
    }

    public static String getCallingPackage(Activity arg1) {
        Intent v0 = arg1.getIntent();
        String v1 = arg1.getCallingPackage();
        if(v1 == null && v0 != null) {
            v1 = ShareCompat.getCallingPackage(v0);
        }

        return v1;
    }

    static String getCallingPackage(Intent arg1) {
        String v0 = arg1.getStringExtra("androidx.core.app.EXTRA_CALLING_PACKAGE");
        if(v0 == null) {
            return arg1.getStringExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE");
        }

        return v0;
    }

    static void migrateExtraStreamToClipData(Intent arg8, ArrayList arg9) {
        ClipData v2 = new ClipData(null, new String[]{arg8.getType()}, new ClipData$Item(arg8.getCharSequenceExtra("android.intent.extra.TEXT"), arg8.getStringExtra("android.intent.extra.HTML_TEXT"), null, arg9.get(0)));
        int v0 = arg9.size();
        int v1;
        for(v1 = 1; v1 < v0; ++v1) {
            v2.addItem(new ClipData$Item(arg9.get(v1)));
        }

        arg8.setClipData(v2);
        arg8.addFlags(1);
    }
}

