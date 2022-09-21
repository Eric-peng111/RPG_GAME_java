package game;

import gameobjects.Item;
import gameobjects.ItemContainer;
import gameobjects.WeaponContainer;
import gameobjects.Weapons;
import globals.ItemType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class DataInit {

    public ItemContainer ic;
    public WeaponContainer wc;
    public ArrayList<String> objects;

    DataInit(){
        init_t();
        init_w();
        getObjects();
    }
    Path path = Paths.get("src");

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

    public void getObjects(){
        this.objects=new ArrayList<>();
        for(Weapons w:this.wc){
            objects.add(w.getName());
        }
        for(Item i:this.ic){
            objects.add(i.getName());
        }
    }

    private ItemType convert(String s){
        if(s.toLowerCase().equals("heal"))
            return ItemType.HEAL;
        else if (s.toLowerCase().equals("buff"))
            return ItemType.BUFF;
        else
            return null;
    }


}
