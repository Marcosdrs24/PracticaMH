package app.services;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.MongoWriteException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import app.dao.MongoUtils;
import app.modelo.Wyvern;

public class WyvernsService {
	private static List<Wyvern> wyverns;
	public static MongoCollection<Wyvern> colecciónWyverns;
	public static MongoCollection<Document> contadorId;
	public static MongoDatabase db;
	public static Document contadorDoc;

	public static void crearLaLista() {

		db = MongoUtils.getMongoDB("MHApp");

		colecciónWyverns = db.getCollection("Wyverns", Wyvern.class);
		wyverns = new ArrayList<>();

		Wyvern wy_GW = new Wyvern();

		wy_GW.setNombre("Gran Wroggi");
		wy_GW.setCazado(true);
		wy_GW.setDescripición(
				"Los wroggi son aves Wyvern que viajan en grupos liderados por el miembro mas grande y venenoso.Cuidado cuando uno levante la cabeza y su bolsa de veneno se hinche: eso es señal de que va escupir una nube de veneno.");
		wy_GW.setHostilidad(2);
		List<String> materialeswy_GW = new ArrayList<>();
		materialeswy_GW.add("Escama de Gran Wroggi");
		materialeswy_GW.add("Cola de Gran Wroggi");
		materialeswy_GW.add("Vesícula de veneno");
		wy_GW.setMateriales(materialeswy_GW);
		wy_GW.setNotas("Llevar antídotos para su veneno");
		wy_GW.setTamaño(2.4);
		wy_GW.setTipo("Wyvern alado");
		wy_GW.setId("GW");
		wyverns.add(wy_GW);

		Wyvern wy_BA = new Wyvern();

		wy_BA.setNombre("Basarios");
		wy_BA.setCazado(true);
		wy_BA.setDescripición(
				"Wyvern que suele acechar bajo tierra, exponiendo su espalda solo a la superficie y asemejándose a las rocas en la distancia. Cuando el enemigo se acerca, saltará del suelo y le dará un fuerte golpe al oponente.");
		wy_BA.setHostilidad(4);
		List<String> materialeswy_BA = new ArrayList<>();
		materialeswy_BA.add("Pleura de Basarios");
		materialeswy_BA.add("Caparazón de Basarios");
		materialeswy_BA.add("Vesícula de veneno");
		materialeswy_BA.add("Cola de Basarios");
		wy_BA.setMateriales(materialeswy_BA);
		wy_BA.setNotas("Parece una montña normal y corriente");
		wy_BA.setTamaño(4.5);
		wy_BA.setTipo("Wyvern alado");
		wy_BA.setId("BA");
		wyverns.add(wy_BA);

		Wyvern wy_GI = new Wyvern();

		wy_GI.setNombre("Gran Izuchi");
		wy_GI.setCazado(true);
		wy_GI.setDescripición(
				"El Izuchi alfa de la manada, reconocible por su tamaño, su colgante pelaje blanco y la cola cual guadaña. Un Gran Izuchi forma hordas con Izuchi menores y escoge a dos del grupo para que lo acompañen en patrullas territoriales. Cuando avista una presa o presiente peligro, el Gran Izuchi da órdenes a los demás Izuchi y coordina sus movimientos. Asegúrate de que no te sobrepasen.");
		wy_GI.setHostilidad(3);
		List<String> materialeswy_GI = new ArrayList<>();
		materialeswy_GI.add("Piel de Gran Izuchi");
		materialeswy_GI.add("Garra de Gran Izuchi");
		materialeswy_GI.add("Cola de Gran Izuchi");
		materialeswy_GI.add("Colmillo de Gran Izuchi");
		wy_GI.setMateriales(materialeswy_GI);
		wy_GI.setNotas(null);
		wy_GI.setTamaño(2.5);
		wy_GI.setTipo("Wyvern pájaro");
		wy_GI.setId("GI");
		wyverns.add(wy_GI);

		Wyvern wy_TE = new Wyvern();

		wy_TE.setNombre("Tetranadon");
		wy_TE.setCazado(true);
		wy_TE.setDescripición(
				"Un anfibio fácilmente reconocible por su gigantesco y rechoncho cuerpo. Tiene una voracidad sin límite, y es capaz de tragarse entera a cualquier cosa que se mueva, incluso grava. Al terminar de comer, su estómago se hincha y el monstruo se vuelve más lento... pero también más pesado, y con ello también se vuelven más destructivos sus ataques.");
		wy_TE.setHostilidad(3);
		List<String> materialeswy_TE = new ArrayList<>();
		materialeswy_TE.add("Caparazón de Tetranadon");
		materialeswy_TE.add("Pico de Tetranadon");
		materialeswy_TE.add("Vesícula Torrencial");
		materialeswy_TE.add("Disco de Tetranadon");
		wy_TE.setMateriales(materialeswy_TE);
		wy_TE.setNotas("Cuando escupe el agua se queda muy expuesto");
		wy_TE.setTamaño(4.2);
		wy_TE.setTipo("Wyvern Anfibio");
		wy_TE.setId("TE");
		wyverns.add(wy_TE);

		Wyvern wy_NG = new Wyvern();

		wy_NG.setNombre("Nergigante");
		wy_NG.setCazado(false);
		wy_NG.setDescripición(
				"Un terrible dragón anciano que aparece cuando hay otros dragones ancianos en las cercanías. Se ha documentado ampliamente su pasión por la destrucción.");
		wy_NG.setHostilidad(7);
		List<String> materialeswy_NG = new ArrayList<>();
		materialeswy_NG.add("Caparazón de Nergigante");
		materialeswy_NG.add("Sangre de dragón anciano");
		materialeswy_NG.add("Cola de Nergigante");
		materialeswy_NG.add("Hueso de dragón anciano");
		wy_NG.setMateriales(materialeswy_NG);
		wy_NG.setNotas("Cuidado con sus pinchos");
		wy_NG.setTamaño(5.0);
		wy_NG.setTipo("Dragón Anciano");
		wy_NG.setId("NG");
		wyverns.add(wy_NG);

		Wyvern wy_DH = new Wyvern();

		wy_DH.setNombre("Daimyo Hermitaur");
		wy_DH.setCazado(true);
		wy_DH.setDescripición(
				" Este carapaceon lleva una colosal calavera de monstruo a su espalda, y usa sus enormes pinzas y su aliento burbuja para atacar a sus presas. Cuando está en peligro, usa sus pinzas como escudo para repeler los ataques.");
		wy_DH.setHostilidad(5);
		List<String> materialeswy_DH = new ArrayList<>();
		materialeswy_DH.add("Córtex de Hermitaur");
		materialeswy_DH.add("Pinza de Hermitaur");
		materialeswy_DH.add("Perla negra pulida");
		materialeswy_DH.add("Cuerno carmesí");
		wy_DH.setMateriales(materialeswy_DH);
		wy_DH.setNotas("El caparazón es muy resistente");
		wy_DH.setTamaño(3.0);
		wy_DH.setTipo("Wyvern Caparaceon");
		wy_DH.setId("DH");
		wyverns.add(wy_DH);

		contadorId = db.getCollection("Contador", Document.class);

		contadorDoc = new Document();
		ObjectId objectId = new ObjectId("61f6db4bb8f2097df1f4d140");
		contadorDoc.append("_id", objectId);
		contadorDoc.append("numero", 0);
		try {
			InsertOneResult result = contadorId.insertOne(contadorDoc);
		} catch (MongoWriteException e) {
			Bson filter = Filters.eq("_id", new ObjectId("61f6db4bb8f2097df1f4d140"));
			Bson updates = Updates.set("numero", 0);
			UpdateOptions options = new UpdateOptions().upsert(true);
			UpdateResult result = contadorId.updateOne(filter, updates);
			System.out.println(result.getMatchedCount());
			System.out.println("Ya existe el contador");
		}

		InsertManyResult result1 = colecciónWyverns.insertMany(wyverns);

	}

