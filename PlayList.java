/** Represnts a list of musical tracks. The list has a maximum capacity (int),
 *  and an actual size (number of tracks in the list, an int). */
class PlayList {
    private Track[] tracks;  // Array of tracks (Track objects)   
    private int maxSize;     // Maximum number of tracks in the array
    private int size;        // Actual number of tracks in the array

    /** Constructs an empty play list with a maximum number of tracks. */ 
    public PlayList(int maxSize) {
        this.maxSize = maxSize;
        tracks = new Track[maxSize];
        size = 0;
    }

    /** Returns the maximum size of this play list. */ 
    public int getMaxSize() {
        return maxSize;
    }
    
    /** Returns the current number of tracks in this play list. */ 
    public int getSize() {
        return size;
    }

    /** Method to get a track by index */
    public Track getTrack(int index) {
        if (index >= 0 && index < size) {
            return tracks[index];
        } else {
            return null;
        }
    }
    
    /** Appends the given track to the end of this list. 
     *  If the list is full, does nothing and returns false.
     *  Otherwise, appends the track and returns true. */
    public boolean add(Track track) {
        //// replace the following statement with your code
        // if the list is full
        if (this.size >= maxSize)
        {
           return false;
        }
        // if the list has space- the track will enter tracks in the place of size
        tracks[size] = track;
        this.size ++;
        return true;
    }

    /** Returns the data of this list, as a string. Each track appears in a separate line. */
    //// For an efficient implementation, use StringBuilder.
    public String toString() {
        //// replace the following statement with your code
        StringBuilder s = new StringBuilder("");
        for(int i = 0; i < tracks.length ; i ++) {
            s.append(this.tracks[i]).append("\n");
        }
        return s.toString();
    }

    /** Removes the last track from this list. If the list is empty, does nothing. */
     public void removeLast() {
        //// replace this comment with your code
        if (this.size == 0) {
            
        }
        else {
            this.size--; 
    } 
     }
    
    /** Returns the total duration (in seconds) of all the tracks in this list.*/
    public int totalDuration() {
        //// replace the following statement with your code
        int totalDuration = 0;
        int thisDuration = 0;
        for ( int i = 0; i < this.tracks.length; i ++ ) 
        {
            if (tracks[i] != null) 
            {
                
            
            thisDuration = tracks[i].getDuration();
            totalDuration += thisDuration;
            }
        }
        return totalDuration;
    
    }
    /** Returns the index of the track with the given title in this list.
     *  If such a track is not found, returns -1. */
    public int indexOf(String title) {
        //// replace the following statement with your code
        for (int i = 0; i < this.tracks.length; i++) {
            if (tracks[i] != null && this.tracks[i].getTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }

    /** Inserts the given track in index i of this list. For example, if the list is
     *  (t5, t3, t1), then just after add(1,t4) the list becomes (t5, t4, t3, t1).
     *  If the list is the empty list (), then just after add(0,t3) it becomes (t3).
     *  If i is negative or greater than the size of this list, or if the list
     *  is full, does nothing and returns false. Otherwise, inserts the track and
     *  returns true. */
    public boolean add(int i, Track track) {
        //// replace the following statement with your code 
        // if index is larger than size or if negetive or list is full- return false
        if (i > this.size || i < 0 || this.size == maxSize)
        {
           return false;
        }
        if (this.size == i) 
        {
            this.tracks[this.size] = track;
        }
        else
        { // shifts element to the right to make space for the new track
            for( int j = this.size - 1; j >= i; j--) 
            {
                this.tracks[j+1] = this.tracks[j];
            }
            this.tracks[i] = track;
        } 
        this.size ++; 
        return true;
    }
     
    /** Removes the track in the given index from this list.
     *  If the list is empty, or the given index is negative or too big for this list, 
     *  does nothing and returns -1. */
    public int remove(int i) {
        //// replace this comment with your code
        // *  If the list is empty, or the given index is negative or too big for this list, 
        // *  does nothing and returns -1. */
        if (this.size == 0 || i < 0 || i >= this.size) 
        {
            return -1;    
        }
        else {
            for( int j = i; j < this.size -1; j++) 
            {
                this.tracks[j] = this.tracks[j+1];
            }
            
        } 
        this.size --; 
        return 0;

        }
    

    /** Removes the first track that has the given title from this list.
     *  If such a track is not found, or the list is empty, or the given index
     *  is negative or too big for this list, does nothing. */
    public void remove(String title) {
        //// replace this comment with your code\
        // does nothing if index is negative or too big or if list is empty
        for (int i = 0; i < this.size; i ++) 
        {
            if (this.tracks[i].getTitle().equals(title)) {
                remove(i);
                size --;
                return;
                
            }
        }
    }

    /** Removes the first track from this list. If the list is empty, does nothing. */
    public void removeFirst() {
        //// replace this comment with your code
        remove (0);
    }
    
    /** Adds all the tracks in the other list to the end of this list. 
     *  If the total size of both lists is too large, does nothing. */
    //// An elegant and terribly inefficient implementation.
     public void add(PlayList other) {
        //// replace this comment with your code
        if (this.size + other.size > maxSize)
        { 
        return;
        }
            
        for (int i = this.size, j = 0; i < this.size + other.size; i++, j++) 
            {   this.tracks [i] = other.tracks [j];
            }
        
        size += other.size;
     }
    
    /** Returns the index in this list of the track that has the shortest duration,
     *  starting the search in location start. For example, if the durations are 
     *  7, 1, 6, 7, 5, 8, 7, then min(2) returns 4, since this the index of the 
     *  minimum value (5) when starting the search from index 2.  
     *  If start is negative or greater than size - 1, returns -1.
     */
    private int minIndex(int start) {
        //// replace the following statement with your code
        if (start >= this.size || start < 0) {
            return -1;
            
        } 
        int minDuration = this.tracks[start].getDuration();
        int indexOfMinDuration = start;
        for (int i = start; i < this.size; i++) 
        {
            if (this.tracks[i].getDuration() < minDuration) 
            {
                minDuration = this.tracks[i].getDuration();
                indexOfMinDuration = i;
                
            }

        }
        return indexOfMinDuration;
    }

    /** Returns the title of the shortest track in this list. 
     *  If the list is empty, returns null. */
    public String titleOfShortestTrack() {
        return tracks[minIndex(0)].getTitle();
    }

    /** Sorts this list by increasing duration order: Tracks with shorter
     *  durations will appear first. The sort is done in-place. In other words,
     *  rather than returning a new, sorted playlist, the method sorts
     *  the list on which it was called (this list). */
    public void sortedInPlace() {
        // Uses the selection sort algorithm,  
        // calling the minIndex method in each iteration.
        //// replace this statement with your code
        for (int i = 0; i < this.size -1; i++) 
        {
            Track temp = new Track(null, null, i);
            int min = i;

            for (int k = i+1; k < this.size; k ++) 
            {   
                if (this.tracks[k].getDuration() < this.tracks[min].getDuration()) 
                {
                   min = k;
                   temp = tracks[i];
                }
            this.tracks[i] = this.tracks[k];
            this.tracks[k] = temp;
            }
        }
    }
}
