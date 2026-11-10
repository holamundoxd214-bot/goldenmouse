package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build$VERSION;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.Executor;

public class DeviceProfileWriter {
    private final String mApkName;
    private final AssetManager mAssetManager;
    private final File mCurProfile;
    private final byte[] mDesiredVersion;
    private boolean mDeviceSupportsAotProfile;
    private final DiagnosticsCallback mDiagnostics;
    private final Executor mExecutor;
    private DexProfileData[] mProfile;
    private final String mProfileMetaSourceLocation;
    private final String mProfileSourceLocation;
    private byte[] mTranscodedProfile;

    public DeviceProfileWriter(AssetManager arg2, Executor arg3, DiagnosticsCallback arg4, String arg5, String arg6, String arg7, File arg8) {
        super();
        this.mDeviceSupportsAotProfile = false;
        this.mAssetManager = arg2;
        this.mExecutor = arg3;
        this.mDiagnostics = arg4;
        this.mApkName = arg5;
        this.mProfileSourceLocation = arg6;
        this.mProfileMetaSourceLocation = arg7;
        this.mCurProfile = arg8;
        this.mDesiredVersion = DeviceProfileWriter.desiredVersion();
    }

    private DeviceProfileWriter addMetadata(DexProfileData[] arg4, byte[] arg5) {
        InputStream v1;
        DexProfileData[] v0 = null;
        try {
            v1 = this.openStreamFromAssets(this.mAssetManager, this.mProfileMetaSourceLocation);
            if(v1 == null) {
                goto label_19;
            }
        }
        catch(FileNotFoundException v4) {
            goto label_36;
        }
        catch(IllegalStateException v4_1) {
            goto label_23;
        }
        catch(IOException v4_2) {
            goto label_31;
        }

        try {
            this.mProfile = ProfileTranscoder.readMeta(v1, ProfileTranscoder.readHeader(v1, ProfileTranscoder.MAGIC_PROFM), arg5, arg4);
            if(v1 == null) {
                return this;
            }

            goto label_10;
        }
        catch(Throwable v4_3) {
            if(v1 != null) {
                try {
                    v1.close();
                    goto label_18;
                }
                catch(Throwable v5) {
                    try {
                        v4_3.addSuppressed(v5);
                    label_18:
                        throw v4_3;
                    label_10:
                        v1.close();
                    }
                    catch(FileNotFoundException v4) {
                        goto label_36;
                    }
                    catch(IllegalStateException v4_1) {
                        goto label_23;
                    }
                    catch(IOException v4_2) {
                        goto label_31;
                    }
                }
            }
            else {
                goto label_18;
            }
        }

        return this;
        try {
        label_19:
            if(v1 == null) {
                goto label_37;
            }

            v1.close();
        }
        catch(IllegalStateException v4_1) {
        label_23:
            this.mProfile = v0;
            this.mDiagnostics.onResultReceived(8, v4_1);
        }
        catch(IOException v4_2) {
        label_31:
            this.mDiagnostics.onResultReceived(7, v4_2);
        }
        catch(FileNotFoundException v4) {
        label_36:
            this.mDiagnostics.onResultReceived(9, v4);
        }

    label_37:
        return ((DeviceProfileWriter)v0);
    }

    private void assertDeviceAllowsProfileInstallerAotWritesCalled() {
        if(this.mDeviceSupportsAotProfile) {
            return;
        }

        throw new IllegalStateException("This device doesn\'t support aot. Did you call deviceSupportsAotProfile()?");
    }

    private static byte[] desiredVersion() {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            return ProfileVersion.V015_S;
        }

        switch(Build$VERSION.SDK_INT) {
            case 26: {
                goto label_13;
            }
            case 27: {
                goto label_11;
            }
            case 28: 
            case 29: 
            case 30: {
                goto label_9;
            }
        }

