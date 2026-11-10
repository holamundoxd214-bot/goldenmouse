package org.bouncycastle.asn1.cmc;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CertificationRequest extends ASN1Object {
    class org.bouncycastle.asn1.cmc.CertificationRequest$1 {
    }

    class CertificationRequestInfo extends ASN1Object {
        private final ASN1Set attributes;
        private final X500Name subject;
        private final ASN1Sequence subjectPublicKeyInfo;
        private final ASN1Integer version;

        CertificationRequestInfo(ASN1Sequence arg1, org.bouncycastle.asn1.cmc.CertificationRequest$1 arg2) {
            this(arg1);
        }

        CertificationRequestInfo(X500Name arg1, AlgorithmIdentifier arg2, ASN1BitString arg3, ASN1Set arg4, org.bouncycastle.asn1.cmc.CertificationRequest$1 arg5) {
            this(arg1, arg2, arg3, arg4);
        }

        private CertificationRequestInfo(ASN1Sequence arg4) {
            super();
            if(arg4.size() == 4) {
                this.version = ASN1Integer.getInstance(arg4.getObjectAt(0));
                this.subject = X500Name.getInstance(arg4.getObjectAt(1));
                ASN1Sequence v2 = ASN1Sequence.getInstance(arg4.getObjectAt(2));
                this.subjectPublicKeyInfo = v2;
                if(v2.size() == 2) {
                    ASN1Encodable v4 = arg4.getObjectAt(3);
                    if(((ASN1TaggedObject)v4).getTagNo() == 0) {
                        this.attributes = ASN1Set.getInstance(((ASN1TaggedObject)v4), false);
                        return;
                    }

                    throw new IllegalArgumentException("incorrect tag number on attributes for CertificationRequestInfo");
                }

                throw new IllegalArgumentException("incorrect subjectPublicKeyInfo size for CertificationRequestInfo");
            }

            throw new IllegalArgumentException("incorrect sequence size for CertificationRequestInfo");
        }

        private CertificationRequestInfo(X500Name arg3, AlgorithmIdentifier arg4, ASN1BitString arg5, ASN1Set arg6) {
            super();
            this.version = CertificationRequest.ZERO;
            this.subject = arg3;
            this.subjectPublicKeyInfo = new DERSequence(new ASN1Encodable[]{arg4, arg5});
            this.attributes = arg6;
        }

        static ASN1Integer access$200(CertificationRequestInfo arg0) {
            return arg0.getVersion();
        }

        static X500Name access$300(CertificationRequestInfo arg0) {
            return arg0.getSubject();
        }

        static ASN1Set access$400(CertificationRequestInfo arg0) {
            return arg0.getAttributes();
        }

        static ASN1Sequence access$500(CertificationRequestInfo arg0) {
            return arg0.getSubjectPublicKeyInfo();
        }

        private ASN1Set getAttributes() {
            return this.attributes;
        }

        private X500Name getSubject() {
            return this.subject;
        }

        private ASN1Sequence getSubjectPublicKeyInfo() {
            return this.subjectPublicKeyInfo;
        }

        private ASN1Integer getVersion() {
            return this.version;
        }

        public ASN1Primitive toASN1Primitive() {
            ASN1EncodableVector v0 = new ASN1EncodableVector(4);
            v0.add(this.version);
            v0.add(this.subject);
            v0.add(this.subjectPublicKeyInfo);
            v0.add(new DERTaggedObject(false, 0, this.attributes));
            return new DERSequence(v0);
        }
    }

    private static final ASN1Integer ZERO;
    private final CertificationRequestInfo certificationRequestInfo;
    private final ASN1BitString signature;
    private final AlgorithmIdentifier signatureAlgorithm;

    static {
        CertificationRequest.ZERO = new ASN1Integer(0);
    }

    private CertificationRequest(ASN1Sequence arg4) {
        super();
        if(arg4.size() == 3) {
            this.certificationRequestInfo = new CertificationRequestInfo(ASN1Sequence.getInstance(arg4.getObjectAt(0)), null);
            this.signatureAlgorithm = AlgorithmIdentifier.getInstance(arg4.getObjectAt(1));
            this.signature = ASN1BitString.getInstance(arg4.getObjectAt(2));
            return;
        }

        throw new IllegalArgumentException("incorrect sequence size");
    }

    public CertificationRequest(X500Name arg7, AlgorithmIdentifier arg8, ASN1BitString arg9, ASN1Set arg10, AlgorithmIdentifier arg11, ASN1BitString arg12) {
        super();
        this.certificationRequestInfo = new CertificationRequestInfo(arg7, arg8, arg9, arg10, null);
        this.signatureAlgorithm = arg11;
        this.signature = arg12;
    }

    static ASN1Integer access$600() {
        return CertificationRequest.ZERO;
    }

    public ASN1Set getAttributes() {
        return CertificationRequestInfo.access$400(this.certificationRequestInfo);
    }

    public static CertificationRequest getInstance(Object arg1) {
        if((arg1 instanceof CertificationRequest)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CertificationRequest(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1BitString getSignature() {
        return this.signature;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public X500Name getSubject() {
        return CertificationRequestInfo.access$300(this.certificationRequestInfo);
    }

    public ASN1BitString getSubjectPublicKey() {
        return ASN1BitString.getInstance(CertificationRequestInfo.access$500(this.certificationRequestInfo).getObjectAt(1));
    }

    public AlgorithmIdentifier getSubjectPublicKeyAlgorithm() {
        return AlgorithmIdentifier.getInstance(CertificationRequestInfo.access$500(this.certificationRequestInfo).getObjectAt(0));
    }

    public BigInteger getVersion() {
        return CertificationRequestInfo.access$200(this.certificationRequestInfo).getValue();
    }

    public ASN1Primitive parsePublicKey() throws IOException {
        return ASN1Primitive.fromByteArray(this.getSubjectPublicKey().getOctets());
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.certificationRequestInfo);
        v0.add(this.signatureAlgorithm);
        v0.add(this.signature);
        return new DERSequence(v0);
    }
}

