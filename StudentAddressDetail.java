import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


public class StudentAddressDetail implements Writable {
	LongWritable contactNumber= new LongWritable();
	Text email=new Text();
	
	
	public StudentAddressDetail(){}
	
	public StudentAddressDetail(long contactNumber,String email){
		this.contactNumber.set(contactNumber);
		this.email.set(email);
		
	}
	
	public void write(DataOutput out) throws IOException{
		this.email.write(out);
		this.contactNumber.write(out);
	
	}
	
	public void readFields(DataInput in) throws IOException{
		this.email.readFields(in);
		this.contactNumber.readFields(in);
		
	}
}
