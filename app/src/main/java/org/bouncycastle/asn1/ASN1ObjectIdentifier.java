package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.bouncycastle.util.Arrays;

public class ASN1ObjectIdentifier extends ASN1Primitive {
    class org.bouncycastle.asn1.ASN1ObjectIdentifier$1 extends ASN1UniversalType {
        org.bouncycastle.asn1.ASN1ObjectIdentifier$1(Class arg1, int arg2) {
            super(arg1, arg2);
        }

        ASN1Primitive fromImplicitPrimitive(DEROctetString arg1) {
            return ASN1ObjectIdentifier.createPrimitive(arg1.getOctets(), false);
        }
    }

    class OidHandle {
        private final byte[] contents;
        private final int key;

        OidHandle(byte[] arg2) {
            super();
            this.key = Arrays.hashCode(arg2);
            this.contents = arg2;
        }

        public boolean equals(Object arg2) {
            if((arg2 instanceof OidHandle)) {
                return Arrays.areEqual(this.contents, ((OidHandle)arg2).contents);
            }

            return 0;
        }

        public int hashCode() {
            return this.key;
        }
    }

    private static final long LONG_LIMIT = 0xFFFFFFFFFFFF80L;
    private static final int MAX_CONTENTS_LENGTH = 0x1000;
    private static final int MAX_IDENTIFIER_LENGTH = 0x4001;
    static final ASN1UniversalType TYPE;
    private final byte[] contents;
    private String identifier;
    private static final ConcurrentMap pool;

    static {
        ASN1ObjectIdentifier.TYPE = new org.bouncycastle.asn1.ASN1ObjectIdentifier$1(ASN1ObjectIdentifier.class, 6);
        ASN1ObjectIdentifier.pool = new ConcurrentHashMap();
    }

    public ASN1ObjectIdentifier(String arg3) {
        super();
        ASN1ObjectIdentifier.checkIdentifier(arg3);
        byte[] v0 = ASN1ObjectIdentifier.parseIdentifier(arg3);
        ASN1ObjectIdentifier.checkContentsLength(v0.length);
        this.contents = v0;
        this.identifier = arg3;
    }

    private ASN1ObjectIdentifier(byte[] arg1, String arg2) {
        super();
        this.contents = arg1;
        this.identifier = arg2;
    }

    boolean asn1Equals(ASN1Primitive arg2) {
        if(this == (((ASN1ObjectIdentifier)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof ASN1ObjectIdentifier)) {
            return 0;
        }

        return Arrays.areEqual(this.contents, ((ASN1ObjectIdentifier)arg2).contents);
    }

    public ASN1ObjectIdentifier branch(String arg5) {
        byte[] v0_1;
        ASN1RelativeOID.checkIdentifier(arg5);
        int v1 = 2;
        if(arg5.length() <= v1) {
            ASN1ObjectIdentifier.checkContentsLength(this.contents.length + 1);
            int v0 = arg5.charAt(0) - 0x30;
            if(arg5.length() == v1) {
                v0 = v0 * 10 + (arg5.charAt(1) - 0x30);
            }

            v0_1 = Arrays.append(this.contents, ((byte)v0));
        }
        else {
            v0_1 = ASN1RelativeOID.parseIdentifier(arg5);
            ASN1ObjectIdentifier.checkContentsLength(this.contents.length + v0_1.length);
            v0_1 = Arrays.concatenate(this.contents, v0_1);
        }

        return new ASN1ObjectIdentifier(v0_1, this.getId() + "." + arg5);
    }

    static void checkContentsLength(int arg1) {
        if(arg1 <= 0x1000) {
            return;
        }

        throw new IllegalArgumentException("exceeded OID contents length limit");
    }

    static void checkIdentifier(String arg3) {
        if(arg3 != null) {
            if(arg3.length() <= 0x4001) {
                if(ASN1ObjectIdentifier.isValidIdentifier(arg3)) {
                    return;
                }

                throw new IllegalArgumentException("string " + arg3 + " not a valid OID");
            }

            throw new IllegalArgumentException("exceeded OID contents length limit");
        }

        throw new NullPointerException("\'identifier\' cannot be null");
    }

    static ASN1ObjectIdentifier createPrimitive(byte[] arg2, boolean arg3) {
        ASN1ObjectIdentifier.checkContentsLength(arg2.length);
        Object v0 = ASN1ObjectIdentifier.pool.get(new OidHandle(arg2));
        if(v0 != null) {
            return ((ASN1ObjectIdentifier)v0);
        }

        if(ASN1RelativeOID.isValidContents(arg2)) {
            if(arg3) {
                arg2 = Arrays.clone(arg2);
            }

            return new ASN1ObjectIdentifier(arg2, null);
        }

        throw new IllegalArgumentException("invalid OID contents");
    }

    void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        arg2.writeEncodingDL(arg3, 6, this.contents);
    }

