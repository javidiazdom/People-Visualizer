package Data;

import Data.DbFetcher.DbWorker;
import Data.DbFetcher.MongoDB.MongoDbConnection;
import Data.DbFetcher.MongoDB.MongoDbWorker;

import java.util.LinkedList;
import java.util.List;

public class DatabasePool {
    private List<DbWorker> dbs;
    public DatabasePool() {
        dbs = new LinkedList<>();
    }

    public DbWorker getWorker() {
        for (DbWorker worker: dbs) {
            if (worker.isReady()) {
                return worker;
            }
        }
        return new MongoDbWorker(MongoDbConnection.getConnection());
    }
}
