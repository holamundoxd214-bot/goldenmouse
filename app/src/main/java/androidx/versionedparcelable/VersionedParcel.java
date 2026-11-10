package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;

public abstract class VersionedParcel {
    public class ParcelException extends RuntimeException {
        public ParcelException(Throwable arg1) {
            super(arg1);
        }
    }

    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_NETWORK_MAIN_THREAD = -6;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_PARCELABLE = -9;
    private static final int EX_SECURITY = -1;
    private static final int EX_UNSUPPORTED_OPERATION = -7;
    private static final String TAG = "VersionedParcel";
    private static final int TYPE_BINDER = 5;
    private static final int TYPE_FLOAT = 8;
    private static final int TYPE_INTEGER = 7;
    private static final int TYPE_PARCELABLE = 2;
    private static final int TYPE_SERIALIZABLE = 3;
    private static final int TYPE_STRING = 4;
    private static final int TYPE_VERSIONED_PARCELABLE = 1;
    protected final ArrayMap mParcelizerCache;
    protected final ArrayMap mReadCache;
    protected final ArrayMap mWriteCache;

    public VersionedParcel(ArrayMap arg1, ArrayMap arg2, ArrayMap arg3) {
        super();
        this.mReadCache = arg1;
        this.mWriteCache = arg2;
        this.mParcelizerCache = arg3;
    }

    protected abstract void closeField();

    private Exception createException(int arg3, String arg4) {
        switch(arg3) {
            case -9: {
                goto label_33;
            }
            case -7: {
                goto label_30;
            }
            case -6: {
                goto label_27;
            }
            case -5: {
                goto label_24;
            }
            case -4: {
                goto label_21;
            }
            case -3: {
                goto label_18;
            }
            case -2: {
                goto label_15;
            }
            case -1: {
                goto label_12;
            }
        }

        return new RuntimeException("Unknown exception code: " + arg3 + " msg " + arg4);
    label_33:
        return this.readParcelable();
    label_18:
        return new IllegalArgumentException(arg4);
    label_21:
        return new NullPointerException(arg4);
    label_24:
        return new IllegalStateException(arg4);
    label_27:
        return new NetworkOnMainThreadException();
    label_12:
        return new SecurityException(arg4);
    label_30:
        return new UnsupportedOperationException(arg4);
    label_15:
        return new BadParcelableException(arg4);
    }

    protected abstract VersionedParcel createSubParcel();

    private Class findParcelClass(Class arg4) throws ClassNotFoundException {
        Class v0_1;
        Object v0 = this.mParcelizerCache.get(arg4.getName());
        if(v0 == null) {
            v0_1 = Class.forName(String.format("%s.%sParcelizer", arg4.getPackage().getName(), arg4.getSimpleName()), false, arg4.getClassLoader());
            this.mParcelizerCache.put(arg4.getName(), v0_1);
        }

        return v0_1;
    }

    private Method getReadMethod(String arg5) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method v0_1;
        Object v0 = this.mReadCache.get(arg5);
        if(v0 == null) {
            System.currentTimeMillis();
            v0_1 = Class.forName(arg5, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
            this.mReadCache.put(arg5, v0_1);
        }

        return v0_1;
    }

    protected static Throwable getRootCause(Throwable arg1) {
        while(arg1.getCause() != null) {
            arg1 = arg1.getCause();
        }

        return arg1;
    }

    private int getType(Object arg2) {
        if((arg2 instanceof String)) {
            return 4;
        }

        if((arg2 instanceof Parcelable)) {
            return 2;
        }

        if((arg2 instanceof VersionedParcelable)) {
            return 1;
        }

        if((arg2 instanceof Serializable)) {
            return 3;
        }

        if((arg2 instanceof IBinder)) {
            return 5;
        }

        if((arg2 instanceof Integer)) {
            return 7;
        }

        if((arg2 instanceof Float)) {
            return 8;
        }

        throw new IllegalArgumentException(arg2.getClass().getName() + " cannot be VersionedParcelled");
    }

