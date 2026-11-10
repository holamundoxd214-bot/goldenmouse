package org.bouncycastle.asn1.crmf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

public class CertTemplate extends ASN1Object {
    private Extensions extensions;
    private X500Name issuer;
    private ASN1BitString issuerUID;
    private SubjectPublicKeyInfo publicKey;
    private ASN1Sequence seq;
    private ASN1Integer serialNumber;
    private AlgorithmIdentifier signingAlg;
    private X500Name subject;
    private ASN1BitString subjectUID;
    private OptionalValidity validity;
    private ASN1Integer version;

    private CertTemplate(ASN1Sequence arg5) {
        super();
        this.seq = arg5;
        Enumeration v5 = arg5.getObjects();
        while(v5.hasMoreElements()) {
            Object v0 = v5.nextElement();
            switch(((ASN1TaggedObject)v0).getTagNo()) {
                case 0: {
                    goto label_47;
                }
                case 1: {
                    goto label_44;
                }
                case 2: {
                    goto label_41;
                }
                case 3: {
                    goto label_38;
                }
                case 4: {
                    goto label_34;
                }
                case 5: {
                    goto label_31;
                }
                case 6: {
                    goto label_28;
                }
                case 7: {
                    goto label_25;
                }
                case 8: {
                    goto label_22;
                }
                case 9: {
                    goto label_19;
                }
            }

            throw new IllegalArgumentException("unknown tag: " + ((ASN1TaggedObject)v0).getTagNo());
        label_34:
            this.validity = OptionalValidity.getInstance(ASN1Sequence.getInstance(((ASN1TaggedObject)v0), false));
            continue;
        label_19:
            this.extensions = Extensions.getInstance(((ASN1TaggedObject)v0), false);
            continue;
        label_38:
            this.issuer = X500Name.getInstance(((ASN1TaggedObject)v0), true);
            continue;
        label_22:
            this.subjectUID = ASN1BitString.getInstance(((ASN1TaggedObject)v0), false);
            continue;
        label_41:
            this.signingAlg = AlgorithmIdentifier.getInstance(((ASN1TaggedObject)v0), false);
            continue;
        label_25:
            this.issuerUID = ASN1BitString.getInstance(((ASN1TaggedObject)v0), false);
            continue;
        label_44:
            this.serialNumber = ASN1Integer.getInstance(((ASN1TaggedObject)v0), false);
            continue;
        label_28:
            this.publicKey = SubjectPublicKeyInfo.getInstance(((ASN1TaggedObject)v0), false);
            continue;
        label_47:
            this.version = ASN1Integer.getInstance(((ASN1TaggedObject)v0), false);
            continue;
        label_31:
            this.subject = X500Name.getInstance(((ASN1TaggedObject)v0), true);
        }
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public static CertTemplate getInstance(Object arg1) {
        if((arg1 instanceof CertTemplate)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CertTemplate(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public X500Name getIssuer() {
        return this.issuer;
    }

    public ASN1BitString getIssuerUID() {
        return this.issuerUID;
    }

    public SubjectPublicKeyInfo getPublicKey() {
        return this.publicKey;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public AlgorithmIdentifier getSigningAlg() {
        return this.signingAlg;
    }

    public X500Name getSubject() {
        return this.subject;
    }

    public ASN1BitString getSubjectUID() {
        return this.subjectUID;
    }

    public OptionalValidity getValidity() {
        return this.validity;
    }

    public int getVersion() {
        ASN1Integer v0 = this.version;
        if(v0 != null) {
            return v0.intValueExact();
        }

        return -1;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }
}

