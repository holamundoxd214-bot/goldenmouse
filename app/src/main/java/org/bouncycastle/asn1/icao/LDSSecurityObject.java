package org.bouncycastle.asn1.icao;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class LDSSecurityObject extends ASN1Object implements ICAOObjectIdentifiers {
    private DataGroupHash[] datagroupHash;
    private AlgorithmIdentifier digestAlgorithmIdentifier;
    public static final int ub_DataGroups = 16;
    private ASN1Integer version;
    private LDSVersionInfo versionInfo;

    private LDSSecurityObject(ASN1Sequence arg4) {
        super();
        this.version = new ASN1Integer(0);
        if(arg4 != null && arg4.size() != 0) {
            Enumeration v4 = arg4.getObjects();
            this.version = ASN1Integer.getInstance(v4.nextElement());
            this.digestAlgorithmIdentifier = AlgorithmIdentifier.getInstance(v4.nextElement());
            ASN1Sequence v0 = ASN1Sequence.getInstance(v4.nextElement());
            if(this.version.hasValue(1)) {
                this.versionInfo = LDSVersionInfo.getInstance(v4.nextElement());
            }

            this.checkDatagroupHashSeqSize(v0.size());
            this.datagroupHash = new DataGroupHash[v0.size()];
            int v4_1;
            for(v4_1 = 0; v4_1 < v0.size(); ++v4_1) {
                this.datagroupHash[v4_1] = DataGroupHash.getInstance(v0.getObjectAt(v4_1));
            }

            return;
        }

        throw new IllegalArgumentException("null or empty sequence passed.");
    }

    public LDSSecurityObject(AlgorithmIdentifier arg4, DataGroupHash[] arg5) {
        super();
        this.version = new ASN1Integer(0);
        this.version = new ASN1Integer(0);
        this.digestAlgorithmIdentifier = arg4;
        this.datagroupHash = this.copy(arg5);
        this.checkDatagroupHashSeqSize(arg5.length);
    }

    public LDSSecurityObject(AlgorithmIdentifier arg4, DataGroupHash[] arg5, LDSVersionInfo arg6) {
        super();
        this.version = new ASN1Integer(0);
        this.version = new ASN1Integer(1);
        this.digestAlgorithmIdentifier = arg4;
        this.datagroupHash = this.copy(arg5);
        this.versionInfo = arg6;
        this.checkDatagroupHashSeqSize(arg5.length);
    }

    private void checkDatagroupHashSeqSize(int arg1) {
        if(arg1 >= 2 && arg1 <= 16) {
            return;
        }

        throw new IllegalArgumentException("wrong size in DataGroupHashValues : not in (2..16)");
    }

    private DataGroupHash[] copy(DataGroupHash[] arg3) {
        int v2 = arg3.length;
        DataGroupHash[] v0 = new DataGroupHash[v2];
        System.arraycopy(arg3, 0, v0, 0, v2);
        return v0;
    }

    public DataGroupHash[] getDatagroupHash() {
        return this.copy(this.datagroupHash);
    }

    public AlgorithmIdentifier getDigestAlgorithmIdentifier() {
        return this.digestAlgorithmIdentifier;
    }

    public static LDSSecurityObject getInstance(Object arg1) {
        if((arg1 instanceof LDSSecurityObject)) {
            return arg1;
        }

        if(arg1 != null) {
            return new LDSSecurityObject(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public int getVersion() {
        return this.version.intValueExact();
    }

    public LDSVersionInfo getVersionInfo() {
        return this.versionInfo;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(4);
        v0.add(this.version);
        v0.add(this.digestAlgorithmIdentifier);
        v0.add(new DERSequence(this.datagroupHash));
        LDSVersionInfo v3 = this.versionInfo;
        if(v3 != null) {
            v0.add(((ASN1Encodable)v3));
        }

        return new DERSequence(v0);
    }
}

