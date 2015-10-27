import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.IntWritable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class StudentIDKey implements Writable,WritableComparable<StudentIDKey>{
 
	public IntWritable stud_id=new IntWritable();
	public IntWritable recordType=new IntWritable();
	public static final IntWritable ADDRESS_RECORD = new IntWritable(0);
	public static final IntWritable ACADEMIC_RECORD =new IntWritable(1);
	
	
	
	public StudentIDKey(){
		
	}
	public StudentIDKey(int stud_id, IntWritable recordType){
		this.stud_id.set(stud_id);
		this.recordType=recordType;
	}
	public void write(DataOutput out) throws IOException{
		this.stud_id.write(out);
		this.recordType.write(out);
	}
	
	public void readFields(DataInput in) throws IOException{
		this.stud_id.readFields(in);
		this.recordType.readFields(in);
	}
	public int compareTo(StudentIDKey otherkey){
		int comparableValue=this.stud_id.compareTo(otherkey.stud_id);
		System.out.println(this.stud_id+ "Comapre method" + otherkey.stud_id );
		if(comparableValue==0){
			comparableValue=this.recordType.compareTo(otherkey.recordType);
		}
		System.out.println("Compare metho returns: "+comparableValue);
		return comparableValue;
	}
	
	public boolean equals (StudentIDKey otherkey){
		return this.stud_id.equals(otherkey.stud_id) && this.recordType.equals(otherkey.recordType);
	}
	
	public int hashCode(){
		return this.stud_id.hashCode();
	}
	
	
}
