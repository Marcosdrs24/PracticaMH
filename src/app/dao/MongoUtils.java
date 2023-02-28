package app.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoUtils {
	private static MongoClient mongoClient;
MongoUtils(){
	
}

public static MongoClient getMongoClient() {
	if(mongoClient==null) {
		initMongoClient();
	}
	return mongoClient;
}

private static void initMongoClient() {
	/**Properties prop = new Properties();
    InputStream input = null;

	 try {
				//Aqui me dice todo el rato que no se encuentra la ruta y he intentado de todo
	        input = new FileInputStream("/config/config.properties");

	        // load a properties file
	        prop.load(input);

	        // get the property value and print it out
	        System.out.println(prop.getProperty("database"));
	        System.out.println(prop.getProperty("dbuser"));
	        System.out.println(prop.getProperty("dbpassword"));

	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } finally {
	        if (input != null) {
	            try {
	                input.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            **/

ConnectionString connectionString = new ConnectionString("mongodb+srv://MHApp:MHApp12@cluster0.gy0myot.mongodb.net/?retryWrites=true&w=majority");
MongoClientSettings settings = MongoClientSettings.builder()
        .applyConnectionString(connectionString)
        .serverApi(ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build())
        .build();
 mongoClient = MongoClients.create(settings);
	            
	        }
	        



public static MongoDatabase getMongoDB(String database) {
	 CodecRegistry defaultCodecRegistry = MongoClientSettings.getDefaultCodecRegistry();
	 CodecProvider codecProvider = PojoCodecProvider.builder().automatic(true).build();
	 CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(codecProvider);
	 CodecRegistry codecRegistry = CodecRegistries.fromRegistries(defaultCodecRegistry, pojoCodecRegistry);
	 return getMongoClient().getDatabase(database).withCodecRegistry(codecRegistry);
	} 


 

}