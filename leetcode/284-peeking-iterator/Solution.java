// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> myIterator;
    int peekVal;
    boolean peeked;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    myIterator = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (peeked) {
            return peekVal;
        }
        peeked = true;
        peekVal = myIterator.next();
        return peekVal;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (peeked) {
            peeked = false;
            return peekVal;
        }
        return myIterator.next();
	}
	
	@Override
	public boolean hasNext() {
	    return peeked || myIterator.hasNext();
	}
}