    boolean encodeConstructed() {
        return 0;
    }

    int encodedLength(boolean arg1) {
        return ASN1OutputStream.getLengthOfEncodingDL(arg1, this.contents.length);
    }

    public static ASN1ObjectIdentifier fromContents(byte[] arg1) {
        if(arg1 != null) {
            return ASN1ObjectIdentifier.createPrimitive(arg1, true);
        }

        throw new NullPointerException("\'contents\' cannot be null");
    }

    public String getId() {
        String v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.identifier;
            if(v0_1 == null) {
                v0_1 = ASN1ObjectIdentifier.parseContents(this.contents);
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

    public static ASN1ObjectIdentifier getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ASN1ObjectIdentifier)) {
            }
            else {
                if((arg3 instanceof ASN1Encodable)) {
                    ASN1Primitive v0 = arg3.toASN1Primitive();
                    if((v0 instanceof ASN1ObjectIdentifier)) {
                        return ((ASN1ObjectIdentifier)v0);
                    }
                }
                else if((arg3 instanceof byte[])) {
                    try {
                        return ASN1ObjectIdentifier.TYPE.fromByteArray(((byte[])arg3));
                    }
                    catch(IOException v3) {
                        throw new IllegalArgumentException("failed to construct object identifier from byte[]: " + v3.getMessage());
                    }
                }

                throw new IllegalArgumentException("illegal object in getInstance: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public static ASN1ObjectIdentifier getInstance(ASN1TaggedObject arg2, boolean arg3) {
        if(!arg3 && !arg2.isParsed() && (arg2.hasContextTag())) {
            ASN1Primitive v0 = arg2.getBaseObject().toASN1Primitive();
            if(!(v0 instanceof ASN1ObjectIdentifier)) {
                return ASN1ObjectIdentifier.fromContents(ASN1OctetString.getInstance(v0).getOctets());
            }
        }

        return ASN1ObjectIdentifier.TYPE.getContextTagged(arg2, arg3);
    }

    public static ASN1ObjectIdentifier getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1ObjectIdentifier.TYPE.getTagged(arg1, arg2);
    }

    public int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public ASN1ObjectIdentifier intern() {
        Object v3_1;
        OidHandle v0 = new OidHandle(this.contents);
        ConcurrentMap v1 = ASN1ObjectIdentifier.pool;
        Object v2 = v1.get(v0);
        if(v2 == null) {
            __monitor_enter(v1);
            try {
                if(!v1.containsKey(v0)) {
                    v1.put(v0, this);
                }
                else {
                    v3_1 = v1.get(v0);
                }

                __monitor_exit(v1);
                return ((ASN1ObjectIdentifier)v3_1);
            label_15:
                __monitor_exit(v1);
            }
            catch(Throwable v3) {
                goto label_15;
            }

            throw v3;
        }

        return ((ASN1ObjectIdentifier)v2);
    }

    private static boolean isValidIdentifier(String arg8) {
        int v2 = 3;
        if(arg8.length() >= v2) {
            int v4 = 46;
            if(arg8.charAt(1) != v4) {
            }
            else {
                int v3 = arg8.charAt(0);
                if(v3 >= 0x30) {
                    int v5 = 50;
                    if(v3 > v5) {
                    }
                    else {
                        int v6 = 2;
                        if(!ASN1RelativeOID.isValidIdentifier(arg8, v6)) {
                            return 0;
                        }
                        else if(v3 == v5) {
                            return 1;
                        }
                        else {
                            if(arg8.length() != v2) {
                                if(arg8.charAt(v2) == v4) {
                                }
                                else {
                                    v3 = 4;
                                    if(arg8.length() != v3) {
                                        if(arg8.charAt(v3) == v4) {
                                        }
                                        else {
                                            return 0;
                                        }
                                    }

                                    if(arg8.charAt(v6) < 52) {
                                        return 1;
                                    }

                                    return 0;
                                }
                            }

                            return 1;
                        }
                    }
                }
            }
        }

        return 0;
    }

