package template.api;

public class Duck implements Comparable<Duck>{

    String name;
    int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String toString() {
        return name + "체중" + weight;
    }


    @Override
    public int compareTo(Duck o) {
        if(this.weight < o.weight) {
            return -1;
        }
        if(this.weight > o.weight) {
            return 1;
        }

        return 0;
    }
}
