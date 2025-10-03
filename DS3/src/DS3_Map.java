import java.util.ArrayList;

import java.util.Iterator;

public class DS3_Map <K, V> implements MapInterface<K, V>{
    private ArrayList<MapEnt> data;
    public DS3_Map(){
        data = new ArrayList<>();

    }
    public void clear() {

    }

    public boolean containsKey(K key) {
        return false;
    }

    public boolean containsValue(V value) {
        return false;
    }

    public DS3_Set<MapEnt<K, V>> entrySet() {
        return null;
    }

    public V get(K o) {
        for(int i = data.size()-1; i>=0; i++){
            if(o==data.get(i).getKey()){
                return (V) data.get(i).getValue();
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return false;
    }

    public V put(K key, V value) {
        for(int i = data.size()-1; i>=0; i++){
            if(data.get(i).getValue()!=value){
                V yo = (V) data.get(i).getValue();
                data.add(new MapEnt(key, value));
                return yo;
            }
        }
        data.add(new MapEnt(key, value));
        return null;
    }

    public int size() {
        return 0;
    }

    public DS3_Set<K> keySet() {
        DS3_Set<K> yo2 = new DS3_Set<>();
        for(int i = 0; i< data.size(); i++){
            for(int j = 0; j<data.size(); j++){
                if(data.get(i).getKey()==data.get(j).getKey()){
                    j= data.size()-1;
                } else{
                    yo2.add((K) data.get(i).getKey());
                }
            }
        }
        return yo2;
    }

    public ArrayList<V> values() {
        ArrayList<V> yo = new ArrayList<>();
        for(int i = data.size()-1; i>=0; i++) {
            yo.add(get((K) data.get(i).getKey()));
        }
        return yo;
    }

    public V remove(K key) {
        return get(key);
    }

}
