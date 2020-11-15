package ChaveValor;

import org.apache.thrift.TException;
import java.util.HashMap;
import chavevalor.*;

public class ChaveValorHandler implements ChaveValor.Iface {

    private HashMap<Integer, String> kv = new HashMap<>();

    @Override
    public String getKV(int key) throws TException {
        if (kv.containsKey(key)) {
            return kv.get(key);
        } else {
            throw new KeyNotFound();
        }
    }

    @Override
    public String setKV(int key, String valor) throws TException {
        if (kv.containsKey(key)) {
            return kv.get(key);
        }
        kv.put(key, valor);
        return valor;

    }

    @Override
    public void delKV(int key) throws TException {
        kv.remove(key);
    }
}
