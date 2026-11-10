package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

public class ProfileInstaller {
    class androidx.profileinstaller.ProfileInstaller$1 implements DiagnosticsCallback {
        androidx.profileinstaller.ProfileInstaller$1() {
            super();
        }

        public void onDiagnosticReceived(int arg1, Object arg2) {
        }

        public void onResultReceived(int arg1, Object arg2) {
        }
    }

    class androidx.profileinstaller.ProfileInstaller$2 implements DiagnosticsCallback {
        static final String TAG = "ProfileInstaller";

        androidx.profileinstaller.ProfileInstaller$2() {
            super();
        }

        public void onDiagnosticReceived(int arg1, Object arg2) {
            String v0;
            if(arg1 == 1) {
                v0 = "DIAGNOSTIC_CURRENT_PROFILE_EXISTS";
            }
            else if(arg1 == 2) {
                v0 = "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST";
            }
            else if(arg1 == 3) {
                v0 = "DIAGNOSTIC_REF_PROFILE_EXISTS";
            }
            else if(arg1 == 4) {
                v0 = "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST";
            }
            else if(arg1 != 5) {
                v0 = "";
            }
            else {
                v0 = "DIAGNOSTIC_PROFILE_IS_COMPRESSED";
            }

            Log.d("ProfileInstaller", v0);
        }

