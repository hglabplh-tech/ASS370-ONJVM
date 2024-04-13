package hgp.utils;

import java.io.File;
import java.math.BigInteger;
import java.util.Map;

public class DASDArchitecture {


    public DASDArchitecture (File dasdFile, BigInteger dasdSize) {

    }

    public int dasdFormat () {
        return 0;
    }

    public static class DASDMiniDisk {
        private Map<String, DASDFCB> fat = new SizedLinkedMAP<String, DASDFCB>(10, 400);

    }
    public static class DASDAdressChain {

    }

    public static class DASDChainElement {

    }

    public static class DASDFCB {

    }


}
