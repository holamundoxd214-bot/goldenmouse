package androidx.profileinstaller;

import android.content.Context;
import android.os.Build$VERSION;
import java.io.File;

class BenchmarkOperation {
    class Api21ContextHelper {
        private Api21ContextHelper() {
            super();
        }

        static File getCodeCacheDir(Context arg0) {
            return arg0.getCodeCacheDir();
        }
    }

    class Api24ContextHelper {
        private Api24ContextHelper() {
            super();
        }

        static Context createDeviceProtectedStorageContext(Context arg0) {
            return arg0.createDeviceProtectedStorageContext();
        }
    }

    private BenchmarkOperation() {
        super();
    }

    static boolean deleteFilesRecursively(File arg6) {
        if(arg6.isDirectory()) {
            File[] v6 = arg6.listFiles();
            if(v6 == null) {
                return 0;
            }

            int v2 = v6.length;
            int v3 = 0;
            boolean v4 = true;
            while(v3 < v2) {
                v4 = !BenchmarkOperation.deleteFilesRecursively(v6[v3]) || !v4 ? false : true;
                ++v3;
            }

            return v4;
        }

        arg6.delete();
        return 1;
    }

    static void dropShaderCache(Context arg2, ResultDiagnostics arg3) {
        File v2 = Build$VERSION.SDK_INT >= 34 ? Api24ContextHelper.createDeviceProtectedStorageContext(arg2).getCacheDir() : Api21ContextHelper.getCodeCacheDir(Api24ContextHelper.createDeviceProtectedStorageContext(arg2));
        Object v0 = null;
        if(BenchmarkOperation.deleteFilesRecursively(v2)) {
            arg3.onResultReceived(14, v0);
            return;
        }

        arg3.onResultReceived(15, v0);
    }
}

