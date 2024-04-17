package hgp.utils;

import java.io.*;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;



public class DASDArchitecture implements Serializable, Closeable {

       private DASDMiniDisk miniDisk;

    public DASDArchitecture (File dasdFile, BigInteger dasdSize) {
        try {
            if (dasdFile.exists()) {
                FileInputStream stream =
                        new FileInputStream(dasdFile);
                ObjectInputStream objStream =
                        new ObjectInputStream(stream);
                this.miniDisk = (DASDMiniDisk) objStream.readObject();
                objStream.close();
            } else {
                FileOutputStream out = new FileOutputStream(dasdFile);
                ObjectOutputStream objOut = new ObjectOutputStream(out);
                objOut.writeObject(miniDisk);
                objOut.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalStateException("disk init failed", e);
        }
    }


    @Override
    public void close() throws IOException {

    }

    public static class DASDMiniDisk implements Serializable {
        private Map<String, DASDFCB> fat = new SizedLinkedMAP<String, DASDFCB>(10, 1000);

    }
    public static class DASDAddressChain implements Serializable {
        private List<DASDChainElement> theChain = new LinkedList<>();

    }

    public static class DASDChainElement implements Serializable{
            Byte[] block  = new Byte[Short.MAX_VALUE];

    }

    public static class DASDFCB implements Serializable {
        private final DASDAddressChain file_chained_contet;

        private final String fileName;

        private final String fileType;

        private final RecordType recordType ; // here  we make a enum

        private final Integer recLength;

        private final Character diskChar;

        public DASDFCB(DASDAddressChain file_chained_contet,
                       String fileName, String fileType,
                       RecordType recordType, Integer recLength,
                       Character diskChar) {
            this.file_chained_contet = file_chained_contet;
            this.fileName = fileName;
            this.fileType = fileType;
            this.recordType = recordType;
            this.recLength = recLength;
            this.diskChar = diskChar;
        }

        public enum   RecordType {
            V("V"),
            F("F");

            private final String recTypeString;
            RecordType(String recTypeStr) {
                this.recTypeString = recTypeStr;
            }


        }
    }


}
