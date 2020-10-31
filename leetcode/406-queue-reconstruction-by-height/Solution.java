class Person {
    int h;
    int k;
    public Person(int h, int k) {
        this.h = h;
        this.k = k;
    }
}
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length < 2) {
            return people;
        }
        List<Person> pList = new ArrayList<Person>();
        for (int i = 0; i < people.length; i++) {
            pList.add(new Person(people[i][0], people[i][1]));
        }
        Collections.sort(pList, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                if (p1.h != p2.h) {
                    return p2.h - p1.h;
                }
                return p1.k - p2.k;
            }
        });
        List<Person> tempRes = new ArrayList<Person>();
        for (Person person : pList) {
            tempRes.add(person.k, person);
        }
        int[][] res = new int[tempRes.size()][2];
        for (int i = 0; i < tempRes.size(); i++) {
            res[i][0] = tempRes.get(i).h;
            res[i][1] = tempRes.get(i).k;
        }
        return res;
    }
}