public class Cluster {
	
	private int incomeCentroid;
	private int scoreCentroid;
	private int clusterNumber;
	
	
	
	public Cluster(int clusterNumber, int incomeCentroid, int scoreCentroid) {
		super();
		this.clusterNumber = clusterNumber;
		this.incomeCentroid = incomeCentroid;
		this.scoreCentroid = scoreCentroid;
	}
	
	
	public int getIncomeCentroid() {
		return incomeCentroid;
	}
	public void setIncomeCentroid(int incomeCentroid) {
		this.incomeCentroid = incomeCentroid;
	}
	public int getScoreCentroid() {
		return scoreCentroid;
	}
	public void setScoreCentroid(int scoreCentroid) {
		this.scoreCentroid = scoreCentroid;
	}
	public int getClusterNumber() {
		return clusterNumber;
	}
	public void setClusterNumber(int clusterNumber) {
		this.clusterNumber = clusterNumber;
	}


	@Override
	public String toString() {
		return "Cluster [incomeCentroid=" + incomeCentroid + ", scoreCentroid="
				+ scoreCentroid + ", clusterNumber=" + clusterNumber + "]";
	}
	
	// Euclidean Distance
	public double calculateDistance(Record record) {
		return Math.sqrt(Math.pow((getIncomeCentroid() - record.getIncome()), 2) + Math.pow((getScoreCentroid() - record.getScore()), 2));
	}
	
	
	public void updateCentroid(Record record) {
		setIncomeCentroid((getIncomeCentroid() + record.getIncome())/2);
		setScoreCentroid((getScoreCentroid() + record.getScore())/2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}