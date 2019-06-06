package dinoscientist.components;

import dinoscientist.interfaces.IClient;

public class Patient implements IClient {

    @Override
    public int test() {
        return 1;
    }
}