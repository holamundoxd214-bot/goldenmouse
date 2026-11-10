package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build$VERSION;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class PackageInfoCompat {
    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static Signature[] getApkContentsSigners(SigningInfo arg0) {
            return arg0.getApkContentsSigners();
        }

        static long getLongVersionCode(PackageInfo arg2) {
            return arg2.getLongVersionCode();
        }

        static Signature[] getSigningCertificateHistory(SigningInfo arg0) {
            return arg0.getSigningCertificateHistory();
        }

        static boolean hasMultipleSigners(SigningInfo arg0) {
            return arg0.hasMultipleSigners();
        }

        static boolean hasSigningCertificate(PackageManager arg0, String arg1, byte[] arg2, int arg3) {
            return arg0.hasSigningCertificate(arg1, arg2, arg3);
        }
    }

    private PackageInfoCompat() {
        super();
    }

    private static boolean byteArrayContains(byte[][] arg4, byte[] arg5) {
        int v0 = arg4.length;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(Arrays.equals(arg5, arg4[v2])) {
                return 1;
            }
        }

        return 0;
    }

    private static byte[] computeSHA256Digest(byte[] arg2) {
        try {
            return MessageDigest.getInstance("SHA256").digest(arg2);
        }
        catch(NoSuchAlgorithmException v2) {
            throw new RuntimeException("Device doesn\'t support SHA256 cert checking", ((Throwable)v2));
        }
    }

    public static long getLongVersionCode(PackageInfo arg2) {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.getLongVersionCode(arg2);
        }

        return ((long)arg2.versionCode);
    }

    public static List getSignatures(PackageManager arg2, String arg3) throws PackageManager$NameNotFoundException {
        Signature[] v2_1;
        if(Build$VERSION.SDK_INT >= 28) {
            SigningInfo v2 = arg2.getPackageInfo(arg3, 0x8000000).signingInfo;
            v2_1 = Api28Impl.hasMultipleSigners(v2) ? Api28Impl.getApkContentsSigners(v2) : Api28Impl.getSigningCertificateHistory(v2);
        }
        else {
            v2_1 = arg2.getPackageInfo(arg3, 0x40).signatures;
        }

        if(v2_1 == null) {
            return Collections.emptyList();
        }

        return Arrays.asList(((Object[])v2_1));
    }

    public static boolean hasSignatures(PackageManager arg7, String arg8, Map arg9, boolean arg10) throws PackageManager$NameNotFoundException {
        int v8;
        byte[][] v7;
        Iterator v10;
        Object v3;
        String v4;
        if(arg9.isEmpty()) {
            return 0;
        }

        Set v0 = arg9.keySet();
        Iterator v2 = v0.iterator();
        while(true) {
            v4 = "Unsupported certificate type ";
            if(!v2.hasNext()) {
                goto label_44;
            }

            v3 = v2.next();
            if(v3 == null) {
                goto label_36;
            }

            v3 = arg9.get(v3);
            if(v3 == null) {
                goto label_28;
            }

            int v6 = ((Integer)v3).intValue();
            if(v6 == 0) {
                continue;
            }

            if(v6 != 1) {
                break;
            }
        }

        throw new IllegalArgumentException(v4 + v3 + " when verifying " + arg8);
    label_28:
        throw new IllegalArgumentException("Type must be specified for cert when verifying " + arg8);
    label_36:
        throw new IllegalArgumentException("Cert byte array cannot be null when verifying " + arg8);
    label_44:
        List v2_1 = PackageInfoCompat.getSignatures(arg7, arg8);
        if(!arg10 && Build$VERSION.SDK_INT >= 28) {
            v10 = v0.iterator();
            goto label_50;
        }

        if(v2_1.size() != 0 && arg9.size() <= v2_1.size() && (!arg10 || arg9.size() == v2_1.size())) {
            if(arg9.containsValue(Integer.valueOf(1))) {
                v7 = new byte[v2_1.size()][];
                v8 = 0;
                goto label_75;
            }
            else {
                v7 = null;
                goto label_84;
            label_75:
                while(v8 < v2_1.size()) {
                    v7[v8] = PackageInfoCompat.computeSHA256Digest(v2_1.get(v8).toByteArray());
                    ++v8;
                }
            }

        label_84:
            Iterator v8_1 = v0.iterator();
            if(!v8_1.hasNext()) {
                return 0;
            }

            Object v8_2 = v8_1.next();
            Object v9 = arg9.get(v8_2);
            int v10_1 = ((Integer)v9).intValue();
            if(v10_1 != 0) {
                if(v10_1 != 1) {
                    throw new IllegalArgumentException(v4 + v9);
                }
                else if(!PackageInfoCompat.byteArrayContains(v7, ((byte[])v8_2))) {
                    return 0;
                }
            }
            else if(!v2_1.contains(new Signature(((byte[])v8_2)))) {
                return 0;
            }

            return 1;
        }

        return 0;
        do {
        label_50:
            if(!v10.hasNext()) {
                return 1;
            }

            Object v0_1 = v10.next();
        }
        while(Api28Impl.hasSigningCertificate(arg7, arg8, ((byte[])v0_1), arg9.get(v0_1).intValue()));

        return 0;
    }
}

