package game;

import gameobjects.Item;
import gameobjects.ItemContainer;
import gameobjects.WeaponContainer;
import gameobjects.Weapons;
import globals.ItemType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
/** Class to read and save data from Json files
 * @author Enze Peng
 */
public class DataInit {
    /** Represents the items stored
     */
    public ItemContainer ic;
    /** Represents the weapons stored
     */
    public WeaponContainer wc;
    /** Represents Strings to be converted into weapons and items
     */
    public ArrayList<String> objects;
    /**
     * Class Constructor for DataInit
     * @author Enze Peng
     */
    DataInit(){
        init_t();
        init_w();
        getObjects();
    }
    /** Represents filepath to be used when reading and storing data
     */
    Path path = Paths.get("src");
    /**
     * Method to read items from the stored Json file
     * @author Enze Peng
     * @return - ItemContainer of all the items read
     */
    public ItemContainer init_t(){

        this.ic=new ItemContainer();

        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader(path.toAbsolutePath()+"/game/Json/items.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray em= (JSONArray) jsonObject.get("items");
            Iterator itr=em.iterator();
            while(itr.hasNext()){
                JSONObject e=(JSONObject)itr.next();
                int price=Integer.parseInt(e.get("price").toString());
                int impact=Integer.parseInt( e.get("impact").toString());
                this.ic.add(new Item((String)e.get("name"),(String)e.get("description"),price,
                        impact,convert((String)e.get("type"))));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return ic;
    }
    /**
     * Method to read weapons from the stored Json file
     * @author Enze Peng
     * @return - WeaponContainer of all the items read
     */
    public WeaponContainer init_w(){

        this.wc= new WeaponContainer();

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(path.toAbsolutePath()+"/game/Json/weapon.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray em= (JSONArray) jsonObject.get("Weapons");
            Iterator itr=em.iterator();
            while(itr.hasNext()){
                JSONObject e=(JSONObject)itr.next();
                int price=Integer.parseInt(e.get("price").toString());
                int attack=Integer.parseInt(e.get("attack").toString());
                this.wc.add(new Weapons((String)e.get("name"),(String)e.get("description"),price,attack));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return wc;
    }
    /**
     * Method to convert weapons and items into Strings
     * @author Enze Peng
     */
    public void getObjects(){
        this.objects=new ArrayList<>();
        for(Weapons w:this.wc){
            objects.add(w.getName());
        }
        for(Item i:this.ic){
            objects.add(i.getName());
        }
    }
    /**
     * Method to convert between String and ItemType
     * @author Enze Peng
     * @param s - String to be converted to ItemType
     * @return - ItemType represented by the input String
     */
    private ItemType convert(String s){
        if(s.toLowerCase().equals("heal"))
            return ItemType.HEAL;
        else if (s.toLowerCase().equals("buff"))
            return ItemType.BUFF;
        else
            return null;
    }


}
