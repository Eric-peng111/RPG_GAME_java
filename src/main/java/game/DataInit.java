package game;

import gameobjects.*;
import globals.ItemType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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
    /** Represents the scanner to receive user input
     */
    private  Scanner scan;
    /**
     * Class Constructor for DataInit
     * @author Enze Peng
     */
    DataInit(){
        init_t();//init item container
        init_w();// init weapon container
        getObjects();// get all name of items and weapons
        scan= new Scanner(System.in);
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
            // setup object from items in items.json
            Object obj = parser.parse(new FileReader(path.toAbsolutePath()+"/main/java/game/Json/items.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray em= (JSONArray) jsonObject.get("items");//items contains multiple objects
            // which needs Json_array to iterate
            Iterator itr=em.iterator();
            while(itr.hasNext()){
                //get each item from json_array
                JSONObject e=(JSONObject)itr.next();
                int price=Integer.parseInt(e.get("price").toString());
                int impact=Integer.parseInt( e.get("impact").toString());
                //collect all info to create new object of item
                // add to ic container
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
            //get object of weapons from weapon.json
            Object obj = parser.parse(new FileReader(path.toAbsolutePath()+"/main/java/game/Json/weapon.json"));
            JSONObject jsonObject = (JSONObject) obj;
            //object contains multiple weapons,needs json_array to collect all weapons
            JSONArray em= (JSONArray) jsonObject.get("Weapons");
            Iterator itr=em.iterator();
            while(itr.hasNext()){
                //iterate all weapons
                JSONObject e=(JSONObject)itr.next();
                int price=Integer.parseInt(e.get("price").toString());
                int attack=Integer.parseInt(e.get("attack").toString());
                //collect all weapons info and attributes
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
        //iterate all weapons and items
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
        //check string is heal or buff
        if(s.toLowerCase().equals("heal"))
            return ItemType.HEAL;
        else if (s.toLowerCase().equals("buff"))
            return ItemType.BUFF;
        else
            return null;
    }

    /**
     * method to load all players from player.json
     * @author Enze Peng
     * @param ic- an item container
     *  @param wc- an weapon container
     * @return - a collection of players
     */

    private ArrayList<Player> load(ItemContainer ic,WeaponContainer wc){
        ArrayList<Player> p=new ArrayList<>();
        //get object of weapons from player.json
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(path.toAbsolutePath()+"/main/java/game/Json/player.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray em= (JSONArray) jsonObject.get("player");
            Iterator itr=em.iterator();
            while(itr.hasNext()){
                //get all info and features of each player
                JSONObject e=(JSONObject)itr.next();
                int gold=Integer.parseInt(e.get("gold").toString());
                int maxHp=Integer.parseInt(e.get("maxHp").toString());
                int level=Integer.parseInt(e.get("level").toString());
                int attack=Integer.parseInt(e.get("attack").toString());
                int xp=Integer.parseInt(e.get("xp").toString());
                WeaponContainer wt=new WeaponContainer();
                ItemContainer it=new ItemContainer();
                //create item and weapon containers for each player
                List<String> i= (List<String>)e.get("item");
                List<String> w= (List<String>)e.get("weapon");
                //respectively add instances to item/weapon container
                for(int k=0;k<i.size();k++){
                    for(Item t:ic){
                        if(t.getName().equals(i.get(k))){
                            it.add(t);
                        }

                    }
                }
                for(int k=0;k<w.size();k++){
                    for(Weapons t:wc){
                        if(t.getName().equals(w.get(k)))
                            wt.add(t);
                    }
                }
                //add all players from saved player to player collections in this class

                p.add(Player.getInstance().setPlayer((String)e.get("name"),(String)e.get("description"),null,
                        maxHp,attack,xp,gold,level,wt,it,(String)e.get("time")));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;


    }

    /**
     * method to save the player to player.json
     * @author Enze Peng
     * @param P- the player from the currently played game
     */


    public void save(Player P){
        //since everytime save instance to file,
        //it is needed to clear the file first and rewrite the json file
        // so the approach here is to load the existing file to make player-collections
        //then add up one more player from the current game to this collections
        //then do the save manipulation
        ArrayList<Player> playerArrayList=load(ic,wc);
        P.setDate();
        playerArrayList.add(P);

        JSONObject ob=new JSONObject();
        JSONArray player =new JSONArray();

        for(Player p:playerArrayList){

            JSONObject jn = new JSONObject();
            jn.put("name",p.getName());
            jn.put("description",p.getDescription());
            jn.put("attack",p.attack);
            jn.put("xp",p.xp);
            jn.put("maxHp",p.maxHp);
            jn.put("gold",p.getGold());
            jn.put("level",p.level);
            jn.put("time",p.ds);

            JSONArray weapon=new JSONArray();
            for(Weapons w:p.wp){
                weapon.add(w.getName());
            }

            JSONArray item=new JSONArray();
            for(Item i:p.bag){
                item.add(i.getName());
            }

            jn.put("weapon",weapon);
            jn.put("item",item);

            player.add(jn);
        }

        ob.put("player",player);

        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter(path.toAbsolutePath()+"/game/Json/player.json"));
            String ws=ob.toString();
            //System.out.println(ws);
            bw.write(ws);
            // bw.newLine();
            bw.flush();
            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("save successfully\nu can keep going for more adventure\nor press 'q' to end the game");

    }

    /**
     * method to init the player to the game that is about to start
     * @author Enze Peng
     */

    public Player InitPlayer(){
        //once a new game is created
        //player needs to choose whether to use a saved player as before, or create a new one
        //this functions will determine which player will be initialized by the use input
        print("-----Adventure is about to start-----"+"\nchoose action to setup player:"+"\n(1) load from save\n(2) new player \n\nplease enter a number");

        int input = readChoice(2);
        if(input==1){
            ArrayList<Player> p=load(ic,wc);
            if(p.size()==0){
                System.out.println("There is no player u saved before\nGet a new player as default setting");
                return Player.getInstance();
            }

            for(int i=0;i<p.size();i++){
                System.out.println("("+(i+1)+") "+p.get(i).getName()+"   "+p.get(i).ds);
            }
            print("\n\nwhich saved player u want to choose ");
            int input1 = readChoice(p.size());
            return p.get(input1-1);
        }else
            return Player.getInstance();
    }

    /**
     * Method for receiving user int put for fighting
     * @author Enze Peng
     * @param max - int for number of choices allowed
     * @return int acquired from user input
     */
    public  int readChoice(int max){
        int input;
        do{
            try{
                input=Integer.parseInt(scan.next());
            }catch (Exception e){
                input=-1;
                print("pls enter a valid number");
            }
            if(input>max || input<=0)
                print("u only have "+max+" choices");

        }while(input>max || input<=0);

        return input;

    }

    /**
     * Method for printing our text in the terminal
     * @author Enze Peng
     * @param s - String to be printed
     */
    public static void print(String s){
        System.out.println(s);
    }



}
