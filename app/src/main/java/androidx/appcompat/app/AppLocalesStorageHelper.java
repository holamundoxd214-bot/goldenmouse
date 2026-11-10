package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build$VERSION;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

class AppLocalesStorageHelper {
    class SerialExecutor implements Executor {
        Runnable mActive;
        final Executor mExecutor;
        private final Object mLock;
        final Queue mTasks;

        SerialExecutor(Executor arg2) {
            super();
            this.mLock = new Object();
            this.mTasks = new ArrayDeque();
            this.mExecutor = arg2;
        }

        public void execute(Runnable arg4) {
            Object v0 = this.mLock;
            __monitor_enter(v0);
            try {
                this.mTasks.add(new AppLocalesStorageHelper$SerialExecutor$$ExternalSyntheticLambda0(this, arg4));
                if(this.mActive == null) {
                    this.scheduleNext();
                }

                __monitor_exit(v0);
                return;
            label_12:
                __monitor_exit(v0);
            }
            catch(Throwable v3) {
                goto label_12;
            }

            throw v3;
        }

        void lambda$execute$0$androidx-appcompat-app-AppLocalesStorageHelper$SerialExecutor(Runnable arg1) {
            try {
                arg1.run();
            }
            catch(Throwable v1) {
                this.scheduleNext();
                throw v1;
            }

            this.scheduleNext();
        }

        protected void scheduleNext() {
            Object v0 = this.mLock;
            __monitor_enter(v0);
            try {
                Object v1 = this.mTasks.poll();
                this.mActive = ((Runnable)v1);
                if(v1 != null) {
                    this.mExecutor.execute(((Runnable)v1));
                }

                __monitor_exit(v0);
                return;
            label_11:
                __monitor_exit(v0);
            }
            catch(Throwable v2) {
                goto label_11;
            }

            throw v2;
        }
    }

    class ThreadPerTaskExecutor implements Executor {
        ThreadPerTaskExecutor() {
            super();
        }

        public void execute(Runnable arg1) {
            new Thread(arg1).start();
        }
    }

    static final String APPLICATION_LOCALES_RECORD_FILE = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file";
    static final String APP_LOCALES_META_DATA_HOLDER_SERVICE_NAME = "androidx.appcompat.app.AppLocalesMetadataHolderService";
    static final String LOCALE_RECORD_ATTRIBUTE_TAG = "application_locales";
    static final String LOCALE_RECORD_FILE_TAG = "locales";
    static final String TAG = "AppLocalesStorageHelper";

    private AppLocalesStorageHelper() {
        super();
    }

    static void persistLocales(Context arg8, String arg9) {
        FileOutputStream v8;
        String v0 = "locales";
        String v1 = "AppLocalesStorageHelper";
        String v2 = "Storing App Locales : app-locales: ";
        String v3 = "Storing App Locales : Failed to persist app-locales: ";
        String v5 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file";
        if(arg9.equals("")) {
            arg8.deleteFile(v5);
            return;
        }

        try {
            v8 = arg8.openFileOutput(v5, 0);
        }
        catch(FileNotFoundException ) {
            Log.w(v1, String.format("Storing App Locales : FileNotFoundException: Cannot open file %s for writing ", v5));
            return;
        }

        XmlSerializer v4 = Xml.newSerializer();
        v5 = null;
        try {
            v4.setOutput(((OutputStream)v8), v5);
            v4.startDocument("UTF-8", Boolean.valueOf(true));
            v4.startTag(v5, v0);
            v4.attribute(v5, "application_locales", arg9);
            v4.endTag(v5, v0);
            v4.endDocument();
            Log.d(v1, v2 + arg9 + " persisted successfully.");
            if(v8 == null) {
                return;
            }
        }
        catch(Throwable v9) {
        label_45:
            if(v8 != null) {
                try {
                    v8.close();
                    goto label_47;
                }
                catch(IOException ) {
                label_47:
                    throw v9;
                }
            }

            goto label_47;
        }
        catch(Exception v0_1) {
            try {
                Log.w(v1, v3 + arg9, ((Throwable)v0_1));
                if(v8 == null) {
                    return;
                }
            }
            catch(Throwable v9) {
                goto label_45;
            }

            try {
                v8.close();
            }
            catch(IOException ) {
            }

            return;
        }

        try {
            v8.close();
            return;
        }
        catch(IOException ) {
            return;
        }
    }

    static String readLocales(Context arg9) {
        FileInputStream v3;
        String v0 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file";
        String v1 = "AppLocalesStorageHelper";
        String v2 = "";
        try {
            v3 = arg9.openFileInput(v0);
        }
        catch(FileNotFoundException ) {
            Log.w(v1, "Reading app Locales : Locales record file not found: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
            return v2;
        }

        try {
            XmlPullParser v4 = Xml.newPullParser();
            v4.setInput(((InputStream)v3), "UTF-8");
            int v5 = v4.getDepth();
            do {
                int v6 = v4.next();
                if(v6 != 1) {
                    int v7 = 3;
                    if(v6 == v7 && v4.getDepth() <= v5) {
                        goto label_26;
                    }

                    if(v6 == v7) {
                        continue;
                    }

                    if(v6 == 4) {
                        continue;
                    }

                    if(!v4.getName().equals("locales")) {
                        continue;
                    }

                    break;
                }

                goto label_26;
            }
            while(true);

            v2 = v4.getAttributeValue(null, "application_locales");
        }
        catch(Throwable v9) {
            goto label_46;
        }
        catch(IOException ) {
            goto label_31;
        }

    label_26:
        if(v3 == null) {
            goto label_35;
        }

        goto label_27;
        try {
        label_31:
            Log.w(v1, "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
            if(v3 == null) {
                goto label_35;
            }
        }
        catch(Throwable v9) {
            goto label_46;
        }

        try {
        label_27:
            v3.close();
            goto label_35;
        }
        catch(IOException ) {
        label_35:
            if(!v2.isEmpty()) {
                Log.d(v1, "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: " + v2);
            }
            else {
                arg9.deleteFile(v0);
            }

            return v2;
        }

    label_46:
        if(v3 != null) {
            try {
                v3.close();
                goto label_48;
            }
            catch(IOException ) {
            label_48:
                throw v9;
            }
        }

        goto label_48;
    }

    static void syncLocalesToFramework(Context arg4) {
        if(Build$VERSION.SDK_INT >= 33) {
            ComponentName v0 = new ComponentName(arg4, "androidx.appcompat.app.AppLocalesMetadataHolderService");
            if(arg4.getPackageManager().getComponentEnabledSetting(v0) != 1) {
                if(AppCompatDelegate.getApplicationLocales().isEmpty()) {
                    String v1 = AppLocalesStorageHelper.readLocales(arg4);
                    Object v3 = arg4.getSystemService("locale");
                    if(v3 != null) {
                        Api33Impl.localeManagerSetApplicationLocales(v3, Api24Impl.localeListForLanguageTags(v1));
                    }
                }

                arg4.getPackageManager().setComponentEnabledSetting(v0, 1, 1);
            }
        }
    }
}

