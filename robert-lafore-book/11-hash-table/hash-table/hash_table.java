// this is for the 1st hash table type described in the textbook
// it does not use link list
class DataItem {
	private int iData;
	public DataItem(int data) {
		iData = data;
	}
	public int getKey() {
		return iData;
	}
}
class HashTable {

	public DataItem[] hArray;
	public int arraySize;
	public DataItem nonItem; // used to replace removed item

	public HashTable(int size) {

		// create dataItem array (element will be created later during insert)
		arraySize = size;
		hArray = new DataItem[arraySize];

		// create an nonItem for future use
		nonItem = new DataItem(-1);

	}

	public void displayTable() {

		// display the whole object array
		System.out.println("Content of the hash table: ");

		for(int j=0; j<arraySize; j++) {
			if(hArray[j] ==  null) {
				System.out.print("**, ");
			}
			else {
				System.out.print(hArray[j].getKey()+", ");
			}
		}
		System.out.println(" ");
	}

	public void insert(int data) {

		// insert an object with the specified data to the whole object array
		DataItem temp = new DataItem(data);
		int index = hashFunc(data);

		// find the next available spot
		while(hArray[index] != null && hArray[index].getKey()!= -1) {

			// IMPORTANT
			// I used to use "index<arrarySize" instead of "hArray[index] != null" above
			// which reported null object exception
			// this is because index will only be (arraySize-1) when inserting the last element

			index++; // index will be genererated in different ways in "quadratic probing" and "re-hashing method"
			index %= arraySize;
		}
		hArray[index] = temp;
	}

	public DataItem find(int data) {
		// find and return an object with the specified data
		int index = hashFunc(data);

		while(hArray[index] != null) { // find the next spot with the data
			if(hArray[index].getKey() == data) {
				System.out.println("Method find finds the target DataItem successfully.");
				return hArray[index];
			}
			else {
				index++;
				index %= arraySize;
			}
		}
		System.out.println("Method find cannot find the target DataItem.");
		return null;
	}

	public DataItem remove(int data) {
		// find, remove and return an object with the specified data
		int index = hashFunc(data);

		while(hArray[index] != null) {
			if(hArray[index].getKey() == data) {
				System.out.println("Method remove returns the target DataItem successfully.");
				DataItem temp = hArray[index];
				hArray[index] = nonItem; // make it point to the special DataItem object
				return temp;
			}
			else {
				index++;
				index %= arraySize;
			}
		}
		System.out.println("Method find cannot find the target DataItem.");
		return null;
	}

	public int hashFunc(int data) {
		// generate index according to the specified data
		System.out.println("Hashed index is "+(data%arraySize));
		return data%arraySize;
	}
}

class HashTableApp {
	public static void main(String[] args) {
		System.out.println("Creating a hash table of 10 spots.");
		HashTable myArray = new HashTable(10);

		System.out.println("Inserting 32.");
		myArray.insert(32);

		System.out.println("Inserting 52.");
		myArray.insert(52);

		System.out.println("Inserting 18.");
		myArray.insert(18);

		System.out.println("Inserting 27.");
		myArray.insert(27);

		System.out.println("Inserting 67.");
		myArray.insert(67);

		myArray.displayTable();

		System.out.println("Trying to find 1.");
		myArray.find(1);

		System.out.println("Trying to find 52.");
		myArray.find(52);

		System.out.println("Trying to remove 18.");
		myArray.remove(18);

		System.out.println("Trying to remove 21.");
		myArray.remove(21);

		myArray.displayTable();
	}
}