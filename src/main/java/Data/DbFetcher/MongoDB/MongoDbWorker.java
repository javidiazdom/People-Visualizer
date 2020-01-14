package Data.DbFetcher.MongoDB;

import Data.DbFetcher.DbWorker;
import Model.Person;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MongoDbWorker implements DbWorker {
    private MongoDbConnection connection;
    public MongoDbWorker (MongoDbConnection connection) {
        this.connection = connection;
    }

    public List<Person> getPeople () {
        List<Person> result = new LinkedList<>();
        MongoDatabase db = connection.getClient().getDatabase("peopleApp");
        MongoCollection<Document> collection = db.getCollection("people");
        for (Document document : collection.find()) {
            result.add(new Person(document.getString("firstname"),document.getString("lastname"),document.getInteger("age")));
        }
        return result;
    }

    public void savePerson (Person in) {
        Map<String,Object> values = new HashMap<String,Object>();
        values.put("firstname",in.getName());
        values.put("lastname", in.getSurname());
        values.put("age",in.getAge());
        values.put("fullname",in.getName() + " " + in.getSurname());
        Document doc = new Document(values);
        MongoDatabase db = connection.getClient().getDatabase("testdb");
        db.getCollection("people").insertOne(doc);
    }

    public List<Person> getPeopleByName(String name) {
        List<Person> findResult = new LinkedList<>();
        MongoDatabase db = connection.getClient().getDatabase("testdb");
        MongoCollection<Document> collection = db.getCollection("people");
        Bson filter = new Document(getMapFilter(name));
        for (Document doc : collection.find(filter))
            findResult.add(new Person(doc.getString("firstname"), doc.getString("lastname"), doc.getInteger("age")));
        return findResult;
    }

    private Map<String, Object> getMapFilter(String name) {
        Map <String, Object> map = new HashMap<>();
        Map <String, Object> map2 = new HashMap<>();
        map2.put("$regex","^"+name);
        map.put("fullname",map2);

        return map;
    }

    public boolean isReady () {
        return connection != null;
    }
}
