package configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.typesafe.config.ConfigFactory;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class config {
    public static Datastore datastore;

    public static Datastore datastore(){
        if(datastore == null){
            initDatastore();
        }

        return datastore;
    }

    public static void initDatastore(){
        final Morphia morphia = new Morphia();

        // tell it to fine model class
        morphia.mapPackage("models");

//        String host = ConfigFactory.load().getString("mongodb.host");
//        int port = ConfigFactory.load().getInt("mongodb.port");
//        String username = ConfigFactory.load().getString("mongodb.username");
//        String database = ConfigFactory.load().getString("mongodb.database");
//        String password = ConfigFactory.load().getString("mongodb.password");

        MongoClientOptions.Builder options = MongoClientOptions.builder();
        options.socketKeepAlive(true);
        //mongoClient = new MongoClient(mongoAddress, options.build());

        MongoClientURI uri = new MongoClientURI("mongodb://trevis-db:trevis123@ds227740.mlab.com:27740/trevis-db", options);

        //MongoClient mongoClient = new MongoClient("mongodb://trevis-db:trevis123@ds227740.mlab.com:27740");

        datastore = morphia.createDatastore(new MongoClient(uri), "trevis-db");


    }
}
