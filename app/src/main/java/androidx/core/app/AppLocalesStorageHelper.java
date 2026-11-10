package androidx.core.app;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class AppLocalesStorageHelper {
    static final String APPLICATION_LOCALES_RECORD_FILE = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file";
    static final boolean DEBUG = false;
    static final String LOCALE_RECORD_ATTRIBUTE_TAG = "application_locales";
    static final String LOCALE_RECORD_FILE_TAG = "locales";
    static final String TAG = "AppLocalesStorageHelper";
    private static final Object sAppLocaleStorageSync;

    static {
        AppLocalesStorageHelper.sAppLocaleStorageSync = new Object();
    }

    private AppLocalesStorageHelper() {
        super();
    }

    public static void persistLocales(Context arg5, String arg6) {
        String v2;
        XmlSerializer v1;
        FileOutputStream v5_1;
        Object v0 = AppLocalesStorageHelper.sAppLocaleStorageSync;
        __monitor_enter(v0);
        try {
            if(arg6.equals("")) {
                arg5.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                __monitor_exit(v0);
                return;
            }

            try {
                v5_1 = arg5.openFileOutput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file", 0);
                goto label_12;
            }
            catch(FileNotFoundException ) {
                try {
                    Log.w("AppLocalesStorageHelper", String.format("Storing App Locales : FileNotFoundException: Cannot open file %s for writing ", "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"));
                    __monitor_exit(v0);
                    return;
                label_12:
                    v1 = Xml.newSerializer();
                    v2 = null;
                }
                catch(Throwable v5) {
                    goto label_51;
                }
            }
        }
        catch(Throwable v5) {
            goto label_51;
        }

        try {
            v1.setOutput(((OutputStream)v5_1), v2);
            v1.startDocument("UTF-8", Boolean.valueOf(true));
            v1.startTag(v2, "locales");
            v1.attribute(v2, "application_locales", arg6);
            v1.endTag(v2, "locales");
            v1.endDocument();
            if(v5_1 == null) {
                goto label_37;
            }
        }
        catch(Throwable v6) {
        label_39:
            if(v5_1 != null) {
                try {
                    v5_1.close();
                    goto label_41;
                }
                catch(IOException ) {
                label_41:
                    throw v6;
                }
            }

            goto label_41;
        }
        catch(Exception v6_1) {
            try {
                Log.w("AppLocalesStorageHelper", "Storing App Locales : Failed to persist app-locales in storage ", ((Throwable)v6_1));
                if(v5_1 == null) {
                    goto label_37;
                }
            }
            catch(Throwable v6) {
                goto label_39;
            }
        }

        try {
            v5_1.close();
            goto label_37;
        }
        catch(Throwable v5) {
        label_52:
            throw v5;
        }
        catch(IOException ) {
            try {
            label_37:
                __monitor_exit(v0);
                return;
            label_51:
                __monitor_exit(v0);
                goto label_52;
            }
            catch(Throwable v5) {
                goto label_51;
            }
        }
    }

    public static String readLocales(Context arg8) {
        FileInputStream v2;
        String v1;
        Object v0 = AppLocalesStorageHelper.sAppLocaleStorageSync;
        __monitor_enter(v0);
        try {
            v1 = "";
            try {
                v2 = arg8.openFileInput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
            }
            catch(FileNotFoundException ) {
                try {
                    __monitor_exit(v0);
                    return v1;
                }
                catch(Throwable v8) {
                    goto label_50;
                }
            }
        }
        catch(Throwable v8) {
            goto label_50;
        }

        try {
            XmlPullParser v3 = Xml.newPullParser();
            v3.setInput(((InputStream)v2), "UTF-8");
            int v4 = v3.getDepth();
            do {
                int v5 = v3.next();
                if(v5 != 1) {
                    int v6 = 3;
                    if(v5 == v6 && v3.getDepth() <= v4) {
                        goto label_27;
                    }

                    if(v5 == v6) {
                        continue;
                    }

                    if(v5 == 4) {
                        continue;
                    }

                    if(!v3.getName().equals("locales")) {
                        continue;
                    }

                    break;
                }

                goto label_27;
            }
            while(true);

            v1 = v3.getAttributeValue(null, "application_locales");
        }
        catch(XmlPullParserException ) {
            goto label_32;
        }
        catch(Throwable v8) {
            goto label_44;
        }

    label_27:
        if(v2 == null) {
            goto label_37;
        }

        goto label_28;
        try {
        label_32:
            Log.w("AppLocalesStorageHelper", "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
            if(v2 == null) {
                goto label_37;
            }
        }
        catch(Throwable v8) {
            goto label_44;
        }

        try {
        label_28:
            v2.close();
            goto label_37;
        }
        catch(Throwable v8) {
        label_50:
            __monitor_exit(v0);
            throw v8;
        }
        catch(IOException ) {
            try {
            label_37:
                if(!v1.isEmpty()) {
                }
                else {
                    arg8.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                }

                __monitor_exit(v0);
                return v1;
            }
            catch(Throwable v8) {
                goto label_50;
            }

        label_44:
            if(v2 != null) {
                try {
                    v2.close();
                    goto label_46;
                }
                catch(IOException ) {
                label_46:
                    throw v8;
                }
            }

            goto label_46;
        }
    }
}

