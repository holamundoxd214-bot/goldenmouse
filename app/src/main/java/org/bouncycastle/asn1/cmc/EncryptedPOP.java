package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

public class EncryptedPOP extends ASN1Object {
    private final ContentInfo cms;
    private final TaggedRequest request;
    private final AlgorithmIdentifier thePOPAlgID;
    private final byte[] witness;
    private final AlgorithmIdentifier witnessAlgID;

    private EncryptedPOP(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 5) {
            this.request = TaggedRequest.getInstance(arg3.getObjectAt(0));
            this.cms = ContentInfo.getInstance(arg3.getObjectAt(1));
            this.thePOPAlgID = AlgorithmIdentifier.getInstance(arg3.getObjectAt(2));
            this.witnessAlgID = AlgorithmIdentifier.getInstance(arg3.getObjectAt(3));
            this.witness = Arrays.clone(ASN1OctetString.getInstance(arg3.getObjectAt(4)).getOctets());
            return;
        }

        throw new IllegalArgumentException("incorrect sequence size");
    }

    public EncryptedPOP(TaggedRequest arg1, ContentInfo arg2, AlgorithmIdentifier arg3, AlgorithmIdentifier arg4, byte[] arg5) {
        super();
        this.request = arg1;
        this.cms = arg2;
        this.thePOPAlgID = arg3;
        this.witnessAlgID = arg4;
        this.witness = Arrays.clone(arg5);
    }

    public ContentInfo getCms() {
        return this.cms;
    }

    public static EncryptedPOP getInstance(Object arg1) {
        if((arg1 instanceof EncryptedPOP)) {
            return arg1;
        }

        if(arg1 != null) {
            return new EncryptedPOP(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public TaggedRequest getRequest() {
        return this.request;
    }

    public AlgorithmIdentifier getThePOPAlgID() {
        return this.thePOPAlgID;
    }

    public byte[] getWitness() {
        return Arrays.clone(this.witness);
    }

    public AlgorithmIdentifier getWitnessAlgID() {
        return this.witnessAlgID;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(5);
        v0.add(this.request);
        v0.add(this.cms);
        v0.add(this.thePOPAlgID);
        v0.add(this.witnessAlgID);
        v0.add(new DEROctetString(this.witness));
        return new DERSequence(v0);
    }
}

