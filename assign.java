import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class assign{
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to pizza Factory....");
        System.out.println("Enter 1 for customer and 2 for vendor");
        int c=Integer.parseInt(br.readLine());
        System.out.println(c);
        if(c==1){
            PizzaFactory obj=new PizzaFactory();
            while(true){
                System.out.println("Enter 1 to show-menu");
                System.out.println("Enter 2 to add_to cart");
                System.out.println("Enter 3 to place order");
                int per=Integer.parseInt(br.readLine());
                if(per==1) obj.show_menu();
                else if(per==2) obj.add_to_cart();
                else if(per==3){
                    obj.place_order();
                    break;
                }
                else{
                    System.out.println("Enter proper value");
                    continue;
                }
            }
        }
        else{
            PizzaFactory obj=new PizzaFactory();
            while(true){
                System.out.println("Enter 1 to add menu else 2");
                int x=Integer.parseInt(br.readLine());
                if(x==1){
                    obj.add_to_menu();
                }
                else break;
            }
        }
       
    }
}
class PizzaFactory{
    HashMap<String,int[]>veg_pizza=new HashMap<String,int[]>();
    HashMap<String,int[]>nonveg_pizza=new HashMap<String,int[]>();
    HashMap<String,Integer>veg_toppings=new HashMap<String,Integer>();
    HashMap<String,Integer>nonveg_toppings=new HashMap<String,Integer>();
    HashMap<String,Integer>sides=new HashMap<String,Integer>();
    List<String>crust=new ArrayList<>();
    List<List<String>>orders=new ArrayList<>();
    long total=0;
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    PizzaFactory(){
        veg_pizza.put("Deluxe Veggie",new int[]{150,200,325});
        veg_pizza.put("Cheese and corn",new int[]{175,375,475});
        veg_pizza.put("Paneer Tikka",new int[]{160,290,340});

        nonveg_pizza.put("Non-Veg Supreme",new int[]{190,325,425});
        nonveg_pizza.put("Chicken Tikka",new int[]{210,370,500});
        nonveg_pizza.put("Pepper Barbecue Chicken",new int[]{220,380,525});

        veg_toppings.put("Black Olive",20);
        veg_toppings.put("Capsicum",25);
        veg_toppings.put("Paneer",35);
        veg_toppings.put("Mushroom",30);
        veg_toppings.put("Fresh Tomato",10);

        nonveg_toppings.put("Chicken tikka",35);
        nonveg_toppings.put("Barbeque chicken",35);
        nonveg_toppings.put("Grilled chicken",35);
        crust.add("New Hand Tossed");
        crust.add("White thin Tossed");
        crust.add("Cheese Burst");
        crust.add("Fresh Pan Pizza");

        sides.put("Cold drink",55);
        sides.put("Mousse cake",90);
    }
    void show_menu(){
        System.out.println("---------Our Menu---------");
        System.out.println("Vegeterian Pizza");
        for(String s:veg_pizza.keySet()){
            int reg=veg_pizza.get(s)[0];
            int med= veg_pizza.get(s)[1];
            int lar=veg_pizza.get(s)[2];
            System.out.println(s+" Regular Rs."+reg+" Medium Rs."+med+" Large Rs."+lar);
        }
        System.out.println("Non-Veg Pizza");
        for(String s:nonveg_pizza.keySet()){
            int reg=nonveg_pizza.get(s)[0];
            int med= nonveg_pizza.get(s)[1];
            int lar=nonveg_pizza.get(s)[2];
            System.out.println(s+" Regular Rs."+reg+" Medium Rs."+med+" Large Rs."+lar);
        }
        System.out.println("Crust");
        for(String s:crust){
            System.out.println(s);
        }
        System.out.println("Veg toppings");
        for(String s:veg_toppings.keySet()){
            System.out.println(s+" Rs."+veg_toppings.get(s));
        }
        System.out.println("Non-Veg toppings");
        for(String s:nonveg_toppings.keySet()){
            System.out.println(s+" Rs."+nonveg_toppings.get(s));
        }
        System.out.println("Sides");
        for(String s:sides.keySet()){
            System.out.println(s+" Rs."+sides.get(s));
        }
        System.out.println("Extra cheese - 35");
    }
    void add_to_menu() throws Exception{
        System.out.println("Enter 1 to add veg-pizza");
        System.out.println("Enter 2 to add Non-veg-pizza");
        System.out.println("Enter 3 to add veg-toppings");
        System.out.println("Enter 4 to add non-veg-toppings");
        System.out.println("Enter 5 to add crust");
        System.out.println("Enter 6 to add Sides");
        int x=Integer.parseInt(br.readLine());
        if(x==1){
            System.out.println("Enter pizza name");
            String p=br.readLine();
            System.out.println("Enter pizaa price for regular");
            int reg=Integer.parseInt(br.readLine());
            System.out.println("Enter pizaa price for medium");
            int med=Integer.parseInt(br.readLine());
            System.out.println("Enter pizaa price for large");
            int lar=Integer.parseInt(br.readLine());
            veg_pizza.put(p,new int[]{reg,med,lar});
        }
        else if(x==2){
            System.out.println("Enter pizza name");
            String p=br.readLine();
            System.out.println("Enter pizaa price for regular");
            int reg=Integer.parseInt(br.readLine());
            System.out.println("Enter pizaa price for medium");
            int med=Integer.parseInt(br.readLine());
            System.out.println("Enter pizaa price for large");
            int lar=Integer.parseInt(br.readLine());
            nonveg_pizza.put(p,new int[]{reg,med,lar});
        }
        else if(x==3){
            System.out.println("Entervveg_toppings name");
            String p=br.readLine();
            System.out.println("Enter price");
            int r=Integer.parseInt(br.readLine());
            veg_toppings.put(p,r);
        }
        else if(x==4){
            System.out.println("Enter nonveg_toppings name");
            String p=br.readLine();
            System.out.println("Enter price");
            int r=Integer.parseInt(br.readLine());
            nonveg_toppings.put(p,r);
        }
        else if(x==5){
            System.out.println("Enter sides name");
            String p=br.readLine();
            System.out.println("Enter price");
            int r=Integer.parseInt(br.readLine());
            sides.put(p,r);
        }
        else if(x==6){
            System.out.println("Enter crust name");
            String p=br.readLine();
            crust.add(p);
        }
        else {
            System.out.println("Enter valid value");
        }
    }
    void add_to_cart() throws Exception{
        while(true){
            System.out.println("Enter 1 for pizza");
            System.out.println("Enter 2 for sides");
            System.out.println("Enter 3 to exit..");
            int x=Integer.parseInt(br.readLine());
            if(x==1){
                System.out.println("Enter 1 for veg pizza...");
                System.out.println("Enter 2 for Non-veg pizza");
                int y=Integer.parseInt(br.readLine());
                if(y==1){
                    long price=0;
                    List<String>l1=new ArrayList<>();
                    l1.add("Veg Pizza");
                    System.out.println("Enter Your pizza name..");
                    String p=br.readLine();
                    l1.add(p);
                    System.out.println("Enter 1 2 3 for regular medium large..");
                    int z=Integer.parseInt(br.readLine());
                    if(z==1) {l1.add("regular");price+=veg_pizza.get(p)[z];}
                    else if(z==2) {l1.add("medium");price+=veg_pizza.get(p)[z];}
                    else if(z==3) {l1.add("large");price+=veg_pizza.get(p)[z];}
                    else{
                        System.out.println("Enter proper value...");
                        price=0;
                        continue;
                    }
                    System.out.println("Enter Your pizza crust..");
                    String p1=br.readLine();
                    l1.add(p1);
                    if(z==3){
                        System.out.println("Enter any 2 toppings for free");
                        String p2=br.readLine();
                        String p3=br.readLine();
                        l1.add(p2);
                        l1.add(p3);
                    }
                    else{
                        System.out.println("Enter any toppings else no..");
                        String p2=br.readLine();
                        if(!p2.equals("no")){
                            if(veg_toppings.containsKey(p2)){
                                price+=veg_toppings.get(p2);
                                l1.add(p2);
                            }
                            else{
                                System.out.println("Enter valid toppings");
                                price=0;
                                continue;
                            }
                        }
                    }
                    System.out.println("Enter 1 to add extra cheese..");
                    int ex=Integer.parseInt(br.readLine());
                    if(ex==1){ price+=30;l1.add("extra cheese");}
                    else continue;
                    l1.add(Long.toString(price));
                    total+=price;
                    orders.add(l1);
                }
                else if(y==2){
                    long price=0;
                    List<String>l1=new ArrayList<>();
                    l1.add("Non-Veg Pizza");
                    System.out.println("Enter Your pizza name..");
                    String p=br.readLine();
                    l1.add(p);
                    System.out.println("Enter 1 2 3 for regular medium large..");
                    int z=Integer.parseInt(br.readLine());
                    if(z==1) {l1.add("regular");price+=nonveg_pizza.get(p)[z];}
                    else if(z==2) {l1.add("medium");price+=nonveg_pizza.get(p)[z];}
                    else if(z==3) {l1.add("large");price+=nonveg_pizza.get(p)[z];}
                    else{
                        System.out.println("Enter proper value...");
                        price=0;
                        continue;
                    }
                    System.out.println("Enter Your pizza crust..");
                    String p1=br.readLine();
                    l1.add(p1);
                    boolean nvg_toppings=false;
                    if(z==3){
                        System.out.println("Enter any 2 toppings for free");
                        String p2=br.readLine();
                        if(nonveg_toppings.containsKey(p2)) nvg_toppings=true;
                        l1.add(p2);
                        if(nvg_toppings){
                            System.out.println("Enter any veg toppings other than panner..");
                            String p3=br.readLine();
                            l1.add(p3);
                        }
                        else {
                            String p3=br.readLine();
                            l1.add(p3);
                        }
                    }
                    else{
                        System.out.println("Enter any toppings else no..");
                        String p2=br.readLine();
                        if(!p2.equals("no")){
                            if(!nvg_toppings && nonveg_toppings.containsKey(p2)){
                                price+=nonveg_toppings.get(p2);
                                l1.add(p2);
                                nvg_toppings=true;
                            }
                            else if(veg_toppings.containsKey(p2) && !p2.equals("Paneer")){
                                price+=veg_toppings.get(p2);
                                l1.add(p2);
                            }
                            else{
                                System.out.println("Enter valid toppings");
                                price=0;
                                continue;
                            }
                        }
                    }
                    System.out.println("Enter 1 to add extra cheese..");
                    int ex=Integer.parseInt(br.readLine());
                    if(ex==1){ price+=30;l1.add("extra cheese");}
                    else continue;
                    l1.add(Long.toString(price));
                    total+=price;
                    orders.add(l1);
                }
                else{
                    System.out.println("Enter proper value");
                    continue;
                }
            }
            else if(x==2){
                long price=0;
                List<String>l1=new ArrayList<>();
                System.out.println("Enter 1 for cold drink");
                System.out.println("Enter 2 for Mousse cake..");
                int c=Integer.parseInt(br.readLine());
                if(c==1){
                    l1.add("cold drink");
                    price+=55;
                }
                else if(c==2){
                    l1.add("Mousse Cake");
                    price+=90;
                }
                else{
                    System.out.println("Enter proper value");
                    price=0;
                    continue;
                }
                l1.add(Long.toString(price));
                total+=price;
                orders.add(l1);
            }
            else break;
        }
    }
    void place_order() throws Exception{
        System.out.println("Your order is....");
        for(List<String>l1:orders){
            System.out.println(l1);
        }
        System.out.println("Total price is "+total);
        System.out.println("Enter 1 to confirm else 2");
        int k=Integer.parseInt(br.readLine());
        if(k==1) System.out.println("Your order has been confirmed");
        else add_to_cart();
    }
}