        public void onResultReceived(int arg3, Object arg4) {
            String v2;
            switch(arg3) {
                case 1: {
                    v2 = "RESULT_INSTALL_SUCCESS";
                    break;
                }
                case 2: {
                    v2 = "RESULT_ALREADY_INSTALLED";
                    break;
                }
                case 3: {
                    v2 = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                }
                case 4: {
                    v2 = "RESULT_NOT_WRITABLE";
                    break;
                }
                case 5: {
                    v2 = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                }
                case 6: {
                    v2 = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                }
                case 7: {
                    v2 = "RESULT_IO_EXCEPTION";
                    break;
                }
                case 8: {
                    v2 = "RESULT_PARSE_EXCEPTION";
                    break;
                }
                case 10: {
                    v2 = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                }
                case 11: {
                    v2 = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
                }
                default: {
                    v2 = "";
                    break;
                }
            }

            String v1 = "ProfileInstaller";
            if(arg3 != 6 && arg3 != 7 && arg3 != 8) {
                Log.d(v1, v2);
                return;
            }

            Log.e(v1, v2, ((Throwable)arg4));
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface DiagnosticCode {
    }

    public interface DiagnosticsCallback {
        void onDiagnosticReceived(int arg1, Object arg2);

        void onResultReceived(int arg1, Object arg2);
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface ResultCode {
    }

    public static final int DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST = 2;
    public static final int DIAGNOSTIC_CURRENT_PROFILE_EXISTS = 1;
    public static final int DIAGNOSTIC_PROFILE_IS_COMPRESSED = 5;
    public static final int DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST = 4;
    public static final int DIAGNOSTIC_REF_PROFILE_EXISTS = 3;
    private static final DiagnosticsCallback EMPTY_DIAGNOSTICS = null;
    static final DiagnosticsCallback LOG_DIAGNOSTICS = null;
    private static final String PROFILE_BASE_DIR = "/data/misc/profiles/cur/0";
    private static final String PROFILE_FILE = "primary.prof";
    private static final String PROFILE_INSTALLER_SKIP_FILE_NAME = "profileinstaller_profileWrittenFor_lastUpdateTime.dat";
    private static final String PROFILE_META_LOCATION = "dexopt/baseline.profm";
    static final String PROFILE_SOURCE_LOCATION = "dexopt/baseline.prof";
    public static final int RESULT_ALREADY_INSTALLED = 2;
    public static final int RESULT_BASELINE_PROFILE_NOT_FOUND = 6;
    public static final int RESULT_BENCHMARK_OPERATION_FAILURE = 15;
    public static final int RESULT_BENCHMARK_OPERATION_SUCCESS = 14;
    public static final int RESULT_BENCHMARK_OPERATION_UNKNOWN = 16;
    public static final int RESULT_DELETE_SKIP_FILE_SUCCESS = 11;
    public static final int RESULT_DESIRED_FORMAT_UNSUPPORTED = 5;
    public static final int RESULT_INSTALL_SKIP_FILE_SUCCESS = 10;
    public static final int RESULT_INSTALL_SUCCESS = 1;
    public static final int RESULT_IO_EXCEPTION = 7;
    public static final int RESULT_META_FILE_REQUIRED_BUT_NOT_FOUND = 9;
    public static final int RESULT_NOT_WRITABLE = 4;
    public static final int RESULT_PARSE_EXCEPTION = 8;
    public static final int RESULT_SAVE_PROFILE_SIGNALLED = 12;
    public static final int RESULT_SAVE_PROFILE_SKIPPED = 13;
    public static final int RESULT_UNSUPPORTED_ART_VERSION = 3;
    private static final String TAG = "ProfileInstaller";

    static {
        ProfileInstaller.EMPTY_DIAGNOSTICS = new androidx.profileinstaller.ProfileInstaller$1();
        ProfileInstaller.LOG_DIAGNOSTICS = new androidx.profileinstaller.ProfileInstaller$2();
    }

    private ProfileInstaller() {
        super();
    }

    static boolean deleteProfileWrittenFor(File arg2) {
        return new File(arg2, "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
    }

    static void deleteSkipFile(Context arg1, Executor arg2, DiagnosticsCallback arg3) {
        ProfileInstaller.deleteProfileWrittenFor(arg1.getFilesDir());
        ProfileInstaller.result(arg2, arg3, 11, null);
    }

    static void diagnostic(Executor arg1, DiagnosticsCallback arg2, int arg3, Object arg4) {
        arg1.execute(new ProfileInstaller$$ExternalSyntheticLambda1(arg2, arg3, arg4));
    }

    static boolean hasAlreadyWrittenProfileForThisInstall(PackageInfo arg4, File arg5, DiagnosticsCallback arg6) {
        DataInputStream v5;
        File v0 = new File(arg5, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        boolean v1 = false;
        if(!v0.exists()) {
            return 0;
        }

        try {
            v5 = new DataInputStream(new FileInputStream(v0));
        }
        catch(IOException ) {
            return 0;
        }

        try {
            long v2 = v5.readLong();
            goto label_12;
        }
        catch(Throwable v4) {
            try {
                v5.close();
                goto label_26;
            }
            catch(Throwable v5_1) {
                try {
                    v4.addSuppressed(v5_1);
                label_26:
                    throw v4;
                label_12:
                    v5.close();
                }
                catch(IOException ) {
                    return 0;
                }
            }
        }

        if(v2 == arg4.lastUpdateTime) {
            v1 = true;
        }

        if(v1) {
            arg6.onResultReceived(2, null);
        }

        return v1;
    }

    static void lambda$diagnostic$1(DiagnosticsCallback arg0, int arg1, Object arg2) {
        arg0.onDiagnosticReceived(arg1, arg2);
    }

    static void lambda$result$0(DiagnosticsCallback arg0, int arg1, Object arg2) {
        arg0.onResultReceived(arg1, arg2);
    }

    static void noteProfileWrittenFor(PackageInfo arg2, File arg3) {
        DataOutputStream v3;
        File v0 = new File(arg3, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        try {
            v3 = new DataOutputStream(new FileOutputStream(v0));
        }
        catch(IOException ) {
            return;
        }

        try {
            v3.writeLong(arg2.lastUpdateTime);
            goto label_9;
        }
        catch(Throwable v2) {
            try {
                v3.close();
                goto label_16;
            }
            catch(Throwable v3_1) {
                try {
                    v2.addSuppressed(v3_1);
                label_16:
                    throw v2;
                label_9:
                    v3.close();
                    return;
                }
                catch(IOException ) {
                    return;
                }
            }
        }
    }

    static void result(Executor arg1, DiagnosticsCallback arg2, int arg3, Object arg4) {
        arg1.execute(new ProfileInstaller$$ExternalSyntheticLambda0(arg2, arg3, arg4));
    }

    private static boolean transcodeAndWrite(AssetManager arg8, String arg9, PackageInfo arg10, File arg11, String arg12, Executor arg13, DiagnosticsCallback arg14) {
        DeviceProfileWriter v0 = new DeviceProfileWriter(arg8, arg13, arg14, arg12, "dexopt/baseline.prof", "dexopt/baseline.profm", new File(new File("/data/misc/profiles/cur/0", arg9), "primary.prof"));
        if(!v0.deviceAllowsProfileInstallerAotWrites()) {
            return 0;
        }

        boolean v8 = v0.read().transcodeIfNeeded().write();
        if(v8) {
            ProfileInstaller.noteProfileWrittenFor(arg10, arg11);
        }

        return v8;
    }

    static void writeProfile(Context arg9, Executor arg10, DiagnosticsCallback arg11, boolean arg12) {
        Context v0 = arg9.getApplicationContext();
        String v2 = v0.getPackageName();
        ApplicationInfo v1 = v0.getApplicationInfo();
        AssetManager v0_1 = v0.getAssets();
        String v5 = new File(v1.sourceDir).getName();
        PackageManager v1_1 = arg9.getPackageManager();
        boolean v8 = false;
        try {
            PackageInfo v3 = v1_1.getPackageInfo(v2, 0);
        }
        catch(PackageManager$NameNotFoundException v0_2) {
            arg11.onResultReceived(7, v0_2);
            ProfileVerifier.writeProfileVerification(arg9, false);
            return;
        }

        File v4 = arg9.getFilesDir();
        String v1_2 = "ProfileInstaller";
        if(!arg12) {
            if(!ProfileInstaller.hasAlreadyWrittenProfileForThisInstall(v3, v4, arg11)) {
            }
            else {
                Log.d(v1_2, "Skipping profile installation for " + arg9.getPackageName());
                ProfileVerifier.writeProfileVerification(arg9, false);
                return;
            }
        }

        Log.d(v1_2, "Installing profile for " + arg9.getPackageName());
        if((ProfileInstaller.transcodeAndWrite(v0_1, v2, v3, v4, v5, arg10, arg11)) && (arg12)) {
            v8 = true;
        }

        ProfileVerifier.writeProfileVerification(arg9, v8);
    }

    public static void writeProfile(Context arg2) {
        ProfileInstaller.writeProfile(arg2, new ProfileInstallReceiver$$ExternalSyntheticLambda0(), ProfileInstaller.EMPTY_DIAGNOSTICS);
    }

    public static void writeProfile(Context arg1, Executor arg2, DiagnosticsCallback arg3) {
        ProfileInstaller.writeProfile(arg1, arg2, arg3, false);
    }

    static void writeSkipFile(Context arg3, Executor arg4, DiagnosticsCallback arg5) {
        PackageInfo v0_1;
        String v0 = arg3.getApplicationContext().getPackageName();
        PackageManager v1 = arg3.getPackageManager();
        try {
            v0_1 = v1.getPackageInfo(v0, 0);
        }
        catch(PackageManager$NameNotFoundException v3) {
            ProfileInstaller.result(arg4, arg5, 7, v3);
            return;
        }

        ProfileInstaller.noteProfileWrittenFor(v0_1, arg3.getFilesDir());
        ProfileInstaller.result(arg4, arg5, 10, null);
    }
}

