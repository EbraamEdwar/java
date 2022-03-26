package finalprojectwebservice.finalproject;

public class Consumer {
	public static void main(String[] args) {
		LinkCreator consumer = new LinkCreator();
		
		// test each route
		consumer.readData("mostcompanies");
		consumer.readData("mosttitles");
		consumer.readData("mostareas");
		consumer.readData("get_skill");
		consumer.readData("mostcompaniespiechart");
		consumer.readData("mosttitlesbarchart");
		consumer.readData("mostareasbarchart");
		consumer.readData("kmeansclustering");
		
	}

}
