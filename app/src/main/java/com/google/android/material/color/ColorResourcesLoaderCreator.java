package com.google.android.material.color;

import android.content.Context;
import android.content.res.loader.AssetsProvider;
import android.content.res.loader.ResourcesLoader;
import android.content.res.loader.ResourcesProvider;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;

final class ColorResourcesLoaderCreator {
    private static final String TAG = "ColorResLoaderCreator";

    private ColorResourcesLoaderCreator() {
        super();
    }

    static ResourcesLoader create(Context arg5, Map arg6) {
        ResourcesLoader v3_1;
        ParcelFileDescriptor v5_3;
        FileOutputStream v1_1;
        FileDescriptor v6;
        byte[] v5_1;
        String v0 = "ColorResLoaderCreator";
        String v1 = "Table created, length: ";
        ResourcesLoader v2 = null;
        try {
            v5_1 = ColorResourcesTableCreator.create(arg5, arg6);
            Log.i(v0, v1 + v5_1.length);
            if(v5_1.length != 0) {
                goto label_13;
            }
        }
        catch(Exception v5) {
            goto label_58;
        }

        return v2;
        try {
        label_13:
            v6 = Os.memfd_create("temp.arsc", 0);
            if(v6 != null) {
                goto label_22;
            }
        }
        catch(Throwable v5_2) {
            v6 = ((FileDescriptor)v2);
            goto label_53;
        }

        try {
            Log.w(v0, "Cannot create memory file descriptor.");
            if(v6 != null) {
                goto label_20;
            }

            return v2;
        }
        catch(Throwable v5_2) {
            goto label_50;
        }

        try {
        label_20:
            Os.close(v6);
        }
        catch(Exception v5) {
            goto label_58;
        }

        return v2;
        try {
        label_22:
            v1_1 = new FileOutputStream(v6);
        }
        catch(Throwable v5_2) {
            goto label_50;
        }

        try {
            ((OutputStream)v1_1).write(v5_1);
            v5_3 = ParcelFileDescriptor.dup(v6);
        }
        catch(Throwable v5_2) {
            goto label_44;
        }

        try {
            v3_1 = new ResourcesLoader();
            v3_1.addProvider(ResourcesProvider.loadFromTable(v5_3, ((AssetsProvider)v2)));
            if(v5_3 == null) {
                goto label_32;
            }

            goto label_31;
        }
        catch(Throwable v3) {
            if(v5_3 != null) {
                try {
                    v5_3.close();
                    goto label_42;
                }
                catch(Throwable v5_2) {
                    try {
                        v3.addSuppressed(v5_2);
                    label_42:
                        throw v3;
                    label_31:
                        v5_3.close();
                        goto label_32;
                    }
                    catch(Throwable v5_2) {
                        try {
                        label_44:
                            ((OutputStream)v1_1).close();
                            goto label_48;
                        }
                        catch(Throwable v1_2) {
                            try {
                                v5_2.addSuppressed(v1_2);
                            label_48:
                                throw v5_2;
                            label_32:
                                ((OutputStream)v1_1).close();
                                if(v6 == null) {
                                    return v3_1;
                                }

                                goto label_34;
                            }
                            catch(Throwable v5_2) {
                            label_50:
                                goto label_53;
                            }
                        }
                    }
                }
            }
            else {
                goto label_42;
            }

            goto label_32;
        }

    label_53:
        if(v6 != null) {
            try {
                Os.close(v6);
            label_55:
                throw v5_2;
            label_34:
                Os.close(v6);
                return v3_1;
            }
            catch(Exception v5) {
            label_58:
                Log.e(v0, "Failed to create the ColorResourcesTableCreator.", ((Throwable)v5));
                return v2;
            }
        }

        goto label_55;
        return v3_1;
    }
}

