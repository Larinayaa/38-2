
class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {//сравнение обьектов на равенство имен
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return name != null && name.equals(person.name);
    }
    @Override
    public int hashCode() {//отдельный хешкод для каждой персоны отдельной
        return name != null ? name.hashCode() : 0;
    }
    @Override
    public String toString() {
        return name;
    }
}

