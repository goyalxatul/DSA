package DSA.hashing;
import java.util.HashSet;
import java .util.Iterator;

public class creationhash {
    public static void main(String args[]){
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2);
        set.remove(2);

        if(set.contains(2)){
            System.out.println("containing");
        }else{
            System.out.println("not containing ");
        }

        System.out.println(set.size());
        System.out.println(set);


        Iterator it = set.iterator();
        //hasNext ;next
        System.out.println(it.next());

    }
    
}
