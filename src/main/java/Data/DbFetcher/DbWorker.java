package Data.DbFetcher;

import Model.Person;

import java.util.List;

public interface DbWorker {
    public boolean isReady ();
    public List<Person> getPeople();
    public void savePerson(Person in);
    public List<Person> getPeopleByName(String name);
}
