package model;

public class Country implements Comparable{

    private String name;
    private String capital;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Country(String name, String capital) {

        this.name = name;
        this.capital = capital;
    }

    @Override
    public String toString() {
        return name;
    }

    ////////////////////////
    // THis method allows to compare two elements, and we will use it to
    // sort the array
    @Override
    public int compareTo(Object object) {

        Country country = (Country) object;
        if(name.compareTo(country.name)>0){
            return 1;
        } else if (name.compareTo(country.name)==0){
            return 0;
        } else { return -1;}

        ///// for descending order, reverse the return values

    }
}
