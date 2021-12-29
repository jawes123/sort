package countingSort;

//New Object created with the intent to show stability of Counting Sort.
public class ElementCounting {
	private int elementValue;
	private int elementPosition;
	
	ElementCounting(int elementValue, int elementPosition){
		this.elementValue = elementValue;
		this.elementPosition = elementPosition;
	}
	
	//Getter for elementValue
	public int getElementValue() {
		return elementValue;
	}
	
	//Setter for elementValue
	public void setElementValue(int x) {
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
