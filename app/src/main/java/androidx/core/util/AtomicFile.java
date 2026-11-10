package androidx.core.util;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtomicFile {
    private static final String LOG_TAG = "AtomicFile";
    private final File mBaseName;
    private final File mLegacyBackupName;
    private final File mNewName;

    public AtomicFile(File arg4) {
        super();
        this.mBaseName = arg4;
        this.mNewName = new File(arg4.getPath() + ".new");
        this.mLegacyBackupName = new File(arg4.getPath() + ".bak");
    }

    public void delete() {
        this.mBaseName.delete();
        this.mNewName.delete();
        this.mLegacyBackupName.delete();
    }

    public void failWrite(FileOutputStream arg3) {
        if(arg3 != null) {
            String v1 = "AtomicFile";
            if(!AtomicFile.sync(arg3)) {
                Log.e(v1, "Failed to sync file output stream");
            }

            try {
                arg3.close();
            }
            catch(IOException v3) {
                Log.e(v1, "Failed to close file output stream", ((Throwable)v3));
            }

            if(!this.mNewName.delete()) {
                Log.e(v1, "Failed to delete new file " + this.mNewName);
            }
        }
    }

    public void finishWrite(FileOutputStream arg3) {
        if(arg3 == null) {
            return;
        }

        String v1 = "AtomicFile";
        if(!AtomicFile.sync(arg3)) {
            Log.e(v1, "Failed to sync file output stream");
        }

        try {
            arg3.close();
        }
        catch(IOException v3) {
            Log.e(v1, "Failed to close file output stream", ((Throwable)v3));
        }

        AtomicFile.rename(this.mNewName, this.mBaseName);
    }

    public File getBaseFile() {
        return this.mBaseName;
    }

    public FileInputStream openRead() throws FileNotFoundException {
        if(this.mLegacyBackupName.exists()) {
            AtomicFile.rename(this.mLegacyBackupName, this.mBaseName);
        }

        if((this.mNewName.exists()) && (this.mBaseName.exists()) && !this.mNewName.delete()) {
            Log.e("AtomicFile", "Failed to delete outdated new file " + this.mNewName);
        }

        return new FileInputStream(this.mBaseName);
    }

    public byte[] readFully() throws IOException {
        int v3;
        int v2;
        byte[] v0_1;
        FileInputStream v5 = this.openRead();
        try {
            v0_1 = new byte[v5.available()];
            v2 = 0;
            while(true) {
            label_5:
                v3 = v5.read(v0_1, v2, v0_1.length - v2);
                if(v3 > 0) {
                    break;
                }

                goto label_9;
            }
        }
        catch(Throwable v0) {
            goto label_22;
        }

        v2 += v3;
        try {
            v3 = v5.available();
            if(v3 <= v0_1.length - v2) {
                goto label_5;
            }

            byte[] v3_1 = new byte[v3 + v2];
            System.arraycopy(v0_1, 0, v3_1, 0, v2);
            v0_1 = v3_1;
            goto label_5;
        }
        catch(Throwable v0) {
            goto label_22;
        }

    label_9:
        v5.close();
        return v0_1;
    label_22:
        v5.close();
        throw v0;
    }

    private static void rename(File arg3, File arg4) {
        String v1 = "AtomicFile";
        if((arg4.isDirectory()) && !arg4.delete()) {
            Log.e(v1, "Failed to delete file which is a directory " + arg4);
        }

        if(!arg3.renameTo(arg4)) {
            Log.e(v1, "Failed to rename " + arg3 + " to " + arg4);
        }
    }

    public FileOutputStream startWrite() throws IOException {
        if(this.mLegacyBackupName.exists()) {
            AtomicFile.rename(this.mLegacyBackupName, this.mBaseName);
        }

        try {
            return new FileOutputStream(this.mNewName);
        }
        catch(FileNotFoundException ) {
            if(this.mNewName.getParentFile().mkdirs()) {
                try {
                    return new FileOutputStream(this.mNewName);
                }
                catch(FileNotFoundException v0) {
                    throw new IOException("Failed to create new file " + this.mNewName, ((Throwable)v0));
                }
            }

            throw new IOException("Failed to create directory for " + this.mNewName);
        }
    }

    private static boolean sync(FileOutputStream arg0) {
        try {
            arg0.getFD().sync();
            return 1;
        }
        catch(IOException ) {
            return 0;
        }
    }
}

