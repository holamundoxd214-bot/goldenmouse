package androidx.profileinstaller;

import java.util.TreeMap;

class DexProfileData {
    final String apkName;
    int classSetSize;
    int[] classes;
    final long dexChecksum;
    final String dexName;
    final int hotMethodRegionSize;
    long mTypeIdCount;
    final TreeMap methods;
    final int numMethodIds;

    DexProfileData(String arg1, String arg2, long arg3, long arg5, int arg7, int arg8, int arg9, int[] arg10, TreeMap arg11) {
        super();
        this.apkName = arg1;
        this.dexName = arg2;
        this.dexChecksum = arg3;
        this.mTypeIdCount = arg5;
        this.classSetSize = arg7;
        this.hotMethodRegionSize = arg8;
        this.numMethodIds = arg9;
        this.classes = arg10;
        this.methods = arg11;
    }
}

