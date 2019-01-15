package base;

import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import utils.PropertiesUtil;

public class MyMongodb_2{
	
	private DB db;
	private MongoClient mg;
	private ServerAddress address;
	private MongoCredential credential;
	
	private int port;
	private String pwd;
	private String host;
	private String db_name;
	private String user_name;
	private final static MyMongodb_2 UniqueInstance = new MyMongodb_2();
	
	public static MyMongodb_2 getMongoInstance(){
		return UniqueInstance;
	}
	
	private MyMongodb_2(){
		try{
			host = new PropertiesUtil("app.properties").readValue("mongodb_host").toString();
			port = Integer.valueOf(new PropertiesUtil("app.properties").readValue("mongodb_port").toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		_init();
	}
	
	private MyMongodb_2(String host,Integer port){
		this.host = host;
		this.port = port;
		_init();
	}
	
	private void _init(){
		try{
			pwd = new PropertiesUtil("app.properties").readValue("mongodb_pwd").toString();
			db_name = new PropertiesUtil("app.properties").readValue("mongodb_database").toString();
			user_name = new PropertiesUtil("app.properties").readValue("mongodb_username").toString();
			
			this.address = new ServerAddress(this.host,this.port);
//			this.credential = MongoCredential.createCredential(this.user_name, 
//					this.db_name, this.pwd.toCharArray());
//			this.mg = new MongoClient(this.address,Arrays.asList(this.credential));
			this.mg = new MongoClient(this.address);
			this.db = getDB();
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private DB getDB(){
		return this.mg.getDB(this.db_name);
	}
	
	public DBCollection getTable(String name){
		if(existsTable(name)){ //collection已经存在
			return this.db.getCollection(name);
		}else{
			System.out.println("the "+name+" table doesn't existed!");
			return null;
		}
	}
	
	public boolean isOpen(){
		//判断mongo是否开启
		try{
			this.getTable("project");
		}catch(Exception e){
			return false;
		}
		return true;
	}
	private boolean existsTable(String name){
		return this.db.collectionExists(name);
	}
	
	public DBCollection createTable(String collectionName){
		DBObject options = new BasicDBObject();
		return this.db.createCollection(collectionName, options);
	}
	
	public boolean isConnecting(){
		//#todo
		return false;
	}
	public DB getDb() {
		return db;
	}

	public void setDb(DB db) {
		this.db = db;
	}

	public MongoClient getMg() {
		return mg;
	}

	public void setMg(MongoClient mg) {
		this.mg = mg;
	}
	
	private ServerAddress getAddress() {
		return address;
	}

	private void setAddress(ServerAddress address) {
		this.address = address;
	}

	private MongoCredential getCredential() {
		return credential;
	}

	private void setCredential(MongoCredential credential) {
		this.credential = credential;
	}

	private int getPort() {
		return port;
	}

	private void setPort(int port) {
		this.port = port;
	}

	private String getPwd() {
		return pwd;
	}

	private void setPwd(String pwd) {
		this.pwd = pwd;
	}

	private String getHost() {
		return host;
	}

	private void setHost(String host) {
		this.host = host;
	}

	private String getUser_name() {
		return user_name;
	}

	private void setUser_name(String userName) {
		user_name = userName;
	}

	private String getDb_name() {
		return db_name;
	}

	private void setDb_name(String dbName) {
		db_name = dbName;
	}
	

	public static void main(String[] args){
		MyMongodb_2  mm= MyMongodb_2.getMongoInstance(); 
		DBCollection projects = mm.getTable("project");
		DBCollection qs = mm.getTable("question");
		DBCursor p_c = projects.find(new BasicDBObject("user_id",314653248l));
		while(p_c.hasNext()){
			DBObject p_o = p_c.next();
			System.out.println(p_o.get("title"));
			
		}
//		DBCollection qs = mm.getTable("question");
//		DBCursor q = qs.find();
//		while(q.hasNext()){
//			DBObject q_ = q.next();
//			String cid = q_.get("cid").toString();
//			long sid = Long.valueOf(cid.substring(1));
//			q_.put("SID", sid);
//			qs.update(new BasicDBObject("_id",q_.get("_id")),q_);
//		}
//		while(c.hasNext()){
//			System.out.println(c.next());
//		}
//		DBCollection test = mm.createTable("test");
//		JSONObject json_obj = JSONObject.fromObject("{\"df\":11}");
//		test.insert((DBObject) com.mongodb.util.JSON.parse(json_obj.toString()));
		
	}
	
	
	
}