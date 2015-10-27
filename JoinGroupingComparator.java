import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public static class JoinGroupingComparator extends WritableComparator {
 
	public JoinGroupingComparator(){
		super(StudentIDKey.class, true);
	}
	
	public int compare(WritableComparable a, WritableComparable b){
		StudentIDKey first= (StudentIDKey )a;
		StudentIDKey second = (StudentIDKey) b;
			
		return first.stud_id.compareTo(second.stud_id);
	}
	

}
