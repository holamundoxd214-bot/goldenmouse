package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Properties;

public class ASN1RelativeOID extends ASN1Primitive {
    class org.bouncycastle.asn1.ASN1RelativeOID$1 extends ASN1UniversalType {
        org.bouncycastle.asn1.ASN1RelativeOID$1(Class arg1, int arg2) {
            super(arg1, arg2);
        }

        ASN1Primitive fromImplicitPrimitive(DEROctetString arg1) {
            return ASN1RelativeOID.createPrimitive(arg1.getOctets(), false);
        }
    }

    private static final long LONG_LIMIT = 0xFFFFFFFFFFFF80L;
    private static final int MAX_CONTENTS_LENGTH = 0x1000;
    private static final int MAX_IDENTIFIER_LENGTH = 0x3FFF;
    static final ASN1UniversalType TYPE;
    private final byte[] contents;
    private String identifier;
    private static final ConcurrentMap pool;

    static {
        ASN1RelativeOID.TYPE = new org.bouncycastle.asn1.ASN1RelativeOID$1(ASN1RelativeOID.class, 13);
        ASN1RelativeOID.pool = new ConcurrentHashMap();
    }

    public ASN1RelativeOID(String arg3) {
        super();
        ASN1RelativeOID.checkIdentifier(arg3);
        byte[] v0 = ASN1RelativeOID.parseIdentifier(arg3);
        ASN1RelativeOID.checkContentsLength(v0.length);
        this.contents = v0;
        this.identifier = arg3;
    }

    private ASN1RelativeOID(byte[] arg1, String arg2) {
        super();
        this.contents = arg1;
        this.identifier = arg2;
    }

    boolean asn1Equals(ASN1Primitive arg2) {
        if(this == (((ASN1RelativeOID)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof ASN1RelativeOID)) {
            return 0;
        }

        return Arrays.areEqual(this.contents, ((ASN1RelativeOID)arg2).contents);
    }

    public ASN1RelativeOID branch(String arg5) {
        byte[] v0_1;
        ASN1RelativeOID.checkIdentifier(arg5);
        int v1 = 2;
        if(arg5.length() <= v1) {
            ASN1RelativeOID.checkContentsLength(this.contents.length + 1);
            int v0 = arg5.charAt(0) - 0x30;
            if(arg5.length() == v1) {
                v0 = v0 * 10 + (arg5.charAt(1) - 0x30);
            }

            v0_1 = Arrays.append(this.contents, ((byte)v0));
        }
        else {
            v0_1 = ASN1RelativeOID.parseIdentifier(arg5);
            ASN1RelativeOID.checkContentsLength(this.contents.length + v0_1.length);
            v0_1 = Arrays.concatenate(this.contents, v0_1);
        }

        return new ASN1RelativeOID(v0_1, this.getId() + "." + arg5);
    }

    static void checkContentsLength(int arg1) {
        if(arg1 <= 0x1000) {
            return;
        }

        throw new IllegalArgumentException("exceeded relative OID contents length limit");
    }

    static void checkIdentifier(String arg3) {
        if(arg3 != null) {
            if(arg3.length() <= 0x3FFF) {
                if(ASN1RelativeOID.isValidIdentifier(arg3, 0)) {
                    return;
                }

                throw new IllegalArgumentException("string " + arg3 + " not a valid relative OID");
            }

            throw new IllegalArgumentException("exceeded relative OID contents length limit");
        }

        throw new NullPointerException("\'identifier\' cannot be null");
    }

    static ASN1RelativeOID createPrimitive(byte[] arg2, boolean arg3) {
        ASN1RelativeOID.checkContentsLength(arg2.length);
        Object v0 = ASN1RelativeOID.pool.get(new OidHandle(arg2));
        if(v0 != null) {
            return ((ASN1RelativeOID)v0);
        }

        if(ASN1RelativeOID.isValidContents(arg2)) {
            if(arg3) {
                arg2 = Arrays.clone(arg2);
            }

            return new ASN1RelativeOID(arg2, null);
        }

        throw new IllegalArgumentException("invalid relative OID contents");
    }

    void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        arg2.writeEncodingDL(arg3, 13, this.contents);
    }

    boolean encodeConstructed() {
        return 0;
    }

    int encodedLength(boolean arg1) {
        return ASN1OutputStream.getLengthOfEncodingDL(arg1, this.contents.length);
    }

    public static ASN1RelativeOID fromContents(byte[] arg1) {
        if(arg1 != null) {
            return ASN1RelativeOID.createPrimitive(arg1, true);
        }

        throw new NullPointerException("\'contents\' cannot be null");
    }

