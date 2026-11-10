package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

class LazyEncodedSequence extends ASN1Sequence {
    private byte[] encoded;

    LazyEncodedSequence(byte[] arg1) throws IOException {
        super();
        if(arg1 != null) {
            this.encoded = arg1;
            return;
        }

        throw new NullPointerException("\'encoded\' cannot be null");
    }

    void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        byte[] v0 = this.getContents();
        if(v0 != null) {
            arg2.writeEncodingDL(arg3, 0x30, v0);
            return;
        }

        super.toDLObject().encode(arg2, arg3);
    }

    int encodedLength(boolean arg2) throws IOException {
        byte[] v0 = this.getContents();
        if(v0 != null) {
            return ASN1OutputStream.getLengthOfEncodingDL(arg2, v0.length);
        }

        return super.toDLObject().encodedLength(arg2);
    }

    private void force() {
        String v0 = "malformed ASN.1: ";
        __monitor_enter(this);
        try {
            if(this.encoded != null) {
                ASN1InputStream v1 = new ASN1InputStream(this.encoded, true);
                try {
                    ASN1EncodableVector v2 = v1.readVector();
                    v1.close();
                    this.elements = v2.takeElements();
                    this.encoded = null;
                }
                catch(IOException v1_1) {
                    try {
                        throw new ASN1ParsingException(v0 + v1_1, ((Throwable)v1_1));
                    }
                    catch(Throwable v0_1) {
                        try {
                        label_26:
                            __monitor_exit(this);
                        }
                        catch(Throwable v0_1) {
                            goto label_26;
                        }

                        throw v0_1;
                    }
                }
            }
        }
        catch(Throwable v0_1) {
            goto label_26;
        }

        __monitor_exit(this);
    }

    private byte[] getContents() {
        byte[] v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.encoded;
        }
        catch(Throwable v0) {
            try {
            label_5:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_5;
            }

            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    public ASN1Encodable getObjectAt(int arg1) {
        this.force();
        return super.getObjectAt(arg1);
    }

    public Enumeration getObjects() {
        byte[] v0 = this.getContents();
        if(v0 != null) {
            return new LazyConstructionEnumeration(v0);
        }

        return super.getObjects();
    }

    public int hashCode() {
        this.force();
        return super.hashCode();
    }

    public Iterator iterator() {
        this.force();
        return super.iterator();
    }

    public int size() {
        this.force();
        return super.size();
    }

    ASN1BitString toASN1BitString() {
        return this.toDLObject().toASN1BitString();
    }

    ASN1External toASN1External() {
        return this.toDLObject().toASN1External();
    }

    ASN1OctetString toASN1OctetString() {
        return this.toDLObject().toASN1OctetString();
    }

    ASN1Set toASN1Set() {
        return this.toDLObject().toASN1Set();
    }

    public ASN1Encodable[] toArray() {
        this.force();
        return super.toArray();
    }

    ASN1Encodable[] toArrayInternal() {
        this.force();
        return super.toArrayInternal();
    }

    ASN1Primitive toDERObject() {
        this.force();
        return super.toDERObject();
    }

    ASN1Primitive toDLObject() {
        this.force();
        return super.toDLObject();
    }
}

