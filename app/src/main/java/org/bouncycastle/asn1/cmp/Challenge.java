package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.EnvelopedData;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.GeneralName;

public class Challenge extends ASN1Object {
    public class Rand extends ASN1Object {
        private final ASN1Integer integer;
        private final GeneralName sender;

        public Rand(ASN1Integer arg1, GeneralName arg2) {
            super();
            this.integer = arg1;
            this.sender = arg2;
        }

        private Rand(ASN1Sequence arg3) {
            super();
            if(arg3.size() == 2) {
                this.integer = ASN1Integer.getInstance(arg3.getObjectAt(0));
                this.sender = GeneralName.getInstance(arg3.getObjectAt(1));
                return;
            }

            throw new IllegalArgumentException("expected sequence size of 2");
        }

        public Rand(byte[] arg2, GeneralName arg3) {
            this(new ASN1Integer(arg2), arg3);
        }

        public static Rand getInstance(Object arg1) {
            if((arg1 instanceof Rand)) {
                return arg1;
            }

            if(arg1 != null) {
                return new Rand(ASN1Sequence.getInstance(arg1));
            }

            return null;
        }

        public ASN1Integer getInt() {
            return this.integer;
        }

        public GeneralName getSender() {
            return this.sender;
        }

        public ASN1Primitive toASN1Primitive() {
            return new DERSequence(new ASN1Encodable[]{this.integer, this.sender});
        }
    }

    private final ASN1OctetString challenge;
    private final EnvelopedData encryptedRand;
    private final AlgorithmIdentifier owf;
    private final ASN1OctetString witness;

    private Challenge(ASN1Sequence arg6) {
        super();
        int v0 = 0;
        AlgorithmIdentifier v2 = null;
        if((arg6.getObjectAt(0).toASN1Primitive() instanceof ASN1Sequence)) {
            this.owf = AlgorithmIdentifier.getInstance(arg6.getObjectAt(0));
            v0 = 1;
        }
        else {
            this.owf = v2;
        }

        int v1 = v0 + 1;
        this.witness = ASN1OctetString.getInstance(arg6.getObjectAt(v0));
        v0 += 2;
        ASN1OctetString v1_1 = ASN1OctetString.getInstance(arg6.getObjectAt(v1));
        this.challenge = v1_1;
        if(arg6.size() > v0) {
            if(v1_1.getOctets().length == 0) {
                this.encryptedRand = EnvelopedData.getInstance(ASN1TaggedObject.getInstance(arg6.getObjectAt(v0)), true);
                return;
            }

            throw new IllegalArgumentException("ambigous challenge");
        }

        this.encryptedRand = ((EnvelopedData)v2);
    }

    public Challenge(AlgorithmIdentifier arg1, byte[] arg2, EnvelopedData arg3) {
        super();
        this.owf = arg1;
        this.witness = new DEROctetString(arg2);
        this.challenge = new DEROctetString(new byte[0]);
        this.encryptedRand = arg3;
    }

    public Challenge(AlgorithmIdentifier arg1, byte[] arg2, byte[] arg3) {
        super();
        this.owf = arg1;
        this.witness = new DEROctetString(arg2);
        this.challenge = new DEROctetString(arg3);
        this.encryptedRand = null;
    }

    public Challenge(byte[] arg2, EnvelopedData arg3) {
        this(null, arg2, arg3);
    }

    public Challenge(byte[] arg2, byte[] arg3) {
        this(null, arg2, arg3);
    }

    public byte[] getChallenge() {
        return this.challenge.getOctets();
    }

    public EnvelopedData getEncryptedRand() {
        return this.encryptedRand;
    }

    public static Challenge getInstance(Object arg1) {
        if((arg1 instanceof Challenge)) {
            return arg1;
        }

        if(arg1 != null) {
            return new Challenge(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public AlgorithmIdentifier getOwf() {
        return this.owf;
    }

    public byte[] getWitness() {
        return this.witness.getOctets();
    }

    public boolean isEncryptedRand() {
        if(this.encryptedRand != null) {
            return 1;
        }

        return 0;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.addOptional(this.owf);
        v0.add(this.witness);
        v0.add(this.challenge);
        if(this.encryptedRand != null) {
            v0.add(new DERTaggedObject(0, this.encryptedRand));
        }

        return new DERSequence(v0);
    }
}

