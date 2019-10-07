package sample;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Mixer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Admin {

    HashSet<Integer> AccountList = new HashSet<>();
    Map<Integer,User> map = new HashMap<>();
    User list[] = new User[4];
    User Active = null;

    public void Main() {
        System.out.println("In Main");
        list[0] = new User("Hrishabh1", 1, "1", 2500);
        AccountList.add(1);
        map.put(1, list[0]);

        list[1] = new User("Hrishabh2", 2, "2", 3500);
        AccountList.add(2);
        map.put(2, list[1]);

        list[2] = new User("Hrishabh3", 3, "3", 4500);
        AccountList.add(3);
        map.put(3, list[2]);

        list[3] = new User("Hrishabh4", 4, "4", 5500);
        AccountList.add(4);
        map.put(4, list[3]);
        
        
        list[4] = new User("Animesh", 5, "5", 6500);
        AccountList.add(5);
        map.put(5, list[4]);
    }
}
