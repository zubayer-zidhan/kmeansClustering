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
		k1.plotClusteredGraph(k1.data);
		
		
	}
	
	
	// Generate Records	
	private void generateRecord() {
		PlotPointsFromCSV plot = new PlotPointsFromCSV("dataset.csv");	

		for(int[] point : plot.points) {
			Record record = new Record((point[0]-300)/5, (point[1]-100)/5);
			data.add(record);
		}
		plot.plotPoints(plot);
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
	
	private void plotClusteredGraph(List<Record> records) {
		PlotPoints plot2 = new PlotPoints(records);
		plot2.plotPoints(plot2);
	}
	
}