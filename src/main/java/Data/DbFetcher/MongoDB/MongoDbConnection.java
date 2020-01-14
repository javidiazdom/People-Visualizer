package Data.DbFetcher.MongoDB;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoDbConnection {
    private static MongoDbConnection connection;
    private static MongoClient client;

    private MongoDbConnection () {
        client = MongoClients.create("mongodb://localhost:27017");
    }

    public static MongoDbConnection getConnection () {
        if (client == null) {
            connection = new MongoDbConnection();
        }
        return connection;
    }

    public void closeConnection () {
        client.close();
    }

    public MongoClient getClient () {
        return client;
    }
}
