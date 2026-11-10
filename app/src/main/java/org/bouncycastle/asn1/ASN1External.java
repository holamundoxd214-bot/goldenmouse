package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Objects;

public abstract class ASN1External extends ASN1Primitive {
    class org.bouncycastle.asn1.ASN1External$1 extends ASN1UniversalType {
        org.bouncycastle.asn1.ASN1External$1(Class arg1, int arg2) {
            super(arg1, arg2);
        }

        ASN1Primitive fromImplicitConstructed(ASN1Sequence arg1) {
            return arg1.toASN1External();
        }
    }

    static final ASN1UniversalType TYPE;
    ASN1Primitive dataValueDescriptor;
    ASN1ObjectIdentifier directReference;
    int encoding;
    ASN1Primitive externalContent;
    ASN1Integer indirectReference;

    static {
        ASN1External.TYPE = new org.bouncycastle.asn1.ASN1External$1(ASN1External.class, 8);
    }

    ASN1External(ASN1ObjectIdentifier arg1, ASN1Integer arg2, ASN1Primitive arg3, int arg4, ASN1Primitive arg5) {
        super();
        this.directReference = arg1;
        this.indirectReference = arg2;
        this.dataValueDescriptor = arg3;
        this.encoding = ASN1External.checkEncoding(arg4);
        this.externalContent = ASN1External.checkExternalContent(arg4, arg5);
    }

    ASN1External(ASN1ObjectIdentifier arg1, ASN1Integer arg2, ASN1Primitive arg3, DERTaggedObject arg4) {
        super();
        this.directReference = arg1;
        this.indirectReference = arg2;
        this.dataValueDescriptor = arg3;
        this.encoding = ASN1External.checkEncoding(arg4.getTagNo());
        this.externalContent = ASN1External.getExternalContent(((ASN1TaggedObject)arg4));
    }

    ASN1External(ASN1Sequence arg5) {
        super();
        int v0 = 0;
        ASN1Primitive v1 = ASN1External.getObjFromSequence(arg5, 0);
        if((v1 instanceof ASN1ObjectIdentifier)) {
            this.directReference = ((ASN1ObjectIdentifier)v1);
            v1 = ASN1External.getObjFromSequence(arg5, 1);
            v0 = 1;
        }

        if((v1 instanceof ASN1Integer)) {
            this.indirectReference = ((ASN1Integer)v1);
            ++v0;
            v1 = ASN1External.getObjFromSequence(arg5, v0);
        }

        if(!(v1 instanceof ASN1TaggedObject)) {
            this.dataValueDescriptor = v1;
            ++v0;
            v1 = ASN1External.getObjFromSequence(arg5, v0);
        }

        if(arg5.size() == v0 + 1) {
            if((v1 instanceof ASN1TaggedObject)) {
                this.encoding = ASN1External.checkEncoding(((ASN1TaggedObject)v1).getTagNo());
                this.externalContent = ASN1External.getExternalContent(((ASN1TaggedObject)v1));
                return;
            }

            throw new IllegalArgumentException("No tagged object found in sequence. Structure doesn\'t seem to be of type External");
        }

        throw new IllegalArgumentException("input sequence too large");
    }

    boolean asn1Equals(ASN1Primitive arg5) {
        if(this == (((ASN1External)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ASN1External)) {
            return 0;
        }

        if((Objects.areEqual(this.directReference, ((ASN1External)arg5).directReference)) && (Objects.areEqual(this.indirectReference, ((ASN1External)arg5).indirectReference)) && (Objects.areEqual(this.dataValueDescriptor, ((ASN1External)arg5).dataValueDescriptor)) && this.encoding == ((ASN1External)arg5).encoding && (this.externalContent.equals(((ASN1External)arg5).externalContent))) {
            return 1;
        }

        return 0;
    }

    abstract ASN1Sequence buildSequence();

    private static int checkEncoding(int arg3) {
        if(arg3 >= 0 && arg3 <= 2) {
            return arg3;
        }

        throw new IllegalArgumentException("invalid encoding value: " + arg3);
    }

    private static ASN1Primitive checkExternalContent(int arg1, ASN1Primitive arg2) {
        ASN1UniversalType v1;
        if(arg1 == 1) {
            v1 = ASN1OctetString.TYPE;
        }
        else if(arg1 != 2) {
            return arg2;
        }
        else {
            v1 = ASN1BitString.TYPE;
        }

        return v1.checkedCast(arg2);
    }

    void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        arg2.writeIdentifier(arg3, 40);
        this.buildSequence().encode(arg2, false);
    }

    boolean encodeConstructed() {
        return 1;
    }

    int encodedLength(boolean arg1) throws IOException {
        return this.buildSequence().encodedLength(arg1);
    }

    public ASN1Primitive getDataValueDescriptor() {
        return this.dataValueDescriptor;
    }

    public ASN1ObjectIdentifier getDirectReference() {
        return this.directReference;
    }

    public int getEncoding() {
        return this.encoding;
    }

    private static ASN1Primitive getExternalContent(ASN1TaggedObject arg3) {
        ASN1Util.checkContextTagClass(arg3);
        int v0 = arg3.getTagNo();
        if(v0 != 0) {
            if(v0 != 1) {
                if(v0 == 2) {
                    return ASN1BitString.getInstance(arg3, false);
                }

                throw new IllegalArgumentException("invalid tag: " + ASN1Util.getTagText(arg3));
            }

            return ASN1OctetString.getInstance(arg3, false);
        }

        return arg3.getExplicitBaseObject().toASN1Primitive();
    }

    public ASN1Primitive getExternalContent() {
        return this.externalContent;
    }

    public ASN1Integer getIndirectReference() {
        return this.indirectReference;
    }

    public static ASN1External getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ASN1External)) {
            }
            else {
                if((arg3 instanceof ASN1Encodable)) {
                    ASN1Primitive v0 = arg3.toASN1Primitive();
                    if((v0 instanceof ASN1External)) {
                        return ((ASN1External)v0);
                    }
                }
                else if((arg3 instanceof byte[])) {
                    try {
                        return ASN1External.TYPE.fromByteArray(((byte[])arg3));
                    }
                    catch(IOException v3) {
                        throw new IllegalArgumentException("failed to construct external from byte[]: " + v3.getMessage());
                    }
                }

                throw new IllegalArgumentException("illegal object in getInstance: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public static ASN1External getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1External.TYPE.getContextTagged(arg1, arg2);
    }

    private static ASN1Primitive getObjFromSequence(ASN1Sequence arg1, int arg2) {
        if(arg1.size() > arg2) {
            return arg1.getObjectAt(arg2).toASN1Primitive();
        }

        throw new IllegalArgumentException("too few objects in input sequence");
    }

    public static ASN1External getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1External.TYPE.getTagged(arg1, arg2);
    }

    public int hashCode() {
        return this.externalContent.hashCode() ^ (Objects.hashCode(this.directReference) ^ Objects.hashCode(this.indirectReference) ^ Objects.hashCode(this.dataValueDescriptor) ^ this.encoding);
    }

    ASN1Primitive toDERObject() {
        return new DERExternal(this.directReference, this.indirectReference, this.dataValueDescriptor, this.encoding, this.externalContent);
    }

    ASN1Primitive toDLObject() {
        return new DLExternal(this.directReference, this.indirectReference, this.dataValueDescriptor, this.encoding, this.externalContent);
    }
}