    public boolean on(ASN1ObjectIdentifier arg7) {
        byte[] v0 = this.contents;
        byte[] v3 = arg7.contents;
        int v2 = v3.length;
        if(v0.length > v2 && (Arrays.areEqual(v0, 0, v2, v3, 0, v2))) {
            return 1;
        }

        return 0;
    }

    private static String parseContents(byte[] arg18) {
        byte[] v0 = arg18;
        StringBuilder v1 = new StringBuilder();
        BigInteger v4 = null;
        int v5 = 1;
        BigInteger v10 = v4;
        int v7 = 0;
        long v8 = 0;
        while(v7 != v0.length) {
            int v11 = v0[v7];
            char v13 = '2';
            char v14 = '.';
            int v15 = 7;
            long v16 = 80;
            if(Long.compare(v8, 0xFFFFFFFFFFFF80L) <= 0) {
                v8 += ((long)(v11 & 0x7F));
                if((v11 & 0x80) == 0) {
                    if(v5 != 0) {
                        long v2 = 40;
                        if(v8 < v2) {
                            v1.append('0');
                        }
                        else if(v8 < v16) {
                            v1.append('1');
                            v8 -= v2;
                        }
                        else {
                            v1.append(v13);
                            v8 -= v16;
                        }

                        v5 = 0;
                    }

                    v1.append(v14);
                    v1.append(v8);
                    goto label_40;
                }
                else {
                    v8 <<= v15;
                }
            }
            else {
                if(v10 == null) {
                    v10 = BigInteger.valueOf(v8);
                }

                BigInteger v2_1 = v10.or(BigInteger.valueOf(((long)(v11 & 0x7F))));
                if((v11 & 0x80) == 0) {
                    if(v5 != 0) {
                        v1.append(v13);
                        v2_1 = v2_1.subtract(BigInteger.valueOf(v16));
                        v5 = 0;
                    }

                    v1.append(v14);
                    v1.append(v2_1);
                    v10 = v4;
                label_40:
                    v8 = 0;
                    goto label_62;
                }

                v10 = v2_1.shiftLeft(v15);
            }

        label_62:
            ++v7;
        }

        return v1.toString();
    }

    private static byte[] parseIdentifier(String arg7) {
        ByteArrayOutputStream v0 = new ByteArrayOutputStream();
        OIDTokenizer v1 = new OIDTokenizer(arg7);
        int v7 = Integer.parseInt(v1.nextToken()) * 40;
        String v2 = v1.nextToken();
        int v4 = 18;
        if(v2.length() <= v4) {
            ASN1RelativeOID.writeField(v0, (((long)v7)) + Long.parseLong(v2));
        }
        else {
            ASN1RelativeOID.writeField(v0, new BigInteger(v2).add(BigInteger.valueOf(((long)v7))));
        }

        while(v1.hasMoreTokens()) {
            arg7 = v1.nextToken();
            if(arg7.length() <= v4) {
                ASN1RelativeOID.writeField(v0, Long.parseLong(arg7));
                continue;
            }

            ASN1RelativeOID.writeField(v0, new BigInteger(arg7));
        }

        return v0.toByteArray();
    }

    public String toString() {
        return this.getId();
    }

    public static ASN1ObjectIdentifier tryFromID(String arg3) {
        if(arg3 != null) {
            if(arg3.length() <= 0x4001 && (ASN1ObjectIdentifier.isValidIdentifier(arg3))) {
                byte[] v0 = ASN1ObjectIdentifier.parseIdentifier(arg3);
                if(v0.length <= 0x1000) {
                    return new ASN1ObjectIdentifier(v0, arg3);
                }
            }

            return null;
        }

        throw new NullPointerException("\'identifier\' cannot be null");
    }
}

