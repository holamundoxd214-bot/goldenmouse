package androidx.core.app;

import android.app.RemoteInput$Builder;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Build$VERSION;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class RemoteInput {
    class Api20Impl {
        private Api20Impl() {
            super();
        }

        public static android.app.RemoteInput fromCompat(RemoteInput arg4) {
            RemoteInput$Builder v0 = new RemoteInput$Builder(arg4.getResultKey()).setLabel(arg4.getLabel()).setChoices(arg4.getChoices()).setAllowFreeFormInput(arg4.getAllowFreeFormInput()).addExtras(arg4.getExtras());
            Set v1 = arg4.getAllowedDataTypes();
            if(v1 != null) {
                Iterator v1_1 = v1.iterator();
                while(v1_1.hasNext()) {
                    Api26Impl.setAllowDataType(v0, v1_1.next(), true);
                }
            }

            if(Build$VERSION.SDK_INT >= 29) {
                Api29Impl.setEditChoicesBeforeSending(v0, arg4.getEditChoicesBeforeSending());
            }

            return v0.build();
        }

        static RemoteInput fromPlatform(Object arg4) {
            Builder v0 = new Builder(((android.app.RemoteInput)arg4).getResultKey()).setLabel(((android.app.RemoteInput)arg4).getLabel()).setChoices(((android.app.RemoteInput)arg4).getChoices()).setAllowFreeFormInput(((android.app.RemoteInput)arg4).getAllowFreeFormInput()).addExtras(((android.app.RemoteInput)arg4).getExtras());
            Set v1 = Api26Impl.getAllowedDataTypes(arg4);
            if(v1 != null) {
                Iterator v1_1 = v1.iterator();
                while(v1_1.hasNext()) {
                    v0.setAllowDataType(v1_1.next(), true);
                }
            }

            if(Build$VERSION.SDK_INT >= 29) {
                v0.setEditChoicesBeforeSending(Api29Impl.getEditChoicesBeforeSending(arg4));
            }

            return v0.build();
        }
    }

    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static void addDataResultToIntent(RemoteInput arg0, Intent arg1, Map arg2) {
            android.app.RemoteInput.addDataResultToIntent(RemoteInput.fromCompat(arg0), arg1, arg2);
        }

        static Set getAllowedDataTypes(Object arg0) {
            return ((android.app.RemoteInput)arg0).getAllowedDataTypes();
        }

        static Map getDataResultsFromIntent(Intent arg0, String arg1) {
            return android.app.RemoteInput.getDataResultsFromIntent(arg0, arg1);
        }

        static RemoteInput$Builder setAllowDataType(RemoteInput$Builder arg0, String arg1, boolean arg2) {
            return arg0.setAllowDataType(arg1, arg2);
        }
    }

    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static int getResultsSource(Intent arg0) {
            return android.app.RemoteInput.getResultsSource(arg0);
        }

        static void setResultsSource(Intent arg0, int arg1) {
            android.app.RemoteInput.setResultsSource(arg0, arg1);
        }
    }

    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static int getEditChoicesBeforeSending(Object arg0) {
            return ((android.app.RemoteInput)arg0).getEditChoicesBeforeSending();
        }

        static RemoteInput$Builder setEditChoicesBeforeSending(RemoteInput$Builder arg0, int arg1) {
            return arg0.setEditChoicesBeforeSending(arg1);
        }
    }

    public final class Builder {
        private boolean mAllowFreeFormTextInput;
        private final Set mAllowedDataTypes;
        private CharSequence[] mChoices;
        private int mEditChoicesBeforeSending;
        private final Bundle mExtras;
        private CharSequence mLabel;
        private final String mResultKey;

        public Builder(String arg2) {
            super();
            this.mAllowedDataTypes = new HashSet();
            this.mExtras = new Bundle();
            this.mAllowFreeFormTextInput = true;
            this.mEditChoicesBeforeSending = 0;
            if(arg2 != null) {
                this.mResultKey = arg2;
                return;
            }

            throw new IllegalArgumentException("Result key can\'t be null");
        }

        public Builder addExtras(Bundle arg2) {
            if(arg2 != null) {
                this.mExtras.putAll(arg2);
            }

            return this;
        }

        public RemoteInput build() {
            return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormTextInput, this.mEditChoicesBeforeSending, this.mExtras, this.mAllowedDataTypes);
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public Builder setAllowDataType(String arg2, boolean arg3) {
            Set v0 = this.mAllowedDataTypes;
            if(arg3) {
                v0.add(arg2);
                return this;
            }

            v0.remove(arg2);
            return this;
        }

        public Builder setAllowFreeFormInput(boolean arg1) {
            this.mAllowFreeFormTextInput = arg1;
            return this;
        }

        public Builder setChoices(CharSequence[] arg1) {
            this.mChoices = arg1;
            return this;
        }

        public Builder setEditChoicesBeforeSending(int arg1) {
            this.mEditChoicesBeforeSending = arg1;
            return this;
        }

        public Builder setLabel(CharSequence arg1) {
            this.mLabel = arg1;
            return this;
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface EditChoicesBeforeSending {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface Source {
    }

    public static final int EDIT_CHOICES_BEFORE_SENDING_AUTO = 0;
    public static final int EDIT_CHOICES_BEFORE_SENDING_DISABLED = 1;
    public static final int EDIT_CHOICES_BEFORE_SENDING_ENABLED = 2;
    private static final String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    private static final String EXTRA_RESULTS_SOURCE = "android.remoteinput.resultsSource";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    public static final int SOURCE_CHOICE = 1;
    public static final int SOURCE_FREE_FORM_INPUT;
    private final boolean mAllowFreeFormTextInput;
    private final Set mAllowedDataTypes;
    private final CharSequence[] mChoices;
    private final int mEditChoicesBeforeSending;
    private final Bundle mExtras;
    private final CharSequence mLabel;
    private final String mResultKey;

    RemoteInput(String arg1, CharSequence arg2, CharSequence[] arg3, boolean arg4, int arg5, Bundle arg6, Set arg7) {
        super();
        this.mResultKey = arg1;
        this.mLabel = arg2;
        this.mChoices = arg3;
        this.mAllowFreeFormTextInput = arg4;
        this.mEditChoicesBeforeSending = arg5;
        this.mExtras = arg6;
        this.mAllowedDataTypes = arg7;
        if(this.getEditChoicesBeforeSending() == 2) {
            if(this.getAllowFreeFormInput()) {
            }
            else {
                throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
            }
        }
    }

    public static void addDataResultToIntent(RemoteInput arg0, Intent arg1, Map arg2) {
        Api26Impl.addDataResultToIntent(arg0, arg1, arg2);
    }

    public static void addResultsToIntent(RemoteInput[] arg0, Intent arg1, Bundle arg2) {
        android.app.RemoteInput.addResultsToIntent(RemoteInput.fromCompat(arg0), arg1, arg2);
    }

    static android.app.RemoteInput[] fromCompat(RemoteInput[] arg3) {
        if(arg3 == null) {
            return null;
        }

        android.app.RemoteInput[] v0 = new android.app.RemoteInput[arg3.length];
        int v1;
        for(v1 = 0; v1 < arg3.length; ++v1) {
            v0[v1] = RemoteInput.fromCompat(arg3[v1]);
        }

        return v0;
    }

    static android.app.RemoteInput fromCompat(RemoteInput arg0) {
        return Api20Impl.fromCompat(arg0);
    }

    static RemoteInput fromPlatform(android.app.RemoteInput arg0) {
        return Api20Impl.fromPlatform(arg0);
    }

    public boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormTextInput;
    }

    public Set getAllowedDataTypes() {
        return this.mAllowedDataTypes;
    }

    public CharSequence[] getChoices() {
        return this.mChoices;
    }

    private static Intent getClipDataIntentFromIntent(Intent arg3) {
        ClipData v3 = arg3.getClipData();
        Intent v0 = null;
        if(v3 == null) {
            return v0;
        }

        ClipDescription v1 = v3.getDescription();
        if(!v1.hasMimeType("text/vnd.android.intent")) {
            return v0;
        }

        if(!v1.getLabel().toString().contentEquals("android.remoteinput.results")) {
            return v0;
        }

        return v3.getItemAt(0).getIntent();
    }

    public static Map getDataResultsFromIntent(Intent arg0, String arg1) {
        return Api26Impl.getDataResultsFromIntent(arg0, arg1);
    }

    public int getEditChoicesBeforeSending() {
        return this.mEditChoicesBeforeSending;
    }

    private static String getExtraResultsKeyForData(String arg2) {
        return "android.remoteinput.dataTypeResultsData" + arg2;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public CharSequence getLabel() {
        return this.mLabel;
    }

    public String getResultKey() {
        return this.mResultKey;
    }

    public static Bundle getResultsFromIntent(Intent arg0) {
        return android.app.RemoteInput.getResultsFromIntent(arg0);
    }

    public static int getResultsSource(Intent arg2) {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.getResultsSource(arg2);
        }

        arg2 = RemoteInput.getClipDataIntentFromIntent(arg2);
        if(arg2 == null) {
            return 0;
        }

        return arg2.getExtras().getInt("android.remoteinput.resultsSource", 0);
    }

    public boolean isDataOnly() {
        if(!this.getAllowFreeFormInput() && (this.getChoices() == null || this.getChoices().length == 0) && this.getAllowedDataTypes() != null && !this.getAllowedDataTypes().isEmpty()) {
            return 1;
        }

        return 0;
    }

    public static void setResultsSource(Intent arg2, int arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            Api28Impl.setResultsSource(arg2, arg3);
            return;
        }

        Intent v0 = RemoteInput.getClipDataIntentFromIntent(arg2);
        if(v0 == null) {
            v0 = new Intent();
        }

        v0.putExtra("android.remoteinput.resultsSource", arg3);
        arg2.setClipData(ClipData.newIntent("android.remoteinput.results", v0));
    }
}

