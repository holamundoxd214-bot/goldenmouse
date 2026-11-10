package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class BasicOCSPResponse extends ASN1Object {
    private ASN1Sequence certs;
    private DERBitString signature;
    private AlgorithmIdentifier signatureAlgorithm;
    private ResponseData tbsResponseData;

    private BasicOCSPResponse(ASN1Sequence arg4) {
        super();
        this.tbsResponseData = ResponseData.getInstance(arg4.getObjectAt(0));
        this.signatureAlgorithm = AlgorithmIdentifier.getInstance(arg4.getObjectAt(1));
        this.signature = arg4.getObjectAt(2);
        int v2 = 3;
        if(arg4.size() > v2) {
            this.certs = ASN1Sequence.getInstance(arg4.getObjectAt(v2), true);
        }
    }

    public BasicOCSPResponse(ResponseData arg1, AlgorithmIdentifier arg2, DERBitString arg3, ASN1Sequence arg4) {
        super();
        this.tbsResponseData = arg1;
        this.signatureAlgorithm = arg2;
        this.signature = arg3;
        this.certs = arg4;
    }

    public ASN1Sequence getCerts() {
        return this.certs;
    }

    public static BasicOCSPResponse getInstance(Object arg1) {
        if((arg1 instanceof BasicOCSPResponse)) {
            return arg1;
        }

        if(arg1 != null) {
            return new BasicOCSPResponse(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static BasicOCSPResponse getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return BasicOCSPResponse.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public DERBitString getSignature() {
        return this.signature;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public ResponseData getTbsResponseData() {
        return this.tbsResponseData;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(4);
        v0.add(this.tbsResponseData);
        v0.add(this.signatureAlgorithm);
        v0.add(this.signature);
        if(this.certs != null) {
            v0.add(new DERTaggedObject(true, 0, this.certs));
        }

        return new DERSequence(v0);
    }
}

