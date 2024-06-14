package Generic;

import Excepciones.ExisteException;
import Excepciones.NoExisteException;
import Interfaz.IFiltrado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Conteiner <Integer,K extends IFiltrado> {

    private String nombre;
    private HashMap<Integer,K> conteiner;

    public Conteiner(String nombre){
        this.nombre = nombre;
        this.conteiner = new HashMap<>();
    }

    public void agregar (Integer key , K value) throws ExisteException {
        if(conteiner.containsKey(key)){
            throw new ExisteException("No se puede agregar "+ value.toString());
        }
        conteiner.put(key,value);

    }

    public HashMap<Integer,K> obtenerMapa(){
        return conteiner;
    }

    public K obterPorId (Integer key) throws NoExisteException {
        if(!conteiner.containsKey(key)){
            throw new NoExisteException("No se encontro ese id");
        }
        return conteiner.get(key);
    }

    public void eliminar(Integer key){
        conteiner.remove(key);
    }

    public ArrayList<K> mostrarPorGenero(String genero){

        ArrayList<K> listaPorGenero = new ArrayList<>();

        Iterator<Map.Entry<Integer,K>> iterator = conteiner.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, K> entry = iterator.next();
            if(entry.getValue().buscarPorGenero().equalsIgnoreCase(genero)){
                listaPorGenero.add(entry.getValue());
            }

        }

        return listaPorGenero;
    }

    public void Modificar (Integer key, int opcion, String modificacion) throws NoExisteException{

        Iterator<Map.Entry<Integer,K>> iterator = conteiner.entrySet().iterator();
        boolean resultado = false;
        while (iterator.hasNext()) {
            Map.Entry<Integer, K> entry = iterator.next();
            if(entry.getKey() == key){
                entry.getValue().modificar(opcion,modificacion);
                resultado = true;
                return;
            }
        }

        throw new NoExisteException("No se encontro el dato a modificar");
    }

}
