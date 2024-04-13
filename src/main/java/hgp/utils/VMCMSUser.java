package hgp.utils;

public class VMCMSUser {

    private final VMMemory memory;

    public VMCMSUser () {
        memory = USERBootsTrap.initMemory();
    }
}
