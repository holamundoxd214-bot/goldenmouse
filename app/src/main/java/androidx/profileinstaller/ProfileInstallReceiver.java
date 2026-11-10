package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;

public class ProfileInstallReceiver extends BroadcastReceiver {
    class ResultDiagnostics implements DiagnosticsCallback {
        ResultDiagnostics(ProfileInstallReceiver arg1) {
            ProfileInstallReceiver.this = arg1;
            super();
        }

        public void onDiagnosticReceived(int arg1, Object arg2) {
            ProfileInstaller.LOG_DIAGNOSTICS.onDiagnosticReceived(arg1, arg2);
        }

        public void onResultReceived(int arg2, Object arg3) {
            ProfileInstaller.LOG_DIAGNOSTICS.onResultReceived(arg2, arg3);
            ProfileInstallReceiver.this.setResultCode(arg2);
        }
    }

    public static final String ACTION_BENCHMARK_OPERATION = "androidx.profileinstaller.action.BENCHMARK_OPERATION";
    public static final String ACTION_INSTALL_PROFILE = "androidx.profileinstaller.action.INSTALL_PROFILE";
    public static final String ACTION_SAVE_PROFILE = "androidx.profileinstaller.action.SAVE_PROFILE";
    public static final String ACTION_SKIP_FILE = "androidx.profileinstaller.action.SKIP_FILE";
    private static final String EXTRA_BENCHMARK_OPERATION = "EXTRA_BENCHMARK_OPERATION";
    private static final String EXTRA_BENCHMARK_OPERATION_DROP_SHADER_CACHE = "DROP_SHADER_CACHE";
    private static final String EXTRA_SKIP_FILE_OPERATION = "EXTRA_SKIP_FILE_OPERATION";
    private static final String EXTRA_SKIP_FILE_OPERATION_DELETE = "DELETE_SKIP_FILE";
    private static final String EXTRA_SKIP_FILE_OPERATION_WRITE = "WRITE_SKIP_FILE";

    public ProfileInstallReceiver() {
        super();
    }

    public void onReceive(Context arg3, Intent arg4) {
        String v4_1;
        Bundle v4;
        if(arg4 == null) {
        }
        else {
            String v0 = arg4.getAction();
            if("androidx.profileinstaller.action.INSTALL_PROFILE".equals(v0)) {
                ProfileInstaller.writeProfile(arg3, new ProfileInstallReceiver$$ExternalSyntheticLambda0(), new ResultDiagnostics(this), true);
                return;
            }
            else if("androidx.profileinstaller.action.SKIP_FILE".equals(v0)) {
                v4 = arg4.getExtras();
                if(v4 != null) {
                    v4_1 = v4.getString("EXTRA_SKIP_FILE_OPERATION");
                    if("WRITE_SKIP_FILE".equals(v4_1)) {
                        ProfileInstaller.writeSkipFile(arg3, new ProfileInstallReceiver$$ExternalSyntheticLambda0(), new ResultDiagnostics(this));
                        return;
                    }
                    else if("DELETE_SKIP_FILE".equals(v4_1)) {
                        ProfileInstaller.deleteSkipFile(arg3, new ProfileInstallReceiver$$ExternalSyntheticLambda0(), new ResultDiagnostics(this));
                        return;
                    }
                }
            }
            else if("androidx.profileinstaller.action.SAVE_PROFILE".equals(v0)) {
                ProfileInstallReceiver.saveProfile(new ResultDiagnostics(this));
                return;
            }
            else if("androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(v0)) {
                v4 = arg4.getExtras();
                if(v4 != null) {
                    v4_1 = v4.getString("EXTRA_BENCHMARK_OPERATION");
                    ResultDiagnostics v0_1 = new ResultDiagnostics(this);
                    if("DROP_SHADER_CACHE".equals(v4_1)) {
                        BenchmarkOperation.dropShaderCache(arg3, v0_1);
                        return;
                    }
                    else {
                        v0_1.onResultReceived(16, null);
                    }
                }
            }
        }
    }

    static void saveProfile(DiagnosticsCallback arg2) {
        Process.sendSignal(Process.myPid(), 10);
        arg2.onResultReceived(12, null);
    }
}