        return null;
    label_9:
        return ProfileVersion.V010_P;
    label_11:
        return ProfileVersion.V009_O_MR1;
    label_13:
        return ProfileVersion.V005_O;
    }

    public boolean deviceAllowsProfileInstallerAotWrites() {
        if(this.mDesiredVersion == null) {
            this.result(3, Integer.valueOf(Build$VERSION.SDK_INT));
            return 0;
        }

        boolean v0 = this.mCurProfile.exists();
        File v2 = this.mCurProfile;
        Object v3 = null;
        int v4 = 4;
        if(!v0) {
            try {
                if(!v2.createNewFile()) {
                    this.result(v4, v3);
                    return 0;
                }
            }
            catch(IOException ) {
                this.result(v4, v3);
                return 0;
            }
        }
        else if(!v2.canWrite()) {
            this.result(v4, v3);
            return 0;
        }

        this.mDeviceSupportsAotProfile = true;
        return 1;
    }

    private InputStream getProfileInputStream(AssetManager arg2) {
        InputStream v1;
        try {
            v1 = this.openStreamFromAssets(arg2, this.mProfileSourceLocation);
            return v1;
        }
        catch(IOException v2) {
            ((DeviceProfileWriter)v1).mDiagnostics.onResultReceived(7, v2);
        }
        catch(FileNotFoundException v2_1) {
            ((DeviceProfileWriter)v1).mDiagnostics.onResultReceived(6, v2_1);
        }

        return null;
    }

    void lambda$result$0$androidx-profileinstaller-DeviceProfileWriter(int arg1, Object arg2) {
        this.mDiagnostics.onResultReceived(arg1, arg2);
    }

    private InputStream openStreamFromAssets(AssetManager arg2, String arg3) throws IOException {
        FileInputStream v1;
        try {
            v1 = arg2.openFd(arg3).createInputStream();
            return ((InputStream)v1);
        }
        catch(FileNotFoundException v2) {
            String v2_1 = v2.getMessage();
            Object v3 = null;
            if(v2_1 != null && (v2_1.contains("compressed"))) {
                ((DeviceProfileWriter)v1).mDiagnostics.onDiagnosticReceived(5, v3);
            }

            return ((InputStream)v3);
        }
    }

    public DeviceProfileWriter read() {
        this.assertDeviceAllowsProfileInstallerAotWritesCalled();
        if(this.mDesiredVersion == null) {
        }
        else {
            InputStream v0 = this.getProfileInputStream(this.mAssetManager);
            if(v0 != null) {
                this.mProfile = this.readProfileInternal(v0);
            }

            DexProfileData[] v0_1 = this.mProfile;
            if(v0_1 == null) {
                return this;
            }

            if(!DeviceProfileWriter.requiresMetadata()) {
                return this;
            }

            DeviceProfileWriter v0_2 = this.addMetadata(v0_1, this.mDesiredVersion);
            if(v0_2 == null) {
                return this;
            }

            return v0_2;
        }

        return this;
    }

    private DexProfileData[] readProfileInternal(InputStream arg5) {
        DexProfileData[] v1_3;
        int v0 = 7;
        try {
            v1_3 = ProfileTranscoder.readProfile(arg5, ProfileTranscoder.readHeader(arg5, ProfileTranscoder.MAGIC_PROF), this.mApkName);
        }
        catch(Throwable v1) {
        label_12:
            try {
                arg5.close();
            }
            catch(IOException v5) {
                this.mDiagnostics.onResultReceived(v0, v5);
            }

            throw v1;
        }
        catch(IllegalStateException v1_1) {
            try {
                this.mDiagnostics.onResultReceived(8, v1_1);
            }
            catch(Throwable v1) {
                goto label_12;
            }

            try {
            label_21:
                arg5.close();
            }
            catch(IOException v5) {
                this.mDiagnostics.onResultReceived(v0, v5);
            }

            return null;
        }
        catch(IOException v1_2) {
            try {
                this.mDiagnostics.onResultReceived(v0, v1_2);
                goto label_21;
            }
            catch(Throwable v1) {
                goto label_12;
            }
        }

        try {
            arg5.close();
        }
        catch(IOException v5) {
            this.mDiagnostics.onResultReceived(v0, v5);
        }

        return v1_3;
    }

    private static boolean requiresMetadata() {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            return 1;
        }

        return 0;
    }

    private void result(int arg3, Object arg4) {
        this.mExecutor.execute(new DeviceProfileWriter$$ExternalSyntheticLambda0(this, arg3, arg4));
    }

    public DeviceProfileWriter transcodeIfNeeded() {
        ByteArrayOutputStream v3;
        DexProfileData[] v0 = this.mProfile;
        byte[] v1 = this.mDesiredVersion;
        if(v0 != null && v1 != null) {
            this.assertDeviceAllowsProfileInstallerAotWritesCalled();
            Object v2 = null;
            try {
                v3 = new ByteArrayOutputStream();
            }
            catch(IOException v0_1) {
                goto label_36;
            }
            catch(IllegalStateException v0_2) {
                goto label_31;
            }

            try {
                ProfileTranscoder.writeHeader(((OutputStream)v3), v1);
                if(ProfileTranscoder.transcodeAndWriteBody(((OutputStream)v3), v1, v0)) {
                    goto label_18;
                }

                this.mDiagnostics.onResultReceived(5, v2);
                this.mProfile = ((DexProfileData[])v2);
            }
            catch(Throwable v0_3) {
                goto label_23;
            }

            try {
                v3.close();
                return this;
            }
            catch(IOException v0_1) {
                goto label_36;
            }
            catch(IllegalStateException v0_2) {
                goto label_31;
            }

            try {
            label_18:
                this.mTranscodedProfile = v3.toByteArray();
                goto label_20;
            }
            catch(Throwable v0_3) {
                try {
                label_23:
                    v3.close();
                    goto label_27;
                }
                catch(Throwable v1_1) {
                    try {
                        v0_3.addSuppressed(v1_1);
                    label_27:
                        throw v0_3;
                    label_20:
                        v3.close();
                    }
                    catch(IllegalStateException v0_2) {
                    label_31:
                        this.mDiagnostics.onResultReceived(8, v0_2);
                    }
                    catch(IOException v0_1) {
                    label_36:
                        this.mDiagnostics.onResultReceived(7, v0_1);
                    }
                }
            }

            this.mProfile = ((DexProfileData[])v2);
        }

        return this;
    }

    public boolean write() {
        FileLock v5_1;
        FileChannel v4_1;
        FileOutputStream v0_4;
        ByteArrayInputStream v3;
        byte[] v0 = this.mTranscodedProfile;
        if(v0 == null) {
            return 0;
        }

        this.assertDeviceAllowsProfileInstallerAotWritesCalled();
        Object v2 = null;
        try {
            v3 = new ByteArrayInputStream(v0);
        }
        catch(Throwable v0_1) {
            goto label_63;
        }
        catch(IOException v0_2) {
            goto label_54;
        }
        catch(FileNotFoundException v0_3) {
            goto label_59;
        }

        try {
            v0_4 = new FileOutputStream(this.mCurProfile);
        }
        catch(Throwable v0_1) {
            goto label_46;
        }

        try {
            v4_1 = v0_4.getChannel();
        }
        catch(Throwable v4) {
            goto label_40;
        }

        try {
            v5_1 = v4_1.tryLock();
        }
        catch(Throwable v5) {
            goto label_33;
        }

        try {
            Encoding.writeAll(((InputStream)v3), ((OutputStream)v0_4), v5_1);
            this.result(1, v2);
            if(v5_1 == null) {
                goto label_18;
            }

            goto label_17;
        }
        catch(Throwable v6) {
            if(v5_1 != null) {
                try {
                    v5_1.close();
                    goto label_31;
                }
                catch(Throwable v5) {
                    try {
                        v6.addSuppressed(v5);
                    label_31:
                        throw v6;
                    label_17:
                        v5_1.close();
                    }
                    catch(Throwable v5) {
                    label_33:
                        if(v4_1 != null) {
                            try {
                                v4_1.close();
                                goto label_38;
                            }
                            catch(Throwable v4) {
                                try {
                                    v5.addSuppressed(v4);
                                label_38:
                                    throw v5;
                                }
                                catch(Throwable v4) {
                                    goto label_40;
                                }
                            }
                        }
                        else {
                            goto label_38;
                        }
                    }
                }
            }
            else {
                goto label_31;
            }
        }

    label_18:
        if(v4_1 != null) {
            try {
                v4_1.close();
                goto label_20;
            }
            catch(Throwable v4) {
                try {
                label_40:
                    v0_4.close();
                    goto label_44;
                }
                catch(Throwable v0_1) {
                    try {
                        v4.addSuppressed(v0_1);
                    label_44:
                        throw v4;
                    label_20:
                        v0_4.close();
                        goto label_21;
                    }
                    catch(Throwable v0_1) {
                        try {
                        label_46:
                            ((InputStream)v3).close();
                            goto label_50;
                        }
                        catch(Throwable v3_1) {
                            try {
                                v0_1.addSuppressed(v3_1);
                            label_50:
                                throw v0_1;
                            label_21:
                                ((InputStream)v3).close();
                                goto label_22;
                            }
                            catch(Throwable v0_1) {
                            label_63:
                                this.mTranscodedProfile = ((byte[])v2);
                                this.mProfile = ((DexProfileData[])v2);
                                throw v0_1;
                            }
                            catch(IOException v0_2) {
                            label_54:
                                int v3_2 = 7;
                                try {
                                    this.result(v3_2, v0_2);
                                }
                                catch(Throwable v0_1) {
                                    goto label_63;
                                }

                            label_60:
                                this.mTranscodedProfile = ((byte[])v2);
                                this.mProfile = ((DexProfileData[])v2);
                                return 0;
                            }
                            catch(FileNotFoundException v0_3) {
                                try {
                                label_59:
                                    this.result(6, v0_3);
                                    goto label_60;
                                }
                                catch(Throwable v0_1) {
                                    goto label_63;
                                }
                            }
                        }
                    }
                }
            }
        }

        goto label_20;
    label_22:
        this.mTranscodedProfile = ((byte[])v2);
        this.mProfile = ((DexProfileData[])v2);
        return 1;
    }
}

