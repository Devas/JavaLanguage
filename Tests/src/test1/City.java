package test1;

class City {

    public String name;

    City(String n) {
        name = n;
    }

    @Override
    public boolean equals(Object obj) {
        return ((City) obj).name == this.name;
    }

    @Override
    public int hashCode() {
        return -1;
    }

    @Override
    public String toString() {
        return "test1.City{" +
                "name='" + name + '\'' +
                '}';
    }
}
