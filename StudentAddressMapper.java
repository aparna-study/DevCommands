import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapred.MapOutputCollector.Context;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;
import java.io.InterruptedIOException;


public class StudentAddressMapper extends Mapper<LongWritable, Text, StudentIDKey, JoinGenericWritable>{
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedIOException, InterruptedException{
		String[] recordFields= value.toString().split("\\t");
		int stud_id = Integer.parseInt(recordFields[0]);
		String email=recordFields[3];
		long contact= Long.parseLong(recordFields[4]);
		
		StudentIDKey studIdKey=new StudentIDKey(stud_id, StudentIDKey.ADDRESS_RECORD);
		StudentAddressDetail studAddress =new StudentAddressDetail(contact,email);
		 
		JoinGenericWritable genericRecord = new JoinGenericWritable(studAddress);
		context.write(studIdKey, genericRecord);
	      
	}
}