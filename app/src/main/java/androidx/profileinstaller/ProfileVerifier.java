package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageManager$PackageInfoFlags;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.os.Build$VERSION;
import androidx.concurrent.futures.ResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

public final class ProfileVerifier {
    class Api33Impl {
        private Api33Impl() {
            super();
        }

        static PackageInfo getPackageInfo(PackageManager arg2, Context arg3) throws PackageManager$NameNotFoundException {
            return arg2.getPackageInfo(arg3.getPackageName(), PackageManager$PackageInfoFlags.of(0));
        }
    }

    class Cache {
        private static final int SCHEMA = 1;
        final long mInstalledCurrentProfileSize;
        final long mPackageLastUpdateTime;
        final int mResultCode;
        final int mSchema;

        Cache(int arg1, int arg2, long arg3, long arg5) {
            super();
            this.mSchema = arg1;
            this.mResultCode = arg2;
            this.mPackageLastUpdateTime = arg3;
            this.mInstalledCurrentProfileSize = arg5;
        }

        public boolean equals(Object arg7) {
            if(this == (((Cache)arg7))) {
                return 1;
            }

            if(arg7 != null) {
                if(!(arg7 instanceof Cache)) {
                }
                else if(this.mResultCode == ((Cache)arg7).mResultCode && this.mPackageLastUpdateTime == ((Cache)arg7).mPackageLastUpdateTime && this.mSchema == ((Cache)arg7).mSchema && this.mInstalledCurrentProfileSize == ((Cache)arg7).mInstalledCurrentProfileSize) {
                    return 1;
                }
            }

            return 0;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mResultCode), Long.valueOf(this.mPackageLastUpdateTime), Integer.valueOf(this.mSchema), Long.valueOf(this.mInstalledCurrentProfileSize)});
        }

        static Cache readFromFile(File arg9) throws IOException {
            Cache v2;
            DataInputStream v1 = new DataInputStream(new FileInputStream(arg9));
            try {
                v2 = new Cache(v1.readInt(), v1.readInt(), v1.readLong(), v1.readLong());
            }
            catch(Throwable v0) {
                Throwable v9 = v0;
                try {
                    v1.close();
                }
                catch(Throwable v0) {
                    v9.addSuppressed(v0);
                }

                throw v9;
            }

            v1.close();
            return v2;
        }

        void writeOnFile(File arg4) throws IOException {
            arg4.delete();
            DataOutputStream v0 = new DataOutputStream(new FileOutputStream(arg4));
            try {
                v0.writeInt(this.mSchema);
                v0.writeInt(this.mResultCode);
                v0.writeLong(this.mPackageLastUpdateTime);
                v0.writeLong(this.mInstalledCurrentProfileSize);
            }
            catch(Throwable v3) {
                try {
                    v0.close();
                }
                catch(Throwable v4) {
                    v3.addSuppressed(v4);
                }

                throw v3;
            }

            v0.close();
        }
    }

    public class CompilationStatus {
        @Retention(value=RetentionPolicy.SOURCE) @public interface ResultCode {
        }

        public static final int RESULT_CODE_COMPILED_WITH_PROFILE = 1;
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE_NON_MATCHING = 3;
        public static final int RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ = 0x20000;
        public static final int RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE = 0x30000;
        private static final int RESULT_CODE_ERROR_CODE_BIT_SHIFT = 16;
        public static final int RESULT_CODE_ERROR_NO_PROFILE_EMBEDDED = 0x50000;
        public static final int RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST = 0x10000;
        public static final int RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION = 0x40000;
        @Deprecated public static final int RESULT_CODE_NO_PROFILE = 0;
        public static final int RESULT_CODE_NO_PROFILE_INSTALLED = 0;
        public static final int RESULT_CODE_PROFILE_ENQUEUED_FOR_COMPILATION = 2;
        private final boolean mHasCurrentProfile;
        private final boolean mHasEmbeddedProfile;
        private final boolean mHasReferenceProfile;
        final int mResultCode;

        CompilationStatus(int arg1, boolean arg2, boolean arg3, boolean arg4) {
            super();
            this.mResultCode = arg1;
            this.mHasCurrentProfile = arg3;
            this.mHasReferenceProfile = arg2;
            this.mHasEmbeddedProfile = arg4;
        }

        public boolean appApkHasEmbeddedProfile() {
            return this.mHasEmbeddedProfile;
        }

        public int getProfileInstallResultCode() {
            return this.mResultCode;
        }

        public boolean hasProfileEnqueuedForCompilation() {
            return this.mHasCurrentProfile;
        }

        public boolean isCompiledWithProfile() {
            return this.mHasReferenceProfile;
        }
    }

    private static final String CUR_PROFILES_BASE_DIR = "/data/misc/profiles/cur/0/";
    private static final String PROFILE_FILE_NAME = "primary.prof";
    private static final String PROFILE_INSTALLED_CACHE_FILE_NAME = "profileInstalled";
    private static final String REF_PROFILES_BASE_DIR = "/data/misc/profiles/ref/";
    private static final Object SYNC_OBJ = null;
    private static final String TAG = "ProfileVerifier";
    private static CompilationStatus sCompilationStatus;
    private static final ResolvableFuture sFuture;

    static {
        ProfileVerifier.sFuture = ResolvableFuture.create();
        ProfileVerifier.SYNC_OBJ = new Object();
        ProfileVerifier.sCompilationStatus = null;
    }

    private ProfileVerifier() {
        super();
    }

    public static ListenableFuture getCompilationStatusAsync() {
        return ProfileVerifier.sFuture;
    }

    private static long getPackageLastUpdateTime(Context arg3) throws PackageManager$NameNotFoundException {
        PackageManager v0 = arg3.getApplicationContext().getPackageManager();
        if(Build$VERSION.SDK_INT >= 33) {
            return Api33Impl.getPackageInfo(v0, arg3).lastUpdateTime;
        }

        return v0.getPackageInfo(arg3.getPackageName(), 0).lastUpdateTime;
    }

    private static CompilationStatus setCompilationStatus(int arg1, boolean arg2, boolean arg3, boolean arg4) {
        CompilationStatus v0 = new CompilationStatus(arg1, arg2, arg3, arg4);
        ProfileVerifier.sCompilationStatus = v0;
        ProfileVerifier.sFuture.set(v0);
        return ProfileVerifier.sCompilationStatus;
    }

    static CompilationStatus writeProfileVerification(Context arg19, boolean arg20) {
        int v14;
        Cache v9_1;
        long v15;
        boolean v2_1;
        long v17;
        boolean v6_2;
        AssetFileDescriptor v6;
        CompilationStatus v0;
        if(!arg20) {
            v0 = ProfileVerifier.sCompilationStatus;
            if(v0 != null) {
                return v0;
            }
        }

        Object v1 = ProfileVerifier.SYNC_OBJ;
        __monitor_enter(v1);
        if(!arg20) {
            try {
                v0 = ProfileVerifier.sCompilationStatus;
                if(v0 != null) {
                    __monitor_exit(v1);
                    return v0;
                }
            }
            catch(Throwable v0_1) {
                goto label_34;
            }
        }

        long v2 = 0;
        int v5 = 0;
        try {
            v6 = arg19.getAssets().openFd("dexopt/baseline.prof");
        }
        catch(Throwable v0_1) {
            goto label_34;
        }
        catch(IOException ) {
            goto label_35;
        }

        try {
            if(v6.getLength() <= v2) {
                goto label_21;
            }
        }
        catch(Throwable v0_1) {
            Throwable v7 = v0_1;
            if(v6 != null) {
                try {
                    v6.close();
                    goto label_32;
                }
                catch(Throwable v0_1) {
                    try {
                        v7.addSuppressed(v0_1);
                    label_32:
                        throw v7;
                    }
                    catch(Throwable v0_1) {
                        goto label_34;
                    }
                    catch(IOException ) {
                        goto label_35;
                    }
                }
            }
            else {
                goto label_32;
            }

            goto label_22;
        }

        boolean v0_2 = true;
        goto label_22;
    label_21:
        v0_2 = false;
    label_22:
        if(v6 == null) {
            goto label_36;
        }

        try {
            v6.close();
            goto label_36;
        }
        catch(Throwable v0_1) {
        }
        catch(IOException ) {
        label_35:
            v0_2 = false;
            try {
            label_36:
                if(Build$VERSION.SDK_INT >= 28) {
                    if(Build$VERSION.SDK_INT == 30) {
                    }
                    else {
                        File v6_1 = new File(new File("/data/misc/profiles/ref/", arg19.getPackageName()), "primary.prof");
                        long v7_1 = v6_1.length();
                        v6_2 = !v6_1.exists() || v7_1 <= v2 ? false : true;
                        File v9 = new File(new File("/data/misc/profiles/cur/0/", arg19.getPackageName()), "primary.prof");
                        v17 = v9.length();
                        if(v9.exists()) {
                            goto label_67;
                        }
                        else {
                            goto label_70;
                        }
                    }
                }

                goto label_130;
            }
            catch(Throwable v0_1) {
                goto label_34;
            }

        label_67:
            if(v17 > v2) {
                v2_1 = true;
            }
            else {
            label_70:
                v2_1 = false;
            }

            try {
                v15 = ProfileVerifier.getPackageLastUpdateTime(arg19);
                goto label_72;
            }
            catch(PackageManager$NameNotFoundException ) {
                try {
                    __monitor_exit(v1);
                    return ProfileVerifier.setCompilationStatus(0x10000, v6_2, v2_1, v0_2);
                label_72:
                    File v3 = new File(arg19.getFilesDir(), "profileInstalled");
                    if(v3.exists()) {
                        try {
                            v9_1 = Cache.readFromFile(v3);
                            goto label_85;
                        }
                        catch(IOException ) {
                            int v3_1 = 0x20000;
                            try {
                                __monitor_exit(v1);
                                return ProfileVerifier.setCompilationStatus(v3_1, v6_2, v2_1, v0_2);
                            label_84:
                                v9_1 = null;
                            label_85:
                                int v10 = 2;
                                if(v9_1 != null && v9_1.mPackageLastUpdateTime == v15 && v9_1.mResultCode != v10) {
                                    v5 = v9_1.mResultCode;
                                }
                                else if(!v0_2) {
                                    v5 = 0x50000;
                                }
                                else if(v6_2) {
                                    v5 = 1;
                                }
                                else if(v2_1) {
                                    v5 = v10;
                                }

                                if((arg20) && (v2_1) && v5 != 1) {
                                    v5 = v10;
                                }

                                if(v9_1 != null && v9_1.mResultCode == v10 && v5 == 1 && v7_1 < v9_1.mInstalledCurrentProfileSize) {
                                    v5 = 3;
                                }

                                v14 = v5;
                                Cache v12 = new Cache(1, v14, v15, v17);
                                if(v9_1 != null) {
                                    if(!v9_1.equals(v12)) {
                                        goto label_120;
                                    }

                                    goto label_123;
                                }

                                try {
                                label_120:
                                    v12.writeOnFile(v3);
                                }
                                catch(IOException ) {
                                    v14 = 0x30000;
                                }

                                goto label_123;
                            }
                            catch(Throwable v0_1) {
                                goto label_34;
                            }
                        }
                    }
                    else {
                        goto label_84;
                    }

                    goto label_85;
                }
                catch(Throwable v0_1) {
                    goto label_34;
                }
            }

            try {
            label_123:
                __monitor_exit(v1);
                return ProfileVerifier.setCompilationStatus(v14, v6_2, v2_1, v0_2);
            label_130:
                __monitor_exit(v1);
                return ProfileVerifier.setCompilationStatus(0x40000, false, false, v0_2);
            }
            catch(Throwable v0_1) {
            label_34:
                try {
                    __monitor_exit(v1);
                }
                catch(Throwable v0_1) {
                    goto label_34;
                }

                throw v0_1;
            }
        }
    }

    public static CompilationStatus writeProfileVerification(Context arg1) {
        return ProfileVerifier.writeProfileVerification(arg1, false);
    }
}