    public String getId() {
        String v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.identifier;
            if(v0_1 == null) {
                v0_1 = ASN1RelativeOID.parseContents(this.contents);
                this.identifier = v0_1;
            }
        }
        catch(Throwable v0) {
            try {
            label_9:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_9;
            }

            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    public static ASN1RelativeOID getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ASN1RelativeOID)) {
            }
            else {
                if((arg3 instanceof ASN1Encodable)) {
                    ASN1Primitive v0 = arg3.toASN1Primitive();
                    if((v0 instanceof ASN1RelativeOID)) {
                        return ((ASN1RelativeOID)v0);
                    }
                }
                else if((arg3 instanceof byte[])) {
                    try {
                        return ASN1RelativeOID.TYPE.fromByteArray(((byte[])arg3));
                    }
                    catch(IOException v3) {
                        throw new IllegalArgumentException("failed to construct relative OID from byte[]: " + v3.getMessage());
                    }
                }

                throw new IllegalArgumentException("illegal object in getInstance: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public static ASN1RelativeOID getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1RelativeOID.TYPE.getContextTagged(arg1, arg2);
    }

    public static ASN1RelativeOID getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1RelativeOID.TYPE.getTagged(arg1, arg2);
    }

    public int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    static boolean isValidContents(byte[] arg5) {
        if(Properties.isOverrideSet("org.bouncycastle.asn1.allow_wrong_oid_enc")) {
            return 1;
        }

        if(arg5.length < 1) {
            return 0;
        }

        boolean v3 = true;
        int v0;
        for(v0 = 0; v0 < arg5.length; ++v0) {
            int v4 = 0x80;
            if((v3) && (arg5[v0] & 0xFF) == v4) {
                return 0;
            }

            v3 = (arg5[v0] & v4) == 0 ? true : false;
        }

        return v3;
    }

    static boolean isValidIdentifier(String arg8, int arg9) {
        int v0 = arg8.length();
        int v2 = 0;
        while(true) {
            int v3 = v0 - 1;
            int v4 = 0x30;
            if(v3 < arg9) {
                goto label_25;
            }

            int v6 = arg8.charAt(v3);
            if(v6 == 46) {
                if(v2 != 0 && (v2 <= 1 || arg8.charAt(v0) != v4)) {
                    v2 = 0;
                    goto label_22;
                }

                return 0;
            }
            else {
                if(v4 <= v6 && v6 <= 57) {
                    ++v2;
                    goto label_22;
                }

                return 0;
            }

        label_22:
            v0 = v3;
        }

        return 0;
    label_25:
        if(v2 != 0 && (v2 <= 1 || arg8.charAt(v0) != v4)) {
            return 1;
        }

        return 0;
    }

    static String parseContents(byte[] arg15) {
        StringBuilder v1 = new StringBuilder();
        BigInteger v4 = null;
        int v5 = 1;
        BigInteger v10 = v4;
        int v7 = 0;
        long v8 = 0;
        while(v7 != arg15.length) {
            int v11 = arg15[v7];
            char v13 = '.';
            int v14 = 7;
            if(Long.compare(v8, 0xFFFFFFFFFFFF80L) <= 0) {
                v8 += ((long)(v11 & 0x7F));
                if((v11 & 0x80) == 0) {
                    if(v5 != 0) {
                        v5 = 0;
                    }
                    else {
                        v1.append(v13);
                    }

                    v1.append(v8);
                    goto label_26;
                }
                else {
                    v8 <<= v14;
                }
            }
            else {
                if(v10 == null) {
                    v10 = BigInteger.valueOf(v8);
                }

                BigInteger v2 = v10.or(BigInteger.valueOf(((long)(v11 & 0x7F))));
                if((v11 & 0x80) == 0) {
                    if(v5 != 0) {
                        v5 = 0;
                    }
                    else {
                        v1.append(v13);
                    }

                    v1.append(v2);
                    v10 = v4;
                label_26:
                    v8 = 0;
                    goto label_46;
                }

                v10 = v2.shiftLeft(v14);
            }

        label_46:
            ++v7;
        }

        return v1.toString();
    }

    static byte[] parseIdentifier(String arg4) {
        ByteArrayOutputStream v0 = new ByteArrayOutputStream();
        OIDTokenizer v1 = new OIDTokenizer(arg4);
        while(v1.hasMoreTokens()) {
            arg4 = v1.nextToken();
            if(arg4.length() <= 18) {
                ASN1RelativeOID.writeField(v0, Long.parseLong(arg4));
                continue;
            }

            ASN1RelativeOID.writeField(v0, new BigInteger(arg4));
        }

        return v0.toByteArray();
    }

    public String toString() {
        return this.getId();
    }

    public static ASN1RelativeOID tryFromID(String arg3) {
        if(arg3 != null) {
            if(arg3.length() <= 0x3FFF && (ASN1RelativeOID.isValidIdentifier(arg3, 0))) {
                byte[] v0 = ASN1RelativeOID.parseIdentifier(arg3);
                if(v0.length <= 0x1000) {
                    return new ASN1RelativeOID(v0, arg3);
                }
            }

            return null;
        }

        throw new NullPointerException("\'identifier\' cannot be null");
    }

    static void writeField(ByteArrayOutputStream arg5, long arg6) {
        byte[] v0 = new byte[9];
        int v2 = 8;
        v0[v2] = ((byte)((((int)arg6)) & 0x7F));
        while(arg6 >= 0x80) {
            arg6 >>= 7;
            --v2;
            v0[v2] = ((byte)((((int)arg6)) | 0x80));
        }

        arg5.write(v0, v2, 9 - v2);
    }

    static void writeField(ByteArrayOutputStream arg7, BigInteger arg8) {
        int v1 = 7;
        int v0 = (arg8.bitLength() + 6) / v1;
        if(v0 == 0) {
            arg7.write(0);
            return;
        }

        byte[] v3 = new byte[v0];
        int v4 = v0 - 1;
        int v5;
        for(v5 = v4; v5 >= 0; --v5) {
            v3[v5] = ((byte)(arg8.intValue() | 0x80));
            arg8 = arg8.shiftRight(v1);
        }

        v3[v4] = ((byte)(v3[v4] & 0x7F));
        arg7.write(v3, 0, v0);
    }
}

