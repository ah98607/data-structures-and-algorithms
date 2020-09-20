import java.util.*;
public class MyClass {
    
    static HashMap<String, Element> stocks = new HashMap<String, Element>();
    static TreeSet<Element> tset = new TreeSet<Element>(new Comparator<Element>() {
        public int compare(Element e1, Element e2) {
            if (e1.freq != e2.freq) {
                return e2.freq - e1.freq;
            }
            else {
                return e1.name.compareTo(e2.name);
            }
        }
    });
    public static void main(String args[]) {
        add("Facebook", 1);
        add("Apple", 5);
        add("Amazon", 2);
        displayTop();
        add("Amazon", 4);
        list();
    }
    public static void add(String name, int num) {
        if (!stocks.containsKey(name)) {
            Element newE = new Element(name, num);
            stocks.put(name, newE);
            tset.add(newE);
        }
        else {
            Element e = stocks.get(name);
            tset.remove(e);
            e.freq += num;
            tset.add(e);
        }
    }
    public static void displayTop() {
        Iterator<Element> iterator = tset.iterator();
        while (iterator.hasNext()) {
            Element temp = iterator.next();
            System.out.println(temp.name + "/" + temp.freq);
        }
        System.out.println("----------");
    }
}
class Element {
    String name;
    int freq;
    public Element(String name, int freq) {
        this.name = name;
        this.freq = freq;
    }
}