	public void insertarWyvern(Wyvern wyv) {
		colecciónWyverns.insertOne(wyv);
	}

	public void eliminarWyvern(String id) {
		Bson filter = Filters.eq("_id", id);
		DeleteResult result = colecciónWyverns.deleteOne(filter);
	}

	public Integer getContador() {

		List<Document> listaContador = new ArrayList<>();
		contadorId = db.getCollection("Contador", Document.class);

		FindIterable<Document> it = contadorId.find();
		MongoCursor<Document> cursor = it.cursor();
		while (cursor.hasNext()) {
			listaContador.add(cursor.next());
		}

		Integer valorSinActu = listaContador.get(0).getInteger("numero");
		Integer valorActu = actualizarContador(valorSinActu);

		return valorActu;

	}

	public Integer actualizarContador(Integer valor) {
		Bson filter = Filters.eq("_id", new ObjectId("61f6db4bb8f2097df1f4d140"));
		Bson updates = Updates.set("numero", valor + 1);
		UpdateOptions options = new UpdateOptions().upsert(true);
		UpdateResult result = contadorId.updateOne(filter, updates);
		List<Document> listaContador = new ArrayList<>();
		FindIterable<Document> it = contadorId.find();
		MongoCursor<Document> cursor = it.cursor();
		while (cursor.hasNext()) {
			listaContador.add(cursor.next());
		}

		Integer valorDevolver = listaContador.get(0).getInteger("numero");

		return valorDevolver;
	}
	
	public void actualizarNotas (String id, String notas) {
		Bson filter = Filters.eq("_id", id);
		Bson updates = Updates.set("notas", notas);
		UpdateOptions options = new UpdateOptions().upsert(true);
		UpdateResult result = colecciónWyverns.updateOne(filter, updates);
		System.out.println(result.getModifiedCount());
	}
	
	public void actualizarCazado (String id, Boolean caza) {
		Bson filter = Filters.eq("_id", id);
		Bson updates = Updates.set("cazado", caza);
		UpdateOptions options = new UpdateOptions().upsert(true);
		UpdateResult result = colecciónWyverns.updateOne(filter, updates);
		System.out.println(result.getModifiedCount());
	}

	public List<Wyvern> devolverWyverns() {
		List<Wyvern> listaWyverns = new ArrayList<>();
		MongoCollection<Wyvern> colecciónWyverns = db.getCollection("Wyverns", Wyvern.class);

		FindIterable<Wyvern> it = colecciónWyverns.find();
		MongoCursor<Wyvern> cursor = it.cursor();
		while (cursor.hasNext()) {
			listaWyverns.add(cursor.next());
		}
		return listaWyverns;
	}
	
	public void dropColecciones() {
		db = MongoUtils.getMongoDB("MHApp");
		colecciónWyverns = db.getCollection("Wyverns", Wyvern.class);
		colecciónWyverns.drop();
	}

}
