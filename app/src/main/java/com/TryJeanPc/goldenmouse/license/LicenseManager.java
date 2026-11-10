package com.TryJeanPc.goldenmouse.license;

import android.content.Context;
import android.os.Build$VERSION;
import android.security.keystore.KeyGenParameterSpec$Builder;
import android.security.keystore.KeyInfo;
import android.util.AtomicFile;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.KeyStore$LoadStoreParameter;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.KeySpec;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class LicenseManager {
    private static final String ALIAS = "golden.license.device.v1";
    private static final CountDownLatch INITIALIZED;
    static final ExecutorService WORK;
    private static Context app;
    private static volatile boolean authorized;
    private static byte[] device;
    private static volatile String error;
    private static PrivateKey privateKey;
    private static volatile boolean ready;

    static {
        LicenseManager.WORK = Executors.newSingleThreadExecutor(new LicenseManager$$ExternalSyntheticLambda0());
        LicenseManager.error = "";
        LicenseManager.INITIALIZED = new CountDownLatch(1);
    }

    public LicenseManager() {
        super();
    }

    // PATCHED: Always return true - bypass license check
    public static boolean isAuthorized() {
        return true;
    }

    // PATCHED: Always return true - bypass license check
    public static synchronized boolean authorizeSession() {
        return true;
    }                goto label_45;
            }
            catch(Throwable v1) {
                goto label_48;
            }

        label_22:
            goto label_45;
            try {
            label_23:
                v1_1 = LicenseManager.storage().openRead();
            }
            catch(Exception ) {
                goto label_40;
            }
            catch(Throwable v1) {
                goto label_48;
            }

            try {
                LicenseManager.validate(LicenseManager.read(((InputStream)v1_1)));
                LicenseManager.authorized = true;
                if(v1_1 == null) {
                    goto label_31;
                }

                goto label_30;
            }
            catch(Throwable v3) {
                if(v1_1 != null) {
                    try {
                        ((InputStream)v1_1).close();
                        goto label_39;
                    }
                    catch(Throwable v1) {
                        try {
                            v3.addSuppressed(v1);
                        label_39:
                            throw v3;
                        label_30:
                            ((InputStream)v1_1).close();
                        }
                        catch(Throwable v1) {
                            try {
                            label_48:
                                __monitor_exit(v0);
                            }
                            catch(Throwable v1) {
                                goto label_48;
                            }

                            throw v1;
                        }
                        catch(Exception ) {
                            try {
                            label_40:
                                LicenseManager.authorized = false;
                                LicenseManager.error = "Se requiere una licencia válida para esta instalación.";
                            }
                            catch(Throwable v1) {
                                goto label_48;
                            }

                            __monitor_exit(v0);
                            return 0;
                        }
                    }
                }
                else {
                    goto label_39;
                }
            }
        }

    label_31:
        __monitor_exit(v0);
        return 1;
    label_45:
        __monitor_exit(v0);
        return 0;
    }

    static String error() {
        return LicenseManager.error;
    }

    static void importLicense(InputStream arg3) throws Exception {
        FileOutputStream v2;
        AtomicFile v1;
        byte[] v3_1;
        Class v0 = LicenseManager.class;
        __monitor_enter(v0);
        try {
            if((LicenseManager.ready) && LicenseManager.device != null) {
                v3_1 = LicenseManager.read(arg3);
                LicenseManager.validate(v3_1);
                v1 = LicenseManager.storage();
                try {
                    v2 = v1.startWrite();
                    goto label_10;
                }
                catch(Exception v3_2) {
                    v2 = null;
                    goto label_22;
                }
            }

            goto label_25;
        }
        catch(Throwable v3) {
            goto label_30;
        }

        try {
        label_10:
            v2.write(v3_1);
            v1.finishWrite(v2);
            goto label_13;
        }
        catch(Exception v3_2) {
        }

    label_22:
        if(v2 != null) {
            try {
                v1.failWrite(v2);
            label_24:
                throw v3_2;
            label_13:
                LicenseManager.authorized = true;
                LicenseManager.error = "";
                goto label_16;
            }
            catch(Throwable v3) {
                goto label_30;
            }
        }

        goto label_24;
    label_16:
        __monitor_exit(v0);
        return;
        try {
        label_25:
            throw new GeneralSecurityException("Identidad no disponible");
        label_30:
            __monitor_exit(v0);
        }
        catch(Throwable v3) {
            goto label_30;
        }

        throw v3;
    }

    public static void initialize(Context arg2) {
        Class v0 = LicenseManager.class;
        __monitor_enter(v0);
        try {
            if(LicenseManager.app == null) {
                goto label_6;
            }
        }
        catch(Throwable v2) {
            goto label_15;
        }

        __monitor_exit(v0);
        return;
        try {
        label_6:
            LicenseManager.app = arg2.getApplicationContext();
            LicenseManager.WORK.execute(new LicenseManager$$ExternalSyntheticLambda1());
        }
        catch(Throwable v2) {
            try {
            label_15:
                __monitor_exit(v0);
            }
            catch(Throwable v2) {
                goto label_15;
            }

            throw v2;
        }

        __monitor_exit(v0);
    }

    public static boolean isAuthorized() {
        return LicenseManager.authorized;
    }

    static boolean isReady() {
        return LicenseManager.ready;
    }

    static void lambda$initialize$1() {
        FileInputStream v0_3;
        KeyStore$LoadStoreParameter v8;
        KeyStore v7;
        String v0 = "GoldenLicense";
        String v1 = "AndroidKeyStore";
        String v2 = "golden.license.device.v1";
        String v3 = "Nivel de Keystore informado por Android: ";
        String v4 = "No se pudo preparar la identidad: ";
        try {
            v7 = KeyStore.getInstance(v1);
            v8 = null;
            v7.load(v8);
            boolean v9 = v7.containsAlias(v2);
        }
        catch(Exception v0_1) {
            goto label_79;
        }
        catch(Throwable v0_2) {
            goto label_91;
        }

        String v10 = "EC";
        if(!v9) {
            try {
                KeyPairGenerator v9_1 = KeyPairGenerator.getInstance(v10, v1);
                v9_1.initialize(new KeyGenParameterSpec$Builder(v2, 12).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setDigests(new String[]{"SHA-256"}).setUserAuthenticationRequired(false).build());
                v9_1.generateKeyPair();
            label_29:
                LicenseManager.privateKey = v7.getKey(v2, ((char[])v8));
                LicenseManager.device = LicenseCodec.rawPublic(v7.getCertificate(v2).getPublicKey());
                goto label_35;
            }
            catch(Exception v0_1) {
                goto label_79;
            }
            catch(Throwable v0_2) {
                goto label_91;
            }
        }

        goto label_29;
        try {
        label_35:
            KeySpec v1_1 = KeyFactory.getInstance(v10, v1).getKeySpec(LicenseManager.privateKey, KeyInfo.class);
            if(Build$VERSION.SDK_INT >= 0x1F) {
                v1 = String.valueOf(((KeyInfo)v1_1).getSecurityLevel());
            }
            else if(((KeyInfo)v1_1).isInsideSecureHardware()) {
                v1 = "hardware";
            }
            else {
                v1 = "software";
            }

            Log.i(v0, v3 + v1);
            goto label_58;
        }
        catch(Throwable v0_2) {
        }
        catch(Exception v0_1) {
        }
        catch(GeneralSecurityException ) {
            try {
                Log.i(v0, "Nivel de Keystore no informado");
            }
            catch(Exception v0_1) {
                goto label_79;
            }
            catch(Throwable v0_2) {
                goto label_91;
            }

            try {
            label_58:
                v0_3 = LicenseManager.storage().openRead();
            }
            catch(FileNotFoundException ) {
                goto label_87;
            }
            catch(Exception ) {
                goto label_73;
            }
            catch(Throwable v0_2) {
                goto label_91;
            }

            try {
                LicenseManager.validate(LicenseManager.read(((InputStream)v0_3)));
                LicenseManager.authorized = true;
                if(v0_3 == null) {
                    goto label_87;
                }

                goto label_64;
            }
            catch(Throwable v1_2) {
                if(v0_3 == null) {
                    goto label_72;
                }

                try {
                    ((InputStream)v0_3).close();
                    goto label_72;
                }
                catch(Throwable v0_2) {
                    try {
                        v1_2.addSuppressed(v0_2);
                    label_72:
                        throw v1_2;
                    label_64:
                        ((InputStream)v0_3).close();
                        goto label_87;
                    }
                    catch(FileNotFoundException ) {
                    label_87:
                        LicenseManager.ready = true;
                        LicenseManager.INITIALIZED.countDown();
                        return;
                    }
                    catch(Throwable v0_2) {
                    }
                    catch(Exception ) {
                        try {
                        label_73:
                            LicenseManager.error = "La licencia guardada no es válida para esta instalación.";
                            goto label_87;
                        }
                        catch(Throwable v0_2) {
                        }
                        catch(Exception v0_1) {
                            try {
                            label_79:
                                LicenseManager.authorized = false;
                                LicenseManager.error = v4 + v0_1.getClass().getSimpleName();
                                goto label_87;
                            }
                            catch(Throwable v0_2) {
                            label_91:
                                LicenseManager.ready = true;
                                LicenseManager.INITIALIZED.countDown();
                                throw v0_2;
                            }
                        }
                    }
                }
            }
        }
    }

    static Thread lambda$static$0(Runnable arg2) {
        return new Thread(arg2, "GoldenLicense");
    }

    private static byte[] read(InputStream arg6) throws IOException {
        if(arg6 == null) {
            goto label_30;
        }

        ByteArrayOutputStream v0 = new ByteArrayOutputStream();
        int v1 = 0x100;
        byte[] v2 = new byte[v1];
        while(true) {
            int v3 = arg6.read(v2, 0, Math.min(v1, LicenseCodec.LICENSE_SIZE + 1 - v0.size()));
            if(v3 == -1) {
                goto label_28;
            }

            if(v3 == 0) {
                goto label_24;
            }

            v0.write(v2, 0, v3);
            if(v0.size() > LicenseCodec.LICENSE_SIZE) {
                break;
            }
        }

        throw new IOException("Archivo demasiado grande");
    label_24:
        throw new IOException("El proveedor no entregó datos");
    label_28:
        return v0.toByteArray();
    label_30:
        throw new IOException("No se pudo abrir el archivo");
    }

    static String request() throws GeneralSecurityException {
        if((LicenseManager.ready) && LicenseManager.device != null) {
            return "GOLDEN-REQUEST-1:" + Base64.encodeToString(LicenseManager.device, 2);
        }

        throw new GeneralSecurityException("La identidad todavía no está disponible. " + LicenseManager.error);
    }

    private static AtomicFile storage() {
        return new AtomicFile(new File(LicenseManager.app.getNoBackupFilesDir(), "golden-device-license.v1"));
    }

    private static void validate(byte[] arg3) throws GeneralSecurityException {
        LicenseCodec.verifyLicense(arg3, IssuerPublic.VALUE, LicenseManager.device);
        byte[] v0 = new byte[0x20];
        new SecureRandom().nextBytes(v0);
        LicenseCodec.verifyProof(arg3, IssuerPublic.VALUE, v0, LicenseCodec.prove(LicenseManager.privateKey, arg3, v0));
    }
}

