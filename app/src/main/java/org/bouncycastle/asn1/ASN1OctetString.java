package org.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public abstract class ASN1OctetString extends ASN1Primitive implements ASN1OctetStringParser {
    class org.bouncycastle.asn1.ASN1OctetString$1 extends ASN1UniversalType {
        org.bouncycastle.asn1.ASN1OctetString$1(Class arg1, int arg2) {
            super(arg1, arg2);
        }

        ASN1Primitive fromImplicitConstructed(ASN1Sequence arg1) {
            return arg1.toASN1OctetString();
        }

        ASN1Primitive fromImplicitPrimitive(DEROctetString arg1) {
            return arg1;
        }
    }

    static final byte[] EMPTY_OCTETS;
    static final ASN1UniversalType TYPE;
    byte[] string;

    static {
        ASN1OctetString.TYPE = new org.bouncycastle.asn1.ASN1OctetString$1(ASN1OctetString.class, 4);
        ASN1OctetString.EMPTY_OCTETS = new byte[0];
    }

    public ASN1OctetString(byte[] arg1) {
        super();
        if(arg1 != null) {
            this.string = arg1;
            return;
        }

        throw new NullPointerException("\'string\' cannot be null");
    }

    boolean asn1Equals(ASN1Primitive arg2) {
        if(!(arg2 instanceof ASN1OctetString)) {
            return 0;
        }

        return Arrays.areEqual(this.string, ((ASN1OctetString)arg2).string);
    }

    static ASN1OctetString createPrimitive(byte[] arg1) {
        return new DEROctetString(arg1);
    }

    public static ASN1OctetString getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1OctetString.TYPE.getContextTagged(arg1, arg2);
    }

    public static ASN1OctetString getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ASN1OctetString)) {
            }
            else {
                if((arg3 instanceof ASN1Encodable)) {
                    ASN1Primitive v0 = arg3.toASN1Primitive();
                    if((v0 instanceof ASN1OctetString)) {
                        return ((ASN1OctetString)v0);
                    }
                }
                else if((arg3 instanceof byte[])) {
                    try {
                        return ASN1OctetString.TYPE.fromByteArray(((byte[])arg3));
                    }
                    catch(IOException v3) {
                        throw new IllegalArgumentException("failed to construct OCTET STRING from byte[]: " + v3.getMessage());
                    }
                }

                throw new IllegalArgumentException("illegal object in getInstance: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public ASN1Primitive getLoadedObject() {
        return this.toASN1Primitive();
    }

    public InputStream getOctetStream() {
        return new ByteArrayInputStream(this.string);
    }

    public byte[] getOctets() {
        return this.string;
    }

    public int getOctetsLength() {
        return this.getOctets().length;
    }

    public static ASN1OctetString getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1OctetString.TYPE.getTagged(arg1, arg2);
    }

    public int hashCode() {
        return Arrays.hashCode(this.getOctets());
    }

    public ASN1OctetStringParser parser() {
        return this;
    }

    ASN1Primitive toDERObject() {
        return new DEROctetString(this.string);
    }

    ASN1Primitive toDLObject() {
        return new DEROctetString(this.string);
    }

    public String toString() {
        return "#" + Strings.fromByteArray(Hex.encode(this.string));
    }
}

