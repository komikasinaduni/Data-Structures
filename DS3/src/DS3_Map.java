import java.util.ArrayList;
public class DS3_Map <K, V> implements MapInterface<K, V>{
    private ArrayList<MapEnt<K, V>> data;
    public DS3_Map(){
        data = new ArrayList<>();
    }
    public void clear() {
        data.clear();
    }
    public boolean containsKey(K key) {
        for(int i = data.size()-1; i>=0; i++){
            if(data.get(i).getKey()==key){
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(V value) {
        for(int i = data.size()-1; i>=0; i++){
            if(data.get(i).getValue()==value){
                return true;
            }
        }
        return false;
    }

    public DS3_Set<MapEnt<K, V>> entrySet(){
        DS3_Set<MapEnt<K, V>> yo = new DS3_Set<>();
        for(int i = data.size()-1; i>=0; i++){
            yo.add(data.get(i));
        }
        return yo;
    }

    public V get(K o) {
        for(int i = data.size()-1; i>=0; i++){
            if(o==data.get(i).getKey()){
                return data.get(i).getValue();
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public V put(K key, V value) {
        for(int i = data.size()-1; i>=0; i++){
            if(get(key)==get(data.get(i).getKey())){
                V yo = data.get(i).getValue();
                data.get(i).setValue(value);
                return yo;
            }
        }
        data.add(new MapEnt(key, value));
        return null;
    }

    public int size() {
        return data.size();
    }

    public DS3_Set<K> keySet() {
        DS3_Set<K> yo2 = new DS3_Set<>();
        for(int i = 0; i< data.size(); i++){
            for(int j = 0; j<data.size(); j++){
                if(data.get(i).getKey()==data.get(j).getKey()){
                    j= data.size()-1;
                } else{
                    yo2.add(data.get(i).getKey());
                }
            }
        }
        return yo2;
    }

    public ArrayList<V> values() {
        ArrayList<V> yo = new ArrayList<>();
        for(int i = data.size()-1; i>=0; i++) {
            yo.add(get(data.get(i).getKey()));
        }
        return yo;
    }

    public V remove(K key) {
        return get(key);
    }

}
