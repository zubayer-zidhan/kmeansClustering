public class Record {
	private int income;
	private int score;
	private int clusterNumber;
	
	
	public Record(int income, int score) {
		super();
		this.income = income;
		this.score = score;
	}
	
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getClusterNumber() {
		return clusterNumber;
	}
	public void setClusterNumber(int clusterNumber) {
		this.clusterNumber = clusterNumber;
	}
	@Override
	public String toString() {
		return "Record [income=" + income + ", score=" + score + ", clusterNumber="
				+ clusterNumber + "]";
	}
}