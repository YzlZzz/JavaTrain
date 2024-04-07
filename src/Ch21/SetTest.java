package Ch21;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("George");
        set1.add("Jim");
        set1.add("John");
        set1.add("Blake");
        set1.add("Kevin");
        set1.add("Michael");

        set2.add("George");
        set2.add("Katie");
        set2.add("Kevin");
        set2.add("Michael");
        set2.add("Ryan");

        Set<String> addSet = new HashSet<>(set1);
        Set<String> removeSet = new HashSet<>(set1);
        Set<String> retainSet = new HashSet<>(set1);

        addSet.addAll(set2);
        removeSet.removeAll(set2);
        retainSet.retainAll(set2);

        System.out.println(addSet);
        System.out.println(removeSet);
        System.out.println(retainSet);
    }
}
