import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.io.WritableComparable;

public class JoinSortingComaparator extends WritableComparator {

	public JoinSortingComaparator(){
		super(StudentIDKey.class,true);
	}
	
	public int compare(WritableComparable a, WritableComparable b){
		StudentIDKey first= (StudentIDKey) a;
		StudentIDKey second =(StudentIDKey) b;
		
		return first.compareTo(second);
	}
}
