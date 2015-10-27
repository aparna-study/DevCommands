import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Reducer;


public class JoinReducer extends Reducer<StudentIDKey, JoinGenericWritable, NullWritable, Text>{

	public void reduce(StudentIDKey key, Iterable<JoinGenericWritable> values, Context context) throws IOException, InterruptedException{
		StringBuilder output = new StringBuilder();
       float gpa=0.0f;
       
       for(JoinGenericWritable v:values){
    	   Writable record=v.get();
    	   if(key.recordType.equals(StudentIDKey.ACADEMIC_RECORD)){
    		   StudentAcademicDetails sRecord= (StudentAcademicDetails) record;
    		   output.append(Integer.parseInt(key.stud_id.toString())).append(", ");
    		   output.append(sRecord.gpa.toString()).append(", ");
    		   output.append(sRecord.status.toString()).append(",");
    		   
    	   }
    	   else{
    		   StudentAddressDetail saRecord = (StudentAddressDetail) record;
    		   output.append(saRecord.email.toString()).append(", ");
    		   output.append(saRecord.contactNumber.toString()).append(", ");
    	   }
       }
       
       if(gpa > 3){
    	   context.write(NullWritable.get(), new Text(output.toString()));
       }
	}
}
