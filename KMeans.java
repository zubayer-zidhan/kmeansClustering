import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class KMeans {
	
	List<Record> data = new ArrayList<Record>();
	List<Cluster> clusters = new ArrayList<Cluster>();
	Map<Cluster, List<Record>> clusterRecords = new HashMap<Cluster, List<Record>>();
	
	
	// The main Method
	public static void main(String[] args) {
		int clusterNumber = 2;
		KMeans k1 = new KMeans();
		k1.generateRecord();
		k1.initiateClusterAndCentroid(clusterNumber);
		k1.printRecordInformation();
		k1.printClusterInformation();
		
		
	}
	
	
	// Generate Records	
	private void generateRecord() {
		Record record = new Record(15, 39);
		data.add(record);
		
		record = new Record(15, 81);
		data.add(record);
		

		record = new Record(6, 6);
		data.add(record);
		

		record = new Record(6, 77);
		data.add(record);
		

		record = new Record(17, 40);
		data.add(record);
		

		record = new Record(17, 76);
		data.add(record);
		
		
	}
	
	private void initiateClusterAndCentroid(int clusterNumber) {
		int counter = 1;
		Iterator<Record> iterator = data.iterator();
		
		Record record = null;
		
		while(iterator.hasNext()) {
			record = iterator.next();
			if(counter <= clusterNumber) {
				record.setClusterNumber(counter);
				initializeCluster(counter, record);
				counter++;
			} else {
				System.out.println(record);
				System.out.println("** Cluster Information **");
				for(Cluster cluster : clusters) {
					System.out.println(cluster);
				}
				System.out.println("*******************");
				
				double minDistance = Integer.MAX_VALUE;
				Cluster whichCluster = null;
				
				for(Cluster cluster : clusters) {
					double distance = cluster.calculateDistance(record);
					System.out.println(distance);
					if(minDistance > distance) {
						minDistance = distance;
						whichCluster = cluster;
					}
				}
				
				record.setClusterNumber(whichCluster.getClusterNumber());
				whichCluster.updateCentroid(record);
				clusterRecords.get(whichCluster).add(record);
			}
			
			System.out.println("** Cluster Information **");
			for(Cluster cluster : clusters) {
				System.out.println(cluster);
			}
			System.out.println("*******************");
		}
	}

	private void initializeCluster(int clusterNumber, Record record) {
		Cluster cluster = new Cluster(clusterNumber, record.getIncome(), record.getScore());
		clusters.add(cluster);
		
		List<Record> clusterRecord = new ArrayList<Record>();
		clusterRecord.add(record);
		clusterRecords.put(cluster, clusterRecord);
		
	}
	
	private void printRecordInformation() {
		System.out.println("**** Each Record Information *****");
		for(Record record : data) {
			System.out.println(record);
		}
	}
	
	private void printClusterInformation() {
		System.out.println("**** FINAL CLUSTER INFORMATION*****");
		for(Map.Entry<Cluster, List<Record>> entry : clusterRecords.entrySet()) {
			System.out.println("Key = " + entry.getKey() + 
					", Value = " + entry.getValue());
		}
	}
	
	
}