import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.Text;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class StudentAcademicDetails implements Writable {
	Text major=new Text();
	Text status=new Text();
	FloatWritable gpa =new FloatWritable();
	
	public StudentAcademicDetails(){}
	public StudentAcademicDetails(String major, String status, float gpa){
		this.major.set(major);
		this.status.set(status);
		this.gpa.set(gpa);
	}
	
	public void write(DataOutput out) throws IOException{
		this.major.write(out);
		this.status.write(out);
		this.gpa.write(out);
	}
	
	public void readFields(DataInput in) throws IOException{
		this.major.readFields(in);
		this.status.readFields(in);
		this.gpa.readFields(in);
	}
}
