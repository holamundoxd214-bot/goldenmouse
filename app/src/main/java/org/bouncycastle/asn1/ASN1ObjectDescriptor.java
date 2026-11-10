package org.bouncycastle.asn1;

import java.io.IOException;

public final class ASN1ObjectDescriptor extends ASN1Primitive {
    class org.bouncycastle.asn1.ASN1ObjectDescriptor$1 extends ASN1UniversalType {
        org.bouncycastle.asn1.ASN1ObjectDescriptor$1(Class arg1, int arg2) {
            super(arg1, arg2);
        }

        ASN1Primitive fromImplicitConstructed(ASN1Sequence arg2) {
            return new ASN1ObjectDescriptor(ASN1GraphicString.TYPE.fromImplicitConstructed(arg2));
        }

        ASN1Primitive fromImplicitPrimitive(DEROctetString arg2) {
            return new ASN1ObjectDescriptor(ASN1GraphicString.TYPE.fromImplicitPrimitive(arg2));
        }
    }

    static final ASN1UniversalType TYPE;
    private final ASN1GraphicString baseGraphicString;

    static {
        ASN1ObjectDescriptor.TYPE = new org.bouncycastle.asn1.ASN1ObjectDescriptor$1(ASN1ObjectDescriptor.class, 7);
    }

    public ASN1ObjectDescriptor(ASN1GraphicString arg1) {
        super();
        if(arg1 != null) {
            this.baseGraphicString = arg1;
            return;
        }

        throw new NullPointerException("\'baseGraphicString\' cannot be null");
    }

    boolean asn1Equals(ASN1Primitive arg2) {
        if(!(arg2 instanceof ASN1ObjectDescriptor)) {
            return 0;
        }

        return this.baseGraphicString.asn1Equals(((ASN1ObjectDescriptor)arg2).baseGraphicString);
    }

    static ASN1ObjectDescriptor createPrimitive(byte[] arg1) {
        return new ASN1ObjectDescriptor(ASN1GraphicString.createPrimitive(arg1));
    }

    void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        arg2.writeIdentifier(arg3, 7);
        this.baseGraphicString.encode(arg2, false);
    }

    boolean encodeConstructed() {
        return 0;
    }

    int encodedLength(boolean arg1) {
        return this.baseGraphicString.encodedLength(arg1);
    }

    public ASN1GraphicString getBaseGraphicString() {
        return this.baseGraphicString;
    }

    public static ASN1ObjectDescriptor getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ASN1ObjectDescriptor)) {
            }
            else {
                if((arg3 instanceof ASN1Encodable)) {
                    ASN1Primitive v0 = arg3.toASN1Primitive();
                    if((v0 instanceof ASN1ObjectDescriptor)) {
                        return ((ASN1ObjectDescriptor)v0);
                    }
                }
                else if((arg3 instanceof byte[])) {
                    try {
                        return ASN1ObjectDescriptor.TYPE.fromByteArray(((byte[])arg3));
                    }
                    catch(IOException v3) {
                        throw new IllegalArgumentException("failed to construct object descriptor from byte[]: " + v3.getMessage());
                    }
                }

                throw new IllegalArgumentException("illegal object in getInstance: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public static ASN1ObjectDescriptor getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1ObjectDescriptor.TYPE.getContextTagged(arg1, arg2);
    }

    public static ASN1ObjectDescriptor getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1ObjectDescriptor.TYPE.getTagged(arg1, arg2);
    }

    public int hashCode() {
        return ~this.baseGraphicString.hashCode();
    }

    ASN1Primitive toDERObject() {
        ASN1Primitive v0 = this.baseGraphicString.toDERObject();
        if(v0 == this.baseGraphicString) {
            return this;
        }

        return new ASN1ObjectDescriptor(((ASN1GraphicString)v0));
    }

    ASN1Primitive toDLObject() {
        ASN1Primitive v0 = this.baseGraphicString.toDLObject();
        if(v0 == this.baseGraphicString) {
            return this;
        }

        return new ASN1ObjectDescriptor(((ASN1GraphicString)v0));
    }
}

