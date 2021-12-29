package bucketSort;

//New Object created with the intent to show stability of Bucket Sort.
public class ElementBucket {
	private double elementValue;
	private int elementPosition;
	
	ElementBucket(double elementValue, int elementPosition){
		this.elementValue = elementValue;
		this.elementPosition = elementPosition;
	}
	
	//Getter for elementValue
	public double getElementValue() {
		return elementValue;
	}
	
	//Setter for elementValue
	public void setElementValue(double x) {
		elementValue = x;
	}
	
	//Getter for elementIndex
	public int getElementPosition() {
		return elementPosition;
	}
	
	//Setter for elementIndex
	public void setElementPosition(int x) {
		elementPosition = x;
	}
}

