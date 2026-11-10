package cafe.cryptography.curve25519;

public class RistrettoGeneratorTable {
    final EdwardsBasepointTable table;

    public RistrettoGeneratorTable(RistrettoElement arg2) {
        super();
        this.table = new EdwardsBasepointTable(arg2.repr);
    }

    public RistrettoElement multiply(Scalar arg2) {
        return new RistrettoElement(this.table.multiply(arg2));
    }
}