    private Method getWriteMethod(Class arg5) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method v0_2;
        Object v0 = this.mWriteCache.get(arg5.getName());
        if(v0 == null) {
            Class v0_1 = this.findParcelClass(arg5);
            System.currentTimeMillis();
            v0_2 = v0_1.getDeclaredMethod("write", arg5, VersionedParcel.class);
            this.mWriteCache.put(arg5.getName(), v0_2);
        }

        return v0_2;
    }

    public boolean isStream() {
        return 0;
    }

    protected Object[] readArray(Object[] arg5) {
        int v0 = this.readInt();
        Object[] v1 = null;
        if(v0 < 0) {
            return v1;
        }

        ArrayList v2 = new ArrayList(v0);
        if(v0 != 0) {
            int v3 = this.readInt();
            if(v0 < 0) {
                return v1;
            }
            else {
                if(v3 != 1) {
                    if(v3 != 2) {
                        if(v3 != 3) {
                            if(v3 != 4) {
                                if(v3 != 5) {
                                    goto label_46;
                                }

                                while(true) {
                                    if(v0 <= 0) {
                                        goto label_46;
                                    }

                                    v2.add(this.readStrongBinder());
                                    --v0;
                                }
                            }

                            while(true) {
                                if(v0 <= 0) {
                                    goto label_46;
                                }

                                v2.add(this.readString());
                                --v0;
                            }
                        }

                        while(true) {
                            if(v0 <= 0) {
                                goto label_46;
                            }

                            v2.add(this.readSerializable());
                            --v0;
                        }
                    }

                    while(true) {
                        if(v0 <= 0) {
                            goto label_46;
                        }

                        v2.add(this.readParcelable());
                        --v0;
                    }
                }

                while(v0 > 0) {
                    v2.add(this.readVersionedParcelable());
                    --v0;
                }
            }
        }

    label_46:
        return v2.toArray(arg5);
    }

    public Object[] readArray(Object[] arg1, int arg2) {
        if(!this.readField(arg2)) {
            return arg1;
        }

        return this.readArray(arg1);
    }

    public boolean readBoolean(boolean arg1, int arg2) {
        if(!this.readField(arg2)) {
            return arg1;
        }

        return this.readBoolean();
    }

    protected abstract boolean readBoolean();

    protected boolean[] readBooleanArray() {
        int v0 = this.readInt();
        if(v0 < 0) {
            return null;
        }

        boolean[] v1 = new boolean[v0];
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            boolean v4 = this.readInt() != 0 ? true : false;
            v1[v3] = v4;
        }

        return v1;
    }

    public boolean[] readBooleanArray(boolean[] arg1, int arg2) {
        if(!this.readField(arg2)) {
            return arg1;
        }

        return this.readBooleanArray();
    }

    protected abstract Bundle readBundle();

    public Bundle readBundle(Bundle arg1, int arg2) {
        if(!this.readField(arg2)) {
            return arg1;
        }

        return this.readBundle();
    }

    public byte readByte(byte arg1, int arg2) {
        if(!this.readField(arg2)) {
            return arg1;
        }

        return ((byte)(this.readInt() & 0xFF));
    }

    public byte[] readByteArray(byte[] arg1, int arg2) {
        if(!this.readField(arg2)) {
            return arg1;
        }

        return this.readByteArray();
    }

    protected abstract byte[] readByteArray();

    public char[] readCharArray(char[] arg3, int arg4) {
        if(!this.readField(arg4)) {
            return arg3;
        }

        int v3 = this.readInt();
        if(v3 < 0) {
            return null;
        }

        char[] v4 = new char[v3];
        int v0;
        for(v0 = 0; v0 < v3; ++v0) {
            v4[v0] = ((char)this.readInt());
        }

        return v4;
    }

    public CharSequence readCharSequence(CharSequence arg1, int arg2) {
        if(!this.readField(arg2)) {
            return arg1;
        }

        return this.readCharSequence();
    }

    protected abstract CharSequence readCharSequence();

    private Collection readCollection(Collection arg4) {
        int v0 = this.readInt();
        Collection v1 = null;
        if(v0 < 0) {
            return v1;
        }

        if(v0 != 0) {
            int v2 = this.readInt();
            if(v0 < 0) {
                return v1;
            }
            else {
                if(v2 != 1) {
                    if(v2 != 2) {
                        if(v2 != 3) {
                            if(v2 != 4) {
                                if(v2 != 5) {
                                    return arg4;
                                }

                                while(true) {
                                    if(v0 <= 0) {
                                        return arg4;
                                    }

                                    arg4.add(this.readStrongBinder());
                                    --v0;
                                }
                            }

                            while(true) {
                                if(v0 <= 0) {
                                    return arg4;
                                }

                                arg4.add(this.readString());
                                --v0;
                            }
                        }

                        while(true) {
                            if(v0 <= 0) {
                                return arg4;
                            }

                            arg4.add(this.readSerializable());
                            --v0;
                        }
                    }

                    while(true) {
                        if(v0 <= 0) {
                            return arg4;
                        }

                        arg4.add(this.readParcelable());
                        --v0;
                    }
                }

                while(v0 > 0) {
                    arg4.add(this.readVersionedParcelable());
                    --v0;
                }
            }
        }

        return arg4;
    }

    protected abstract double readDouble();

    public double readDouble(double arg1, int arg3) {
        if(!this.readField(arg3)) {
            return arg1;
        }

        return this.readDouble();
    }

    protected double[] readDoubleArray() {
        int v0 = this.readInt();
        if(v0 < 0) {
            return null;
        }

        double[] v1 = new double[v0];
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1[v2] = this.readDouble();
        }

        return v1;
    }

    public double[] readDoubleArray(double[] arg1, int arg2) {
        if(!this.readField(arg2)) {
            return arg1;
        }

        return this.readDoubleArray();
    }

    private Exception readException(int arg1, String arg2) {
        return this.createException(arg1, arg2);
    }

    public Exception readException(Exception arg1, int arg2) {
        if(!this.readField(arg2)) {
        }
        else {
            arg2 = this.readExceptionCode();
            if(arg2 != 0) {
                return this.readException(arg2, this.readString());
            }
        }

        return arg1;
    }

    private int readExceptionCode() {
        return this.readInt();
    }

    protected abstract boolean readField(int arg1);

    protected abstract float readFloat();

    public float readFloat(float arg1, int arg2) {
        if(!this.readField(arg2)) {
            return arg1;
        }

        return this.readFloat();
    }

    protected float[] readFloatArray() {
        int v0 = this.readInt();
        if(v0 < 0) {
            return null;
        }

        float[] v1 = new float[v0];
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1[v2] = this.readFloat();
        }

        return v1;
    }

    public float[] readFloatArray(float[] arg1, int arg2) {
        if(!this.readField(arg2)) {
            return arg1;
        }

        return this.readFloatArray();
    }

    protected VersionedParcelable readFromParcel(String arg1, VersionedParcel arg2) {
        try {
            return this.getReadMethod(arg1).invoke(null, arg2);
        }
        catch(ClassNotFoundException v0) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", ((Throwable)v0));
        }
        catch(NoSuchMethodException v0_1) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", ((Throwable)v0_1));
        }
        catch(InvocationTargetException v0_2) {
            if((v0_2.getCause() instanceof RuntimeException)) {
                throw v0_2.getCause();
            }

            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", ((Throwable)v0_2));
        }
        catch(IllegalAccessException v0_3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", ((Throwable)v0_3));
        }
    }

    public int readInt(int arg1, int arg2) {
        if(!this.readField(arg2)) {
            return arg1;
        }

        return this.readInt();
    }

    protected abstract int readInt();

    protected int[] readIntArray() {
        int v0 = this.readInt();
        if(v0 < 0) {
            return null;
        }

        int[] v1 = new int[v0];
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1[v2] = this.readInt();
        }

        return v1;
    }

    public int[] readIntArray(int[] arg1, int arg2) {
        if(!this.readField(arg2)) {
            return arg1;
        }

        return this.readIntArray();
    }

    public List readList(List arg1, int arg2) {
        if(!this.readField(arg2)) {
            return arg1;
        }

        return this.readCollection(new ArrayList());
    }

    protected abstract long readLong();

    public long readLong(long arg1, int arg3) {
        if(!this.readField(arg3)) {
            return arg1;
        }

        return this.readLong();
    }

    protected long[] readLongArray() {
        int v0 = this.readInt();
        if(v0 < 0) {
            return null;
        }

        long[] v1 = new long[v0];
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1[v2] = this.readLong();
        }

        return v1;
    }

    public long[] readLongArray(long[] arg1, int arg2) {
        if(!this.readField(arg2)) {
            return arg1;
        }

        return this.readLongArray();
    }

    public Map readMap(Map arg5, int arg6) {
        if(!this.readField(arg6)) {
            return arg5;
        }

        int v5 = this.readInt();
        if(v5 < 0) {
            return null;
        }

        ArrayMap v6 = new ArrayMap();
        if(v5 == 0) {
        }
        else {
            ArrayList v0 = new ArrayList();
            ArrayList v1 = new ArrayList();
            this.readCollection(((Collection)v0));
            this.readCollection(((Collection)v1));
            int v4;
            for(v4 = 0; v4 < v5; ++v4) {
                ((Map)v6).put(((List)v0).get(v4), ((List)v1).get(v4));
            }
        }

        return ((Map)v6);
    }

    public Parcelable readParcelable(Parcelable arg1, int arg2) {
        if(!this.readField(arg2)) {
            return arg1;
        }

        return this.readParcelable();
    }

    protected abstract Parcelable readParcelable();

    protected Serializable readSerializable() {
        String v0 = ")";
        String v1 = this.readString();
        if(v1 == null) {
            return null;
        }

        ByteArrayInputStream v3 = new ByteArrayInputStream(this.readByteArray());
        try {
            return new ObjectInputStream(((InputStream)v3)) {
                protected Class resolveClass(ObjectStreamClass arg4) throws IOException, ClassNotFoundException {
                    Class v0 = Class.forName(arg4.getName(), false, this.getClass().getClassLoader());
                    if(v0 != null) {
                        return v0;
                    }

                    return super.resolveClass(arg4);
                }
            }.readObject();
        }
        catch(ClassNotFoundException v5) {
            throw new RuntimeException("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = " + v1 + v0, ((Throwable)v5));
        }
        catch(IOException v5_1) {
            throw new RuntimeException("VersionedParcelable encountered IOException reading a Serializable object (name = " + v1 + v0, ((Throwable)v5_1));
        }
    }

    public Set readSet(Set arg1, int arg2) {
        if(!this.readField(arg2)) {
            return arg1;
        }

        return this.readCollection(new ArraySet());
    }

    public Size readSize(Size arg1, int arg2) {
        if(!this.readField(arg2)) {
            return arg1;
        }

        if(this.readBoolean()) {
            return new Size(this.readInt(), this.readInt());
        }

        return null;
    }

    public SizeF readSizeF(SizeF arg1, int arg2) {
        if(!this.readField(arg2)) {
            return arg1;
        }

        if(this.readBoolean()) {
            return new SizeF(this.readFloat(), this.readFloat());
        }

        return null;
    }

    public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray arg4, int arg5) {
        if(!this.readField(arg5)) {
            return arg4;
        }

        int v4 = this.readInt();
        if(v4 < 0) {
            return null;
        }

        SparseBooleanArray v5 = new SparseBooleanArray(v4);
        int v0;
        for(v0 = 0; v0 < v4; ++v0) {
            v5.put(this.readInt(), this.readBoolean());
        }

        return v5;
    }

    public String readString(String arg1, int arg2) {
        if(!this.readField(arg2)) {
            return arg1;
        }

        return this.readString();
    }

    protected abstract String readString();

    protected abstract IBinder readStrongBinder();

    public IBinder readStrongBinder(IBinder arg1, int arg2) {
        if(!this.readField(arg2)) {
            return arg1;
        }

        return this.readStrongBinder();
    }

    public VersionedParcelable readVersionedParcelable(VersionedParcelable arg1, int arg2) {
        if(!this.readField(arg2)) {
            return arg1;
        }

        return this.readVersionedParcelable();
    }

    protected VersionedParcelable readVersionedParcelable() {
        String v0 = this.readString();
        if(v0 == null) {
            return null;
        }

        return this.readFromParcel(v0, this.createSubParcel());
    }

    protected abstract void setOutputField(int arg1);

    public void setSerializationFlags(boolean arg1, boolean arg2) {
    }

    protected void writeArray(Object[] arg5) {
        if(arg5 == null) {
            this.writeInt(-1);
            return;
        }

        int v0 = arg5.length;
        this.writeInt(v0);
        if(v0 > 0) {
            int v1 = 0;
            int v2 = this.getType(arg5[0]);
            this.writeInt(v2);
            if(v2 != 1) {
                if(v2 != 2) {
                    if(v2 != 3) {
                        if(v2 != 4) {
                            if(v2 != 5) {
                                return;
                            }

                            while(true) {
                                if(v1 >= v0) {
                                    return;
                                }

                                this.writeStrongBinder(arg5[v1]);
                                ++v1;
                            }
                        }

                        while(true) {
                            if(v1 >= v0) {
                                return;
                            }

                            this.writeString(arg5[v1]);
                            ++v1;
                        }
                    }

                    while(true) {
                        if(v1 >= v0) {
                            return;
                        }

                        this.writeSerializable(arg5[v1]);
                        ++v1;
                    }
                }

                while(true) {
                    if(v1 >= v0) {
                        return;
                    }

                    this.writeParcelable(arg5[v1]);
                    ++v1;
                }
            }

            while(v1 < v0) {
                this.writeVersionedParcelable(arg5[v1]);
                ++v1;
            }
        }
    }

    public void writeArray(Object[] arg1, int arg2) {
        this.setOutputField(arg2);
        this.writeArray(arg1);
    }

    public void writeBoolean(boolean arg1, int arg2) {
        this.setOutputField(arg2);
        this.writeBoolean(arg1);
    }

    protected abstract void writeBoolean(boolean arg1);

    protected void writeBooleanArray(boolean[] arg4) {
        if(arg4 != null) {
            int v0 = arg4.length;
            this.writeInt(v0);
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                this.writeInt(arg4[v1]);
            }

            return;
        }

        this.writeInt(-1);
    }

    public void writeBooleanArray(boolean[] arg1, int arg2) {
        this.setOutputField(arg2);
        this.writeBooleanArray(arg1);
    }

    protected abstract void writeBundle(Bundle arg1);

    public void writeBundle(Bundle arg1, int arg2) {
        this.setOutputField(arg2);
        this.writeBundle(arg1);
    }

    public void writeByte(byte arg1, int arg2) {
        this.setOutputField(arg2);
        this.writeInt(arg1);
    }

    public void writeByteArray(byte[] arg1, int arg2) {
        this.setOutputField(arg2);
        this.writeByteArray(arg1);
    }

    protected abstract void writeByteArray(byte[] arg1);

    protected abstract void writeByteArray(byte[] arg1, int arg2, int arg3);

    public void writeByteArray(byte[] arg1, int arg2, int arg3, int arg4) {
        this.setOutputField(arg4);
        this.writeByteArray(arg1, arg2, arg3);
    }

    public void writeCharArray(char[] arg3, int arg4) {
        this.setOutputField(arg4);
        if(arg3 != null) {
            arg4 = arg3.length;
            this.writeInt(arg4);
            int v0;
            for(v0 = 0; v0 < arg4; ++v0) {
                this.writeInt(arg3[v0]);
            }

            return;
        }

        this.writeInt(-1);
    }

    public void writeCharSequence(CharSequence arg1, int arg2) {
        this.setOutputField(arg2);
        this.writeCharSequence(arg1);
    }

    protected abstract void writeCharSequence(CharSequence arg1);

    private void writeCollection(Collection arg2) {
        if(arg2 == null) {
            this.writeInt(-1);
            return;
        }

        int v0 = arg2.size();
        this.writeInt(v0);
        if(v0 > 0) {
            v0 = this.getType(arg2.iterator().next());
            this.writeInt(v0);
            switch(v0) {
                case 1: {
                    goto label_51;
                }
                case 2: {
                    goto label_45;
                }
                case 3: {
                    goto label_39;
                }
                case 4: {
                    goto label_33;
                }
                case 5: {
                    goto label_27;
                }
                case 7: {
                    goto label_20;
                }
                case 8: {
                    goto label_13;
                }
            }

            return;
        label_33:
            Iterator v2 = arg2.iterator();
            while(true) {
                if(v2.hasNext()) {
                    this.writeString(v2.next());
                    continue;
                }

                return;
            }

        label_51:
            v2 = arg2.iterator();
            while(true) {
                if(v2.hasNext()) {
                    this.writeVersionedParcelable(v2.next());
                    continue;
                }

                return;
            }

        label_20:
            v2 = arg2.iterator();
            while(true) {
                if(v2.hasNext()) {
                    this.writeInt(v2.next().intValue());
                    continue;
                }

                return;
            }

        label_39:
            v2 = arg2.iterator();
            while(true) {
                if(v2.hasNext()) {
                    this.writeSerializable(v2.next());
                    continue;
                }

                return;
            }

        label_27:
            v2 = arg2.iterator();
            while(true) {
                if(v2.hasNext()) {
                    this.writeStrongBinder(v2.next());
                    continue;
                }

                return;
            }

        label_45:
            v2 = arg2.iterator();
            while(true) {
                if(v2.hasNext()) {
                    this.writeParcelable(v2.next());
                    continue;
                }

                return;
            }

        label_13:
            v2 = arg2.iterator();
            while(v2.hasNext()) {
                this.writeFloat(v2.next().floatValue());
            }
        }
    }

    private void writeCollection(Collection arg1, int arg2) {
        this.setOutputField(arg2);
        this.writeCollection(arg1);
    }

    protected abstract void writeDouble(double arg1);

    public void writeDouble(double arg1, int arg3) {
        this.setOutputField(arg3);
        this.writeDouble(arg1);
    }

    protected void writeDoubleArray(double[] arg5) {
        if(arg5 != null) {
            int v0 = arg5.length;
            this.writeInt(v0);
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                this.writeDouble(arg5[v1]);
            }

            return;
        }

        this.writeInt(-1);
    }

    public void writeDoubleArray(double[] arg1, int arg2) {
        this.setOutputField(arg2);
        this.writeDoubleArray(arg1);
    }

    public void writeException(Exception arg3, int arg4) {
        this.setOutputField(arg4);
        if(arg3 == null) {
            this.writeNoException();
            return;
        }

        int v0 = -9;
        if(((arg3 instanceof Parcelable)) && arg3.getClass().getClassLoader() == Parcelable.class.getClassLoader()) {
            arg4 = v0;
        }
        else if((arg3 instanceof SecurityException)) {
            arg4 = -1;
        }
        else if((arg3 instanceof BadParcelableException)) {
            arg4 = -2;
        }
        else if((arg3 instanceof IllegalArgumentException)) {
            arg4 = -3;
        }
        else if((arg3 instanceof NullPointerException)) {
            arg4 = -4;
        }
        else if((arg3 instanceof IllegalStateException)) {
            arg4 = -5;
        }
        else if((arg3 instanceof NetworkOnMainThreadException)) {
            arg4 = -6;
        }
        else if((arg3 instanceof UnsupportedOperationException)) {
            arg4 = -7;
        }
        else {
            arg4 = 0;
        }

        this.writeInt(arg4);
        if(arg4 == 0) {
            if((arg3 instanceof RuntimeException)) {
                throw arg3;
            }

            throw new RuntimeException(((Throwable)arg3));
        }

        this.writeString(arg3.getMessage());
        if(arg4 != v0) {
            return;
        }

        this.writeParcelable(((Parcelable)arg3));
    }

    protected abstract void writeFloat(float arg1);

    public void writeFloat(float arg1, int arg2) {
        this.setOutputField(arg2);
        this.writeFloat(arg1);
    }

    protected void writeFloatArray(float[] arg4) {
        if(arg4 != null) {
            int v0 = arg4.length;
            this.writeInt(v0);
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                this.writeFloat(arg4[v1]);
            }

            return;
        }

        this.writeInt(-1);
    }

    public void writeFloatArray(float[] arg1, int arg2) {
        this.setOutputField(arg2);
        this.writeFloatArray(arg1);
    }

    public void writeInt(int arg1, int arg2) {
        this.setOutputField(arg2);
        this.writeInt(arg1);
    }

    protected abstract void writeInt(int arg1);

    protected void writeIntArray(int[] arg4) {
        if(arg4 != null) {
            int v0 = arg4.length;
            this.writeInt(v0);
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                this.writeInt(arg4[v1]);
            }

            return;
        }

        this.writeInt(-1);
    }

    public void writeIntArray(int[] arg1, int arg2) {
        this.setOutputField(arg2);
        this.writeIntArray(arg1);
    }

    public void writeList(List arg1, int arg2) {
        this.writeCollection(((Collection)arg1), arg2);
    }

    protected abstract void writeLong(long arg1);

    public void writeLong(long arg1, int arg3) {
        this.setOutputField(arg3);
        this.writeLong(arg1);
    }

    protected void writeLongArray(long[] arg5) {
        if(arg5 != null) {
            int v0 = arg5.length;
            this.writeInt(v0);
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                this.writeLong(arg5[v1]);
            }

            return;
        }

        this.writeInt(-1);
    }

    public void writeLongArray(long[] arg1, int arg2) {
        this.setOutputField(arg2);
        this.writeLongArray(arg1);
    }

    public void writeMap(Map arg4, int arg5) {
        this.setOutputField(arg5);
        if(arg4 == null) {
            this.writeInt(-1);
            return;
        }

        arg5 = arg4.size();
        this.writeInt(arg5);
        if(arg5 == 0) {
            return;
        }

        ArrayList v5 = new ArrayList();
        ArrayList v0 = new ArrayList();
        Iterator v4 = arg4.entrySet().iterator();
        while(v4.hasNext()) {
            Object v1 = v4.next();
            ((List)v5).add(((Map$Entry)v1).getKey());
            ((List)v0).add(((Map$Entry)v1).getValue());
        }

        this.writeCollection(((Collection)v5));
        this.writeCollection(((Collection)v0));
    }

    protected void writeNoException() {
        this.writeInt(0);
    }

    public void writeParcelable(Parcelable arg1, int arg2) {
        this.setOutputField(arg2);
        this.writeParcelable(arg1);
    }

    protected abstract void writeParcelable(Parcelable arg1);

    private void writeSerializable(Serializable arg4) {
        if(arg4 == null) {
            this.writeString(null);
            return;
        }

        String v0 = arg4.getClass().getName();
        this.writeString(v0);
        ByteArrayOutputStream v1 = new ByteArrayOutputStream();
        try {
            ObjectOutputStream v2 = new ObjectOutputStream(((OutputStream)v1));
            v2.writeObject(arg4);
            v2.close();
            this.writeByteArray(v1.toByteArray());
            return;
        }
        catch(IOException v3) {
            throw new RuntimeException("VersionedParcelable encountered IOException writing serializable object (name = " + v0 + ")", ((Throwable)v3));
        }
    }

    public void writeSerializable(Serializable arg1, int arg2) {
        this.setOutputField(arg2);
        this.writeSerializable(arg1);
    }

    public void writeSet(Set arg1, int arg2) {
        this.writeCollection(((Collection)arg1), arg2);
    }

    public void writeSize(Size arg1, int arg2) {
        this.setOutputField(arg2);
        boolean v2 = arg1 != null ? true : false;
        this.writeBoolean(v2);
        if(arg1 != null) {
            this.writeInt(arg1.getWidth());
            this.writeInt(arg1.getHeight());
        }
    }

    public void writeSizeF(SizeF arg1, int arg2) {
        this.setOutputField(arg2);
        boolean v2 = arg1 != null ? true : false;
        this.writeBoolean(v2);
        if(arg1 != null) {
            this.writeFloat(arg1.getWidth());
            this.writeFloat(arg1.getHeight());
        }
    }

    public void writeSparseBooleanArray(SparseBooleanArray arg3, int arg4) {
        this.setOutputField(arg4);
        if(arg3 == null) {
            this.writeInt(-1);
            return;
        }

        arg4 = arg3.size();
        this.writeInt(arg4);
        int v0;
        for(v0 = 0; v0 < arg4; ++v0) {
            this.writeInt(arg3.keyAt(v0));
            this.writeBoolean(arg3.valueAt(v0));
        }
    }

    public void writeString(String arg1, int arg2) {
        this.setOutputField(arg2);
        this.writeString(arg1);
    }

    protected abstract void writeString(String arg1);

    protected abstract void writeStrongBinder(IBinder arg1);

    public void writeStrongBinder(IBinder arg1, int arg2) {
        this.setOutputField(arg2);
        this.writeStrongBinder(arg1);
    }

    protected abstract void writeStrongInterface(IInterface arg1);

    public void writeStrongInterface(IInterface arg1, int arg2) {
        this.setOutputField(arg2);
        this.writeStrongInterface(arg1);
    }

    protected void writeToParcel(VersionedParcelable arg2, VersionedParcel arg3) {
        try {
            this.getWriteMethod(arg2.getClass()).invoke(null, arg2, arg3);
            return;
        }
        catch(ClassNotFoundException v1) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", ((Throwable)v1));
        }
        catch(NoSuchMethodException v1_1) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", ((Throwable)v1_1));
        }
        catch(InvocationTargetException v1_2) {
            if((v1_2.getCause() instanceof RuntimeException)) {
                throw v1_2.getCause();
            }

            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", ((Throwable)v1_2));
        }
        catch(IllegalAccessException v1_3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", ((Throwable)v1_3));
        }
    }

    public void writeVersionedParcelable(VersionedParcelable arg1, int arg2) {
        this.setOutputField(arg2);
        this.writeVersionedParcelable(arg1);
    }

    protected void writeVersionedParcelable(VersionedParcelable arg2) {
        if(arg2 == null) {
            this.writeString(null);
            return;
        }

        this.writeVersionedParcelableCreator(arg2);
        VersionedParcel v0 = this.createSubParcel();
        this.writeToParcel(arg2, v0);
        v0.closeField();
    }

    private void writeVersionedParcelableCreator(VersionedParcelable arg3) {
        Class v3;
        try {
            v3 = this.findParcelClass(arg3.getClass());
        }
        catch(ClassNotFoundException v2) {
            throw new RuntimeException(v3.getClass().getSimpleName() + " does not have a Parcelizer", ((Throwable)v2));
        }

        this.writeString(v3.getName());
    }
}

